package com.crowd.service;

import com.crowd.entity.Admin;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getById(Integer id);
}
