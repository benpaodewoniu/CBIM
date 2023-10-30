package com.cbim.cbim.entity.score;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ScoreEntity {
    private List<Score> scoreList;
}

@Data
class Score {
    private int score;
}