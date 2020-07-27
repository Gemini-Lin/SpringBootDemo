package cn.geminiplanet.springbootdemo.service;

import cn.geminiplanet.springbootdemo.common.domain.Admin;
import cn.geminiplanet.springbootdemo.common.domain.AdminExample;
import cn.geminiplanet.springbootdemo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin login(Admin admin){
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andLoginnameEqualTo(admin.getLoginname().trim());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        return adminList.size()>0?adminList.get(0):null;
    }
}