package ${package.Controller};

import com.lwc.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwc.common.Assembler;
import ${package.Entity}.${entity};
import ${package.EntityExt}.${table.entityExtName};
import ${package.Feign}.${table.feignName};
import ${package.Service}.${table.serviceName};
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
    * ${table.comment!} 前端控制器
    * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping(value = "/api/v1/${table.entityPath}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class ${table.controllerName} implements ${table.feignName}{

    @Autowired
    ${table.serviceName} logic;

    @Override
    @ApiOperation(value = "查询${table.comment!}", notes = "查询${table.comment!}")
    @ApiImplicitParam(name = "id", value = "${table.comment!}主键", required = true, dataType = "String")
    @GetMapping(value = "query/{id}")
    public Result<${table.entityExtName}> query(@PathVariable("id") Long id) {
        Result<${table.entityExtName}> result = null;
        try {
            ${entity} model = logic.doQuery(id);
            result = Result.SUCCESS(Assembler.assemble(${table.entityExtName}.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "逻辑删除${table.comment!}", notes = "逻辑删除${table.comment!}")
    @ApiImplicitParam(name = "id", value = "${table.comment!}主键", required = true, dataType = "String")
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
    @ApiOperation(value = "物理删除${table.comment!}", notes = "物理删除${table.comment!}")
    @ApiImplicitParam(name = "id", value = "${table.comment!}主键", required = true, dataType = "String")
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
    @ApiOperation(value = "批量查询${table.comment!}", notes = "批量查询${table.comment!}")
    @ApiImplicitParam(name = "ids", value = "${table.comment!}", required = true, allowMultiple = true, dataType = "String")
    @PostMapping(value = "queryByIds", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<${table.entityExtName}>> queryByIds(@RequestBody List<Long> ids) {
        Result<List<${table.entityExtName}>> result = null;
        try {
            List<${entity}> model = new ArrayList<>();
            model.addAll(logic.doQueryByIds(ids));
            result = Result.SUCCESS(Assembler.multiAssemble(${table.entityExtName}.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量逻辑删除${table.comment!}", notes = "批量逻辑删除${table.comment!}")
    @ApiImplicitParam(name = "ids", value = "${table.comment!}", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "批量物理删除${table.comment!}", notes = "批量物理删除${table.comment!}")
    @ApiImplicitParam(name = "ids", value = "${table.comment!}", required = true, allowMultiple = true, dataType = "String")
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
    @ApiOperation(value = "查询${table.comment!}", notes = "查询${table.comment!}:" + "分页项目：length=数量;start=开始页(默认0)")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "query", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<${table.entityExtName}>> query(@RequestBody ${table.entityExtName} entity) {
        Result<List<${table.entityExtName}>> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            List<${entity}> model = logic.doQuery(form);
            result = Result.SUCCESS(Assembler.multiAssemble(${table.entityExtName}.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "新建${table.comment!}", notes = "新建${table.comment!}:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<${table.entityExtName}> create(@RequestBody ${table.entityExtName} entity) {
        Result<${table.entityExtName}> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            ${entity} model = logic.doCreate(form);
            result = Result.SUCCESS(Assembler.assemble(${table.entityExtName}.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新${table.comment!}", notes = "更新${table.comment!}:")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<${table.entityExtName}>> update(@RequestBody ${table.entityExtName} entity) {
        Result<List<${table.entityExtName}>> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            List<${entity}> model = logic.doUpdate(form);
            result = Result.SUCCESS(Assembler.multiAssemble(${table.entityExtName}.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "逻辑删除${table.comment!}", notes = "逻辑删除${table.comment!}:")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "remove", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> remove(@RequestBody ${table.entityExtName} entity) {
        Result<Integer> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            int model = logic.doRemove(form);
            result = Result.SUCCESS(Integer.valueOf(model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "物理删除${table.comment!}", notes = "物理删除${table.comment!}:")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "purge", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> purge(@RequestBody ${table.entityExtName} entity) {
        Result<Integer> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            int count = logic.doPurge(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }


    @Override
    @ApiOperation(value = "查询${table.comment!}数量", notes = "查询${table.comment!}数量:")
    @ApiImplicitParam(name = "entity", value = "${table.comment!}", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Integer> count(@RequestBody ${table.entityExtName} entity) {
        Result<Integer> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            int count = logic.doCount(form);
            result = Result.SUCCESS(Integer.valueOf(count));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "批量导入${table.comment!}", notes = "批量导入${table.comment!}:" + "必须项目：coopCode=coopCode")
    @ApiImplicitParam(name = "entities", value = "${table.comment!}", required = true, allowMultiple = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "insertOrUpdateBatch", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<List<${table.entityExtName}>> insertOrUpdateBatch(@RequestBody List<${table.entityExtName}> entities) {
        Result<List<${table.entityExtName}>> result = null;
        try {
            List<${entity}> form = Assembler.multiAssemble(${entity}.class, entities);
            List<${entity}> model = logic.insertOrUpdateBatch(form);
            result = Result.SUCCESS(Assembler.multiAssemble(${table.entityExtName}.class, model));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }

    @Override
    @ApiOperation(value = "分页查询${table.comment!}", notes = "")
    @ApiImplicitParam(name = "entity", value = "信息", required = true, dataType = "${table.entityExtName}")
    @PostMapping(value = "page/{current}/{size}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<IPage<${table.entityExtName}>> page(@RequestBody ${table.entityExtName} entity, @PathVariable("current") int current, @PathVariable("size") int size) {
        Result<IPage<${table.entityExtName}>> result = null;
        try {
            ${entity} form = Assembler.assemble(${entity}.class, entity);
            IPage<${entity}> model = logic.page(form, current, size);
            result = Result.SUCCESS(Assembler.iPageAssemble(${table.entityExtName}.class, model));
        }catch (Exception ex) {
            log.warn(ex.getMessage());
            result = Result.FAILED();
        }
        return result;
    }
}
