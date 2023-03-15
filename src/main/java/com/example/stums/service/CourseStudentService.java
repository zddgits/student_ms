package com.example.stums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.CourseStudent;
import com.baomidou.mybatisplus.extension.service.IService;
import sun.plugin.dom.core.CoreConstants;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
public interface CourseStudentService extends IService<CourseStudent> {
    /**
     * CourseStudent的分页查询
     * */
//    Page<CourseStudent> findPageByID(String role, Integer id);
//
//    Page<CourseStudent> findByTeacherAndCourse(Integer teacherID, Integer courseID);
    R<Page<CourseStudent>> findAll(Integer current, Integer limit);

    R<Page<CourseStudent>> findPageByID(String role, Integer id, Integer current, Integer limit);

    R<Page<CourseStudent>> findByTeacherAndCourse(Integer teacherID, Integer courseID, Integer current, Integer limit);

    R<Page<CourseStudent>> findByStudentAndCourse(Integer studentID, Integer courseID, Integer current, Integer limit);
}
