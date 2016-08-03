/**
 * Contact.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.xsd;

public class Contact  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.String accountUUID;

    private java.lang.Integer charge;

    private java.lang.Integer favor;

    private java.lang.String name;

    private java.lang.Integer nameOrder;

    private java.lang.Integer order;

    private java.lang.String ownerUUID;

    private java.lang.String pic;

    public Contact() {
    }

    public Contact(
           java.lang.String UUID,
           java.lang.String accountUUID,
           java.lang.Integer charge,
           java.lang.Integer favor,
           java.lang.String name,
           java.lang.Integer nameOrder,
           java.lang.Integer order,
           java.lang.String ownerUUID,
           java.lang.String pic) {
           this.UUID = UUID;
           this.accountUUID = accountUUID;
           this.charge = charge;
           this.favor = favor;
           this.name = name;
           this.nameOrder = nameOrder;
           this.order = order;
           this.ownerUUID = ownerUUID;
           this.pic = pic;
    }


    /**
     * Gets the UUID value for this Contact.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this Contact.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the accountUUID value for this Contact.
     * 
     * @return accountUUID
     */
    public java.lang.String getAccountUUID() {
        return accountUUID;
    }


    /**
     * Sets the accountUUID value for this Contact.
     * 
     * @param accountUUID
     */
    public void setAccountUUID(java.lang.String accountUUID) {
        this.accountUUID = accountUUID;
    }


    /**
     * Gets the charge value for this Contact.
     * 
     * @return charge
     */
    public java.lang.Integer getCharge() {
        return charge;
    }


    /**
     * Sets the charge value for this Contact.
     * 
     * @param charge
     */
    public void setCharge(java.lang.Integer charge) {
        this.charge = charge;
    }


    /**
     * Gets the favor value for this Contact.
     * 
     * @return favor
     */
    public java.lang.Integer getFavor() {
        return favor;
    }


    /**
     * Sets the favor value for this Contact.
     * 
     * @param favor
     */
    public void setFavor(java.lang.Integer favor) {
        this.favor = favor;
    }


    /**
     * Gets the name value for this Contact.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Contact.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the nameOrder value for this Contact.
     * 
     * @return nameOrder
     */
    public java.lang.Integer getNameOrder() {
        return nameOrder;
    }


    /**
     * Sets the nameOrder value for this Contact.
     * 
     * @param nameOrder
     */
    public void setNameOrder(java.lang.Integer nameOrder) {
        this.nameOrder = nameOrder;
    }


    /**
     * Gets the order value for this Contact.
     * 
     * @return order
     */
    public java.lang.Integer getOrder() {
        return order;
    }


    /**
     * Sets the order value for this Contact.
     * 
     * @param order
     */
    public void setOrder(java.lang.Integer order) {
        this.order = order;
    }


    /**
     * Gets the ownerUUID value for this Contact.
     * 
     * @return ownerUUID
     */
    public java.lang.String getOwnerUUID() {
        return ownerUUID;
    }


    /**
     * Sets the ownerUUID value for this Contact.
     * 
     * @param ownerUUID
     */
    public void setOwnerUUID(java.lang.String ownerUUID) {
        this.ownerUUID = ownerUUID;
    }


    /**
     * Gets the pic value for this Contact.
     * 
     * @return pic
     */
    public java.lang.String getPic() {
        return pic;
    }


    /**
     * Sets the pic value for this Contact.
     * 
     * @param pic
     */
    public void setPic(java.lang.String pic) {
        this.pic = pic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
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
            ((this.accountUUID==null && other.getAccountUUID()==null) || 
             (this.accountUUID!=null &&
              this.accountUUID.equals(other.getAccountUUID()))) &&
            ((this.charge==null && other.getCharge()==null) || 
             (this.charge!=null &&
              this.charge.equals(other.getCharge()))) &&
            ((this.favor==null && other.getFavor()==null) || 
             (this.favor!=null &&
              this.favor.equals(other.getFavor()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.nameOrder==null && other.getNameOrder()==null) || 
             (this.nameOrder!=null &&
              this.nameOrder.equals(other.getNameOrder()))) &&
            ((this.order==null && other.getOrder()==null) || 
             (this.order!=null &&
              this.order.equals(other.getOrder()))) &&
            ((this.ownerUUID==null && other.getOwnerUUID()==null) || 
             (this.ownerUUID!=null &&
              this.ownerUUID.equals(other.getOwnerUUID()))) &&
            ((this.pic==null && other.getPic()==null) || 
             (this.pic!=null &&
              this.pic.equals(other.getPic())));
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
        if (getAccountUUID() != null) {
            _hashCode += getAccountUUID().hashCode();
        }
        if (getCharge() != null) {
            _hashCode += getCharge().hashCode();
        }
        if (getFavor() != null) {
            _hashCode += getFavor().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNameOrder() != null) {
            _hashCode += getNameOrder().hashCode();
        }
        if (getOrder() != null) {
            _hashCode += getOrder().hashCode();
        }
        if (getOwnerUUID() != null) {
            _hashCode += getOwnerUUID().hashCode();
        }
        if (getPic() != null) {
            _hashCode += getPic().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Contact.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "Contact"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "accountUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("charge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "charge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("favor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "favor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "nameOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "order"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerUUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "ownerUUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "pic"));
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
