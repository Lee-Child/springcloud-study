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
    * 部门 BO实体
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@ApiModel(value="DepartmentBo", description="部门 BO实体")
public class DepartmentBo implements Serializable{

    private static final long serialVersionUID = -1L;


    @ApiModelProperty(value = "分布式主键")
    private Long id;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "部门类型 0-公司 1-部门")
    private Boolean departmentType;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

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
