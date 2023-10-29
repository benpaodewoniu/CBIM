package com.cbim.cbim.service.Score;

import com.cbim.cbim.entity.score.ScoreEntity;
import com.cbim.flowbase.EventService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

@Service
public class ScoreService implements EventService {
    @Override
    public void update(String data) throws Exception {
        ScoreEntity scoreEntity = JSON.parseObject(data,ScoreEntity.class);
        System.out.println(data);
    }
}
