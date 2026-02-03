package com.reginyuan.job.mapper;

import com.reginyuan.job.domain.JobCategory;

import java.util.List;

public interface JobCategoryMapper {
    /**
     * 查询数据
     * @return
     */
    List<JobCategory> allJobCategory();

    /**
     * 添加数据
     * @param jobCategory
     * @return
     */
    int insertJobCategory(JobCategory jobCategory);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteJobCategory(Integer id);


    /**
     * 修改数据
     * @param jobCategory
     * @return
     */
    int updateByPrimaryKey(JobCategory jobCategory);

}
