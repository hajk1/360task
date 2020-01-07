package com.t360.model;

import java.util.Objects;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This is the super class for all players, it contain all necessary fields
 */
public abstract class SuperPlayer {
    private final String userName;
    Chat chat;

    SuperPlayer(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * All the implementation classes must implement this method as well
     *
     * @param message
     */
    abstract void sendMessage(Message message);

    /**
     * @return
     */
    abstract boolean mustEnd();

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
