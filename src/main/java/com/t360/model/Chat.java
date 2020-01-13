package com.t360.model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This class is responsible for gathering the set of all players
 */
public class Chat implements Serializable {

    private Set<SuperPlayer> players = new HashSet<SuperPlayer>();

    /**
     * This method is used by any new Player instance
     */
    public void attach(SuperPlayer player) {
        players.add(player);
    }

    public SuperPlayer findByUsername(String username) {
        return players.stream().filter(superPlayer -> username.equals(superPlayer.getUserName()))
            .findFirst().orElse(null);
    }

    /**
     * This method is used for delivering a message to the correct recipient
     */
    public void sendMessage(Message message) throws RemoteException {
        if (message instanceof PrivateMessage) {
            PrivateMessage privateMessage = (PrivateMessage) message;
            SuperPlayer recipientPlayer = findByUsername(
                privateMessage.getReceiverUsername());
            if (recipientPlayer == null) {
                throw new RuntimeException("Player not found:" + privateMessage.getSenderPlayer());
            }
            recipientPlayer.sendMessage(message);
        }
    }

}
