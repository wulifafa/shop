package com.lf.test.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

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
@MapperScan(basePackages = {"com.lf.test.admin.mbg.mapper","com.lf.test.admin.dao"})
public class MybatisConfig {
}
