package com.reginyuan.job.service;

import com.reginyuan.job.domain.JobCategory;
import com.reginyuan.job.utils.ReponseResult;

/**
 * JobCategory服务接口
 */
public interface JobCategoryService {

    /**
     * 获取所有岗位类别
     * @return
     */
    ReponseResult getAllJobCategory();

    /**
     * 新增岗位类别
     * @param jobCategory
     * @return
     */
    ReponseResult addJobCategory(JobCategory jobCategory);

    /**
     * 删除岗位类别
     * @param id
     * @return
     */
    int removeJobCategory(Integer id);

    /**
     * 修改岗位类别
     * @param jobCategory
     * @return
     */
    int updateJobCategory(JobCategory jobCategory);
}
