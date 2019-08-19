package cn.ufan0.blog_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// https://docs.spring.io/spring-security/site/docs/current/reference/html5/#jc-method
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        /*
         * 取消csrf防护，否则需要追加Token，不然会导致403
         * https://segmentfault.com/q/1010000012743613
         */
        http.csrf().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                // 生产环境不应该保存明文密码
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("1")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}