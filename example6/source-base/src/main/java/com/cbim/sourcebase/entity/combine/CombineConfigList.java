package com.cbim.sourcebase.entity.combine;

import lombok.Data;

import java.util.List;

@Data
public class CombineConfigList {
    private String type;
    private List<CombineConfig> content;
}
