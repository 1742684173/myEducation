package com.aloogn.project.service.impl;

import com.aloogn.project.entity.ProjectSort;
import com.aloogn.project.dao.ProjectSortDao;
import com.aloogn.project.service.ProjectSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectSort)表服务实现类
 *
 * @author makejava
 * @since 2021-01-21 15:10:22
 */
@Service("projectSortService")
public class ProjectSortServiceImpl implements ProjectSortService {
    @Resource
    private ProjectSortDao projectSortDao;

    @Override
    public List queryAll(ProjectSort projectSort) {
        return projectSortDao.queryAll(projectSort);
    }
}