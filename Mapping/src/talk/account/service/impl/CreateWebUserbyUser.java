/**
 * CreateWebUserbyUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.impl;

public class CreateWebUserbyUser  implements java.io.Serializable {
    private java.lang.String serverHandshake;

    private java.lang.String number;

    private java.lang.String mail;

    private java.lang.String unitUUID;

    private java.lang.String name;

    public CreateWebUserbyUser() {
    }

    public CreateWebUserbyUser(
           java.lang.String serverHandshake,
           java.lang.String number,
           java.lang.String mail,
           java.lang.String unitUUID,
           java.lang.String name) {
           this.serverHandshake = serverHandshake;
           this.number = number;
           this.mail = mail;
           this.unitUUID = unitUUID;
           this.name = name;
    }


    /**
     * Gets the serverHandshake value for this CreateWebUserbyUser.
     * 
     * @return serverHandshake
     */
    public java.lang.String getServerHandshake() {
        return serverHandshake;
    }


    /**
     * Sets the serverHandshake value for this CreateWebUserbyUser.
     * 
     * @param serverHandshake
     */
    public void setServerHandshake(java.lang.String serverHandshake) {
        this.serverHandshake = serverHandshake;
    }


    /**
     * Gets the number value for this CreateWebUserbyUser.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this CreateWebUserbyUser.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the mail value for this CreateWebUserbyUser.
     * 
     * @return mail
     */
    public java.lang.String getMail() {
        return mail;
    }


    /**
     * Sets the mail value for this CreateWebUserbyUser.
     * 
     * @param mail
     */
    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }


    /**
     * Gets the unitUUID value for this CreateWebUserbyUser.
     * 
     * @return unitUUID
     */
    public java.lang.String getUnitUUID() {
        return unitUUID;
    }


    /**
     * Sets the unitUUID value for this CreateWebUserbyUser.
     * 
     * @param unitUUID
     */
    public void setUnitUUID(java.lang.String unitUUID) {
        this.unitUUID = unitUUID;
    }


    /**
     * Gets the name value for this CreateWebUserbyUser.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CreateWebUserbyUser.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateWebUserbyUser)) return false;
        CreateWebUserbyUser other = (CreateWebUserbyUser) obj;
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
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.mail==null && other.getMail()==null) || 
             (this.mail!=null &&
              this.mail.equals(other.getMail()))) &&
            ((this.unitUUID==null && other.getUnitUUID()==null) || 
             (this.unitUUID!=null &&
              this.unitUUID.equals(other.getUnitUUID()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getMail() != null) {
            _hashCode += getMail().hashCode();
        }
        if (getUnitUUID() != null) {
            _hashCode += getUnitUUID().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateWebUserbyUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.account.talk", ">createWebUserbyUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serverHandshake");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "serverHandshake"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("number");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "mail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "unitUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://impl.service.account.talk", "name"));
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
