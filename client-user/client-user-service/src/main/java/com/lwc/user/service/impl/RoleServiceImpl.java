package com.lwc.user.service.impl;

import com.lwc.user.entity.Role;
import com.lwc.user.service.RoleService;
import com.lwc.user.mapper.RoleMapper;

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
 * 角色 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:Role", key = "#id")
    public Role doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<Role> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<Role> doQuery(Role entity) throws Exception {
        Wrapper<Role> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:Role", key = "#entity.uid")
    public Role doCreate(Role entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:Role", key = "#entity.uid")
    public List<Role> doUpdate(Role entity) throws Exception {
        List<Role> models = null;
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:Role", key = "#entity.uid")
    public int doRemove(Role entity) throws Exception {
        Role model = null;
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", key = "#entity.uid")
    public int doPurge(Role entity) throws Exception {
        List<Role> models = doQuery(entity);
        List<Long> ids = models.stream().map(Role :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(Role entity) throws Exception {
        Wrapper<Role> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Role", allEntries = true)
    public List<Role> insertOrUpdateBatch(List<Role> entities) throws Exception {
        List<Role> model = new ArrayList<>();
        for (Role entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<Role> page(Role entity, int current, int size) throws Exception {
        Wrapper<Role> wrapper = new QueryWrapper<>(entity);
        IPage<Role> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
