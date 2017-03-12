package com.bao.disruptor_gateway.config.quartz;

import com.bao.disruptor_gateway.model.Message;
import com.bao.disruptor_gateway.model.MessageType;
import com.bao.disruptor_gateway.service.disruptor.producer.MessageEventProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Bao.Tran on 3/12/2017.
 */
public class QuartzTimerJob implements Job{
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzTimerJob.class);

    @Autowired
    MessageEventProducer messageEventProducer;

    public void execute(JobExecutionContext context) {
        LOGGER.info("JOB {} fired {}", context.getJobDetail().getKey().getName(), context.getFireTime());
        messageEventProducer.onData(new Message(
                MessageType.QUARTZ_SCHEDULE,
                MessageType.QUARTZ_SCHEDULE + " " + context.getFireTime()
        ));
        LOGGER.info("NEXT JOB {} SCHEDULED {}", context.getNextFireTime());
    }
}
