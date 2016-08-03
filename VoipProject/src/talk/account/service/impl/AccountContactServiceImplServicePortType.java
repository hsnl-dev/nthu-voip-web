/**
 * AccountContactServiceImplServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public interface AccountContactServiceImplServicePortType extends java.rmi.Remote {
    public talk.account.service.xsd.Contact[] getMVPNContactList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String getContactsHash(java.lang.String session) throws java.rmi.RemoteException;
    public talk.account.service.xsd.WebContact[] loadDefaultWebContactList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String getMVPNContactCode(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String delMVPNFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String getFavoriteContactsHash(java.lang.String session) throws java.rmi.RemoteException;
    public talk.account.service.xsd.WebContact[] getWebContactList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String setWebContact(java.lang.String session, talk.account.service.xsd.WebContact webContact) throws java.rmi.RemoteException;
    public java.lang.String delContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String[] addFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Contact[] getFavoriteList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String editContact(java.lang.String session, talk.account.service.xsd.Contact contactInfo) throws java.rmi.RemoteException;
    public java.lang.String clearWebContactList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String[] addContactList(java.lang.String session, talk.account.service.xsd.Contact[] usrContactList) throws java.rmi.RemoteException;
    public java.lang.String[] addMVPNFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String addFavoriteContact(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException;
    public java.lang.String addContact(java.lang.String session, java.lang.String contact) throws java.rmi.RemoteException;
    public java.lang.String delWebDefaultContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Contact[] getMVPNFavoriteList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String delFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String editMVPNContact(java.lang.String session, talk.account.service.xsd.Contact contactInfo) throws java.rmi.RemoteException;
    public java.lang.String deleteFavoriteContacts(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException;
    public java.lang.String setWebDefaultContact(java.lang.String session, talk.account.service.xsd.WebContact defaultContact) throws java.rmi.RemoteException;
    public java.lang.String deleteContact(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException;
    public talk.account.service.xsd.WebContact[] loadDefaultWebContactListByAdmin(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String delMVPNContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String addWebDefaultContactList(java.lang.String session, talk.account.service.xsd.WebContact[] usrContactList) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Contact[] getContactList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String setWebContactOrder(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException;
    public java.lang.String addWebContactList(java.lang.String session, talk.account.service.xsd.WebContact[] usrContactList) throws java.rmi.RemoteException;
    public java.lang.String delWebContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException;
}
