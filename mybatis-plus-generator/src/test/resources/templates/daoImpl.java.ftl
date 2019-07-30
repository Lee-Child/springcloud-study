<#--package ${package.DaoImpl};-->

<#--import ${package.Entity}.${entity};-->
<#--import ${package.Mapper}.${table.mapperName};-->
<#--import ${package.Dao}.${table.daoName};-->
<#--import ${superDaoImplClassPackage};-->

<#--import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;-->
<#--import org.springframework.beans.factory.annotation.Autowired;-->
<#--import org.springframework.stereotype.Repository;-->

<#--import java.util.List;-->


<#--/**-->
 <#--* <p>-->
 <#--* ${table.comment!} DAO实现类-->
 <#--* </p>-->
 <#--*-->
 <#--* @author ${author}-->
 <#--* @since ${date}-->
 <#--*/-->
<#--@Repository("${table.daoName}")-->
<#--public class ${table.daoImplName} extends ${superDaoImplClass}<${entity}, Long> implements ${table.daoName} {-->

    <#--@Autowired-->
    <#--private ${table.mapperName} extMapper;-->

    <#--@Override-->
    <#--public int callDeleteById(String id) {-->

        <#--return extMapper.deleteById(id);-->
    <#--}-->

    <#--@Override-->
    <#--public int callPurge(Long id) {-->

        <#--return extMapper.purge(id);-->
    <#--}-->

    <#--@Override-->
    <#--public int callDeleteBatchIds(List<String> ids) {-->

        <#--return extMapper.deleteBatchIds(ids);-->
    <#--}-->

    <#--@Override-->
    <#--public int callDelete(QueryWrapper queryWrapper) {-->

        <#--return extMapper.delete(queryWrapper);-->
    <#--}-->

<#--}-->
