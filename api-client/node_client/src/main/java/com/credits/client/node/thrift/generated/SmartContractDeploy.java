/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-12-26")
public class SmartContractDeploy implements org.apache.thrift.TBase<SmartContractDeploy, SmartContractDeploy._Fields>, java.io.Serializable, Cloneable, Comparable<SmartContractDeploy> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SmartContractDeploy");

  private static final org.apache.thrift.protocol.TField SOURCE_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceCode", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_CODE_OBJECTS_FIELD_DESC = new org.apache.thrift.protocol.TField("byteCodeObjects", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField HASH_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("hashState", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TOKEN_STANDART_FIELD_DESC = new org.apache.thrift.protocol.TField("tokenStandart", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SmartContractDeployStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SmartContractDeployTupleSchemeFactory();

  public java.lang.String sourceCode; // required
  public java.util.List<com.credits.general.thrift.generated.ByteCodeObject> byteCodeObjects; // required
  public java.lang.String hashState; // required
  public TokenStandart tokenStandart; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SOURCE_CODE((short)1, "sourceCode"),
    BYTE_CODE_OBJECTS((short)2, "byteCodeObjects"),
    HASH_STATE((short)3, "hashState"),
    TOKEN_STANDART((short)4, "tokenStandart");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SOURCE_CODE
          return SOURCE_CODE;
        case 2: // BYTE_CODE_OBJECTS
          return BYTE_CODE_OBJECTS;
        case 3: // HASH_STATE
          return HASH_STATE;
        case 4: // TOKEN_STANDART
          return TOKEN_STANDART;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SOURCE_CODE, new org.apache.thrift.meta_data.FieldMetaData("sourceCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BYTE_CODE_OBJECTS, new org.apache.thrift.meta_data.FieldMetaData("byteCodeObjects", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.credits.general.thrift.generated.ByteCodeObject.class))));
    tmpMap.put(_Fields.HASH_STATE, new org.apache.thrift.meta_data.FieldMetaData("hashState", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOKEN_STANDART, new org.apache.thrift.meta_data.FieldMetaData("tokenStandart", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.ENUM        , "TokenStandart")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SmartContractDeploy.class, metaDataMap);
  }

  public SmartContractDeploy() {
  }

  public SmartContractDeploy(
    java.lang.String sourceCode,
    java.util.List<com.credits.general.thrift.generated.ByteCodeObject> byteCodeObjects,
    java.lang.String hashState,
    TokenStandart tokenStandart)
  {
    this();
    this.sourceCode = sourceCode;
    this.byteCodeObjects = byteCodeObjects;
    this.hashState = hashState;
    this.tokenStandart = tokenStandart;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SmartContractDeploy(SmartContractDeploy other) {
    if (other.isSetSourceCode()) {
      this.sourceCode = other.sourceCode;
    }
    if (other.isSetByteCodeObjects()) {
      java.util.List<com.credits.general.thrift.generated.ByteCodeObject> __this__byteCodeObjects = new java.util.ArrayList<com.credits.general.thrift.generated.ByteCodeObject>(other.byteCodeObjects.size());
      for (com.credits.general.thrift.generated.ByteCodeObject other_element : other.byteCodeObjects) {
        __this__byteCodeObjects.add(new com.credits.general.thrift.generated.ByteCodeObject(other_element));
      }
      this.byteCodeObjects = __this__byteCodeObjects;
    }
    if (other.isSetHashState()) {
      this.hashState = other.hashState;
    }
    if (other.isSetTokenStandart()) {
      this.tokenStandart = other.tokenStandart;
    }
  }

  public SmartContractDeploy deepCopy() {
    return new SmartContractDeploy(this);
  }

  @Override
  public void clear() {
    this.sourceCode = null;
    this.byteCodeObjects = null;
    this.hashState = null;
    this.tokenStandart = null;
  }

  public java.lang.String getSourceCode() {
    return this.sourceCode;
  }

  public SmartContractDeploy setSourceCode(java.lang.String sourceCode) {
    this.sourceCode = sourceCode;
    return this;
  }

  public void unsetSourceCode() {
    this.sourceCode = null;
  }

  /** Returns true if field sourceCode is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceCode() {
    return this.sourceCode != null;
  }

  public void setSourceCodeIsSet(boolean value) {
    if (!value) {
      this.sourceCode = null;
    }
  }

  public int getByteCodeObjectsSize() {
    return (this.byteCodeObjects == null) ? 0 : this.byteCodeObjects.size();
  }

  public java.util.Iterator<com.credits.general.thrift.generated.ByteCodeObject> getByteCodeObjectsIterator() {
    return (this.byteCodeObjects == null) ? null : this.byteCodeObjects.iterator();
  }

  public void addToByteCodeObjects(com.credits.general.thrift.generated.ByteCodeObject elem) {
    if (this.byteCodeObjects == null) {
      this.byteCodeObjects = new java.util.ArrayList<com.credits.general.thrift.generated.ByteCodeObject>();
    }
    this.byteCodeObjects.add(elem);
  }

  public java.util.List<com.credits.general.thrift.generated.ByteCodeObject> getByteCodeObjects() {
    return this.byteCodeObjects;
  }

  public SmartContractDeploy setByteCodeObjects(java.util.List<com.credits.general.thrift.generated.ByteCodeObject> byteCodeObjects) {
    this.byteCodeObjects = byteCodeObjects;
    return this;
  }

  public void unsetByteCodeObjects() {
    this.byteCodeObjects = null;
  }

  /** Returns true if field byteCodeObjects is set (has been assigned a value) and false otherwise */
  public boolean isSetByteCodeObjects() {
    return this.byteCodeObjects != null;
  }

  public void setByteCodeObjectsIsSet(boolean value) {
    if (!value) {
      this.byteCodeObjects = null;
    }
  }

  public java.lang.String getHashState() {
    return this.hashState;
  }

  public SmartContractDeploy setHashState(java.lang.String hashState) {
    this.hashState = hashState;
    return this;
  }

  public void unsetHashState() {
    this.hashState = null;
  }

  /** Returns true if field hashState is set (has been assigned a value) and false otherwise */
  public boolean isSetHashState() {
    return this.hashState != null;
  }

  public void setHashStateIsSet(boolean value) {
    if (!value) {
      this.hashState = null;
    }
  }

  public TokenStandart getTokenStandart() {
    return this.tokenStandart;
  }

  public SmartContractDeploy setTokenStandart(TokenStandart tokenStandart) {
    this.tokenStandart = tokenStandart;
    return this;
  }

  public void unsetTokenStandart() {
    this.tokenStandart = null;
  }

  /** Returns true if field tokenStandart is set (has been assigned a value) and false otherwise */
  public boolean isSetTokenStandart() {
    return this.tokenStandart != null;
  }

  public void setTokenStandartIsSet(boolean value) {
    if (!value) {
      this.tokenStandart = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SOURCE_CODE:
      if (value == null) {
        unsetSourceCode();
      } else {
        setSourceCode((java.lang.String)value);
      }
      break;

    case BYTE_CODE_OBJECTS:
      if (value == null) {
        unsetByteCodeObjects();
      } else {
        setByteCodeObjects((java.util.List<com.credits.general.thrift.generated.ByteCodeObject>)value);
      }
      break;

    case HASH_STATE:
      if (value == null) {
        unsetHashState();
      } else {
        setHashState((java.lang.String)value);
      }
      break;

    case TOKEN_STANDART:
      if (value == null) {
        unsetTokenStandart();
      } else {
        setTokenStandart((TokenStandart)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SOURCE_CODE:
      return getSourceCode();

    case BYTE_CODE_OBJECTS:
      return getByteCodeObjects();

    case HASH_STATE:
      return getHashState();

    case TOKEN_STANDART:
      return getTokenStandart();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SOURCE_CODE:
      return isSetSourceCode();
    case BYTE_CODE_OBJECTS:
      return isSetByteCodeObjects();
    case HASH_STATE:
      return isSetHashState();
    case TOKEN_STANDART:
      return isSetTokenStandart();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SmartContractDeploy)
      return this.equals((SmartContractDeploy)that);
    return false;
  }

  public boolean equals(SmartContractDeploy that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_sourceCode = true && this.isSetSourceCode();
    boolean that_present_sourceCode = true && that.isSetSourceCode();
    if (this_present_sourceCode || that_present_sourceCode) {
      if (!(this_present_sourceCode && that_present_sourceCode))
        return false;
      if (!this.sourceCode.equals(that.sourceCode))
        return false;
    }

    boolean this_present_byteCodeObjects = true && this.isSetByteCodeObjects();
    boolean that_present_byteCodeObjects = true && that.isSetByteCodeObjects();
    if (this_present_byteCodeObjects || that_present_byteCodeObjects) {
      if (!(this_present_byteCodeObjects && that_present_byteCodeObjects))
        return false;
      if (!this.byteCodeObjects.equals(that.byteCodeObjects))
        return false;
    }

    boolean this_present_hashState = true && this.isSetHashState();
    boolean that_present_hashState = true && that.isSetHashState();
    if (this_present_hashState || that_present_hashState) {
      if (!(this_present_hashState && that_present_hashState))
        return false;
      if (!this.hashState.equals(that.hashState))
        return false;
    }

    boolean this_present_tokenStandart = true && this.isSetTokenStandart();
    boolean that_present_tokenStandart = true && that.isSetTokenStandart();
    if (this_present_tokenStandart || that_present_tokenStandart) {
      if (!(this_present_tokenStandart && that_present_tokenStandart))
        return false;
      if (!this.tokenStandart.equals(that.tokenStandart))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSourceCode()) ? 131071 : 524287);
    if (isSetSourceCode())
      hashCode = hashCode * 8191 + sourceCode.hashCode();

    hashCode = hashCode * 8191 + ((isSetByteCodeObjects()) ? 131071 : 524287);
    if (isSetByteCodeObjects())
      hashCode = hashCode * 8191 + byteCodeObjects.hashCode();

    hashCode = hashCode * 8191 + ((isSetHashState()) ? 131071 : 524287);
    if (isSetHashState())
      hashCode = hashCode * 8191 + hashState.hashCode();

    hashCode = hashCode * 8191 + ((isSetTokenStandart()) ? 131071 : 524287);
    if (isSetTokenStandart())
      hashCode = hashCode * 8191 + tokenStandart.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(SmartContractDeploy other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetSourceCode()).compareTo(other.isSetSourceCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceCode, other.sourceCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetByteCodeObjects()).compareTo(other.isSetByteCodeObjects());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteCodeObjects()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteCodeObjects, other.byteCodeObjects);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHashState()).compareTo(other.isSetHashState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHashState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hashState, other.hashState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTokenStandart()).compareTo(other.isSetTokenStandart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTokenStandart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tokenStandart, other.tokenStandart);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SmartContractDeploy(");
    boolean first = true;

    sb.append("sourceCode:");
    if (this.sourceCode == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("byteCodeObjects:");
    if (this.byteCodeObjects == null) {
      sb.append("null");
    } else {
      sb.append(this.byteCodeObjects);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hashState:");
    if (this.hashState == null) {
      sb.append("null");
    } else {
      sb.append(this.hashState);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tokenStandart:");
    if (this.tokenStandart == null) {
      sb.append("null");
    } else {
      sb.append(this.tokenStandart);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SmartContractDeployStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SmartContractDeployStandardScheme getScheme() {
      return new SmartContractDeployStandardScheme();
    }
  }

  private static class SmartContractDeployStandardScheme extends org.apache.thrift.scheme.StandardScheme<SmartContractDeploy> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SmartContractDeploy struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SOURCE_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sourceCode = iprot.readString();
              struct.setSourceCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BYTE_CODE_OBJECTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.byteCodeObjects = new java.util.ArrayList<com.credits.general.thrift.generated.ByteCodeObject>(_list0.size);
                com.credits.general.thrift.generated.ByteCodeObject _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new com.credits.general.thrift.generated.ByteCodeObject();
                  _elem1.read(iprot);
                  struct.byteCodeObjects.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setByteCodeObjectsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HASH_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.hashState = iprot.readString();
              struct.setHashStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOKEN_STANDART
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tokenStandart = com.credits.client.node.thrift.generated.TokenStandart.findByValue(iprot.readI32());
              struct.setTokenStandartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SmartContractDeploy struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sourceCode != null) {
        oprot.writeFieldBegin(SOURCE_CODE_FIELD_DESC);
        oprot.writeString(struct.sourceCode);
        oprot.writeFieldEnd();
      }
      if (struct.byteCodeObjects != null) {
        oprot.writeFieldBegin(BYTE_CODE_OBJECTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.byteCodeObjects.size()));
          for (com.credits.general.thrift.generated.ByteCodeObject _iter3 : struct.byteCodeObjects)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.hashState != null) {
        oprot.writeFieldBegin(HASH_STATE_FIELD_DESC);
        oprot.writeString(struct.hashState);
        oprot.writeFieldEnd();
      }
      if (struct.tokenStandart != null) {
        oprot.writeFieldBegin(TOKEN_STANDART_FIELD_DESC);
        oprot.writeI32(struct.tokenStandart.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SmartContractDeployTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SmartContractDeployTupleScheme getScheme() {
      return new SmartContractDeployTupleScheme();
    }
  }

  private static class SmartContractDeployTupleScheme extends org.apache.thrift.scheme.TupleScheme<SmartContractDeploy> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SmartContractDeploy struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSourceCode()) {
        optionals.set(0);
      }
      if (struct.isSetByteCodeObjects()) {
        optionals.set(1);
      }
      if (struct.isSetHashState()) {
        optionals.set(2);
      }
      if (struct.isSetTokenStandart()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSourceCode()) {
        oprot.writeString(struct.sourceCode);
      }
      if (struct.isSetByteCodeObjects()) {
        {
          oprot.writeI32(struct.byteCodeObjects.size());
          for (com.credits.general.thrift.generated.ByteCodeObject _iter4 : struct.byteCodeObjects)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetHashState()) {
        oprot.writeString(struct.hashState);
      }
      if (struct.isSetTokenStandart()) {
        oprot.writeI32(struct.tokenStandart.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SmartContractDeploy struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.sourceCode = iprot.readString();
        struct.setSourceCodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.byteCodeObjects = new java.util.ArrayList<com.credits.general.thrift.generated.ByteCodeObject>(_list5.size);
          com.credits.general.thrift.generated.ByteCodeObject _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new com.credits.general.thrift.generated.ByteCodeObject();
            _elem6.read(iprot);
            struct.byteCodeObjects.add(_elem6);
          }
        }
        struct.setByteCodeObjectsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.hashState = iprot.readString();
        struct.setHashStateIsSet(true);
      }
      if (incoming.get(3)) {
        struct.tokenStandart = com.credits.client.node.thrift.generated.TokenStandart.findByValue(iprot.readI32());
        struct.setTokenStandartIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

