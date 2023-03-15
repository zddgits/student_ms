package com.example.stums.mapper;

import com.example.stums.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
