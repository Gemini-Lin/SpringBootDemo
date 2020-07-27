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

    public PageInfo<MyClass> findClass(int pageNo,int pageSize,MyClass myClass){
        PageHelper.startPage(pageNo,pageSize);
        MyClassExample myClassExample = new MyClassExample();
        if(myClassExample != null){
            MyClassExample.Criteria criteria = myClassExample.createCriteria();
            if(myClass.getName()!=null && myClass.getName().trim().length()>0){
                criteria.andNameLike("%"+myClass.getName()+"%");
            }
            if(myClass.getRemark()!=null && myClass.getRemark().trim().length()>0){
                criteria.andRemarkLike("%"+myClass.getRemark()+"%");
            }
        }
        List<MyClass> myClasses = myClassMapper.selectByExample(myClassExample);
        PageInfo<MyClass> pageInfo = new PageInfo<>(myClasses);
        return pageInfo;
    }

    public int removeClass(Integer... ids) {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = myClassMapper.deleteByPrimaryKey(id);
                count = count + i;
            }
        }
        return count;
    }

    /**
     *
     * @param myClass
     * @return
     */
    public int addClass(MyClass myClass) {
        return myClassMapper.insert(myClass);
    }

    public MyClass findClassById(Integer id) {
        return myClassMapper.selectByPrimaryKey(id);
    }

    public int updateClass(MyClass myClass) {
        return myClassMapper.updateByPrimaryKeySelective(myClass);
    }
}

