package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 前端页面接口：调取文章评论
     *
     * @param article_id 指定文章 id
     * @return 返回对应文章所有评论，（评论数量/内容/昵称/等非敏感基本内容）
     */
    @Select("select count(*), time, nickname, content, upvote_count, downvote_count\n" +
            "from tb_comment\n" +
            "where id\n" +
            "          in (\n" +
            "          select comment_id\n" +
            "          from tb_article_comment\n" +
            "          where article_id = #{article_id}\n" +
            "      )")
    List<Comment> getComment(Integer article_id);

    /**
     * 前端页面接口：插入新评论
     *
     * @param comment 要插入的评论内容
     */
    @Insert("insert into tb_comment(time, nickname, email, content, upvote_count, downvote_count, ip, user_agent) values(#{time}, #{nickname}, #{email}, #{content}, #{upvote_count}, #{downvote_count}, #{ip}, #{user_agent})")
    void addComment(Comment comment);

}
