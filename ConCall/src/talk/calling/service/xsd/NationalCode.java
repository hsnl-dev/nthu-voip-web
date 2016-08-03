/**
 * NationalCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.calling.service.xsd;

public class NationalCode  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.String nation;

    private java.lang.String nationalPreCode;

    public NationalCode() {
    }

    public NationalCode(
           java.lang.String UUID,
           java.lang.String nation,
           java.lang.String nationalPreCode) {
           this.UUID = UUID;
           this.nation = nation;
           this.nationalPreCode = nationalPreCode;
    }


    /**
     * Gets the UUID value for this NationalCode.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this NationalCode.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the nation value for this NationalCode.
     * 
     * @return nation
     */
    public java.lang.String getNation() {
        return nation;
    }


    /**
     * Sets the nation value for this NationalCode.
     * 
     * @param nation
     */
    public void setNation(java.lang.String nation) {
        this.nation = nation;
    }


    /**
     * Gets the nationalPreCode value for this NationalCode.
     * 
     * @return nationalPreCode
     */
    public java.lang.String getNationalPreCode() {
        return nationalPreCode;
    }


    /**
     * Sets the nationalPreCode value for this NationalCode.
     * 
     * @param nationalPreCode
     */
    public void setNationalPreCode(java.lang.String nationalPreCode) {
        this.nationalPreCode = nationalPreCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NationalCode)) return false;
        NationalCode other = (NationalCode) obj;
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
            ((this.nation==null && other.getNation()==null) || 
             (this.nation!=null &&
              this.nation.equals(other.getNation()))) &&
            ((this.nationalPreCode==null && other.getNationalPreCode()==null) || 
             (this.nationalPreCode!=null &&
              this.nationalPreCode.equals(other.getNationalPreCode())));
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
        if (getNation() != null) {
            _hashCode += getNation().hashCode();
        }
        if (getNationalPreCode() != null) {
            _hashCode += getNationalPreCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NationalCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "NationalCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "nation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationalPreCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "nationalPreCode"));
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
