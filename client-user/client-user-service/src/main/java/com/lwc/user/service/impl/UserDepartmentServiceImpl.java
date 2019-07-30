package com.lwc.user.service.impl;

import com.lwc.user.entity.UserDepartment;
import com.lwc.user.service.UserDepartmentService;
import com.lwc.user.mapper.UserDepartmentMapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 用户部门 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("UserDepartmentService")
public class UserDepartmentServiceImpl implements UserDepartmentService {

    @Autowired
    private UserDepartmentMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:UserDepartment", key = "#id")
    public UserDepartment doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<UserDepartment> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<UserDepartment> doQuery(UserDepartment entity) throws Exception {
        Wrapper<UserDepartment> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:UserDepartment", key = "#entity.uid")
    public UserDepartment doCreate(UserDepartment entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", key = "#entity.uid")
    public List<UserDepartment> doUpdate(UserDepartment entity) throws Exception {
        List<UserDepartment> models = null;
        UpdateWrapper<UserDepartment> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", key = "#entity.uid")
    public int doRemove(UserDepartment entity) throws Exception {
        UserDepartment model = null;
        QueryWrapper<UserDepartment> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", key = "#entity.uid")
    public int doPurge(UserDepartment entity) throws Exception {
        List<UserDepartment> models = doQuery(entity);
        List<Long> ids = models.stream().map(UserDepartment :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(UserDepartment entity) throws Exception {
        Wrapper<UserDepartment> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:UserDepartment", allEntries = true)
    public List<UserDepartment> insertOrUpdateBatch(List<UserDepartment> entities) throws Exception {
        List<UserDepartment> model = new ArrayList<>();
        for (UserDepartment entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<UserDepartment> page(UserDepartment entity, int current, int size) throws Exception {
        Wrapper<UserDepartment> wrapper = new QueryWrapper<>(entity);
        IPage<UserDepartment> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
