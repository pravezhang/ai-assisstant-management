package com.lowrisk.aiassistant.management.db.mapper;

import com.lowrisk.aiassistant.management.db.pojo.BasePojo;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CRUDMapper<Type extends BasePojo> {
    void insert(Type pojo);

    void update(Type pojo);

    Type selectById(Integer id);

    List<Type> selectByCondition(Map<String,Object> searchMap);

    void delete(Integer id);

    void deleteLogically(Integer id);

    static <Type extends BasePojo> Map<String,Object> transferToSearchMap(Type object){
        Map<String, Object> map = new HashMap<>();
        try {
            // 获取public方法
            Method[] declaredMethods = object.getClass().getMethods();
            for (Method md : declaredMethods) {
                if (md.getName().startsWith("get")) {
                    Object res = md.invoke(object);
                    if (res != null)
                        map.put(changeNameStyle(md.getName().substring(3)), res);
                }
            }
            return map;
        }catch (NullPointerException | ReflectiveOperationException e){
            map.put("1","0");
            return map;
        }
    }
    static String changeNameStyle(String old){
        char[] chs = old.toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        for (char c:chs){
            if(Character.isUpperCase(c))
                stringBuilder.append("_").append(Character.toLowerCase(c));
            else
                stringBuilder.append(c);
        }
        return stringBuilder.substring(1);
    }
}
