package cn.ufan0.blog_test.service.impl;


import cn.ufan0.blog_test.entity.Comment;
import cn.ufan0.blog_test.mapper.CommentMapper;
import cn.ufan0.blog_test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(Integer article_id) {
        return commentMapper.getComment(article_id);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }
}
