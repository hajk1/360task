package com.t360.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This class is responsible for gathering the set of all players
 */
public class Chat {
    private Set<SuperPlayer> players = new HashSet<SuperPlayer>();

    /**
     * This method is used by any new Player instance
     *
     * @param player
     */
    public void attach(SuperPlayer player) {
        players.add(player);
    }

    /**
     * This method is used for delivering a message to the correct recipient
     * @param message
     */
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
