package cn.ufan0.blog_test.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * mysql> desc tb_article;
 * +------------------+-----------------------+------+-----+---------+----------------+
 * | Field            | Type                  | Null | Key | Default | Extra          |
 * +------------------+-----------------------+------+-----+---------+----------------+
 * | id               | smallint(6) unsigned  | NO   | PRI | NULL    | auto_increment |
 * | category_id      | smallint(6) unsigned  | YES  |     | NULL    |                |
 * | tag_id           | smallint(6) unsigned  | YES  |     | NULL    |                |
 * | comment_id       | smallint(6) unsigned  | YES  |     | NULL    |                |
 * | title            | varchar(47)           | YES  |     | NULL    |                |
 * | content          | mediumtext            | YES  |     | NULL    |                |
 * | create_time      | timestamp             | YES  |     | NULL    |                |
 * | last_update_time | timestamp             | YES  |     | NULL    |                |
 * | update_count     | smallint(6) unsigned  | YES  |     | NULL    |                |
 * | upvote_count     | smallint(6) unsigned  | YES  |     | NULL    |                |
 * | read_count       | mediumint(9) unsigned | YES  |     | NULL    |                |
 * | comment_count    | smallint(6) unsigned  | YES  |     | NULL    |                |
 * +------------------+-----------------------+------+-----+---------+----------------+
 * 12 rows in set
 */

@Data
public class Article {

    private Integer id;

    private String title;

    private String content;

    private String description;

    private Timestamp create_time;

    private Timestamp last_update_time;

    private Integer update_count;

    private Integer upvote_count;

    private Integer read_count;

    private Boolean status;

}
