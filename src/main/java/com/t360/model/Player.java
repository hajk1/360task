package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/
public class Player extends SuperPlayer {
    public static final int MAX_COUNTER = 10;
    private int receiveCounter;
    private int sendCounter;

    public Player(Chat chat, String userName) {
        super(userName);
        this.chat = chat;
        this.chat.attach(this);
    }

    void sendMessage(Message message) {
        System.out.println("message = " + message.getValue());
        if (message instanceof PrivateMessage) {
            PrivateMessage replyMessage = new PrivateMessage(message.getValue() + (receiveCounter + 1), this, ((PrivateMessage) message).getSenderPlayer());
            if (sendCounter == MAX_COUNTER && receiveCounter == MAX_COUNTER)
                return;
            receiveCounter++;
            sendCounter++;
            chat.sendMessage(replyMessage);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
