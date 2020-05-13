package com.hu.scan.permission.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;

class j implements o {
  private static final String a = "PERMISSION";
  
  private ContentResolver b;
  
  j(ContentResolver paramContentResolver) {
    this.b = paramContentResolver;
  }
  
  private void a(long paramLong1, long paramLong2) {
    this.b.delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[] { Long.toString(paramLong1) });
    this.b.delete(ContactsContract.Data.CONTENT_URI, "_id=?", new String[] { Long.toString(paramLong2) });
  }
  
  private boolean a(long paramLong) {
    boolean bool;
    ContentValues contentValues = new ContentValues();
    contentValues.put("raw_contact_id", Long.valueOf(paramLong));
    contentValues.put("data1", "PERMISSION");
    contentValues.put("data2", "PERMISSION");
    contentValues.put("mimetype", "vnd.android.cursor.item/name");
    if (ContentUris.parseId(this.b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean b() {
    boolean bool;
    ContentValues contentValues = new ContentValues();
    contentValues.put("raw_contact_id", Long.valueOf(ContentUris.parseId(this.b.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues))));
    contentValues.put("data1", "PERMISSION");
    contentValues.put("data2", "PERMISSION");
    contentValues.put("mimetype", "vnd.android.cursor.item/name");
    if (ContentUris.parseId(this.b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean a() {
    Cursor cursor = this.b.query(ContactsContract.Data.CONTENT_URI, new String[] { "raw_contact_id" }, "mimetype=? and data1=?", new String[] { "vnd.android.cursor.item/name", "PERMISSION" }, null);
    if (cursor != null) {
      if (cursor.moveToFirst()) {
        long l = cursor.getLong(0);
        cursor.close();
        return a(l);
      } 
      cursor.close();
      return b();
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */