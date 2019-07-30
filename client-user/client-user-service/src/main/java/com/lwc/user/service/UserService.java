package com.lwc.user.service;

import com.lwc.user.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface UserService {
    User doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<User> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<User> doQuery(User entity) throws Exception;

    User doCreate(User entity) throws Exception;

    List<User> doUpdate(User entity) throws Exception;

    int doRemove(User entity) throws Exception;

    int doPurge(User entity) throws Exception;

    int doCount(User entity) throws Exception;

    List<User> insertOrUpdateBatch(List<User> entities) throws Exception;

    IPage<User> page(User entity, int current, int size) throws Exception;
}
