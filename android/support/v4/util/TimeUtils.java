package android.support.v4.util;

import android.support.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TimeUtils {
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  
  private static final int SECONDS_PER_DAY = 86400;
  
  private static final int SECONDS_PER_HOUR = 3600;
  
  private static final int SECONDS_PER_MINUTE = 60;
  
  private static char[] sFormatStr;
  
  private static final Object sFormatSync = new Object();
  
  static {
    sFormatStr = new char[24];
  }
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    return (paramInt1 > 99 || (paramBoolean && paramInt3 >= 3)) ? (paramInt2 + 3) : ((paramInt1 > 9 || (paramBoolean && paramInt3 >= 2)) ? (paramInt2 + 2) : ((paramBoolean || paramInt1 > 0) ? (paramInt2 + 1) : 0));
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter) {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
      return;
    } 
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter) {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt) {
    synchronized (sFormatSync) {
      paramInt = formatDurationLocked(paramLong, paramInt);
      String str = new String();
      this(sFormatStr, 0, paramInt);
      paramPrintWriter.print(str);
      return;
    } 
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder) {
    synchronized (sFormatSync) {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    } 
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    byte b;
    if (sFormatStr.length < paramInt)
      sFormatStr = new char[paramInt]; 
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L) {
      while (paramInt - 1 < 0)
        arrayOfChar[0] = (char)' '; 
      arrayOfChar[0] = (char)'0';
      return 1;
    } 
    if (paramLong > 0L) {
      i = 43;
    } else {
      paramLong = -paramLong;
      i = 45;
    } 
    int j = (int)(paramLong % 1000L);
    int k = (int)Math.floor((paramLong / 1000L));
    int m = 0;
    int n = k;
    if (k > 86400) {
      m = k / 86400;
      n = k - 86400 * m;
    } 
    if (n > 3600) {
      bool1 = n / 3600;
      n -= bool1 * 3600;
    } else {
      bool1 = false;
    } 
    if (n > 60) {
      k = n / 60;
      bool2 = k;
      k = n - k * 60;
    } else {
      bool2 = false;
      k = n;
    } 
    if (paramInt != 0) {
      n = accumField(m, 1, false, 0);
      if (n > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      n += accumField(bool1, 1, bool3, 2);
      if (n > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      n += accumField(bool2, 1, bool3, 2);
      if (n > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      int i1 = n + accumField(k, 1, bool3, 2);
      if (i1 > 0) {
        n = 3;
      } else {
        n = 0;
      } 
      b = accumField(j, 2, true, n);
      n = 0;
      i1 = b + 1 + i1;
      while (true) {
        b = n;
        if (i1 < paramInt) {
          arrayOfChar[n] = (char)' ';
          i1++;
          n++;
          continue;
        } 
        break;
      } 
    } else {
      b = 0;
    } 
    arrayOfChar[b] = (char)i;
    int i = b + 1;
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    m = printField(arrayOfChar, m, 'd', i, false, 0);
    if (m != i) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      n = 2;
    } else {
      n = 0;
    } 
    m = printField(arrayOfChar, bool1, 'h', m, bool3, n);
    if (m != i) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      n = 2;
    } else {
      n = 0;
    } 
    m = printField(arrayOfChar, bool2, 'm', m, bool3, n);
    if (m != i) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      n = 2;
    } else {
      n = 0;
    } 
    n = printField(arrayOfChar, k, 's', m, bool3, n);
    if (paramInt != 0 && n != i) {
      paramInt = 3;
    } else {
      paramInt = 0;
    } 
    paramInt = printField(arrayOfChar, j, 'm', n, true, paramInt);
    arrayOfChar[paramInt] = (char)'s';
    return ++paramInt;
  }
  
  private static int printField(char[] paramArrayOfchar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3) {
    // Byte code:
    //   0: iload #4
    //   2: ifne -> 12
    //   5: iload_3
    //   6: istore #6
    //   8: iload_1
    //   9: ifle -> 143
    //   12: iload #4
    //   14: ifeq -> 23
    //   17: iload #5
    //   19: iconst_3
    //   20: if_icmpge -> 29
    //   23: iload_1
    //   24: bipush #99
    //   26: if_icmple -> 146
    //   29: iload_1
    //   30: bipush #100
    //   32: idiv
    //   33: istore #7
    //   35: aload_0
    //   36: iload_3
    //   37: iload #7
    //   39: bipush #48
    //   41: iadd
    //   42: i2c
    //   43: i2c
    //   44: castore
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: istore #6
    //   50: iload_1
    //   51: iload #7
    //   53: bipush #100
    //   55: imul
    //   56: isub
    //   57: istore_1
    //   58: iload #4
    //   60: ifeq -> 69
    //   63: iload #5
    //   65: iconst_2
    //   66: if_icmpge -> 88
    //   69: iload_1
    //   70: bipush #9
    //   72: if_icmpgt -> 88
    //   75: iload_1
    //   76: istore #7
    //   78: iload #6
    //   80: istore #5
    //   82: iload_3
    //   83: iload #6
    //   85: if_icmpeq -> 117
    //   88: iload_1
    //   89: bipush #10
    //   91: idiv
    //   92: istore_3
    //   93: aload_0
    //   94: iload #6
    //   96: iload_3
    //   97: bipush #48
    //   99: iadd
    //   100: i2c
    //   101: i2c
    //   102: castore
    //   103: iload #6
    //   105: iconst_1
    //   106: iadd
    //   107: istore #5
    //   109: iload_1
    //   110: iload_3
    //   111: bipush #10
    //   113: imul
    //   114: isub
    //   115: istore #7
    //   117: aload_0
    //   118: iload #5
    //   120: iload #7
    //   122: bipush #48
    //   124: iadd
    //   125: i2c
    //   126: i2c
    //   127: castore
    //   128: iload #5
    //   130: iconst_1
    //   131: iadd
    //   132: istore_1
    //   133: aload_0
    //   134: iload_1
    //   135: iload_2
    //   136: i2c
    //   137: castore
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore #6
    //   143: iload #6
    //   145: ireturn
    //   146: iload_3
    //   147: istore #6
    //   149: goto -> 58
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v\\util\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */