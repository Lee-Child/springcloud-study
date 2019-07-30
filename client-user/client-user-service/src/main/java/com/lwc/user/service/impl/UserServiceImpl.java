package com.lwc.user.service.impl;

import com.lwc.user.entity.User;
import com.lwc.user.service.UserService;
import com.lwc.user.mapper.UserMapper;

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
 * 用户 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:User", key = "#id")
    public User doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:User", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:User", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<User> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:User", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:User", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<User> doQuery(User entity) throws Exception {
        Wrapper<User> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:User", key = "#entity.uid")
    public User doCreate(User entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:User", key = "#entity.uid")
    public List<User> doUpdate(User entity) throws Exception {
        List<User> models = null;
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:User", key = "#entity.uid")
    public int doRemove(User entity) throws Exception {
        User model = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:User", key = "#entity.uid")
    public int doPurge(User entity) throws Exception {
        List<User> models = doQuery(entity);
        List<Long> ids = models.stream().map(User :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(User entity) throws Exception {
        Wrapper<User> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:User", allEntries = true)
    public List<User> insertOrUpdateBatch(List<User> entities) throws Exception {
        List<User> model = new ArrayList<>();
        for (User entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<User> page(User entity, int current, int size) throws Exception {
        Wrapper<User> wrapper = new QueryWrapper<>(entity);
        IPage<User> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
