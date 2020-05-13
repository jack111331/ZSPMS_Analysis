package com.alibaba.fastjson.serializer;

public enum SerializerFeature {
  BeanToArray, BrowserCompatible, BrowserSecure, DisableCheckSpecialChar, DisableCircularReferenceDetect, IgnoreErrorGetter, IgnoreNonFieldGetter, MapSortField, NotWriteDefaultValue, NotWriteRootClassName, PrettyFormat, QuoteFieldNames, SkipTransientField, SortField, UseISO8601DateFormat, UseSingleQuotes, WriteBigDecimalAsPlain, WriteClassName, WriteDateUseDateFormat, WriteEnumUsingName, WriteEnumUsingToString, WriteMapNullValue, WriteNonStringKeyAsString, WriteNonStringValueAsString, WriteNullBooleanAsFalse, WriteNullListAsEmpty, WriteNullNumberAsZero, WriteNullStringAsEmpty, WriteSlashAsSpecial, WriteTabAsSpecial;
  
  public static final SerializerFeature[] EMPTY;
  
  public static final int WRITE_MAP_NULL_FEATURES;
  
  public final int mask = 1 << ordinal();
  
  static {
    WriteEnumUsingToString = new SerializerFeature("WriteEnumUsingToString", 3);
    WriteEnumUsingName = new SerializerFeature("WriteEnumUsingName", 4);
    UseISO8601DateFormat = new SerializerFeature("UseISO8601DateFormat", 5);
    WriteNullListAsEmpty = new SerializerFeature("WriteNullListAsEmpty", 6);
    WriteNullStringAsEmpty = new SerializerFeature("WriteNullStringAsEmpty", 7);
    WriteNullNumberAsZero = new SerializerFeature("WriteNullNumberAsZero", 8);
    WriteNullBooleanAsFalse = new SerializerFeature("WriteNullBooleanAsFalse", 9);
    SkipTransientField = new SerializerFeature("SkipTransientField", 10);
    SortField = new SerializerFeature("SortField", 11);
    WriteTabAsSpecial = new SerializerFeature("WriteTabAsSpecial", 12);
    PrettyFormat = new SerializerFeature("PrettyFormat", 13);
    WriteClassName = new SerializerFeature("WriteClassName", 14);
    DisableCircularReferenceDetect = new SerializerFeature("DisableCircularReferenceDetect", 15);
    WriteSlashAsSpecial = new SerializerFeature("WriteSlashAsSpecial", 16);
    BrowserCompatible = new SerializerFeature("BrowserCompatible", 17);
    WriteDateUseDateFormat = new SerializerFeature("WriteDateUseDateFormat", 18);
    NotWriteRootClassName = new SerializerFeature("NotWriteRootClassName", 19);
    DisableCheckSpecialChar = new SerializerFeature("DisableCheckSpecialChar", 20);
    BeanToArray = new SerializerFeature("BeanToArray", 21);
    WriteNonStringKeyAsString = new SerializerFeature("WriteNonStringKeyAsString", 22);
    NotWriteDefaultValue = new SerializerFeature("NotWriteDefaultValue", 23);
    BrowserSecure = new SerializerFeature("BrowserSecure", 24);
    IgnoreNonFieldGetter = new SerializerFeature("IgnoreNonFieldGetter", 25);
    WriteNonStringValueAsString = new SerializerFeature("WriteNonStringValueAsString", 26);
    IgnoreErrorGetter = new SerializerFeature("IgnoreErrorGetter", 27);
    WriteBigDecimalAsPlain = new SerializerFeature("WriteBigDecimalAsPlain", 28);
    MapSortField = new SerializerFeature("MapSortField", 29);
    $VALUES = new SerializerFeature[] { 
        QuoteFieldNames, UseSingleQuotes, WriteMapNullValue, WriteEnumUsingToString, WriteEnumUsingName, UseISO8601DateFormat, WriteNullListAsEmpty, WriteNullStringAsEmpty, WriteNullNumberAsZero, WriteNullBooleanAsFalse, 
        SkipTransientField, SortField, WriteTabAsSpecial, PrettyFormat, WriteClassName, DisableCircularReferenceDetect, WriteSlashAsSpecial, BrowserCompatible, WriteDateUseDateFormat, NotWriteRootClassName, 
        DisableCheckSpecialChar, BeanToArray, WriteNonStringKeyAsString, NotWriteDefaultValue, BrowserSecure, IgnoreNonFieldGetter, WriteNonStringValueAsString, IgnoreErrorGetter, WriteBigDecimalAsPlain, MapSortField };
    EMPTY = new SerializerFeature[0];
    WRITE_MAP_NULL_FEATURES = WriteMapNullValue.getMask() | WriteNullBooleanAsFalse.getMask() | WriteNullListAsEmpty.getMask() | WriteNullNumberAsZero.getMask() | WriteNullStringAsEmpty.getMask();
  }
  
  public static int config(int paramInt, SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    if (paramBoolean) {
      paramInt |= paramSerializerFeature.mask;
    } else {
      paramInt &= paramSerializerFeature.mask ^ 0xFFFFFFFF;
    } 
    return paramInt;
  }
  
  public static boolean isEnabled(int paramInt1, int paramInt2, SerializerFeature paramSerializerFeature) {
    int i = paramSerializerFeature.mask;
    return ((paramInt1 & i) != 0 || (paramInt2 & i) != 0);
  }
  
  public static boolean isEnabled(int paramInt, SerializerFeature paramSerializerFeature) {
    boolean bool;
    if ((paramInt & paramSerializerFeature.mask) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static int of(SerializerFeature[] paramArrayOfSerializerFeature) {
    byte b = 0;
    if (paramArrayOfSerializerFeature == null)
      return 0; 
    int i = paramArrayOfSerializerFeature.length;
    int j = 0;
    while (b < i) {
      j |= (paramArrayOfSerializerFeature[b]).mask;
      b++;
    } 
    return j;
  }
  
  public final int getMask() {
    return this.mask;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializerFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */