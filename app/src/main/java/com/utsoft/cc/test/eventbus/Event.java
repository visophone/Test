package com.utsoft.cc.test.eventbus;

/**
 * Created by 周玉明 on 2017/1/13.
 * Function:传递的事件
 * Desc:
 */

public class Event {
    private String mMsg;

    public Event(String mMsg) {
        this.mMsg = mMsg;
    }

    public String getmMsg() {
        return mMsg;
    }

    public void setmMsg(String mMsg) {
        this.mMsg = mMsg;
    }
}
