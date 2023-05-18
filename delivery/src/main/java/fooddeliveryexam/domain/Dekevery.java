package fooddeliveryexam.domain;

import fooddeliveryexam.DeliveryApplication;
import fooddeliveryexam.domain.DeliveryCompleted;
import fooddeliveryexam.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dekevery_table")
@Data
public class Dekevery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String riderId;

    private String storeId;

    private String orderId;

    private String address;

    @PostPersist
    public void onPostPersist() {
       // DeliveryStarted deliveryStarted = new DeliveryStarted(this);
       // deliveryStarted.publishAfterCommit();

      //  DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
      //  deliveryCompleted.publishAfterCommit();
    }

    public static DekeveryRepository repository() {
        DekeveryRepository dekeveryRepository = DeliveryApplication.applicationContext.getBean(
            DekeveryRepository.class
        );
        return dekeveryRepository;
    }

    public void pick() {}

    public static void addToDeliveryList(Cooked cooked) {
        /** Example 1:  new item */ 
        Dekevery dekevery = new Dekevery();
        dekevery.setRiderId("aAAA");
        dekevery.setAddress(cooked.getAddress());
        dekevery.setOrderId(cooked.getOrderId());
        repository().save(dekevery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(dekevery);
        deliveryStarted.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(dekevery->{
            
            dekevery // do something
            repository().save(dekevery);


         });
        */

    }
}
