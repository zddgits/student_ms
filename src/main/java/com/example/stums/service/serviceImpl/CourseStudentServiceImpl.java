package com.example.stums.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.CourseStudent;
import com.example.stums.mapper.CourseStudentMapper;
import com.example.stums.service.CourseStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import sun.plugin.dom.core.CoreConstants;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@Service
public class CourseStudentServiceImpl extends ServiceImpl<CourseStudentMapper, CourseStudent> implements CourseStudentService {

//    @Override
//    public Page<CourseStudent> findPageByID(String role, Integer id) {
//        Page<CourseStudent> page = new Page<>();
//        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
//        wrapper.eq(role + "_id", id);
//        baseMapper.selectPage(page, wrapper);
//        return page;
//    }
//
//    @Override
//    public Page<CourseStudent> findByTeacherAndCourse(Integer teacherID, Integer courseID) {
//        Page<CourseStudent> page = new Page<>();
//        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
//        wrapper.eq("course_id",courseID);
//        wrapper.eq("teacher_id", teacherID);
//        baseMapper.selectPage(page, wrapper);
//        return page;
//    }

    @Override
    public R<Page<CourseStudent>> findAll(Integer current, Integer limit) {
        // 创建分页对象
        Page<CourseStudent> page = new Page<>(current, limit);
        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<CourseStudent> list = page.getRecords();
        // 获取表中总记录数
        int total = (int) page.getTotal();
        total = list.size();
        // 获取分页总数
        int pages = (int) page.getPages();
        pages = total / limit;
        // 将分页信息数据封装在Map集合中
        return R.success(page).add("total", total).add("pages",pages).add("current",current).add("limit",limit);
    }

    @Override
    public R<Page<CourseStudent>> findPageByID(String role, Integer id, Integer current, Integer limit) {
        // 创建分页对象
        Page<CourseStudent> page = new Page<>(current, limit);
        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.eq(role + "_id", id);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<CourseStudent> list = page.getRecords();
        // 获取表中总记录数
        int total = (int) page.getTotal();
        total = list.size();
        // 获取分页总数
        int pages = (int) page.getPages();
        pages = total / limit;
        // 将分页信息数据封装在Map集合中
        return R.success(page).add("total", total).add("pages",pages).add("current",current).add("limit",limit);
    }

    @Override
    public R<Page<CourseStudent>> findByTeacherAndCourse(Integer teacherID, Integer courseID, Integer current, Integer limit) {
        // 创建分页对象
        Page<CourseStudent> page = new Page<>(current, limit);
        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.eq("course_id",courseID);
        wrapper.eq("teacher_id", teacherID);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<CourseStudent> list = page.getRecords();
        // 获取表中总记录数
        int total = (int) page.getTotal();
        total = list.size();
        // 获取分页总数
        int pages = (int) page.getPages();
        pages = total / limit;
        // 将分页信息数据封装在Map集合中
        return R.success(page).add("total", total).add("pages",pages).add("current",current).add("limit",limit);
    }

    @Override
    public R<Page<CourseStudent>> findByStudentAndCourse(Integer studentID, Integer courseID, Integer current, Integer limit) {
        // 创建分页对象
        Page<CourseStudent> page = new Page<>(current, limit);
        QueryWrapper<CourseStudent> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.eq("course_id",courseID);
        wrapper.eq("student_id", studentID);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<CourseStudent> list = page.getRecords();
        // 获取表中总记录数
        int total = (int) page.getTotal();
        total = list.size();
        // 获取分页总数
        int pages = (int) page.getPages();
        pages = total / limit;
        // 将分页信息数据封装在Map集合中
        return R.success(page).add("total", total).add("pages",pages).add("current",current).add("limit",limit);
    }
}
