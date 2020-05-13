package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;

public class SecureJsInterface extends a.b {
  public static boolean isPWDEdit = false;
  
  private String a;
  
  public void clearAllEdit() {
    f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
    try {
      JniInterface.clearAllPWD();
      return;
    } catch (Exception exception) {
      f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + exception.getMessage());
      throw new RuntimeException(exception);
    } 
  }
  
  public void curPosFromJS(String paramString) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.SecureJsInterface'
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: ldc '-->curPosFromJS: '
    //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: istore_2
    //   26: aload_1
    //   27: invokestatic parseInt : (Ljava/lang/String;)I
    //   30: istore_3
    //   31: iload_3
    //   32: ifge -> 59
    //   35: new java/lang/RuntimeException
    //   38: dup
    //   39: ldc 'position is illegal.'
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: athrow
    //   45: astore_1
    //   46: ldc 'openSDK_LOG.SecureJsInterface'
    //   48: ldc '-->curPosFromJS number format exception.'
    //   50: aload_1
    //   51: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: iload_2
    //   55: istore_3
    //   56: goto -> 31
    //   59: getstatic com/tencent/open/web/security/a.c : Z
    //   62: ifne -> 65
    //   65: getstatic com/tencent/open/web/security/a.b : Z
    //   68: ifeq -> 92
    //   71: getstatic com/tencent/open/web/security/a.b : Z
    //   74: iload_3
    //   75: invokestatic BackSpaceChar : (ZI)Z
    //   78: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   81: invokevirtual booleanValue : ()Z
    //   84: ifeq -> 91
    //   87: iconst_0
    //   88: putstatic com/tencent/open/web/security/a.b : Z
    //   91: return
    //   92: aload_0
    //   93: getstatic com/tencent/open/web/security/a.a : Ljava/lang/String;
    //   96: putfield a : Ljava/lang/String;
    //   99: iload_3
    //   100: aload_0
    //   101: getfield a : Ljava/lang/String;
    //   104: aload_0
    //   105: getfield a : Ljava/lang/String;
    //   108: invokevirtual length : ()I
    //   111: invokestatic insetTextToArray : (ILjava/lang/String;I)Z
    //   114: pop
    //   115: ldc 'openSDK_LOG.SecureJsInterface'
    //   117: new java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial <init> : ()V
    //   124: ldc 'curPosFromJS mKey: '
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield a : Ljava/lang/String;
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual toString : ()Ljava/lang/String;
    //   139: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -> 91
    // Exception table:
    //   from	to	target	type
    //   26	31	45	java/lang/NumberFormatException
  }
  
  public boolean customCallback() {
    return true;
  }
  
  public String getMD5FromNative() {
    f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
    try {
      String str = JniInterface.getPWDKeyToMD5(null);
      f.a("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + str);
      return str;
    } catch (Exception exception) {
      f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + exception.getMessage());
      throw new RuntimeException(exception);
    } 
  }
  
  public void isPasswordEdit(String paramString) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.SecureJsInterface'
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: ldc '-->is pswd edit, flag: '
    //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: istore_2
    //   26: aload_1
    //   27: invokestatic parseInt : (Ljava/lang/String;)I
    //   30: istore_3
    //   31: iload_3
    //   32: ifeq -> 83
    //   35: iload_3
    //   36: iconst_1
    //   37: if_icmpeq -> 83
    //   40: new java/lang/RuntimeException
    //   43: dup
    //   44: ldc 'is pswd edit flag is illegal.'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_1
    //   51: ldc 'openSDK_LOG.SecureJsInterface'
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: ldc '-->is pswd edit exception: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual getMessage : ()Ljava/lang/String;
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   78: iload_2
    //   79: istore_3
    //   80: goto -> 31
    //   83: iload_3
    //   84: ifne -> 92
    //   87: iconst_0
    //   88: putstatic com/tencent/open/web/security/SecureJsInterface.isPWDEdit : Z
    //   91: return
    //   92: iload_3
    //   93: iconst_1
    //   94: if_icmpne -> 91
    //   97: iconst_1
    //   98: putstatic com/tencent/open/web/security/SecureJsInterface.isPWDEdit : Z
    //   101: goto -> 91
    // Exception table:
    //   from	to	target	type
    //   26	31	50	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\web\security\SecureJsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */