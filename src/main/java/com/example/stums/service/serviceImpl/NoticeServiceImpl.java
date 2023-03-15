package com.example.stums.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Notice;
import com.example.stums.mapper.NoticeMapper;
import com.example.stums.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.print.Pageable;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

//    @Override
//    public Page<Notice> findPageByAcceptor(String acceptor) {
//        Page<Notice> page = new Page<>();
//        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
//        wrapper.eq("acceptor", acceptor);
//        baseMapper.selectPage(page, wrapper);
//        return page;
//    }
//
//    @Override
//    public Page<Notice> findPageByDeliver(Integer id) {
//        Page<Notice> page = new Page<>();
//        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
//        wrapper.eq("deliver_id", id);
//        baseMapper.selectPage(page, wrapper);
//        return page;
//    }

    @Override
    public R<Page<Notice>> findPageByAcceptor(String acceptor, Integer current, Integer limit) {
        // 创建分页对象
        Page<Notice> page = new Page<>(current, limit);
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.eq("acceptor", acceptor);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<Notice> list = page.getRecords();
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
    public R<Page<Notice>> findPageByDeliver(Integer id, Integer current, Integer limit) {
        // 创建分页对象
        Page<Notice> page = new Page<>(current, limit);
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        wrapper.eq("deliver_id", id);
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<Notice> list = page.getRecords();
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
    public R<Page<Notice>> findPage(Integer current, Integer limit) {
        // 创建分页对象
        Page<Notice> page = new Page<>(current, limit);
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        // 条件构造器——构造条件
        // 调用分页查询的方法
        baseMapper.selectPage(page, wrapper);
        // 获取表中的显示的数据
        List<Notice> list = page.getRecords();
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
