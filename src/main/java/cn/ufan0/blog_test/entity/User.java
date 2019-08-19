package cn.ufan0.blog_test.entity;

import lombok.Data;

/**
 * mysql> desc tb_user;
 * +---------------+---------------------+------+-----+---------+----------------+
 * | Field         | Type                | Null | Key | Default | Extra          |
 * +---------------+---------------------+------+-----+---------+----------------+
 * | id            | tinyint(3) unsigned | NO   | PRI | NULL    | auto_increment |
 * | username      | varchar(47)         | YES  |     | NULL    |                |
 * | password      | varchar(47)         | YES  |     | NULL    |                |
 * | email         | varchar(257)        | YES  |     | NULL    |                |
 * | nickname      | varchar(47)         | YES  |     | NULL    |                |
 * | profile_photo | varchar(1024)       | YES  |     | NULL    |                |
 * | description   | varchar(1024)       | YES  |     | NULL    |                |
 * +---------------+---------------------+------+-----+---------+----------------+
 * 7 rows in set
 */
@Data
public class User {

    // private Integer id;

    private String username;

    private String password;

    private String email;

    private String nickname;

    private String profile_photo;

    private String description;

}
