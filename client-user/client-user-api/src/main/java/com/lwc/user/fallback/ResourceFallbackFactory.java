package com.lwc.user.fallback;

import com.lwc.user.bo.ResourceBo;
import lombok.extern.slf4j.Slf4j;
import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.user.api.ResourceApi;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
public class ResourceFallbackFactory implements ResourceApi {

    @Override
    public Result<ResourceBo> query(Long id){
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
    public Result<List<ResourceBo>> queryByIds(List<Long> ids){
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
    public Result<List<ResourceBo>> query(ResourceBo entity){
        log.warn("query接口异常，已熔断", entity);
        return Result.FAILED("query接口异常，已熔断");
    }

    @Override
     public Result<ResourceBo> create(ResourceBo entity){
        log.warn("create接口异常，已熔断", entity);
        return Result.FAILED("create接口异常，已熔断");
    }

    @Override
    public Result<List<ResourceBo>> update(ResourceBo entity){
        log.warn("update接口异常，已熔断", entity);
        return Result.FAILED("update接口异常，已熔断");
    }

    @Override
    public Result<Integer> remove(ResourceBo entity){
        log.warn("remove接口异常，已熔断", entity);
        return Result.FAILED("remove接口异常，已熔断");
    }

    @Override
    public Result<Integer> purge(ResourceBo entity){
        log.warn("purge接口异常，已熔断", entity);
        return Result.FAILED("purge接口异常，已熔断");
    }

    @Override
    public Result<Integer> count(ResourceBo entity){
        log.warn("count接口异常，已熔断", entity);
        return Result.FAILED("count接口异常，已熔断");
    }

    @Override
    public Result<List<ResourceBo>> insertOrUpdateBatch(List<ResourceBo> entities){
        log.warn("insertOrUpdateBatch接口异常，已熔断", entities);
        return Result.FAILED("insertOrUpdateBatch接口异常，已熔断");
    }

    @Override
    public Result<IPage<ResourceBo>> page(ResourceBo entity, int current, int size){
        log.warn("page接口异常，已熔断", entity, current, size);
        return Result.FAILED("page接口异常，已熔断");
    }
}
