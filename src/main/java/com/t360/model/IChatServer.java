package com.t360.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/10/2020, Fri
 **/

/**
 * Skeleton interface for chat server
 */
public interface IChatServer extends Remote {

    void registerListener(IMessageListener listener) throws RemoteException;

    void sendMessage(IMessage message) throws RemoteException;
}
