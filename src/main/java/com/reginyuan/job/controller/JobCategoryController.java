package com.reginyuan.job.controller;

import com.reginyuan.job.domain.JobCategory;
import com.reginyuan.job.service.JobCategoryService;
import com.reginyuan.job.utils.ReponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController // 注册为控制层
@Api(tags = "岗位类别管理相关接口")
public class JobCategoryController {

    @Resource  // 将jobCategoryService服务层注解进来
    private JobCategoryService jobCategoryService;


    /**
     * 获取所有岗位类别
     * @return
     */
    @GetMapping("/all/category") // 提供访问接口
    @ApiOperation("获取所有岗位类别")
    public ReponseResult getAllJobCategory() {
        return jobCategoryService.getAllJobCategory();
    }

    /**
     * 新增岗位分类
     * @param jobCategory
     * @return
     */
    @PostMapping("/add/category")
    @ApiOperation("新增岗位分类")
    public ReponseResult addJobCategory(@Validated JobCategory jobCategory) {
        return jobCategoryService.addJobCategory(jobCategory);
    }


    /**
     *删除岗位信息
     * @param id
     * @return
     */
    @PostMapping("/delete/category")
    @ApiOperation("删除岗位信息")
    public int deleteJobCategory(@RequestParam(value = "id")Integer id) {
        return jobCategoryService.removeJobCategory(id);
    }

    /**
     * 修改岗位信息
     * @param jobCategory
     * @return
     */
    @PostMapping("/edit/category")
    @ApiOperation("修改岗位信息")
    public int updateJobCategory(JobCategory jobCategory) {
        return jobCategoryService.updateJobCategory(jobCategory);
    }


}
