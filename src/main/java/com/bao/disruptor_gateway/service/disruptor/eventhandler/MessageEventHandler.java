package com.bao.disruptor_gateway.service.disruptor.eventhandler;

import com.bao.disruptor_gateway.service.disruptor.event.MessageEvent;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by bao on 2/23/17.
 */
@Service
public class MessageEventHandler implements EventHandler<MessageEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onEvent(MessageEvent messageEvent, long sequence, boolean endOfBatch) throws Exception {
        LOGGER.info("on event: " + messageEvent);
    }
}
