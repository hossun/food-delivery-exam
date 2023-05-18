package fooddeliveryexam.domain;

import fooddeliveryexam.domain.*;
import fooddeliveryexam.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String address;
    private String storeId;
    private String foodId;
    private Integer qty;
    private String status;
    private Float price;
}
