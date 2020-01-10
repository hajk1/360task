package com.t360.model;

import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class MultiProcess {
    private static final String SERVER_MODE = "S";
    private static final String CLIENT_MODE = "C";
    private static final String msg_server_client = "Server(S) mode or Client(C)?";

    public void run() throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        String process_state;
        do {
            System.out.println(msg_server_client);
            process_state = scanner.nextLine();
        } while (!process_state.matches("[SC]"));

        switch (process_state) {
            case SERVER_MODE:
                ChatServerImpl.run();
                break;
            case CLIENT_MODE:
                new MultiProcess().run();
                break;
        }
    }
}
