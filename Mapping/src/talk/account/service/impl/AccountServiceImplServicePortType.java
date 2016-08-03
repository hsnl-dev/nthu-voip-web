/**
 * AccountServiceImplServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public interface AccountServiceImplServicePortType extends java.rmi.Remote {
    public java.lang.String validateMVPNService(java.lang.String number, java.lang.String authCode, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String loginForeignKits(java.lang.String number, java.lang.String devKey) throws java.rmi.RemoteException;
    public java.lang.String logout(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String switchNewDevice(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String userLevelup(java.lang.String session, java.lang.String parentUUID, java.lang.String userUUID) throws java.rmi.RemoteException;
    public java.lang.Boolean checkMVPN(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String normalize(java.lang.String n) throws java.rmi.RemoteException;
    public talk.account.service.xsd.WebAccount[] getWebUser(java.lang.String systemHandShake) throws java.rmi.RemoteException;
    public java.lang.String delWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String getRecommendCode(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String addWebSubUser(java.lang.String session, talk.account.service.xsd.WebAccount[] subUser) throws java.rmi.RemoteException;
    public java.lang.String updateNationStatus(java.lang.String session, java.lang.Boolean abroad) throws java.rmi.RemoteException;
    public java.lang.String test(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String changePassword(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException;
    public java.lang.String loginSIPMVPNService(java.lang.String number, java.lang.String key, java.lang.String devKey) throws java.rmi.RemoteException;
    public java.lang.String sendWebValidationMail(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String logoutAdmin(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String loginWebUser(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String createUserforMappingService(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String checkAccountInfo(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String loginMappingService(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String delWebSubUser(java.lang.String session, java.lang.String subUserUUID) throws java.rmi.RemoteException;
    public talk.billing.service.xsd.Point[] getSubUserPoint(java.lang.String session, java.lang.String[] subUser) throws java.rmi.RemoteException;
    public java.lang.String setMVPNUnit(java.lang.String number, java.lang.String unit, java.lang.String adminKey) throws java.rmi.RemoteException;
    public java.lang.String loginMVPNService(java.lang.String number, java.lang.String key, java.lang.String devKey) throws java.rmi.RemoteException;
    public java.lang.String sendPasswordEmail(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String registerMVPNServiceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String deleteMVPN(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String chgWebUserPassword(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException;
    public java.lang.String getWebAccountBySession(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String sendValidationMVPNServiceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String createAccount(java.lang.String username, java.lang.String password, java.lang.String name, talk.account.service.xsd.Phone mobile) throws java.rmi.RemoteException;
    public talk.account.service.xsd.UnitName[] getUnitList(java.lang.String serverHandshake) throws java.rmi.RemoteException;
    public java.lang.String createWebUserbyUser(java.lang.String serverHandshake, java.lang.String number, java.lang.String mail, java.lang.String unitUUID, java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String sendValidationMVPNService(java.lang.String number) throws java.rmi.RemoteException;
    public talk.account.service.xsd.WebAccount[] getWebSubUser(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String verifyWebUser(java.lang.String number, java.lang.String authCode) throws java.rmi.RemoteException;
    public java.lang.String checkSessionID(java.lang.String username, java.lang.String session) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Account getAccountBySession(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String approveWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String sendCustomMsg(java.lang.String number, java.lang.String msg) throws java.rmi.RemoteException;
    public java.lang.String registerCloudMessage(java.lang.String session, java.lang.String registrationID) throws java.rmi.RemoteException;
    public java.lang.String updateLimitedPoint(java.lang.String session, java.lang.String subUser, java.lang.Float newLimitation) throws java.rmi.RemoteException;
    public java.lang.String loginAdmin(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String resendOfflinePassword(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String login(java.lang.String username, java.lang.String password, java.lang.String registrationID) throws java.rmi.RemoteException;
    public java.lang.String getMVPNTelecom(java.lang.String number, java.lang.String adminKey) throws java.rmi.RemoteException;
    public java.lang.String denyWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String addWebUser(java.lang.String number, java.lang.String mail, java.lang.String serverHandshake, java.lang.String unitName, java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String updateWebUsername(java.lang.String session, java.lang.String accountUUID, java.lang.String newUsername) throws java.rmi.RemoteException;
    public java.lang.String deleteMVPNAccount(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String getWebUserUnitName(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String setWebUserUnitName(java.lang.String session, java.lang.String unitName) throws java.rmi.RemoteException;
    public java.lang.String registerMVPNService(java.lang.String number) throws java.rmi.RemoteException;
    public java.lang.String getUnitname(java.lang.String systemHandShake, java.lang.String accountUUID) throws java.rmi.RemoteException;
    public talk.account.service.xsd.Account getAccountByUUID(java.lang.String accountUUID) throws java.rmi.RemoteException;
    public java.lang.Object getSubUser(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String setMVPNTelecom(java.lang.String number, java.lang.String telecom, java.lang.String adminKey) throws java.rmi.RemoteException;
    public java.lang.String sendValidationMail(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String keepAlive(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.String chgUserPasswordforMappingService(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException;
    public java.lang.String degradeWebUser(java.lang.String session, java.lang.String userUUID) throws java.rmi.RemoteException;
    public java.lang.String removeUnitFromList(java.lang.String serverHandshake, java.lang.String unitName) throws java.rmi.RemoteException;
    public java.lang.String switchNewDeviceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException;
    public java.lang.String deleteAccount(java.lang.String accountUUID) throws java.rmi.RemoteException;
    public java.lang.String setNickname(java.lang.String number, java.lang.String key, java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String updateWebUser(java.lang.String session, talk.account.service.xsd.WebAccount webUser) throws java.rmi.RemoteException;
    public java.lang.String resetPasswordMail(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String checkUsername(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String registerMVPN(java.lang.String number, java.lang.String preCode) throws java.rmi.RemoteException;
    public java.lang.String validateMail(java.lang.String username, java.lang.String password, java.lang.String code) throws java.rmi.RemoteException;
}
