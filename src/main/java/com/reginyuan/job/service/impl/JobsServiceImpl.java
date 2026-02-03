package com.reginyuan.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reginyuan.job.domain.Jobs;
import com.reginyuan.job.service.JobsService;
import com.reginyuan.job.mapper.JobsMapper;
import com.reginyuan.job.vo.JobsByCategoryVo;
import com.reginyuan.job.vo.JobsByCityVo;
import com.reginyuan.job.vo.JobsByProvinceVo;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * @author Administrator
 * @description 针对表【jobs(岗位详情表)】的数据库操作Service实现
 * @createDate 2026-01-17 15:41:53
 */
@Service
public class JobsServiceImpl extends ServiceImpl<JobsMapper, Jobs> implements JobsService {
    @Resource
    private JobsMapper jobsMapper;

    /**
     * 分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页数据的条数
     * @return
     */
    public IPage<Jobs> getJobsByPage(int pageNum, int pageSize){
        // 创建分页对象
        Page<Jobs> page = new Page<>(pageNum, pageSize);

        // 构造查询条件
        QueryWrapper<Jobs> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","job_title","category_name", "salary","city", "company","publish_time", "company_info");
        queryWrapper.orderByDesc("publish_time");
        // 执行分页查询
        Page<Jobs> jobsPage = jobsMapper.selectPage(page,queryWrapper);
        return jobsPage;
    }

    /**
     * 按类别统计岗位数量
     * @return
     */
    @Override
    public List<JobsByCategoryVo> countByCategoryName(){
       List<JobsByCategoryVo>  jobsByCategoryVos = jobsMapper.countByCategoryName();
       return jobsByCategoryVos;
    }


    /**
     * 按城市统计岗位
     */
    @Override
    public List<JobsByCityVo> countByCity(){
        List<JobsByCityVo> jobsByCityVos = jobsMapper.countByCity();
        return jobsByCityVos;
    }

    /**
     * 按省份统计岗位
     */
    @Override
    public List<JobsByProvinceVo> countByProvince(){
        List<JobsByProvinceVo> JobsByProvinceVos = jobsMapper.countByProvince();
        return JobsByProvinceVos;
    }
}




