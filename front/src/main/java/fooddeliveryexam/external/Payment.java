package fooddeliveryexam.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long id;
    private String ordierId;
    private Float payment;
}
