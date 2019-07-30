<#--package ${package.Payload};-->

<#--import ${package.EntityExt}.${table.entityExtName};-->
<#--import com.gtmc.infra.eip.common.mq.AbstractPayload;-->

<#--import com.alibaba.fastjson.JSON;-->
<#--import com.alibaba.fastjson.JSONObject;-->

<#--import java.io.Serializable;-->

<#--public class ${table.payloadName} extends AbstractPayload<${table.entityExtName}> implements Serializable {-->

    <#--@Override-->
    <#--public ${table.entityExtName} parseSqlParams() {-->
        <#--${table.entityExtName} bo = new ${table.entityExtName}();-->
        <#--JSONObject json = JSON.parseObject(getSqlParamValues());-->
        <#--return null;-->
    <#--}-->
<#--}-->

