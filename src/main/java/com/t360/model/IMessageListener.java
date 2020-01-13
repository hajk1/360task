package com.t360.model;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public interface IMessageListener extends java.rmi.Remote {

  void messageReceived(Message msg) throws java.rmi.RemoteException;
}
