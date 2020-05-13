package com.zz.a.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

class i {
  private static final String a = "session";
  
  private static final String b = "user_id";
  
  private static final String c = "user_name";
  
  private static final String d = "password";
  
  private static final String e = "email";
  
  private static final String f = "money";
  
  private static final String g = "auto_login";
  
  private static final String h = "last_login_time";
  
  private static i j;
  
  private SQLiteDatabase i;
  
  private i(Context paramContext) {
    try {
      j j = new j();
      this(this, paramContext);
      this.i = j.getWritableDatabase();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private f a(Cursor paramCursor) {
    f f = new f();
    f.a = paramCursor.getInt(paramCursor.getColumnIndex("user_id"));
    f.b = l.c(paramCursor.getString(paramCursor.getColumnIndex("user_name")));
    f.c = l.c(paramCursor.getString(paramCursor.getColumnIndex("password")));
    f.e = paramCursor.getInt(paramCursor.getColumnIndex("money"));
    f.d = paramCursor.getString(paramCursor.getColumnIndex("email"));
    f.f = paramCursor.getInt(paramCursor.getColumnIndex("auto_login"));
    f.j = paramCursor.getLong(paramCursor.getColumnIndex("last_login_time"));
    return f;
  }
  
  public static i a(Context paramContext) {
    if (j == null)
      j = new i(paramContext); 
    return j;
  }
  
  private ContentValues b(f paramf) {
    if (paramf == null)
      return null; 
    ContentValues contentValues = new ContentValues();
    contentValues.put("user_id", Integer.valueOf(paramf.a));
    contentValues.put("user_name", l.b(paramf.b));
    contentValues.put("password", l.b(paramf.c));
    contentValues.put("money", Double.valueOf(paramf.e));
    contentValues.put("email", paramf.d);
    contentValues.put("auto_login", Integer.valueOf(paramf.f));
    contentValues.put("last_login_time", Long.valueOf(System.currentTimeMillis()));
    return contentValues;
  }
  
  private f b(Cursor paramCursor) {
    f f = new f();
    f.b = l.c(paramCursor.getString(paramCursor.getColumnIndex("user_name")));
    f.c = l.c(paramCursor.getString(paramCursor.getColumnIndex("password")));
    return f;
  }
  
  public f a() {
    return a("auto_login=?", new String[] { "1" });
  }
  
  public f a(String paramString) {
    return (paramString == null) ? null : a("user_name=?", new String[] { paramString });
  }
  
  public f a(String paramString, String[] paramArrayOfString) {
    f f;
    String str1 = null;
    String str2 = null;
    if (this.i == null)
      return (f)str2; 
    Cursor cursor = this.i.query("session", null, paramString, paramArrayOfString, null, null, "last_login_time desc ");
    paramString = str1;
    if (cursor.moveToFirst()) {
      paramString = str1;
      if (!cursor.isAfterLast())
        f = a(cursor); 
    } 
    cursor.close();
    return f;
  }
  
  public boolean a(f paramf) {
    boolean bool1 = true;
    boolean bool2 = false;
    null = bool2;
    if (paramf != null) {
      if (this.i == null)
        return bool2; 
    } else {
      return null;
    } 
    String str1 = l.b(paramf.b);
    String str2 = l.b(paramf.c);
    if (paramf.k != null) {
      b(str1);
    } else if (a(str1, str2)) {
      return bool2;
    } 
    ContentValues contentValues = b(paramf);
    long l1 = this.i.update("session", contentValues, "user_name=?", new String[] { str1 });
    long l2 = l1;
    if (l1 <= 0L)
      l2 = this.i.insert("session", null, contentValues); 
    return (l2 > 0L) ? bool1 : false;
  }
  
  public boolean a(String paramString1, String paramString2) {
    return (this.i == null) ? false : ((this.i.query("session", null, "user_name=?", new String[] { paramString1 }, null, null, "last_login_time desc ").getCount() < 1) ? false : (paramString2.equals((a(paramString1)).c)));
  }
  
  public List b() {
    ArrayList<f> arrayList1 = null;
    Cursor cursor = this.i.query(true, "session", new String[] { "user_name", "password" }, null, null, null, null, null, null);
    ArrayList<f> arrayList2 = new ArrayList();
    if (cursor.moveToFirst())
      while (!cursor.isAfterLast()) {
        arrayList2.add(b(cursor));
        cursor.moveToNext();
      }  
    cursor.close();
    if (arrayList2.size() > 0)
      arrayList1 = arrayList2; 
    return arrayList1;
  }
  
  public boolean b(String paramString) {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.i == null)
      return bool2; 
    if (this.i.delete("session", "user_name=?", new String[] { paramString }) <= 0)
      bool1 = false; 
    return bool1;
  }
  
  public f[] c() {
    null = this.i.query("session", null, null, null, null, null, "last_login_time desc ");
    ArrayList<f> arrayList = new ArrayList();
    if (null.moveToFirst())
      while (!null.isAfterLast()) {
        arrayList.add(a(null));
        null.moveToNext();
      }  
    null.close();
    return (arrayList.size() > 0) ? arrayList.<f>toArray(new f[arrayList.size()]) : null;
  }
  
  public List d() {
    ArrayList<f> arrayList1 = null;
    Cursor cursor = this.i.query("session", null, null, null, null, null, "last_login_time desc ");
    ArrayList<f> arrayList2 = new ArrayList();
    if (cursor.moveToFirst())
      while (!cursor.isAfterLast()) {
        arrayList2.add(a(cursor));
        cursor.moveToNext();
      }  
    cursor.close();
    if (arrayList2.size() > 0)
      arrayList1 = arrayList2; 
    return arrayList1;
  }
  
  public boolean e() {
    boolean bool = false;
    if (this.i != null && this.i.delete("session", null, null) > 0)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */