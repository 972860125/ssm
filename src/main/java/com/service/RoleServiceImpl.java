package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.RoleMapper;
import com.domain.Role;
import com.service.RoleService;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Map> selectAllPermisAndByRoleidRermis() {
        return roleMapper.selectAllPermisAndByRoleidRermis();
    }
}
