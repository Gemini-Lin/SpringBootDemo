package cn.geminiplanet.springbootdemo.controller;

import cn.geminiplanet.springbootdemo.common.domain.MyClass;
import cn.geminiplanet.springbootdemo.common.utils.Result;
import cn.geminiplanet.springbootdemo.service.ClassService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping("/listClass")
    @ResponseBody
    public Object listClass(MyClass myClass,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageInfo<MyClass> pageInfo = classService.findClass(pageNo,pageSize,myClass);
        return Result.success(pageInfo);
    }

    @RequestMapping("/delClass")
    @ResponseBody
    public Object delClass(@RequestBody Integer[] ids){
        int count = classService.removeClass(ids);
        return Result.success(count,"操作成功",200);
    }

    @RequestMapping("/addClass")
    @ResponseBody
    public Object addClass(@RequestBody MyClass myClass){
        int count = classService.addClass(myClass);
        return Result.success(count,"操作成功",200);
    }

    @RequestMapping("/showClass")
    public String showClass(ModelMap modelMap, Integer id){
        MyClass myClass = classService.findClassById(id);
        modelMap.put("class",myClass);
        return "/views/layer_showClassDetail";
    }

    /**
     * 查询clazz 对象后，回显到layer 弹出框
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping("/toUpdate")
    public String showClassUpdate(ModelMap modelMap,Integer id){
        MyClass myClass = classService.findClassById(id);
        modelMap.put("class",myClass);
        return "/views/layer_showClassUpdate";
    }
    /**
     *
     */
    @RequestMapping("/submitUpdateClass")
    @ResponseBody
    public Object submitUpdateClass(@RequestBody MyClass myClass){
        int count = classService.updateClass(myClass);
        return Result.success(count,"操作成功",200);
    }


}
