package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import fooddeliveryexam.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private String riderId;
    private String storeId;
    private String orderId;
    private String address;

    public DeliveryCompleted(Dekevery aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
