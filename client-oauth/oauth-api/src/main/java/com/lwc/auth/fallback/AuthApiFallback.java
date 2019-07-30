package com.lwc.auth.fallback;

import com.lwc.auth.api.AuthApi;
import com.lwc.auth.bo.AuthBo;
import com.lwc.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthApiFallback implements AuthApi {

    @Override
    public Result<Boolean> checkIgnore(AuthBo authBo) {
        log.warn("checkIgnore接口异常，已熔断", authBo);
        return Result.FAILED("checkIgnore接口异常，已熔断");
    }

    @Override
    public Result<Boolean> hasPermission(AuthBo authBo) {
        log.warn("hasPermission接口异常，已熔断", authBo);
        return Result.FAILED("hasPermission接口异常，已熔断");
    }

    @Override
    public Result<Jwt> getJwt(AuthBo authBo) {
        log.warn("getJwt接口异常，已熔断", authBo);
        return Result.FAILED("getJwt接口异常，已熔断");
    }
}
