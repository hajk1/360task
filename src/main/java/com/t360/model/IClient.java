package com.t360.model;

import java.io.Serializable;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public interface IClient extends java.rmi.Remote, Serializable {

  void notify(Message msg) throws java.rmi.RemoteException;
}