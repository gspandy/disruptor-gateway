package com.bao.disruptor_gateway.service.disruptor.producer;

import com.bao.disruptor_gateway.service.disruptor.DisruptorService;
import com.bao.disruptor_gateway.service.disruptor.event.MessageEvent;
import com.lmax.disruptor.RingBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

/**
 * Created by bao on 2/23/17.
 */
@Service
public class MessageEventProducer {

    @Autowired
    private DisruptorService disruptorService;

    // data will come from file?
    public void onData(ByteBuffer buffer) {
        RingBuffer<MessageEvent> ringBuffer = disruptorService.getRingBuffer();

        long sequence = ringBuffer.next();
        try {
            // get entry of sequence and fill with data
            MessageEvent event = ringBuffer.get(sequence);
            event.setMessage(buffer.toString());
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
