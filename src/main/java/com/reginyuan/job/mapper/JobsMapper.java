package com.reginyuan.job.mapper;

import com.reginyuan.job.domain.Jobs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reginyuan.job.vo.JobsByCategoryVo;
import com.reginyuan.job.vo.JobsByCityVo;
import com.reginyuan.job.vo.JobsByProvinceVo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【jobs(岗位详情表)】的数据库操作Mapper
* @createDate 2026-01-17 15:41:53
* @Entity com.reginyuan.job.domain.Jobs
*/
public interface JobsMapper extends BaseMapper<Jobs> {
    /**
     * 按类别统计岗位数量
     */
    List<JobsByCategoryVo> countByCategoryName();

    /**
     * 按城市统计岗位数量
     */
    List<JobsByCityVo> countByCity();


    /**
     * 按省份统计岗位数量
     */
    List<JobsByProvinceVo> countByProvince();
}




