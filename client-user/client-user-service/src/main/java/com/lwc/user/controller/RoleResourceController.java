package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.RoleResource;
import com.lwc.user.bo.RoleResourceBo;
import com.lwc.user.api.RoleResourceApi;
import com.lwc.user.service.RoleResourceService;
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
    *  前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/roleResource", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class RoleResourceController implements RoleResourceApi{

    @Autowired
    RoleResourceService logic;

    @Override
    @ApiOperation(value = "查询", notes = "查询")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<RoleResourceBo> query(@PathVariable("id") Long id) {
        Result<RoleResourceBo> result = null;
        try {
            RoleResource model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(RoleResourceBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询", notes = "批量查询")
    @ApiImplicitParam(name = "ids", value = "", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleResourceBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<RoleResourceBo>> result = null;
        try {
            List<RoleResource> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(RoleResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除", notes = "批量逻辑删除")
    @ApiImplicitParam(name = "ids", value = "", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除", notes = "批量物理删除")
    @ApiImplicitParam(name = "ids", value = "", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询", notes = "查询:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleResourceBo>> query(@RequestBody RoleResourceBo entity) {
        Result<List<RoleResourceBo>> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            List<RoleResource> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建", notes = "新建:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<RoleResourceBo> create(@RequestBody RoleResourceBo entity) {
        Result<RoleResourceBo> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            RoleResource model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(RoleResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新", notes = "更新:")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleResourceBo>> update(@RequestBody RoleResourceBo entity) {
        Result<List<RoleResourceBo>> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            List<RoleResource> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除:")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody RoleResourceBo entity) {
        Result<Integer> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除", notes = "物理删除:")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody RoleResourceBo entity) {
        Result<Integer> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询数量", notes = "查询数量:")
    @ApiImplicitParam(name = "entity", value = "", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody RoleResourceBo entity) {
        Result<Integer> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入", notes = "批量导入:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "", required = true, allowMultiple = true, dataType = "RoleResourceBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleResourceBo>> insertOrUpdateBatch(@RequestBody List<RoleResourceBo> entities) {
        Result<List<RoleResourceBo>> result = null;
        try {
            List<RoleResource> form = Assembler.multiAssemble(RoleResource.class, entities);
            List<RoleResource> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleResourceBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "RoleResourceBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<RoleResourceBo>> page(@RequestBody RoleResourceBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<RoleResourceBo>> result = null;
        try {
            RoleResource form = Assembler.assemble(RoleResource.class, entity);
            IPage<RoleResource> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(RoleResourceBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
