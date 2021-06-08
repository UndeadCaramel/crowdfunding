package com.crowd.mvc.handler;

import com.crowd.entity.Admin;
import com.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("test")
public class TestHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("ssm.html")
    public String testSsm(ModelMap modelMap){
        List<Admin> list=adminService.getAll();
        modelMap.addAttribute("list",list);
        return "target";
    }

    @RequestMapping("getAdmin.json")
    @ResponseBody
    public Admin testAdmin(@RequestParam("id") Integer id){
        Admin admin=adminService.getById(id);
        return admin;
    }

    @RequestMapping("array.html")
    @ResponseBody
    public List testArray(@RequestParam("array[]") List<Integer> array){
        System.out.println(array.size());
        return array;
    }
}
