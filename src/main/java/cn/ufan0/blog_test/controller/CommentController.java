package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Comment;
import cn.ufan0.blog_test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> getComment(@RequestParam("article_id") Integer article_id) {
        return commentService.getComment(article_id);
    }

    public void addComment(Integer article_id, Comment comment) {
        commentService.addComment(comment);
    }


}
