/**
 * RemoveUnitFromList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class RemoveUnitFromList  implements java.io.Serializable {
    private java.lang.String serverHandshake;

    private java.lang.String unitName;

    public RemoveUnitFromList() {
    }

    public RemoveUnitFromList(
           java.lang.String serverHandshake,
           java.lang.String unitName) {
           this.serverHandshake = serverHandshake;
           this.unitName = unitName;
    }


    /**
     * Gets the serverHandshake value for this RemoveUnitFromList.
     * 
     * @return serverHandshake
     */
    public java.lang.String getServerHandshake() {
        return serverHandshake;
    }


    /**
     * Sets the serverHandshake value for this RemoveUnitFromList.
     * 
     * @param serverHandshake
     */
    public void setServerHandshake(java.lang.String serverHandshake) {
        this.serverHandshake = serverHandshake;
    }


    /**
     * Gets the unitName value for this RemoveUnitFromList.
     * 
     * @return unitName
     */
    public java.lang.String getUnitName() {
        return unitName;
    }


    /**
     * Sets the unitName value for this RemoveUnitFromList.
     * 
     * @param unitName
     */
    public void setUnitName(java.lang.String unitName) {
        this.unitName = unitName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemoveUnitFromList)) return false;
        RemoveUnitFromList other = (RemoveUnitFromList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serverHandshake==null && other.getServerHandshake()==null) || 
             (this.serverHandshake!=null &&
              this.serverHandshake.equals(other.getServerHandshake()))) &&
            ((this.unitName==null && other.getUnitName()==null) || 
             (this.unitName!=null &&
              this.unitName.equals(other.getUnitName())));
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
        if (getServerHandshake() != null) {
            _hashCode += getServerHandshake().hashCode();
        }
        if (getUnitName() != null) {
            _hashCode += getUnitName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RemoveUnitFromList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">removeUnitFromList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverHandshake");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "serverHandshake"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "unitName"));
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
