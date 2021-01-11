package com.aloogn.door.app.service.addUser;

import com.aloogn.api.service.IBaseService;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2021/1/10 10:34
 */
@org.springframework.stereotype.Service
public class Service extends IBaseService {

    @Override
    protected void execute(Map<String, Object> map) throws Exception {
        Input input = (Input)map.get("input");
        Output output = (Output)map.get("output");
    }


}