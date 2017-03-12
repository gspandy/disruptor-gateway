package com.bao.disruptor_gateway;

import com.bao.disruptor_gateway.service.disruptor.DisruptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by bao on 2/23/17.
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    DisruptorService disruptorService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        disruptorService.start();
    }
}
