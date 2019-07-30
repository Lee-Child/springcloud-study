<#--package ${package.Handler};-->

<#--import ${package.Entity}.${entity};-->
<#--import ${package.Service}.${table.serviceName};-->
<#--import ${package.Payload}.${table.payloadName};-->
<#--import ${package.EntityExt}.${table.entityExtName};-->

<#--import com.gtmc.glaf.framework.core.assembler.Assembler;-->
<#--import com.gtmc.glaf.framework.core.constant.CommCode;-->
<#--import com.gtmc.infra.eip.${package.ModuleName}.assembler.EipAssembler;-->

<#--import com.gtmc.infra.eip.common.exception.BusinessException;-->
<#--import com.gtmc.infra.eip.common.mq.PayloadDefs;-->
<#--import com.gtmc.glaf.framework.core.model.result.Result;-->
<#--import com.gtmc.infra.eip.common.service.ServiceConstants;-->
<#--import lombok.extern.slf4j.Slf4j;-->
<#--import org.slf4j.Logger;-->
<#--import org.slf4j.LoggerFactory;-->
<#--import org.springframework.beans.factory.annotation.Autowired;-->
<#--import org.springframework.stereotype.Component;-->

<#--import java.util.List;-->
<#--import java.io.Serializable;-->

<#--@Component-->
<#--@Slf4j-->
<#--public class ${table.handlerName} {-->

    <#--@Autowired-->
    <#--${table.serviceName} logic;-->

    <#--public Result<${table.entityExtName}> handleMessage(${table.payloadName} payload) {-->
        <#--Result<${table.entityExtName}> result = null;-->
        <#--${entity} model = null;-->
        <#--log.debug("MQ Payload SqlId: {}", payload.getSqlId());-->
        <#--log.debug("MQ Payload SqlParamValues: {}", payload.getSqlParamValues());-->
        <#--try {-->
            <#--${entity} data = Assembler.assemble(${entity}.class, payload.parseSqlParams());-->
            <#--switch (payload.getSqlId()){-->
<#--//                case PayloadDefs.TYPE.INSERT:-->
<#--//                    model = logic.insertByPrimaryKeyBatch(datas);-->
<#--//                    break;-->
<#--//                case PayloadDefs.TYPE.UPDATE:-->
<#--//                    model = logic.updateByPrimaryKeyBatch(datas);-->
<#--//                    break;-->
<#--//                case PayloadDefs.TYPE.DELETE:-->
<#--//                    model = logic.removeByPrimaryKeyBatch(datas);-->
<#--//                    break;-->
<#--//                case PayloadDefs.TYPE.MIGRATION:-->
<#--//                    model = logic.insertOrUpdateBatch(datas);-->
<#--//                    break;-->
                <#--default:-->
                    <#--break;-->
            <#--}-->

            <#--result = Result.build(Assembler.assemble(${table.entityExtName}.class, model));-->
<#--//        } catch (NetworkException ne) {-->
<#--//            log.warn(ne.getMessage());-->
<#--//            result = Result.newFailure(ne.getCode(), ne.getMessage());-->
<#--//        } catch (SystemException se) {-->
<#--//            log.warn(se.getMessage());-->
<#--//            result = Result.newFailure(se.getCode(), se.getMessage());-->
        <#--} catch (BusinessException be) {-->
            <#--log.warn(be.getMessage());-->
            <#--//result = Result.newFailure(be.getCode(), be.getMessage());-->
            <#--result = Result.build(CommCode.ERROR);-->
        <#--} catch (Exception ex) {-->
            <#--log.warn(ex.getMessage());-->
            <#--//result = Result.newFailure(ServiceConstants.FAILURE_MESSAGE);-->
            <#--result = Result.build(CommCode.ERROR);-->
        <#--}-->
        <#--return result;-->
    <#--}-->

<#--}-->



