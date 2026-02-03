package com.reginyuan.job.vo;

import lombok.Data;

@Data
public class JobsByCategoryVo {
    private String categoryName;
    private String categoryDesc;
    private Integer quantity; // 岗位数量
}
