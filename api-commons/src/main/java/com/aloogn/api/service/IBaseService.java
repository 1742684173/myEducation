package com.aloogn.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2020/12/26 10:29
 */
public abstract class IBaseService {
    private static Logger log = LoggerFactory.getLogger(IBaseService.class);

//    @Autowired
//    protected DaoServiceImpl daoService;
//    @Autowired
//    protected IFileService fileService;
//    @Autowired
//    protected ILogService logService;

    public void process(Map<String, Object> mapDataModel) throws Exception {
        try {
            this.execute(mapDataModel);
        } catch (Exception var8) {
            var8.printStackTrace();
            log.error("组件调用错误", var8);
        }finally {

        }
    }

    protected abstract void execute(Map<String, Object> mapDataModel) throws Exception;

}
