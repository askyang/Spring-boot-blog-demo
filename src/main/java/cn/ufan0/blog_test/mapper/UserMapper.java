package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface UserMapper {

    @Select("select username, email, nickname, profile_photo, description from tb_user")
    User getUser();

    @UpdateProvider(type = UserSqlBuilder.class, method = "buildUpdateUser")
    void updateUser(User user);

    class UserSqlBuilder {
        public static String buildUpdateUser(final User user) {
            return new SQL() {{
                UPDATE("tb_user");
                if (user.getUsername() != null && !user.getUsername().equals(""))
                    SET("username = #{username}");
                if (user.getPassword() != null && !user.getPassword().equals(""))
                    SET("password = #{password}");
                if (user.getProfile_photo() != null && !user.getProfile_photo().equals(""))
                    SET("profile_photo = #{profile_photo}");
                if (user.getEmail() != null && !user.getEmail().equals(""))
                    SET("email = #{email}");
                if (user.getNickname() != null && !user.getNickname().equals(""))
                    SET("nickname = #{nickname}");
                if (user.getDescription() != null && !user.getDescription().equals(""))
                    SET("description = #{description}");
                WHERE("id=1");
            }}.toString();
        }
    }
}