package com.aloogn.project.controller;

import com.aloogn.project.base.BaseVo;
import com.aloogn.project.entity.ProjectSort;
import com.aloogn.project.response.Result;
import com.aloogn.project.service.ProjectSortService;
import com.aloogn.project.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (ProjectSort)表控制层
 *
 * @author makejava
 * @since 2021-01-21 15:10:24
 */
@RestController
public class ProjectSortController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectSortController.class);
    /**
     * 服务对象
     */
    @Resource
    private ProjectSortService projectSortService;


    @GetMapping("/provider/projectSort/queryAll")
    public Result queryAll(@RequestParam Map map) throws Exception {
        logger.info("queryAll入参：[{}]",map);
        ProjectSort projectSort = (ProjectSort)ObjectUtil.map2Object(map,ProjectSort.class);
        List result = this.projectSortService.queryAll(projectSort);
        logger.info("queryAll结果：[{}]",ObjectUtil.list2Str(result));
        return Result.success(BaseVo.getPageInfo(result.size(),1,1,result));
    }



}