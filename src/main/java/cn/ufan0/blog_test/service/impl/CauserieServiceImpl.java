package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.Causerie;
import cn.ufan0.blog_test.mapper.CauserieMapper;
import cn.ufan0.blog_test.service.CauserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CauserieServiceImpl implements CauserieService {

    @Autowired
    private CauserieMapper causerieMapper;

    @Override
    public List<Causerie> getAllCauserie() {
        return causerieMapper.getAllCauserie();
    }

    @Override
    public List<Causerie> getAllPublicCauserie() {
        return causerieMapper.getAllPublicCauserie();
    }

    @Override
    public Causerie getCauserie(Integer id) {
        return causerieMapper.getCauserie(id);
    }

    @Override
    public void addCauserie(Causerie causerie) {
        causerieMapper.addCauserie(causerie);
    }

    @Override
    public void updateCauserie(Causerie causerie) {
        causerieMapper.updateCauserie(causerie);
    }

    @Override
    public void deleteCauserie(Integer id) {
        causerieMapper.deleteCauserie(id);
    }
}
