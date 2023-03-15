package com.example.stums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Student;
import com.example.stums.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 根据姓名名模糊查询
     * */
    public R<Page<Teacher>> findByName(String name, Integer current, Integer limit);
}
