/**
 * AddWebSubUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class AddWebSubUser  implements java.io.Serializable {
    private java.lang.String session;

    private talk.account.service.xsd.WebAccount[] subUser;

    public AddWebSubUser() {
    }

    public AddWebSubUser(
           java.lang.String session,
           talk.account.service.xsd.WebAccount[] subUser) {
           this.session = session;
           this.subUser = subUser;
    }


    /**
     * Gets the session value for this AddWebSubUser.
     * 
     * @return session
     */
    public java.lang.String getSession() {
        return session;
    }


    /**
     * Sets the session value for this AddWebSubUser.
     * 
     * @param session
     */
    public void setSession(java.lang.String session) {
        this.session = session;
    }


    /**
     * Gets the subUser value for this AddWebSubUser.
     * 
     * @return subUser
     */
    public talk.account.service.xsd.WebAccount[] getSubUser() {
        return subUser;
    }


    /**
     * Sets the subUser value for this AddWebSubUser.
     * 
     * @param subUser
     */
    public void setSubUser(talk.account.service.xsd.WebAccount[] subUser) {
        this.subUser = subUser;
    }

    public talk.account.service.xsd.WebAccount getSubUser(int i) {
        return this.subUser[i];
    }

    public void setSubUser(int i, talk.account.service.xsd.WebAccount _value) {
        this.subUser[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddWebSubUser)) return false;
        AddWebSubUser other = (AddWebSubUser) obj;
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
            ((this.subUser==null && other.getSubUser()==null) || 
             (this.subUser!=null &&
              java.util.Arrays.equals(this.subUser, other.getSubUser())));
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
        if (getSubUser() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubUser());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubUser(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddWebSubUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">addWebSubUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "subUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "WebAccount"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
