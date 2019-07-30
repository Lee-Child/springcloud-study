package com.lwc.user.service.impl;

import com.lwc.user.entity.RoleResource;
import com.lwc.user.service.RoleResourceService;
import com.lwc.user.mapper.RoleResourceMapper;

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
 *  服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("RoleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:RoleResource", key = "#id")
    public RoleResource doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<RoleResource> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<RoleResource> doQuery(RoleResource entity) throws Exception {
        Wrapper<RoleResource> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:RoleResource", key = "#entity.uid")
    public RoleResource doCreate(RoleResource entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", key = "#entity.uid")
    public List<RoleResource> doUpdate(RoleResource entity) throws Exception {
        List<RoleResource> models = null;
        UpdateWrapper<RoleResource> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", key = "#entity.uid")
    public int doRemove(RoleResource entity) throws Exception {
        RoleResource model = null;
        QueryWrapper<RoleResource> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", key = "#entity.uid")
    public int doPurge(RoleResource entity) throws Exception {
        List<RoleResource> models = doQuery(entity);
        List<Long> ids = models.stream().map(RoleResource :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(RoleResource entity) throws Exception {
        Wrapper<RoleResource> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:RoleResource", allEntries = true)
    public List<RoleResource> insertOrUpdateBatch(List<RoleResource> entities) throws Exception {
        List<RoleResource> model = new ArrayList<>();
        for (RoleResource entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<RoleResource> page(RoleResource entity, int current, int size) throws Exception {
        Wrapper<RoleResource> wrapper = new QueryWrapper<>(entity);
        IPage<RoleResource> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
