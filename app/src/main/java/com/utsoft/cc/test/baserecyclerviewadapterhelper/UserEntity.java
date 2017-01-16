package com.utsoft.cc.test.baserecyclerviewadapterhelper;

/**
 * Created by 周玉明 on 2017/1/16.
 * Function 用户实体类
 * Desc
 */

public class UserEntity {
    private String name;    //用户姓名
    private int id;         //用户id

    public UserEntity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
