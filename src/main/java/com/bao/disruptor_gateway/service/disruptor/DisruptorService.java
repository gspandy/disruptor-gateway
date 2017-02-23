package com.bao.disruptor_gateway.service.disruptor;

import com.bao.disruptor_gateway.service.disruptor.event.MessageEvent;
import com.bao.disruptor_gateway.service.disruptor.event.MessageEventFactory;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;


import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by bao on 2/23/17.
 */
@Service
public class DisruptorService {

    private static final int BUFFER_SIZE = 1024;

    private Disruptor<MessageEvent> disruptor;

    @Autowired
    public DisruptorService(EventFactory<MessageEvent> factory, EventHandler<MessageEvent> eventHandler) {
        // Executor used to construct new threads for consumers
        Executor executor = Executors.newSingleThreadExecutor();

        disruptor = new Disruptor<MessageEvent>(factory, BUFFER_SIZE, executor);
        disruptor.handleEventsWith(eventHandler);
    }

    public void start() {
        disruptor.start();
    }

    public RingBuffer<MessageEvent> getRingBuffer() {
        return disruptor.getRingBuffer();
    }
}
