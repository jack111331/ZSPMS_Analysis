package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.a.af;
import android.support.a.ag;

class b implements o {
  private ContentResolver a;
  
  b(Context paramContext) {
    this.a = paramContext.getContentResolver();
  }
  
  @af(a = 14)
  @ag(a = "android.permission.READ_CALENDAR")
  public boolean a() {
    Cursor cursor = this.a.query(CalendarContract.Calendars.CONTENT_URI, new String[] { "_id", "name" }, null, null, null);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */