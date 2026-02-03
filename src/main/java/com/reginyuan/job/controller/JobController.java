package com.reginyuan.job.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.reginyuan.job.domain.Jobs;
import com.reginyuan.job.service.JobsService;
import com.reginyuan.job.utils.ReponseResult;
import com.reginyuan.job.vo.JobsByCategoryVo;
import com.reginyuan.job.vo.JobsByCityVo;
import com.reginyuan.job.vo.JobsByProvinceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/job")
@Api(tags = "岗位管理相关接口")
public class JobController {


    @Resource
    private JobsService jobsService;

    /**
     * 根据id获取岗位注解
     * @return
     */
    @GetMapping("/v1/{id}")
    @ApiOperation("根据id获取岗位注解")
    public ReponseResult getById(@PathVariable("id") Integer id) {
        Jobs byid = jobsService.getById(id);
        if (byid != null) {
            return new ReponseResult(byid);
        } else {
            return new ReponseResult(401, "不存在对应id的数据");
        }
    }

    /**
     * 分页查询岗位数据
     */
    @GetMapping("/v1/page")
    @ApiOperation("分页查询岗位数据")
    public ReponseResult getByPage(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {

        // 分页查询
        IPage<Jobs> jobsByPage = jobsService.getJobsByPage(pageNum, pageSize);
        return new ReponseResult(jobsByPage);
    }

    /**
     * 按类别统计岗位数量
     * @return
     */
    @GetMapping("/v1/category/statistics")
    @ApiOperation("按类别统计岗位数量")
    public ReponseResult getJobsByCategory() {
        List <JobsByCategoryVo> jobsByCategoryVos = jobsService.countByCategoryName();
        return new ReponseResult(jobsByCategoryVos);
    }

    /**
     * 按城市统计岗位
     */
    @GetMapping("/v1/city/statistics")
    @ApiOperation("按城市统计岗位")
    public ReponseResult getJobsByCity() {
        List <JobsByCityVo> jobsByCityVos = jobsService.countByCity();
        return new ReponseResult(jobsByCityVos);
    }

    /**
     * 按省份统计岗位
     */
    @GetMapping("/v1/province/statistics")
    @ApiOperation("按省份统计岗位")
    public ReponseResult getJobsByProvince() {
        List <JobsByProvinceVo> jobsByProvinceVos = jobsService.countByProvince();
        return new ReponseResult(jobsByProvinceVos);
    }
}
