package com.example.stums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.stums.entity.Notice;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
public interface CourseService extends IService<Course> {
    /**
     * 根据课程名模糊查询
     * */
    public R<Page<Course>> findByName(String name, Integer current, Integer limit);
    /**
     * 接受的通知的分页查询
     * */
//    Page<Course> findPage();
    public R<Page<Course>> findPage(Integer current, Integer limit);
}
