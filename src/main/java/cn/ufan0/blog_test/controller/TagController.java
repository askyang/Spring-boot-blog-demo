package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Tag;
import cn.ufan0.blog_test.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

// @RestController = @ResponseBody + @Controller
@RestController
@RequestMapping("/api")
public class TagController {

    @RequestMapping("")
    public String api() {
        return "api";
    }

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public Object getTag() {
        return tagService.getTag();
    }

    @Secured("ROLE_USER")
    @PostMapping("/tag")
    public void addTag(Tag tag) {
        if (tag.getTitle() != null && !tag.getTitle().equals("")) {
            tagService.addTag(tag);
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/tag")
    public void deleteTag(Integer id) {
        if (id != null) {
            tagService.deleteTag(id);
        }
    }

    @Secured("ROLE_USER")
    @PutMapping("/tag")
    public void updateTag(Tag tag) {
        // 当且仅当 tag.id 存在 , tag.title 和 tag.description 任一不为 null 时才执行更新操作
        if (tag.getId() != null && (tag.getTitle() != null || tag.getDescription() != null)) {
            tagService.updateTag(tag);
        }
    }
}
