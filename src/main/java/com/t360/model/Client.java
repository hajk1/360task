package com.t360.model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 1/11/2020, Sat
 **/
public class Client {
    private static ChatServer look_up;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        look_up = (ChatServer) Naming.lookup("//localhost/MyServer");
        System.out.println("look_up = " + look_up);
    }
}
