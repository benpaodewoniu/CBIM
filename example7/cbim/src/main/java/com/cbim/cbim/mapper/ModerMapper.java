package com.cbim.cbim.mapper;

import com.cbim.cbim.entity.Model.user.AccountModelEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModerMapper {
    List<AccountModelEntity> getAccount();
}
