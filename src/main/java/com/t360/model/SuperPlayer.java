package com.t360.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This is the super class for all players, it contain all necessary fields
 */
public abstract class SuperPlayer extends UnicastRemoteObject {

    private final String userName;
    Chat chat;

    SuperPlayer(String userName) throws RemoteException {
        super();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * All the implementation classes must implement this method as well
     */
    abstract void sendMessage(Message message) throws RemoteException;

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
