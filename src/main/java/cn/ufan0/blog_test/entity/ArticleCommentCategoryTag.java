package cn.ufan0.blog_test.entity;

import lombok.Data;

/**
 * mysql> desc tb_article_comment_category_tag;
 * +-------------+-------------+------+-----+---------+----------------+
 * | Field       | Type        | Null | Key | Default | Extra          |
 * +-------------+-------------+------+-----+---------+----------------+
 * | id          | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | article_id  | smallint(6) | NO   |     | NULL    |                |
 * | comment_id  | smallint(6) | YES  |     | NULL    |                |
 * | category_id | smallint(6) | YES  |     | NULL    |                |
 * | tag_id      | smallint(6) | YES  |     | NULL    |                |
 * +-------------+-------------+------+-----+---------+----------------+
 * 5 rows in set
 */
@Data
public class ArticleCommentCategoryTag {

    private Integer id;

    private Integer article_id;

    private Integer comment_id;

    private Integer category_id;

    private Integer tag_id;

    public Integer getId() {
        return id;
    }

}
