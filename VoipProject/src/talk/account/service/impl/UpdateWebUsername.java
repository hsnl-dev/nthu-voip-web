/**
 * UpdateWebUsername.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class UpdateWebUsername  implements java.io.Serializable {
    private java.lang.String session;

    private java.lang.String accountUUID;

    private java.lang.String newUsername;

    public UpdateWebUsername() {
    }

    public UpdateWebUsername(
           java.lang.String session,
           java.lang.String accountUUID,
           java.lang.String newUsername) {
           this.session = session;
           this.accountUUID = accountUUID;
           this.newUsername = newUsername;
    }


    /**
     * Gets the session value for this UpdateWebUsername.
     * 
     * @return session
     */
    public java.lang.String getSession() {
        return session;
    }


    /**
     * Sets the session value for this UpdateWebUsername.
     * 
     * @param session
     */
    public void setSession(java.lang.String session) {
        this.session = session;
    }


    /**
     * Gets the accountUUID value for this UpdateWebUsername.
     * 
     * @return accountUUID
     */
    public java.lang.String getAccountUUID() {
        return accountUUID;
    }


    /**
     * Sets the accountUUID value for this UpdateWebUsername.
     * 
     * @param accountUUID
     */
    public void setAccountUUID(java.lang.String accountUUID) {
        this.accountUUID = accountUUID;
    }


    /**
     * Gets the newUsername value for this UpdateWebUsername.
     * 
     * @return newUsername
     */
    public java.lang.String getNewUsername() {
        return newUsername;
    }


    /**
     * Sets the newUsername value for this UpdateWebUsername.
     * 
     * @param newUsername
     */
    public void setNewUsername(java.lang.String newUsername) {
        this.newUsername = newUsername;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateWebUsername)) return false;
        UpdateWebUsername other = (UpdateWebUsername) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.session==null && other.getSession()==null) || 
             (this.session!=null &&
              this.session.equals(other.getSession()))) &&
            ((this.accountUUID==null && other.getAccountUUID()==null) || 
             (this.accountUUID!=null &&
              this.accountUUID.equals(other.getAccountUUID()))) &&
            ((this.newUsername==null && other.getNewUsername()==null) || 
             (this.newUsername!=null &&
              this.newUsername.equals(other.getNewUsername())));
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
        if (getSession() != null) {
            _hashCode += getSession().hashCode();
        }
        if (getAccountUUID() != null) {
            _hashCode += getAccountUUID().hashCode();
        }
        if (getNewUsername() != null) {
            _hashCode += getNewUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateWebUsername.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">updateWebUsername"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "session"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newUsername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "newUsername"));
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
