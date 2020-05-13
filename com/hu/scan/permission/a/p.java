package com.hu.scan.permission.a;

import android.database.Cursor;

public class p {
  public static void a(Cursor paramCursor) {
    if (paramCursor.getCount() > 0) {
      paramCursor.moveToFirst();
      int i = paramCursor.getType(0);
      if (i != 0 && i != 4)
        paramCursor.getString(0); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */