package com.aloogn.project.micservice;

import com.aloogn.project.response.Result;
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
@FeignClient(value = "CLOUD-PROVIDER-PROJECT",fallback = ProjectSortFallbackService.class)
public interface ProjectSortService {
    @GetMapping("/provider/projectSort/queryAll")
    public Result queryAll(@RequestParam Map map) throws Exception;

}
