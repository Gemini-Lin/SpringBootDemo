package cn.geminiplanet.springbootdemo;

import cn.geminiplanet.springbootdemo.common.domain.Admin;
import cn.geminiplanet.springbootdemo.common.domain.MyClass;
import cn.geminiplanet.springbootdemo.mapper.AdminMapper;
import cn.geminiplanet.springbootdemo.mapper.MyClassMapper;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class MapperTest {
    @Autowired(required = false)
    MyClassMapper myClassMapper = null;

    @Autowired
    AdminMapper adminMapper;

    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            MyClass myClass = new MyClass();
            myClass.setName("班级名称-" + i);
            myClass.setRemark("备注信息如下-" + i);
            myClass.setStudentcount((int)(Math.random()*200));
            myClassMapper.insert(myClass);
        }
    }

    @Test
    void test3() {
        Admin admin = new Admin();
        admin.setLoginname("Gemini");
        admin.setPassword("06094619");
        adminMapper.insert(admin);
    }

}
