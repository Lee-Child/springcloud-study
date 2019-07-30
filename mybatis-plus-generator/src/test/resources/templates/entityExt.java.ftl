package ${package.EntityExt};

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* <p>
    * ${table.comment!} BO实体
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Data
@NoArgsConstructor
@ApiModel(value="${table.entityExtName}", description="${table.comment!} BO实体")
public class ${table.entityExtName} implements Serializable{

    private static final long serialVersionUID = -1L;

    <#-- ----------  BEGIN 字段循环遍历  ---------->
    <#list table.fields as field>
        <#if field.keyFlag>
            <#assign keyPropertyName="${field.propertyName}"/>
        </#if>

        <#if field.comment!?length gt 0>
            <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
            <#else>
    /**
     * ${field.comment}
     */
            </#if>
        </#if>
    private ${field.propertyType} ${field.propertyName};
    </#list>
    <#------------  END 字段循环遍历  ---------->

    <#if !entityLombokModel>
        <#list table.fields as field>
            <#if field.propertyType == "boolean">
                <#assign getprefix="is"/>
            <#else>
                <#assign getprefix="get"/>
            </#if>
    public ${field.propertyType} ${getprefix}${field.capitalName}() {
         return ${field.propertyName};
    }

            <#if entityBuilderModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
            </#if>
        this.${field.propertyName} = ${field.propertyName};
            <#if entityBuilderModel>
        return this;
            </#if>
    }
        </#list>
    </#if>

    <#if entityColumnConstant>
        <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";

        </#list>
    </#if>

    <#if !entityLombokModel>
    @Override
    public String toString() {
        return "${entity}{" +
        <#list table.fields as field>
            <#if field_index==0>
                "${field.propertyName}=" + ${field.propertyName} +
            <#else>
                ", ${field.propertyName}=" + ${field.propertyName} +
            </#if>
        </#list>
        "}";
    }
    </#if>

}
