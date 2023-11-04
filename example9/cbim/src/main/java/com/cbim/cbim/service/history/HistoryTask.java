package com.cbim.cbim.service.history;

import com.cbim.cbim.entity.model.history.HistoryModelEntity;
import com.cbim.cbim.flow.DataInit;
import com.cbim.cbim.mapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cbim.cbim.global.ServiceGlobal.historyModelEntityConcurrentLinkedDeque;

@Service
public class HistoryTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void run() {

        logger.info("数据库定时任务执行");

        List<HistoryModelEntity> historyModelEntityList = new ArrayList<>();

        while (!historyModelEntityConcurrentLinkedDeque.isEmpty()) {
            historyModelEntityList.add(historyModelEntityConcurrentLinkedDeque.poll());
        }

        try {

            modelMapper.batchInsertHistory(historyModelEntityList);
        } catch (Exception e) {
            logger.info(e.toString());
        }

    }
}
