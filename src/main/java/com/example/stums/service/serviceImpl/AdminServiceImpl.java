package com.example.stums.service.serviceImpl;

import com.example.stums.entity.Admin;
import com.example.stums.mapper.AdminMapper;
import com.example.stums.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XXX
 * @since 2022-11-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
