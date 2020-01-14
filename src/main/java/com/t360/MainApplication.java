package com.t360;

import com.t360.process.MultiProcess;
import com.t360.process.SingleProcess;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/

/**
 * This class is the main class which starts the whole program
 */
public class MainApplication {

    public static ResourceBundle rb = ResourceBundle.getBundle("messages");
    private static final String SINGLE_PROCESS_MODE = "S";
    private static final String MULTIPLE_PROCESS_MODE = "M";

    public static void main(String[] args)
            throws RemoteException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        String process_state;
        do {
            System.out.println(rb.getString("welcome.msg"));
            process_state = scanner.nextLine();
        } while (!process_state.matches("[SM]"));

        switch (process_state) {
            case SINGLE_PROCESS_MODE:
                new SingleProcess().run();
                break;
            case MULTIPLE_PROCESS_MODE:
                new MultiProcess().run();
                break;
        }
    }

}
