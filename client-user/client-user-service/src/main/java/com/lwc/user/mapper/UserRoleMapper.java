package com.lwc.user.mapper;

import com.lwc.user.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-07-29
 */
@Mapper
@Component
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int purge(Long id);

    int purgeByIds(@Param("ids") List<Long> ids);
}
