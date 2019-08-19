package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class InformationController {

    @Autowired
    private InformationService informationService;

    // @CrossOrigin
    @GetMapping("/information")
    public HashMap getInformation() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_nickname", informationService.getUserNickname());
        hashMap.put("article_count", informationService.getArticleCount());
        hashMap.put("causerie_count", informationService.getCauserieCount());
        hashMap.put("tag_count", informationService.getTagCount());
        hashMap.put("category_count", informationService.getCategoryCount());

        return hashMap;
    }
}
