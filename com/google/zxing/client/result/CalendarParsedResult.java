package com.google.zxing.client.result;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CalendarParsedResult extends ParsedResult {
  private static final Pattern DATE_TIME;
  
  private static final Pattern RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
  
  private static final long[] RFC2445_DURATION_FIELD_UNITS = new long[] { 604800000L, 86400000L, 3600000L, 60000L, 1000L };
  
  private final String[] attendees;
  
  private final String description;
  
  private final long end;
  
  private final boolean endAllDay;
  
  private final double latitude;
  
  private final String location;
  
  private final double longitude;
  
  private final String organizer;
  
  private final long start;
  
  private final boolean startAllDay;
  
  private final String summary;
  
  static {
    DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
  }
  
  public CalendarParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, String paramString7, double paramDouble1, double paramDouble2) {
    // Byte code:
    //   0: aload_0
    //   1: getstatic com/google/zxing/client/result/ParsedResultType.CALENDAR : Lcom/google/zxing/client/result/ParsedResultType;
    //   4: invokespecial <init> : (Lcom/google/zxing/client/result/ParsedResultType;)V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield summary : Ljava/lang/String;
    //   12: aload_0
    //   13: aload_2
    //   14: invokestatic parseDate : (Ljava/lang/String;)J
    //   17: putfield start : J
    //   20: aload_3
    //   21: ifnonnull -> 64
    //   24: aload #4
    //   26: invokestatic parseDurationMS : (Ljava/lang/CharSequence;)J
    //   29: lstore #13
    //   31: lload #13
    //   33: lconst_0
    //   34: lcmp
    //   35: ifge -> 46
    //   38: ldc2_w -1
    //   41: lstore #13
    //   43: goto -> 55
    //   46: lload #13
    //   48: aload_0
    //   49: getfield start : J
    //   52: ladd
    //   53: lstore #13
    //   55: aload_0
    //   56: lload #13
    //   58: putfield end : J
    //   61: goto -> 72
    //   64: aload_0
    //   65: aload_3
    //   66: invokestatic parseDate : (Ljava/lang/String;)J
    //   69: putfield end : J
    //   72: aload_2
    //   73: invokevirtual length : ()I
    //   76: istore #15
    //   78: iconst_0
    //   79: istore #16
    //   81: iload #15
    //   83: bipush #8
    //   85: if_icmpne -> 94
    //   88: iconst_1
    //   89: istore #17
    //   91: goto -> 97
    //   94: iconst_0
    //   95: istore #17
    //   97: aload_0
    //   98: iload #17
    //   100: putfield startAllDay : Z
    //   103: iload #16
    //   105: istore #17
    //   107: aload_3
    //   108: ifnull -> 127
    //   111: iload #16
    //   113: istore #17
    //   115: aload_3
    //   116: invokevirtual length : ()I
    //   119: bipush #8
    //   121: if_icmpne -> 127
    //   124: iconst_1
    //   125: istore #17
    //   127: aload_0
    //   128: iload #17
    //   130: putfield endAllDay : Z
    //   133: aload_0
    //   134: aload #5
    //   136: putfield location : Ljava/lang/String;
    //   139: aload_0
    //   140: aload #6
    //   142: putfield organizer : Ljava/lang/String;
    //   145: aload_0
    //   146: aload #7
    //   148: putfield attendees : [Ljava/lang/String;
    //   151: aload_0
    //   152: aload #8
    //   154: putfield description : Ljava/lang/String;
    //   157: aload_0
    //   158: dload #9
    //   160: putfield latitude : D
    //   163: aload_0
    //   164: dload #11
    //   166: putfield longitude : D
    //   169: return
    //   170: astore_1
    //   171: new java/lang/IllegalArgumentException
    //   174: dup
    //   175: aload_1
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_1
    //   184: new java/lang/IllegalArgumentException
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: invokespecial <init> : (Ljava/lang/String;)V
    //   195: athrow
    // Exception table:
    //   from	to	target	type
    //   12	20	183	java/text/ParseException
    //   64	72	170	java/text/ParseException
  }
  
  private static String format(boolean paramBoolean, long paramLong) {
    DateFormat dateFormat;
    if (paramLong < 0L)
      return null; 
    if (paramBoolean) {
      dateFormat = DateFormat.getDateInstance(2);
    } else {
      dateFormat = DateFormat.getDateTimeInstance(2, 2);
    } 
    return dateFormat.format(Long.valueOf(paramLong));
  }
  
  private static long parseDate(String paramString) throws ParseException {
    GregorianCalendar gregorianCalendar;
    if (DATE_TIME.matcher(paramString).matches()) {
      if (paramString.length() == 8) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.parse(paramString).getTime();
      } 
      if (paramString.length() == 16 && paramString.charAt(15) == 'Z') {
        long l = parseDateTimeString(paramString.substring(0, 15));
        gregorianCalendar = new GregorianCalendar();
        l += gregorianCalendar.get(15);
        gregorianCalendar.setTime(new Date(l));
        return l + gregorianCalendar.get(16);
      } 
      return parseDateTimeString((String)gregorianCalendar);
    } 
    throw new ParseException(gregorianCalendar, 0);
  }
  
  private static long parseDateTimeString(String paramString) throws ParseException {
    return (new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH)).parse(paramString).getTime();
  }
  
  private static long parseDurationMS(CharSequence paramCharSequence) {
    if (paramCharSequence == null)
      return -1L; 
    Matcher matcher = RFC2445_DURATION.matcher(paramCharSequence);
    if (!matcher.matches())
      return -1L; 
    long l = 0L;
    int i = 0;
    while (i < RFC2445_DURATION_FIELD_UNITS.length) {
      int j = i + 1;
      String str = matcher.group(j);
      long l1 = l;
      if (str != null)
        l1 = l + RFC2445_DURATION_FIELD_UNITS[i] * Integer.parseInt(str); 
      i = j;
      l = l1;
    } 
    return l;
  }
  
  public String[] getAttendees() {
    return this.attendees;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayResult() {
    StringBuilder stringBuilder = new StringBuilder(100);
    maybeAppend(this.summary, stringBuilder);
    maybeAppend(format(this.startAllDay, this.start), stringBuilder);
    maybeAppend(format(this.endAllDay, this.end), stringBuilder);
    maybeAppend(this.location, stringBuilder);
    maybeAppend(this.organizer, stringBuilder);
    maybeAppend(this.attendees, stringBuilder);
    maybeAppend(this.description, stringBuilder);
    return stringBuilder.toString();
  }
  
  @Deprecated
  public Date getEnd() {
    return (this.end < 0L) ? null : new Date(this.end);
  }
  
  public long getEndTimestamp() {
    return this.end;
  }
  
  public double getLatitude() {
    return this.latitude;
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public double getLongitude() {
    return this.longitude;
  }
  
  public String getOrganizer() {
    return this.organizer;
  }
  
  @Deprecated
  public Date getStart() {
    return new Date(this.start);
  }
  
  public long getStartTimestamp() {
    return this.start;
  }
  
  public String getSummary() {
    return this.summary;
  }
  
  public boolean isEndAllDay() {
    return this.endAllDay;
  }
  
  public boolean isStartAllDay() {
    return this.startAllDay;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\CalendarParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */