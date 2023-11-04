package com.cbim.cbim.entity.model.history;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryModelEntity {
    private int id;
    private String name;
    private Date time;
}
