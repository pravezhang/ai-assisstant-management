package com.lowrisk.aiassistant.management.service;

import com.lowrisk.aiassistant.management.db.mapper.CRUDMapper;
import com.lowrisk.aiassistant.management.db.pojo.BasePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<Type extends BasePojo> {
    @Autowired
    private CRUDMapper<Type> mapper;

    public List<Type> list(Type pojo){
        return mapper.selectByCondition(CRUDMapper.transferToSearchMap(pojo));
    }

    public void insert(Type pojo){
        mapper.insert(pojo);
    }

    public void update(Type pojo){
        mapper.update(pojo);
    }

    public void delete(Integer id){
        mapper.deleteLogically(id);
    }

    public Type selectById(Integer id){
        return mapper.selectById(id);
    }
}
