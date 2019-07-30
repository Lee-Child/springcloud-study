package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.UserRole;
import com.lwc.user.bo.UserRoleBo;
import com.lwc.user.api.UserRoleApi;
import com.lwc.user.service.UserRoleService;
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
    * 用户角色 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/userRole", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class UserRoleController implements UserRoleApi{

    @Autowired
    UserRoleService logic;

    @Override
    @ApiOperation(value = "查询用户角色", notes = "查询用户角色")
    @ApiImplicitParam(name = "id", value = "用户角色主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<UserRoleBo> query(@PathVariable("id") Long id) {
        Result<UserRoleBo> result = null;
        try {
            UserRole model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(UserRoleBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除用户角色", notes = "逻辑删除用户角色")
    @ApiImplicitParam(name = "id", value = "用户角色主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除用户角色", notes = "物理删除用户角色")
    @ApiImplicitParam(name = "id", value = "用户角色主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询用户角色", notes = "批量查询用户角色")
    @ApiImplicitParam(name = "ids", value = "用户角色", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserRoleBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<UserRoleBo>> result = null;
        try {
            List<UserRole> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(UserRoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除用户角色", notes = "批量逻辑删除用户角色")
    @ApiImplicitParam(name = "ids", value = "用户角色", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除用户角色", notes = "批量物理删除用户角色")
    @ApiImplicitParam(name = "ids", value = "用户角色", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询用户角色", notes = "查询用户角色:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserRoleBo>> query(@RequestBody UserRoleBo entity) {
        Result<List<UserRoleBo>> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            List<UserRole> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserRoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建用户角色", notes = "新建用户角色:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<UserRoleBo> create(@RequestBody UserRoleBo entity) {
        Result<UserRoleBo> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            UserRole model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(UserRoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新用户角色", notes = "更新用户角色:")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserRoleBo>> update(@RequestBody UserRoleBo entity) {
        Result<List<UserRoleBo>> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            List<UserRole> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserRoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除用户角色", notes = "逻辑删除用户角色:")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody UserRoleBo entity) {
        Result<Integer> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除用户角色", notes = "物理删除用户角色:")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody UserRoleBo entity) {
        Result<Integer> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询用户角色数量", notes = "查询用户角色数量:")
    @ApiImplicitParam(name = "entity", value = "用户角色", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody UserRoleBo entity) {
        Result<Integer> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入用户角色", notes = "批量导入用户角色:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "用户角色", required = true, allowMultiple = true, dataType = "UserRoleBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserRoleBo>> insertOrUpdateBatch(@RequestBody List<UserRoleBo> entities) {
        Result<List<UserRoleBo>> result = null;
        try {
            List<UserRole> form = Assembler.multiAssemble(UserRole.class, entities);
            List<UserRole> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserRoleBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询用户角色", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "UserRoleBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<UserRoleBo>> page(@RequestBody UserRoleBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<UserRoleBo>> result = null;
        try {
            UserRole form = Assembler.assemble(UserRole.class, entity);
            IPage<UserRole> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(UserRoleBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
