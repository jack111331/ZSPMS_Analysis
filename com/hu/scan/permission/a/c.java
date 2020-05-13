package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.a.af;
import java.util.TimeZone;

class c implements o {
  private static final String a = "PERMISSION";
  
  private static final String b = "permission@gmail.com";
  
  private ContentResolver c;
  
  c(Context paramContext) {
    this.c = paramContext.getContentResolver();
  }
  
  @af(b = 14)
  public boolean a() {
    try {
      boolean bool;
      TimeZone timeZone = TimeZone.getDefault();
      ContentValues contentValues = new ContentValues();
      this();
      contentValues.put("name", "PERMISSION");
      contentValues.put("account_name", "permission@gmail.com");
      contentValues.put("account_type", "LOCAL");
      contentValues.put("calendar_displayName", "PERMISSION");
      contentValues.put("visible", Integer.valueOf(1));
      contentValues.put("calendar_color", Integer.valueOf(-16776961));
      contentValues.put("calendar_access_level", Integer.valueOf(700));
      contentValues.put("sync_events", Integer.valueOf(1));
      contentValues.put("calendar_timezone", timeZone.getID());
      contentValues.put("ownerAccount", "PERMISSION");
      contentValues.put("canOrganizerRespond", Integer.valueOf(0));
      Uri uri1 = CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "PERMISSION").appendQueryParameter("account_type", "LOCAL").build();
      long l = ContentUris.parseId(this.c.insert(uri1, contentValues));
      if (l > 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    } finally {
      Uri uri = CalendarContract.Calendars.CONTENT_URI.buildUpon().build();
      this.c.delete(uri, "account_name=?", new String[] { "permission@gmail.com" });
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */