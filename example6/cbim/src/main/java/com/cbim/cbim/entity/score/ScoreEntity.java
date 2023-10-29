package com.cbim.cbim.entity.score;

import lombok.Data;

import java.util.List;

@Data
public class ScoreEntity {
    private List<Score> scoreList;
}

@Data
class Score {
    private int score;
}