package com.t360.process;

import static com.t360.MainApplication.rb;
import static com.t360.service.ChatServerImpl.createFactory;
import static com.t360.service.ChatServerImpl.getServerLocation;

import com.t360.model.IChatServer;
import com.t360.model.Player;
import com.t360.model.PrivateMessage;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

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
        System.out.println(rb.getString("input.usr1"));
        String userName1 = scanner.nextLine();
        System.out.println(rb.getString("input.usr2"));
        String userName2 = scanner.nextLine();
        Player initiator = new Player(userName1, getServerLocation());
        Player secondPlayer = new Player(userName2, getServerLocation());
        System.out.println(String.format(rb.getString("send.msg.template"), userName1, userName2));
        String msg = scanner.nextLine();
        PrivateMessage privateMessage = new PrivateMessage(msg, initiator.getUserName(),
                secondPlayer.getUserName());
        chatServer.sendMessage(privateMessage);
        chatServer.exit();
        System.exit(0);
    }
}
