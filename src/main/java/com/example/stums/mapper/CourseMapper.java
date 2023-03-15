package com.example.stums.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
//    @Select(value="select * from course where name like CONCAT('%',:name,'%')")
//    Page<Course> findByName(String name);

}
