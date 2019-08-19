package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.Tag;
import cn.ufan0.blog_test.mapper.TagMapper;
import cn.ufan0.blog_test.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public List<Tag> getTag() {
        return tagMapper.getTag();
    }

    @Override
    public void deleteTag(Integer id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }
}
