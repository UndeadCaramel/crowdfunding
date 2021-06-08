package com.crowd.service.impl;

import com.crowd.entity.Admin;
import com.crowd.mapper.AdminMapper;
import com.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
