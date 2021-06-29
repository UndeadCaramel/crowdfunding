package com.crowd.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    private String loginAcct;

    private String userPswd;

    private String userName;

    private String email;

    private String createTime;

}