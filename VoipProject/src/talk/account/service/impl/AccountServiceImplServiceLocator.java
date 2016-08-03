/**
 * AccountServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class AccountServiceImplServiceLocator extends org.apache.axis.client.Service implements talk.account.service.impl.AccountServiceImplService {

    public AccountServiceImplServiceLocator() {
    }


    public AccountServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccountServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AccountServiceImplServiceHttpSoap11Endpoint
    private java.lang.String AccountServiceImplServiceHttpSoap11Endpoint_address = "http://ts.kits.tw/6talkWS/services/AccountServiceImplService.AccountServiceImplServiceHttpSoap11Endpoint/";

    public java.lang.String getAccountServiceImplServiceHttpSoap11EndpointAddress() {
        return AccountServiceImplServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AccountServiceImplServiceHttpSoap11EndpointWSDDServiceName = "AccountServiceImplServiceHttpSoap11Endpoint";

    public java.lang.String getAccountServiceImplServiceHttpSoap11EndpointWSDDServiceName() {
        return AccountServiceImplServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setAccountServiceImplServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        AccountServiceImplServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public talk.account.service.impl.AccountServiceImplServicePortType getAccountServiceImplServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AccountServiceImplServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAccountServiceImplServiceHttpSoap11Endpoint(endpoint);
    }

    public talk.account.service.impl.AccountServiceImplServicePortType getAccountServiceImplServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            talk.account.service.impl.AccountServiceImplServiceSoap11BindingStub _stub = new talk.account.service.impl.AccountServiceImplServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getAccountServiceImplServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAccountServiceImplServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        AccountServiceImplServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (talk.account.service.impl.AccountServiceImplServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                talk.account.service.impl.AccountServiceImplServiceSoap11BindingStub _stub = new talk.account.service.impl.AccountServiceImplServiceSoap11BindingStub(new java.net.URL(AccountServiceImplServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getAccountServiceImplServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AccountServiceImplServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getAccountServiceImplServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.account.talk", "AccountServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.account.talk", "AccountServiceImplServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AccountServiceImplServiceHttpSoap11Endpoint".equals(portName)) {
            setAccountServiceImplServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
