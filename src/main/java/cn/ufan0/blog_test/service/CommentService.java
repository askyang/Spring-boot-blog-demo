package cn.ufan0.blog_test.service;

import cn.ufan0.blog_test.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComment(Integer article_id);

    void addComment(Comment comment);

}
