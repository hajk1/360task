package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/6/2020, Mon
 **/

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
public class ChatServerImpl extends UnicastRemoteObject implements ChatServer {

    public static String clientName = "ChatClient";
    public static String msg_player1 = "Plz Enter 1st username:";
    public static String msg_player2 = "Plz Enter 2nd username:";
    public static String send_msg_template = "Hi %s! Enter your message to sent to %s";
    public static final String HOST_USERNAME = "host";
    public static int remotePort = 5000;
    public static String serverName = "ChatServer";
    LinkedList<IMessageListener> listeners = new LinkedList<>();
    private Chat chat;

    public static String getServerLocation() {
        return "rmi://localhost:" + remotePort + "/" + serverName;
    }

    public static ChatServer createFactory() throws RemoteException, MalformedURLException {
        ChatServer chatServer = new ChatServerImpl();
        LocateRegistry.createRegistry(remotePort);
        Naming.rebind(getServerLocation(), chatServer);
        return chatServer;
    }

    public ChatServerImpl() throws RemoteException {
        super();
        chat = new Chat();
    }

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

    @Override
    public SuperPlayer findPlayer(String userName) throws RemoteException {
        return chat.findByUsername(userName);
    }

    @Override
    public void sendMessage(Message message) throws RemoteException {
        for (IMessageListener listener : listeners) {
            listener.messageReceived(message);
        }
    }

    @Override
    public Chat getChat() throws RemoteException {
        return chat;
    }

    @Override
    public void registerListener(IMessageListener listener) throws RemoteException {
        listeners.add(listener);
    }
}
