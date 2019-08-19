package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into tb_category(title, description) values(#{title}, #{description})")
    void addCategory(Category category);

    @Select("select * from tb_category")
    List<Category> getCategory();

    @Delete("delete from tb_category where id=#{id}")
    void deleteCategory(Integer id);

    @UpdateProvider(type = CategorySqlBuilder.class, method = "buildUpdateCategory")
    void updateCategory(Category category);

    class CategorySqlBuilder {
        public static String buildUpdateCategory(final Category category) {
            return new SQL() {{
                UPDATE("tb_category");
                if (category.getDescription() != null && !category.getDescription().equals(""))
                    SET("description = #{description}");
                if (category.getTitle() != null && !category.getTitle().equals(""))
                    SET("title = #{title}");
                WHERE("id=#{id}");
            }}.toString();
        }
    }

}
