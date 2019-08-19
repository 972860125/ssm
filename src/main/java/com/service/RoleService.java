package com.service;

import com.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService{


    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    List<Map> selectAllPermisAndByRoleidRermis();
}
