package talk.account.service.impl;

public class AccountContactServiceImplServicePortTypeProxy implements talk.account.service.impl.AccountContactServiceImplServicePortType {
  private String _endpoint = null;
  private talk.account.service.impl.AccountContactServiceImplServicePortType accountContactServiceImplServicePortType = null;
  
  public AccountContactServiceImplServicePortTypeProxy() {
    _initAccountContactServiceImplServicePortTypeProxy();
  }
  
  public AccountContactServiceImplServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountContactServiceImplServicePortTypeProxy();
  }
  
  private void _initAccountContactServiceImplServicePortTypeProxy() {
    try {
      accountContactServiceImplServicePortType = (new talk.account.service.impl.AccountContactServiceImplServiceLocator()).getAccountContactServiceImplServiceHttpSoap11Endpoint();
      if (accountContactServiceImplServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountContactServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountContactServiceImplServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountContactServiceImplServicePortType != null)
      ((javax.xml.rpc.Stub)accountContactServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.account.service.impl.AccountContactServiceImplServicePortType getAccountContactServiceImplServicePortType() {
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType;
  }
  
  public talk.account.service.xsd.Contact[] getMVPNContactList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getMVPNContactList(session);
  }
  
  public java.lang.String getContactsHash(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getContactsHash(session);
  }
  
  public talk.account.service.xsd.WebContact[] loadDefaultWebContactList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.loadDefaultWebContactList(session);
  }
  
  public java.lang.String getMVPNContactCode(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getMVPNContactCode(session);
  }
  
  public java.lang.String delMVPNFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delMVPNFavoriteList(session, contactUUIDList);
  }
  
  public java.lang.String getFavoriteContactsHash(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getFavoriteContactsHash(session);
  }
  
  public talk.account.service.xsd.WebContact[] getWebContactList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getWebContactList(session);
  }
  
  public java.lang.String setWebContact(java.lang.String session, talk.account.service.xsd.WebContact webContact) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.setWebContact(session, webContact);
  }
  
  public java.lang.String delContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delContactList(session, usrContactUUIDList);
  }
  
  public java.lang.String[] addFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addFavoriteList(session, contactUUIDList);
  }
  
  public talk.account.service.xsd.Contact[] getFavoriteList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getFavoriteList(session);
  }
  
  public java.lang.String editContact(java.lang.String session, talk.account.service.xsd.Contact contactInfo) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.editContact(session, contactInfo);
  }
  
  public java.lang.String clearWebContactList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.clearWebContactList(session);
  }
  
  public java.lang.String[] addContactList(java.lang.String session, talk.account.service.xsd.Contact[] usrContactList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addContactList(session, usrContactList);
  }
  
  public java.lang.String[] addMVPNFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addMVPNFavoriteList(session, contactUUIDList);
  }
  
  public java.lang.String addFavoriteContact(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addFavoriteContact(session, contactUUID);
  }
  
  public java.lang.String addContact(java.lang.String session, java.lang.String contact) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addContact(session, contact);
  }
  
  public java.lang.String delWebDefaultContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delWebDefaultContactList(session, usrContactUUIDList);
  }
  
  public talk.account.service.xsd.Contact[] getMVPNFavoriteList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getMVPNFavoriteList(session);
  }
  
  public java.lang.String delFavoriteList(java.lang.String session, java.lang.String[] contactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delFavoriteList(session, contactUUIDList);
  }
  
  public java.lang.String editMVPNContact(java.lang.String session, talk.account.service.xsd.Contact contactInfo) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.editMVPNContact(session, contactInfo);
  }
  
  public java.lang.String deleteFavoriteContacts(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.deleteFavoriteContacts(session, contactUUID);
  }
  
  public java.lang.String setWebDefaultContact(java.lang.String session, talk.account.service.xsd.WebContact defaultContact) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.setWebDefaultContact(session, defaultContact);
  }
  
  public java.lang.String deleteContact(java.lang.String session, java.lang.String contactUUID) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.deleteContact(session, contactUUID);
  }
  
  public talk.account.service.xsd.WebContact[] loadDefaultWebContactListByAdmin(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.loadDefaultWebContactListByAdmin(session);
  }
  
  public java.lang.String delMVPNContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delMVPNContactList(session, usrContactUUIDList);
  }
  
  public java.lang.String addWebDefaultContactList(java.lang.String session, talk.account.service.xsd.WebContact[] usrContactList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addWebDefaultContactList(session, usrContactList);
  }
  
  public talk.account.service.xsd.Contact[] getContactList(java.lang.String session) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.getContactList(session);
  }
  
  public java.lang.String setWebContactOrder(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.setWebContactOrder(session, usrContactUUIDList);
  }
  
  public java.lang.String addWebContactList(java.lang.String session, talk.account.service.xsd.WebContact[] usrContactList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.addWebContactList(session, usrContactList);
  }
  
  public java.lang.String delWebContactList(java.lang.String session, java.lang.String[] usrContactUUIDList) throws java.rmi.RemoteException{
    if (accountContactServiceImplServicePortType == null)
      _initAccountContactServiceImplServicePortTypeProxy();
    return accountContactServiceImplServicePortType.delWebContactList(session, usrContactUUIDList);
  }
  
  
}