package com.bao.disruptor_gateway.model;

/**
 * Created by bao on 2/24/17.
 */
public class Message {
    private String content;
    private MessageType type;

    public Message() {}

    public Message(MessageType type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
