/**
 * CDR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.billing.service.xsd;

public class CDR  implements java.io.Serializable {
    private java.lang.String EDTime;

    private java.lang.String STTime;

    private java.lang.String UUID;

    private java.lang.Integer chargeMode;

    private java.lang.Float cost;

    private java.lang.String person;

    private java.lang.Integer status;

    private java.lang.String userID;

    public CDR() {
    }

    public CDR(
           java.lang.String EDTime,
           java.lang.String STTime,
           java.lang.String UUID,
           java.lang.Integer chargeMode,
           java.lang.Float cost,
           java.lang.String person,
           java.lang.Integer status,
           java.lang.String userID) {
           this.EDTime = EDTime;
           this.STTime = STTime;
           this.UUID = UUID;
           this.chargeMode = chargeMode;
           this.cost = cost;
           this.person = person;
           this.status = status;
           this.userID = userID;
    }


    /**
     * Gets the EDTime value for this CDR.
     * 
     * @return EDTime
     */
    public java.lang.String getEDTime() {
        return EDTime;
    }


    /**
     * Sets the EDTime value for this CDR.
     * 
     * @param EDTime
     */
    public void setEDTime(java.lang.String EDTime) {
        this.EDTime = EDTime;
    }


    /**
     * Gets the STTime value for this CDR.
     * 
     * @return STTime
     */
    public java.lang.String getSTTime() {
        return STTime;
    }


    /**
     * Sets the STTime value for this CDR.
     * 
     * @param STTime
     */
    public void setSTTime(java.lang.String STTime) {
        this.STTime = STTime;
    }


    /**
     * Gets the UUID value for this CDR.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this CDR.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the chargeMode value for this CDR.
     * 
     * @return chargeMode
     */
    public java.lang.Integer getChargeMode() {
        return chargeMode;
    }


    /**
     * Sets the chargeMode value for this CDR.
     * 
     * @param chargeMode
     */
    public void setChargeMode(java.lang.Integer chargeMode) {
        this.chargeMode = chargeMode;
    }


    /**
     * Gets the cost value for this CDR.
     * 
     * @return cost
     */
    public java.lang.Float getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this CDR.
     * 
     * @param cost
     */
    public void setCost(java.lang.Float cost) {
        this.cost = cost;
    }


    /**
     * Gets the person value for this CDR.
     * 
     * @return person
     */
    public java.lang.String getPerson() {
        return person;
    }


    /**
     * Sets the person value for this CDR.
     * 
     * @param person
     */
    public void setPerson(java.lang.String person) {
        this.person = person;
    }


    /**
     * Gets the status value for this CDR.
     * 
     * @return status
     */
    public java.lang.Integer getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CDR.
     * 
     * @param status
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }


    /**
     * Gets the userID value for this CDR.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this CDR.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CDR)) return false;
        CDR other = (CDR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EDTime==null && other.getEDTime()==null) || 
             (this.EDTime!=null &&
              this.EDTime.equals(other.getEDTime()))) &&
            ((this.STTime==null && other.getSTTime()==null) || 
             (this.STTime!=null &&
              this.STTime.equals(other.getSTTime()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID()))) &&
            ((this.chargeMode==null && other.getChargeMode()==null) || 
             (this.chargeMode!=null &&
              this.chargeMode.equals(other.getChargeMode()))) &&
            ((this.cost==null && other.getCost()==null) || 
             (this.cost!=null &&
              this.cost.equals(other.getCost()))) &&
            ((this.person==null && other.getPerson()==null) || 
             (this.person!=null &&
              this.person.equals(other.getPerson()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID())));
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
        if (getEDTime() != null) {
            _hashCode += getEDTime().hashCode();
        }
        if (getSTTime() != null) {
            _hashCode += getSTTime().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        if (getChargeMode() != null) {
            _hashCode += getChargeMode().hashCode();
        }
        if (getCost() != null) {
            _hashCode += getCost().hashCode();
        }
        if (getPerson() != null) {
            _hashCode += getPerson().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CDR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "CDR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EDTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "EDTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "STTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "chargeMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("person");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "person"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "userID"));
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
