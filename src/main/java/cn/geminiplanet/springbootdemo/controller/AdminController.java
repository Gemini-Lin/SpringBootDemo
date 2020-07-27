package cn.geminiplanet.springbootdemo.controller;

import cn.geminiplanet.springbootdemo.common.domain.Admin;
import cn.geminiplanet.springbootdemo.common.utils.Result;
import cn.geminiplanet.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Admin admin, HttpServletRequest request){

        Admin adminInDB = adminService.login(admin);
        if(adminInDB==null){
            return Result.fail("用户名不存在",200);
        }else {
            if(adminInDB.getPassword().equals(admin.getPassword())){
                return Result.success("登录成功",200);
            }else {
                return Result.fail("密码错误",200);
            }
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "/login";
    }

}