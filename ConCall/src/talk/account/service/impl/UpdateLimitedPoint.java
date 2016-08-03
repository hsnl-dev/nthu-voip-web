/**
 * UpdateLimitedPoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class UpdateLimitedPoint  implements java.io.Serializable {
    private java.lang.String session;

    private java.lang.String subUser;

    private java.lang.Float newLimitation;

    public UpdateLimitedPoint() {
    }

    public UpdateLimitedPoint(
           java.lang.String session,
           java.lang.String subUser,
           java.lang.Float newLimitation) {
           this.session = session;
           this.subUser = subUser;
           this.newLimitation = newLimitation;
    }


    /**
     * Gets the session value for this UpdateLimitedPoint.
     * 
     * @return session
     */
    public java.lang.String getSession() {
        return session;
    }


    /**
     * Sets the session value for this UpdateLimitedPoint.
     * 
     * @param session
     */
    public void setSession(java.lang.String session) {
        this.session = session;
    }


    /**
     * Gets the subUser value for this UpdateLimitedPoint.
     * 
     * @return subUser
     */
    public java.lang.String getSubUser() {
        return subUser;
    }


    /**
     * Sets the subUser value for this UpdateLimitedPoint.
     * 
     * @param subUser
     */
    public void setSubUser(java.lang.String subUser) {
        this.subUser = subUser;
    }


    /**
     * Gets the newLimitation value for this UpdateLimitedPoint.
     * 
     * @return newLimitation
     */
    public java.lang.Float getNewLimitation() {
        return newLimitation;
    }


    /**
     * Sets the newLimitation value for this UpdateLimitedPoint.
     * 
     * @param newLimitation
     */
    public void setNewLimitation(java.lang.Float newLimitation) {
        this.newLimitation = newLimitation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateLimitedPoint)) return false;
        UpdateLimitedPoint other = (UpdateLimitedPoint) obj;
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
              this.subUser.equals(other.getSubUser()))) &&
            ((this.newLimitation==null && other.getNewLimitation()==null) || 
             (this.newLimitation!=null &&
              this.newLimitation.equals(other.getNewLimitation())));
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
            _hashCode += getSubUser().hashCode();
        }
        if (getNewLimitation() != null) {
            _hashCode += getNewLimitation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateLimitedPoint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">updateLimitedPoint"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newLimitation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "newLimitation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
