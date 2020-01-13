package com.t360;

import com.t360.process.MultiProcess;
import com.t360.process.SingleProcess;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/

/**
 * This class is the main class which starts the whole program
 */
public class MainApplication {

    private static final String SINGLE_PROCESS_MODE = "S";
    private static final String MULTIPLE_PROCESS_MODE = "M";
    private static String msg_welcome = "Welcome! Do you want to run Single(S) Process or Multiple(M) Process?";

    public static void main(String[] args)
            throws RemoteException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        String process_state;
        do {
            System.out.println(msg_welcome);
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
