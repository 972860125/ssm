package com.service;

import com.domain.Permis;

import java.util.List;

public interface PermisService{


    int deleteByPrimaryKey(Integer id);

    int insert(Permis record);

    int insertSelective(Permis record);

    Permis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permis record);

    int updateByPrimaryKey(Permis record);

    /**
     * 根据parent的值获取permistype为1的菜单
     * @param permis
     * @return
     */
    List<Permis> selectPermisByParent(Permis permis);

}
