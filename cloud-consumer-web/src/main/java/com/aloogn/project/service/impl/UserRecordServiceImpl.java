package com.aloogn.project.service.impl;

import com.aloogn.project.entity.UserRecord;
import com.aloogn.project.dao.UserRecordDao;
import com.aloogn.project.service.UserRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-01-22 19:08:40
 */
@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Resource
    private UserRecordDao userRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rid 主键
     * @return 实例对象
     */
    @Override
    public UserRecord queryById(String rid) {
        return this.userRecordDao.queryById(rid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserRecord> queryAllByLimit(int offset, int limit) {
        return this.userRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord insert(UserRecord userRecord) {
        this.userRecordDao.insert(userRecord);
        return userRecord;
    }

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord update(UserRecord userRecord) {
        this.userRecordDao.update(userRecord);
        return this.queryById(userRecord.getRid());
    }

    /**
     * 通过主键删除数据
     *
     * @param rid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String rid) {
        return this.userRecordDao.deleteById(rid) > 0;
    }
}