/**
 * GetUnitname.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class GetUnitname  implements java.io.Serializable {
    private java.lang.String systemHandShake;

    private java.lang.String accountUUID;

    public GetUnitname() {
    }

    public GetUnitname(
           java.lang.String systemHandShake,
           java.lang.String accountUUID) {
           this.systemHandShake = systemHandShake;
           this.accountUUID = accountUUID;
    }


    /**
     * Gets the systemHandShake value for this GetUnitname.
     * 
     * @return systemHandShake
     */
    public java.lang.String getSystemHandShake() {
        return systemHandShake;
    }


    /**
     * Sets the systemHandShake value for this GetUnitname.
     * 
     * @param systemHandShake
     */
    public void setSystemHandShake(java.lang.String systemHandShake) {
        this.systemHandShake = systemHandShake;
    }


    /**
     * Gets the accountUUID value for this GetUnitname.
     * 
     * @return accountUUID
     */
    public java.lang.String getAccountUUID() {
        return accountUUID;
    }


    /**
     * Sets the accountUUID value for this GetUnitname.
     * 
     * @param accountUUID
     */
    public void setAccountUUID(java.lang.String accountUUID) {
        this.accountUUID = accountUUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUnitname)) return false;
        GetUnitname other = (GetUnitname) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.systemHandShake==null && other.getSystemHandShake()==null) || 
             (this.systemHandShake!=null &&
              this.systemHandShake.equals(other.getSystemHandShake()))) &&
            ((this.accountUUID==null && other.getAccountUUID()==null) || 
             (this.accountUUID!=null &&
              this.accountUUID.equals(other.getAccountUUID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSystemHandShake() != null) {
            _hashCode += getSystemHandShake().hashCode();
        }
        if (getAccountUUID() != null) {
            _hashCode += getAccountUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUnitname.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">getUnitname"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemHandShake");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "systemHandShake"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "accountUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
