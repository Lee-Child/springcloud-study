package com.lwc.user.mapper;

import com.lwc.user.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 部门 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Mapper
@Component
public interface DepartmentMapper extends BaseMapper<Department> {

    int purge(Long id);

    int purgeByIds(@Param("ids") List<Long> ids);
}
