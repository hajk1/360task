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
public class PrivateMessage extends UnicastRemoteObject implements Message {

    private final String value;
    private final String receiverUsername;
    private final Player senderPlayer;

    public PrivateMessage(String value, Player senderPlayer, String receiverUsername)
        throws RemoteException {
        this.value = value;
        this.senderPlayer = senderPlayer;
        this.receiverUsername = receiverUsername;
    }

    public String getValue() {
        return value;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public Player getSenderPlayer() {
        return senderPlayer;
    }
}
