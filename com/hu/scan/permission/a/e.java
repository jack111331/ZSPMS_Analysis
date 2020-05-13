package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog;
import android.support.a.ag;

class e implements o {
  private ContentResolver a;
  
  e(Context paramContext) {
    this.a = paramContext.getContentResolver();
  }
  
  @ag(a = "android.permission.WRITE_CALL_LOG")
  public boolean a() {
    try {
      boolean bool;
      ContentValues contentValues = new ContentValues();
      this();
      contentValues.put("type", Integer.valueOf(1));
      contentValues.put("number", "1");
      contentValues.put("date", Integer.valueOf(20080808));
      contentValues.put("new", "0");
      long l = ContentUris.parseId(this.a.insert(CallLog.Calls.CONTENT_URI, contentValues));
      if (l > 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } finally {
      this.a.delete(CallLog.Calls.CONTENT_URI, "number=?", new String[] { "1" });
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */