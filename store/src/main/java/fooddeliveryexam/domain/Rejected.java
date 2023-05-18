package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import fooddeliveryexam.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private Integer qty;
    private String status;
    private Float price;
    private String customerId;
    private String address;

    public Rejected(StoreOrder aggregate) {
        super(aggregate);
    }

    public Rejected() {
        super();
    }
}
