package com.lwc.auth.api;

import com.lwc.auth.bo.AuthBo;
import com.lwc.auth.fallback.AuthApiFallback;
import com.lwc.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.security.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "eip-user-service", path = "/api/v1/department", fallback = AuthApiFallback.class)
public interface AuthApi {

    @PostMapping(value = "/checkIgnore", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Boolean> checkIgnore(@RequestBody AuthBo authBo);

    @PostMapping(value = "/checkPermission/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Boolean> hasPermission(@RequestBody AuthBo authBo);

    @PostMapping(value = "/query/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Jwt> getJwt(@RequestBody AuthBo authBo);
}
