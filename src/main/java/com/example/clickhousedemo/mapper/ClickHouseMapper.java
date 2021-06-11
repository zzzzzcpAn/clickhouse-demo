package com.example.clickhousedemo.mapper;

import com.example.clickhousedemo.domain.TagUsersMap;
import com.example.clickhousedemo.domain.User;
import com.example.clickhousedemo.typeHandler.UidsTyperHanlder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 15:46
 * @description
 */
@Mapper
public interface ClickHouseMapper {


    @Select("select id, name, age from t_test")
    @Results(
            id = "map1",
            value = {
                @Result(column = "id", property = "id"),
                @Result(column = "name", property = "name"),
                @Result(column = "age", property = "age")
            }
    )
    List<User> select();


    @Select("with " +
            " (select uids from t_tag_users_map where tag_id=1) as tag1, " +
            " (select uids from t_tag_users_map where tag_id=2) as tag2 " +
            "select bitmapToArray(bitmapAnd(tag1, tag2)) as res")
    @Results(
            value = {
                @Result(column = "res", property = "uids", typeHandler = UidsTyperHanlder.class)
            }
    )
    List<TagUsersMap> selectWithTags(@Param("tag1") Integer tag1, @Param("tag2") Integer tag2);

}
