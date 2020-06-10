package org.huangpu.gongdi.service.impl;


import org.huangpu.gongdi.mapper.GeneralMapper;
import org.huangpu.gongdi.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private GeneralMapper generalMapper;

    @Override
    public List<Map<String, Object>> query(String column, String table, String condition) {
        return generalMapper.query(column, table, condition);
    }

    @Override
    public void delete(String table, String ids) {
        for (String id : ids.split(",")) {
            generalMapper.deleteByPrimaryKey(table, id);
        }
    }

    @Override
    public String insert(String table, Map<String, Object> data) {
        generalMapper.insert(table, data);
        Object id = data.get("id");
        if(id!=null){
            return data.get("id").toString();
        }
        return "";
    }

    @Override
    public void update(String table, String id, Map<String, Object> data) {
        generalMapper.update(table, id, data);
    }


    @Override
    public List<Map<String, Object>> query(String table, String condition) {
        return query("*", table, condition);
    }


}
