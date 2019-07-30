package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.Role;
import com.lwc.user.bo.RoleBo;
import com.lwc.user.api.RoleApi;
import com.lwc.user.service.RoleService;
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
    * 角色 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/role", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class RoleController implements RoleApi{

    @Autowired
    RoleService logic;

    @Override
    @ApiOperation(value = "查询角色", notes = "查询角色")
    @ApiImplicitParam(name = "id", value = "角色主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<RoleBo> query(@PathVariable("id") Long id) {
        Result<RoleBo> result = null;
        try {
            Role model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(RoleBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除角色", notes = "逻辑删除角色")
    @ApiImplicitParam(name = "id", value = "角色主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除角色", notes = "物理删除角色")
    @ApiImplicitParam(name = "id", value = "角色主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询角色", notes = "批量查询角色")
    @ApiImplicitParam(name = "ids", value = "角色", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<RoleBo>> result = null;
        try {
            List<Role> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(RoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除角色", notes = "批量逻辑删除角色")
    @ApiImplicitParam(name = "ids", value = "角色", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除角色", notes = "批量物理删除角色")
    @ApiImplicitParam(name = "ids", value = "角色", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询角色", notes = "查询角色:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleBo>> query(@RequestBody RoleBo entity) {
        Result<List<RoleBo>> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            List<Role> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建角色", notes = "新建角色:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<RoleBo> create(@RequestBody RoleBo entity) {
        Result<RoleBo> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            Role model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(RoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新角色", notes = "更新角色:")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleBo>> update(@RequestBody RoleBo entity) {
        Result<List<RoleBo>> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            List<Role> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除角色", notes = "逻辑删除角色:")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody RoleBo entity) {
        Result<Integer> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除角色", notes = "物理删除角色:")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody RoleBo entity) {
        Result<Integer> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询角色数量", notes = "查询角色数量:")
    @ApiImplicitParam(name = "entity", value = "角色", required = true, dataType = "RoleBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody RoleBo entity) {
        Result<Integer> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入角色", notes = "批量导入角色:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "角色", required = true, allowMultiple = true, dataType = "RoleBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<RoleBo>> insertOrUpdateBatch(@RequestBody List<RoleBo> entities) {
        Result<List<RoleBo>> result = null;
        try {
            List<Role> form = Assembler.multiAssemble(Role.class, entities);
            List<Role> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(RoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询角色", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "RoleBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<RoleBo>> page(@RequestBody RoleBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<RoleBo>> result = null;
        try {
            Role form = Assembler.assemble(Role.class, entity);
            IPage<Role> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(RoleBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
