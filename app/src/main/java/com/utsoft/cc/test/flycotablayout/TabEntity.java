package com.utsoft.cc.test.flycotablayout;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by 周玉明 on 2017/1/13.
 * Function: Tab实体类
 * Desc:
 */

public class TabEntity implements CustomTabEntity {
    public String title;    //标题
    public int selectedIcon;    //选中时的图片
    public int unSelectedIcon;  //为选中时的图片

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
