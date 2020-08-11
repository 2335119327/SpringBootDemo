package com.dong.secrity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dong
 * @date 2020/8/11 10:55
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //定制授权规则
        //antMatchers 路径匹配
        //hasRole() 设置角色
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动登录功能
//        http.formLogin();

        //自定义登录页
        //默认post形式的 /login代表处理登录
        //一旦定制loginPage，那么loginPage的post请求就是登录请求
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");

        //1、/login来打登录页
        //2、重定向到/login?error表示的登录失败


        //开启自动配置的注销功能
        //logoutSuccessUrl("/" ：注销成功后回到首页
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能
        //登陆成功后，将cookie发给浏览器保存，以后访问带上这个cookie，只要通过检查就可以免登录
        //注销后会删除cookie
//        http.rememberMe();

        //自定义界面
        http.rememberMe().rememberMeParameter("rember");
    }


    //密码编码 passwordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //定义认证规则
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2","VIP3");
    }
}
