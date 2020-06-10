package org.huangpu.gongdi.service;

import java.util.List;
import java.util.Map;

public interface GeneralService {
    List<Map<String, Object>> query(String column, String table, String condition);

    void delete(String table, String ids);

    String insert(String table, Map<String, Object> data);

    void update(String table, String id, Map<String, Object> data);

    List<Map<String, Object>> query(String table, String condition);

}
