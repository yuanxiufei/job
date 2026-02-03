package com.reginyuan.job.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data // 生成getter、setter、toString等方法
@NoArgsConstructor // 生成无参构造方法
@AllArgsConstructor // 生成全参构造方法
public class JobCategory {
    private int id;
    @NotBlank(message = "岗位名称类别或岗位表述不能为空")
    @Length(min=2,max=20,message = "长度2-20个字符")
    private String categoryName;
    private String categoryDesc;
}
