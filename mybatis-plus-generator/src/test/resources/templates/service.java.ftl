package ${package.Service};

import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} {
    ${entity} doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<${entity}> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<${entity}> doQuery(${entity} entity) throws Exception;

    ${entity} doCreate(${entity} entity) throws Exception;

    List<${entity}> doUpdate(${entity} entity) throws Exception;

    int doRemove(${entity} entity) throws Exception;

    int doPurge(${entity} entity) throws Exception;

    int doCount(${entity} entity) throws Exception;

    List<${entity}> insertOrUpdateBatch(List<${entity}> entities) throws Exception;

    IPage<${entity}> page(${entity} entity, int current, int size) throws Exception;
}
