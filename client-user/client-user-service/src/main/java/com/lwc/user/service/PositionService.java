package com.lwc.user.service;

import com.lwc.user.entity.Position;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 职位 服务类
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
public interface PositionService {
    Position doQuery(Long id) throws Exception;

    int doRemove(Long id) throws Exception;

    int doPurge(Long id) throws Exception;

    List<Position> doQueryByIds(List<Long> ids) throws Exception;

    int doRemoveByIds(List<Long> ids) throws Exception;

    int doPurgeByIds(List<Long> ids) throws Exception;

    List<Position> doQuery(Position entity) throws Exception;

    Position doCreate(Position entity) throws Exception;

    List<Position> doUpdate(Position entity) throws Exception;

    int doRemove(Position entity) throws Exception;

    int doPurge(Position entity) throws Exception;

    int doCount(Position entity) throws Exception;

    List<Position> insertOrUpdateBatch(List<Position> entities) throws Exception;

    IPage<Position> page(Position entity, int current, int size) throws Exception;
}
