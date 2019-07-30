package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.UserDepartment;
import com.lwc.user.bo.UserDepartmentBo;
import com.lwc.user.api.UserDepartmentApi;
import com.lwc.user.service.UserDepartmentService;
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
    * 用户部门 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/userDepartment", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class UserDepartmentController implements UserDepartmentApi{

    @Autowired
    UserDepartmentService logic;

    @Override
    @ApiOperation(value = "查询用户部门", notes = "查询用户部门")
    @ApiImplicitParam(name = "id", value = "用户部门主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<UserDepartmentBo> query(@PathVariable("id") Long id) {
        Result<UserDepartmentBo> result = null;
        try {
            UserDepartment model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(UserDepartmentBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除用户部门", notes = "逻辑删除用户部门")
    @ApiImplicitParam(name = "id", value = "用户部门主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除用户部门", notes = "物理删除用户部门")
    @ApiImplicitParam(name = "id", value = "用户部门主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询用户部门", notes = "批量查询用户部门")
    @ApiImplicitParam(name = "ids", value = "用户部门", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserDepartmentBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<UserDepartmentBo>> result = null;
        try {
            List<UserDepartment> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(UserDepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除用户部门", notes = "批量逻辑删除用户部门")
    @ApiImplicitParam(name = "ids", value = "用户部门", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除用户部门", notes = "批量物理删除用户部门")
    @ApiImplicitParam(name = "ids", value = "用户部门", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询用户部门", notes = "查询用户部门:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserDepartmentBo>> query(@RequestBody UserDepartmentBo entity) {
        Result<List<UserDepartmentBo>> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            List<UserDepartment> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserDepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建用户部门", notes = "新建用户部门:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<UserDepartmentBo> create(@RequestBody UserDepartmentBo entity) {
        Result<UserDepartmentBo> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            UserDepartment model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(UserDepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新用户部门", notes = "更新用户部门:")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserDepartmentBo>> update(@RequestBody UserDepartmentBo entity) {
        Result<List<UserDepartmentBo>> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            List<UserDepartment> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserDepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除用户部门", notes = "逻辑删除用户部门:")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody UserDepartmentBo entity) {
        Result<Integer> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除用户部门", notes = "物理删除用户部门:")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody UserDepartmentBo entity) {
        Result<Integer> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询用户部门数量", notes = "查询用户部门数量:")
    @ApiImplicitParam(name = "entity", value = "用户部门", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody UserDepartmentBo entity) {
        Result<Integer> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入用户部门", notes = "批量导入用户部门:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "用户部门", required = true, allowMultiple = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserDepartmentBo>> insertOrUpdateBatch(@RequestBody List<UserDepartmentBo> entities) {
        Result<List<UserDepartmentBo>> result = null;
        try {
            List<UserDepartment> form = Assembler.multiAssemble(UserDepartment.class, entities);
            List<UserDepartment> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserDepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询用户部门", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "UserDepartmentBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<UserDepartmentBo>> page(@RequestBody UserDepartmentBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<UserDepartmentBo>> result = null;
        try {
            UserDepartment form = Assembler.assemble(UserDepartment.class, entity);
            IPage<UserDepartment> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(UserDepartmentBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
