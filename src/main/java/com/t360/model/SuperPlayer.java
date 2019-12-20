package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public abstract class SuperPlayer {
    protected Chat chat;

    abstract void sendMessage(Message message);
}
