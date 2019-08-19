package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Site;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface SiteMapper {

    @Select("select title, description, logo, favicon, footer from tb_site")
    Site getSite();

    // 动态注解 http://www.mybatis.org/mybatis-3/zh/java-api.html
    // 不允许插入空值和 NULL
    @UpdateProvider(type = UserSqlBuilder.class, method = "buildUpdateSite")
    void updateSite(Site site);

    class UserSqlBuilder {
        public static String buildUpdateSite(final Site site) {
            // 使用字符串形式可能会被注入
            return new SQL() {{
                UPDATE("tb_site");
                // 逻辑判断，在JDK12+可以使用 switch，更加简洁
                if (site.getDescription() != null && !site.getDescription().equals(""))
                    SET("description = #{description}");
                if (site.getFavicon() != null && !site.getFavicon().equals(""))
                    SET("favicon = #{favicon}");
                if (site.getFooter() != null && !site.getFooter().equals(""))
                    SET("footer = #{footer}");
                if (site.getLogo() != null && !site.getLogo().equals(""))
                    SET("logo = #{logo}");
                if (site.getTitle() != null && !site.getTitle().equals(""))
                    SET("title = #{title}");
                WHERE("id=1");
            }}.toString();
        }
    }

}
