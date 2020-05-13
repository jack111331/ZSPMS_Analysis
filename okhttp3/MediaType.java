package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

public final class MediaType {
  private static final Pattern PARAMETER;
  
  private static final String QUOTED = "\"([^\"]*)\"";
  
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  
  private final String charset;
  
  private final String mediaType;
  
  private final String subtype;
  
  private final String type;
  
  static {
    PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  }
  
  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  public static MediaType parse(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic okhttp3/MediaType.TYPE_SUBTYPE : Ljava/util/regex/Pattern;
    //   5: aload_0
    //   6: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual lookingAt : ()Z
    //   14: ifne -> 21
    //   17: aload_1
    //   18: astore_2
    //   19: aload_2
    //   20: areturn
    //   21: aload_2
    //   22: iconst_1
    //   23: invokevirtual group : (I)Ljava/lang/String;
    //   26: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   29: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   32: astore_3
    //   33: aload_2
    //   34: iconst_2
    //   35: invokevirtual group : (I)Ljava/lang/String;
    //   38: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   41: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   44: astore #4
    //   46: aconst_null
    //   47: astore #5
    //   49: getstatic okhttp3/MediaType.PARAMETER : Ljava/util/regex/Pattern;
    //   52: aload_0
    //   53: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   56: astore #6
    //   58: aload_2
    //   59: invokevirtual end : ()I
    //   62: istore #7
    //   64: iload #7
    //   66: aload_0
    //   67: invokevirtual length : ()I
    //   70: if_icmpge -> 207
    //   73: aload #6
    //   75: iload #7
    //   77: aload_0
    //   78: invokevirtual length : ()I
    //   81: invokevirtual region : (II)Ljava/util/regex/Matcher;
    //   84: pop
    //   85: aload_1
    //   86: astore_2
    //   87: aload #6
    //   89: invokevirtual lookingAt : ()Z
    //   92: ifeq -> 19
    //   95: aload #6
    //   97: iconst_1
    //   98: invokevirtual group : (I)Ljava/lang/String;
    //   101: astore #8
    //   103: aload #5
    //   105: astore_2
    //   106: aload #8
    //   108: ifnull -> 124
    //   111: aload #8
    //   113: ldc 'charset'
    //   115: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   118: ifne -> 137
    //   121: aload #5
    //   123: astore_2
    //   124: aload #6
    //   126: invokevirtual end : ()I
    //   129: istore #7
    //   131: aload_2
    //   132: astore #5
    //   134: goto -> 64
    //   137: aload #6
    //   139: iconst_2
    //   140: invokevirtual group : (I)Ljava/lang/String;
    //   143: ifnull -> 194
    //   146: aload #6
    //   148: iconst_2
    //   149: invokevirtual group : (I)Ljava/lang/String;
    //   152: astore_2
    //   153: aload #5
    //   155: ifnull -> 204
    //   158: aload_2
    //   159: aload #5
    //   161: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   164: ifne -> 204
    //   167: new java/lang/IllegalArgumentException
    //   170: dup
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: ldc 'Multiple different charsets: '
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: invokespecial <init> : (Ljava/lang/String;)V
    //   193: athrow
    //   194: aload #6
    //   196: iconst_3
    //   197: invokevirtual group : (I)Ljava/lang/String;
    //   200: astore_2
    //   201: goto -> 153
    //   204: goto -> 124
    //   207: new okhttp3/MediaType
    //   210: dup
    //   211: aload_0
    //   212: aload_3
    //   213: aload #4
    //   215: aload #5
    //   217: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   220: astore_2
    //   221: goto -> 19
  }
  
  public Charset charset() {
    return (this.charset != null) ? Charset.forName(this.charset) : null;
  }
  
  public Charset charset(Charset paramCharset) {
    if (this.charset != null)
      paramCharset = Charset.forName(this.charset); 
    return paramCharset;
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof MediaType && ((MediaType)paramObject).mediaType.equals(this.mediaType));
  }
  
  public int hashCode() {
    return this.mediaType.hashCode();
  }
  
  public String subtype() {
    return this.subtype;
  }
  
  public String toString() {
    return this.mediaType;
  }
  
  public String type() {
    return this.type;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */