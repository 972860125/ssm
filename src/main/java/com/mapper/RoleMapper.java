package com.mapper;

import com.domain.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {
    List<Map> selectAllPermisAndByRoleidRermis();
}