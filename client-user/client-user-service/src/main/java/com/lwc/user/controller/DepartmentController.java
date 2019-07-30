package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.Department;
import com.lwc.user.bo.DepartmentBo;
import com.lwc.user.api.DepartmentApi;
import com.lwc.user.service.DepartmentService;
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
    * 部门 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/department", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class DepartmentController implements DepartmentApi{

    @Autowired
    DepartmentService logic;

    @Override
    @ApiOperation(value = "查询部门", notes = "查询部门")
    @ApiImplicitParam(name = "id", value = "部门主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<DepartmentBo> query(@PathVariable("id") Long id) {
        Result<DepartmentBo> result = null;
        try {
            Department model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(DepartmentBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除部门", notes = "逻辑删除部门")
    @ApiImplicitParam(name = "id", value = "部门主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除部门", notes = "物理删除部门")
    @ApiImplicitParam(name = "id", value = "部门主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询部门", notes = "批量查询部门")
    @ApiImplicitParam(name = "ids", value = "部门", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<DepartmentBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<DepartmentBo>> result = null;
        try {
            List<Department> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(DepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除部门", notes = "批量逻辑删除部门")
    @ApiImplicitParam(name = "ids", value = "部门", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除部门", notes = "批量物理删除部门")
    @ApiImplicitParam(name = "ids", value = "部门", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询部门", notes = "查询部门:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<DepartmentBo>> query(@RequestBody DepartmentBo entity) {
        Result<List<DepartmentBo>> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            List<Department> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(DepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建部门", notes = "新建部门:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<DepartmentBo> create(@RequestBody DepartmentBo entity) {
        Result<DepartmentBo> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            Department model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(DepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新部门", notes = "更新部门:")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<DepartmentBo>> update(@RequestBody DepartmentBo entity) {
        Result<List<DepartmentBo>> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            List<Department> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(DepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除部门", notes = "逻辑删除部门:")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody DepartmentBo entity) {
        Result<Integer> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除部门", notes = "物理删除部门:")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody DepartmentBo entity) {
        Result<Integer> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询部门数量", notes = "查询部门数量:")
    @ApiImplicitParam(name = "entity", value = "部门", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody DepartmentBo entity) {
        Result<Integer> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入部门", notes = "批量导入部门:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "部门", required = true, allowMultiple = true, dataType = "DepartmentBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<DepartmentBo>> insertOrUpdateBatch(@RequestBody List<DepartmentBo> entities) {
        Result<List<DepartmentBo>> result = null;
        try {
            List<Department> form = Assembler.multiAssemble(Department.class, entities);
            List<Department> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(DepartmentBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询部门", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "DepartmentBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<DepartmentBo>> page(@RequestBody DepartmentBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<DepartmentBo>> result = null;
        try {
            Department form = Assembler.assemble(Department.class, entity);
            IPage<Department> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(DepartmentBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
