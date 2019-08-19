package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.Site;
import cn.ufan0.blog_test.mapper.SiteMapper;
import cn.ufan0.blog_test.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public void updateSite(Site site) {
        siteMapper.updateSite(site);
    }

    @Override
    public Site getSite() {
        return siteMapper.getSite();
    }
}
