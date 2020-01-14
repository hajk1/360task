package com.t360.process;

import static com.t360.MainApplication.rb;

import com.t360.service.ChatServerImpl;
import com.t360.service.Client;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/

/**
 * This class is used for a multi process run time
 */
public class MultiProcess {
    private static final String SERVER_MODE = "S";
    private static final String CLIENT_MODE = "C";

    public void run() throws RemoteException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        String process_state;
        do {
            System.out.println(rb.getString("server.client.choice"));
            process_state = scanner.nextLine();
        } while (!process_state.matches("[SC]"));

        switch (process_state) {
            case SERVER_MODE:
                ChatServerImpl.run();
                break;
            case CLIENT_MODE:
                Client.run();
                break;
        }
    }
}
