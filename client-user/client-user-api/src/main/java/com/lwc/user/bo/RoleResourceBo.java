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
    *  BO实体
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@ApiModel(value="RoleResourceBo", description=" BO实体")
public class RoleResourceBo implements Serializable{

    private static final long serialVersionUID = -1L;


    @ApiModelProperty(value = "分布式主键")
    private Long id;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "资源id")
    private Long resourceId;

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




}
