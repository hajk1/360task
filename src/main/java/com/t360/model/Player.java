package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public class Player extends SuperPlayer {
    public Player(Chat chat) {
        this.chat = chat;
        this.chat.attach(this);
    }

    void sendMessage(Message message) {

    }
}
