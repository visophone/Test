package com.utsoft.cc.test.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 周玉明 on 2017/1/17.
 * Function
 * Desc
 */
@Entity
public class UserEntity {

    @Id
    private long id;
    private String name;
    @Transient
    private int tempUsageCount;

    @Generated(hash = 1611124801)
    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1433178141)
    public UserEntity() {
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

    public int getTempUsageCount() {
        return tempUsageCount;
    }

    public void setTempUsageCount(int tempUsageCount) {
        this.tempUsageCount = tempUsageCount;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
