package com.boot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author yuansc
 * @date 2019/3/28 0028 下午 3:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel
public class SysDictList implements Serializable {

    private static final long serialVersionUID = 3229169744406099575L;

    @ApiModelProperty(value = "数据值")
    private String value;
    @ApiModelProperty(value = "标签名")
    private String label;
    @ApiModelProperty(value = "排序（升序）")
    private Long sort;


}
