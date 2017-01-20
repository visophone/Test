package com.utsoft.cc.test.baserecyclerviewadapterhelper;

/**
 * Created by 周玉明 on 2017/1/16.
 * Function 用户实体类
 * Desc
 */

public class UserEntity {
    private String name;    //用户姓名
    private int id;         //用户id
    private String icon;    //用户的图片

    public UserEntity(String name, int id, String icon) {
        this.name = name;
        this.id = id;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
