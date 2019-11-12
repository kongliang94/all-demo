package com.github.jsontoword.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 */
@Data
@ApiModel("单个图表请求对象")
public class ReportContentRequest {

    @ApiModelProperty(value = "报表中排列序号", name = "serial")
    private Integer serial;

    @ApiModelProperty(value = "单个图表标题", name = "title")
    private String title;

    @ApiModelProperty(value = "单个图表base64编码值", name = "base64")
    private String base64;

    @ApiModelProperty(value = "单个图表内容总结", name = "summary")
    private String summary;

    @ApiModelProperty(value = "该标题下存在多个报表", name = "children")
    private List<ReportContentRequest> children;
}
