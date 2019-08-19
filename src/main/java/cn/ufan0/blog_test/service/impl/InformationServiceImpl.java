package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.mapper.InformationMapper;
import cn.ufan0.blog_test.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public Integer getArticleCount() {
        return informationMapper.getArticleCount();
    }

    @Override
    public Integer getTagCount() {
        return informationMapper.getTagCount();
    }

    @Override
    public Integer getCategoryCount() {
        return informationMapper.getCategoryCount();
    }

    @Override
    public Integer getCauserieCount() {
        return informationMapper.getCauserieCount();
    }

    @Override
    public String getUserNickname() {
        return informationMapper.getUserNickname();
    }
}
