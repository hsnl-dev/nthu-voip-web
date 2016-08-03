package talk.account.service.impl;

public class SuperAccountServiceImplPortTypeProxy implements talk.account.service.impl.SuperAccountServiceImplPortType {
  private String _endpoint = null;
  private talk.account.service.impl.SuperAccountServiceImplPortType superAccountServiceImplPortType = null;
  
  public SuperAccountServiceImplPortTypeProxy() {
    _initSuperAccountServiceImplPortTypeProxy();
  }
  
  public SuperAccountServiceImplPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSuperAccountServiceImplPortTypeProxy();
  }
  
  private void _initSuperAccountServiceImplPortTypeProxy() {
    try {
      superAccountServiceImplPortType = (new talk.account.service.impl.SuperAccountServiceImplLocator()).getSuperAccountServiceImplHttpSoap11Endpoint();
      if (superAccountServiceImplPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)superAccountServiceImplPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)superAccountServiceImplPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (superAccountServiceImplPortType != null)
      ((javax.xml.rpc.Stub)superAccountServiceImplPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.account.service.impl.SuperAccountServiceImplPortType getSuperAccountServiceImplPortType() {
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType;
  }
  
  public java.lang.String getSuperAccountInfo(java.lang.String session) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.getSuperAccountInfo(session);
  }
  
  public java.lang.String addPhone(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.addPhone(session, number);
  }
  
  public java.lang.String registerSuperAccount(java.lang.String mail, java.lang.String number, java.lang.String password) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.registerSuperAccount(mail, number, password);
  }
  
  public java.lang.String setCurrentPhone(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.setCurrentPhone(session, number);
  }
  
  public java.lang.String logingSuperAccount(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.logingSuperAccount(mail, password);
  }
  
  public java.lang.String deleteAccount(java.lang.String regiMail, java.lang.String password) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.deleteAccount(regiMail, password);
  }
  
  public java.lang.String validateSuperAccount(java.lang.String mail, java.lang.String authCode) throws java.rmi.RemoteException{
    if (superAccountServiceImplPortType == null)
      _initSuperAccountServiceImplPortTypeProxy();
    return superAccountServiceImplPortType.validateSuperAccount(mail, authCode);
  }
  
  
}