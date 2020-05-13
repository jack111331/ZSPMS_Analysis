package com.zz.sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.text.SimpleDateFormat;

class b {
  protected j a;
  
  protected SQLiteDatabase b;
  
  protected boolean c;
  
  protected SimpleDateFormat d;
  
  protected Context e;
  
  @SuppressLint({"SimpleDateFormat"})
  public b(Context paramContext) {
    this.e = paramContext;
    this.d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.a = new j(paramContext, "zzsdk.db", null, 3);
    try {
      this.b = this.a.getWritableDatabase();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5) {
    return this.b.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    return this.b.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean a() {
    return this.c;
  }
  
  public void b() {
    if (!this.c)
      try {
        if (this.a != null)
          this.a.close(); 
        if (this.b != null)
          this.b.close(); 
        this.c = true;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */