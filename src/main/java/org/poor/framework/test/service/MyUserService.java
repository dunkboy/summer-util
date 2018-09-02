package org.poor.framework.test.service;

import java.util.List;
import org.poor.framework.test.domain.MyUser;
public interface MyUserService{

    int insert(MyUser myUser);

    int insertSelective(MyUser myUser);

    int insertList(List<MyUser> myUsers);

    int update(MyUser myUser);
}
