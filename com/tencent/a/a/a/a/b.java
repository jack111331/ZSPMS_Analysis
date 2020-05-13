package com.tencent.a.a.a.a;

import android.content.Context;
import android.os.Environment;

final class b extends f {
  b(Context paramContext) {
    super(paramContext);
  }
  
  protected final boolean a() {
    return (h.a(this.e, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted"));
  }
  
  protected final String b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'read mid from InternalStorage'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new java/io/File
    //   13: astore_1
    //   14: aload_1
    //   15: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   18: ldc '6X8Y4XdM2Vhvn0KfzcEatGnWaNU='
    //   20: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokestatic a : (Ljava/io/File;)Ljava/util/List;
    //   30: invokeinterface iterator : ()Ljava/util/Iterator;
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 114
    //   45: aload_2
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast java/lang/String
    //   54: ldc ','
    //   56: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: arraylength
    //   62: iconst_2
    //   63: if_icmpne -> 36
    //   66: aload_1
    //   67: iconst_0
    //   68: aaload
    //   69: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   71: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual equals : (Ljava/lang/Object;)Z
    //   77: ifeq -> 36
    //   80: new java/lang/StringBuilder
    //   83: astore_2
    //   84: aload_2
    //   85: ldc 'read mid from InternalStorage:'
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: ldc 'MID'
    //   92: aload_2
    //   93: aload_1
    //   94: iconst_1
    //   95: aaload
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   105: pop
    //   106: aload_1
    //   107: iconst_1
    //   108: aaload
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: areturn
    //   114: aconst_null
    //   115: astore_1
    //   116: goto -> 110
    //   119: astore_1
    //   120: ldc 'MID'
    //   122: aload_1
    //   123: invokestatic w : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -> 110
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	132	finally
    //   26	36	119	java/io/IOException
    //   26	36	132	finally
    //   36	106	119	java/io/IOException
    //   36	106	132	finally
    //   110	112	132	finally
    //   120	127	132	finally
  }
  
  protected final void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MID'
    //   4: ldc 'write mid to InternalStorage'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new java/lang/StringBuilder
    //   13: astore_2
    //   14: aload_2
    //   15: invokespecial <init> : ()V
    //   18: aload_2
    //   19: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   22: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc '/'
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc '6X8Y4XdM2Vhvn0I='
    //   32: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokestatic a : (Ljava/lang/String;)Ljava/io/File;
    //   44: pop
    //   45: new java/io/File
    //   48: astore_3
    //   49: aload_3
    //   50: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   53: ldc '6X8Y4XdM2Vhvn0KfzcEatGnWaNU='
    //   55: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   61: new java/io/FileWriter
    //   64: astore_2
    //   65: aload_2
    //   66: aload_3
    //   67: invokespecial <init> : (Ljava/io/File;)V
    //   70: new java/io/BufferedWriter
    //   73: astore_3
    //   74: aload_3
    //   75: aload_2
    //   76: invokespecial <init> : (Ljava/io/Writer;)V
    //   79: new java/lang/StringBuilder
    //   82: astore_2
    //   83: aload_2
    //   84: invokespecial <init> : ()V
    //   87: aload_3
    //   88: aload_2
    //   89: ldc '4kU71lN96TJUomD1vOU9lgj9Tw=='
    //   91: invokestatic f : (Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc ','
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual toString : ()Ljava/lang/String;
    //   109: invokevirtual write : (Ljava/lang/String;)V
    //   112: aload_3
    //   113: ldc '\\n'
    //   115: invokevirtual write : (Ljava/lang/String;)V
    //   118: aload_3
    //   119: invokevirtual close : ()V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: astore_1
    //   126: ldc 'MID'
    //   128: aload_1
    //   129: invokestatic w : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: goto -> 122
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   2	61	136	finally
    //   61	122	125	java/lang/Exception
    //   61	122	136	finally
    //   122	124	136	finally
    //   126	133	136	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */