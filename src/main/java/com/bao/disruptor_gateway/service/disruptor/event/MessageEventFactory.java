package com.bao.disruptor_gateway.service.disruptor.event;

import com.lmax.disruptor.EventFactory;
import org.springframework.stereotype.Component;

/**
 * Created by bao on 2/23/17.
 */
@Component
public class MessageEventFactory implements EventFactory<MessageEvent> {
    @Override
    public MessageEvent newInstance() {
        return new MessageEvent();
    }
}
