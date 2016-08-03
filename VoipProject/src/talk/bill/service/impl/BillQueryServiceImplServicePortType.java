/**
 * BillQueryServiceImplServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.bill.service.impl;

public interface BillQueryServiceImplServicePortType extends java.rmi.Remote {
    public talk.billing.service.xsd.BillDetail[] queryBillDetailByTimeStamp(java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException;
    public java.lang.String payByCard(java.lang.String cardUUID, java.lang.Float cost) throws java.rmi.RemoteException;
    public java.lang.String insertCDR(java.lang.String username, talk.billing.service.xsd.CDR newCDR) throws java.rmi.RemoteException;
    public java.lang.String insertBillDetail(java.lang.String username, talk.billing.service.xsd.BillDetail newBillDetail) throws java.rmi.RemoteException;
    public talk.billing.service.xsd.BillDetail[] queryBillDetailByCaller(java.lang.String callerNumber) throws java.rmi.RemoteException;
    public java.lang.String queryAccountByUUID(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String queryAccountByID(java.lang.Integer userid) throws java.rmi.RemoteException;
    public java.lang.Integer getProgram(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.Boolean exceedBudget(java.lang.String cardUUID) throws java.rmi.RemoteException;
    public java.lang.String findPayID(java.lang.String username) throws java.rmi.RemoteException;
    public talk.billing.service.xsd.Point queryPointBySession(java.lang.String session) throws java.rmi.RemoteException;
}
