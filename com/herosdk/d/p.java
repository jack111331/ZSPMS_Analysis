package com.herosdk.d;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class p {
  private static final String a = "frameLib.flus";
  
  private static volatile p b;
  
  private static final String c = "UTF-8";
  
  public static p a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/p.b : Lcom/herosdk/d/p;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/p
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/p.b : Lcom/herosdk/d/p;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/p
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/p.b : Lcom/herosdk/d/p;
    //   27: ldc com/herosdk/d/p
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/p.b : Lcom/herosdk/d/p;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/p
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public File a(String paramString1, String paramString2) {
    try {
      File file2 = new File();
      this(paramString1);
      if (!file2.exists())
        file2.mkdirs(); 
      File file3 = new File();
      this(file2, paramString2);
      File file1 = file3;
      if (!file3.exists()) {
        file3.createNewFile();
        file1 = file3;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return (File)exception;
  }
  
  public String a(String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2))
        return ""; 
      str = "";
      paramString2 = a().b(paramString1, paramString2);
      if (TextUtils.isEmpty(paramString2)) {
        Log.d("frameLib.flus", "gffi return empty");
        return str;
      } 
    } catch (Exception exception) {
      return "";
    } 
    paramString1 = str;
    if (paramString2.startsWith(paramString3))
      paramString1 = paramString2.substring(paramString2.indexOf(":") + 1, paramString2.length()); 
    return paramString1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        paramString3 = stringBuilder.append(paramString3).append(":").append(paramString4).toString();
        c(paramString1, paramString2);
        File file = a(paramString1, paramString2);
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(file, true);
        paramString3 = o.a(paramString3, o.b());
        if (TextUtils.isEmpty(paramString3)) {
          if (file.exists())
            file.delete(); 
        } else {
          fileOutputStream.write(paramString3.getBytes("UTF-8"));
        } 
        fileOutputStream.close();
      } 
    } catch (Exception exception) {}
  }
  
  public String b(String paramString1, String paramString2) {
    String str1;
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2))
      return ""; 
    String str2 = "";
    File file = a(paramString1, paramString2);
    paramString1 = str2;
    if (file != null)
      try {
        FileInputStream fileInputStream = new FileInputStream();
        this(file);
        paramString1 = str2;
        if (fileInputStream != null) {
          InputStreamReader inputStreamReader = new InputStreamReader();
          this(fileInputStream);
          BufferedReader bufferedReader = new BufferedReader();
          this(inputStreamReader);
          str1 = "";
          while (true) {
            String str = bufferedReader.readLine();
            if (str != null) {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              str1 = stringBuilder.append(str1).append(str).append("\n").toString();
              continue;
            } 
            fileInputStream.close();
            bufferedReader.close();
            if (TextUtils.isEmpty(str1)) {
              str1 = "";
              // Byte code: goto -> 17
            } 
            if (TextUtils.isEmpty(o.b(str1, o.b()))) {
              if (file.exists()) {
                file.delete();
                return "invalid data";
              } 
              continue;
            } 
            break;
          } 
          str1 = o.b(str1, o.b());
        } 
      } catch (Exception exception) {
        str1 = "";
      }  
    return str1;
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {
    try {
      if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
        File file = a().a(paramString1, paramString2);
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(file, true);
        fileOutputStream.write(o.a(paramString3, o.b()).getBytes("UTF-8"));
        fileOutputStream.close();
      } 
    } catch (Exception exception) {}
  }
  
  public void c(String paramString1, String paramString2) {
    try {
      if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
        File file1 = new File();
        File file2 = new File();
        this(paramString1);
        this(file2, paramString2);
        if (file1.exists() && !file1.isDirectory()) {
          FileWriter fileWriter = new FileWriter();
          this(file1);
          BufferedWriter bufferedWriter = new BufferedWriter();
          this(fileWriter);
          bufferedWriter.write("");
          bufferedWriter.close();
        } 
      } 
    } catch (Exception exception) {}
  }
  
  public void c(String paramString1, String paramString2, String paramString3) {
    try {
      if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
        File file = a().a(paramString1, paramString2);
        FileOutputStream fileOutputStream = new FileOutputStream();
        this(file, true);
        fileOutputStream.write(o.a(paramString3, o.b("mi+3XXLIixBh6et6/PItP1/O6RMylWGgc7jKuUJhjB4=", o.b())).getBytes("UTF-8"));
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.close();
      } 
    } catch (Exception exception) {}
  }
  
  public void d(String paramString1, String paramString2) {
    File file = a(paramString1, paramString2);
    if (file != null)
      try {
        FileInputStream fileInputStream = new FileInputStream();
        this(file);
        if (fileInputStream != null) {
          InputStreamReader inputStreamReader = new InputStreamReader();
          this(fileInputStream);
          BufferedReader bufferedReader = new BufferedReader();
          this(inputStreamReader);
          String str = "";
          while (true) {
            JSONObject jSONObject2;
            String str1;
            String str3 = bufferedReader.readLine();
            if (str3 == null || str3.isEmpty()) {
              fileInputStream.close();
              bufferedReader.close();
              if (str.isEmpty())
                str = ""; 
              if (str.isEmpty()) {
                jSONObject2 = new JSONObject();
                this();
                jSONObject2.put("action", "timestamp");
                JSONObject jSONObject = new JSONObject();
                this();
                jSONObject.put("time", System.currentTimeMillis());
                jSONObject2.put("info", jSONObject);
                c(paramString1, paramString2, jSONObject2.toString());
                return;
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              str1 = stringBuilder.append((String)jSONObject2).append(str3).append("\n").toString();
              continue;
            } 
            String str2 = o.b(str1, o.b("mi+3XXLIixBh6et6/PItP1/O6RMylWGgc7jKuUJhjB4=", o.b()));
            JSONObject jSONObject1 = new JSONObject();
            this(str2);
            long l = jSONObject1.getJSONObject("info").optLong("time");
            if (l == 0L || System.currentTimeMillis() - l >= 604800000L)
              c(paramString1, paramString2); 
            return;
          } 
        } 
      } catch (Exception exception) {} 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */