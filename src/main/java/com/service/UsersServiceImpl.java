package com.service;

import com.domain.Permis;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.UsersMapper;
import com.domain.Users;
import com.service.UsersService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public Users selectOne(Users users) {
        return usersMapper.selectOne(users);
    }

    /**
     * 根据用户Id获取用户的角色集合
     *
     * @param users
     * @return
     */
    @Override
    public Set<String> selectRoleByUserId(Users users) {
        users = usersMapper.selectByIds(users); //根据用户id获取用户对象，里面包含用户对应的部门id、公司id
        return usersMapper.selectRoleByUserId(users);//根据用户id、部门id、公司id获取用户的角色集合

    }

    /**
     * 根据用户id获取用户的权限集合
     *
     * @param users
     * @return
     */
    @Override
    public Set<String> selectPermisByUsersId(Users users) {
        users = usersMapper.selectByIds(users);//根据用户id获取用户对象，里面包含用户对应的部门id、公司id
        List<Permis> permisList = usersMapper.selectPermisByUsersId(users, null);//获取用户所有的集合
        Set<String> permisSet = new HashSet<>();
        for (Permis permis : permisList) {
            permisSet.add(permis.getPermisname());
        }
        return permisSet;
    }

    /**
     * 根据用户id获取用户的权限集合
     *
     * @param users
     * @return
     */
    @Override
    public List<Permis> selectPermisByUsersId2(Users users) {
        users = usersMapper.selectByIds(users);//根据用户id获取用户对象，里面包含用户对应的部门id、公司id
        List<Permis> permisList = usersMapper.selectPermisByUsersId(users, 1);//获取用户所有的集合
        return permisList;
    }
}

