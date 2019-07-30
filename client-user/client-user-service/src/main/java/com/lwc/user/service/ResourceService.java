package com.lwc.user.service;

import com.lwc.user.entity.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 资源 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface ResourceService {
    Resource doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<Resource> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<Resource> doQuery(Resource entity) throws Exception;

    Resource doCreate(Resource entity) throws Exception;

    List<Resource> doUpdate(Resource entity) throws Exception;

    int doRemove(Resource entity) throws Exception;

    int doPurge(Resource entity) throws Exception;

    int doCount(Resource entity) throws Exception;

    List<Resource> insertOrUpdateBatch(List<Resource> entities) throws Exception;

    IPage<Resource> page(Resource entity, int current, int size) throws Exception;
}
