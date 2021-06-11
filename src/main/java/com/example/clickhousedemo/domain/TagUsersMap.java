package com.example.clickhousedemo.domain;

import lombok.Data;

import java.util.List;

/**
 * @author zhouchuanpei
 * @date 2021/6/11 16:09
 * @description
 */
@Data
public class TagUsersMap {

    private Integer tagId;
    private List<Integer> uids;

}
