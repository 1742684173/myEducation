package com.aloogn.project.dao;

import com.aloogn.project.entity.ProjectSort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProjectSort)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-21 15:10:22
 */
@Mapper
public interface ProjectSortDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectSort queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectSort> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectSort 实例对象
     * @return 对象列表
     */
    List<ProjectSort> queryAll(ProjectSort projectSort);

    /**
     * 新增数据
     *
     * @param projectSort 实例对象
     * @return 影响行数
     */
    int insert(ProjectSort projectSort);

    /**
     * 修改数据
     *
     * @param projectSort 实例对象
     * @return 影响行数
     */
    int update(ProjectSort projectSort);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}