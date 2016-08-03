/**
 * UserLevelup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class UserLevelup  implements java.io.Serializable {
    private java.lang.String session;

    private java.lang.String parentUUID;

    private java.lang.String userUUID;

    public UserLevelup() {
    }

    public UserLevelup(
           java.lang.String session,
           java.lang.String parentUUID,
           java.lang.String userUUID) {
           this.session = session;
           this.parentUUID = parentUUID;
           this.userUUID = userUUID;
    }


    /**
     * Gets the session value for this UserLevelup.
     * 
     * @return session
     */
    public java.lang.String getSession() {
        return session;
    }


    /**
     * Sets the session value for this UserLevelup.
     * 
     * @param session
     */
    public void setSession(java.lang.String session) {
        this.session = session;
    }


    /**
     * Gets the parentUUID value for this UserLevelup.
     * 
     * @return parentUUID
     */
    public java.lang.String getParentUUID() {
        return parentUUID;
    }


    /**
     * Sets the parentUUID value for this UserLevelup.
     * 
     * @param parentUUID
     */
    public void setParentUUID(java.lang.String parentUUID) {
        this.parentUUID = parentUUID;
    }


    /**
     * Gets the userUUID value for this UserLevelup.
     * 
     * @return userUUID
     */
    public java.lang.String getUserUUID() {
        return userUUID;
    }


    /**
     * Sets the userUUID value for this UserLevelup.
     * 
     * @param userUUID
     */
    public void setUserUUID(java.lang.String userUUID) {
        this.userUUID = userUUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserLevelup)) return false;
        UserLevelup other = (UserLevelup) obj;
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
            ((this.parentUUID==null && other.getParentUUID()==null) || 
             (this.parentUUID!=null &&
              this.parentUUID.equals(other.getParentUUID()))) &&
            ((this.userUUID==null && other.getUserUUID()==null) || 
             (this.userUUID!=null &&
              this.userUUID.equals(other.getUserUUID())));
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
        if (getParentUUID() != null) {
            _hashCode += getParentUUID().hashCode();
        }
        if (getUserUUID() != null) {
            _hashCode += getUserUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserLevelup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">userLevelup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "parentUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "userUUID"));
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
