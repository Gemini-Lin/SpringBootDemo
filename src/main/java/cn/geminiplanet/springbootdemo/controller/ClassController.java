package cn.geminiplanet.springbootdemo.controller;

import cn.geminiplanet.springbootdemo.common.domain.MyClass;
import cn.geminiplanet.springbootdemo.common.utils.Result;
import cn.geminiplanet.springbootdemo.service.ClassService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping("/listClass")
    @ResponseBody
    public Object listClass(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageInfo<MyClass> pageInfo = classService.findClass(pageNo,pageSize);
        return Result.success(pageInfo);
    }
}
