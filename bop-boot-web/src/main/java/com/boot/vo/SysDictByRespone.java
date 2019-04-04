package com.boot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuansc
 * @date 2019/4/4 0004 上午 11:15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel
public class SysDictByRespone implements Serializable {

    /**
     * 主键
     */
    @NotNull
    @ApiModelProperty(value = "查询主键", required = true)
    String key;

}
