/**
 * Notification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.calling.service.xsd;

public class Notification  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.String deliverTime;

    private java.lang.String message;

    private java.lang.String receiverNickname;

    private java.lang.String receiverUUID;

    private java.lang.String senderNickname;

    private java.lang.String senderUUID;

    public Notification() {
    }

    public Notification(
           java.lang.String UUID,
           java.lang.String deliverTime,
           java.lang.String message,
           java.lang.String receiverNickname,
           java.lang.String receiverUUID,
           java.lang.String senderNickname,
           java.lang.String senderUUID) {
           this.UUID = UUID;
           this.deliverTime = deliverTime;
           this.message = message;
           this.receiverNickname = receiverNickname;
           this.receiverUUID = receiverUUID;
           this.senderNickname = senderNickname;
           this.senderUUID = senderUUID;
    }


    /**
     * Gets the UUID value for this Notification.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this Notification.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the deliverTime value for this Notification.
     * 
     * @return deliverTime
     */
    public java.lang.String getDeliverTime() {
        return deliverTime;
    }


    /**
     * Sets the deliverTime value for this Notification.
     * 
     * @param deliverTime
     */
    public void setDeliverTime(java.lang.String deliverTime) {
        this.deliverTime = deliverTime;
    }


    /**
     * Gets the message value for this Notification.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this Notification.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the receiverNickname value for this Notification.
     * 
     * @return receiverNickname
     */
    public java.lang.String getReceiverNickname() {
        return receiverNickname;
    }


    /**
     * Sets the receiverNickname value for this Notification.
     * 
     * @param receiverNickname
     */
    public void setReceiverNickname(java.lang.String receiverNickname) {
        this.receiverNickname = receiverNickname;
    }


    /**
     * Gets the receiverUUID value for this Notification.
     * 
     * @return receiverUUID
     */
    public java.lang.String getReceiverUUID() {
        return receiverUUID;
    }


    /**
     * Sets the receiverUUID value for this Notification.
     * 
     * @param receiverUUID
     */
    public void setReceiverUUID(java.lang.String receiverUUID) {
        this.receiverUUID = receiverUUID;
    }


    /**
     * Gets the senderNickname value for this Notification.
     * 
     * @return senderNickname
     */
    public java.lang.String getSenderNickname() {
        return senderNickname;
    }


    /**
     * Sets the senderNickname value for this Notification.
     * 
     * @param senderNickname
     */
    public void setSenderNickname(java.lang.String senderNickname) {
        this.senderNickname = senderNickname;
    }


    /**
     * Gets the senderUUID value for this Notification.
     * 
     * @return senderUUID
     */
    public java.lang.String getSenderUUID() {
        return senderUUID;
    }


    /**
     * Sets the senderUUID value for this Notification.
     * 
     * @param senderUUID
     */
    public void setSenderUUID(java.lang.String senderUUID) {
        this.senderUUID = senderUUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Notification)) return false;
        Notification other = (Notification) obj;
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
            ((this.deliverTime==null && other.getDeliverTime()==null) || 
             (this.deliverTime!=null &&
              this.deliverTime.equals(other.getDeliverTime()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.receiverNickname==null && other.getReceiverNickname()==null) || 
             (this.receiverNickname!=null &&
              this.receiverNickname.equals(other.getReceiverNickname()))) &&
            ((this.receiverUUID==null && other.getReceiverUUID()==null) || 
             (this.receiverUUID!=null &&
              this.receiverUUID.equals(other.getReceiverUUID()))) &&
            ((this.senderNickname==null && other.getSenderNickname()==null) || 
             (this.senderNickname!=null &&
              this.senderNickname.equals(other.getSenderNickname()))) &&
            ((this.senderUUID==null && other.getSenderUUID()==null) || 
             (this.senderUUID!=null &&
              this.senderUUID.equals(other.getSenderUUID())));
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
        if (getDeliverTime() != null) {
            _hashCode += getDeliverTime().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getReceiverNickname() != null) {
            _hashCode += getReceiverNickname().hashCode();
        }
        if (getReceiverUUID() != null) {
            _hashCode += getReceiverUUID().hashCode();
        }
        if (getSenderNickname() != null) {
            _hashCode += getSenderNickname().hashCode();
        }
        if (getSenderUUID() != null) {
            _hashCode += getSenderUUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Notification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "Notification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliverTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "deliverTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiverNickname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "receiverNickname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiverUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "receiverUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderNickname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "senderNickname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.calling.talk/xsd", "senderUUID"));
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
