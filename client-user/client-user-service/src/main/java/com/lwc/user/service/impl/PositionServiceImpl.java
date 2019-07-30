package com.lwc.user.service.impl;

import com.lwc.user.entity.Position;
import com.lwc.user.service.PositionService;
import com.lwc.user.mapper.PositionMapper;

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
 * 职位 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("PositionService")
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:Position", key = "#id")
    public Position doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<Position> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<Position> doQuery(Position entity) throws Exception {
        Wrapper<Position> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:Position", key = "#entity.uid")
    public Position doCreate(Position entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:Position", key = "#entity.uid")
    public List<Position> doUpdate(Position entity) throws Exception {
        List<Position> models = null;
        UpdateWrapper<Position> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:Position", key = "#entity.uid")
    public int doRemove(Position entity) throws Exception {
        Position model = null;
        QueryWrapper<Position> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", key = "#entity.uid")
    public int doPurge(Position entity) throws Exception {
        List<Position> models = doQuery(entity);
        List<Long> ids = models.stream().map(Position :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(Position entity) throws Exception {
        Wrapper<Position> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Position", allEntries = true)
    public List<Position> insertOrUpdateBatch(List<Position> entities) throws Exception {
        List<Position> model = new ArrayList<>();
        for (Position entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<Position> page(Position entity, int current, int size) throws Exception {
        Wrapper<Position> wrapper = new QueryWrapper<>(entity);
        IPage<Position> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
