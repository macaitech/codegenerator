package com.macaitech.codegenerator.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.macaitech.codegenerator.sys.model.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findUserMenuList(int userId);

    List<Menu> findAllMenu();

    List<Menu> findRoleMenu(Integer roleId);

    Boolean existMenuName(Menu menu);

    Boolean existMenuCode(Menu menu);

    int insert(Menu menu);

    int findMaxMenuIndex();

    int deleteChildren(Integer menuId);

    int delete(Integer menuId);

    Menu findPreviousMenu(Integer menuId);

    Menu findNextMenu(Integer menuId);

    Menu findById(Integer menuId);

    int update(Menu menu);

}
