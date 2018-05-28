package com.macaitech.codegenerator.sys.dao;

import com.macaitech.codegenerator.sys.model.User;
import com.macaitech.codegenerator.vo.QueryUserVo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User signIn(User user);

    Boolean existUserName(User user);

    int insert(User user);

    List<User> find(QueryUserVo vo);

    int deleteByIds(List<Integer> ids);

    User findById(Integer userId);

    User findWithPasswordById(Integer userId);

    int update(User user);

    int resetPassword(User user);
}
