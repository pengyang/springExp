package com.baobaotao.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.baobaotao.domain.User;

import java.util.Date;

/**
 * Created by y on 2016/2/29.
 */

@RunWith(SpringJUnit4ClassRunner.class) //基于JUnit4的Spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestUserService  extends TestCase{

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertFalse(b2);
    }


    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals("admin",user.getUserName());
    }

    @Test
    public void loginSuccess(){
        User user = userService.findUserByUserName("admin");
        user.setLastIp("127.0.0.1");
        user.setLastVisit(new Date());

        userService.loginSuccess(user);
    }

}
