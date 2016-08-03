/**
 * MVPNHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.calling.service.xsd;

public class MVPNHistory  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.Long duration;

    private java.lang.Long endTime;

    private java.lang.String number;

    private java.lang.String ourNumber;

    private java.lang.Long startTime;

    private java.lang.Integer status;

    public MVPNHistory() {
    }

    public MVPNHistory(
           java.lang.String UUID,
           java.lang.Long duration,
           java.lang.Long endTime,
           java.lang.String number,
           java.lang.String ourNumber,
           java.lang.Long startTime,
           java.lang.Integer status) {
           this.UUID = UUID;
           this.duration = duration;
           this.endTime = endTime;
           this.number = number;
           this.ourNumber = ourNumber;
           this.startTime = startTime;
           this.status = status;
    }


    /**
     * Gets the UUID value for this MVPNHistory.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this MVPNHistory.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the duration value for this MVPNHistory.
     * 
     * @return duration
     */
    public java.lang.Long getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this MVPNHistory.
     * 
     * @param duration
     */
    public void setDuration(java.lang.Long duration) {
        this.duration = duration;
    }


    /**
     * Gets the endTime value for this MVPNHistory.
     * 
     * @return endTime
     */
    public java.lang.Long getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this MVPNHistory.
     * 
     * @param endTime
     */
    public void setEndTime(java.lang.Long endTime) {
        this.endTime = endTime;
    }


    /**
     * Gets the number value for this MVPNHistory.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this MVPNHistory.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the ourNumber value for this MVPNHistory.
     * 
     * @return ourNumber
     */
    public java.lang.String getOurNumber() {
        return ourNumber;
    }


    /**
     * Sets the ourNumber value for this MVPNHistory.
     * 
     * @param ourNumber
     */
    public void setOurNumber(java.lang.String ourNumber) {
        this.ourNumber = ourNumber;
    }


    /**
     * Gets the startTime value for this MVPNHistory.
     * 
     * @return startTime
     */
    public java.lang.Long getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this MVPNHistory.
     * 
     * @param startTime
     */
    public void setStartTime(java.lang.Long startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the status value for this MVPNHistory.
     * 
     * @return status
     */
    public java.lang.Integer getStatus() {
        return status;
    }


    /**
     * Sets the status value for this MVPNHistory.
     * 
     * @param status
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MVPNHistory)) return false;
        MVPNHistory other = (MVPNHistory) obj;
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
            ((this.duration==null && other.getDuration()==null) || 
             (this.duration!=null &&
              this.duration.equals(other.getDuration()))) &&
            ((this.endTime==null && other.getEndTime()==null) || 
             (this.endTime!=null &&
              this.endTime.equals(other.getEndTime()))) &&
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.ourNumber==null && other.getOurNumber()==null) || 
             (this.ourNumber!=null &&
              this.ourNumber.equals(other.getOurNumber()))) &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getDuration() != null) {
            _hashCode += getDuration().hashCode();
        }
        if (getEndTime() != null) {
            _hashCode += getEndTime().hashCode();
        }
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getOurNumber() != null) {
            _hashCode += getOurNumber().hashCode();
        }
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MVPNHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "MVPNHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "endTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ourNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "ourNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
