package cn.ufan0.blog_test.mapper;

import cn.ufan0.blog_test.entity.Causerie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface CauserieMapper {

    /**
     * 后端接口，返回所有随笔
     */
    @Select("select * from tb_causerie")
    List<Causerie> getAllCauserie();

    /**
     * 前端接口，返回所有 status=true 的随笔
     */
    @Select("select * from tb_causerie where status = 1")
    List<Causerie> getAllPublicCauserie();

    @Select("select * from tb_causerie where id = #{id}")
    Causerie getCauserie(Integer id);

    @Insert("Insert into tb_causerie(content) values(#{content})")
    void addCauserie(Causerie causerie);

    @UpdateProvider(type = CauserieSqlBuilder.class, method = "buildUpdateCauserie")
    void updateCauserie(Causerie causerie);

    class CauserieSqlBuilder {
        public static String buildUpdateCauserie(final Causerie causerie) {
            return new SQL() {{
                UPDATE("tb_causerie");
                if (causerie.getContent()!= null && !causerie.getContent().equals(""))
                    SET("content = #{content}");
                if (causerie.getLast_update_time()!= null)
                    SET("last_update_time = #{last_update_time}");
                if (causerie.getStatus() != null)
                    SET("status = #{status}");
                WHERE("id=#{id}");
            }}.toString();
        }
    }

    @Delete("delete from tb_causerie where id=#{id}")
    void deleteCauserie(Integer id);
}
