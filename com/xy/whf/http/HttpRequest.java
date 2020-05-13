package com.xy.whf.http;

import android.content.Context;
import android.os.AsyncTask;
import com.xy.whf.a.a.a;
import com.xy.whf.entity.StatusCode;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public class HttpRequest {
  private static HttpRequest INSTANCE;
  
  private WeakReference<Context> mWeakReference;
  
  private HttpRequest(Context paramContext) {
    this.mWeakReference = new WeakReference<Context>(paramContext);
  }
  
  private static void close(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream, BufferedReader paramBufferedReader, OutputStreamWriter paramOutputStreamWriter) {
    if (paramHttpURLConnection != null)
      try {
        paramHttpURLConnection.disconnect();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (paramInputStream != null)
      try {
        paramInputStream.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (paramBufferedReader != null)
      try {
        paramBufferedReader.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (paramOutputStreamWriter != null)
      try {
        paramOutputStreamWriter.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static HttpRequest getInstance(Context paramContext) {
    if (INSTANCE == null)
      INSTANCE = new HttpRequest(paramContext); 
    return INSTANCE;
  }
  
  public void get(String paramString, ResponseListener paramResponseListener) {
    (new HttpGetTask(paramString, paramResponseListener)).execute((Object[])new Void[0]);
  }
  
  public void get(String paramString, HashMap<String, Object> paramHashMap, ResponseListener paramResponseListener) {
    HashMap<String, Object> hashMap = paramHashMap;
    if (paramHashMap == null)
      hashMap = new HashMap<String, Object>(); 
    try {
      hashMap.put("app_no", a.e(this.mWeakReference.get()));
      hashMap.put("zmid", a.g(this.mWeakReference.get()));
      hashMap.put("device_id", a.d(this.mWeakReference.get()));
      hashMap.put("imei", a.b(this.mWeakReference.get()));
      HttpGetTask httpGetTask = new HttpGetTask();
      this(paramString, hashMap, paramResponseListener);
      httpGetTask.execute((Object[])new Void[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void post(String paramString, ResponseListener paramResponseListener) {
    (new HttpPostTask(paramString, "", paramResponseListener)).execute((Object[])new Void[0]);
  }
  
  public void post(String paramString, HashMap<String, Object> paramHashMap, ResponseListener paramResponseListener) {
    HashMap<String, Object> hashMap = paramHashMap;
    if (paramHashMap == null)
      hashMap = new HashMap<String, Object>(); 
    try {
      hashMap.put("app_no", a.e(this.mWeakReference.get()));
      hashMap.put("zmid", a.g(this.mWeakReference.get()));
      hashMap.put("device_id", a.d(this.mWeakReference.get()));
      hashMap.put("imei", a.b(this.mWeakReference.get()));
      HttpPostTask httpPostTask = new HttpPostTask();
      this(paramString, hashMap, paramResponseListener);
      httpPostTask.execute((Object[])new Void[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void post(String paramString, JSONObject paramJSONObject, ResponseListener paramResponseListener) {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    try {
      jSONObject.put("app_no", a.e(this.mWeakReference.get()));
      jSONObject.put("zmid", a.g(this.mWeakReference.get()));
      jSONObject.put("device_id", a.d(this.mWeakReference.get()));
      jSONObject.put("imei", a.b(this.mWeakReference.get()));
      HttpPostTask httpPostTask = new HttpPostTask();
      this(paramString, jSONObject.toString(), paramResponseListener);
      httpPostTask.execute((Object[])new Void[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private static class HttpGetTask extends AsyncTask<Void, Void, String> {
    private ResponseListener listener;
    
    private HashMap<String, Object> paramsMap = null;
    
    private JSONObject paramsStr = null;
    
    private String url;
    
    private HttpGetTask(String param1String, ResponseListener param1ResponseListener) {
      this.url = param1String;
      this.listener = param1ResponseListener;
    }
    
    private HttpGetTask(String param1String, HashMap<String, Object> param1HashMap, ResponseListener param1ResponseListener) {
      this.url = param1String;
      this.paramsMap = param1HashMap;
      this.listener = param1ResponseListener;
    }
    
    private HttpGetTask(String param1String, JSONObject param1JSONObject, ResponseListener param1ResponseListener) {
      this.url = param1String;
      this.paramsStr = param1JSONObject;
      this.listener = param1ResponseListener;
    }
    
    protected String doInBackground(Void... param1VarArgs) {
      BufferedReader bufferedReader;
      HttpURLConnection httpURLConnection;
      InputStream inputStream;
      try {
        Exception exception;
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        if (!LangHelper.isNullOrEmpty(this.paramsMap)) {
          for (String str : this.paramsMap.keySet())
            stringBuilder1.append(str).append("=").append(this.paramsMap.get(str)).append("&"); 
          stringBuilder1.replace(stringBuilder1.length() - 1, stringBuilder1.length(), "");
        } else if (!LangHelper.isNullOrEmpty(this.paramsStr)) {
          stringBuilder1.append(this.paramsStr);
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        this.url = stringBuilder2.append(this.url).append("?").append(stringBuilder1.toString()).toString();
        URL uRL = new URL();
        this(this.url);
      } catch (Exception null) {
        param1VarArgs = null;
      } finally {
        param1VarArgs = null;
        bufferedReader = null;
        inputStream = null;
      } 
      HttpRequest.close(httpURLConnection, inputStream, bufferedReader, null);
      throw param1VarArgs;
    }
    
    protected void onPostExecute(String param1String) {
      super.onPostExecute(param1String);
      if (!LangHelper.isNullOrEmpty(param1String)) {
        if (this.listener != null)
          this.listener.result(StatusCode.SUCCESS_0, param1String); 
        return;
      } 
      if (this.listener != null)
        this.listener.result(StatusCode.FAILED_0, null); 
    }
  }
  
  private static class HttpPostTask extends AsyncTask<Void, Void, String> {
    private ResponseListener listener;
    
    private HashMap<String, Object> paramsMap = null;
    
    private String paramsStr = null;
    
    private String url;
    
    private HttpPostTask(String param1String, ResponseListener param1ResponseListener) {
      this.url = param1String;
      this.listener = param1ResponseListener;
    }
    
    private HttpPostTask(String param1String1, String param1String2, ResponseListener param1ResponseListener) {
      this.url = param1String1;
      this.paramsStr = param1String2;
      this.listener = param1ResponseListener;
    }
    
    private HttpPostTask(String param1String, HashMap<String, Object> param1HashMap, ResponseListener param1ResponseListener) {
      this.url = param1String;
      this.paramsMap = param1HashMap;
      this.listener = param1ResponseListener;
    }
    
    private void close(HttpURLConnection param1HttpURLConnection, InputStream param1InputStream, BufferedReader param1BufferedReader, OutputStreamWriter param1OutputStreamWriter) {
      if (param1HttpURLConnection != null)
        try {
          param1HttpURLConnection.disconnect();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
      if (param1InputStream != null)
        try {
          param1InputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
      if (param1BufferedReader != null)
        try {
          param1BufferedReader.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
      if (param1OutputStreamWriter != null)
        try {
          param1OutputStreamWriter.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    }
    
    protected String doInBackground(Void... param1VarArgs) {
      InputStream inputStream;
      HttpURLConnection httpURLConnection;
      BufferedReader bufferedReader;
      InputStreamReader inputStreamReader = null;
      try {
        Exception exception1;
        Exception exception2;
        Exception exception3;
        URL uRL = new URL();
        this(this.url);
        HttpURLConnection httpURLConnection1 = (HttpURLConnection)uRL.openConnection();
        try {
          StringBuilder stringBuilder2;
          StringBuilder stringBuilder1;
          httpURLConnection1.setRequestMethod("POST");
          httpURLConnection1.setRequestProperty("Accept-Charset", "utf-8");
          httpURLConnection1.setDoInput(true);
          httpURLConnection1.setDoOutput(true);
          StringBuilder stringBuilder3 = new StringBuilder();
          this();
        } catch (Exception null) {
          BufferedReader bufferedReader1 = null;
          bufferedReader = null;
        } finally {
          Exception exception = null;
          bufferedReader = null;
          inputStream = null;
          exception3 = exception1;
        } 
        close((HttpURLConnection)exception3, inputStream, bufferedReader, (OutputStreamWriter)exception2);
        throw exception1;
      } catch (Exception exception) {
      
      } finally {
        bufferedReader = null;
        inputStream = null;
        httpURLConnection = null;
        close(httpURLConnection, inputStream, bufferedReader, (OutputStreamWriter)inputStreamReader);
      } 
      try {
        return null;
      } finally {
        BufferedReader bufferedReader2;
        Exception exception2 = null;
        Void[] arrayOfVoid2 = param1VarArgs;
        BufferedReader bufferedReader1 = bufferedReader;
        HttpURLConnection httpURLConnection1 = httpURLConnection;
        Exception exception1 = exception2;
        InputStreamReader inputStreamReader1 = inputStreamReader;
        Void[] arrayOfVoid1 = arrayOfVoid2;
      } 
    }
    
    protected void onPostExecute(String param1String) {
      super.onPostExecute(param1String);
      if (!LangHelper.isNullOrEmpty(param1String)) {
        if (this.listener != null)
          this.listener.result(StatusCode.SUCCESS_0, param1String); 
        return;
      } 
      if (this.listener != null)
        this.listener.result(StatusCode.FAILED_0, null); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\http\HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */