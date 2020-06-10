package org.huangpu.gongdi.controller;

import org.huangpu.gongdi.annotation.Page;
import org.huangpu.gongdi.pojo.Result;
import org.huangpu.gongdi.service.GeneralService;
import org.huangpu.gongdi.util.CheckUtil;
import org.huangpu.gongdi.util.FileUtil;
import org.huangpu.gongdi.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private GeneralService generalService;


    @Page
    @RequestMapping("query")
    public Object query(@RequestParam(value = "column", required = false,defaultValue = "*") String column,
                        @RequestParam("function") String function,
                        @RequestParam(value = "condition", required = false) String condition,
                        @RequestParam(value = "pageNum", required = false) Integer pageNum,
                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        CheckUtil.checkGeneral(column);
        CheckUtil.checkGeneral(function);
        CheckUtil.checkGeneral(condition);
        //CheckUtil.checkColumn(column);
        //CheckUtil.checkTable(function);
        //CheckUtil.checkCondition(condition);
        if(condition==null){
            condition="1=1";
        }
        return generalService.query(column, function, condition);
    }

    @RequestMapping("delete")
    public void delete(@RequestParam("function") String function, @RequestParam("ids") String ids) {
        CheckUtil.checkTable(function);
        generalService.delete(function, ids);
    }

    @RequestMapping("insert")
    public String insert(@RequestParam("function") String function, @RequestParam("jsonData") String jsonData) {
        Map<String, Object> data = JsonUtil.parseObject(jsonData, Map.class);
        CheckUtil.checkTable(function);
        return generalService.insert(function, data);
    }

    @RequestMapping("update")
    public void update(@RequestParam("function") String function, @RequestParam("id") String id, @RequestParam("jsonData") String jsonData) {
        Map<String, Object> data = JsonUtil.parseObject(jsonData, Map.class);
        CheckUtil.checkTable(function);
        generalService.update(function, id, data);
    }

    /**
     * 文件上传
     * @param file 文件
     * @return 文件路径
     * @throws IOException
     */
    @RequestMapping("upload")
    public Result upload(@RequestParam MultipartFile file) throws IOException {
        Result result = new Result();
        result.setResult(FileUtil.save(file));
        return result;
    }

}