package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Mapper
@Component
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    int purge(Long id);

    int purgeByIds(@Param("ids")List<Long> ids);
}
