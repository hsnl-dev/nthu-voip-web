/**
 * SuperAccountServiceImplPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public interface SuperAccountServiceImplPortType extends java.rmi.Remote {
    public java.lang.String getSuperAccountInfo(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String addPhone(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String registerSuperAccount(java.lang.String mail, java.lang.String number, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String setCurrentPhone(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String logingSuperAccount(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String deleteAccount(java.lang.String regiMail, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String validateSuperAccount(java.lang.String mail, java.lang.String authCode) throws java.rmi.RemoteException;
}
