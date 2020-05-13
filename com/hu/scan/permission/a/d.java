package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.a.ag;

class d implements o {
  private ContentResolver a;
  
  d(Context paramContext) {
    this.a = paramContext.getContentResolver();
  }
  
  @ag(a = "android.permission.READ_CALL_LOG")
  public boolean a() {
    Cursor cursor = this.a.query(CallLog.Calls.CONTENT_URI, new String[] { "_id", "number", "type" }, null, null, null);
    if (cursor != null)
      try {
        p.a(cursor);
        return true;
      } finally {
        cursor.close();
      }  
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */