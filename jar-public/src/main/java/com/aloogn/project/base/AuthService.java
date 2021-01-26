package com.aloogn.project.base;

import com.aloogn.project.base.Auth;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zouXiaoLong on 2020/12/26 10:29
 */
@Component
public interface AuthService {

    public Auth auth(String account, String password) throws Exception;
}
