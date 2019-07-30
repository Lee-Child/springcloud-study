package com.lwc.user.service;

import com.lwc.user.entity.UserRole;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface UserRoleService {
    UserRole doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<UserRole> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<UserRole> doQuery(UserRole entity) throws Exception;

    UserRole doCreate(UserRole entity) throws Exception;

    List<UserRole> doUpdate(UserRole entity) throws Exception;

    int doRemove(UserRole entity) throws Exception;

    int doPurge(UserRole entity) throws Exception;

    int doCount(UserRole entity) throws Exception;

    List<UserRole> insertOrUpdateBatch(List<UserRole> entities) throws Exception;

    IPage<UserRole> page(UserRole entity, int current, int size) throws Exception;
}
