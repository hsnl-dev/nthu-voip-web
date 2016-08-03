package talk.account.service.impl;

public class AccountServiceImplServicePortTypeProxy implements talk.account.service.impl.AccountServiceImplServicePortType {
  private String _endpoint = null;
  private talk.account.service.impl.AccountServiceImplServicePortType accountServiceImplServicePortType = null;
  
  public AccountServiceImplServicePortTypeProxy() {
    _initAccountServiceImplServicePortTypeProxy();
  }
  
  public AccountServiceImplServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountServiceImplServicePortTypeProxy();
  }
  
  private void _initAccountServiceImplServicePortTypeProxy() {
    try {
      accountServiceImplServicePortType = (new talk.account.service.impl.AccountServiceImplServiceLocator()).getAccountServiceImplServiceHttpSoap11Endpoint();
      if (accountServiceImplServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountServiceImplServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountServiceImplServicePortType != null)
      ((javax.xml.rpc.Stub)accountServiceImplServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public talk.account.service.impl.AccountServiceImplServicePortType getAccountServiceImplServicePortType() {
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType;
  }
  
  public java.lang.String validateMVPNService(java.lang.String number, java.lang.String authCode, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.validateMVPNService(number, authCode, key);
  }
  
  public java.lang.String loginForeignKits(java.lang.String number, java.lang.String devKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginForeignKits(number, devKey);
  }
  
  public java.lang.String logout(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.logout(session);
  }
  
  public java.lang.String switchNewDevice(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.switchNewDevice(number, key);
  }
  
  public java.lang.String userLevelup(java.lang.String session, java.lang.String parentUUID, java.lang.String userUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.userLevelup(session, parentUUID, userUUID);
  }
  
  public java.lang.Boolean checkMVPN(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.checkMVPN(number);
  }
  
  public java.lang.String normalize(java.lang.String n) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.normalize(n);
  }
  
  public talk.account.service.xsd.WebAccount[] getWebUser(java.lang.String systemHandShake) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getWebUser(systemHandShake);
  }
  
  public java.lang.String delWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.delWebUser(systemHandShake, username);
  }
  
  public java.lang.String getRecommendCode(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getRecommendCode(session);
  }
  
  public java.lang.String addWebSubUser(java.lang.String session, talk.account.service.xsd.WebAccount[] subUser) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.addWebSubUser(session, subUser);
  }
  
  public java.lang.String updateNationStatus(java.lang.String session, java.lang.Boolean abroad) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.updateNationStatus(session, abroad);
  }
  
  public java.lang.String test(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.test(number);
  }
  
  public java.lang.String changePassword(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.changePassword(session, oldPassword, newPassword);
  }
  
  public java.lang.String loginSIPMVPNService(java.lang.String number, java.lang.String key, java.lang.String devKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginSIPMVPNService(number, key, devKey);
  }
  
  public java.lang.String sendWebValidationMail(java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendWebValidationMail(username);
  }
  
  public java.lang.String logoutAdmin(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.logoutAdmin(session);
  }
  
  public java.lang.String loginWebUser(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginWebUser(username, password);
  }
  
  public java.lang.String createUserforMappingService(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.createUserforMappingService(number);
  }
  
  public java.lang.String checkAccountInfo(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.checkAccountInfo(number);
  }
  
  public java.lang.String loginMappingService(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginMappingService(username, password);
  }
  
  public java.lang.String delWebSubUser(java.lang.String session, java.lang.String subUserUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.delWebSubUser(session, subUserUUID);
  }
  
  public talk.billing.service.xsd.Point[] getSubUserPoint(java.lang.String session, java.lang.String[] subUser) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getSubUserPoint(session, subUser);
  }
  
  public java.lang.String setMVPNUnit(java.lang.String number, java.lang.String unit, java.lang.String adminKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.setMVPNUnit(number, unit, adminKey);
  }
  
  public java.lang.String loginMVPNService(java.lang.String number, java.lang.String key, java.lang.String devKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginMVPNService(number, key, devKey);
  }
  
  public java.lang.String sendPasswordEmail(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendPasswordEmail(session);
  }
  
  public java.lang.String registerMVPNServiceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.registerMVPNServiceLink(number, key);
  }
  
  public java.lang.String deleteMVPN(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.deleteMVPN(number);
  }
  
  public java.lang.String chgWebUserPassword(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.chgWebUserPassword(session, oldPassword, newPassword);
  }
  
  public java.lang.String getWebAccountBySession(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getWebAccountBySession(session);
  }
  
  public java.lang.String sendValidationMVPNServiceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendValidationMVPNServiceLink(number, key);
  }
  
  public java.lang.String createAccount(java.lang.String username, java.lang.String password, java.lang.String name, talk.account.service.xsd.Phone mobile) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.createAccount(username, password, name, mobile);
  }
  
  public talk.account.service.xsd.UnitName[] getUnitList(java.lang.String serverHandshake) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getUnitList(serverHandshake);
  }
  
  public java.lang.String createWebUserbyUser(java.lang.String serverHandshake, java.lang.String number, java.lang.String mail, java.lang.String unitUUID, java.lang.String name) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.createWebUserbyUser(serverHandshake, number, mail, unitUUID, name);
  }
  
  public java.lang.String sendValidationMVPNService(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendValidationMVPNService(number);
  }
  
  public talk.account.service.xsd.WebAccount[] getWebSubUser(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getWebSubUser(session);
  }
  
  public java.lang.String verifyWebUser(java.lang.String number, java.lang.String authCode) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.verifyWebUser(number, authCode);
  }
  
  public java.lang.String checkSessionID(java.lang.String username, java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.checkSessionID(username, session);
  }
  
  public talk.account.service.xsd.Account getAccountBySession(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getAccountBySession(session);
  }
  
  public java.lang.String approveWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.approveWebUser(systemHandShake, username);
  }
  
  public java.lang.String sendCustomMsg(java.lang.String number, java.lang.String msg) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendCustomMsg(number, msg);
  }
  
  public java.lang.String registerCloudMessage(java.lang.String session, java.lang.String registrationID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.registerCloudMessage(session, registrationID);
  }
  
  public java.lang.String updateLimitedPoint(java.lang.String session, java.lang.String subUser, java.lang.Float newLimitation) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.updateLimitedPoint(session, subUser, newLimitation);
  }
  
  public java.lang.String loginAdmin(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.loginAdmin(number, key);
  }
  
  public java.lang.String resendOfflinePassword(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.resendOfflinePassword(number);
  }
  
  public java.lang.String login(java.lang.String username, java.lang.String password, java.lang.String registrationID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.login(username, password, registrationID);
  }
  
  public java.lang.String getMVPNTelecom(java.lang.String number, java.lang.String adminKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getMVPNTelecom(number, adminKey);
  }
  
  public java.lang.String denyWebUser(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.denyWebUser(systemHandShake, username);
  }
  
  public java.lang.String addWebUser(java.lang.String number, java.lang.String mail, java.lang.String serverHandshake, java.lang.String unitName, java.lang.String name) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.addWebUser(number, mail, serverHandshake, unitName, name);
  }
  
  public java.lang.String updateWebUsername(java.lang.String session, java.lang.String accountUUID, java.lang.String newUsername) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.updateWebUsername(session, accountUUID, newUsername);
  }
  
  public java.lang.String deleteMVPNAccount(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.deleteMVPNAccount(number);
  }
  
  public java.lang.String getWebUserUnitName(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getWebUserUnitName(session);
  }
  
  public java.lang.String setWebUserUnitName(java.lang.String session, java.lang.String unitName) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.setWebUserUnitName(session, unitName);
  }
  
  public java.lang.String registerMVPNService(java.lang.String number) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.registerMVPNService(number);
  }
  
  public java.lang.String getUnitname(java.lang.String systemHandShake, java.lang.String accountUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getUnitname(systemHandShake, accountUUID);
  }
  
  public talk.account.service.xsd.Account getAccountByUUID(java.lang.String accountUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getAccountByUUID(accountUUID);
  }
  
  public java.lang.Object getSubUser(java.lang.String uuid) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.getSubUser(uuid);
  }
  
  public java.lang.String setMVPNTelecom(java.lang.String number, java.lang.String telecom, java.lang.String adminKey) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.setMVPNTelecom(number, telecom, adminKey);
  }
  
  public java.lang.String sendValidationMail(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.sendValidationMail(username, password);
  }
  
  public java.lang.String keepAlive(java.lang.String session) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.keepAlive(session);
  }
  
  public java.lang.String chgUserPasswordforMappingService(java.lang.String session, java.lang.String oldPassword, java.lang.String newPassword) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.chgUserPasswordforMappingService(session, oldPassword, newPassword);
  }
  
  public java.lang.String degradeWebUser(java.lang.String session, java.lang.String userUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.degradeWebUser(session, userUUID);
  }
  
  public java.lang.String removeUnitFromList(java.lang.String serverHandshake, java.lang.String unitName) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.removeUnitFromList(serverHandshake, unitName);
  }
  
  public java.lang.String switchNewDeviceLink(java.lang.String number, java.lang.String key) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.switchNewDeviceLink(number, key);
  }
  
  public java.lang.String deleteAccount(java.lang.String accountUUID) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.deleteAccount(accountUUID);
  }
  
  public java.lang.String setNickname(java.lang.String number, java.lang.String key, java.lang.String name) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.setNickname(number, key, name);
  }
  
  public java.lang.String updateWebUser(java.lang.String session, talk.account.service.xsd.WebAccount webUser) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.updateWebUser(session, webUser);
  }
  
  public java.lang.String resetPasswordMail(java.lang.String systemHandShake, java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.resetPasswordMail(systemHandShake, username);
  }
  
  public java.lang.String checkUsername(java.lang.String username) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.checkUsername(username);
  }
  
  public java.lang.String registerMVPN(java.lang.String number, java.lang.String preCode) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.registerMVPN(number, preCode);
  }
  
  public java.lang.String validateMail(java.lang.String username, java.lang.String password, java.lang.String code) throws java.rmi.RemoteException{
    if (accountServiceImplServicePortType == null)
      _initAccountServiceImplServicePortTypeProxy();
    return accountServiceImplServicePortType.validateMail(username, password, code);
  }
  
  
}