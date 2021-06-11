package com.example.clickhousedemo;

import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.ClickHouseStatement;
import ru.yandex.clickhouse.settings.ClickHouseProperties;
import ru.yandex.clickhouse.settings.ClickHouseQueryParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 15:28
 * @description
 */
public class ClickHouseDemo1 {

    public static void main(String[] args) {

        String url = "jdbc:clickhouse://node01:8123/test";
        ClickHouseProperties properties = new ClickHouseProperties();
        // set connection options - see more defined in ClickHouseConnectionSettings
        properties.setClientName("Agent #1");

        // set default request options - more in ClickHouseQueryParam
        properties.setSessionId("default-session-id");

        ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);
        String sql = "select * from mytable";
        Map<ClickHouseQueryParam, String> additionalDBParams = new HashMap<>();
        // set request options, which will override the default ones in ClickHouseProperties
        additionalDBParams.put(ClickHouseQueryParam.SESSION_ID, "new-session-id");
        try (ClickHouseConnection conn = dataSource.getConnection();
            ClickHouseStatement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql, additionalDBParams)) {


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
