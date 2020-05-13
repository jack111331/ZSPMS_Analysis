package android.support.v4.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;

@TargetApi(21)
@RequiresApi(21)
class DocumentsContractApi21 {
  private static final String TAG = "DocumentFile";
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable) {
    if (paramAutoCloseable != null)
      try {
        paramAutoCloseable.close();
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {} 
  }
  
  public static Uri createDirectory(Context paramContext, Uri paramUri, String paramString) {
    return createFile(paramContext, paramUri, "vnd.android.document/directory", paramString);
  }
  
  public static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
  }
  
  public static Uri[] listFiles(Context paramContext, Uri paramUri) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_1
    //   6: aload_1
    //   7: invokestatic getDocumentId : (Landroid/net/Uri;)Ljava/lang/String;
    //   10: invokestatic buildChildDocumentsUriUsingTree : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_2
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_3
    //   22: aload_0
    //   23: aload_2
    //   24: iconst_1
    //   25: anewarray java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 'document_id'
    //   32: aastore
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_2
    //   40: aload_2
    //   41: astore_0
    //   42: aload_2
    //   43: invokeinterface moveToNext : ()Z
    //   48: ifeq -> 128
    //   51: aload_2
    //   52: astore_0
    //   53: aload_3
    //   54: aload_1
    //   55: aload_2
    //   56: iconst_0
    //   57: invokeinterface getString : (I)Ljava/lang/String;
    //   62: invokestatic buildDocumentUriUsingTree : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   65: invokevirtual add : (Ljava/lang/Object;)Z
    //   68: pop
    //   69: goto -> 40
    //   72: astore_1
    //   73: aload_2
    //   74: astore_0
    //   75: new java/lang/StringBuilder
    //   78: astore #4
    //   80: aload_2
    //   81: astore_0
    //   82: aload #4
    //   84: invokespecial <init> : ()V
    //   87: aload_2
    //   88: astore_0
    //   89: ldc 'DocumentFile'
    //   91: aload #4
    //   93: ldc 'Failed query: '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual toString : ()Ljava/lang/String;
    //   105: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   108: pop
    //   109: aload_2
    //   110: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   113: aload_3
    //   114: aload_3
    //   115: invokevirtual size : ()I
    //   118: anewarray android/net/Uri
    //   121: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   124: checkcast [Landroid/net/Uri;
    //   127: areturn
    //   128: aload_2
    //   129: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   132: goto -> 113
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_0
    //   139: astore_1
    //   140: aload_2
    //   141: invokestatic closeQuietly : (Ljava/lang/AutoCloseable;)V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: goto -> 73
    //   152: astore_1
    //   153: aload_0
    //   154: astore_2
    //   155: goto -> 140
    // Exception table:
    //   from	to	target	type
    //   22	40	146	java/lang/Exception
    //   22	40	135	finally
    //   42	51	72	java/lang/Exception
    //   42	51	152	finally
    //   53	69	72	java/lang/Exception
    //   53	69	152	finally
    //   75	80	152	finally
    //   82	87	152	finally
    //   89	109	152	finally
  }
  
  public static Uri prepareTreeUri(Uri paramUri) {
    return DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri));
  }
  
  public static Uri renameTo(Context paramContext, Uri paramUri, String paramString) {
    return DocumentsContract.renameDocument(paramContext.getContentResolver(), paramUri, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */