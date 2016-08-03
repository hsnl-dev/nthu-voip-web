/**
 * SetMVPNTelecom.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class SetMVPNTelecom  implements java.io.Serializable {
    private java.lang.String number;

    private java.lang.String telecom;

    private java.lang.String adminKey;

    public SetMVPNTelecom() {
    }

    public SetMVPNTelecom(
           java.lang.String number,
           java.lang.String telecom,
           java.lang.String adminKey) {
           this.number = number;
           this.telecom = telecom;
           this.adminKey = adminKey;
    }


    /**
     * Gets the number value for this SetMVPNTelecom.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this SetMVPNTelecom.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the telecom value for this SetMVPNTelecom.
     * 
     * @return telecom
     */
    public java.lang.String getTelecom() {
        return telecom;
    }


    /**
     * Sets the telecom value for this SetMVPNTelecom.
     * 
     * @param telecom
     */
    public void setTelecom(java.lang.String telecom) {
        this.telecom = telecom;
    }


    /**
     * Gets the adminKey value for this SetMVPNTelecom.
     * 
     * @return adminKey
     */
    public java.lang.String getAdminKey() {
        return adminKey;
    }


    /**
     * Sets the adminKey value for this SetMVPNTelecom.
     * 
     * @param adminKey
     */
    public void setAdminKey(java.lang.String adminKey) {
        this.adminKey = adminKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetMVPNTelecom)) return false;
        SetMVPNTelecom other = (SetMVPNTelecom) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.telecom==null && other.getTelecom()==null) || 
             (this.telecom!=null &&
              this.telecom.equals(other.getTelecom()))) &&
            ((this.adminKey==null && other.getAdminKey()==null) || 
             (this.adminKey!=null &&
              this.adminKey.equals(other.getAdminKey())));
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
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getTelecom() != null) {
            _hashCode += getTelecom().hashCode();
        }
        if (getAdminKey() != null) {
            _hashCode += getAdminKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetMVPNTelecom.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">setMVPNTelecom"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telecom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "telecom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adminKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "adminKey"));
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
