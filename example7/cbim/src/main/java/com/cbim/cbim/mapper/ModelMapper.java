package com.cbim.cbim.mapper;

import com.cbim.cbim.entity.model.user.AccountModelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ModelMapper {
    List<AccountModelEntity> getAccount();
}
