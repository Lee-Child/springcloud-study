package com.lwc.user.service;

import com.lwc.user.entity.Role;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface RoleService {
    Role doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<Role> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<Role> doQuery(Role entity) throws Exception;

    Role doCreate(Role entity) throws Exception;

    List<Role> doUpdate(Role entity) throws Exception;

    int doRemove(Role entity) throws Exception;

    int doPurge(Role entity) throws Exception;

    int doCount(Role entity) throws Exception;

    List<Role> insertOrUpdateBatch(List<Role> entities) throws Exception;

    IPage<Role> page(Role entity, int current, int size) throws Exception;
}
