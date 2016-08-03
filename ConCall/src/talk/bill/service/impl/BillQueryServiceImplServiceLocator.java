/**
 * BillQueryServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.bill.service.impl;

public class BillQueryServiceImplServiceLocator extends org.apache.axis.client.Service implements talk.bill.service.impl.BillQueryServiceImplService {

    public BillQueryServiceImplServiceLocator() {
    }


    public BillQueryServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BillQueryServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BillQueryServiceImplServiceHttpSoap11Endpoint
    private java.lang.String BillQueryServiceImplServiceHttpSoap11Endpoint_address = "http://scb.kits.tw:8080/6talkWS/services/BillQueryServiceImplService.BillQueryServiceImplServiceHttpSoap11Endpoint/";

    public java.lang.String getBillQueryServiceImplServiceHttpSoap11EndpointAddress() {
        return BillQueryServiceImplServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName = "BillQueryServiceImplServiceHttpSoap11Endpoint";

    public java.lang.String getBillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName() {
        return BillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setBillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        BillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public talk.bill.service.impl.BillQueryServiceImplServicePortType getBillQueryServiceImplServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BillQueryServiceImplServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBillQueryServiceImplServiceHttpSoap11Endpoint(endpoint);
    }

    public talk.bill.service.impl.BillQueryServiceImplServicePortType getBillQueryServiceImplServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            talk.bill.service.impl.BillQueryServiceImplServiceSoap11BindingStub _stub = new talk.bill.service.impl.BillQueryServiceImplServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getBillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBillQueryServiceImplServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        BillQueryServiceImplServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (talk.bill.service.impl.BillQueryServiceImplServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                talk.bill.service.impl.BillQueryServiceImplServiceSoap11BindingStub _stub = new talk.bill.service.impl.BillQueryServiceImplServiceSoap11BindingStub(new java.net.URL(BillQueryServiceImplServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getBillQueryServiceImplServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("BillQueryServiceImplServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getBillQueryServiceImplServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.bill.talk", "BillQueryServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.bill.talk", "BillQueryServiceImplServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BillQueryServiceImplServiceHttpSoap11Endpoint".equals(portName)) {
            setBillQueryServiceImplServiceHttpSoap11EndpointEndpointAddress(address);
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
