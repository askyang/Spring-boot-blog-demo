## 一个前后分离的博客系统半成品

代码介绍：[掘金：心心念念的博客计划，因为菜，导致计划流产了](https://juejin.im/post/5d5a6cade51d453b5f1a048d)

提供给与我一样的初学者，在这里你能参考：

- Spring Boot的简单开箱以及常见注解的使用
- Spring Security的基本配置
- Spring Thymeleaf的基本使用
- HikariCP的基本配置
- RESTful API设计风格
- MySQL的基本配置
- 基于注解的MyBatis简单使用

由于数据库及SQL语句尚未完成最终设计，以下组件并未使用。

- ElasticSearch
- EHcache
- Spring Security
- flexmark

### 建立数据表

- 文章表

```sql
create table tb_article
(
    id               smallint(6) unsigned auto_increment comment '文章主键'
        primary key,
    title            varchar(47) charset utf8mb4           not null comment '文章标题',
    description      text                                  null,
    upvote_count     smallint(6) default 0                 not null comment '文章点赞量',
    content          mediumtext charset utf8mb4            null comment '文章内容',
    update_count     smallint(6) default 0                 not null comment '文章更新次数',
    read_count       mediumint   default 0                 not null comment '文章阅读量',
    create_time      timestamp   default CURRENT_TIMESTAMP not null comment '文章创建时间',
    last_update_time timestamp   default CURRENT_TIMESTAMP not null comment '文章上次修改时间',
    status           tinyint(1)  default 1                 not null comment '文章状态'
)
    comment '文章信息' collate = utf8mb4_general_ci;
```

- 文章标签表

```sql
create table tb_tag
(
    id          smallint(5) unsigned auto_increment comment '标签主键'
        primary key,
    title       varchar(17) charset utf8mb4  not null comment '标签标题',
    description varchar(140) charset utf8mb4 null comment '标签描述',
    constraint title_UNIQUE
        unique (title)
)
    comment '文章标签信息' collate = utf8mb4_general_ci;
```

- 文章-标签中间表

```sql
create table tb_article_tag
(
    id         int auto_increment comment '中间表主键'
        primary key,
    article_id smallint(6) not null comment '文章id',
    tag_id     smallint(6) null comment '标签id'
)
    comment 'article_tag 多对多中间表';
```

- 文章分类表

```sql
create table tb_category
(
    id          smallint(6) unsigned auto_increment comment '分类主键'
        primary key,
    title       varchar(17)  not null comment '分类标题',
    description varchar(140) null comment '分类描述',
    constraint title_UNIQUE
        unique (title)
)
    comment '文章分类信息';
```

- 文章-分类中间表

```sql
create table tb_article_category
(
    id          int auto_increment comment '中间表主键'
        primary key,
    article_id  smallint(6) not null comment '文章id',
    category_id smallint(6) null comment '分类id'
)
    comment 'article_category 多对多查询中间表';
```

- 文章评论表

```sql
create table tb_comment
(
    id             smallint(5) unsigned auto_increment comment '评论主键'
        primary key,
    time           timestamp          null comment '评论时间',
    nickname       varchar(47)        not null comment '评论者昵称',
    email          varchar(257)       null comment '评论者邮箱',
    content        text               not null comment '评论内容',
    upvote_count   smallint default 0 not null comment '评论被赞量',
    downvote_count smallint default 0 not null comment '评论被踩量',
    ip             varchar(15)        null comment '评论者ip',
    user_agent     varchar(1024)      null comment '评论者'
)
    comment '文章评论信息';
```

- 文章-评论中间表

```sql
create table tb_article_comment
(
    id         int auto_increment comment '中间表主键'
        primary key,
    article_id smallint(6) not null comment '文章id',
    comment_id smallint(6) null comment '评论id'
)
    comment 'article_comment 多对多中间表';
```

- 随笔表

```sql
create table tb_causerie
(
    id               int auto_increment
        primary key,
    content          text                                 not null comment '随笔内容',
    create_time      timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    last_update_time timestamp  default CURRENT_TIMESTAMP not null comment '上次修改时间',
    status           tinyint(1) default 1                 not null comment '随笔状态'
)
    comment '随笔';
```

- 用户信息表

```sql
create table tb_user
(
    id            tinyint unsigned auto_increment comment '用户主键'
        primary key,
    username      varchar(47)   null comment '用户登录名',
    password      varchar(67)   null comment '用户密码',
    email         varchar(257)  null comment '用户邮箱',
    nickname      varchar(47)   null comment '用户昵称',
    profile_photo varchar(1024) null comment '用户头像地址',
    description   varchar(1024) null comment '用户描述'
)
    comment '用户信息';
```

- 站点资料表

```sql
create table tb_site
(
    id          tinyint unsigned auto_increment comment '主键'
        primary key,
    title       tinytext      null comment '站点标题',
    description tinytext      null comment '站点描述',
    logo        varchar(1024) null comment '站点logo地址',
    favicon     varchar(1024) null comment '站点favicon地址',
    footer      varchar(140)  null comment '站点页脚信息'
)
    comment '站点信息';
```
