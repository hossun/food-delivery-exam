package fooddeliveryexam.infra;

import fooddeliveryexam.config.kafka.KafkaProcessor;
import fooddeliveryexam.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusViewHandler {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setOrderId(String.valueOf(orderPlaced.getId()));
            orderStatus.setFoodId(orderPlaced.getFoodId());
            orderStatus.setCustomerId(orderPlaced.getCustomerId());
            orderStatus.setStatus("주문시작");
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회

            List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(
                String.valueOf(orderCanceled.getId())
            );
            for (OrderStatus orderStatus : orderStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("주문취소");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_2(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(
                accepted.getOrderId()
            );
            for (OrderStatus orderStatus : orderStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("주문승인");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_3(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 객체 조회

            List<OrderStatus> orderStatusList = orderStatusRepository.findByOrderId(
                rejected.getOrderId()
            );
            for (OrderStatus orderStatus : orderStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("주문거절");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
