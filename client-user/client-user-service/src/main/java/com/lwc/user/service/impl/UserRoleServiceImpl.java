package com.lwc.user.service.impl;

import com.lwc.user.entity.UserRole;
import com.lwc.user.service.UserRoleService;
import com.lwc.user.mapper.UserRoleMapper;

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
 * 用户角色 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:UserRole", key = "#id")
    public UserRole doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<UserRole> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<UserRole> doQuery(UserRole entity) throws Exception {
        Wrapper<UserRole> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:UserRole", key = "#entity.uid")
    public UserRole doCreate(UserRole entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", key = "#entity.uid")
    public List<UserRole> doUpdate(UserRole entity) throws Exception {
        List<UserRole> models = null;
        UpdateWrapper<UserRole> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", key = "#entity.uid")
    public int doRemove(UserRole entity) throws Exception {
        UserRole model = null;
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", key = "#entity.uid")
    public int doPurge(UserRole entity) throws Exception {
        List<UserRole> models = doQuery(entity);
        List<Long> ids = models.stream().map(UserRole :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(UserRole entity) throws Exception {
        Wrapper<UserRole> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:UserRole", allEntries = true)
    public List<UserRole> insertOrUpdateBatch(List<UserRole> entities) throws Exception {
        List<UserRole> model = new ArrayList<>();
        for (UserRole entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<UserRole> page(UserRole entity, int current, int size) throws Exception {
        Wrapper<UserRole> wrapper = new QueryWrapper<>(entity);
        IPage<UserRole> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
