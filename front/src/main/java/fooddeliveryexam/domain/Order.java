package fooddeliveryexam.domain;

import fooddeliveryexam.FrontApplication;
import fooddeliveryexam.domain.OrderPlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String address;

    private String storeId;

    private String foodId;

    private Integer qty;

    private String status;

    private Float price;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddeliveryexam.external.Payment payment = new fooddeliveryexam.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext
            .getBean(fooddeliveryexam.external.PaymentService.class)
            .pay(payment);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void orderCancel() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }
}
