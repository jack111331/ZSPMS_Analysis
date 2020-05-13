package com.bun.miitmdid.core;

import android.content.Context;
import android.support.annotation.Keep;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Keep
public class JLibrary {
  @Keep
  public static String ASSET = "assets/";
  
  @Keep
  public static String SeriailizationString = "stub_liu_0_dex_so:39285EFA@com/jdog;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;";
  
  public static final String TAG = "JLibrary";
  
  @Keep
  public static ClassLoader classLoader;
  
  @Keep
  public static Context context;
  
  @Keep
  public static String o00o0a0odod;
  
  @Keep
  public static String o00o0a0odou;
  
  @Keep
  public static String xdata = ".00000000000";
  
  @Keep
  public static String ydata = ".11111111111";
  
  @Keep
  public static ReturnStatus InitEntry(Context paramContext) throws Exception {
    if (paramContext != null) {
      ReturnStatus returnStatus;
      context = paramContext;
      classLoader = JLibrary.class.getClassLoader();
      System.loadLibrary(SeriailizationString.substring(SeriailizationString.lastIndexOf(':') + 1, SeriailizationString.indexOf('@')));
      if ("!".length() < 0) {
        returnStatus = ReturnStatus.RETURN_ERR;
      } else {
        a();
        returnStatus = ReturnStatus.RETURN_OK;
      } 
      return returnStatus;
    } 
    throw new ExceptionInInitializerError("pass InitEntry arg(context) is null");
  }
  
  @Keep
  public static ByteBuffer ReadByteBuffer(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream();
      this(paramString);
      ByteBuffer byteBuffer = ByteBuffer.allocate(fileInputStream.available());
      for (int i = 0;; i += j) {
        if (i >= fileInputStream.available()) {
          fileInputStream.close();
          break;
        } 
        int j = fileInputStream.read(byteBuffer.array(), i, fileInputStream.available() - i);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (ByteBuffer)exception;
  }
  
  @Keep
  public static native boolean a();
  
  @Keep
  public static Object[] o0o0o0o0o0(Object paramObject, String paramString1, String paramString2, List<IOException> paramList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
    String[] arrayOfString = paramString1.split(";");
    ArrayList<ByteBuffer> arrayList = new ArrayList();
    int i = arrayOfString.length;
    for (byte b = 0;; b++) {
      ByteBuffer[] arrayOfByteBuffer;
      if (b >= i) {
        arrayOfByteBuffer = new ByteBuffer[arrayList.size()];
        return (Object[])o0o0o0o0o0o0(paramObject, paramString2, new Class[] { ByteBuffer[].class, List.class }).invoke(paramObject, new Object[] { arrayList.toArray((Object[])arrayOfByteBuffer), paramList });
      } 
      arrayList.add(ReadByteBuffer((String)arrayOfByteBuffer[b]));
    } 
  }
  
  @Keep
  private static Method o0o0o0o0o0o0(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    Class<?> clazz = paramObject.getClass();
    while (clazz != null) {
      try {
        Method method = clazz.getDeclaredMethod(paramString, paramVarArgs);
        if (!method.isAccessible())
          method.setAccessible(true); 
        return method;
      } catch (NoSuchMethodException noSuchMethodException) {
        clazz = clazz.getSuperclass();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder("Method ");
    stringBuilder.append(paramString);
    stringBuilder.append(" with parameters ");
    stringBuilder.append(Arrays.asList(paramVarArgs));
    stringBuilder.append(" not found in ");
    stringBuilder.append(paramObject.getClass());
    throw new NoSuchMethodException(stringBuilder.toString());
  }
  
  @Keep
  public static void o0oo0o0(Context paramContext, String paramString) throws Exception {
    try {
      StringBuilder stringBuilder1;
      IllegalStateException illegalStateException;
      int i;
      InputStream inputStream = paramContext.getAssets().open(paramString);
      o00o0a0odod = Utils.getXdataDir(paramContext, "");
      o00o0a0odou = Utils.getYdataDir(paramContext, "");
      File file1 = new File();
      this(o00o0a0odod);
      File file2 = new File();
      this(o00o0a0odou);
      boolean bool = file1.exists();
      byte b = 3;
      if (!bool) {
        i = 3;
        while (true) {
          int j = i - 1;
          if (i <= 0) {
            i = j;
            break;
          } 
          i = j;
          if (!file1.mkdir()) {
            i = j;
            continue;
          } 
          break;
        } 
      } else {
        i = 3;
      } 
      if (i != -1) {
        if (!file2.exists()) {
          i = b;
          while (true) {
            int j = i - 1;
            if (i <= 0) {
              i = j;
              break;
            } 
            i = j;
            if (!file2.mkdir()) {
              i = j;
              continue;
            } 
            break;
          } 
        } else {
          i = 3;
        } 
        if (i != -1) {
          if (!Utils.update(paramContext)) {
            file2 = new File();
            stringBuilder2 = new StringBuilder();
            this(String.valueOf(o00o0a0odod));
            stringBuilder2.append(paramString);
            this(stringBuilder2.toString());
            if (!file2.exists()) {
              stringBuilder2 = new StringBuilder();
              this(String.valueOf(o00o0a0odod));
              stringBuilder2.append(paramString);
              Utils.x0xooXdata(inputStream, stringBuilder2.toString(), paramContext);
            } 
            return;
          } 
        } else {
          IllegalStateException illegalStateException1 = new IllegalStateException();
          StringBuilder stringBuilder = new StringBuilder();
          this("User dir cannot be created: ");
          stringBuilder.append(file2.getAbsolutePath());
          this(stringBuilder.toString());
          throw illegalStateException1;
        } 
      } else {
        illegalStateException = new IllegalStateException();
        stringBuilder1 = new StringBuilder();
        this("User dir cannot be created: ");
        stringBuilder1.append(stringBuilder2.getAbsolutePath());
        this(stringBuilder1.toString());
        throw illegalStateException;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      this(String.valueOf(o00o0a0odod));
      stringBuilder2.append((String)illegalStateException);
      Utils.x0xooXdata(inputStream, stringBuilder2.toString(), (Context)stringBuilder1);
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
  
  @Keep
  enum ReturnStatus {
    RETURN_ERR, RETURN_OK;
    
    static {
      ENUM$VALUES = new ReturnStatus[] { RETURN_OK, RETURN_ERR };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\core\JLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */