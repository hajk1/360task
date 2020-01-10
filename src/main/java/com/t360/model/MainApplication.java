package com.t360.model;

import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class MainApplication {
    private static final String SINGLE_PROCESS_MODE = "S";
    private static final String MULTIPLE_PROCESS_MODE = "M";
    private static String msg_welcome = "Welcome! Do you want to run Single(S) Process or Multiple(M) Process?";

    public static void main(String[] args) throws RemoteException {
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
