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
public class Client {

    public static void run() throws RemoteException, MalformedURLException, NotBoundException {
        System.out.println("client PID:" + ManagementFactory.getRuntimeMXBean().getPid());
        System.out.println("Client started");
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        Player initiator = new Player(userName1,
            "rmi://localhost:" + remotePort + "/" + serverName);
        Naming.rebind("rmi://localhost:" + remotePort + "/" + serverName, initiator);
        System.out.println("Msg:");
        String msg = scanner.nextLine();
        Message privateMessage = new PrivateMessage(msg, initiator, HOST_USERNAME);
        initiator.notify(privateMessage);
    }

}
