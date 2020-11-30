package com.lf.test.admin.config;

import cn.hutool.core.lang.Assert;
import com.lf.test.admin.common.JwtAuthenticationTokenFilter;
import com.lf.test.admin.common.RestAuthenestAuthenticationEntryPoint;
import com.lf.test.admin.common.RestfulAccessDeinidccessDeniedHandler;
import com.lf.test.admin.dto.AdminUserDetails;
import com.lf.test.admin.mbg.model.UmsAdmin;
import com.lf.test.admin.mbg.model.UmsPermission;
import com.lf.test.admin.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/11/26
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecturyConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private RestfulAccessDeinidccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 配置需要拦截的url路径、jwt过滤器及出异常后的处理器
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,        //允许对于网站静态资源的无授权访问
                        "/", "/*.html","favicon.icon","/**/*.html","/**/*.css","/**/*.js",
                        "/swagger-resources/**","/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login","/admin/register")      //对登录注册允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)        //跨域请求会先进行一次options请求
                .permitAll()
//                .antMatchers("/**")     //测试时全部放开
//                .permitAll()
                .anyRequest()       //除上面外的所有请求全部需要鉴权认证
                .authenticated();
        //禁用缓存
        httpSecurity.headers().cacheControl();
        //添加JWT 过滤器filter
        httpSecurity.addFilterBefore(this.jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    /**
     * 在用户名和密码校验前添加的过滤器，如果有token信息，会自行根据token信息进行登录
     * @return
     * @throws Exception
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception{
        return new JwtAuthenticationTokenFilter();
    }

    /**
     * 配置UserDetailsService 和 PasswordEncoder
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    /**
     * SpringSecurty编码比对密码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        //获取登录用户信息
        return username->{
            UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
            Assert.notNull(umsAdmin,"用户名不存在!");
            List<UmsPermission> permissionList = umsAdminService.getPermissionList(umsAdmin.getId());
            return new AdminUserDetails(umsAdmin,permissionList);
        };
    }
}
