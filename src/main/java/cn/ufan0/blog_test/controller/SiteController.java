package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Site;
import cn.ufan0.blog_test.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping("/site")
    public Site getSite() {
        return siteService.getSite();
    }

    @Secured("ROLE_USER")
    @PutMapping("/site")
    public void update(Site site) {
        if (site.getTitle() != null || site.getLogo() != null || site.getFooter() != null || site.getFavicon() != null || site.getDescription() != null) {
            siteService.updateSite(site);
        }
    }
}
