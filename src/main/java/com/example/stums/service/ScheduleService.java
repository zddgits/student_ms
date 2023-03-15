package com.example.stums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
public interface ScheduleService extends IService<Schedule> {
    /**
     * 课表的分页查询
     * */
//    Page<Schedule> findPageByWorkID(Integer id);

    R<Page<Schedule>> findPageByWorkID(Integer id, Integer current, Integer limit);
}
