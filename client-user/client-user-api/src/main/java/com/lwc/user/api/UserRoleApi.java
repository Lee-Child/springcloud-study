package com.lwc.user.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.user.bo.UserRoleBo;
import com.lwc.common.Result;
import com.lwc.user.fallback.UserRoleFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "eip-user-service", path = "/api/v1/userRole", fallbackFactory = UserRoleFallbackFactory.class)
public interface UserRoleApi {

    @GetMapping(value = "/query/{id}")
    Result<UserRoleBo> query(@PathVariable("id") Long id);

    @PostMapping(value = "/remove/{id}")
    Result<Integer> remove(@PathVariable("id") Long id);

    @PostMapping(value = "/purge/{id}")
    Result<Integer> purge(@PathVariable("id") Long id);

    @PostMapping(value = "/queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserRoleBo>> queryByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/removeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> removeByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/purgeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> purgeByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserRoleBo>> query(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<UserRoleBo> create(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserRoleBo>> update(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> remove(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> purge(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> count(@RequestBody UserRoleBo entity);

    @PostMapping(value = "/insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserRoleBo>> insertOrUpdateBatch(@RequestBody List<UserRoleBo> entities);

    @PostMapping(value = "/page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<IPage<UserRoleBo>> page(@RequestBody UserRoleBo entity, @PathVariable("current") int current, @PathVariable("size") int size);
}
