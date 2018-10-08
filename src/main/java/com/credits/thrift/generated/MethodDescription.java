/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-10-08")
public class MethodDescription implements org.apache.thrift.TBase<MethodDescription, MethodDescription._Fields>, java.io.Serializable, Cloneable, Comparable<MethodDescription> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MethodDescription");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ARG_TYPES_FIELD_DESC = new org.apache.thrift.protocol.TField("argTypes", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField RETURN_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("returnType", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MethodDescriptionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MethodDescriptionTupleSchemeFactory();

  public java.lang.String name; // required
  public java.util.List<java.lang.String> argTypes; // required
  public java.lang.String returnType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    ARG_TYPES((short)2, "argTypes"),
    RETURN_TYPE((short)3, "returnType");

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
        case 1: // NAME
          return NAME;
        case 2: // ARG_TYPES
          return ARG_TYPES;
        case 3: // RETURN_TYPE
          return RETURN_TYPE;
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
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ARG_TYPES, new org.apache.thrift.meta_data.FieldMetaData("argTypes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.RETURN_TYPE, new org.apache.thrift.meta_data.FieldMetaData("returnType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MethodDescription.class, metaDataMap);
  }

  public MethodDescription() {
  }

  public MethodDescription(
    java.lang.String name,
    java.util.List<java.lang.String> argTypes,
    java.lang.String returnType)
  {
    this();
    this.name = name;
    this.argTypes = argTypes;
    this.returnType = returnType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MethodDescription(MethodDescription other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetArgTypes()) {
      java.util.List<java.lang.String> __this__argTypes = new java.util.ArrayList<java.lang.String>(other.argTypes);
      this.argTypes = __this__argTypes;
    }
    if (other.isSetReturnType()) {
      this.returnType = other.returnType;
    }
  }

  public MethodDescription deepCopy() {
    return new MethodDescription(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.argTypes = null;
    this.returnType = null;
  }

  public java.lang.String getName() {
    return this.name;
  }

  public MethodDescription setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getArgTypesSize() {
    return (this.argTypes == null) ? 0 : this.argTypes.size();
  }

  public java.util.Iterator<java.lang.String> getArgTypesIterator() {
    return (this.argTypes == null) ? null : this.argTypes.iterator();
  }

  public void addToArgTypes(java.lang.String elem) {
    if (this.argTypes == null) {
      this.argTypes = new java.util.ArrayList<java.lang.String>();
    }
    this.argTypes.add(elem);
  }

  public java.util.List<java.lang.String> getArgTypes() {
    return this.argTypes;
  }

  public MethodDescription setArgTypes(java.util.List<java.lang.String> argTypes) {
    this.argTypes = argTypes;
    return this;
  }

  public void unsetArgTypes() {
    this.argTypes = null;
  }

  /** Returns true if field argTypes is set (has been assigned a value) and false otherwise */
  public boolean isSetArgTypes() {
    return this.argTypes != null;
  }

  public void setArgTypesIsSet(boolean value) {
    if (!value) {
      this.argTypes = null;
    }
  }

  public java.lang.String getReturnType() {
    return this.returnType;
  }

  public MethodDescription setReturnType(java.lang.String returnType) {
    this.returnType = returnType;
    return this;
  }

  public void unsetReturnType() {
    this.returnType = null;
  }

  /** Returns true if field returnType is set (has been assigned a value) and false otherwise */
  public boolean isSetReturnType() {
    return this.returnType != null;
  }

  public void setReturnTypeIsSet(boolean value) {
    if (!value) {
      this.returnType = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case ARG_TYPES:
      if (value == null) {
        unsetArgTypes();
      } else {
        setArgTypes((java.util.List<java.lang.String>)value);
      }
      break;

    case RETURN_TYPE:
      if (value == null) {
        unsetReturnType();
      } else {
        setReturnType((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case ARG_TYPES:
      return getArgTypes();

    case RETURN_TYPE:
      return getReturnType();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case ARG_TYPES:
      return isSetArgTypes();
    case RETURN_TYPE:
      return isSetReturnType();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MethodDescription)
      return this.equals((MethodDescription)that);
    return false;
  }

  public boolean equals(MethodDescription that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_argTypes = true && this.isSetArgTypes();
    boolean that_present_argTypes = true && that.isSetArgTypes();
    if (this_present_argTypes || that_present_argTypes) {
      if (!(this_present_argTypes && that_present_argTypes))
        return false;
      if (!this.argTypes.equals(that.argTypes))
        return false;
    }

    boolean this_present_returnType = true && this.isSetReturnType();
    boolean that_present_returnType = true && that.isSetReturnType();
    if (this_present_returnType || that_present_returnType) {
      if (!(this_present_returnType && that_present_returnType))
        return false;
      if (!this.returnType.equals(that.returnType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetArgTypes()) ? 131071 : 524287);
    if (isSetArgTypes())
      hashCode = hashCode * 8191 + argTypes.hashCode();

    hashCode = hashCode * 8191 + ((isSetReturnType()) ? 131071 : 524287);
    if (isSetReturnType())
      hashCode = hashCode * 8191 + returnType.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MethodDescription other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetArgTypes()).compareTo(other.isSetArgTypes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArgTypes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.argTypes, other.argTypes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetReturnType()).compareTo(other.isSetReturnType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturnType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.returnType, other.returnType);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MethodDescription(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("argTypes:");
    if (this.argTypes == null) {
      sb.append("null");
    } else {
      sb.append(this.argTypes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("returnType:");
    if (this.returnType == null) {
      sb.append("null");
    } else {
      sb.append(this.returnType);
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

  private static class MethodDescriptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MethodDescriptionStandardScheme getScheme() {
      return new MethodDescriptionStandardScheme();
    }
  }

  private static class MethodDescriptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<MethodDescription> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MethodDescription struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ARG_TYPES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list10 = iprot.readListBegin();
                struct.argTypes = new java.util.ArrayList<java.lang.String>(_list10.size);
                java.lang.String _elem11;
                for (int _i12 = 0; _i12 < _list10.size; ++_i12)
                {
                  _elem11 = iprot.readString();
                  struct.argTypes.add(_elem11);
                }
                iprot.readListEnd();
              }
              struct.setArgTypesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // RETURN_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.returnType = iprot.readString();
              struct.setReturnTypeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MethodDescription struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.argTypes != null) {
        oprot.writeFieldBegin(ARG_TYPES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.argTypes.size()));
          for (java.lang.String _iter13 : struct.argTypes)
          {
            oprot.writeString(_iter13);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.returnType != null) {
        oprot.writeFieldBegin(RETURN_TYPE_FIELD_DESC);
        oprot.writeString(struct.returnType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MethodDescriptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MethodDescriptionTupleScheme getScheme() {
      return new MethodDescriptionTupleScheme();
    }
  }

  private static class MethodDescriptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<MethodDescription> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MethodDescription struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetArgTypes()) {
        optionals.set(1);
      }
      if (struct.isSetReturnType()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetArgTypes()) {
        {
          oprot.writeI32(struct.argTypes.size());
          for (java.lang.String _iter14 : struct.argTypes)
          {
            oprot.writeString(_iter14);
          }
        }
      }
      if (struct.isSetReturnType()) {
        oprot.writeString(struct.returnType);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MethodDescription struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.argTypes = new java.util.ArrayList<java.lang.String>(_list15.size);
          java.lang.String _elem16;
          for (int _i17 = 0; _i17 < _list15.size; ++_i17)
          {
            _elem16 = iprot.readString();
            struct.argTypes.add(_elem16);
          }
        }
        struct.setArgTypesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.returnType = iprot.readString();
        struct.setReturnTypeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

