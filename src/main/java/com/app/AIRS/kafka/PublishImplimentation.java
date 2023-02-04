package com.app.AIRS.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishImplimentation implements PublishService{

    private static final Logger logger = LoggerFactory.getLogger(PublishImplimentation.class);

//    private final KafkaTemplate<String, Object> kafkaTemplate;

//    @Override
//    public void publish(String message, String topic) {
//        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(topic, message);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//
//            @Override
//            public void onSuccess(SendResult<String, Object> result) {
//                logger.info("Sent message=[" + message +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//            @Override
//            public void onFailure(Throwable ex) {
//                logger.info("Unable to send message=["
//                        + message + "] due to : " + ex.getMessage());
//            }
//        });
//    }
}
