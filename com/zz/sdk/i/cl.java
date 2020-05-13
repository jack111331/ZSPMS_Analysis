package com.zz.sdk.i;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cl extends ContentObserver {
  private Context a;
  
  private Handler b;
  
  private String c;
  
  public cl(Context paramContext, Handler paramHandler) {
    super(paramHandler);
    this.a = paramContext;
    this.b = paramHandler;
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri) {
    try {
      paramUri = Uri.parse("content://sms/inbox");
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str = stringBuilder.append("date >").append(System.currentTimeMillis() - 120000L).toString();
      Cursor cursor = this.a.getContentResolver().query(paramUri, new String[] { "_id", "address", "read", "body" }, str, null, "date desc");
      if (cursor != null) {
        if (cursor.moveToFirst()) {
          str = cursor.getString(cursor.getColumnIndex("body"));
          Matcher matcher = Pattern.compile("(\\d{4})").matcher(str);
          if (matcher.find()) {
            this.c = matcher.group(0);
            this.b.obtainMessage(1, this.c).sendToTarget();
          } 
        } 
        cursor.close();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */