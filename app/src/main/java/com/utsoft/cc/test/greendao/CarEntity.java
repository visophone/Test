package com.utsoft.cc.test.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 周玉明 on 2017/1/17.
 * Function 汽车实体类
 * Desc
 */
@Entity
public class CarEntity {

    @Id
    private long id;
    private String name;

    @Generated(hash = 1104257666)
    public CarEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1313569821)
    public CarEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
