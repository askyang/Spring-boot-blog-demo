package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface TagMapper {

    /*
    若是多参数，应该使用注解 @Param
    @Insert("insert into tb_tag(title, description) values(#{name1.name}, #{name2.name})")
    void addTag(@Param("name1")Tag1 tag1, @Param("name2")Tag2 tag2);
    */
    @Insert("insert into tb_tag(title, description) values(#{title}, #{description})")
    void addTag(Tag tag);

    @Select("select * from tb_tag")
    List<Tag> getTag();

    @Delete("delete from tb_tag where id=#{id}")
    void deleteTag(Integer id);

    // @Update("update tb_tag set title = #{title}, description = #{description} where id = #{id}")
    @UpdateProvider(type = TagSqlBuilder.class, method = "buildUpdateTag")
    void updateTag(Tag tag);

    class TagSqlBuilder {
        public static String buildUpdateTag(final Tag tag) {
            // 使用字符串形式可能会被注入
            return new SQL() {{
                UPDATE("tb_tag");
                // 逻辑判断，在JDK12+可以使用 switch，更加简洁
                if (tag.getDescription() != null && !tag.getDescription().equals(""))
                    SET("description = #{description}");
                if (tag.getTitle() != null && !tag.getTitle().equals(""))
                    SET("title = #{title}");
                WHERE("id=#{id}");
            }}.toString();
        }
    }
}
