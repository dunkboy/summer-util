package org.poor.framework.test.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.poor.framework.test.domain.MyUser;
import org.poor.framework.test.dao.MyUserMapper;
import org.poor.framework.test.service.MyUserService;

@Service
public class MyUserServiceImpl implements MyUserService{

    @Resource
    private MyUserMapper myUserMapper;

    @Override
    public int insert(MyUser myUser){
        return myUserMapper.insert(myUser);
    }

    @Override
    public int insertSelective(MyUser myUser){
        return myUserMapper.insertSelective(myUser);
    }

    @Override
    public int insertList(List<MyUser> myUsers){
        return myUserMapper.insertList(myUsers);
    }

    @Override
    public int update(MyUser myUser){
        return myUserMapper.update(myUser);
    }
}
