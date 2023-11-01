package com.cbim.cbim.service.score;

import com.alibaba.fastjson.JSON;
import com.cbim.cbim.entity.input.score.ScoreInputEntity;
import com.cbim.flowbase.interfaces.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScoreService implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

    @Override
    public void update(String data) throws Exception {
        ScoreInputEntity scoreInputEntity = JSON.parseObject(data, ScoreInputEntity.class);
        logger.info(scoreInputEntity.toString());
    }
}
