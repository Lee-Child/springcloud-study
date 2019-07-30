package com.lwc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.auth.api.AuthApi;
import com.lwc.auth.bo.AuthBo;
import com.lwc.common.Assembler;
import com.lwc.common.Result;
import com.lwc.user.api.UserApi;
import com.lwc.user.bo.DepartmentBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 部门 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/auth", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class AuthController implements AuthApi {

    @Autowired
    private UserApi userApi;

    @Override
    @PostMapping(value = "/checkIgnore", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> checkIgnore(AuthBo authBo) {
        Result<Boolean> result = null;
        try {
            return userApi.checkIgnore(authBo);
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @PostMapping(value = "/hasPermission", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> hasPermission(AuthBo authBo) {
        Result<Boolean> result = null;
        try {
            return userApi.hasPermission(authBo);
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @PostMapping(value = "/getJwt", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Jwt> getJwt(AuthBo authBo) {
        Result<Jwt> result = null;
        try {
            return userApi.getJwt(authBo);
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
