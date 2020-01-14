package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/***
 * This class is a private message between 2 players, it holds the message content and the sender and receiver players as well
 */
public class PrivateMessage extends UnicastRemoteObject implements IMessage {

    private final String value;
    private final String receiverUsername;
    private final String senderUsername;

    public PrivateMessage(String value, String senderUsername, String receiverUsername)
        throws RemoteException {
        this.value = value;
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getSenderUsername() throws RemoteException {
        return senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }
}
