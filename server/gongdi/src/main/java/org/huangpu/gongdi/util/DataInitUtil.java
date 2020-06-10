package org.huangpu.gongdi.util;

import org.huangpu.gongdi.service.GeneralService;
import org.huangpu.gongdi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class DataInitUtil {

    public static List<String> tableNameList = new ArrayList<>();

    @Autowired
    private GeneralService generalService;

    @PostConstruct
    public void init(){
        initTableNameList();
    }

    private void initTableNameList(){
        String tableNameColumn = "TABLE_NAME";
        List<Map<String, Object>> table =  generalService.query(tableNameColumn,"information_schema.TABLES","TABLE_SCHEMA=(select database())");
        for (Map<String, Object> tableItem : table) {
            tableNameList.add(tableItem.get(tableNameColumn).toString());

        }
    }


}
