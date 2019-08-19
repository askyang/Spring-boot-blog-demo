package cn.ufan0.blog_test.service;

import cn.ufan0.blog_test.entity.Causerie;

import java.util.List;

public interface CauserieService {

    List<Causerie> getAllCauserie();

    List<Causerie> getAllPublicCauserie();

    Causerie getCauserie(Integer id);

    void addCauserie(Causerie causerie);

    void updateCauserie(Causerie causerie);

    void deleteCauserie(Integer id);

}
