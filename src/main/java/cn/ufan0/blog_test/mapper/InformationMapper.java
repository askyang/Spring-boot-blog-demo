package cn.ufan0.blog_test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InformationMapper {

    @Select("select count(id) from tb_article")
    Integer getArticleCount();

    @Select("select count(id) from tb_tag")
    Integer getTagCount();

    @Select("select count(id) from tb_category")
    Integer getCategoryCount();

    @Select("select count(id) from tb_causerie")
    Integer getCauserieCount();

    @Select("select nickname from tb_user")
    String getUserNickname();

}
