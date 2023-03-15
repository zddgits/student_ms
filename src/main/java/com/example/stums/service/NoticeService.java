package com.example.stums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stums.common.R;
import com.example.stums.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
public interface NoticeService extends IService<Notice> {

//    /**
//     * 接受的通知的分页查询
//     * */
//    Page<Notice> findPageByAcceptor(String acceptor);

//    /**
//     * 发布的通知的分页查询
//     * */
//    Page<Notice> findPageByDeliver(Integer id);

    /**
     * 接受的通知的分页查询
     * */
    R<Page<Notice>> findPageByAcceptor(String acceptor, Integer current, Integer limit);

    /**
     * 发布的通知的分页查询
     * */
    R<Page<Notice>> findPageByDeliver(Integer id, Integer current, Integer limit);

    R<Page<Notice>> findPage(Integer current, Integer limit);
}
