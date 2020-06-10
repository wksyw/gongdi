package org.huangpu.gongdi.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GeneralMapper {

    List<Map<String, Object>> query(String column, String table, String condition);

    void deleteByPrimaryKey(String table, String id);

    void insert(String table, Map<String, Object> data);

    void update(String table, String id, Map<String, Object> data);


}
