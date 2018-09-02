package org.poor.framework.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.poor.framework.test.domain.MyUser;

@Mapper
public interface MyUserMapper {
    int insert(@Param("myUser") MyUser myUser);

    int insertSelective(@Param("myUser") MyUser myUser);

    int insertList(@Param("myUsers") List<MyUser> myUsers);

    int update(@Param("myUser") MyUser myUser);
}
