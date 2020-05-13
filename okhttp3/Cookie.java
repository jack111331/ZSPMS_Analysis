package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {
  private static final Pattern DAY_OF_MONTH_PATTERN;
  
  private static final Pattern MONTH_PATTERN;
  
  private static final Pattern TIME_PATTERN;
  
  private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
  
  private final String domain;
  
  private final long expiresAt;
  
  private final boolean hostOnly;
  
  private final boolean httpOnly;
  
  private final String name;
  
  private final String path;
  
  private final boolean persistent;
  
  private final boolean secure;
  
  private final String value;
  
  static {
    MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  }
  
  private Cookie(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.name = paramString1;
    this.value = paramString2;
    this.expiresAt = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.secure = paramBoolean1;
    this.httpOnly = paramBoolean2;
    this.hostOnly = paramBoolean3;
    this.persistent = paramBoolean4;
  }
  
  private Cookie(Builder paramBuilder) {
    if (paramBuilder.name == null)
      throw new NullPointerException("builder.name == null"); 
    if (paramBuilder.value == null)
      throw new NullPointerException("builder.value == null"); 
    if (paramBuilder.domain == null)
      throw new NullPointerException("builder.domain == null"); 
    this.name = paramBuilder.name;
    this.value = paramBuilder.value;
    this.expiresAt = paramBuilder.expiresAt;
    this.domain = paramBuilder.domain;
    this.path = paramBuilder.path;
    this.secure = paramBuilder.secure;
    this.httpOnly = paramBuilder.httpOnly;
    this.persistent = paramBuilder.persistent;
    this.hostOnly = paramBuilder.hostOnly;
  }
  
  private static int dateCharacterOffset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: if_icmpge -> 119
    //   5: aload_0
    //   6: iload_1
    //   7: invokevirtual charAt : (I)C
    //   10: istore #4
    //   12: iload #4
    //   14: bipush #32
    //   16: if_icmpge -> 26
    //   19: iload #4
    //   21: bipush #9
    //   23: if_icmpne -> 82
    //   26: iload #4
    //   28: bipush #127
    //   30: if_icmpge -> 82
    //   33: iload #4
    //   35: bipush #48
    //   37: if_icmplt -> 47
    //   40: iload #4
    //   42: bipush #57
    //   44: if_icmple -> 82
    //   47: iload #4
    //   49: bipush #97
    //   51: if_icmplt -> 61
    //   54: iload #4
    //   56: bipush #122
    //   58: if_icmple -> 82
    //   61: iload #4
    //   63: bipush #65
    //   65: if_icmplt -> 75
    //   68: iload #4
    //   70: bipush #90
    //   72: if_icmple -> 82
    //   75: iload #4
    //   77: bipush #58
    //   79: if_icmpne -> 101
    //   82: iconst_1
    //   83: istore #4
    //   85: iload_3
    //   86: ifne -> 107
    //   89: iconst_1
    //   90: istore #5
    //   92: iload #4
    //   94: iload #5
    //   96: if_icmpne -> 113
    //   99: iload_1
    //   100: ireturn
    //   101: iconst_0
    //   102: istore #4
    //   104: goto -> 85
    //   107: iconst_0
    //   108: istore #5
    //   110: goto -> 92
    //   113: iinc #1, 1
    //   116: goto -> 0
    //   119: iload_2
    //   120: istore_1
    //   121: goto -> 99
  }
  
  private static boolean domainMatch(HttpUrl paramHttpUrl, String paramString) {
    boolean bool = true;
    String str = paramHttpUrl.host();
    if (!str.equals(paramString) && (!str.endsWith(paramString) || str.charAt(str.length() - paramString.length() - 1) != '.' || Util.verifyAsIpAddress(str)))
      bool = false; 
    return bool;
  }
  
  static Cookie parse(long paramLong, HttpUrl paramHttpUrl, String paramString) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual length : ()I
    //   4: istore #4
    //   6: aload_3
    //   7: iconst_0
    //   8: iload #4
    //   10: bipush #59
    //   12: invokestatic delimiterOffset : (Ljava/lang/String;IIC)I
    //   15: istore #5
    //   17: aload_3
    //   18: iconst_0
    //   19: iload #5
    //   21: bipush #61
    //   23: invokestatic delimiterOffset : (Ljava/lang/String;IIC)I
    //   26: istore #6
    //   28: iload #6
    //   30: iload #5
    //   32: if_icmpne -> 39
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_2
    //   38: areturn
    //   39: aload_3
    //   40: iconst_0
    //   41: iload #6
    //   43: invokestatic trimSubstring : (Ljava/lang/String;II)Ljava/lang/String;
    //   46: astore #7
    //   48: aload #7
    //   50: invokevirtual isEmpty : ()Z
    //   53: ifeq -> 61
    //   56: aconst_null
    //   57: astore_2
    //   58: goto -> 37
    //   61: aload_3
    //   62: iload #6
    //   64: iconst_1
    //   65: iadd
    //   66: iload #5
    //   68: invokestatic trimSubstring : (Ljava/lang/String;II)Ljava/lang/String;
    //   71: astore #8
    //   73: ldc2_w 253402300799999
    //   76: lstore #9
    //   78: ldc2_w -1
    //   81: lstore #11
    //   83: aconst_null
    //   84: astore #13
    //   86: aconst_null
    //   87: astore #14
    //   89: iconst_0
    //   90: istore #15
    //   92: iconst_0
    //   93: istore #16
    //   95: iconst_1
    //   96: istore #17
    //   98: iconst_0
    //   99: istore #18
    //   101: iinc #5, 1
    //   104: iload #5
    //   106: iload #4
    //   108: if_icmpge -> 493
    //   111: aload_3
    //   112: iload #5
    //   114: iload #4
    //   116: bipush #59
    //   118: invokestatic delimiterOffset : (Ljava/lang/String;IIC)I
    //   121: istore #19
    //   123: aload_3
    //   124: iload #5
    //   126: iload #19
    //   128: bipush #61
    //   130: invokestatic delimiterOffset : (Ljava/lang/String;IIC)I
    //   133: istore #6
    //   135: aload_3
    //   136: iload #5
    //   138: iload #6
    //   140: invokestatic trimSubstring : (Ljava/lang/String;II)Ljava/lang/String;
    //   143: astore #20
    //   145: iload #6
    //   147: iload #19
    //   149: if_icmpge -> 247
    //   152: aload_3
    //   153: iload #6
    //   155: iconst_1
    //   156: iadd
    //   157: iload #19
    //   159: invokestatic trimSubstring : (Ljava/lang/String;II)Ljava/lang/String;
    //   162: astore #21
    //   164: aload #20
    //   166: ldc 'expires'
    //   168: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   171: ifeq -> 254
    //   174: aload #21
    //   176: iconst_0
    //   177: aload #21
    //   179: invokevirtual length : ()I
    //   182: invokestatic parseExpires : (Ljava/lang/String;II)J
    //   185: lstore #22
    //   187: iconst_1
    //   188: istore #24
    //   190: lload #11
    //   192: lstore #25
    //   194: iload #17
    //   196: istore #27
    //   198: iload #15
    //   200: istore #28
    //   202: aload #14
    //   204: astore #29
    //   206: aload #13
    //   208: astore #21
    //   210: iload #19
    //   212: iconst_1
    //   213: iadd
    //   214: istore #5
    //   216: lload #22
    //   218: lstore #9
    //   220: aload #21
    //   222: astore #13
    //   224: aload #29
    //   226: astore #14
    //   228: iload #28
    //   230: istore #15
    //   232: iload #27
    //   234: istore #17
    //   236: iload #24
    //   238: istore #18
    //   240: lload #25
    //   242: lstore #11
    //   244: goto -> 104
    //   247: ldc ''
    //   249: astore #21
    //   251: goto -> 164
    //   254: aload #20
    //   256: ldc 'max-age'
    //   258: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   261: ifeq -> 297
    //   264: aload #21
    //   266: invokestatic parseMaxAge : (Ljava/lang/String;)J
    //   269: lstore #25
    //   271: iconst_1
    //   272: istore #24
    //   274: lload #9
    //   276: lstore #22
    //   278: aload #13
    //   280: astore #21
    //   282: aload #14
    //   284: astore #29
    //   286: iload #15
    //   288: istore #28
    //   290: iload #17
    //   292: istore #27
    //   294: goto -> 210
    //   297: aload #20
    //   299: ldc 'domain'
    //   301: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   304: ifeq -> 340
    //   307: aload #21
    //   309: invokestatic parseDomain : (Ljava/lang/String;)Ljava/lang/String;
    //   312: astore #21
    //   314: iconst_0
    //   315: istore #27
    //   317: lload #9
    //   319: lstore #22
    //   321: aload #14
    //   323: astore #29
    //   325: iload #15
    //   327: istore #28
    //   329: iload #18
    //   331: istore #24
    //   333: lload #11
    //   335: lstore #25
    //   337: goto -> 210
    //   340: aload #20
    //   342: ldc 'path'
    //   344: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   347: ifeq -> 381
    //   350: aload #21
    //   352: astore #29
    //   354: lload #9
    //   356: lstore #22
    //   358: aload #13
    //   360: astore #21
    //   362: iload #15
    //   364: istore #28
    //   366: iload #17
    //   368: istore #27
    //   370: iload #18
    //   372: istore #24
    //   374: lload #11
    //   376: lstore #25
    //   378: goto -> 210
    //   381: aload #20
    //   383: ldc 'secure'
    //   385: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   388: ifeq -> 421
    //   391: iconst_1
    //   392: istore #28
    //   394: lload #9
    //   396: lstore #22
    //   398: aload #13
    //   400: astore #21
    //   402: aload #14
    //   404: astore #29
    //   406: iload #17
    //   408: istore #27
    //   410: iload #18
    //   412: istore #24
    //   414: lload #11
    //   416: lstore #25
    //   418: goto -> 210
    //   421: lload #9
    //   423: lstore #22
    //   425: aload #13
    //   427: astore #21
    //   429: aload #14
    //   431: astore #29
    //   433: iload #15
    //   435: istore #28
    //   437: iload #17
    //   439: istore #27
    //   441: iload #18
    //   443: istore #24
    //   445: lload #11
    //   447: lstore #25
    //   449: aload #20
    //   451: ldc 'httponly'
    //   453: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   456: ifeq -> 210
    //   459: iconst_1
    //   460: istore #16
    //   462: lload #9
    //   464: lstore #22
    //   466: aload #13
    //   468: astore #21
    //   470: aload #14
    //   472: astore #29
    //   474: iload #15
    //   476: istore #28
    //   478: iload #17
    //   480: istore #27
    //   482: iload #18
    //   484: istore #24
    //   486: lload #11
    //   488: lstore #25
    //   490: goto -> 210
    //   493: lload #11
    //   495: ldc2_w -9223372036854775808
    //   498: lcmp
    //   499: ifne -> 590
    //   502: ldc2_w -9223372036854775808
    //   505: lstore #9
    //   507: aload #13
    //   509: ifnonnull -> 658
    //   512: aload_2
    //   513: invokevirtual host : ()Ljava/lang/String;
    //   516: astore #21
    //   518: aload #14
    //   520: ifnull -> 536
    //   523: aload #14
    //   525: astore_3
    //   526: aload #14
    //   528: ldc '/'
    //   530: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   533: ifne -> 562
    //   536: aload_2
    //   537: invokevirtual encodedPath : ()Ljava/lang/String;
    //   540: astore_2
    //   541: aload_2
    //   542: bipush #47
    //   544: invokevirtual lastIndexOf : (I)I
    //   547: istore #5
    //   549: iload #5
    //   551: ifeq -> 676
    //   554: aload_2
    //   555: iconst_0
    //   556: iload #5
    //   558: invokevirtual substring : (II)Ljava/lang/String;
    //   561: astore_3
    //   562: new okhttp3/Cookie
    //   565: dup
    //   566: aload #7
    //   568: aload #8
    //   570: lload #9
    //   572: aload #21
    //   574: aload_3
    //   575: iload #15
    //   577: iload #16
    //   579: iload #17
    //   581: iload #18
    //   583: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V
    //   586: astore_2
    //   587: goto -> 37
    //   590: lload #11
    //   592: ldc2_w -1
    //   595: lcmp
    //   596: ifeq -> 507
    //   599: lload #11
    //   601: ldc2_w 9223372036854775
    //   604: lcmp
    //   605: ifgt -> 650
    //   608: lload #11
    //   610: ldc2_w 1000
    //   613: lmul
    //   614: lstore #9
    //   616: lload_0
    //   617: lload #9
    //   619: ladd
    //   620: lstore #11
    //   622: lload #11
    //   624: lload_0
    //   625: lcmp
    //   626: iflt -> 642
    //   629: lload #11
    //   631: lstore #9
    //   633: lload #11
    //   635: ldc2_w 253402300799999
    //   638: lcmp
    //   639: ifle -> 507
    //   642: ldc2_w 253402300799999
    //   645: lstore #9
    //   647: goto -> 507
    //   650: ldc2_w 9223372036854775807
    //   653: lstore #9
    //   655: goto -> 616
    //   658: aload #13
    //   660: astore #21
    //   662: aload_2
    //   663: aload #13
    //   665: invokestatic domainMatch : (Lokhttp3/HttpUrl;Ljava/lang/String;)Z
    //   668: ifne -> 518
    //   671: aconst_null
    //   672: astore_2
    //   673: goto -> 37
    //   676: ldc '/'
    //   678: astore_3
    //   679: goto -> 562
    //   682: astore #21
    //   684: lload #9
    //   686: lstore #22
    //   688: aload #13
    //   690: astore #21
    //   692: aload #14
    //   694: astore #29
    //   696: iload #15
    //   698: istore #28
    //   700: iload #17
    //   702: istore #27
    //   704: iload #18
    //   706: istore #24
    //   708: lload #11
    //   710: lstore #25
    //   712: goto -> 210
    //   715: astore #21
    //   717: lload #9
    //   719: lstore #22
    //   721: aload #13
    //   723: astore #21
    //   725: aload #14
    //   727: astore #29
    //   729: iload #15
    //   731: istore #28
    //   733: iload #17
    //   735: istore #27
    //   737: iload #18
    //   739: istore #24
    //   741: lload #11
    //   743: lstore #25
    //   745: goto -> 210
    //   748: astore #21
    //   750: lload #9
    //   752: lstore #22
    //   754: aload #13
    //   756: astore #21
    //   758: aload #14
    //   760: astore #29
    //   762: iload #15
    //   764: istore #28
    //   766: iload #17
    //   768: istore #27
    //   770: iload #18
    //   772: istore #24
    //   774: lload #11
    //   776: lstore #25
    //   778: goto -> 210
    // Exception table:
    //   from	to	target	type
    //   174	187	748	java/lang/IllegalArgumentException
    //   264	271	682	java/lang/NumberFormatException
    //   307	314	715	java/lang/IllegalArgumentException
  }
  
  public static Cookie parse(HttpUrl paramHttpUrl, String paramString) {
    return parse(System.currentTimeMillis(), paramHttpUrl, paramString);
  }
  
  public static List<Cookie> parseAll(HttpUrl paramHttpUrl, Headers paramHeaders) {
    ArrayList<Cookie> arrayList;
    List<String> list = paramHeaders.values("Set-Cookie");
    paramHeaders = null;
    byte b = 0;
    int i = list.size();
    while (b < i) {
      Cookie cookie = parse(paramHttpUrl, list.get(b));
      if (cookie != null) {
        ArrayList<Cookie> arrayList1;
        Headers headers = paramHeaders;
        if (paramHeaders == null)
          arrayList1 = new ArrayList(); 
        arrayList1.add(cookie);
        arrayList = arrayList1;
      } 
      b++;
    } 
    return (List)((arrayList != null) ? Collections.unmodifiableList(arrayList) : Collections.emptyList());
  }
  
  private static String parseDomain(String paramString) {
    if (paramString.endsWith("."))
      throw new IllegalArgumentException(); 
    String str = paramString;
    if (paramString.startsWith("."))
      str = paramString.substring(1); 
    paramString = Util.domainToAscii(str);
    if (paramString == null)
      throw new IllegalArgumentException(); 
    return paramString;
  }
  
  private static long parseExpires(String paramString, int paramInt1, int paramInt2) {
    int i = dateCharacterOffset(paramString, paramInt1, paramInt2, false);
    byte b1 = -1;
    byte b2 = -1;
    byte b3 = -1;
    byte b4 = -1;
    byte b5 = -1;
    paramInt1 = -1;
    Matcher matcher = TIME_PATTERN.matcher(paramString);
    while (i < paramInt2) {
      byte b6;
      byte b7;
      byte b8;
      byte b9;
      byte b10;
      int j = dateCharacterOffset(paramString, i + 1, paramInt2, true);
      matcher.region(i, j);
      if (b1 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
        b6 = Integer.parseInt(matcher.group(1));
        b7 = Integer.parseInt(matcher.group(2));
        b8 = Integer.parseInt(matcher.group(3));
        i = paramInt1;
        b9 = b5;
        b10 = b4;
      } else if (b4 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
        b10 = Integer.parseInt(matcher.group(1));
        b6 = b1;
        b7 = b2;
        b9 = b5;
        b8 = b3;
        i = paramInt1;
      } else if (b5 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
        String str = matcher.group(1).toLowerCase(Locale.US);
        b9 = MONTH_PATTERN.pattern().indexOf(str) / 4;
        b10 = b4;
        b6 = b1;
        b7 = b2;
        b8 = b3;
        i = paramInt1;
      } else {
        b10 = b4;
        b6 = b1;
        b7 = b2;
        b9 = b5;
        b8 = b3;
        i = paramInt1;
        if (paramInt1 == -1) {
          b10 = b4;
          b6 = b1;
          b7 = b2;
          b9 = b5;
          b8 = b3;
          i = paramInt1;
          if (matcher.usePattern(YEAR_PATTERN).matches()) {
            i = Integer.parseInt(matcher.group(1));
            b10 = b4;
            b6 = b1;
            b7 = b2;
            b9 = b5;
            b8 = b3;
          } 
        } 
      } 
      j = dateCharacterOffset(paramString, j + 1, paramInt2, false);
      b4 = b10;
      b1 = b6;
      b2 = b7;
      b5 = b9;
      b3 = b8;
      paramInt1 = i;
      i = j;
    } 
    paramInt2 = paramInt1;
    if (paramInt1 >= 70) {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99)
        paramInt2 = paramInt1 + 1900; 
    } 
    paramInt1 = paramInt2;
    if (paramInt2 >= 0) {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69)
        paramInt1 = paramInt2 + 2000; 
    } 
    if (paramInt1 < 1601)
      throw new IllegalArgumentException(); 
    if (b5 == -1)
      throw new IllegalArgumentException(); 
    if (b4 < 1 || b4 > 31)
      throw new IllegalArgumentException(); 
    if (b1 < 0 || b1 > 23)
      throw new IllegalArgumentException(); 
    if (b2 < 0 || b2 > 59)
      throw new IllegalArgumentException(); 
    if (b3 < 0 || b3 > 59)
      throw new IllegalArgumentException(); 
    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
    gregorianCalendar.setLenient(false);
    gregorianCalendar.set(1, paramInt1);
    gregorianCalendar.set(2, b5 - 1);
    gregorianCalendar.set(5, b4);
    gregorianCalendar.set(11, b1);
    gregorianCalendar.set(12, b2);
    gregorianCalendar.set(13, b3);
    gregorianCalendar.set(14, 0);
    return gregorianCalendar.getTimeInMillis();
  }
  
  private static long parseMaxAge(String paramString) {
    long l = Long.MIN_VALUE;
    try {
      long l1 = Long.parseLong(paramString);
      l = l1;
      if (l1 <= 0L)
        l = Long.MIN_VALUE; 
      return l;
    } catch (NumberFormatException numberFormatException) {
      if (paramString.matches("-?\\d+")) {
        if (!paramString.startsWith("-"))
          l = Long.MAX_VALUE; 
        return l;
      } 
      throw numberFormatException;
    } 
  }
  
  private static boolean pathMatch(HttpUrl paramHttpUrl, String paramString) {
    boolean bool = true;
    String str = paramHttpUrl.encodedPath();
    if (str.equals(paramString))
      return bool; 
    if (str.startsWith(paramString)) {
      boolean bool1 = bool;
      if (!paramString.endsWith("/")) {
        bool1 = bool;
        if (str.charAt(paramString.length()) != '/')
          return false; 
      } 
      return bool1;
    } 
    return false;
  }
  
  public String domain() {
    return this.domain;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    if (!(paramObject instanceof Cookie))
      return bool1; 
    paramObject = paramObject;
    boolean bool2 = bool1;
    if (((Cookie)paramObject).name.equals(this.name)) {
      bool2 = bool1;
      if (((Cookie)paramObject).value.equals(this.value)) {
        bool2 = bool1;
        if (((Cookie)paramObject).domain.equals(this.domain)) {
          bool2 = bool1;
          if (((Cookie)paramObject).path.equals(this.path)) {
            bool2 = bool1;
            if (((Cookie)paramObject).expiresAt == this.expiresAt) {
              bool2 = bool1;
              if (((Cookie)paramObject).secure == this.secure) {
                bool2 = bool1;
                if (((Cookie)paramObject).httpOnly == this.httpOnly) {
                  bool2 = bool1;
                  if (((Cookie)paramObject).persistent == this.persistent) {
                    bool2 = bool1;
                    if (((Cookie)paramObject).hostOnly == this.hostOnly)
                      bool2 = true; 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public long expiresAt() {
    return this.expiresAt;
  }
  
  public int hashCode() {
    byte b2;
    byte b3;
    byte b4;
    byte b1 = 0;
    int i = this.name.hashCode();
    int j = this.value.hashCode();
    int k = this.domain.hashCode();
    int m = this.path.hashCode();
    int n = (int)(this.expiresAt ^ this.expiresAt >>> 32L);
    if (this.secure) {
      b2 = 0;
    } else {
      b2 = 1;
    } 
    if (this.httpOnly) {
      b3 = 0;
    } else {
      b3 = 1;
    } 
    if (this.persistent) {
      b4 = 0;
    } else {
      b4 = 1;
    } 
    if (!this.hostOnly)
      b1 = 1; 
    return ((((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + b2) * 31 + b3) * 31 + b4) * 31 + b1;
  }
  
  public boolean hostOnly() {
    return this.hostOnly;
  }
  
  public boolean httpOnly() {
    return this.httpOnly;
  }
  
  public boolean matches(HttpUrl paramHttpUrl) {
    boolean bool = false;
    if (this.hostOnly) {
      null = paramHttpUrl.host().equals(this.domain);
    } else {
      null = domainMatch(paramHttpUrl, this.domain);
    } 
    if (!null)
      return bool; 
    null = bool;
    if (pathMatch(paramHttpUrl, this.path)) {
      if (this.secure) {
        null = bool;
        return paramHttpUrl.isHttps() ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public String name() {
    return this.name;
  }
  
  public String path() {
    return this.path;
  }
  
  public boolean persistent() {
    return this.persistent;
  }
  
  public boolean secure() {
    return this.secure;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.name);
    stringBuilder.append('=');
    stringBuilder.append(this.value);
    if (this.persistent)
      if (this.expiresAt == Long.MIN_VALUE) {
        stringBuilder.append("; max-age=0");
      } else {
        stringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
      }  
    if (!this.hostOnly)
      stringBuilder.append("; domain=").append(this.domain); 
    stringBuilder.append("; path=").append(this.path);
    if (this.secure)
      stringBuilder.append("; secure"); 
    if (this.httpOnly)
      stringBuilder.append("; httponly"); 
    return stringBuilder.toString();
  }
  
  public String value() {
    return this.value;
  }
  
  public static final class Builder {
    String domain;
    
    long expiresAt = 253402300799999L;
    
    boolean hostOnly;
    
    boolean httpOnly;
    
    String name;
    
    String path = "/";
    
    boolean persistent;
    
    boolean secure;
    
    String value;
    
    private Builder domain(String param1String, boolean param1Boolean) {
      if (param1String == null)
        throw new NullPointerException("domain == null"); 
      String str = Util.domainToAscii(param1String);
      if (str == null)
        throw new IllegalArgumentException("unexpected domain: " + param1String); 
      this.domain = str;
      this.hostOnly = param1Boolean;
      return this;
    }
    
    public Cookie build() {
      return new Cookie(this);
    }
    
    public Builder domain(String param1String) {
      return domain(param1String, false);
    }
    
    public Builder expiresAt(long param1Long) {
      long l = param1Long;
      if (param1Long <= 0L)
        l = Long.MIN_VALUE; 
      param1Long = l;
      if (l > 253402300799999L)
        param1Long = 253402300799999L; 
      this.expiresAt = param1Long;
      this.persistent = true;
      return this;
    }
    
    public Builder hostOnlyDomain(String param1String) {
      return domain(param1String, true);
    }
    
    public Builder httpOnly() {
      this.httpOnly = true;
      return this;
    }
    
    public Builder name(String param1String) {
      if (param1String == null)
        throw new NullPointerException("name == null"); 
      if (!param1String.trim().equals(param1String))
        throw new IllegalArgumentException("name is not trimmed"); 
      this.name = param1String;
      return this;
    }
    
    public Builder path(String param1String) {
      if (!param1String.startsWith("/"))
        throw new IllegalArgumentException("path must start with '/'"); 
      this.path = param1String;
      return this;
    }
    
    public Builder secure() {
      this.secure = true;
      return this;
    }
    
    public Builder value(String param1String) {
      if (param1String == null)
        throw new NullPointerException("value == null"); 
      if (!param1String.trim().equals(param1String))
        throw new IllegalArgumentException("value is not trimmed"); 
      this.value = param1String;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */