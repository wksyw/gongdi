package org.huangpu.gongdi.util;



import org.huangpu.gongdi.pojo.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {
    public static void send(HttpServletResponse response,String msg){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            Response errorResponse = Response.getFailResult();
            errorResponse.setMsg(msg);
            String data = JsonUtil.toJson(errorResponse);
            PrintWriter out = response.getWriter();
            out.print(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
