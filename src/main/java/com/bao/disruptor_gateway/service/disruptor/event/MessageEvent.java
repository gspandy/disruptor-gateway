package com.bao.disruptor_gateway.service.disruptor.event;

/**
 * Created by bao on 2/23/17.
 */
public class MessageEvent {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
