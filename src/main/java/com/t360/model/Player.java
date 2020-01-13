package com.t360.model;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

/**
 * This is the base implementation of the SuperPlayer and it is committed to 10 times message delivering
 * The instances of this  class are unique based on their username
 */
public class Player extends SuperPlayer implements IClient, IMessageListener, Remote {

    public static final int MAX_COUNTER = 10;
    private int receiveCounter;
    private int sendCounter;
    private IChatServer chatServer;
    /**
     * This pattern shows Process Id, current username and sender left justified(8 chars) and the message
     */
    private final String msgTemplate = "PID:%s,username:%-8s,sender:%-8s,msg:%s";

    /**
     * The constructor registers username, finds chat server and registers itself as a message listener
     *
     * @param userName
     * @param serverLocation
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public Player(String userName, String serverLocation)
            throws RemoteException, NotBoundException, MalformedURLException {
        super(userName);
        chatServer = (IChatServer) Naming.lookup(serverLocation);
        chatServer.registerListener(this);
    }

    /**
     * This method is used for notifying server about new message
     *
     * @param msg
     * @throws RemoteException
     */
    @Override
    public void notify(IMessage msg) throws RemoteException {
        chatServer.sendMessage(msg);
    }

    @Override
    public void exit() throws RemoteException {
        try {
            chatServer.exit();
        } catch (Exception ignored) {
        }
    }

    /**
     * It receives a message, checks for the ending condition and
     * it generates the reply based on what is indicated on the requirements in case of not reaching the final result,
     * other ways it will return and the program would be finished happily
     *
     * @param message
     */
    @Override
    public void messageReceived(IMessage message) throws RemoteException {
        final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        final long pid = runtime.getPid();
        if (mustEnd()) {
            return;
        }
        String senderUsername = message.getSenderUsername();
        String msg = String.format(msgTemplate, pid, getUserName(), senderUsername, message.getValue());
        System.out.println(msg);
        PrivateMessage replyMessage = new PrivateMessage(message.getValue() + (receiveCounter + 1), getUserName(), senderUsername);
        receiveCounter++;
        sendCounter++;
        notify(replyMessage);
    }

    /**
     * Implements the requirement for ending the messaging chain and the program
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
