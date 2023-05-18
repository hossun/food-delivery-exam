package fooddeliveryexam.domain;

import fooddeliveryexam.SummaryApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AlertLog_table")
@Data
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String message;

    public static AlertLogRepository repository() {
        AlertLogRepository alertLogRepository = SummaryApplication.applicationContext.getBean(
            AlertLogRepository.class
        );
        return alertLogRepository;
    }

    public static void alertToUser(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }

    public static void alertToUser(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }

    public static void alertToUser(Accepted accepted) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }

    public static void alertToUser(Rejected rejected) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }

    public static void alertToUser(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }

    public static void alertToUser(DeliveryCompleted deliveryCompleted) {
        /** Example 1:  new item 
        AlertLog alertLog = new AlertLog();
        repository().save(alertLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(alertLog->{
            
            alertLog // do something
            repository().save(alertLog);


         });
        */

    }
}
