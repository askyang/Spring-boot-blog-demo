package cn.ufan0.blog_test.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Causerie {

    private Integer id;

    private String Content;

    private Timestamp create_time;

    private Timestamp last_update_time;

    private Boolean status;

}
