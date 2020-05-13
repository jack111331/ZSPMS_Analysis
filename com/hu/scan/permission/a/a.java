package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract;
import android.support.a.af;
import android.text.TextUtils;

class a implements o {
  private ContentResolver a;
  
  a(Context paramContext) {
    this.a = paramContext.getContentResolver();
  }
  
  @af(b = 14)
  public boolean a() {
    boolean bool = true;
    try {
      Uri uri = VoicemailContract.Voicemails.CONTENT_URI;
      ContentValues contentValues = new ContentValues();
      this();
      contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
      contentValues.put("number", "1");
      contentValues.put("duration", Integer.valueOf(1));
      contentValues.put("source_package", "permission");
      contentValues.put("source_data", "permission");
      contentValues.put("is_read", Integer.valueOf(0));
      long l = ContentUris.parseId(this.a.insert(uri, contentValues));
      int i = this.a.delete(uri, "_id=?", new String[] { Long.toString(l) });
      if (i <= 0)
        bool = false; 
      return bool;
    } catch (Exception exception) {
      String str = exception.getMessage();
      return !TextUtils.isEmpty(str) ? (true ^ str.toLowerCase().contains("add_voicemail")) : false;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */