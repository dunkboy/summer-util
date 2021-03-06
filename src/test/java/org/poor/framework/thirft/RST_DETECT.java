/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.poor.framework.thirft;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-11-27")
public class RST_DETECT implements org.apache.thrift.TBase<RST_DETECT, RST_DETECT._Fields>, java.io.Serializable, Cloneable, Comparable<RST_DETECT> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RST_DETECT");

  private static final org.apache.thrift.protocol.TField BRET_FIELD_DESC = new org.apache.thrift.protocol.TField("bret", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("val", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField RECT_FIELD_DESC = new org.apache.thrift.protocol.TField("rect", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RST_DETECTStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RST_DETECTTupleSchemeFactory();

  public boolean bret; // required
  public java.util.List<String> type; // required
  public java.util.List<Double> val; // required
  public java.util.List<RECT_DETECT> rect; // required
  public String message; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BRET((short)1, "bret"),
    TYPE((short)2, "type"),
    VAL((short)3, "val"),
    RECT((short)4, "rect"),
    MESSAGE((short)5, "message");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

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
        case 1: // BRET
          return BRET;
        case 2: // TYPE
          return TYPE;
        case 3: // VAL
          return VAL;
        case 4: // RECT
          return RECT;
        case 5: // MESSAGE
          return MESSAGE;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BRET_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BRET, new org.apache.thrift.meta_data.FieldMetaData("bret", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.VAL, new org.apache.thrift.meta_data.FieldMetaData("val", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
    tmpMap.put(_Fields.RECT, new org.apache.thrift.meta_data.FieldMetaData("rect", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RECT_DETECT.class))));
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RST_DETECT.class, metaDataMap);
  }

  public RST_DETECT() {
  }

  public RST_DETECT(
    boolean bret,
    java.util.List<String> type,
    java.util.List<Double> val,
    java.util.List<RECT_DETECT> rect,
    String message)
  {
    this();
    this.bret = bret;
    setBretIsSet(true);
    this.type = type;
    this.val = val;
    this.rect = rect;
    this.message = message;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RST_DETECT(RST_DETECT other) {
    __isset_bitfield = other.__isset_bitfield;
    this.bret = other.bret;
    if (other.isSetType()) {
      java.util.List<String> __this__type = new java.util.ArrayList<String>(other.type);
      this.type = __this__type;
    }
    if (other.isSetVal()) {
      java.util.List<Double> __this__val = new java.util.ArrayList<Double>(other.val);
      this.val = __this__val;
    }
    if (other.isSetRect()) {
      java.util.List<RECT_DETECT> __this__rect = new java.util.ArrayList<RECT_DETECT>(other.rect.size());
      for (RECT_DETECT other_element : other.rect) {
        __this__rect.add(new RECT_DETECT(other_element));
      }
      this.rect = __this__rect;
    }
    if (other.isSetMessage()) {
      this.message = other.message;
    }
  }

  public RST_DETECT deepCopy() {
    return new RST_DETECT(this);
  }

  @Override
  public void clear() {
    setBretIsSet(false);
    this.bret = false;
    this.type = null;
    this.val = null;
    this.rect = null;
    this.message = null;
  }

  public boolean isBret() {
    return this.bret;
  }

  public RST_DETECT setBret(boolean bret) {
    this.bret = bret;
    setBretIsSet(true);
    return this;
  }

  public void unsetBret() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BRET_ISSET_ID);
  }

  /** Returns true if field bret is set (has been assigned a value) and false otherwise */
  public boolean isSetBret() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BRET_ISSET_ID);
  }

  public void setBretIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BRET_ISSET_ID, value);
  }

  public int getTypeSize() {
    return (this.type == null) ? 0 : this.type.size();
  }

  public java.util.Iterator<String> getTypeIterator() {
    return (this.type == null) ? null : this.type.iterator();
  }

  public void addToType(String elem) {
    if (this.type == null) {
      this.type = new java.util.ArrayList<String>();
    }
    this.type.add(elem);
  }

  public java.util.List<String> getType() {
    return this.type;
  }

  public RST_DETECT setType(java.util.List<String> type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public int getValSize() {
    return (this.val == null) ? 0 : this.val.size();
  }

  public java.util.Iterator<Double> getValIterator() {
    return (this.val == null) ? null : this.val.iterator();
  }

  public void addToVal(double elem) {
    if (this.val == null) {
      this.val = new java.util.ArrayList<Double>();
    }
    this.val.add(elem);
  }

  public java.util.List<Double> getVal() {
    return this.val;
  }

  public RST_DETECT setVal(java.util.List<Double> val) {
    this.val = val;
    return this;
  }

  public void unsetVal() {
    this.val = null;
  }

  /** Returns true if field val is set (has been assigned a value) and false otherwise */
  public boolean isSetVal() {
    return this.val != null;
  }

  public void setValIsSet(boolean value) {
    if (!value) {
      this.val = null;
    }
  }

  public int getRectSize() {
    return (this.rect == null) ? 0 : this.rect.size();
  }

  public java.util.Iterator<RECT_DETECT> getRectIterator() {
    return (this.rect == null) ? null : this.rect.iterator();
  }

  public void addToRect(RECT_DETECT elem) {
    if (this.rect == null) {
      this.rect = new java.util.ArrayList<RECT_DETECT>();
    }
    this.rect.add(elem);
  }

  public java.util.List<RECT_DETECT> getRect() {
    return this.rect;
  }

  public RST_DETECT setRect(java.util.List<RECT_DETECT> rect) {
    this.rect = rect;
    return this;
  }

  public void unsetRect() {
    this.rect = null;
  }

  /** Returns true if field rect is set (has been assigned a value) and false otherwise */
  public boolean isSetRect() {
    return this.rect != null;
  }

  public void setRectIsSet(boolean value) {
    if (!value) {
      this.rect = null;
    }
  }

  public String getMessage() {
    return this.message;
  }

  public RST_DETECT setMessage(String message) {
    this.message = message;
    return this;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BRET:
      if (value == null) {
        unsetBret();
      } else {
        setBret((Boolean)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.util.List<String>)value);
      }
      break;

    case VAL:
      if (value == null) {
        unsetVal();
      } else {
        setVal((java.util.List<Double>)value);
      }
      break;

    case RECT:
      if (value == null) {
        unsetRect();
      } else {
        setRect((java.util.List<RECT_DETECT>)value);
      }
      break;

    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BRET:
      return isBret();

    case TYPE:
      return getType();

    case VAL:
      return getVal();

    case RECT:
      return getRect();

    case MESSAGE:
      return getMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BRET:
      return isSetBret();
    case TYPE:
      return isSetType();
    case VAL:
      return isSetVal();
    case RECT:
      return isSetRect();
    case MESSAGE:
      return isSetMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RST_DETECT)
      return this.equals((RST_DETECT)that);
    return false;
  }

  public boolean equals(RST_DETECT that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_bret = true;
    boolean that_present_bret = true;
    if (this_present_bret || that_present_bret) {
      if (!(this_present_bret && that_present_bret))
        return false;
      if (this.bret != that.bret)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_val = true && this.isSetVal();
    boolean that_present_val = true && that.isSetVal();
    if (this_present_val || that_present_val) {
      if (!(this_present_val && that_present_val))
        return false;
      if (!this.val.equals(that.val))
        return false;
    }

    boolean this_present_rect = true && this.isSetRect();
    boolean that_present_rect = true && that.isSetRect();
    if (this_present_rect || that_present_rect) {
      if (!(this_present_rect && that_present_rect))
        return false;
      if (!this.rect.equals(that.rect))
        return false;
    }

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((bret) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.hashCode();

    hashCode = hashCode * 8191 + ((isSetVal()) ? 131071 : 524287);
    if (isSetVal())
      hashCode = hashCode * 8191 + val.hashCode();

    hashCode = hashCode * 8191 + ((isSetRect()) ? 131071 : 524287);
    if (isSetRect())
      hashCode = hashCode * 8191 + rect.hashCode();

    hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
    if (isSetMessage())
      hashCode = hashCode * 8191 + message.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RST_DETECT other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBret()).compareTo(other.isSetBret());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBret()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bret, other.bret);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVal()).compareTo(other.isSetVal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.val, other.val);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRect()).compareTo(other.isSetRect());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRect()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rect, other.rect);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
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
  public String toString() {
    StringBuilder sb = new StringBuilder("RST_DETECT(");
    boolean first = true;

    sb.append("bret:");
    sb.append(this.bret);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("val:");
    if (this.val == null) {
      sb.append("null");
    } else {
      sb.append(this.val);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rect:");
    if (this.rect == null) {
      sb.append("null");
    } else {
      sb.append(this.rect);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("message:");
    if (this.message == null) {
      sb.append("null");
    } else {
      sb.append(this.message);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RST_DETECTStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RST_DETECTStandardScheme getScheme() {
      return new RST_DETECTStandardScheme();
    }
  }

  private static class RST_DETECTStandardScheme extends org.apache.thrift.scheme.StandardScheme<RST_DETECT> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RST_DETECT struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BRET
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.bret = iprot.readBool();
              struct.setBretIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.type = new java.util.ArrayList<String>(_list0.size);
                String _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readString();
                  struct.type.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VAL
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.val = new java.util.ArrayList<Double>(_list3.size);
                double _elem4;
                for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                {
                  _elem4 = iprot.readDouble();
                  struct.val.add(_elem4);
                }
                iprot.readListEnd();
              }
              struct.setValIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RECT
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.rect = new java.util.ArrayList<RECT_DETECT>(_list6.size);
                RECT_DETECT _elem7;
                for (int _i8 = 0; _i8 < _list6.size; ++_i8)
                {
                  _elem7 = new RECT_DETECT();
                  _elem7.read(iprot);
                  struct.rect.add(_elem7);
                }
                iprot.readListEnd();
              }
              struct.setRectIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RST_DETECT struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(BRET_FIELD_DESC);
      oprot.writeBool(struct.bret);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.type.size()));
          for (String _iter9 : struct.type)
          {
            oprot.writeString(_iter9);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.val != null) {
        oprot.writeFieldBegin(VAL_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.DOUBLE, struct.val.size()));
          for (double _iter10 : struct.val)
          {
            oprot.writeDouble(_iter10);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.rect != null) {
        oprot.writeFieldBegin(RECT_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.rect.size()));
          for (RECT_DETECT _iter11 : struct.rect)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.message != null) {
        oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
        oprot.writeString(struct.message);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RST_DETECTTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RST_DETECTTupleScheme getScheme() {
      return new RST_DETECTTupleScheme();
    }
  }

  private static class RST_DETECTTupleScheme extends org.apache.thrift.scheme.TupleScheme<RST_DETECT> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RST_DETECT struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBret()) {
        optionals.set(0);
      }
      if (struct.isSetType()) {
        optionals.set(1);
      }
      if (struct.isSetVal()) {
        optionals.set(2);
      }
      if (struct.isSetRect()) {
        optionals.set(3);
      }
      if (struct.isSetMessage()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetBret()) {
        oprot.writeBool(struct.bret);
      }
      if (struct.isSetType()) {
        {
          oprot.writeI32(struct.type.size());
          for (String _iter12 : struct.type)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetVal()) {
        {
          oprot.writeI32(struct.val.size());
          for (double _iter13 : struct.val)
          {
            oprot.writeDouble(_iter13);
          }
        }
      }
      if (struct.isSetRect()) {
        {
          oprot.writeI32(struct.rect.size());
          for (RECT_DETECT _iter14 : struct.rect)
          {
            _iter14.write(oprot);
          }
        }
      }
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RST_DETECT struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.bret = iprot.readBool();
        struct.setBretIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.type = new java.util.ArrayList<String>(_list15.size);
          String _elem16;
          for (int _i17 = 0; _i17 < _list15.size; ++_i17)
          {
            _elem16 = iprot.readString();
            struct.type.add(_elem16);
          }
        }
        struct.setTypeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
          struct.val = new java.util.ArrayList<Double>(_list18.size);
          double _elem19;
          for (int _i20 = 0; _i20 < _list18.size; ++_i20)
          {
            _elem19 = iprot.readDouble();
            struct.val.add(_elem19);
          }
        }
        struct.setValIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.rect = new java.util.ArrayList<RECT_DETECT>(_list21.size);
          RECT_DETECT _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new RECT_DETECT();
            _elem22.read(iprot);
            struct.rect.add(_elem22);
          }
        }
        struct.setRectIsSet(true);
      }
      if (incoming.get(4)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

