package com.service;

import com.domain.Permis;
import com.domain.Users;

import java.util.List;
import java.util.Set;

public interface UsersService {


    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectOne(Users users);

    /**
     * 根据用户Id获取用户的角色集合
     *
     * @param users
     * @return
     */
    Set<String> selectRoleByUserId(Users users);

    /**
     * 根据用户id获取用户的权限集合
     *
     * @param users
     * @return
     */
    Set<String> selectPermisByUsersId(Users users);

    /**
     * 根据用户id获取用户的权限集合
     *
     * @param users
     * @return
     */
    List<Permis> selectPermisByUsersId2(Users users);

}
