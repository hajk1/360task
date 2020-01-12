package com.t360.model;

import static com.t360.model.ChatServerImpl.HOST_USERNAME;
import static com.t360.model.ChatServerImpl.msg_player1;
import static com.t360.model.ChatServerImpl.remotePort;
import static com.t360.model.ChatServerImpl.serverName;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class ChatClient {

    public void run() throws RemoteException, MalformedURLException, NotBoundException {
        System.out.println("client PID:" + ManagementFactory.getRuntimeMXBean().getPid());
        ChatServer chatServer = (ChatServer) Naming
            .lookup("rmi://localhost:" + remotePort + "/" + serverName);
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        Chat chat = chatServer.getChat();

        Player initiator = new Player(chat, userName1);
//        chatServer.registerPlayer(initiator);
        String msg = scanner.nextLine();
        PrivateMessage privateMessage = new PrivateMessage(msg, initiator,
            (Player) chatServer.findPlayer(HOST_USERNAME));
        chatServer.sendMessage(privateMessage);
    }
}
