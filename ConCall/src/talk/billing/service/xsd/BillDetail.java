/**
 * BillDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.billing.service.xsd;

public class BillDetail  implements java.io.Serializable {
    private java.lang.String EDTime;

    private java.lang.String STTime;

    private java.lang.String UUID;

    private java.lang.String callTime;

    private java.lang.String calleeNumber;

    private java.lang.String calleeTelAcc;

    private java.lang.String callerNumber;

    private java.lang.String callerTelAcc;

    private java.lang.String callerUUID;

    private java.lang.String cardID;

    private java.lang.Float cost;

    private java.lang.Integer day;

    private java.lang.Integer hour;

    private java.lang.Integer minute;

    private java.lang.Integer month;

    private java.lang.Boolean paid;

    private java.lang.Float profit;

    private java.lang.Integer program;

    private java.lang.Integer second;

    private java.lang.Integer year;

    public BillDetail() {
    }

    public BillDetail(
           java.lang.String EDTime,
           java.lang.String STTime,
           java.lang.String UUID,
           java.lang.String callTime,
           java.lang.String calleeNumber,
           java.lang.String calleeTelAcc,
           java.lang.String callerNumber,
           java.lang.String callerTelAcc,
           java.lang.String callerUUID,
           java.lang.String cardID,
           java.lang.Float cost,
           java.lang.Integer day,
           java.lang.Integer hour,
           java.lang.Integer minute,
           java.lang.Integer month,
           java.lang.Boolean paid,
           java.lang.Float profit,
           java.lang.Integer program,
           java.lang.Integer second,
           java.lang.Integer year) {
           this.EDTime = EDTime;
           this.STTime = STTime;
           this.UUID = UUID;
           this.callTime = callTime;
           this.calleeNumber = calleeNumber;
           this.calleeTelAcc = calleeTelAcc;
           this.callerNumber = callerNumber;
           this.callerTelAcc = callerTelAcc;
           this.callerUUID = callerUUID;
           this.cardID = cardID;
           this.cost = cost;
           this.day = day;
           this.hour = hour;
           this.minute = minute;
           this.month = month;
           this.paid = paid;
           this.profit = profit;
           this.program = program;
           this.second = second;
           this.year = year;
    }


    /**
     * Gets the EDTime value for this BillDetail.
     * 
     * @return EDTime
     */
    public java.lang.String getEDTime() {
        return EDTime;
    }


    /**
     * Sets the EDTime value for this BillDetail.
     * 
     * @param EDTime
     */
    public void setEDTime(java.lang.String EDTime) {
        this.EDTime = EDTime;
    }


    /**
     * Gets the STTime value for this BillDetail.
     * 
     * @return STTime
     */
    public java.lang.String getSTTime() {
        return STTime;
    }


    /**
     * Sets the STTime value for this BillDetail.
     * 
     * @param STTime
     */
    public void setSTTime(java.lang.String STTime) {
        this.STTime = STTime;
    }


    /**
     * Gets the UUID value for this BillDetail.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this BillDetail.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the callTime value for this BillDetail.
     * 
     * @return callTime
     */
    public java.lang.String getCallTime() {
        return callTime;
    }


    /**
     * Sets the callTime value for this BillDetail.
     * 
     * @param callTime
     */
    public void setCallTime(java.lang.String callTime) {
        this.callTime = callTime;
    }


    /**
     * Gets the calleeNumber value for this BillDetail.
     * 
     * @return calleeNumber
     */
    public java.lang.String getCalleeNumber() {
        return calleeNumber;
    }


    /**
     * Sets the calleeNumber value for this BillDetail.
     * 
     * @param calleeNumber
     */
    public void setCalleeNumber(java.lang.String calleeNumber) {
        this.calleeNumber = calleeNumber;
    }


    /**
     * Gets the calleeTelAcc value for this BillDetail.
     * 
     * @return calleeTelAcc
     */
    public java.lang.String getCalleeTelAcc() {
        return calleeTelAcc;
    }


    /**
     * Sets the calleeTelAcc value for this BillDetail.
     * 
     * @param calleeTelAcc
     */
    public void setCalleeTelAcc(java.lang.String calleeTelAcc) {
        this.calleeTelAcc = calleeTelAcc;
    }


    /**
     * Gets the callerNumber value for this BillDetail.
     * 
     * @return callerNumber
     */
    public java.lang.String getCallerNumber() {
        return callerNumber;
    }


    /**
     * Sets the callerNumber value for this BillDetail.
     * 
     * @param callerNumber
     */
    public void setCallerNumber(java.lang.String callerNumber) {
        this.callerNumber = callerNumber;
    }


    /**
     * Gets the callerTelAcc value for this BillDetail.
     * 
     * @return callerTelAcc
     */
    public java.lang.String getCallerTelAcc() {
        return callerTelAcc;
    }


    /**
     * Sets the callerTelAcc value for this BillDetail.
     * 
     * @param callerTelAcc
     */
    public void setCallerTelAcc(java.lang.String callerTelAcc) {
        this.callerTelAcc = callerTelAcc;
    }


    /**
     * Gets the callerUUID value for this BillDetail.
     * 
     * @return callerUUID
     */
    public java.lang.String getCallerUUID() {
        return callerUUID;
    }


    /**
     * Sets the callerUUID value for this BillDetail.
     * 
     * @param callerUUID
     */
    public void setCallerUUID(java.lang.String callerUUID) {
        this.callerUUID = callerUUID;
    }


    /**
     * Gets the cardID value for this BillDetail.
     * 
     * @return cardID
     */
    public java.lang.String getCardID() {
        return cardID;
    }


    /**
     * Sets the cardID value for this BillDetail.
     * 
     * @param cardID
     */
    public void setCardID(java.lang.String cardID) {
        this.cardID = cardID;
    }


    /**
     * Gets the cost value for this BillDetail.
     * 
     * @return cost
     */
    public java.lang.Float getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this BillDetail.
     * 
     * @param cost
     */
    public void setCost(java.lang.Float cost) {
        this.cost = cost;
    }


    /**
     * Gets the day value for this BillDetail.
     * 
     * @return day
     */
    public java.lang.Integer getDay() {
        return day;
    }


    /**
     * Sets the day value for this BillDetail.
     * 
     * @param day
     */
    public void setDay(java.lang.Integer day) {
        this.day = day;
    }


    /**
     * Gets the hour value for this BillDetail.
     * 
     * @return hour
     */
    public java.lang.Integer getHour() {
        return hour;
    }


    /**
     * Sets the hour value for this BillDetail.
     * 
     * @param hour
     */
    public void setHour(java.lang.Integer hour) {
        this.hour = hour;
    }


    /**
     * Gets the minute value for this BillDetail.
     * 
     * @return minute
     */
    public java.lang.Integer getMinute() {
        return minute;
    }


    /**
     * Sets the minute value for this BillDetail.
     * 
     * @param minute
     */
    public void setMinute(java.lang.Integer minute) {
        this.minute = minute;
    }


    /**
     * Gets the month value for this BillDetail.
     * 
     * @return month
     */
    public java.lang.Integer getMonth() {
        return month;
    }


    /**
     * Sets the month value for this BillDetail.
     * 
     * @param month
     */
    public void setMonth(java.lang.Integer month) {
        this.month = month;
    }


    /**
     * Gets the paid value for this BillDetail.
     * 
     * @return paid
     */
    public java.lang.Boolean getPaid() {
        return paid;
    }


    /**
     * Sets the paid value for this BillDetail.
     * 
     * @param paid
     */
    public void setPaid(java.lang.Boolean paid) {
        this.paid = paid;
    }


    /**
     * Gets the profit value for this BillDetail.
     * 
     * @return profit
     */
    public java.lang.Float getProfit() {
        return profit;
    }


    /**
     * Sets the profit value for this BillDetail.
     * 
     * @param profit
     */
    public void setProfit(java.lang.Float profit) {
        this.profit = profit;
    }


    /**
     * Gets the program value for this BillDetail.
     * 
     * @return program
     */
    public java.lang.Integer getProgram() {
        return program;
    }


    /**
     * Sets the program value for this BillDetail.
     * 
     * @param program
     */
    public void setProgram(java.lang.Integer program) {
        this.program = program;
    }


    /**
     * Gets the second value for this BillDetail.
     * 
     * @return second
     */
    public java.lang.Integer getSecond() {
        return second;
    }


    /**
     * Sets the second value for this BillDetail.
     * 
     * @param second
     */
    public void setSecond(java.lang.Integer second) {
        this.second = second;
    }


    /**
     * Gets the year value for this BillDetail.
     * 
     * @return year
     */
    public java.lang.Integer getYear() {
        return year;
    }


    /**
     * Sets the year value for this BillDetail.
     * 
     * @param year
     */
    public void setYear(java.lang.Integer year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BillDetail)) return false;
        BillDetail other = (BillDetail) obj;
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
            ((this.callTime==null && other.getCallTime()==null) || 
             (this.callTime!=null &&
              this.callTime.equals(other.getCallTime()))) &&
            ((this.calleeNumber==null && other.getCalleeNumber()==null) || 
             (this.calleeNumber!=null &&
              this.calleeNumber.equals(other.getCalleeNumber()))) &&
            ((this.calleeTelAcc==null && other.getCalleeTelAcc()==null) || 
             (this.calleeTelAcc!=null &&
              this.calleeTelAcc.equals(other.getCalleeTelAcc()))) &&
            ((this.callerNumber==null && other.getCallerNumber()==null) || 
             (this.callerNumber!=null &&
              this.callerNumber.equals(other.getCallerNumber()))) &&
            ((this.callerTelAcc==null && other.getCallerTelAcc()==null) || 
             (this.callerTelAcc!=null &&
              this.callerTelAcc.equals(other.getCallerTelAcc()))) &&
            ((this.callerUUID==null && other.getCallerUUID()==null) || 
             (this.callerUUID!=null &&
              this.callerUUID.equals(other.getCallerUUID()))) &&
            ((this.cardID==null && other.getCardID()==null) || 
             (this.cardID!=null &&
              this.cardID.equals(other.getCardID()))) &&
            ((this.cost==null && other.getCost()==null) || 
             (this.cost!=null &&
              this.cost.equals(other.getCost()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.hour==null && other.getHour()==null) || 
             (this.hour!=null &&
              this.hour.equals(other.getHour()))) &&
            ((this.minute==null && other.getMinute()==null) || 
             (this.minute!=null &&
              this.minute.equals(other.getMinute()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.paid==null && other.getPaid()==null) || 
             (this.paid!=null &&
              this.paid.equals(other.getPaid()))) &&
            ((this.profit==null && other.getProfit()==null) || 
             (this.profit!=null &&
              this.profit.equals(other.getProfit()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.second==null && other.getSecond()==null) || 
             (this.second!=null &&
              this.second.equals(other.getSecond()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear())));
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
        if (getCallTime() != null) {
            _hashCode += getCallTime().hashCode();
        }
        if (getCalleeNumber() != null) {
            _hashCode += getCalleeNumber().hashCode();
        }
        if (getCalleeTelAcc() != null) {
            _hashCode += getCalleeTelAcc().hashCode();
        }
        if (getCallerNumber() != null) {
            _hashCode += getCallerNumber().hashCode();
        }
        if (getCallerTelAcc() != null) {
            _hashCode += getCallerTelAcc().hashCode();
        }
        if (getCallerUUID() != null) {
            _hashCode += getCallerUUID().hashCode();
        }
        if (getCardID() != null) {
            _hashCode += getCardID().hashCode();
        }
        if (getCost() != null) {
            _hashCode += getCost().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getHour() != null) {
            _hashCode += getHour().hashCode();
        }
        if (getMinute() != null) {
            _hashCode += getMinute().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getPaid() != null) {
            _hashCode += getPaid().hashCode();
        }
        if (getProfit() != null) {
            _hashCode += getProfit().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getSecond() != null) {
            _hashCode += getSecond().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BillDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "BillDetail"));
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
        elemField.setFieldName("callTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "callTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calleeNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "calleeNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calleeTelAcc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "calleeTelAcc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "callerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerTelAcc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "callerTelAcc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "callerUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "cardID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hour");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "hour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minute");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "minute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "paid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "profit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("second");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "second"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.billing.talk/xsd", "year"));
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
