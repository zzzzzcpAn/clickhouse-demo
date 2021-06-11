package com.example.clickhousedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import javax.sql.DataSource;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 15:40
 * @description
 */
@Configuration
public class ClickHouseConfig {


    @Bean
    public DataSource clickHouseDataSource(){
        String url = "jdbc:clickhouse://node01:8123/testdb";
        ClickHouseProperties properties = new ClickHouseProperties();
        // set connection options - see more defined in ClickHouseConnectionSettings
        properties.setClientName("Agent #1");

        // set default request options - more in ClickHouseQueryParam
        properties.setSessionId("default-session-id");

        ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);

        return dataSource;
    }

}
