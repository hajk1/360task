package com.t360.model;

import java.rmi.RemoteException;
import java.util.Scanner;

import static com.t360.model.ChatServerImpl.*;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class SingleProcess {
    public void run() throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        ChatServer chatServer = new ChatServerImpl();
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        System.out.println(msg_player2);
        String userName2 = scanner.nextLine();
        Player initiator = chatServer.registerPlayer(userName1);
        Player secondPlayer = chatServer.registerPlayer(userName2);
        System.out.println(String.format(send_msg_template, userName1, userName2));
        System.out.println(userName1 + ":");
        String msg = scanner.nextLine();
        PrivateMessage privateMessage = new PrivateMessage(msg, initiator, secondPlayer);
        chatServer.sendMessage(privateMessage);
    }
}
