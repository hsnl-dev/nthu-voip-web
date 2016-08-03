/**
 * WebAccount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.xsd;

public class WebAccount  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.Boolean approval;

    private java.lang.String authCode;

    private java.lang.String card;

    private java.lang.String date;

    private java.lang.Integer level;

    private java.lang.String name;

    private java.lang.String password;

    private java.lang.Object phoneList;

    private java.lang.String picture;

    private java.lang.String regMail;

    private java.lang.String unitUUID;

    private java.lang.String userName;

    private java.lang.Boolean validation;

    public WebAccount() {
    }

    public WebAccount(
           java.lang.String UUID,
           java.lang.Boolean approval,
           java.lang.String authCode,
           java.lang.String card,
           java.lang.String date,
           java.lang.Integer level,
           java.lang.String name,
           java.lang.String password,
           java.lang.Object phoneList,
           java.lang.String picture,
           java.lang.String regMail,
           java.lang.String unitUUID,
           java.lang.String userName,
           java.lang.Boolean validation) {
           this.UUID = UUID;
           this.approval = approval;
           this.authCode = authCode;
           this.card = card;
           this.date = date;
           this.level = level;
           this.name = name;
           this.password = password;
           this.phoneList = phoneList;
           this.picture = picture;
           this.regMail = regMail;
           this.unitUUID = unitUUID;
           this.userName = userName;
           this.validation = validation;
    }


    /**
     * Gets the UUID value for this WebAccount.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this WebAccount.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the approval value for this WebAccount.
     * 
     * @return approval
     */
    public java.lang.Boolean getApproval() {
        return approval;
    }


    /**
     * Sets the approval value for this WebAccount.
     * 
     * @param approval
     */
    public void setApproval(java.lang.Boolean approval) {
        this.approval = approval;
    }


    /**
     * Gets the authCode value for this WebAccount.
     * 
     * @return authCode
     */
    public java.lang.String getAuthCode() {
        return authCode;
    }


    /**
     * Sets the authCode value for this WebAccount.
     * 
     * @param authCode
     */
    public void setAuthCode(java.lang.String authCode) {
        this.authCode = authCode;
    }


    /**
     * Gets the card value for this WebAccount.
     * 
     * @return card
     */
    public java.lang.String getCard() {
        return card;
    }


    /**
     * Sets the card value for this WebAccount.
     * 
     * @param card
     */
    public void setCard(java.lang.String card) {
        this.card = card;
    }


    /**
     * Gets the date value for this WebAccount.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this WebAccount.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the level value for this WebAccount.
     * 
     * @return level
     */
    public java.lang.Integer getLevel() {
        return level;
    }


    /**
     * Sets the level value for this WebAccount.
     * 
     * @param level
     */
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }


    /**
     * Gets the name value for this WebAccount.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this WebAccount.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the password value for this WebAccount.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this WebAccount.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the phoneList value for this WebAccount.
     * 
     * @return phoneList
     */
    public java.lang.Object getPhoneList() {
        return phoneList;
    }


    /**
     * Sets the phoneList value for this WebAccount.
     * 
     * @param phoneList
     */
    public void setPhoneList(java.lang.Object phoneList) {
        this.phoneList = phoneList;
    }


    /**
     * Gets the picture value for this WebAccount.
     * 
     * @return picture
     */
    public java.lang.String getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this WebAccount.
     * 
     * @param picture
     */
    public void setPicture(java.lang.String picture) {
        this.picture = picture;
    }


    /**
     * Gets the regMail value for this WebAccount.
     * 
     * @return regMail
     */
    public java.lang.String getRegMail() {
        return regMail;
    }


    /**
     * Sets the regMail value for this WebAccount.
     * 
     * @param regMail
     */
    public void setRegMail(java.lang.String regMail) {
        this.regMail = regMail;
    }


    /**
     * Gets the unitUUID value for this WebAccount.
     * 
     * @return unitUUID
     */
    public java.lang.String getUnitUUID() {
        return unitUUID;
    }


    /**
     * Sets the unitUUID value for this WebAccount.
     * 
     * @param unitUUID
     */
    public void setUnitUUID(java.lang.String unitUUID) {
        this.unitUUID = unitUUID;
    }


    /**
     * Gets the userName value for this WebAccount.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this WebAccount.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the validation value for this WebAccount.
     * 
     * @return validation
     */
    public java.lang.Boolean getValidation() {
        return validation;
    }


    /**
     * Sets the validation value for this WebAccount.
     * 
     * @param validation
     */
    public void setValidation(java.lang.Boolean validation) {
        this.validation = validation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebAccount)) return false;
        WebAccount other = (WebAccount) obj;
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
            ((this.approval==null && other.getApproval()==null) || 
             (this.approval!=null &&
              this.approval.equals(other.getApproval()))) &&
            ((this.authCode==null && other.getAuthCode()==null) || 
             (this.authCode!=null &&
              this.authCode.equals(other.getAuthCode()))) &&
            ((this.card==null && other.getCard()==null) || 
             (this.card!=null &&
              this.card.equals(other.getCard()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.phoneList==null && other.getPhoneList()==null) || 
             (this.phoneList!=null &&
              this.phoneList.equals(other.getPhoneList()))) &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              this.picture.equals(other.getPicture()))) &&
            ((this.regMail==null && other.getRegMail()==null) || 
             (this.regMail!=null &&
              this.regMail.equals(other.getRegMail()))) &&
            ((this.unitUUID==null && other.getUnitUUID()==null) || 
             (this.unitUUID!=null &&
              this.unitUUID.equals(other.getUnitUUID()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.validation==null && other.getValidation()==null) || 
             (this.validation!=null &&
              this.validation.equals(other.getValidation())));
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
        if (getApproval() != null) {
            _hashCode += getApproval().hashCode();
        }
        if (getAuthCode() != null) {
            _hashCode += getAuthCode().hashCode();
        }
        if (getCard() != null) {
            _hashCode += getCard().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPhoneList() != null) {
            _hashCode += getPhoneList().hashCode();
        }
        if (getPicture() != null) {
            _hashCode += getPicture().hashCode();
        }
        if (getRegMail() != null) {
            _hashCode += getRegMail().hashCode();
        }
        if (getUnitUUID() != null) {
            _hashCode += getUnitUUID().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getValidation() != null) {
            _hashCode += getValidation().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebAccount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "WebAccount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "approval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "authCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("card");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "card"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("level");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "level"));
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
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "phoneList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("picture");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "picture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "regMail"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "validation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
