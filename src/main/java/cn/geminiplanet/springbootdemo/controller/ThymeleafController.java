package cn.geminiplanet.springbootdemo.controller;

import cn.geminiplanet.springbootdemo.common.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/Thymeleaf")
    public String Thymeleaf(ModelMap modelMap){
        modelMap.put("text","<h1>Welcome to Thymeleaf<h1>");
        modelMap.put("id","MyButtonID");
        // 泛型思想
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("Book Name：" + i);
            list.add(book);
        }
        modelMap.put("bookList",list);
        return "ThymeleafDemo";
    }
}
