package com.xy.whf.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.CallLog;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.d;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
  private static e a;
  
  private Context b;
  
  private e(Context paramContext) {
    this.b = paramContext;
  }
  
  public static e a(Context paramContext) {
    if (a == null)
      a = new e(paramContext); 
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
    
    private a(e this$0, String param1String, int param1Int, b param1b) {
      this.b = param1String;
      this.c = param1Int;
      this.d = param1b;
    }
    
    protected JSONArray a(Void... param1VarArgs) {
      Cursor cursor;
      JSONArray jSONArray = new JSONArray();
      try {
        ContentResolver contentResolver = e.a(this.a).getContentResolver();
        if (PermissionHelper.a(e.a(this.a), "android.permission.READ_CALL_LOG")) {
          long l = d.a(this.b, "yyyy-MM-dd HH:mm:ss");
          Uri uri = CallLog.Calls.CONTENT_URI;
          StringBuilder stringBuilder = new StringBuilder();
          this();
          cursor = contentResolver.query(uri, null, stringBuilder.append("date >= ").append(l).toString(), null, null);
          if (cursor != null) {
            if (cursor.getCount() <= this.c || this.c == 0)
              this.c = cursor.getCount(); 
            byte b1 = 0;
            while (b1 < this.c) {
              cursor.moveToPosition(b1);
              Date date = new Date();
              this(cursor.getLong(cursor.getColumnIndex("date")));
              int i = cursor.getInt(cursor.getColumnIndex("_id"));
              String str3 = cursor.getString(cursor.getColumnIndex("number"));
              int j = cursor.getInt(cursor.getColumnIndex("type"));
              String str2 = cursor.getString(cursor.getColumnIndex("name"));
              l = cursor.getLong(cursor.getColumnIndex("duration"));
              JSONObject jSONObject = new JSONObject();
              this();
              jSONObject.put("call_id", i);
              if (!LangHelper.isNullOrEmpty(str2)) {
                jSONObject.put("name", str2);
              } else {
                jSONObject.put("name", str3);
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              String str1 = stringBuilder1.append("").append(j).toString();
              switch (j) {
                case 1:
                  str1 = "呼入";
                  jSONObject.put("phone", str3);
                  jSONObject.put("call_time", d.a(date, "yyyy-MM-dd HH:mm:ss"));
                  jSONObject.put("type", str1);
                  jSONObject.put("duration", l);
                  jSONArray.put(jSONObject);
                  b1++;
                  break;
                case 2:
                  str1 = "呼出";
                  jSONObject.put("phone", str3);
                  jSONObject.put("call_time", d.a(date, "yyyy-MM-dd HH:mm:ss"));
                  jSONObject.put("type", str1);
                  jSONObject.put("duration", l);
                  jSONArray.put(jSONObject);
                  b1++;
                  break;
                case 3:
                  str1 = "未接";
                  jSONObject.put("phone", str3);
                  jSONObject.put("call_time", d.a(date, "yyyy-MM-dd HH:mm:ss"));
                  jSONObject.put("type", str1);
                  jSONObject.put("duration", l);
                  jSONArray.put(jSONObject);
                  b1++;
                  break;
              } 
            } 
          } else {
            return jSONArray;
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
    
    protected void a(JSONArray param1JSONArray) {
      super.onPostExecute(param1JSONArray);
      if (!LangHelper.isNullOrEmpty(param1JSONArray)) {
        this.d.a(param1JSONArray, 0);
        return;
      } 
      this.d.a(null, -1);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */