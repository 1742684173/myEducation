package com.aloogn.project.base;

import com.aloogn.project.exception.BaseException;
import com.aloogn.project.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2020/12/26 10:29
 */
public abstract class BaseService<T> {
    private static Logger logger = LoggerFactory.getLogger(BaseService.class);

//    @Autowired
//    protected DaoServiceImpl daoService;
//    @Autowired
//    protected IFileService fileService;
//    @Autowired
//    protected ILogService logService;

    public void process(Object po,Object vo) throws Exception {
        try{
             this.setParam(po,vo);
             this.execute(po,vo);
        }catch (Exception e){
            logger.error("------------{}---------",e.getMessage());
            if(e instanceof BaseException){
                throw new BaseException(((BaseException) e).getCode(),e.getMessage());
            }else{
                e.printStackTrace();
                throw new BaseException(ResultCode.SYSTEM_ERROR);
            }
        }

    }

    protected abstract void setParam(Object po,Object vo) throws Exception;

    protected abstract void execute(Object po,Object vo) throws Exception;

}
