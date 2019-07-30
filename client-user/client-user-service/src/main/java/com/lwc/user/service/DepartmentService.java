package com.lwc.user.service;

import com.lwc.user.entity.Department;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface DepartmentService {
    Department doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<Department> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<Department> doQuery(Department entity) throws Exception;

    Department doCreate(Department entity) throws Exception;

    List<Department> doUpdate(Department entity) throws Exception;

    int doRemove(Department entity) throws Exception;

    int doPurge(Department entity) throws Exception;

    int doCount(Department entity) throws Exception;

    List<Department> insertOrUpdateBatch(List<Department> entities) throws Exception;

    IPage<Department> page(Department entity, int current, int size) throws Exception;
}
