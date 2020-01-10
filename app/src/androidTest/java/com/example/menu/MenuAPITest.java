package com.example.menu;

import com.example.menu.bll.LoginBLL;
import com.example.menu.bll.RegisterBLL;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MenuAPITest {

    @Test
    public void testLoginPass(){
        LoginBLL loginBLL = new LoginBLL("suman670", "suman");
        boolean result = loginBLL.checkUser();
        assertEquals(true, result);
    }

    @Test
    public void testLoginFailed(){
        LoginBLL loginBLL = new LoginBLL("tuman670", "suman");
        boolean result = loginBLL.checkUser();
        assertEquals(false, result);
    }

    @Test
    public void testRegisterPass(){
        RegisterBLL registerBLL = new RegisterBLL("Anish Rajbhandari", "anishkalp","anish@gmail.com","9841254965","anish","imageFile-1562772539947.jpg");
        boolean result = registerBLL.register();
        assertEquals(true, result);
    }

    @Test
    public void testRegisterFailed(){
        RegisterBLL registerBLL = new RegisterBLL("Anish Rawal", "anish123","anish@gmail.com","9800644819","rawal","imageFile-1562772539947.jpg");
        boolean result = registerBLL.register();
        assertEquals(false, result);
    }

    @Test
    public void testAddPostPass(){
        AddPostBLL addPostBLL = new AddPostBLL("great restaurant", "kathmandu","imageFile-1562772539947.jpg",1,"user","suman","imageFile-1562772539947.jpg");
        boolean result = addPostBLL.addPost();
        assertEquals(true, result);
    }
}
