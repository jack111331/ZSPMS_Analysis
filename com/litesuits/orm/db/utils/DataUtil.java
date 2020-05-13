package com.litesuits.orm.db.utils;

import android.annotation.TargetApi;
import android.database.Cursor;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.Primarykey;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.log.OrmLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DataUtil implements Serializable {
  public static final String BLOB = " BLOB ";
  
  public static final int CLASS_TYPE_BOOLEAN = 2;
  
  public static final int CLASS_TYPE_BYTE = 8;
  
  public static final int CLASS_TYPE_BYTE_ARRAY = 9;
  
  public static final int CLASS_TYPE_CHAR = 10;
  
  public static final int CLASS_TYPE_DATE = 11;
  
  public static final int CLASS_TYPE_DOUBLE = 3;
  
  public static final int CLASS_TYPE_FLOAT = 4;
  
  public static final int CLASS_TYPE_INT = 6;
  
  public static final int CLASS_TYPE_LONG = 5;
  
  public static final int CLASS_TYPE_NONE = 0;
  
  public static final int CLASS_TYPE_SERIALIZABLE = 12;
  
  public static final int CLASS_TYPE_SHORT = 7;
  
  public static final int CLASS_TYPE_STRING = 1;
  
  public static final int CLASS_TYPE_UNKNOWN = 13;
  
  public static final int FIELD_TYPE_BLOB = 4;
  
  public static final int FIELD_TYPE_DATE = 5;
  
  public static final int FIELD_TYPE_LONG = 1;
  
  public static final int FIELD_TYPE_NULL = 0;
  
  public static final int FIELD_TYPE_REAL = 2;
  
  public static final int FIELD_TYPE_SERIALIZABLE = 6;
  
  public static final int FIELD_TYPE_STRING = 3;
  
  public static final String INTEGER = " INTEGER ";
  
  public static final String NULL = " NULL ";
  
  public static final String REAL = " REAL ";
  
  public static final String TAG = "DataUtil";
  
  public static final String TEXT = " TEXT ";
  
  private static final long serialVersionUID = 6668874253056236676L;
  
  public static List<?> arrayToList(Object[] paramArrayOfObject) {
    return Arrays.asList(paramArrayOfObject);
  }
  
  public static Object[] arrayToList(Collection<?> paramCollection) {
    return paramCollection.toArray();
  }
  
  public static Object byteToObject(byte[] paramArrayOfbyte) throws Exception {
    ObjectInputStream objectInputStream = null;
    try {
      ObjectInputStream objectInputStream1 = new ObjectInputStream();
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramArrayOfbyte);
      this(byteArrayInputStream);
      try {
        return objectInputStream1.readObject();
      } finally {
        paramArrayOfbyte = null;
      } 
    } finally {}
    if (objectInputStream != null)
      objectInputStream.close(); 
    throw paramArrayOfbyte;
  }
  
  @TargetApi(9)
  public static <T> T[] concat(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    Object[] arrayOfObject = Arrays.copyOf((Object[])paramArrayOfT1, paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return (T[])arrayOfObject;
  }
  
  @TargetApi(9)
  public static <T> T[] concatAll(T[] paramArrayOfT, T[]... paramVarArgs) {
    int i = paramArrayOfT.length;
    int j = paramVarArgs.length;
    byte b;
    for (b = 0; b < j; b++)
      i += (paramVarArgs[b]).length; 
    Object[] arrayOfObject = Arrays.copyOf((Object[])paramArrayOfT, i);
    i = paramArrayOfT.length;
    j = paramVarArgs.length;
    for (b = 0; b < j; b++) {
      paramArrayOfT = paramVarArgs[b];
      System.arraycopy(paramArrayOfT, 0, arrayOfObject, i, paramArrayOfT.length);
      i += paramArrayOfT.length;
    } 
    return (T[])arrayOfObject;
  }
  
  public static int getFieldClassType(Field paramField) {
    Class<?> clazz = paramField.getType();
    return CharSequence.class.isAssignableFrom(clazz) ? 1 : ((boolean.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz)) ? 2 : ((double.class.isAssignableFrom(clazz) || Double.class.isAssignableFrom(clazz)) ? 3 : ((float.class.isAssignableFrom(clazz) || Float.class.isAssignableFrom(clazz)) ? 4 : ((long.class.isAssignableFrom(clazz) || Long.class.isAssignableFrom(clazz)) ? 5 : ((int.class.isAssignableFrom(clazz) || Integer.class.isAssignableFrom(clazz)) ? 6 : ((short.class.isAssignableFrom(clazz) || Short.class.isAssignableFrom(clazz)) ? 7 : ((byte.class.isAssignableFrom(clazz) || Byte.class.isAssignableFrom(clazz)) ? 8 : ((byte[].class.isAssignableFrom(clazz) || Byte[].class.isAssignableFrom(clazz)) ? 9 : ((char.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) ? 10 : (Date.class.isAssignableFrom(clazz) ? 11 : (Serializable.class.isAssignableFrom(clazz) ? 12 : 13)))))))))));
  }
  
  public static String getSQLDataType(int paramInt) {
    switch (paramInt) {
      default:
        return " BLOB ";
      case 5:
      case 6:
      case 7:
      case 8:
      case 11:
        return " INTEGER ";
      case 3:
      case 4:
        return " REAL ";
      case 1:
      case 2:
      case 10:
        break;
    } 
    return " TEXT ";
  }
  
  public static int getType(Object paramObject) {
    return (paramObject == null) ? 0 : ((paramObject instanceof CharSequence || paramObject instanceof Boolean || paramObject instanceof Character) ? 3 : ((paramObject instanceof Float || paramObject instanceof Double) ? 2 : ((paramObject instanceof Number) ? 1 : ((paramObject instanceof Date) ? 5 : ((paramObject instanceof byte[]) ? 4 : ((paramObject instanceof Serializable) ? 6 : 0))))));
  }
  
  public static void injectDataToObject(Cursor paramCursor, Object paramObject, EntityTable paramEntityTable) throws Exception {
    int i = paramCursor.getColumnCount();
    for (byte b = 0; b < i; b++) {
      Primarykey primarykey;
      String str2;
      String str1 = paramCursor.getColumnName(b);
      Property property1 = null;
      if (!Checker.isEmpty(paramEntityTable.pmap))
        property1 = (Property)paramEntityTable.pmap.get(str1); 
      Property property2 = property1;
      if (property1 == null) {
        property2 = property1;
        if (paramEntityTable.key != null) {
          property2 = property1;
          if (str1.equals(paramEntityTable.key.column))
            primarykey = paramEntityTable.key; 
        } 
      } 
      if (primarykey == null) {
        if (OrmLog.isPrint) {
          str2 = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("数据库字段[");
          stringBuilder.append(str1);
          stringBuilder.append("]已在实体中被移除");
          OrmLog.w(str2, stringBuilder.toString());
        } 
      } else {
        byte[] arrayOfByte;
        Long long_;
        String str;
        Field field = ((Property)str2).field;
        field.setAccessible(true);
        switch (((Property)str2).classType) {
          case 12:
            arrayOfByte = paramCursor.getBlob(b);
            if (arrayOfByte != null)
              field.set(paramObject, byteToObject(arrayOfByte)); 
            break;
          case 11:
            long_ = Long.valueOf(paramCursor.getLong(b));
            if (long_ != null)
              field.set(paramObject, new Date(long_.longValue())); 
            break;
          case 10:
            str = paramCursor.getString(b);
            if (!Checker.isEmpty(str))
              field.set(paramObject, Character.valueOf(str.charAt(0))); 
            break;
          case 9:
            field.set(paramObject, paramCursor.getBlob(b));
            break;
          case 8:
            if (paramCursor.getString(b) != null)
              field.set(paramObject, Byte.valueOf(Byte.parseByte(paramCursor.getString(b)))); 
            break;
          case 7:
            field.set(paramObject, Short.valueOf(paramCursor.getShort(b)));
            break;
          case 6:
            field.set(paramObject, Integer.valueOf(paramCursor.getInt(b)));
            break;
          case 5:
            field.set(paramObject, Long.valueOf(paramCursor.getLong(b)));
            break;
          case 4:
            field.set(paramObject, Float.valueOf(paramCursor.getFloat(b)));
            break;
          case 3:
            field.set(paramObject, Double.valueOf(paramCursor.getDouble(b)));
            break;
          case 2:
            field.set(paramObject, Boolean.valueOf(Boolean.parseBoolean(paramCursor.getString(b))));
            break;
          case 1:
            field.set(paramObject, paramCursor.getString(b));
            break;
        } 
      } 
    } 
  }
  
  public static byte[] objectToByte(Object paramObject) throws IOException {
    ObjectOutputStream objectOutputStream2;
    ObjectOutputStream objectOutputStream1 = null;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      objectOutputStream2 = new ObjectOutputStream();
      this(byteArrayOutputStream);
    } finally {
      paramObject = null;
    } 
    if (objectOutputStream2 != null)
      objectOutputStream2.close(); 
    throw paramObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\d\\utils\DataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */