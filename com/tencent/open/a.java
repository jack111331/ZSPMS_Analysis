package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class a {
  protected HashMap<String, b> a = new HashMap<String, b>();
  
  public void a(b paramb, String paramString) {
    this.a.put(paramString, paramb);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, a parama) {
    f.a("openSDK_LOG.JsBridge", "getResult---objName = " + paramString1 + " methodName = " + paramString2);
    int i = paramList.size();
    for (byte b1 = 0; b1 < i; b1++) {
      try {
        paramList.set(b1, URLDecoder.decode(paramList.get(b1), "UTF-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } 
    } 
    b b = this.a.get(paramString1);
    if (b != null) {
      f.b("openSDK_LOG.JsBridge", "call----");
      b.call(paramString2, paramList, parama);
      return;
    } 
    f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
    if (parama != null)
      parama.a(); 
  }
  
  public boolean a(WebView paramWebView, String paramString) {
    boolean bool1 = false;
    f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + paramString);
    if (paramString == null)
      return bool1; 
    boolean bool2 = bool1;
    if (Uri.parse(paramString).getScheme().equals("jsbridge")) {
      ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])(paramString + "/#").split("/")));
      bool2 = bool1;
      if (arrayList.size() >= 6) {
        String str1 = arrayList.get(2);
        String str2 = arrayList.get(3);
        List<String> list = arrayList.subList(4, arrayList.size() - 1);
        a a1 = new a(paramWebView, 4L, paramString);
        paramWebView.getUrl();
        a(str1, str2, list, a1);
        bool2 = true;
      } 
    } 
    return bool2;
  }
  
  public static class a {
    protected WeakReference<WebView> a;
    
    protected long b;
    
    protected String c;
    
    public a(WebView param1WebView, long param1Long, String param1String) {
      this.a = new WeakReference<WebView>(param1WebView);
      this.b = param1Long;
      this.c = param1String;
    }
    
    public void a() {
      WebView webView = this.a.get();
      if (webView != null)
        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})"); 
    }
    
    public void a(Object param1Object) {
      WebView webView = this.a.get();
      if (webView != null) {
        String str = "'undefined'";
        if (param1Object instanceof String) {
          param1Object = ((String)param1Object).replace("\\", "\\\\").replace("'", "\\'");
          str = "'" + param1Object + "'";
        } else if (param1Object instanceof Number || param1Object instanceof Long || param1Object instanceof Integer || param1Object instanceof Double || param1Object instanceof Float) {
          str = param1Object.toString();
        } else if (param1Object instanceof Boolean) {
          str = param1Object.toString();
        } 
        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
      } 
    }
    
    public void a(String param1String) {
      WebView webView = this.a.get();
      if (webView != null)
        webView.loadUrl("javascript:" + param1String); 
    }
  }
  
  public static class b {
    public void call(String param1String, List<String> param1List, a.a param1a) {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual getClass : ()Ljava/lang/Class;
      //   4: invokevirtual getDeclaredMethods : ()[Ljava/lang/reflect/Method;
      //   7: astore #4
      //   9: aconst_null
      //   10: astore #5
      //   12: aload #4
      //   14: arraylength
      //   15: istore #6
      //   17: iconst_0
      //   18: istore #7
      //   20: aload #5
      //   22: astore #8
      //   24: iload #7
      //   26: iload #6
      //   28: if_icmpge -> 65
      //   31: aload #4
      //   33: iload #7
      //   35: aaload
      //   36: astore #8
      //   38: aload #8
      //   40: invokevirtual getName : ()Ljava/lang/String;
      //   43: aload_1
      //   44: invokevirtual equals : (Ljava/lang/Object;)Z
      //   47: ifeq -> 264
      //   50: aload #8
      //   52: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
      //   55: arraylength
      //   56: aload_2
      //   57: invokeinterface size : ()I
      //   62: if_icmpne -> 264
      //   65: aload #8
      //   67: ifnull -> 575
      //   70: aload_2
      //   71: invokeinterface size : ()I
      //   76: tableswitch default -> 116, 0 -> 270, 1 -> 284, 2 -> 308, 3 -> 342, 4 -> 386, 5 -> 440
      //   116: aload #8
      //   118: aload_0
      //   119: bipush #6
      //   121: anewarray java/lang/Object
      //   124: dup
      //   125: iconst_0
      //   126: aload_2
      //   127: iconst_0
      //   128: invokeinterface get : (I)Ljava/lang/Object;
      //   133: aastore
      //   134: dup
      //   135: iconst_1
      //   136: aload_2
      //   137: iconst_1
      //   138: invokeinterface get : (I)Ljava/lang/Object;
      //   143: aastore
      //   144: dup
      //   145: iconst_2
      //   146: aload_2
      //   147: iconst_2
      //   148: invokeinterface get : (I)Ljava/lang/Object;
      //   153: aastore
      //   154: dup
      //   155: iconst_3
      //   156: aload_2
      //   157: iconst_3
      //   158: invokeinterface get : (I)Ljava/lang/Object;
      //   163: aastore
      //   164: dup
      //   165: iconst_4
      //   166: aload_2
      //   167: iconst_4
      //   168: invokeinterface get : (I)Ljava/lang/Object;
      //   173: aastore
      //   174: dup
      //   175: iconst_5
      //   176: aload_2
      //   177: iconst_5
      //   178: invokeinterface get : (I)Ljava/lang/Object;
      //   183: aastore
      //   184: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   187: astore_1
      //   188: aload #8
      //   190: invokevirtual getReturnType : ()Ljava/lang/Class;
      //   193: astore #5
      //   195: new java/lang/StringBuilder
      //   198: astore_2
      //   199: aload_2
      //   200: invokespecial <init> : ()V
      //   203: ldc 'openSDK_LOG.JsBridge'
      //   205: aload_2
      //   206: ldc '-->call, result: '
      //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   211: aload_1
      //   212: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   215: ldc ' | ReturnType: '
      //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: aload #5
      //   222: invokevirtual getName : ()Ljava/lang/String;
      //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: invokevirtual toString : ()Ljava/lang/String;
      //   231: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   234: ldc 'void'
      //   236: aload #5
      //   238: invokevirtual getName : ()Ljava/lang/String;
      //   241: invokevirtual equals : (Ljava/lang/Object;)Z
      //   244: ifne -> 254
      //   247: aload #5
      //   249: ldc java/lang/Void
      //   251: if_acmpne -> 504
      //   254: aload_3
      //   255: ifnull -> 263
      //   258: aload_3
      //   259: aconst_null
      //   260: invokevirtual a : (Ljava/lang/Object;)V
      //   263: return
      //   264: iinc #7, 1
      //   267: goto -> 20
      //   270: aload #8
      //   272: aload_0
      //   273: iconst_0
      //   274: anewarray java/lang/Object
      //   277: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   280: astore_1
      //   281: goto -> 188
      //   284: aload #8
      //   286: aload_0
      //   287: iconst_1
      //   288: anewarray java/lang/Object
      //   291: dup
      //   292: iconst_0
      //   293: aload_2
      //   294: iconst_0
      //   295: invokeinterface get : (I)Ljava/lang/Object;
      //   300: aastore
      //   301: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   304: astore_1
      //   305: goto -> 188
      //   308: aload #8
      //   310: aload_0
      //   311: iconst_2
      //   312: anewarray java/lang/Object
      //   315: dup
      //   316: iconst_0
      //   317: aload_2
      //   318: iconst_0
      //   319: invokeinterface get : (I)Ljava/lang/Object;
      //   324: aastore
      //   325: dup
      //   326: iconst_1
      //   327: aload_2
      //   328: iconst_1
      //   329: invokeinterface get : (I)Ljava/lang/Object;
      //   334: aastore
      //   335: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   338: astore_1
      //   339: goto -> 188
      //   342: aload #8
      //   344: aload_0
      //   345: iconst_3
      //   346: anewarray java/lang/Object
      //   349: dup
      //   350: iconst_0
      //   351: aload_2
      //   352: iconst_0
      //   353: invokeinterface get : (I)Ljava/lang/Object;
      //   358: aastore
      //   359: dup
      //   360: iconst_1
      //   361: aload_2
      //   362: iconst_1
      //   363: invokeinterface get : (I)Ljava/lang/Object;
      //   368: aastore
      //   369: dup
      //   370: iconst_2
      //   371: aload_2
      //   372: iconst_2
      //   373: invokeinterface get : (I)Ljava/lang/Object;
      //   378: aastore
      //   379: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   382: astore_1
      //   383: goto -> 188
      //   386: aload #8
      //   388: aload_0
      //   389: iconst_4
      //   390: anewarray java/lang/Object
      //   393: dup
      //   394: iconst_0
      //   395: aload_2
      //   396: iconst_0
      //   397: invokeinterface get : (I)Ljava/lang/Object;
      //   402: aastore
      //   403: dup
      //   404: iconst_1
      //   405: aload_2
      //   406: iconst_1
      //   407: invokeinterface get : (I)Ljava/lang/Object;
      //   412: aastore
      //   413: dup
      //   414: iconst_2
      //   415: aload_2
      //   416: iconst_2
      //   417: invokeinterface get : (I)Ljava/lang/Object;
      //   422: aastore
      //   423: dup
      //   424: iconst_3
      //   425: aload_2
      //   426: iconst_3
      //   427: invokeinterface get : (I)Ljava/lang/Object;
      //   432: aastore
      //   433: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   436: astore_1
      //   437: goto -> 188
      //   440: aload #8
      //   442: aload_0
      //   443: iconst_5
      //   444: anewarray java/lang/Object
      //   447: dup
      //   448: iconst_0
      //   449: aload_2
      //   450: iconst_0
      //   451: invokeinterface get : (I)Ljava/lang/Object;
      //   456: aastore
      //   457: dup
      //   458: iconst_1
      //   459: aload_2
      //   460: iconst_1
      //   461: invokeinterface get : (I)Ljava/lang/Object;
      //   466: aastore
      //   467: dup
      //   468: iconst_2
      //   469: aload_2
      //   470: iconst_2
      //   471: invokeinterface get : (I)Ljava/lang/Object;
      //   476: aastore
      //   477: dup
      //   478: iconst_3
      //   479: aload_2
      //   480: iconst_3
      //   481: invokeinterface get : (I)Ljava/lang/Object;
      //   486: aastore
      //   487: dup
      //   488: iconst_4
      //   489: aload_2
      //   490: iconst_4
      //   491: invokeinterface get : (I)Ljava/lang/Object;
      //   496: aastore
      //   497: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   500: astore_1
      //   501: goto -> 188
      //   504: aload_3
      //   505: ifnull -> 263
      //   508: aload_0
      //   509: invokevirtual customCallback : ()Z
      //   512: ifeq -> 263
      //   515: aload_1
      //   516: ifnull -> 570
      //   519: aload_1
      //   520: invokevirtual toString : ()Ljava/lang/String;
      //   523: astore_1
      //   524: aload_3
      //   525: aload_1
      //   526: invokevirtual a : (Ljava/lang/String;)V
      //   529: goto -> 263
      //   532: astore_1
      //   533: ldc 'openSDK_LOG.JsBridge'
      //   535: new java/lang/StringBuilder
      //   538: dup
      //   539: invokespecial <init> : ()V
      //   542: ldc '-->handler call mehtod ex. targetMethod: '
      //   544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   547: aload #8
      //   549: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   552: invokevirtual toString : ()Ljava/lang/String;
      //   555: aload_1
      //   556: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   559: aload_3
      //   560: ifnull -> 263
      //   563: aload_3
      //   564: invokevirtual a : ()V
      //   567: goto -> 263
      //   570: aconst_null
      //   571: astore_1
      //   572: goto -> 524
      //   575: aload_3
      //   576: ifnull -> 263
      //   579: aload_3
      //   580: invokevirtual a : ()V
      //   583: goto -> 263
      // Exception table:
      //   from	to	target	type
      //   70	116	532	java/lang/Exception
      //   116	188	532	java/lang/Exception
      //   188	247	532	java/lang/Exception
      //   258	263	532	java/lang/Exception
      //   270	281	532	java/lang/Exception
      //   284	305	532	java/lang/Exception
      //   308	339	532	java/lang/Exception
      //   342	383	532	java/lang/Exception
      //   386	437	532	java/lang/Exception
      //   440	501	532	java/lang/Exception
      //   508	515	532	java/lang/Exception
      //   519	524	532	java/lang/Exception
      //   524	529	532	java/lang/Exception
    }
    
    public boolean customCallback() {
      return false;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */