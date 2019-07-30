package com.lwc.user.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.user.bo.UserDepartmentBo;
import com.lwc.common.Result;
import com.lwc.user.fallback.UserDepartmentFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "eip-user-service", path = "/api/v1/userDepartment", fallbackFactory = UserDepartmentFallbackFactory.class)
public interface UserDepartmentApi {

    @GetMapping(value = "/query/{id}")
    Result<UserDepartmentBo> query(@PathVariable("id") Long id);

    @PostMapping(value = "/remove/{id}")
    Result<Integer> remove(@PathVariable("id") Long id);

    @PostMapping(value = "/purge/{id}")
    Result<Integer> purge(@PathVariable("id") Long id);

    @PostMapping(value = "/queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserDepartmentBo>> queryByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/removeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> removeByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/purgeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> purgeByIds(@RequestBody List<Long> ids);

    @PostMapping(value = "/query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserDepartmentBo>> query(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<UserDepartmentBo> create(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserDepartmentBo>> update(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> remove(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> purge(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Integer> count(@RequestBody UserDepartmentBo entity);

    @PostMapping(value = "/insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<List<UserDepartmentBo>> insertOrUpdateBatch(@RequestBody List<UserDepartmentBo> entities);

    @PostMapping(value = "/page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<IPage<UserDepartmentBo>> page(@RequestBody UserDepartmentBo entity, @PathVariable("current") int current, @PathVariable("size") int size);
}
