package com.t360.model;

/**
 * @author : Kayvan Tehrani<k1.tehrani@gmail.com>
 * @since : 12/20/2019, Fri
 **/

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is used for base message skeleton
 */
public interface Message extends Remote {

  String getValue() throws RemoteException;
}
