package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 后端接口，展示所有文章
     */
    @Select("select id, title, description, create_time, last_update_time, read_count, status from tb_article")
    List<Article> getAllArticle();

    /**
     * 前端接口，展示所有公开文章
     */
    @Select("select id, title, description, create_time, last_update_time, read_count, status from tb_article where status = 1")
    List<Article> getAllPublicArticle();

    /**
     * @param id 文章id
     * @return 指定id所对应文章的全部信息
     */
    @Select("select * from tb_article where id = #{id}")
    Article getArticle(Integer id);

    /**
     * 删除文章
     *
     * @param id 文章id
     */
    @Delete("delete from tb_article where id = #{id}")
    void deleteArticle(Integer id);

    /**
     * @param article 新增的文章
     */
    @Insert("insert into tb_article(title, description, content) values(#{title}, #{description}, #{content}")
    void insertArticle(Article article);

    /**
     * 后期记得配置缓存，否则容易造成数据库很大压力
     *
     * @param id 阅读的文章id
     */
    @Update("update tb_article set read_count = read_count+1 where id = #{id}")
    void updateArticleRead_Count(Integer id);

    /**
     * @param article 需要修改的文章
     */
    @UpdateProvider(type = ArticleSqlBuilder.class, method = "buildUpdateArticle")
    void updateArticle(Article article);

    class ArticleSqlBuilder {
        public static String buildUpdateArticle(final Article article) {
            // 使用字符串形式可能会被注入
            return new SQL() {{
                UPDATE("tb_article");
                // 逻辑判断，在JDK12+可以使用 switch，更加简洁
                if (article.getTitle() != null && !article.getTitle().equals(""))
                    SET("title = #{title}");
                if (article.getDescription() != null && !article.getDescription().equals(""))
                    SET("description = #{description}");
                if (article.getContent() != null && !article.getContent().equals(""))
                    SET("content = #{content}");
                if (article.getLast_update_time() != null)
                    SET("last_update_time = #{last_update_time}");
                if (article.getUpdate_count() != null)
                    SET("update_count = #{update_count}");
                if (article.getStatus() != null)
                    SET("status = #{status}");
                WHERE("id=#{id}");
            }}.toString();
        }
    }

}
