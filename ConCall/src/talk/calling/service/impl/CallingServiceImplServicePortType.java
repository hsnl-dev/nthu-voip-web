/**
 * CallingServiceImplServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.calling.service.impl;

public interface CallingServiceImplServicePortType extends java.rmi.Remote {
    public java.lang.String getHistoryHash(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String addNationalCode(java.lang.String systemHandShake, talk.calling.service.xsd.NationalCode[] code) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.Notification[] pollingMessage(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String initFreeList(java.lang.String[] freeMapping) throws java.rmi.RemoteException;
    public java.lang.String startCallingMVPNSIP(java.lang.String number, java.lang.String mappingNumber) throws java.rmi.RemoteException;
    public java.lang.String editMappingPhone(java.lang.String session, talk.calling.service.xsd.MappingPhone[] mappingPneLst) throws java.rmi.RemoteException;
    public java.lang.String startCallingByContact(java.lang.String session, java.lang.String contactID) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.UnitContact[] getDefaultContactList(java.lang.String unitUUID) throws java.rmi.RemoteException;
    public java.lang.String startCallingMVPNSIPByApp(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.History[] getCallingHistory(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String clearDefaultContactList(java.lang.String unitUUID) throws java.rmi.RemoteException;
    public java.lang.String startCallingByForeign(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String clearCallingHistory(java.lang.String session) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.SoftPhone allocateSIPAccount(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String callByShih(java.lang.String number, java.lang.String mappingNumber) throws java.rmi.RemoteException;
    public java.lang.String startingCalling(java.lang.String callerNum, java.lang.String calleeNumber, java.lang.String callerID, java.lang.String calleeID, java.lang.String card, java.lang.String whois) throws java.rmi.RemoteException;
    public java.lang.String startCallingByWeb(java.lang.String session, java.lang.String number) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.MappingPhone[] getMappedList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String addMappingPhone(java.lang.String session, talk.calling.service.xsd.MappingPhone[] mappingPneLst) throws java.rmi.RemoteException;
    public java.lang.String startCallingByMVPN(java.lang.String session, java.lang.String contactID, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String sendMessageByUser(java.lang.String session, talk.calling.service.xsd.Notification msg) throws java.rmi.RemoteException;
    public java.lang.String cancelCallingByMVPN(java.lang.String session, java.lang.String number, java.lang.Boolean callee) throws java.rmi.RemoteException;
    public java.lang.String getUnitUUID(java.lang.String session) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.MVPNHistory[] getMVPNCallingHistory(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String delMVPNCallingHistoryList(java.lang.String session, talk.calling.service.xsd.MVPNHistory[] historyList) throws java.rmi.RemoteException;
    public java.lang.String cancelCallingByContact(java.lang.String session, java.lang.String contactID) throws java.rmi.RemoteException;
    public java.lang.String delDefaultContactList(java.lang.String unitUUID, talk.calling.service.xsd.UnitContact[] unitCnct) throws java.rmi.RemoteException;
    public java.lang.String restoreMappingList(java.lang.String systemHandShake, java.lang.String number, java.lang.String[] freeMapping) throws java.rmi.RemoteException;
    public java.lang.String clearMVPNCallingHistory(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String addDefaultContactList(java.lang.String unitUUID, talk.calling.service.xsd.UnitContact[] unitCnct) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Contact queryContactByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException;
    public java.lang.String delCallingHistory(java.lang.String session, java.lang.String historyID) throws java.rmi.RemoteException;
    public java.lang.String cancelCallingByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException;
    public java.lang.String startCallingByWebMVPN(java.lang.String caller, java.lang.String callee) throws java.rmi.RemoteException;
    public java.lang.String cancelCallingByCallee(java.lang.String session, java.lang.String callID) throws java.rmi.RemoteException;
    public java.lang.String releaseSIPAccount(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String sipServerNotificationMVPN(java.lang.String caller, java.lang.String callee, java.lang.Integer status) throws java.rmi.RemoteException;
    public java.lang.String startCallingByNumber(java.lang.String session, java.lang.String calleeNumber) throws java.rmi.RemoteException;
    public talk.calling.service.xsd.NationalCode[] getNationalCode(java.lang.String systemHandShake) throws java.rmi.RemoteException;
    public java.lang.String[] getMappingList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String deleteMappingPhone(java.lang.String session, java.lang.String[] mappingNumLst) throws java.rmi.RemoteException;
}
