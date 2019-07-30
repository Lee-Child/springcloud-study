package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.User;
import com.lwc.user.bo.UserBo;
import com.lwc.user.api.UserApi;
import com.lwc.user.service.UserService;
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
    * 用户 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class UserController implements UserApi{

    @Autowired
    UserService logic;

    @Override
    @ApiOperation(value = "查询用户", notes = "查询用户")
    @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<UserBo> query(@PathVariable("id") Long id) {
        Result<UserBo> result = null;
        try {
            User model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(UserBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除用户", notes = "逻辑删除用户")
    @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除用户", notes = "物理删除用户")
    @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询用户", notes = "批量查询用户")
    @ApiImplicitParam(name = "ids", value = "用户", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<UserBo>> result = null;
        try {
            List<User> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(UserBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除用户", notes = "批量逻辑删除用户")
    @ApiImplicitParam(name = "ids", value = "用户", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除用户", notes = "批量物理删除用户")
    @ApiImplicitParam(name = "ids", value = "用户", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询用户", notes = "查询用户:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserBo>> query(@RequestBody UserBo entity) {
        Result<List<UserBo>> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            List<User> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建用户", notes = "新建用户:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<UserBo> create(@RequestBody UserBo entity) {
        Result<UserBo> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            User model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(UserBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新用户", notes = "更新用户:")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserBo>> update(@RequestBody UserBo entity) {
        Result<List<UserBo>> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            List<User> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除用户", notes = "逻辑删除用户:")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody UserBo entity) {
        Result<Integer> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除用户", notes = "物理删除用户:")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody UserBo entity) {
        Result<Integer> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询用户数量", notes = "查询用户数量:")
    @ApiImplicitParam(name = "entity", value = "用户", required = true, dataType = "UserBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody UserBo entity) {
        Result<Integer> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入用户", notes = "批量导入用户:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "用户", required = true, allowMultiple = true, dataType = "UserBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<UserBo>> insertOrUpdateBatch(@RequestBody List<UserBo> entities) {
        Result<List<UserBo>> result = null;
        try {
            List<User> form = Assembler.multiAssemble(User.class, entities);
            List<User> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(UserBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询用户", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "UserBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<UserBo>> page(@RequestBody UserBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<UserBo>> result = null;
        try {
            User form = Assembler.assemble(User.class, entity);
            IPage<User> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(UserBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
