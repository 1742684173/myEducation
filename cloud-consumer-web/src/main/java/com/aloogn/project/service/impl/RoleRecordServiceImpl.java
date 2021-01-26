package com.aloogn.project.service.impl;

import com.aloogn.project.entity.RoleRecord;
import com.aloogn.project.dao.RoleRecordDao;
import com.aloogn.project.service.RoleRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-01-22 19:09:06
 */
@Service("roleRecordService")
public class RoleRecordServiceImpl implements RoleRecordService {
    @Resource
    private RoleRecordDao roleRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rid 主键
     * @return 实例对象
     */
    @Override
    public RoleRecord queryById(String rid) {
        return this.roleRecordDao.queryById(rid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleRecord> queryAllByLimit(int offset, int limit) {
        return this.roleRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roleRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RoleRecord insert(RoleRecord roleRecord) {
        this.roleRecordDao.insert(roleRecord);
        return roleRecord;
    }

    /**
     * 修改数据
     *
     * @param roleRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RoleRecord update(RoleRecord roleRecord) {
        this.roleRecordDao.update(roleRecord);
        return this.queryById(roleRecord.getRid());
    }

    /**
     * 通过主键删除数据
     *
     * @param rid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String rid) {
        return this.roleRecordDao.deleteById(rid) > 0;
    }
}