package com.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.domain.Section;
import com.mapper.SectionMapper;
import com.service.SectionService;
@Service
public class SectionServiceImpl implements SectionService{

    @Resource
    private SectionMapper sectionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Section record) {
        return sectionMapper.insert(record);
    }

    @Override
    public int insertSelective(Section record) {
        return sectionMapper.insertSelective(record);
    }

    @Override
    public Section selectByPrimaryKey(Integer id) {
        return sectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Section record) {
        return sectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Section record) {
        return sectionMapper.updateByPrimaryKey(record);
    }

}
