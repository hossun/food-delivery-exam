package fooddeliveryexam.domain;

import fooddeliveryexam.DeliveryApplication;
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
    public void onPostPersist() {}

    public static DekeveryRepository repository() {
        DekeveryRepository dekeveryRepository = DeliveryApplication.applicationContext.getBean(
            DekeveryRepository.class
        );
        return dekeveryRepository;
    }

    public void pick() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public void deliveryConfirm() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static void addToDeliveryList(Cooked cooked) {
        Dekevery dekevery = new Dekevery();
        dekevery.setRiderId("aAAA");
        dekevery.setAddress(cooked.getAddress());
        dekevery.setOrderId(cooked.getOrderId());
        repository().save(dekevery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(dekevery);
        deliveryStarted.publishAfterCommit();

    }
}
