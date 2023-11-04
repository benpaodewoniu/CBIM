package com.cbim.cbim.service.score;

import com.alibaba.fastjson.JSON;
import com.cbim.cbim.entity.input.score.Score;
import com.cbim.cbim.entity.input.score.ScoreInputEntity;
import com.cbim.cbim.entity.model.score.ScoreInfoEntity;
import com.cbim.flowbase.interfaces.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cbim.cbim.global.ServiceGlobal.scoreInfoEntityList;

@Service
public class ScoreService implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

    @Override
    public void update(String data) throws Exception {

        clear();
        load(data);

    }

    public void load(String data) throws Exception {
        ScoreInputEntity scoreInputEntity = JSON.parseObject(data, ScoreInputEntity.class);
        logger.info(scoreInputEntity.toString());

        List<Score> scoreList = scoreInputEntity.getScoreList();

        for (int i = 0; i < scoreList.size(); i++) {
            ScoreInfoEntity scoreInfoEntity = new ScoreInfoEntity();
            scoreInfoEntity.setName("小朋友" + i);
            scoreInfoEntity.setMath(scoreList.get(i).getScore());
            scoreInfoEntity.setChinese(scoreList.get(i).getScore());
            scoreInfoEntity.setEnglish(scoreList.get(i).getScore());
            scoreInfoEntityList.add(scoreInfoEntity);
        }
    }

    private void clear() {
        scoreInfoEntityList.clear();
    }
}
