package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

@TargetApi(19)
@RequiresApi(19)
class DocumentsContractApi19 {
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri) {
    boolean bool = true;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0 || TextUtils.isEmpty(getRawType(paramContext, paramUri)))
      bool = false; 
    return bool;
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri) {
    boolean bool1 = false;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0)
      return bool1; 
    String str = getRawType(paramContext, paramUri);
    int i = queryForInt(paramContext, paramUri, "flags", 0);
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(str)) {
      if ((i & 0x4) != 0)
        return true; 
      if ("vnd.android.document/directory".equals(str) && (i & 0x8) != 0)
        return true; 
      bool2 = bool1;
      if (!TextUtils.isEmpty(str)) {
        bool2 = bool1;
        if ((i & 0x2) != 0)
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable) {
    if (paramAutoCloseable != null)
      try {
        paramAutoCloseable.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static boolean delete(Context paramContext, Uri paramUri) {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }
  
  public static boolean exists(Context paramContext, Uri paramUri) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      Cursor cursor = contentResolver.query(paramUri, new String[] { "document_id" }, null, null, null);
    } catch (Exception exception) {
      contentResolver = null;
    } finally {
      paramUri = null;
    } 
    closeQuietly((AutoCloseable)contentResolver);
    throw paramUri;
  }
  
  public static long getFlags(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  public static String getName(Context paramContext, Uri paramUri) {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri) {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri) {
    String str2 = getRawType(paramContext, paramUri);
    String str1 = str2;
    if ("vnd.android.document/directory".equals(str2))
      str1 = null; 
    return str1;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri) {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri) {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri) {
    String str = getRawType(paramContext, paramUri);
    return !("vnd.android.document/directory".equals(str) || TextUtils.isEmpty(str));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri) {
    return (isDocumentUri(paramContext, paramUri) && (0x200L & getFlags(paramContext, paramUri)) != 0L);
  }
  
  public static long lastModified(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri) {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt) {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface moveToFirst : ()Z
    //   30: ifeq -> 65
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface isNull : (I)Z
    //   42: ifne -> 65
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface getLong : (I)J
    //   54: lstore #5
    //   56: lload #5
    //   58: lstore_3
    //   59: aload_1
    //   60: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   63: lload_3
    //   64: lreturn
    //   65: aload_1
    //   66: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   69: goto -> 63
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: new java/lang/StringBuilder
    //   80: astore #7
    //   82: aload_1
    //   83: astore_0
    //   84: aload #7
    //   86: invokespecial <init> : ()V
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 'DocumentFile'
    //   93: aload #7
    //   95: ldc 'Failed query: '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_1
    //   112: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   115: goto -> 63
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   125: aload_1
    //   126: athrow
    //   127: astore_2
    //   128: goto -> 75
    //   131: astore_1
    //   132: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   5	22	72	java/lang/Exception
    //   5	22	118	finally
    //   24	33	127	java/lang/Exception
    //   24	33	131	finally
    //   35	45	127	java/lang/Exception
    //   35	45	131	finally
    //   47	56	127	java/lang/Exception
    //   47	56	131	finally
    //   77	82	131	finally
    //   84	89	131	finally
    //   91	111	131	finally
  }
  
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface moveToFirst : ()Z
    //   30: ifeq -> 63
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface isNull : (I)Z
    //   42: ifne -> 63
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface getString : (I)Ljava/lang/String;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_1
    //   58: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   61: aload_0
    //   62: areturn
    //   63: aload_1
    //   64: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   67: aload_3
    //   68: astore_0
    //   69: goto -> 61
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: new java/lang/StringBuilder
    //   80: astore #4
    //   82: aload_1
    //   83: astore_0
    //   84: aload #4
    //   86: invokespecial <init> : ()V
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 'DocumentFile'
    //   93: aload #4
    //   95: ldc 'Failed query: '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload_1
    //   112: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   115: aload_3
    //   116: astore_0
    //   117: goto -> 61
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_2
    //   130: goto -> 75
    //   133: astore_1
    //   134: goto -> 123
    // Exception table:
    //   from	to	target	type
    //   5	22	72	java/lang/Exception
    //   5	22	120	finally
    //   24	33	129	java/lang/Exception
    //   24	33	133	finally
    //   35	45	129	java/lang/Exception
    //   35	45	133	finally
    //   47	55	129	java/lang/Exception
    //   47	55	133	finally
    //   77	82	133	finally
    //   84	89	133	finally
    //   91	111	133	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */