package com.t360.process;

import com.t360.model.IChatServer;
import com.t360.model.Player;
import com.t360.model.PrivateMessage;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import static com.t360.service.ChatServerImpl.*;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/

/**
 * This class is used for a single process run time
 */
public class SingleProcess {

    public void run() throws RemoteException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        IChatServer chatServer = createFactory();
        System.out.println(msg_player1);
        String userName1 = scanner.nextLine();
        System.out.println(msg_player2);
        String userName2 = scanner.nextLine();
        Player initiator = new Player(userName1, getServerLocation());
        Player secondPlayer = new Player(userName2, getServerLocation());
        System.out.println(String.format(send_msg_template, userName1, userName2));
        String msg = scanner.nextLine();
        PrivateMessage privateMessage = new PrivateMessage(msg, initiator.getUserName(),
                secondPlayer.getUserName());
        chatServer.sendMessage(privateMessage);
    }
}
