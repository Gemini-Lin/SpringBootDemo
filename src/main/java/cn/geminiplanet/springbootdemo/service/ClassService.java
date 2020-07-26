package cn.geminiplanet.springbootdemo.service;

import cn.geminiplanet.springbootdemo.common.domain.MyClass;
import cn.geminiplanet.springbootdemo.common.domain.MyClassExample;
import cn.geminiplanet.springbootdemo.mapper.MyClassMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private MyClassMapper myClassMapper;
    public PageInfo<MyClass> findClass(int pageNo,int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        MyClassExample myClassExample = new MyClassExample();
        List<MyClass> myClasses = myClassMapper.selectByExample(myClassExample);
        PageInfo<MyClass> pageInfo = new PageInfo<>(myClasses);
        return pageInfo;
    }
}
