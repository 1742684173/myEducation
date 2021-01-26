package com.aloogn.project.dao;

import com.aloogn.project.entity.RoleRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (RoleRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-22 19:09:06
 */
@Mapper
public interface RoleRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rid 主键
     * @return 实例对象
     */
    RoleRecord queryById(String rid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleRecord 实例对象
     * @return 对象列表
     */
    List<RoleRecord> queryAll(RoleRecord roleRecord);

    /**
     * 新增数据
     *
     * @param roleRecord 实例对象
     * @return 影响行数
     */
    int insert(RoleRecord roleRecord);

    /**
     * 修改数据
     *
     * @param roleRecord 实例对象
     * @return 影响行数
     */
    int update(RoleRecord roleRecord);

    /**
     * 通过主键删除数据
     *
     * @param rid 主键
     * @return 影响行数
     */
    int deleteById(String rid);

}