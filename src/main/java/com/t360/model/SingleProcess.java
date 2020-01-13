package com.t360.model;

import static com.t360.model.ChatServerImpl.createFactory;
import static com.t360.model.ChatServerImpl.getServerLocation;
import static com.t360.model.ChatServerImpl.msg_player1;
import static com.t360.model.ChatServerImpl.msg_player2;
import static com.t360.model.ChatServerImpl.send_msg_template;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class SingleProcess {

    public void run() throws RemoteException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        ChatServer chatServer = createFactory();
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        System.out.println(msg_player2);
        String userName2 = scanner.nextLine();
        Player initiator = new Player(userName1, getServerLocation());
        Player secondPlayer = new Player(userName2, getServerLocation());
        System.out.println(String.format(send_msg_template, userName1, userName2));
        System.out.println(userName1 + ":");
        String msg = scanner.nextLine();
        PrivateMessage privateMessage = new PrivateMessage(msg, initiator,
            secondPlayer.getUserName());
        chatServer.sendMessage(privateMessage);
    }
}
