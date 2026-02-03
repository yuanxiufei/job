package com.reginyuan.job.service.impl;

import com.reginyuan.job.domain.JobCategory;
import com.reginyuan.job.mapper.JobCategoryMapper;
import com.reginyuan.job.service.JobCategoryService;
import com.reginyuan.job.utils.ReponseResult;
import com.reginyuan.job.utils.enums.ResultCodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现类具体实现JobCategoryService的功能
 */
@Service // 标注为服务层
public class JobCategoryServiceImpl implements JobCategoryService {

    @Resource // 将jobCategoryMapper注入进来
    private JobCategoryMapper jobCategoryMapper;

    /**
     * 查询所有岗位类别
     * @return
     */
    @Override
    public ReponseResult getAllJobCategory() {
        return new ReponseResult(jobCategoryMapper.allJobCategory());
    }

    /**
     * 新增岗位分类
     * @param jobCategory
     * @return
     */
    @Override
    public ReponseResult addJobCategory(JobCategory jobCategory) {
        int result = jobCategoryMapper.insertJobCategory(jobCategory);
        Map<String,Integer> idMap = new HashMap<>();
        if (result > 0) {
            // result = jobCategory.getId(); // 如果插入成功， 返回自增主键id
            idMap.put("id",jobCategory.getId());
            return new ReponseResult(idMap);
        } else {
            return new ReponseResult(ResultCodeEnum.SERVER_ERROR);
        }
    }

    /**
     * 删除岗位类别
     * @param id
     * @return
     */
    @Override
    public int removeJobCategory(Integer id) {
        return jobCategoryMapper.deleteJobCategory(id);
    }

    /**
     * 修改岗位类别
     * @param jobCategory
     * @return
     */
    @Override
    public int updateJobCategory(JobCategory jobCategory) {
        return jobCategoryMapper.updateByPrimaryKey(jobCategory);
    }


}
