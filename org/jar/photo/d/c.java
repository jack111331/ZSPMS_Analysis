package org.jar.photo.d;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import java.util.ArrayList;
import org.jar.photo.bean.b;

final class c implements Runnable {
  c(Activity paramActivity, int paramInt, Handler paramHandler) {}
  
  public void run() {
    String str2;
    ArrayList<b> arrayList = new ArrayList();
    ContentResolver contentResolver = this.a.getContentResolver();
    String str1 = null;
    b b = null;
    try {
      Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "_data", "bucket_id", "bucket_display_name", "COUNT(1) AS count" }, "0==0) GROUP BY (bucket_id", null, "date_modified");
      if (cursor != null)
        try {
          if (cursor.moveToFirst()) {
            int i = cursor.getColumnIndex("_data");
            int j = cursor.getColumnIndex("_id");
            int k = cursor.getColumnIndex("bucket_display_name");
            int m = cursor.getColumnIndex("count");
            do {
              b = new b();
              this();
              b.a = cursor.getString(i);
              b.e = cursor.getInt(j);
              b.b = cursor.getInt(m);
              str1 = cursor.getString(k);
              b.c = str1;
              if (Environment.getExternalStorageDirectory().getPath().contains(str1))
                continue; 
              arrayList.add(0, b);
            } while (cursor.moveToNext());
          } 
        } catch (Exception exception) {
        
        } finally {} 
      Message message = new Message();
      this();
      message.what = this.b;
    } catch (Exception exception) {
      String str = str1;
    } finally {
      String str4;
      contentResolver = null;
      String str3 = str2;
      ContentResolver contentResolver1 = contentResolver;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */