package cn.ufan0.blog_test.entity;

import lombok.Data;

/**
 * mysql> desc tb_category;
 * +-------------+----------------------+------+-----+---------+----------------+
 * | Field       | Type                 | Null | Key | Default | Extra          |
 * +-------------+----------------------+------+-----+---------+----------------+
 * | id          | smallint(6) unsigned | NO   | PRI | NULL    | auto_increment |
 * | title       | varchar(17)          | YES  | UNI | NULL    |                |
 * | description | varchar(140)         | YES  |     | NULL    |                |
 * +-------------+----------------------+------+-----+---------+----------------+
 * 3 rows in set
 */
@Data
public class Category {

    private Integer id;

    private String title;

    private String description;

}
