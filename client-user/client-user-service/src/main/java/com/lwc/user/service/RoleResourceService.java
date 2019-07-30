package com.lwc.user.service;

import com.lwc.user.entity.RoleResource;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface RoleResourceService {
    RoleResource doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<RoleResource> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<RoleResource> doQuery(RoleResource entity) throws Exception;

    RoleResource doCreate(RoleResource entity) throws Exception;

    List<RoleResource> doUpdate(RoleResource entity) throws Exception;

    int doRemove(RoleResource entity) throws Exception;

    int doPurge(RoleResource entity) throws Exception;

    int doCount(RoleResource entity) throws Exception;

    List<RoleResource> insertOrUpdateBatch(List<RoleResource> entities) throws Exception;

    IPage<RoleResource> page(RoleResource entity, int current, int size) throws Exception;
}
