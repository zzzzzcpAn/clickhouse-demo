package com.example.clickhousedemo.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 16:25
 * @description Mybatis TyperHandler
 */
public class UidsTyperHanlder extends BaseTypeHandler<List<Integer>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getIntegers(rs.getString(columnName));
    }

    private List<Integer> getIntegers(String strs) {
        if (strs != null && !strs.isEmpty()){
            List<Integer> collect = Arrays.stream(strs.substring(1, strs.length() - 1).split(","))
                    .map(str -> Integer.valueOf(str))
                    .collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        return getIntegers(rs.getString(columnIndex));
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getIntegers(cs.getString(columnIndex));
    }
}
