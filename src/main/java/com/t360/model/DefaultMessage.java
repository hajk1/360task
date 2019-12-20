package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public class DefaultMessage implements Message {
    private final String value;
    private final Player receiverPlayer;

    public DefaultMessage(String value, Player player) {
        this.value = value;
        this.receiverPlayer = player;
    }

    public String getValue() {
        return value;
    }

    public Player getReceiverPlayer() {
        return receiverPlayer;
    }
}
