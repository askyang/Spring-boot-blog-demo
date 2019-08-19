package cn.ufan0.blog_test.entity;


import lombok.Data;

/**
 * mysql> desc tb_comment;
 * +----------------+----------------------+------+-----+-----------+----------------+
 * | Field          | Type                 | Null | Key | Default   | Extra          |
 * +----------------+----------------------+------+-----+-----------+----------------+
 * | id             | smallint(5) unsigned | NO   | PRI | NULL      | auto_increment |
 * | article_id     | smallint(5) unsigned | YES  |     | NULL      |                |
 * | time           | timestamp            | YES  |     | NULL      |                |
 * | nickname       | varchar(47)          | YES  |     | Anonymous |                |
 * | email          | varchar(257)         | YES  |     | NULL      |                |
 * | content        | text                 | YES  |     | NULL      |                |
 * | upvote_count   | smallint(5) unsigned | YES  |     | NULL      |                |
 * | downvote_count | smallint(5) unsigned | YES  |     | NULL      |                |
 * | ip             | varchar(15)          | YES  |     | NULL      |                |
 * | user_agent     | varchar(1024)        | YES  |     | NULL      |                |
 * +----------------+----------------------+------+-----+-----------+----------------+
 * 10 rows in set
 */
@Data
public class Comment {

    private Integer id;

    private String time;

    private String nickname;

    private String email;

    private String content;

    private Integer upvote_count;

    private Integer downvote_count;

    private String ip;

    private String user_agent;

}
