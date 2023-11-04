package com.cbim.cbim.flow;

import com.cbim.cbim.service.history.HistoryTask;
import com.cbim.flowbase.actuator.AbstractActuator;
import com.cbim.flowbase.entity.ActuatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component("timerInit")
public class TimerInit extends AbstractActuator {

    @Autowired
    private HistoryTask historyTask;

    public void invoke(ActuatorEntity actuatorEntity) throws Exception {
        /*
         * 数据库批量插入定时任务
         * */
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleWithFixedDelay(historyTask, 0, 60, TimeUnit.SECONDS);
    }

    ;
}
