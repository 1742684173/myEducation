package com.aloogn.project.service;

import com.aloogn.project.entity.ProjectSort;
import java.util.List;

/**
 * (ProjectSort)表服务接口
 *
 * @author makejava
 * @since 2021-01-21 15:10:22
 */
public interface ProjectSortService {

    List queryAll(ProjectSort projectSort);
}