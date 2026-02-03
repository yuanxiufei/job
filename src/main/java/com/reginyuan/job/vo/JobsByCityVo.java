package com.reginyuan.job.vo;

import lombok.Data;

@Data
public class JobsByCityVo {
    private String city;
    private String categoryName;
    private String categoryDesc;
    private Integer quantity;
}
