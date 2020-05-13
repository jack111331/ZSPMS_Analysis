package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

public final class h {
  private StringBuilder a;
  
  private int b = 0;
  
  public h(StringBuilder paramStringBuilder, int paramInt) {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private <T> h a(T paramT, String paramString) {
    if (paramT == null) {
      this.a.append("null\n");
    } else {
      StringBuilder stringBuilder;
      if (paramT instanceof Byte) {
        byte b = ((Byte)paramT).byteValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(b);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Boolean) {
        byte b;
        boolean bool = ((Boolean)stringBuilder).booleanValue();
        a(paramString);
        stringBuilder = this.a;
        if (bool) {
          byte b1 = 84;
          b = b1;
        } else {
          byte b1 = 70;
          b = b1;
        } 
        stringBuilder.append(b);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Short) {
        short s = ((Short)stringBuilder).shortValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(s);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Integer) {
        int i = ((Integer)stringBuilder).intValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(i);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Long) {
        long l = ((Long)stringBuilder).longValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(l);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Float) {
        float f = ((Float)stringBuilder).floatValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(f);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof Double) {
        double d = ((Double)stringBuilder).doubleValue();
        a(paramString);
        stringBuilder = this.a;
        stringBuilder.append(d);
        stringBuilder.append('\n');
      } else if (stringBuilder instanceof String) {
        a((String)stringBuilder, paramString);
      } else if (stringBuilder instanceof Map) {
        a((Map<?, ?>)stringBuilder, paramString);
      } else {
        List list;
        if (stringBuilder instanceof List) {
          list = (List)stringBuilder;
          if (list == null) {
            a(paramString);
            this.a.append("null\t");
          } else {
            a(list.toArray(), paramString);
          } 
        } else if (list instanceof k) {
          a((k)list, paramString);
        } else if (list instanceof byte[]) {
          a((byte[])list, paramString);
        } else if (list instanceof boolean[]) {
          a((boolean[])list, paramString);
        } else {
          StringBuilder stringBuilder1;
          h h1;
          boolean bool = list instanceof short[];
          int j = 0;
          int k = 0;
          boolean bool1 = false;
          boolean bool2 = false;
          int i = 0;
          if (bool) {
            short[] arrayOfShort = (short[])list;
            a(paramString);
            if (arrayOfShort == null) {
              this.a.append("null\n");
            } else if (arrayOfShort.length == 0) {
              StringBuilder stringBuilder2 = this.a;
              stringBuilder2.append(arrayOfShort.length);
              stringBuilder2.append(", []\n");
            } else {
              StringBuilder stringBuilder2 = this.a;
              stringBuilder2.append(arrayOfShort.length);
              stringBuilder2.append(", [\n");
              h1 = new h(this.a, this.b + 1);
              j = arrayOfShort.length;
              while (i < j) {
                k = arrayOfShort[i];
                h1.a(null);
                StringBuilder stringBuilder3 = h1.a;
                stringBuilder3.append(k);
                stringBuilder3.append('\n');
                i++;
              } 
              a(null);
              stringBuilder1 = this.a;
              stringBuilder1.append(']');
              stringBuilder1.append('\n');
            } 
          } else {
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            if (stringBuilder1 instanceof int[]) {
              int[] arrayOfInt = (int[])stringBuilder1;
              a((String)h1);
              if (arrayOfInt == null) {
                this.a.append("null\n");
              } else if (arrayOfInt.length == 0) {
                stringBuilder3 = this.a;
                stringBuilder3.append(arrayOfInt.length);
                stringBuilder3.append(", []\n");
              } else {
                stringBuilder3 = this.a;
                stringBuilder3.append(arrayOfInt.length);
                stringBuilder3.append(", [\n");
                h h2 = new h(this.a, this.b + 1);
                k = arrayOfInt.length;
                for (i = j; i < k; i++) {
                  j = arrayOfInt[i];
                  h2.a(null);
                  stringBuilder3 = h2.a;
                  stringBuilder3.append(j);
                  stringBuilder3.append('\n');
                } 
                a(null);
                stringBuilder2 = this.a;
                stringBuilder2.append(']');
                stringBuilder2.append('\n');
              } 
            } else {
              StringBuilder stringBuilder4;
              h h2;
              if (stringBuilder2 instanceof long[]) {
                long[] arrayOfLong = (long[])stringBuilder2;
                a((String)stringBuilder3);
                if (arrayOfLong == null) {
                  this.a.append("null\n");
                } else if (arrayOfLong.length == 0) {
                  stringBuilder3 = this.a;
                  stringBuilder3.append(arrayOfLong.length);
                  stringBuilder3.append(", []\n");
                } else {
                  stringBuilder3 = this.a;
                  stringBuilder3.append(arrayOfLong.length);
                  stringBuilder3.append(", [\n");
                  h2 = new h(this.a, this.b + 1);
                  j = arrayOfLong.length;
                  for (i = k; i < j; i++) {
                    long l = arrayOfLong[i];
                    h2.a(null);
                    StringBuilder stringBuilder5 = h2.a;
                    stringBuilder5.append(l);
                    stringBuilder5.append('\n');
                  } 
                  a(null);
                  stringBuilder4 = this.a;
                  stringBuilder4.append(']');
                  stringBuilder4.append('\n');
                } 
              } else {
                StringBuilder stringBuilder5;
                StringBuilder stringBuilder6;
                if (stringBuilder4 instanceof float[]) {
                  float[] arrayOfFloat = (float[])stringBuilder4;
                  a((String)h2);
                  if (arrayOfFloat == null) {
                    this.a.append("null\n");
                  } else if (arrayOfFloat.length == 0) {
                    stringBuilder6 = this.a;
                    stringBuilder6.append(arrayOfFloat.length);
                    stringBuilder6.append(", []\n");
                  } else {
                    stringBuilder6 = this.a;
                    stringBuilder6.append(arrayOfFloat.length);
                    stringBuilder6.append(", [\n");
                    h h3 = new h(this.a, this.b + 1);
                    j = arrayOfFloat.length;
                    for (i = bool1; i < j; i++) {
                      float f = arrayOfFloat[i];
                      h3.a(null);
                      stringBuilder6 = h3.a;
                      stringBuilder6.append(f);
                      stringBuilder6.append('\n');
                    } 
                    a(null);
                    stringBuilder5 = this.a;
                    stringBuilder5.append(']');
                    stringBuilder5.append('\n');
                  } 
                } else {
                  StringBuilder stringBuilder7;
                  if (stringBuilder5 instanceof double[]) {
                    double[] arrayOfDouble = (double[])stringBuilder5;
                    a((String)stringBuilder6);
                    if (arrayOfDouble == null) {
                      this.a.append("null\n");
                    } else if (arrayOfDouble.length == 0) {
                      stringBuilder6 = this.a;
                      stringBuilder6.append(arrayOfDouble.length);
                      stringBuilder6.append(", []\n");
                    } else {
                      stringBuilder6 = this.a;
                      stringBuilder6.append(arrayOfDouble.length);
                      stringBuilder6.append(", [\n");
                      h h3 = new h(this.a, this.b + 1);
                      j = arrayOfDouble.length;
                      for (i = bool2; i < j; i++) {
                        double d = arrayOfDouble[i];
                        h3.a(null);
                        stringBuilder6 = h3.a;
                        stringBuilder6.append(d);
                        stringBuilder6.append('\n');
                      } 
                      a(null);
                      stringBuilder7 = this.a;
                      stringBuilder7.append(']');
                      stringBuilder7.append('\n');
                    } 
                  } else {
                    if (stringBuilder7.getClass().isArray()) {
                      a((Object[])stringBuilder7, (String)stringBuilder6);
                      return this;
                    } 
                    throw new b("write object error: unsupport type.");
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return this;
  }
  
  private <T> h a(T[] paramArrayOfT, String paramString) {
    a(paramString);
    if (paramArrayOfT == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramArrayOfT.length == 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramArrayOfT.length);
      stringBuilder.append(", []\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramArrayOfT.length);
    stringBuilder2.append(", [\n");
    h h1 = new h(this.a, this.b + 1);
    int i = paramArrayOfT.length;
    for (byte b = 0; b < i; b++)
      h1.a(paramArrayOfT[b], (String)null); 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append(']');
    stringBuilder1.append('\n');
    return this;
  }
  
  private void a(String paramString) {
    for (byte b = 0; b < this.b; b++)
      this.a.append('\t'); 
    if (paramString != null) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramString);
      stringBuilder.append(": ");
    } 
  }
  
  public final h a(byte paramByte, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramByte);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(int paramInt, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramInt);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(long paramLong, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramLong);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(k paramk, String paramString) {
    a(paramString);
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append('{');
    stringBuilder2.append('\n');
    if (paramk == null) {
      stringBuilder1 = this.a;
      stringBuilder1.append('\t');
      stringBuilder1.append("null");
    } else {
      stringBuilder1.a(this.a, this.b + 1);
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append('}');
    stringBuilder1.append('\n');
    return this;
  }
  
  public final h a(String paramString1, String paramString2) {
    a(paramString2);
    if (paramString1 == null) {
      this.a.append("null\n");
    } else {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramString1);
      stringBuilder.append('\n');
    } 
    return this;
  }
  
  public final <K, V> h a(Map<K, V> paramMap, String paramString) {
    a(paramString);
    if (paramMap == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramMap.isEmpty()) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramMap.size());
      stringBuilder.append(", {}\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramMap.size());
    stringBuilder2.append(", {\n");
    h h2 = new h(this.a, this.b + 1);
    h h1 = new h(this.a, this.b + 2);
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      h2.a(null);
      StringBuilder stringBuilder = h2.a;
      stringBuilder.append('(');
      stringBuilder.append('\n');
      h1.a(entry.getKey(), (String)null);
      h1.a(entry.getValue(), (String)null);
      h2.a(null);
      stringBuilder = h2.a;
      stringBuilder.append(')');
      stringBuilder.append('\n');
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append('}');
    stringBuilder1.append('\n');
    return this;
  }
  
  public final h a(short paramShort, String paramString) {
    a(paramString);
    StringBuilder stringBuilder = this.a;
    stringBuilder.append(paramShort);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(boolean paramBoolean, String paramString) {
    byte b;
    a(paramString);
    StringBuilder stringBuilder = this.a;
    if (paramBoolean) {
      byte b1 = 84;
      b = b1;
    } else {
      byte b1 = 70;
      b = b1;
    } 
    stringBuilder.append(b);
    stringBuilder.append('\n');
    return this;
  }
  
  public final h a(byte[] paramArrayOfbyte, String paramString) {
    a(paramString);
    if (paramArrayOfbyte == null) {
      this.a.append("null\n");
      return this;
    } 
    if (paramArrayOfbyte.length == 0) {
      StringBuilder stringBuilder = this.a;
      stringBuilder.append(paramArrayOfbyte.length);
      stringBuilder.append(", []\n");
      return this;
    } 
    StringBuilder stringBuilder2 = this.a;
    stringBuilder2.append(paramArrayOfbyte.length);
    stringBuilder2.append(", [\n");
    h h1 = new h(this.a, this.b + 1);
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      byte b1 = paramArrayOfbyte[b];
      h1.a(null);
      stringBuilder2 = h1.a;
      stringBuilder2.append(b1);
      stringBuilder2.append('\n');
    } 
    a(null);
    StringBuilder stringBuilder1 = this.a;
    stringBuilder1.append(']');
    stringBuilder1.append('\n');
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */