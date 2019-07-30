package com.lwc.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
* <p>
    * 资源
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@TableName("resource")
@ApiModel(value="Resource", description="资源")
public class Resource implements Serializable {



    @ApiModelProperty(value = "分布式主键")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "资源名称")
    @TableField(value = "resource_name")
    private String resourceName;

    @ApiModelProperty(value = "资源类型 0-目录 1-菜单 2-按钮 3-接口")
    @TableField(value = "resource_type")
    private Integer resourceType;

    @ApiModelProperty(value = "接口/连接地址")
    @TableField(value = "url")
    private String url;

    @ApiModelProperty(value = "接口方法")
    @TableField(value = "method")
    private String method;

    @ApiModelProperty(value = "是否忽略权限校验 0-否 1-是")
    @TableField(value = "ignore_flag")
    private Boolean ignoreFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    @ApiModelProperty(value = "创建人")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateAt;

    @ApiModelProperty(value = "修改人")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    @ApiModelProperty(value = "是否逻辑删除")
    @TableField(value = "delete_flag")
    @TableLogic
    private Boolean deleteFlag;

    @ApiModelProperty(value = "乐观锁字段")
    @TableField(value = "version")
    @Version
    private Integer version;



}
