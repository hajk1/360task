package com.t360.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public class Chat {
    private Set<SuperPlayer> players = new HashSet<SuperPlayer>();

    public void attach(SuperPlayer player) {
        players.add(player);
    }

    public void sendMessage(Message message) {
        if (message instanceof PrivateMessage) {
            PrivateMessage privateMessage = (PrivateMessage) message;
            SuperPlayer recipientPlayer = players.stream().filter(superPlayer -> privateMessage.getReceiverPlayer().getUserName().equals(superPlayer.getUserName())).findFirst().orElse(null);
            if (recipientPlayer == null)
                throw new RuntimeException("Player not found:" + privateMessage.getSenderPlayer());
            recipientPlayer.sendMessage(message);
        }
    }

}
