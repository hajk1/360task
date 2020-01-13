package com.t360.service;

import com.t360.model.IMessage;
import com.t360.model.Player;
import com.t360.model.PrivateMessage;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import static com.t360.service.ChatServerImpl.*;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/

/**
 * This class is used for creating a new client which communicates with a predefined user
 */
public class Client {

    public static void run() throws RemoteException, MalformedURLException, NotBoundException {
        System.out.println("client PID:" + ManagementFactory.getRuntimeMXBean().getPid());
        System.out.println("Client started");
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        Player initiator = new Player(userName1, getServerLocation());
        Naming.rebind(getServerLocation(), initiator);
        System.out.println("Msg:");
        String msg = scanner.nextLine();
        IMessage privateMessage = new PrivateMessage(msg, initiator.getUserName(), HOST_USERNAME);
        initiator.notify(privateMessage);
        initiator.exit();
        System.exit(0);
    }

}
