package cn.ufan0.blog_test.entity;

import lombok.Data;

/**
 * mysql> desc tb_site;
 * +-------------+---------------------+------+-----+---------+----------------+
 * | Field       | Type                | Null | Key | Default | Extra          |
 * +-------------+---------------------+------+-----+---------+----------------+
 * | id          | tinyint(3) unsigned | NO   | PRI | NULL    | auto_increment |
 * | title       | tinytext            | YES  |     | NULL    |                |
 * | description | tinytext            | YES  |     | NULL    |                |
 * | logo        | varchar(1024)       | YES  |     | NULL    |                |
 * | favicon     | varchar(1024)       | YES  |     | NULL    |                |
 * | footer      | varchar(140)        | YES  |     | NULL    |                |
 * +-------------+---------------------+------+-----+---------+----------------+
 * 6 rows in set
 */
@Data
public class Site {

    // private Integer id;

    private String title;

    private String description;

    private String logo;

    private String favicon;

    private String footer;

}
