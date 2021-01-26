package com.aloogn.project.micservice;

import com.aloogn.project.exception.BaseException;
import com.aloogn.project.response.Result;
import com.aloogn.project.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2021/1/19 22:53
 */
@Component
public class ProjectSortFallbackService implements ProjectSortService{
    private static final Logger logger = LoggerFactory.getLogger(ProjectSortFallbackService.class);

    @GetMapping("/provider/projectSort/queryAll")
    public Result queryAll(@RequestParam Map map) throws Exception{
        logger.error("--------调用微服务【ProjectSortService.queryAll】错误------");

        return Result.fail(ResultCode.MIC_SERVICE_ERROR);
    }

}
