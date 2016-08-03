/**
 * ConCallCallingServiceImplPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.concall.calling.service.impl;

public interface ConCallCallingServiceImplPortType extends java.rmi.Remote {
    public java.lang.String sipTerminateUser(java.lang.String UUID, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String webStartMeeting(java.lang.String session, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String webInviteMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String getHistoryList(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String getMeetingInfo(java.lang.String session, java.lang.String[] UUIDList) throws java.rmi.RemoteException;
    public java.lang.String fuck(java.lang.String s) throws java.rmi.RemoteException;
    public java.lang.String testConCall(java.lang.String s) throws java.rmi.RemoteException;
    public java.lang.String kickMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String inviteMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String startMeeting(java.lang.String session, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String getMemberState(java.lang.String session, java.lang.String UUID) throws java.rmi.RemoteException;
    public java.lang.String sipBusyUser(java.lang.String UUID, java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String webKickMember(java.lang.String session, java.lang.String UUID, java.lang.String[] number) throws java.rmi.RemoteException;
    public java.lang.String sipAcceptUser(java.lang.String number, java.lang.String roomNumber) throws java.rmi.RemoteException;
    public java.lang.String forceTerminate(java.lang.String UUID) throws java.rmi.RemoteException;
    public java.lang.String hostTerminate(java.lang.String session, java.lang.String UUID) throws java.rmi.RemoteException;
}
