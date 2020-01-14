package com.t360.model;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */

import java.rmi.RemoteException;

/**
 * Skeleton for a client entity
 */
public interface IClient extends java.rmi.Remote {

  /**
   * All the implementation classes must implement this method as well
   */
  void notify(IMessage msg) throws java.rmi.RemoteException;

    /**
     * tries to exit the application
     *
     * @throws RemoteException
     */
    void exit() throws RemoteException;

}