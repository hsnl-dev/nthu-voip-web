/**
 * UnitName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.xsd;

public class UnitName  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.String unitName;

    private java.lang.String unitUUID;

    public UnitName() {
    }

    public UnitName(
           java.lang.String UUID,
           java.lang.String unitName,
           java.lang.String unitUUID) {
           this.UUID = UUID;
           this.unitName = unitName;
           this.unitUUID = unitUUID;
    }


    /**
     * Gets the UUID value for this UnitName.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this UnitName.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the unitName value for this UnitName.
     * 
     * @return unitName
     */
    public java.lang.String getUnitName() {
        return unitName;
    }


    /**
     * Sets the unitName value for this UnitName.
     * 
     * @param unitName
     */
    public void setUnitName(java.lang.String unitName) {
        this.unitName = unitName;
    }


    /**
     * Gets the unitUUID value for this UnitName.
     * 
     * @return unitUUID
     */
    public java.lang.String getUnitUUID() {
        return unitUUID;
    }


    /**
     * Sets the unitUUID value for this UnitName.
     * 
     * @param unitUUID
     */
    public void setUnitUUID(java.lang.String unitUUID) {
        this.unitUUID = unitUUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnitName)) return false;
        UnitName other = (UnitName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID()))) &&
            ((this.unitName==null && other.getUnitName()==null) || 
             (this.unitName!=null &&
              this.unitName.equals(other.getUnitName()))) &&
            ((this.unitUUID==null && other.getUnitUUID()==null) || 
             (this.unitUUID!=null &&
              this.unitUUID.equals(other.getUnitUUID())));
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
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        if (getUnitName() != null) {
            _hashCode += getUnitName().hashCode();
        }
        if (getUnitUUID() != null) {
            _hashCode += getUnitUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnitName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "UnitName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "unitName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "unitUUID"));
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
