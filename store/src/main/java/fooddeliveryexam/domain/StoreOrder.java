package fooddeliveryexam.domain;

import fooddeliveryexam.StoreApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreOrder_table")
@Data
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String foodId;

    private Integer qty;

    private String status;

    private Float price;

    private String customerId;

    private String address;

    @PostPersist
    public void onPostPersist() {}

    public static StoreOrderRepository repository() {
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(
            StoreOrderRepository.class
        );
        return storeOrderRepository;
    }

    public void accept() {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void reject() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public void startCook() {
        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    public void finishCook() {
        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    public static void addToOrderLists(OrderPlaced orderPlaced) {
        /** Example 1:  new item */
        StoreOrder storeOrder = new StoreOrder();
        storeOrder.setOrderId(Long.toString(orderPlaced.getId()));
        storeOrder.setFoodId(orderPlaced.getFoodId());
        storeOrder.setQty(orderPlaced.getQty());    
        storeOrder.setPrice(orderPlaced.getPrice());
        storeOrder.setCustomerId(orderPlaced.getCustomerId());
        storeOrder.setAddress(orderPlaced.getAddress());
        repository().save(storeOrder);


        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

    }

    public static void notifyOrderCancelled(OrderCanceled orderCanceled) {
        
        repository().findById(orderCanceled.getId()).ifPresent(storeOrder->{
            storeOrder.setStatus("주문 취소");  // do something
            repository().save(storeOrder);
         });

    }
}
