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
    * 用户部门
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@TableName("user_department")
@ApiModel(value="UserDepartment", description="用户部门")
public class UserDepartment implements Serializable {



    @ApiModelProperty(value = "分布式主键")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "部门id")
    @TableField(value = "department_id")
    private Long departmentId;

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



}
