package cn.geminiplanet.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/page/{path}")
    public String toPage(@PathVariable("path") String p){
        return "/views/"+p;
    }

    @RequestMapping("/")
    public String toIndex(){
        return "/login";
    }
}
