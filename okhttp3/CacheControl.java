package okhttp3;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
  public static final CacheControl FORCE_CACHE;
  
  public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
  
  String headerValue;
  
  private final boolean isPrivate;
  
  private final boolean isPublic;
  
  private final int maxAgeSeconds;
  
  private final int maxStaleSeconds;
  
  private final int minFreshSeconds;
  
  private final boolean mustRevalidate;
  
  private final boolean noCache;
  
  private final boolean noStore;
  
  private final boolean noTransform;
  
  private final boolean onlyIfCached;
  
  private final int sMaxAgeSeconds;
  
  static {
    FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  }
  
  private CacheControl(Builder paramBuilder) {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString) {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.headerValue = paramString;
  }
  
  private String headerValue() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.noCache)
      stringBuilder.append("no-cache, "); 
    if (this.noStore)
      stringBuilder.append("no-store, "); 
    if (this.maxAgeSeconds != -1)
      stringBuilder.append("max-age=").append(this.maxAgeSeconds).append(", "); 
    if (this.sMaxAgeSeconds != -1)
      stringBuilder.append("s-maxage=").append(this.sMaxAgeSeconds).append(", "); 
    if (this.isPrivate)
      stringBuilder.append("private, "); 
    if (this.isPublic)
      stringBuilder.append("public, "); 
    if (this.mustRevalidate)
      stringBuilder.append("must-revalidate, "); 
    if (this.maxStaleSeconds != -1)
      stringBuilder.append("max-stale=").append(this.maxStaleSeconds).append(", "); 
    if (this.minFreshSeconds != -1)
      stringBuilder.append("min-fresh=").append(this.minFreshSeconds).append(", "); 
    if (this.onlyIfCached)
      stringBuilder.append("only-if-cached, "); 
    if (this.noTransform)
      stringBuilder.append("no-transform, "); 
    if (stringBuilder.length() == 0)
      return ""; 
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: iconst_m1
    //   5: istore_3
    //   6: iconst_m1
    //   7: istore #4
    //   9: iconst_0
    //   10: istore #5
    //   12: iconst_0
    //   13: istore #6
    //   15: iconst_0
    //   16: istore #7
    //   18: iconst_m1
    //   19: istore #8
    //   21: iconst_m1
    //   22: istore #9
    //   24: iconst_0
    //   25: istore #10
    //   27: iconst_0
    //   28: istore #11
    //   30: iconst_1
    //   31: istore #12
    //   33: aconst_null
    //   34: astore #13
    //   36: iconst_0
    //   37: istore #14
    //   39: aload_0
    //   40: invokevirtual size : ()I
    //   43: istore #15
    //   45: iload #14
    //   47: iload #15
    //   49: if_icmpge -> 674
    //   52: aload_0
    //   53: iload #14
    //   55: invokevirtual name : (I)Ljava/lang/String;
    //   58: astore #16
    //   60: aload_0
    //   61: iload #14
    //   63: invokevirtual value : (I)Ljava/lang/String;
    //   66: astore #17
    //   68: aload #16
    //   70: ldc 'Cache-Control'
    //   72: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   75: ifeq -> 239
    //   78: aload #13
    //   80: ifnull -> 232
    //   83: iconst_0
    //   84: istore #12
    //   86: iconst_0
    //   87: istore #18
    //   89: iload_1
    //   90: istore #19
    //   92: iload_2
    //   93: istore #20
    //   95: iload_3
    //   96: istore #21
    //   98: iload #4
    //   100: istore #22
    //   102: iload #5
    //   104: istore #23
    //   106: iload #6
    //   108: istore #24
    //   110: iload #7
    //   112: istore #25
    //   114: iload #8
    //   116: istore #26
    //   118: iload #9
    //   120: istore #27
    //   122: iload #10
    //   124: istore #28
    //   126: iload #11
    //   128: istore #29
    //   130: aload #13
    //   132: astore #30
    //   134: iload #12
    //   136: istore #31
    //   138: iload #18
    //   140: aload #17
    //   142: invokevirtual length : ()I
    //   145: if_icmpge -> 619
    //   148: aload #17
    //   150: iload #18
    //   152: ldc '=,;'
    //   154: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   157: istore #26
    //   159: aload #17
    //   161: iload #18
    //   163: iload #26
    //   165: invokevirtual substring : (II)Ljava/lang/String;
    //   168: invokevirtual trim : ()Ljava/lang/String;
    //   171: astore #16
    //   173: iload #26
    //   175: aload #17
    //   177: invokevirtual length : ()I
    //   180: if_icmpeq -> 207
    //   183: aload #17
    //   185: iload #26
    //   187: invokevirtual charAt : (I)C
    //   190: bipush #44
    //   192: if_icmpeq -> 207
    //   195: aload #17
    //   197: iload #26
    //   199: invokevirtual charAt : (I)C
    //   202: bipush #59
    //   204: if_icmpne -> 304
    //   207: iinc #26, 1
    //   210: aconst_null
    //   211: astore #30
    //   213: ldc 'no-cache'
    //   215: aload #16
    //   217: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   220: ifeq -> 396
    //   223: iconst_1
    //   224: istore_1
    //   225: iload #26
    //   227: istore #18
    //   229: goto -> 89
    //   232: aload #17
    //   234: astore #13
    //   236: goto -> 86
    //   239: iload_1
    //   240: istore #19
    //   242: iload_2
    //   243: istore #20
    //   245: iload_3
    //   246: istore #21
    //   248: iload #4
    //   250: istore #22
    //   252: iload #5
    //   254: istore #23
    //   256: iload #6
    //   258: istore #24
    //   260: iload #7
    //   262: istore #25
    //   264: iload #8
    //   266: istore #26
    //   268: iload #9
    //   270: istore #27
    //   272: iload #10
    //   274: istore #28
    //   276: iload #11
    //   278: istore #29
    //   280: aload #13
    //   282: astore #30
    //   284: iload #12
    //   286: istore #31
    //   288: aload #16
    //   290: ldc 'Pragma'
    //   292: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   295: ifeq -> 619
    //   298: iconst_0
    //   299: istore #12
    //   301: goto -> 86
    //   304: aload #17
    //   306: iload #26
    //   308: iconst_1
    //   309: iadd
    //   310: invokestatic skipWhitespace : (Ljava/lang/String;I)I
    //   313: istore #18
    //   315: iload #18
    //   317: aload #17
    //   319: invokevirtual length : ()I
    //   322: if_icmpge -> 368
    //   325: aload #17
    //   327: iload #18
    //   329: invokevirtual charAt : (I)C
    //   332: bipush #34
    //   334: if_icmpne -> 368
    //   337: iinc #18, 1
    //   340: aload #17
    //   342: iload #18
    //   344: ldc '"'
    //   346: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   349: istore #26
    //   351: aload #17
    //   353: iload #18
    //   355: iload #26
    //   357: invokevirtual substring : (II)Ljava/lang/String;
    //   360: astore #30
    //   362: iinc #26, 1
    //   365: goto -> 213
    //   368: aload #17
    //   370: iload #18
    //   372: ldc ',;'
    //   374: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   377: istore #26
    //   379: aload #17
    //   381: iload #18
    //   383: iload #26
    //   385: invokevirtual substring : (II)Ljava/lang/String;
    //   388: invokevirtual trim : ()Ljava/lang/String;
    //   391: astore #30
    //   393: goto -> 213
    //   396: ldc 'no-store'
    //   398: aload #16
    //   400: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   403: ifeq -> 415
    //   406: iconst_1
    //   407: istore_2
    //   408: iload #26
    //   410: istore #18
    //   412: goto -> 89
    //   415: ldc 'max-age'
    //   417: aload #16
    //   419: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   422: ifeq -> 439
    //   425: aload #30
    //   427: iconst_m1
    //   428: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   431: istore_3
    //   432: iload #26
    //   434: istore #18
    //   436: goto -> 89
    //   439: ldc 's-maxage'
    //   441: aload #16
    //   443: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   446: ifeq -> 464
    //   449: aload #30
    //   451: iconst_m1
    //   452: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   455: istore #4
    //   457: iload #26
    //   459: istore #18
    //   461: goto -> 89
    //   464: ldc 'private'
    //   466: aload #16
    //   468: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   471: ifeq -> 484
    //   474: iconst_1
    //   475: istore #5
    //   477: iload #26
    //   479: istore #18
    //   481: goto -> 89
    //   484: ldc 'public'
    //   486: aload #16
    //   488: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   491: ifeq -> 504
    //   494: iconst_1
    //   495: istore #6
    //   497: iload #26
    //   499: istore #18
    //   501: goto -> 89
    //   504: ldc 'must-revalidate'
    //   506: aload #16
    //   508: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   511: ifeq -> 524
    //   514: iconst_1
    //   515: istore #7
    //   517: iload #26
    //   519: istore #18
    //   521: goto -> 89
    //   524: ldc 'max-stale'
    //   526: aload #16
    //   528: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   531: ifeq -> 550
    //   534: aload #30
    //   536: ldc 2147483647
    //   538: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   541: istore #8
    //   543: iload #26
    //   545: istore #18
    //   547: goto -> 89
    //   550: ldc 'min-fresh'
    //   552: aload #16
    //   554: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   557: ifeq -> 575
    //   560: aload #30
    //   562: iconst_m1
    //   563: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   566: istore #9
    //   568: iload #26
    //   570: istore #18
    //   572: goto -> 89
    //   575: ldc 'only-if-cached'
    //   577: aload #16
    //   579: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   582: ifeq -> 595
    //   585: iconst_1
    //   586: istore #10
    //   588: iload #26
    //   590: istore #18
    //   592: goto -> 89
    //   595: iload #26
    //   597: istore #18
    //   599: ldc 'no-transform'
    //   601: aload #16
    //   603: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   606: ifeq -> 89
    //   609: iconst_1
    //   610: istore #11
    //   612: iload #26
    //   614: istore #18
    //   616: goto -> 89
    //   619: iinc #14, 1
    //   622: iload #19
    //   624: istore_1
    //   625: iload #20
    //   627: istore_2
    //   628: iload #21
    //   630: istore_3
    //   631: iload #22
    //   633: istore #4
    //   635: iload #23
    //   637: istore #5
    //   639: iload #24
    //   641: istore #6
    //   643: iload #25
    //   645: istore #7
    //   647: iload #26
    //   649: istore #8
    //   651: iload #27
    //   653: istore #9
    //   655: iload #28
    //   657: istore #10
    //   659: iload #29
    //   661: istore #11
    //   663: aload #30
    //   665: astore #13
    //   667: iload #31
    //   669: istore #12
    //   671: goto -> 45
    //   674: iload #12
    //   676: ifne -> 682
    //   679: aconst_null
    //   680: astore #13
    //   682: new okhttp3/CacheControl
    //   685: dup
    //   686: iload_1
    //   687: iload_2
    //   688: iload_3
    //   689: iload #4
    //   691: iload #5
    //   693: iload #6
    //   695: iload #7
    //   697: iload #8
    //   699: iload #9
    //   701: iload #10
    //   703: iload #11
    //   705: aload #13
    //   707: invokespecial <init> : (ZZIIZZZIIZZLjava/lang/String;)V
    //   710: areturn
  }
  
  public boolean isPrivate() {
    return this.isPrivate;
  }
  
  public boolean isPublic() {
    return this.isPublic;
  }
  
  public int maxAgeSeconds() {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds() {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds() {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate() {
    return this.mustRevalidate;
  }
  
  public boolean noCache() {
    return this.noCache;
  }
  
  public boolean noStore() {
    return this.noStore;
  }
  
  public boolean noTransform() {
    return this.noTransform;
  }
  
  public boolean onlyIfCached() {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds() {
    return this.sMaxAgeSeconds;
  }
  
  public String toString() {
    String str = this.headerValue;
    if (str == null) {
      str = headerValue();
      this.headerValue = str;
    } 
    return str;
  }
  
  public static final class Builder {
    int maxAgeSeconds = -1;
    
    int maxStaleSeconds = -1;
    
    int minFreshSeconds = -1;
    
    boolean noCache;
    
    boolean noStore;
    
    boolean noTransform;
    
    boolean onlyIfCached;
    
    public CacheControl build() {
      return new CacheControl(this);
    }
    
    public Builder maxAge(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int < 0)
        throw new IllegalArgumentException("maxAge < 0: " + param1Int); 
      long l = param1TimeUnit.toSeconds(param1Int);
      if (l > 2147483647L) {
        param1Int = Integer.MAX_VALUE;
        this.maxAgeSeconds = param1Int;
        return this;
      } 
      param1Int = (int)l;
      this.maxAgeSeconds = param1Int;
      return this;
    }
    
    public Builder maxStale(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int < 0)
        throw new IllegalArgumentException("maxStale < 0: " + param1Int); 
      long l = param1TimeUnit.toSeconds(param1Int);
      if (l > 2147483647L) {
        param1Int = Integer.MAX_VALUE;
        this.maxStaleSeconds = param1Int;
        return this;
      } 
      param1Int = (int)l;
      this.maxStaleSeconds = param1Int;
      return this;
    }
    
    public Builder minFresh(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int < 0)
        throw new IllegalArgumentException("minFresh < 0: " + param1Int); 
      long l = param1TimeUnit.toSeconds(param1Int);
      if (l > 2147483647L) {
        param1Int = Integer.MAX_VALUE;
        this.minFreshSeconds = param1Int;
        return this;
      } 
      param1Int = (int)l;
      this.minFreshSeconds = param1Int;
      return this;
    }
    
    public Builder noCache() {
      this.noCache = true;
      return this;
    }
    
    public Builder noStore() {
      this.noStore = true;
      return this;
    }
    
    public Builder noTransform() {
      this.noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached() {
      this.onlyIfCached = true;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\CacheControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */