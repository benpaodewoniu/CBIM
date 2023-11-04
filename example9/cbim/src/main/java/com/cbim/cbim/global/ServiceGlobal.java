package com.cbim.cbim.global;

import com.cbim.cbim.entity.model.history.HistoryModelEntity;
import com.cbim.cbim.entity.model.user.AccountModelEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServiceGlobal {

    public static List<AccountModelEntity> accountModelGlobalEntityList = new ArrayList<>();
    public static ConcurrentLinkedDeque<HistoryModelEntity> historyModelEntityConcurrentLinkedDeque = new ConcurrentLinkedDeque<>();

}
