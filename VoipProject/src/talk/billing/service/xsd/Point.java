/**
 * Point.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.billing.service.xsd;

public class Point  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.Float chargePoint;

    private java.lang.Float costPoint;

    private java.lang.Float currentPoint;

    private java.lang.Float initPoint;

    private java.lang.Long lastOptDate;

    private java.lang.Float limitPoint;

    private java.lang.Float recomPoint;

    public Point() {
    }

    public Point(
           java.lang.String UUID,
           java.lang.Float chargePoint,
           java.lang.Float costPoint,
           java.lang.Float currentPoint,
           java.lang.Float initPoint,
           java.lang.Long lastOptDate,
           java.lang.Float limitPoint,
           java.lang.Float recomPoint) {
           this.UUID = UUID;
           this.chargePoint = chargePoint;
           this.costPoint = costPoint;
           this.currentPoint = currentPoint;
           this.initPoint = initPoint;
           this.lastOptDate = lastOptDate;
           this.limitPoint = limitPoint;
           this.recomPoint = recomPoint;
    }


    /**
     * Gets the UUID value for this Point.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this Point.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the chargePoint value for this Point.
     * 
     * @return chargePoint
     */
    public java.lang.Float getChargePoint() {
        return chargePoint;
    }


    /**
     * Sets the chargePoint value for this Point.
     * 
     * @param chargePoint
     */
    public void setChargePoint(java.lang.Float chargePoint) {
        this.chargePoint = chargePoint;
    }


    /**
     * Gets the costPoint value for this Point.
     * 
     * @return costPoint
     */
    public java.lang.Float getCostPoint() {
        return costPoint;
    }


    /**
     * Sets the costPoint value for this Point.
     * 
     * @param costPoint
     */
    public void setCostPoint(java.lang.Float costPoint) {
        this.costPoint = costPoint;
    }


    /**
     * Gets the currentPoint value for this Point.
     * 
     * @return currentPoint
     */
    public java.lang.Float getCurrentPoint() {
        return currentPoint;
    }


    /**
     * Sets the currentPoint value for this Point.
     * 
     * @param currentPoint
     */
    public void setCurrentPoint(java.lang.Float currentPoint) {
        this.currentPoint = currentPoint;
    }


    /**
     * Gets the initPoint value for this Point.
     * 
     * @return initPoint
     */
    public java.lang.Float getInitPoint() {
        return initPoint;
    }


    /**
     * Sets the initPoint value for this Point.
     * 
     * @param initPoint
     */
    public void setInitPoint(java.lang.Float initPoint) {
        this.initPoint = initPoint;
    }


    /**
     * Gets the lastOptDate value for this Point.
     * 
     * @return lastOptDate
     */
    public java.lang.Long getLastOptDate() {
        return lastOptDate;
    }


    /**
     * Sets the lastOptDate value for this Point.
     * 
     * @param lastOptDate
     */
    public void setLastOptDate(java.lang.Long lastOptDate) {
        this.lastOptDate = lastOptDate;
    }


    /**
     * Gets the limitPoint value for this Point.
     * 
     * @return limitPoint
     */
    public java.lang.Float getLimitPoint() {
        return limitPoint;
    }


    /**
     * Sets the limitPoint value for this Point.
     * 
     * @param limitPoint
     */
    public void setLimitPoint(java.lang.Float limitPoint) {
        this.limitPoint = limitPoint;
    }


    /**
     * Gets the recomPoint value for this Point.
     * 
     * @return recomPoint
     */
    public java.lang.Float getRecomPoint() {
        return recomPoint;
    }


    /**
     * Sets the recomPoint value for this Point.
     * 
     * @param recomPoint
     */
    public void setRecomPoint(java.lang.Float recomPoint) {
        this.recomPoint = recomPoint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
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
            ((this.chargePoint==null && other.getChargePoint()==null) || 
             (this.chargePoint!=null &&
              this.chargePoint.equals(other.getChargePoint()))) &&
            ((this.costPoint==null && other.getCostPoint()==null) || 
             (this.costPoint!=null &&
              this.costPoint.equals(other.getCostPoint()))) &&
            ((this.currentPoint==null && other.getCurrentPoint()==null) || 
             (this.currentPoint!=null &&
              this.currentPoint.equals(other.getCurrentPoint()))) &&
            ((this.initPoint==null && other.getInitPoint()==null) || 
             (this.initPoint!=null &&
              this.initPoint.equals(other.getInitPoint()))) &&
            ((this.lastOptDate==null && other.getLastOptDate()==null) || 
             (this.lastOptDate!=null &&
              this.lastOptDate.equals(other.getLastOptDate()))) &&
            ((this.limitPoint==null && other.getLimitPoint()==null) || 
             (this.limitPoint!=null &&
              this.limitPoint.equals(other.getLimitPoint()))) &&
            ((this.recomPoint==null && other.getRecomPoint()==null) || 
             (this.recomPoint!=null &&
              this.recomPoint.equals(other.getRecomPoint())));
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
        if (getChargePoint() != null) {
            _hashCode += getChargePoint().hashCode();
        }
        if (getCostPoint() != null) {
            _hashCode += getCostPoint().hashCode();
        }
        if (getCurrentPoint() != null) {
            _hashCode += getCurrentPoint().hashCode();
        }
        if (getInitPoint() != null) {
            _hashCode += getInitPoint().hashCode();
        }
        if (getLastOptDate() != null) {
            _hashCode += getLastOptDate().hashCode();
        }
        if (getLimitPoint() != null) {
            _hashCode += getLimitPoint().hashCode();
        }
        if (getRecomPoint() != null) {
            _hashCode += getRecomPoint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Point.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "Point"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargePoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "chargePoint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costPoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "costPoint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "currentPoint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("initPoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "initPoint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastOptDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "lastOptDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limitPoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "limitPoint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recomPoint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "recomPoint"));
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
