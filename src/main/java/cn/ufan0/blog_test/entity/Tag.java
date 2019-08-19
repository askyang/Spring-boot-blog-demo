package cn.ufan0.blog_test.entity;

import lombok.Data;

/**
 * mysql> desc tb_tag;
 * +-------------+----------------------+------+-----+---------+----------------+
 * | Field       | Type                 | Null | Key | Default | Extra          |
 * +-------------+----------------------+------+-----+---------+----------------+
 * | id          | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
 * | title       | varchar(17)          | YES  |     | NULL    |                |
 * | description | varchar(140)         | YES  |     | NULL    |                |
 * +-------------+----------------------+------+-----+---------+----------------+
 * 3 rows in set (0.00 sec)
 */
@Data
public class Tag {

    private Integer id;

    private String title;

    private String description;

}
