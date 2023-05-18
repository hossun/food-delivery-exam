package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import fooddeliveryexam.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String riderId;
    private String storeId;
    private String orderId;
    private String address;

    public DeliveryStarted(Dekevery aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
