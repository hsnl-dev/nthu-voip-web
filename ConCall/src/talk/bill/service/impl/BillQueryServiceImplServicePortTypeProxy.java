package talk.bill.service.impl;

public class BillQueryServiceImplServicePortTypeProxy implements talk.bill.service.impl.BillQueryServiceImplServicePortType {
  private String _endpoint = null;
  private talk.bill.service.impl.BillQueryServiceImplServicePortType billQueryServiceImplServicePortType = null;
  
  public BillQueryServiceImplServicePortTypeProxy() {
    _initBillQueryServiceImplServicePortTypeProxy();
  }
  
  public BillQueryServiceImplServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initBillQueryServiceImplServicePortTypeProxy();
  }
  
  private void _initBillQueryServiceImplServicePortTypeProxy() {
    try {
      billQueryServiceImplServicePortType = (new talk.bill.service.impl.BillQueryServiceImplServiceLocator()).getBillQueryServiceImplServiceHttpSoap11Endpoint();
      if (billQueryServiceImplServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)billQueryServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)billQueryServiceImplServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (billQueryServiceImplServicePortType != null)
      ((javax.xml.rpc.Stub)billQueryServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.bill.service.impl.BillQueryServiceImplServicePortType getBillQueryServiceImplServicePortType() {
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType;
  }
  
  public talk.billing.service.xsd.BillDetail[] queryBillDetailByTimeStamp(java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.queryBillDetailByTimeStamp(startTime, endTime);
  }
  
  public java.lang.String payByCard(java.lang.String cardUUID, java.lang.Float cost) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.payByCard(cardUUID, cost);
  }
  
  public java.lang.String insertCDR(java.lang.String username, talk.billing.service.xsd.CDR newCDR) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.insertCDR(username, newCDR);
  }
  
  public java.lang.String insertBillDetail(java.lang.String username, talk.billing.service.xsd.BillDetail newBillDetail) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.insertBillDetail(username, newBillDetail);
  }
  
  public talk.billing.service.xsd.BillDetail[] queryBillDetailByCaller(java.lang.String callerNumber) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.queryBillDetailByCaller(callerNumber);
  }
  
  public java.lang.String queryAccountByUUID(java.lang.String uuid) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.queryAccountByUUID(uuid);
  }
  
  public java.lang.String queryAccountByID(java.lang.Integer userid) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.queryAccountByID(userid);
  }
  
  public java.lang.Integer getProgram(java.lang.String username) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.getProgram(username);
  }
  
  public java.lang.Boolean exceedBudget(java.lang.String cardUUID) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.exceedBudget(cardUUID);
  }
  
  public java.lang.String findPayID(java.lang.String username) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.findPayID(username);
  }
  
  public talk.billing.service.xsd.Point queryPointBySession(java.lang.String session) throws java.rmi.RemoteException{
    if (billQueryServiceImplServicePortType == null)
      _initBillQueryServiceImplServicePortTypeProxy();
    return billQueryServiceImplServicePortType.queryPointBySession(session);
  }
  
  
}