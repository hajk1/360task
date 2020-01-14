package com.t360.model;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 * <p>
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public interface IMessageListener extends java.rmi.Remote {

    void messageReceived(IMessage msg) throws java.rmi.RemoteException;

    String getUserName() throws java.rmi.RemoteException;

}
