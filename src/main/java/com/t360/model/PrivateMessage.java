package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public class PrivateMessage implements Message {
    private final String value;
    private final Player receiverPlayer;
    private final Player senderPlayer;

    public PrivateMessage(String value, Player senderPlayer, Player receiverPlayer) {
        this.value = value;
        this.senderPlayer = senderPlayer;
        this.receiverPlayer = receiverPlayer;
    }

    public String getValue() {
        return value;
    }

    public Player getReceiverPlayer() {
        return receiverPlayer;
    }

    public Player getSenderPlayer() {
        return senderPlayer;
    }
}
