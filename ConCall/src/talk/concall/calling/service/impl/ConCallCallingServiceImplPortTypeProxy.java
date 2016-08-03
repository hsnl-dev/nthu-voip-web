package talk.concall.calling.service.impl;

public class ConCallCallingServiceImplPortTypeProxy implements talk.concall.calling.service.impl.ConCallCallingServiceImplPortType {
  private String _endpoint = null;
  private talk.concall.calling.service.impl.ConCallCallingServiceImplPortType conCallCallingServiceImplPortType = null;
  
  public ConCallCallingServiceImplPortTypeProxy() {
    _initConCallCallingServiceImplPortTypeProxy();
  }
  
  public ConCallCallingServiceImplPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initConCallCallingServiceImplPortTypeProxy();
  }
  
  private void _initConCallCallingServiceImplPortTypeProxy() {
    try {
      conCallCallingServiceImplPortType = (new talk.concall.calling.service.impl.ConCallCallingServiceImplLocator()).getConCallCallingServiceImplHttpSoap11Endpoint();
      if (conCallCallingServiceImplPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)conCallCallingServiceImplPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)conCallCallingServiceImplPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (conCallCallingServiceImplPortType != null)
      ((javax.xml.rpc.Stub)conCallCallingServiceImplPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.concall.calling.service.impl.ConCallCallingServiceImplPortType getConCallCallingServiceImplPortType() {
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType;
  }
  
  public java.lang.String sipTerminateUser(java.lang.String UUID, java.lang.String number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.sipTerminateUser(UUID, number);
  }
  
  public java.lang.String webStartMeeting(java.lang.String session, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.webStartMeeting(session, number);
  }
  
  public java.lang.String webInviteMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.webInviteMember(session, UUID, number);
  }
  
  public java.lang.String getHistoryList(java.lang.String session) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.getHistoryList(session);
  }
  
  public java.lang.String getMeetingInfo(java.lang.String session, java.lang.String[] UUIDList) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.getMeetingInfo(session, UUIDList);
  }
  
  public java.lang.String fuck(java.lang.String s) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.fuck(s);
  }
  
  public java.lang.String testConCall(java.lang.String s) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.testConCall(s);
  }
  
  public java.lang.String kickMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.kickMember(session, UUID, number);
  }
  
  public java.lang.String inviteMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.inviteMember(session, UUID, number);
  }
  
  public java.lang.String startMeeting(java.lang.String session, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.startMeeting(session, number);
  }
  
  public java.lang.String getMemberState(java.lang.String session, java.lang.String UUID) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.getMemberState(session, UUID);
  }
  
  public java.lang.String sipBusyUser(java.lang.String UUID, java.lang.String number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.sipBusyUser(UUID, number);
  }
  
  public java.lang.String webKickMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.webKickMember(session, UUID, number);
  }
  
  public java.lang.String sipAcceptUser(java.lang.String number, java.lang.String roomNumber) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.sipAcceptUser(number, roomNumber);
  }
  
  public java.lang.String forceTerminate(java.lang.String UUID) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.forceTerminate(UUID);
  }
  
  public java.lang.String hostTerminate(java.lang.String session, java.lang.String UUID) throws java.rmi.RemoteException{
    if (conCallCallingServiceImplPortType == null)
      _initConCallCallingServiceImplPortTypeProxy();
    return conCallCallingServiceImplPortType.hostTerminate(session, UUID);
  }
  
  
}