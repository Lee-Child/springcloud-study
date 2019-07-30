package com.lwc.user.service.impl;

import com.lwc.user.entity.Resource;
import com.lwc.user.service.ResourceService;
import com.lwc.user.mapper.ResourceMapper;

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
 * 资源 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:Resource", key = "#id")
    public Resource doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<Resource> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<Resource> doQuery(Resource entity) throws Exception {
        Wrapper<Resource> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:Resource", key = "#entity.uid")
    public Resource doCreate(Resource entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", key = "#entity.uid")
    public List<Resource> doUpdate(Resource entity) throws Exception {
        List<Resource> models = null;
        UpdateWrapper<Resource> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", key = "#entity.uid")
    public int doRemove(Resource entity) throws Exception {
        Resource model = null;
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", key = "#entity.uid")
    public int doPurge(Resource entity) throws Exception {
        List<Resource> models = doQuery(entity);
        List<Long> ids = models.stream().map(Resource :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(Resource entity) throws Exception {
        Wrapper<Resource> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Resource", allEntries = true)
    public List<Resource> insertOrUpdateBatch(List<Resource> entities) throws Exception {
        List<Resource> model = new ArrayList<>();
        for (Resource entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<Resource> page(Resource entity, int current, int size) throws Exception {
        Wrapper<Resource> wrapper = new QueryWrapper<>(entity);
        IPage<Resource> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
