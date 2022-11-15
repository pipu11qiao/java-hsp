package org.example;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.service.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource("jdbc.properties")
public class AppConfig {

    @Value("${jdbc.url}")
    String jdbcUrl;

    @Value("${jdbc.username}")
    String jdbcUsername;

    @Value("${jdbc.password}")
    String jdbcPassword;

    // 创建一个DataSource实例，它的实际类型是HikariDataSource,创建时需要用到注入的配置
    @Bean
    DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        System.out.println("jdbcUrl");
        System.out.println(jdbcUrl);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        config.addDataSourceProperty("autoCommit", "true");
        config.addDataSourceProperty("connectionTimeout", "5");
        config.addDataSourceProperty("idleTimeout", "60");
        return new HikariDataSource(config);
    }

    // 创建一个JdbcTemplate实例,需要注入DataSource实例
    @Bean
    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        System.out.println(dataSource);
        System.out.println("-----");
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.getUserById(1);
        System.out.println(user.getName());
    }

}
