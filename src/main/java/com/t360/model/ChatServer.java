package com.t360.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/10/2020, Fri
 **/
public interface ChatServer extends Remote {

    Chat getChat() throws RemoteException;

    void registerPlayer(Player player) throws RemoteException;

    Player registerPlayer(String userName) throws RemoteException;

    SuperPlayer findPlayer(String userName) throws RemoteException;

    void sendMessage(Message message) throws RemoteException;
}
