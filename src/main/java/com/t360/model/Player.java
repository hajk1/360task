package com.t360.model;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This is the base implementation of the SuperPlayer and it is committed to 10 times message delivering
 * The instances of this  class are unique based on their username
 */
public class Player extends SuperPlayer {
    public static final int MAX_COUNTER = 10;
    private int receiveCounter;
    private int sendCounter;

    public Player(Chat chat, String userName) {
        super(userName);
        this.chat = chat;
        this.chat.attach(this);
    }

    /**
     * It receives a message, checks for the ending condition and
     * it generates the reply based on what is indicated on the requirements in case of not reaching the final result,
     * other ways it will return and the program would be finished happily
     *
     * @param message
     */
    void sendMessage(Message message) {
        final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        final long pid = runtime.getPid();
        System.out.println("Process ID is '" + pid);
        System.out.println("message = " + message.getValue());
        if (mustEnd())
            return;
        if (message instanceof PrivateMessage) {
            PrivateMessage replyMessage = new PrivateMessage(message.getValue() + (receiveCounter + 1), this, ((PrivateMessage) message).getSenderPlayer());
            receiveCounter++;
            sendCounter++;
            chat.sendMessage(replyMessage);
        }
    }

    /**
     * Implements the requirement for ending the messaging chain and the program
     *
     * @return
     */
    boolean mustEnd() {
        return sendCounter == MAX_COUNTER && receiveCounter == MAX_COUNTER;
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
