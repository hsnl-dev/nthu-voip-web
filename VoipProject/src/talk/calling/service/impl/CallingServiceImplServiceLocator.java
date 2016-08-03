/**
 * CallingServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.calling.service.impl;

public class CallingServiceImplServiceLocator extends org.apache.axis.client.Service implements talk.calling.service.impl.CallingServiceImplService {

    public CallingServiceImplServiceLocator() {
    }


    public CallingServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CallingServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CallingServiceImplServiceHttpSoap11Endpoint
    private java.lang.String CallingServiceImplServiceHttpSoap11Endpoint_address = "http://ts.kits.tw/6talkWS/services/CallingServiceImplService.CallingServiceImplServiceHttpSoap11Endpoint/";

    public java.lang.String getCallingServiceImplServiceHttpSoap11EndpointAddress() {
        return CallingServiceImplServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CallingServiceImplServiceHttpSoap11EndpointWSDDServiceName = "CallingServiceImplServiceHttpSoap11Endpoint";

    public java.lang.String getCallingServiceImplServiceHttpSoap11EndpointWSDDServiceName() {
        return CallingServiceImplServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setCallingServiceImplServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        CallingServiceImplServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public talk.calling.service.impl.CallingServiceImplServicePortType getCallingServiceImplServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CallingServiceImplServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCallingServiceImplServiceHttpSoap11Endpoint(endpoint);
    }

    public talk.calling.service.impl.CallingServiceImplServicePortType getCallingServiceImplServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            talk.calling.service.impl.CallingServiceImplServiceSoap11BindingStub _stub = new talk.calling.service.impl.CallingServiceImplServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getCallingServiceImplServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCallingServiceImplServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        CallingServiceImplServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (talk.calling.service.impl.CallingServiceImplServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                talk.calling.service.impl.CallingServiceImplServiceSoap11BindingStub _stub = new talk.calling.service.impl.CallingServiceImplServiceSoap11BindingStub(new java.net.URL(CallingServiceImplServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getCallingServiceImplServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("CallingServiceImplServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getCallingServiceImplServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.calling.talk", "CallingServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.calling.talk", "CallingServiceImplServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CallingServiceImplServiceHttpSoap11Endpoint".equals(portName)) {
            setCallingServiceImplServiceHttpSoap11EndpointEndpointAddress(address);
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
