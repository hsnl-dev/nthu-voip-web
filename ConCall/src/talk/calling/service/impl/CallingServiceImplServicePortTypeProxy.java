package talk.calling.service.impl;

public class CallingServiceImplServicePortTypeProxy implements talk.calling.service.impl.CallingServiceImplServicePortType {
  private String _endpoint = null;
  private talk.calling.service.impl.CallingServiceImplServicePortType callingServiceImplServicePortType = null;
  
  public CallingServiceImplServicePortTypeProxy() {
    _initCallingServiceImplServicePortTypeProxy();
  }
  
  public CallingServiceImplServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCallingServiceImplServicePortTypeProxy();
  }
  
  private void _initCallingServiceImplServicePortTypeProxy() {
    try {
      callingServiceImplServicePortType = (new talk.calling.service.impl.CallingServiceImplServiceLocator()).getCallingServiceImplServiceHttpSoap11Endpoint();
      if (callingServiceImplServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)callingServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)callingServiceImplServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (callingServiceImplServicePortType != null)
      ((javax.xml.rpc.Stub)callingServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.calling.service.impl.CallingServiceImplServicePortType getCallingServiceImplServicePortType() {
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType;
  }
  
  public java.lang.String getHistoryHash(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getHistoryHash(session);
  }
  
  public java.lang.String addNationalCode(java.lang.String systemHandShake, talk.calling.service.xsd.NationalCode[] code) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.addNationalCode(systemHandShake, code);
  }
  
  public talk.calling.service.xsd.Notification[] pollingMessage(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.pollingMessage(session);
  }
  
  public java.lang.String initFreeList(java.lang.String[] freeMapping) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.initFreeList(freeMapping);
  }
  
  public java.lang.String startCallingMVPNSIP(java.lang.String number, java.lang.String mappingNumber) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingMVPNSIP(number, mappingNumber);
  }
  
  public java.lang.String editMappingPhone(java.lang.String session, talk.calling.service.xsd.MappingPhone[] mappingPneLst) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.editMappingPhone(session, mappingPneLst);
  }
  
  public java.lang.String startCallingByContact(java.lang.String session, java.lang.String contactID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByContact(session, contactID);
  }
  
  public talk.calling.service.xsd.UnitContact[] getDefaultContactList(java.lang.String unitUUID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getDefaultContactList(unitUUID);
  }
  
  public java.lang.String startCallingMVPNSIPByApp(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingMVPNSIPByApp(session, number);
  }
  
  public talk.calling.service.xsd.History[] getCallingHistory(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getCallingHistory(session);
  }
  
  public java.lang.String clearDefaultContactList(java.lang.String unitUUID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.clearDefaultContactList(unitUUID);
  }
  
  public java.lang.String startCallingByForeign(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByForeign(session, number);
  }
  
  public java.lang.String clearCallingHistory(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.clearCallingHistory(session);
  }
  
  public talk.calling.service.xsd.SoftPhone allocateSIPAccount(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.allocateSIPAccount(session);
  }
  
  public java.lang.String callByShih(java.lang.String number, java.lang.String mappingNumber) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.callByShih(number, mappingNumber);
  }
  
  public java.lang.String startingCalling(java.lang.String callerNum, java.lang.String calleeNumber, java.lang.String callerID, java.lang.String calleeID, java.lang.String card, java.lang.String whois) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startingCalling(callerNum, calleeNumber, callerID, calleeID, card, whois);
  }
  
  public java.lang.String startCallingByWeb(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByWeb(session, number);
  }
  
  public talk.calling.service.xsd.MappingPhone[] getMappedList(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getMappedList(session);
  }
  
  public java.lang.String addMappingPhone(java.lang.String session, talk.calling.service.xsd.MappingPhone[] mappingPneLst) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.addMappingPhone(session, mappingPneLst);
  }
  
  public java.lang.String startCallingByMVPN(java.lang.String session, java.lang.String contactID, java.lang.String number) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByMVPN(session, contactID, number);
  }
  
  public java.lang.String sendMessageByUser(java.lang.String session, talk.calling.service.xsd.Notification msg) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.sendMessageByUser(session, msg);
  }
  
  public java.lang.String cancelCallingByMVPN(java.lang.String session, java.lang.String number, java.lang.Boolean callee) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.cancelCallingByMVPN(session, number, callee);
  }
  
  public java.lang.String getUnitUUID(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getUnitUUID(session);
  }
  
  public talk.calling.service.xsd.MVPNHistory[] getMVPNCallingHistory(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getMVPNCallingHistory(session);
  }
  
  public java.lang.String delMVPNCallingHistoryList(java.lang.String session, talk.calling.service.xsd.MVPNHistory[] historyList) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.delMVPNCallingHistoryList(session, historyList);
  }
  
  public java.lang.String cancelCallingByContact(java.lang.String session, java.lang.String contactID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.cancelCallingByContact(session, contactID);
  }
  
  public java.lang.String delDefaultContactList(java.lang.String unitUUID, talk.calling.service.xsd.UnitContact[] unitCnct) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.delDefaultContactList(unitUUID, unitCnct);
  }
  
  public java.lang.String restoreMappingList(java.lang.String systemHandShake, java.lang.String number, java.lang.String[] freeMapping) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.restoreMappingList(systemHandShake, number, freeMapping);
  }
  
  public java.lang.String clearMVPNCallingHistory(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.clearMVPNCallingHistory(session);
  }
  
  public java.lang.String addDefaultContactList(java.lang.String unitUUID, talk.calling.service.xsd.UnitContact[] unitCnct) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.addDefaultContactList(unitUUID, unitCnct);
  }
  
  public talk.account.service.xsd.Contact queryContactByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.queryContactByNumber(session, calleeNumber);
  }
  
  public java.lang.String delCallingHistory(java.lang.String session, java.lang.String historyID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.delCallingHistory(session, historyID);
  }
  
  public java.lang.String cancelCallingByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.cancelCallingByNumber(session, calleeNumber);
  }
  
  public java.lang.String startCallingByWebMVPN(java.lang.String caller, java.lang.String callee) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByWebMVPN(caller, callee);
  }
  
  public java.lang.String cancelCallingByCallee(java.lang.String session, java.lang.String callID) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.cancelCallingByCallee(session, callID);
  }
  
  public java.lang.String releaseSIPAccount(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.releaseSIPAccount(session);
  }
  
  public java.lang.String sipServerNotificationMVPN(java.lang.String caller, java.lang.String callee, java.lang.Integer status) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.sipServerNotificationMVPN(caller, callee, status);
  }
  
  public java.lang.String startCallingByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.startCallingByNumber(session, calleeNumber);
  }
  
  public talk.calling.service.xsd.NationalCode[] getNationalCode(java.lang.String systemHandShake) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getNationalCode(systemHandShake);
  }
  
  public java.lang.String[] getMappingList(java.lang.String session) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.getMappingList(session);
  }
  
  public java.lang.String deleteMappingPhone(java.lang.String session, java.lang.String[] mappingNumLst) throws java.rmi.RemoteException{
    if (callingServiceImplServicePortType == null)
      _initCallingServiceImplServicePortTypeProxy();
    return callingServiceImplServicePortType.deleteMappingPhone(session, mappingNumLst);
  }
  
  
}