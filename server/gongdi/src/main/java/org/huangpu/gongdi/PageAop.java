package org.huangpu.gongdi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.huangpu.gongdi.pojo.PageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PageAop {
    @Around(value = "@annotation(org.huangpu.gongdi.annotation.Page)")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (args.length < 2) {
            //规定原方法的参数最后两个是当前页和每页条数
            throw new Exception("参数不够分页");
        }
        if (args[args.length - 2] == null || args[args.length - 1] == null) {
            return point.proceed();
        }
        PageHelper.startPage((Integer) args[args.length - 2], (Integer) args[args.length - 1]);
        List list = (List) point.proceed();
        PageInfo pageInfo = new PageInfo(list);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setData(list);
        pageResponse.setTotal(pageInfo.getTotal());
        return pageResponse;
    }
}