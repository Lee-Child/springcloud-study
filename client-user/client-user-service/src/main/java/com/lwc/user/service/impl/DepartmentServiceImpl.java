package com.lwc.user.service.impl;

import com.lwc.user.entity.Department;
import com.lwc.user.service.DepartmentService;
import com.lwc.user.mapper.DepartmentMapper;

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
 * 部门 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper extMapper;

    @Override
    @Cacheable(value = "eip:user:Department", key = "#id")
    public Department doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<Department> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<Department> doQuery(Department entity) throws Exception {
        Wrapper<Department> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:user:Department", key = "#entity.uid")
    public Department doCreate(Department entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:user:Department", key = "#entity.uid")
    public List<Department> doUpdate(Department entity) throws Exception {
        List<Department> models = null;
        UpdateWrapper<Department> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:user:Department", key = "#entity.uid")
    public int doRemove(Department entity) throws Exception {
        Department model = null;
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", key = "#entity.uid")
    public int doPurge(Department entity) throws Exception {
        List<Department> models = doQuery(entity);
        List<Long> ids = models.stream().map(Department :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(Department entity) throws Exception {
        Wrapper<Department> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:user:Department", allEntries = true)
    public List<Department> insertOrUpdateBatch(List<Department> entities) throws Exception {
        List<Department> model = new ArrayList<>();
        for (Department entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<Department> page(Department entity, int current, int size) throws Exception {
        Wrapper<Department> wrapper = new QueryWrapper<>(entity);
        IPage<Department> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
