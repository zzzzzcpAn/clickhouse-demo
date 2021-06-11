package com.example.clickhousedemo;

import com.example.clickhousedemo.domain.User;
import com.example.clickhousedemo.mapper.ClickHouseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 15:45
 * @description
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Test1 {

    @Autowired
    private ClickHouseMapper mapper;

    @Test
    public void test1(){
        List<User> users = mapper.select();

        System.out.println(users);
    }


    @Test
    public void test2(){

        System.out.println(mapper.selectWithTags(1, 2));
    }

}
