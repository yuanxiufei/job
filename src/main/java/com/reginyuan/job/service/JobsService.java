package com.reginyuan.job.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reginyuan.job.domain.Jobs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.reginyuan.job.utils.ReponseResult;
import com.reginyuan.job.vo.JobsByCategoryVo;
import com.reginyuan.job.vo.JobsByCityVo;
import com.reginyuan.job.vo.JobsByProvinceVo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【jobs(岗位详情表)】的数据库操作Service
* @createDate 2026-01-17 15:41:53
*/
public interface JobsService extends IService<Jobs> {
    /**
     * 分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页数据的条数
     * @return
     */
    IPage<Jobs> getJobsByPage(int pageNum, int pageSize);


    /**
     * 按类别统计岗位数量
     * @return
     */
    List<JobsByCategoryVo> countByCategoryName();

    /**
     * 按城市统计岗位
     * @return
     */
    List<JobsByCityVo> countByCity();

    /**
     * 按省份统计岗位
     * @return
     */
    List<JobsByProvinceVo> countByProvince();
}
