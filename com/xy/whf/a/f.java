package com.xy.whf.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
  private static f a;
  
  private Context b;
  
  private f(Context paramContext) {
    this.b = paramContext;
  }
  
  public static f a(Context paramContext) {
    if (a == null)
      a = new f(paramContext); 
    return a;
  }
  
  public void a(int paramInt, b paramb) {
    (new a(paramInt, paramb)).execute((Object[])new Void[0]);
  }
  
  @SuppressLint({"StaticFieldLeak"})
  private class a extends AsyncTask<Void, Void, JSONArray> {
    private int b;
    
    private b c;
    
    private a(f this$0, int param1Int, b param1b) {
      this.b = param1Int;
      this.c = param1b;
    }
    
    private JSONArray a(ContentResolver param1ContentResolver, int param1Int) {
      JSONArray jSONArray = new JSONArray();
      Cursor cursor = param1ContentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id=" + param1Int, null, null);
      if (cursor != null) {
        while (cursor.moveToNext())
          jSONArray.put(cursor.getString(cursor.getColumnIndex("data1"))); 
        cursor.close();
      } 
      return jSONArray;
    }
    
    private JSONArray a(ContentResolver param1ContentResolver, int param1Int1, int param1Int2) {
      JSONArray jSONArray = new JSONArray();
      if (param1Int1 > 0) {
        Cursor cursor = param1ContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + param1Int2, null, null);
        if (cursor != null) {
          while (cursor.moveToNext())
            jSONArray.put(cursor.getString(cursor.getColumnIndex("data1"))); 
          cursor.close();
        } 
      } 
      return jSONArray;
    }
    
    private JSONArray b(ContentResolver param1ContentResolver, int param1Int) {
      JSONArray jSONArray = new JSONArray();
      Cursor cursor = param1ContentResolver.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, "contact_id=" + param1Int, null, null);
      if (cursor != null) {
        while (cursor.moveToNext())
          jSONArray.put(cursor.getString(cursor.getColumnIndex("data1"))); 
        cursor.close();
      } 
      return jSONArray;
    }
    
    private String c(ContentResolver param1ContentResolver, int param1Int) {
      Cursor cursor = param1ContentResolver.query(ContactsContract.Data.CONTENT_URI, null, "contact_id = ? AND mimetype = ?", new String[] { param1Int + "", "vnd.android.cursor.item/organization" }, null);
      String str2 = "";
      String str1 = "";
      StringBuilder stringBuilder = new StringBuilder();
      String str3 = str1;
      String str4 = str2;
      if (cursor != null) {
        str4 = str2;
        if (cursor.moveToFirst()) {
          str4 = cursor.getString(cursor.getColumnIndex("data1"));
          str1 = cursor.getString(cursor.getColumnIndex("data4"));
        } 
        cursor.close();
        str3 = str1;
      } 
      stringBuilder.append(str4).append(",").append(str3);
      return stringBuilder.toString();
    }
    
    protected JSONArray a(Void... param1VarArgs) {
      JSONArray jSONArray = new JSONArray();
      try {
        ContentResolver contentResolver = f.a(this.a).getContentResolver();
        if (PermissionHelper.a(f.a(this.a), "android.permission.READ_CONTACTS")) {
          Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
          if (cursor != null) {
            if (cursor.getCount() <= this.b || this.b == 0)
              this.b = cursor.getCount(); 
            for (byte b1 = 0; b1 < this.b; b1++) {
              cursor.moveToPosition(b1);
              JSONObject jSONObject = new JSONObject();
              this();
              int i = cursor.getInt(cursor.getColumnIndex("_id"));
              String str2 = cursor.getString(cursor.getColumnIndex("display_name"));
              int j = cursor.getInt(cursor.getColumnIndex("has_phone_number"));
              jSONObject.put("contact_id", i);
              String str1 = str2;
              if (LangHelper.isNullOrEmpty(str2))
                str1 = ""; 
              jSONObject.put("name", str1);
              jSONObject.put("phone", a(contentResolver, j, i));
              jSONObject.put("email", a(contentResolver, i));
              jSONObject.put("address", b(contentResolver, i));
              String[] arrayOfString = c(contentResolver, i).split(",");
              if (!LangHelper.isNullOrEmpty((Object[])arrayOfString)) {
                jSONObject.put("company", arrayOfString[0]);
                jSONObject.put("job_title", arrayOfString[1]);
              } 
              jSONArray.put(jSONObject);
            } 
            cursor.close();
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return jSONArray;
    }
    
    protected void a(JSONArray param1JSONArray) {
      super.onPostExecute(param1JSONArray);
      if (!LangHelper.isNullOrEmpty(param1JSONArray)) {
        this.c.a(param1JSONArray, 0);
        return;
      } 
      this.c.a(null, -1);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */