package com.lwc.user.bo;

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
    * 资源 BO实体
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@ApiModel(value="ResourceBo", description="资源 BO实体")
public class ResourceBo implements Serializable{

    private static final long serialVersionUID = -1L;


    @ApiModelProperty(value = "分布式主键")
    private Long id;

    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @ApiModelProperty(value = "资源类型 0-目录 1-菜单 2-按钮 3-接口")
    private Integer resourceType;

    @ApiModelProperty(value = "接口/连接地址")
    private String url;

    @ApiModelProperty(value = "接口方法")
    private String method;

    @ApiModelProperty(value = "是否忽略权限校验 0-否 1-是")
    private Boolean ignoreFlag;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateAt;

    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    @ApiModelProperty(value = "是否逻辑删除")
    private Boolean deleteFlag;

    @ApiModelProperty(value = "乐观锁字段")
    private Integer version;




}
