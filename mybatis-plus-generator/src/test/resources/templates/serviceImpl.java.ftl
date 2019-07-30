package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${package.Mapper}.${table.mapperName};

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
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service("${table.serviceName}")
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} extMapper;

    @Override
    @Cacheable(value = "eip:${package.ModuleName}:${entity}", key = "#id")
    public ${entity} doQuery(Long id) throws Exception {
        return extMapper.selectById(id);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", key = "#id")
    public int doRemove(Long id) throws Exception {
        return extMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", key = "#id")
    public int doPurge(Long id) throws Exception {
        return extMapper.purge(id);
    }

    @Override
    public List<${entity}> doQueryByIds(List<Long> ids) throws Exception {
        return extMapper.selectBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", allEntries = true)
    public int doRemoveByIds(List<Long> ids) throws Exception {
        return extMapper.deleteBatchIds(ids);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", allEntries = true)
    public int doPurgeByIds(List<Long> ids) throws Exception {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return extMapper.purgeByIds(ids);
    }

    @Override
    public List<${entity}> doQuery(${entity} entity) throws Exception {
        Wrapper<${entity}> wrapper = new QueryWrapper<>(entity);
        return extMapper.selectList(wrapper);
    }

    @Override
    @Cacheable(value = "eip:${package.ModuleName}:${entity}", key = "#entity.uid")
    public ${entity} doCreate(${entity} entity) throws Exception {
        extMapper.insert(entity);
        return entity;
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", key = "#entity.uid")
    public List<${entity}> doUpdate(${entity} entity) throws Exception {
        List<${entity}> models = null;
        UpdateWrapper<${entity}> updateWrapper = new UpdateWrapper<>(entity);
        if (extMapper.update(entity, updateWrapper) > 0) {
            models = doQuery(entity);
        }
        return models;
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", key = "#entity.uid")
    public int doRemove(${entity} entity) throws Exception {
        ${entity} model = null;
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(entity);
        return extMapper.delete(queryWrapper);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", key = "#entity.uid")
    public int doPurge(${entity} entity) throws Exception {
        List<${entity}> models = doQuery(entity);
        List<Long> ids = models.stream().map(${entity} :: getId).collect(Collectors.toList());
        return doRemoveByIds(ids);
    }

    @Override
    public int doCount(${entity} entity) throws Exception {
        Wrapper<${entity}> wrapper = new QueryWrapper<>(entity);
        return (int) extMapper.selectCount(wrapper);
    }

    @Override
    @CacheEvict(value = "eip:${package.ModuleName}:${entity}", allEntries = true)
    public List<${entity}> insertOrUpdateBatch(List<${entity}> entities) throws Exception {
        List<${entity}> model = new ArrayList<>();
        for (${entity} entity : entities) {
            if (entity.getId() == null || entity.getId() <= 0L) {
                model.add(doCreate(entity));
            } else {
                model.addAll(doUpdate(entity));
            }
        }
        return model;
    }

    @Override
    public IPage<${entity}> page(${entity} entity, int current, int size) throws Exception {
        Wrapper<${entity}> wrapper = new QueryWrapper<>(entity);
        IPage<${entity}> page = new Page<>(current, size);
        return extMapper.selectPage(page, wrapper);
    }
}
