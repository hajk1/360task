package com.t360.model;

import java.util.Objects;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public abstract class SuperPlayer {
    private final String userName;
    Chat chat;

    SuperPlayer(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    abstract void sendMessage(Message message);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperPlayer that = (SuperPlayer) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
