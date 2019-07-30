package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.Resource;
import com.lwc.user.bo.ResourceBo;
import com.lwc.user.api.ResourceApi;
import com.lwc.user.service.ResourceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 资源 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/resource", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class ResourceController implements ResourceApi{

    @Autowired
    ResourceService logic;

    @Override
    @ApiOperation(value = "查询资源", notes = "查询资源")
    @ApiImplicitParam(name = "id", value = "资源主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<ResourceBo> query(@PathVariable("id") Long id) {
        Result<ResourceBo> result = null;
        try {
            Resource model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(ResourceBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除资源", notes = "逻辑删除资源")
    @ApiImplicitParam(name = "id", value = "资源主键", required = true, dataType = "String")
    @PostMapping(value = "remove/{id}")
    public Result<Integer> remove(@PathVariable("id") Long id) {
        Result<Integer> result = null;
        try {
            int model = logic.doRemove(id);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除资源", notes = "物理删除资源")
    @ApiImplicitParam(name = "id", value = "资源主键", required = true, dataType = "String")
    @PostMapping(value = "purge/{id}")
    public Result<Integer> purge(@PathVariable("id") Long id) {
        Result<Integer> result = null;
        try {
            int count = logic.doPurge(id);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量查询资源", notes = "批量查询资源")
    @ApiImplicitParam(name = "ids", value = "资源", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<ResourceBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<ResourceBo>> result = null;
        try {
            List<Resource> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(ResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除资源", notes = "批量逻辑删除资源")
    @ApiImplicitParam(name = "ids", value = "资源", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "removeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> removeByIds(@RequestBody List<Long> ids) {
        Result<Integer> result = null;
        try {
            int model = logic.doRemoveByIds(ids);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量物理删除资源", notes = "批量物理删除资源")
    @ApiImplicitParam(name = "ids", value = "资源", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "purgeByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purgeByIds(@RequestBody List<Long> ids) {
        Result<Integer> result = null;
        try {
            int count = logic.doPurgeByIds(ids);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "查询资源", notes = "查询资源:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<ResourceBo>> query(@RequestBody ResourceBo entity) {
        Result<List<ResourceBo>> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            List<Resource> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(ResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建资源", notes = "新建资源:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<ResourceBo> create(@RequestBody ResourceBo entity) {
        Result<ResourceBo> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            Resource model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(ResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新资源", notes = "更新资源:")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<ResourceBo>> update(@RequestBody ResourceBo entity) {
        Result<List<ResourceBo>> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            List<Resource> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(ResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除资源", notes = "逻辑删除资源:")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody ResourceBo entity) {
        Result<Integer> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除资源", notes = "物理删除资源:")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody ResourceBo entity) {
        Result<Integer> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询资源数量", notes = "查询资源数量:")
    @ApiImplicitParam(name = "entity", value = "资源", required = true, dataType = "ResourceBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody ResourceBo entity) {
        Result<Integer> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入资源", notes = "批量导入资源:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "资源", required = true, allowMultiple = true, dataType = "ResourceBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<ResourceBo>> insertOrUpdateBatch(@RequestBody List<ResourceBo> entities) {
        Result<List<ResourceBo>> result = null;
        try {
            List<Resource> form = Assembler.multiAssemble(Resource.class, entities);
            List<Resource> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(ResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询资源", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "ResourceBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<ResourceBo>> page(@RequestBody ResourceBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<ResourceBo>> result = null;
        try {
            Resource form = Assembler.assemble(Resource.class, entity);
            IPage<Resource> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(ResourceBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
