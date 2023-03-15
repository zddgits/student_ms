package com.example.stums.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Teacher;
import com.example.stums.mapper.TeacherMapper;
import com.example.stums.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public R<Page<Teacher>> findByName(String name, Integer current, Integer limit) {
        // 创建分页对象
        Page<Teacher> page = new Page<>(current, limit);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.like("name", name);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<Teacher> list = page.getRecords();
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
