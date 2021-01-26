package com.aloogn.project.doservice.queryProjectSort;


import com.alibaba.fastjson.JSON;
import com.aloogn.project.base.BaseVo;
import com.aloogn.project.exception.BaseException;
import com.aloogn.project.micservice.ProjectSortService;
import com.aloogn.project.response.Result;
import com.aloogn.project.response.ResultCode;
import com.aloogn.project.base.BaseService;
//import com.aloogn.project.micservice.ProjectSortService;
import com.aloogn.project.utils.ObjectUtil;
import com.aloogn.project.utils.SpringUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2021/1/10 10:34
 */
public class Service extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    Po po = new Po();
    Vo vo = new Vo();

    ProjectSortService projectSortService = SpringUtil.getBean(ProjectSortService.class);

    @Override
    protected void setParam(Object po, Object vo) throws Exception {
        if(null != po) this.po = (Po)po;
        if(null != vo) this.vo = (Vo)vo;
    }

    @Override
    protected void execute(Object po,Object vo) throws Exception {
        Map map = ObjectUtil.object2Map(po);
        Result result = projectSortService.queryAll(map);
        logger.info("查询项目分类projectSortService.queryAll结果：{}",JSON.toJSONString(result));


        if(ResultCode.getByCode(result.getCode()) != ResultCode.SUCCESS){
            throw new BaseException(result.getCode(),result.getMessage());
        }

        BeanUtils.copyProperties(this.vo,result.getData());
    }


}