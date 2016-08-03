/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package talk.account.service.xsd;

public class Account  implements java.io.Serializable {
    private java.lang.String UUID;

    private java.lang.String authCode;

    private java.lang.String card;

    private java.lang.String cnctHashCode;

    private java.lang.Boolean deleted;

    private java.lang.String favoriteHashCode;

    private java.lang.String hstHashCode;

    private java.lang.Integer level;

    private talk.account.service.xsd.Phone mobile;

    private java.lang.String name;

    private java.lang.String password;

    private java.lang.String picture;

    private java.lang.String privateLazyKey;

    private java.lang.String privateMVPNKey;

    private java.lang.Integer program;

    private java.lang.String reference;

    private java.lang.String regMail;

    private java.lang.String showHashCode;

    private java.lang.String userName;

    private java.lang.Boolean validation;

    public Account() {
    }

    public Account(
           java.lang.String UUID,
           java.lang.String authCode,
           java.lang.String card,
           java.lang.String cnctHashCode,
           java.lang.Boolean deleted,
           java.lang.String favoriteHashCode,
           java.lang.String hstHashCode,
           java.lang.Integer level,
           talk.account.service.xsd.Phone mobile,
           java.lang.String name,
           java.lang.String password,
           java.lang.String picture,
           java.lang.String privateLazyKey,
           java.lang.String privateMVPNKey,
           java.lang.Integer program,
           java.lang.String reference,
           java.lang.String regMail,
           java.lang.String showHashCode,
           java.lang.String userName,
           java.lang.Boolean validation) {
           this.UUID = UUID;
           this.authCode = authCode;
           this.card = card;
           this.cnctHashCode = cnctHashCode;
           this.deleted = deleted;
           this.favoriteHashCode = favoriteHashCode;
           this.hstHashCode = hstHashCode;
           this.level = level;
           this.mobile = mobile;
           this.name = name;
           this.password = password;
           this.picture = picture;
           this.privateLazyKey = privateLazyKey;
           this.privateMVPNKey = privateMVPNKey;
           this.program = program;
           this.reference = reference;
           this.regMail = regMail;
           this.showHashCode = showHashCode;
           this.userName = userName;
           this.validation = validation;
    }


    /**
     * Gets the UUID value for this Account.
     * 
     * @return UUID
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this Account.
     * 
     * @param UUID
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the authCode value for this Account.
     * 
     * @return authCode
     */
    public java.lang.String getAuthCode() {
        return authCode;
    }


    /**
     * Sets the authCode value for this Account.
     * 
     * @param authCode
     */
    public void setAuthCode(java.lang.String authCode) {
        this.authCode = authCode;
    }


    /**
     * Gets the card value for this Account.
     * 
     * @return card
     */
    public java.lang.String getCard() {
        return card;
    }


    /**
     * Sets the card value for this Account.
     * 
     * @param card
     */
    public void setCard(java.lang.String card) {
        this.card = card;
    }


    /**
     * Gets the cnctHashCode value for this Account.
     * 
     * @return cnctHashCode
     */
    public java.lang.String getCnctHashCode() {
        return cnctHashCode;
    }


    /**
     * Sets the cnctHashCode value for this Account.
     * 
     * @param cnctHashCode
     */
    public void setCnctHashCode(java.lang.String cnctHashCode) {
        this.cnctHashCode = cnctHashCode;
    }


    /**
     * Gets the deleted value for this Account.
     * 
     * @return deleted
     */
    public java.lang.Boolean getDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this Account.
     * 
     * @param deleted
     */
    public void setDeleted(java.lang.Boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the favoriteHashCode value for this Account.
     * 
     * @return favoriteHashCode
     */
    public java.lang.String getFavoriteHashCode() {
        return favoriteHashCode;
    }


    /**
     * Sets the favoriteHashCode value for this Account.
     * 
     * @param favoriteHashCode
     */
    public void setFavoriteHashCode(java.lang.String favoriteHashCode) {
        this.favoriteHashCode = favoriteHashCode;
    }


    /**
     * Gets the hstHashCode value for this Account.
     * 
     * @return hstHashCode
     */
    public java.lang.String getHstHashCode() {
        return hstHashCode;
    }


    /**
     * Sets the hstHashCode value for this Account.
     * 
     * @param hstHashCode
     */
    public void setHstHashCode(java.lang.String hstHashCode) {
        this.hstHashCode = hstHashCode;
    }


    /**
     * Gets the level value for this Account.
     * 
     * @return level
     */
    public java.lang.Integer getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Account.
     * 
     * @param level
     */
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }


    /**
     * Gets the mobile value for this Account.
     * 
     * @return mobile
     */
    public talk.account.service.xsd.Phone getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this Account.
     * 
     * @param mobile
     */
    public void setMobile(talk.account.service.xsd.Phone mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the name value for this Account.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Account.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the password value for this Account.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this Account.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the picture value for this Account.
     * 
     * @return picture
     */
    public java.lang.String getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this Account.
     * 
     * @param picture
     */
    public void setPicture(java.lang.String picture) {
        this.picture = picture;
    }


    /**
     * Gets the privateLazyKey value for this Account.
     * 
     * @return privateLazyKey
     */
    public java.lang.String getPrivateLazyKey() {
        return privateLazyKey;
    }


    /**
     * Sets the privateLazyKey value for this Account.
     * 
     * @param privateLazyKey
     */
    public void setPrivateLazyKey(java.lang.String privateLazyKey) {
        this.privateLazyKey = privateLazyKey;
    }


    /**
     * Gets the privateMVPNKey value for this Account.
     * 
     * @return privateMVPNKey
     */
    public java.lang.String getPrivateMVPNKey() {
        return privateMVPNKey;
    }


    /**
     * Sets the privateMVPNKey value for this Account.
     * 
     * @param privateMVPNKey
     */
    public void setPrivateMVPNKey(java.lang.String privateMVPNKey) {
        this.privateMVPNKey = privateMVPNKey;
    }


    /**
     * Gets the program value for this Account.
     * 
     * @return program
     */
    public java.lang.Integer getProgram() {
        return program;
    }


    /**
     * Sets the program value for this Account.
     * 
     * @param program
     */
    public void setProgram(java.lang.Integer program) {
        this.program = program;
    }


    /**
     * Gets the reference value for this Account.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this Account.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the regMail value for this Account.
     * 
     * @return regMail
     */
    public java.lang.String getRegMail() {
        return regMail;
    }


    /**
     * Sets the regMail value for this Account.
     * 
     * @param regMail
     */
    public void setRegMail(java.lang.String regMail) {
        this.regMail = regMail;
    }


    /**
     * Gets the showHashCode value for this Account.
     * 
     * @return showHashCode
     */
    public java.lang.String getShowHashCode() {
        return showHashCode;
    }


    /**
     * Sets the showHashCode value for this Account.
     * 
     * @param showHashCode
     */
    public void setShowHashCode(java.lang.String showHashCode) {
        this.showHashCode = showHashCode;
    }


    /**
     * Gets the userName value for this Account.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this Account.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the validation value for this Account.
     * 
     * @return validation
     */
    public java.lang.Boolean getValidation() {
        return validation;
    }


    /**
     * Sets the validation value for this Account.
     * 
     * @param validation
     */
    public void setValidation(java.lang.Boolean validation) {
        this.validation = validation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
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
            ((this.authCode==null && other.getAuthCode()==null) || 
             (this.authCode!=null &&
              this.authCode.equals(other.getAuthCode()))) &&
            ((this.card==null && other.getCard()==null) || 
             (this.card!=null &&
              this.card.equals(other.getCard()))) &&
            ((this.cnctHashCode==null && other.getCnctHashCode()==null) || 
             (this.cnctHashCode!=null &&
              this.cnctHashCode.equals(other.getCnctHashCode()))) &&
            ((this.deleted==null && other.getDeleted()==null) || 
             (this.deleted!=null &&
              this.deleted.equals(other.getDeleted()))) &&
            ((this.favoriteHashCode==null && other.getFavoriteHashCode()==null) || 
             (this.favoriteHashCode!=null &&
              this.favoriteHashCode.equals(other.getFavoriteHashCode()))) &&
            ((this.hstHashCode==null && other.getHstHashCode()==null) || 
             (this.hstHashCode!=null &&
              this.hstHashCode.equals(other.getHstHashCode()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              this.picture.equals(other.getPicture()))) &&
            ((this.privateLazyKey==null && other.getPrivateLazyKey()==null) || 
             (this.privateLazyKey!=null &&
              this.privateLazyKey.equals(other.getPrivateLazyKey()))) &&
            ((this.privateMVPNKey==null && other.getPrivateMVPNKey()==null) || 
             (this.privateMVPNKey!=null &&
              this.privateMVPNKey.equals(other.getPrivateMVPNKey()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.regMail==null && other.getRegMail()==null) || 
             (this.regMail!=null &&
              this.regMail.equals(other.getRegMail()))) &&
            ((this.showHashCode==null && other.getShowHashCode()==null) || 
             (this.showHashCode!=null &&
              this.showHashCode.equals(other.getShowHashCode()))) &&
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
        if (getAuthCode() != null) {
            _hashCode += getAuthCode().hashCode();
        }
        if (getCard() != null) {
            _hashCode += getCard().hashCode();
        }
        if (getCnctHashCode() != null) {
            _hashCode += getCnctHashCode().hashCode();
        }
        if (getDeleted() != null) {
            _hashCode += getDeleted().hashCode();
        }
        if (getFavoriteHashCode() != null) {
            _hashCode += getFavoriteHashCode().hashCode();
        }
        if (getHstHashCode() != null) {
            _hashCode += getHstHashCode().hashCode();
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPicture() != null) {
            _hashCode += getPicture().hashCode();
        }
        if (getPrivateLazyKey() != null) {
            _hashCode += getPrivateLazyKey().hashCode();
        }
        if (getPrivateMVPNKey() != null) {
            _hashCode += getPrivateMVPNKey().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getRegMail() != null) {
            _hashCode += getRegMail().hashCode();
        }
        if (getShowHashCode() != null) {
            _hashCode += getShowHashCode().hashCode();
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
        new org.apache.axis.description.TypeDesc(Account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "Account"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("cnctHashCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "cnctHashCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("favoriteHashCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "favoriteHashCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hstHashCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "hstHashCode"));
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
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.account.talk/xsd", "Phone"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("picture");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "picture"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateLazyKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "privateLazyKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateMVPNKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "privateMVPNKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "reference"));
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
        elemField.setFieldName("showHashCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.account.talk/xsd", "showHashCode"));
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
