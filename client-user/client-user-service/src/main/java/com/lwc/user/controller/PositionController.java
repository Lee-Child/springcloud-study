package com.lwc.user.controller;

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import com.lwc.user.entity.Position;
import com.lwc.user.bo.PositionBo;
import com.lwc.user.api.PositionApi;
import com.lwc.user.service.PositionService;
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
    * 职位 前端控制器
    * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@RestController
@RequestMapping(value = "/api/v1/position", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class PositionController implements PositionApi{

    @Autowired
    PositionService logic;

    @Override
    @ApiOperation(value = "查询职位", notes = "查询职位")
    @ApiImplicitParam(name = "id", value = "职位主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<PositionBo> query(@PathVariable("id") Long id) {
        Result<PositionBo> result = null;
        try {
            Position model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(PositionBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除职位", notes = "逻辑删除职位")
    @ApiImplicitParam(name = "id", value = "职位主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除职位", notes = "物理删除职位")
    @ApiImplicitParam(name = "id", value = "职位主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询职位", notes = "批量查询职位")
    @ApiImplicitParam(name = "ids", value = "职位", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<PositionBo>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<PositionBo>> result = null;
        try {
            List<Position> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(PositionBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除职位", notes = "批量逻辑删除职位")
    @ApiImplicitParam(name = "ids", value = "职位", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除职位", notes = "批量物理删除职位")
    @ApiImplicitParam(name = "ids", value = "职位", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询职位", notes = "查询职位:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<PositionBo>> query(@RequestBody PositionBo entity) {
        Result<List<PositionBo>> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            List<Position> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(PositionBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建职位", notes = "新建职位:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<PositionBo> create(@RequestBody PositionBo entity) {
        Result<PositionBo> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            Position model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(PositionBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新职位", notes = "更新职位:")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<PositionBo>> update(@RequestBody PositionBo entity) {
        Result<List<PositionBo>> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            List<Position> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(PositionBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除职位", notes = "逻辑删除职位:")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody PositionBo entity) {
        Result<Integer> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除职位", notes = "物理删除职位:")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody PositionBo entity) {
        Result<Integer> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询职位数量", notes = "查询职位数量:")
    @ApiImplicitParam(name = "entity", value = "职位", required = true, dataType = "PositionBo")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody PositionBo entity) {
        Result<Integer> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入职位", notes = "批量导入职位:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "职位", required = true, allowMultiple = true, dataType = "PositionBo")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<PositionBo>> insertOrUpdateBatch(@RequestBody List<PositionBo> entities) {
        Result<List<PositionBo>> result = null;
        try {
            List<Position> form = Assembler.multiAssemble(Position.class, entities);
            List<Position> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(PositionBo.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询职位", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "PositionBo")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<PositionBo>> page(@RequestBody PositionBo entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<PositionBo>> result = null;
        try {
            Position form = Assembler.assemble(Position.class, entity);
            IPage<Position> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(PositionBo.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
