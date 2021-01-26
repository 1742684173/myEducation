package com.aloogn.project.service;

import com.aloogn.project.entity.RoleRecord;
import java.util.List;

/**
 * (RoleRecord)表服务接口
 *
 * @author makejava
 * @since 2021-01-22 19:09:06
 */
public interface RoleRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param rid 主键
     * @return 实例对象
     */
    RoleRecord queryById(String rid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roleRecord 实例对象
     * @return 实例对象
     */
    RoleRecord insert(RoleRecord roleRecord);

    /**
     * 修改数据
     *
     * @param roleRecord 实例对象
     * @return 实例对象
     */
    RoleRecord update(RoleRecord roleRecord);

    /**
     * 通过主键删除数据
     *
     * @param rid 主键
     * @return 是否成功
     */
    boolean deleteById(String rid);

}