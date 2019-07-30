package com.lwc.user.service;

import com.lwc.user.entity.UserDepartment;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户部门 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface UserDepartmentService {
    UserDepartment doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<UserDepartment> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<UserDepartment> doQuery(UserDepartment entity) throws Exception;

    UserDepartment doCreate(UserDepartment entity) throws Exception;

    List<UserDepartment> doUpdate(UserDepartment entity) throws Exception;

    int doRemove(UserDepartment entity) throws Exception;

    int doPurge(UserDepartment entity) throws Exception;

    int doCount(UserDepartment entity) throws Exception;

    List<UserDepartment> insertOrUpdateBatch(List<UserDepartment> entities) throws Exception;

    IPage<UserDepartment> page(UserDepartment entity, int current, int size) throws Exception;
}
