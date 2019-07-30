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
    * 用户
    * </p>
*
* @author Li
* @since 2019-07-29
*/
@Data
@NoArgsConstructor
@TableName("user")
@ApiModel(value="User", description="用户")
public class User implements Serializable {



    @ApiModelProperty(value = "分布式主键")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户职位id")
    @TableField(value = "position_id")
    private Long positionId;

    @ApiModelProperty(value = "账号")
    @TableField(value = "login_name")
    private String loginName;

    @ApiModelProperty(value = "密码")
    @TableField(value = "login_pass")
    private String loginPass;

    @ApiModelProperty(value = "盐")
    @TableField(value = "salt")
    private String salt;

    @ApiModelProperty(value = "真实姓名")
    @TableField(value = "real_name")
    private String realName;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone")
    private String phone;

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
