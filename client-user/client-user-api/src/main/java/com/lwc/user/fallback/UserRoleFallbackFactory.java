package com.lwc.user.fallback;

import com.lwc.user.bo.UserRoleBo;
import lombok.extern.slf4j.Slf4j;
import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.user.api.UserRoleApi;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
public class UserRoleFallbackFactory implements UserRoleApi {

    @Override
    public Result<UserRoleBo> query(Long id){
        log.warn("query接口异常，已熔断", id);
        return Result.FAILED("query接口异常，已熔断");
    }

    @Override
    public Result<Integer> remove(Long id){
        log.warn("remove接口异常，已熔断", id);
        return Result.FAILED("remove接口异常，已熔断");
    }

    @Override
    public Result<Integer> purge(Long id){
        log.warn("purge接口异常，已熔断", id);
        return Result.FAILED("purge接口异常，已熔断");
    }

    @Override
    public Result<List<UserRoleBo>> queryByIds(List<Long> ids){
        log.warn("queryByIds接口异常，已熔断", ids);
        return Result.FAILED("queryByIds接口异常，已熔断");
    }

    @Override
    public Result<Integer> removeByIds(List<Long> ids){
        log.warn("removeByIds接口异常，已熔断", ids);
        return Result.FAILED("removeByIds接口异常，已熔断");
    }

    @Override
    public Result<Integer> purgeByIds(List<Long> ids){
        log.warn("purgeByIds接口异常，已熔断", ids);
        return Result.FAILED("purgeByIds接口异常，已熔断");
    }

    @Override
    public Result<List<UserRoleBo>> query(UserRoleBo entity){
        log.warn("query接口异常，已熔断", entity);
        return Result.FAILED("query接口异常，已熔断");
    }

    @Override
     public Result<UserRoleBo> create(UserRoleBo entity){
        log.warn("create接口异常，已熔断", entity);
        return Result.FAILED("create接口异常，已熔断");
    }

    @Override
    public Result<List<UserRoleBo>> update(UserRoleBo entity){
        log.warn("update接口异常，已熔断", entity);
        return Result.FAILED("update接口异常，已熔断");
    }

    @Override
    public Result<Integer> remove(UserRoleBo entity){
        log.warn("remove接口异常，已熔断", entity);
        return Result.FAILED("remove接口异常，已熔断");
    }

    @Override
    public Result<Integer> purge(UserRoleBo entity){
        log.warn("purge接口异常，已熔断", entity);
        return Result.FAILED("purge接口异常，已熔断");
    }

    @Override
    public Result<Integer> count(UserRoleBo entity){
        log.warn("count接口异常，已熔断", entity);
        return Result.FAILED("count接口异常，已熔断");
    }

    @Override
    public Result<List<UserRoleBo>> insertOrUpdateBatch(List<UserRoleBo> entities){
        log.warn("insertOrUpdateBatch接口异常，已熔断", entities);
        return Result.FAILED("insertOrUpdateBatch接口异常，已熔断");
    }

    @Override
    public Result<IPage<UserRoleBo>> page(UserRoleBo entity, int current, int size){
        log.warn("page接口异常，已熔断", entity, current, size);
        return Result.FAILED("page接口异常，已熔断");
    }
}
