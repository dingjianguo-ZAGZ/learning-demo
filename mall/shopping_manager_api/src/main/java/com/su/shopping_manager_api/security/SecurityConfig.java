package com.su.shopping_manager_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.text.Normalizer;

/**
 * security配置类
 */
@Configuration
//开启鉴权配置
@EnableMethodSecurity
public class SecurityConfig {
    //springSecurity配置
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //自定义登录表单
        http.formLogin(
            form -> {
                form.usernameParameter("username")//用户名项
                        .passwordParameter("password")//密码项
                        .loginProcessingUrl("/admin/login")//登录提交路径
                        .successHandler(new MyLoginSuccessHandler())//登录成功处理器
                        .failureHandler(new MyLoginFailureHandler());//登录失败处理器
            }
        );
        //权限认证
        http.authorizeHttpRequests(
                resp -> {
                    resp.requestMatchers("/login","/admin/login").permitAll();//登录不用认证
                    resp.anyRequest().authenticated();//其他请求都需要认证
                }
        );
        //退出登录配置
        http.logout(
             logout -> {
                 logout.logoutUrl("/admin/logout")//退出登录路径
                         .logoutSuccessHandler(new MyLogoutSuccessHandler())//退出登录处理器
                         .clearAuthentication(true)//清楚缓存认证信息
                         .invalidateHttpSession(true);//清除session
             }
        );
        //异常配置
        http.exceptionHandling(
                exception -> {
                    exception.authenticationEntryPoint(new MyAuthenticationEntryPoint())//异常处理器
                            .accessDeniedHandler(new MyAccessDeniedHandler());//权限不足处理器
                }
        );
        //跨域访问
        http.cors();

        //关闭csrf防护
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    //对管理员的密码加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
