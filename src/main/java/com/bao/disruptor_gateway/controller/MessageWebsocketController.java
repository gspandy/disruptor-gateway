package com.bao.disruptor_gateway.controller;

import com.bao.disruptor_gateway.service.disruptor.event.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by bao on 2/23/17.
 */
@Controller
public class MessageWebsocketController {

    Logger LOGGER = LoggerFactory.getLogger(MessageWebsocketController.class);

    @MessageMapping("/message")
    public void handleMessage(Object message) {
        LOGGER.info("message receive: " + message);
    }
}
