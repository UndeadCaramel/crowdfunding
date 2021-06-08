package com.crowd.test;


import com.crowd.entity.Admin;
import com.crowd.entity.AdminExample;
import com.crowd.mapper.AdminMapper;
import com.crowd.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    // 1.获取Logger对象，这里传入的Class对象就是当前打印日志的类
    Logger logger = LoggerFactory.getLogger(CrowdTest.class);


    @Test
    public void testDataSource() throws SQLException {
        // 1.通过数据源对象获取数据源连接
        Connection connection = dataSource.getConnection();
        // 2.打印数据库连接
        System.out.println(connection);
    }

    @Test
    public void testInsert() throws SQLException{
        Admin admin=new Admin();
        admin.setLoginAcct("aim");
        admin.setUserName("Aim Cock");
        admin.setEmail("aim@crowd.com");
        admin.setUserPswd("1234567");
        int flag=adminMapper.insert(admin);
        logger.debug(""+flag);
    }

    @Test
    public void testQuery() throws SQLException{
        AdminExample adminExample=new AdminExample();
        List<Admin> list=adminMapper.selectByExample(adminExample);
        logger.debug(list.toString());
    }

    @Test
    public void testLog() {

        // 1.获取Logger对象，这里传入的Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        // 2.根据不同日志级别打印日志
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");

        logger.info("Info level!!!");
        logger.info("Info level!!!");
        logger.info("Info level!!!");

        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");
        logger.warn("Warn level!!!");

        logger.error("Error level!!!");
        logger.error("Error level!!!");
        logger.error("Error level!!!");
    }

    @Test
    public void testTx(){
        Admin admin=new Admin();
        admin.setLoginAcct("bim");
        admin.setUserName("Bim Cock");
        admin.setEmail("bim@crowd.com");
        admin.setUserPswd("123456");
        adminService.saveAdmin(admin);
    }






}
