package com.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mapper.PermisMapper;
import com.domain.Permis;
import com.service.PermisService;

import java.util.List;

@Service
public class PermisServiceImpl implements PermisService{

    @Resource
    private PermisMapper permisMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return permisMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Permis record) {
        return permisMapper.insert(record);
    }

    @Override
    public int insertSelective(Permis record) {
        return permisMapper.insertSelective(record);
    }

    @Override
    public Permis selectByPrimaryKey(Integer id) {
        return permisMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Permis record) {
        return permisMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permis record) {
        return permisMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据parent的值获取permistype为1的菜单
     *
     * @param permis
     * @return
     */
    @Override
    public List<Permis> selectPermisByParent(Permis permis) {
        return permisMapper.select(permis);
    }
}
