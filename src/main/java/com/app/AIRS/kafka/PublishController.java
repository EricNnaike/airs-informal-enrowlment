package com.app.AIRS.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {
    private final PublishService publishService;

    PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    @GetMapping("/kafka/publish/{message}")
    public void publish(@PathVariable("message") String message) {
//        this.publishService.publish(message, "enumeration");
    }
}
