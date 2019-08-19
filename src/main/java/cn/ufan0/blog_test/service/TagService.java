package cn.ufan0.blog_test.service;

import cn.ufan0.blog_test.entity.Tag;

import java.util.List;

public interface TagService {

    void addTag(Tag tag);

    List<Tag> getTag();

    void deleteTag(Integer id);

    void updateTag(Tag tag);
}
