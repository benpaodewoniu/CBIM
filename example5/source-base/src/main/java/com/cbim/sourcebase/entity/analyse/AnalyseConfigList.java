package com.cbim.sourcebase.entity.analyse;

import lombok.Data;

import java.util.List;

@Data
public class AnalyseConfigList {
    private String type;
    private List<AnalyseConfig> content;
}
