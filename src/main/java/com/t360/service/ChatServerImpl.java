package com.t360.service;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/6/2020, Mon
 **/

import com.t360.model.IChatServer;
import com.t360.model.IMessage;
import com.t360.model.IMessageListener;
import com.t360.model.Player;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

/**
 * This class is used as the main class inorder to start the chat
 * It creates a chat and then 2 players
 * The 1st player(initiator) creates a private message and send it using chat class which has access to both players
 */
public class ChatServerImpl extends UnicastRemoteObject implements IChatServer {

    public static String clientName = "ChatClient";
    public static String msg_player1 = "Plz Enter 1st username:";
    public static String msg_player2 = "Plz Enter 2nd username:";
    public static String send_msg_template = "Hi %s! Enter your message to sent to %s";
    public static final String HOST_USERNAME = "host";
    public static int remotePort = 5000;
    public static String serverName = "ChatServer";
    private LinkedList<IMessageListener> listeners = new LinkedList<>();
    public static String getServerLocation() {
        return "rmi://localhost:" + remotePort + "/" + serverName;
    }

    private ChatServerImpl() throws RemoteException {
        super();
    }

    /**
     * This is used for creating new instance
     *
     * @return
     * @throws RemoteException
     * @throws MalformedURLException
     */
    public static IChatServer createFactory() throws RemoteException, MalformedURLException {
        IChatServer chatServer = new ChatServerImpl();
        LocateRegistry.createRegistry(remotePort);
        Naming.rebind(getServerLocation(), chatServer);
        return chatServer;
    }

    /**
     * This method is used for starting the Chat server
     */
    public static void run() {
        try {
            System.out.println("server PID:" + ManagementFactory.getRuntimeMXBean().getPid());
            createFactory();
            new Player(HOST_USERNAME, getServerLocation());
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * This method is used for sending message to the receiver player
     * @param message
     * @throws RemoteException
     */
    @Override
    public void sendMessage(IMessage message) throws RemoteException {
        IMessageListener listener = listeners.stream().filter(iMessageListener -> {
            try {
                return message.getReceiverUsername().equals(iMessageListener.getUserName());
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }).findFirst().orElse(null);
        if (listener != null)
            listener.messageReceived(message);
    }

    /**
     * This method registers the listener inorder to notify the clients
     * @param listener
     * @throws RemoteException
     */
    @Override
    public void registerListener(IMessageListener listener) throws RemoteException {
        listeners.add(listener);
    }

    public void exit() throws RemoteException {
        try {
            // Unregister ourself
            Naming.unbind(getServerLocation());
            // Unexport; this will also remove us from the RMI runtime
            UnicastRemoteObject.unexportObject(this, true);
            System.out.println("Chat Server exiting...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
