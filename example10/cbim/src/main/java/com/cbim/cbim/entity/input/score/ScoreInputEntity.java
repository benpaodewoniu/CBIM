package com.cbim.cbim.entity.input.score;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ScoreInputEntity {
    private List<Score> scoreList;
}

@Data
class Score {
    private int score;
}