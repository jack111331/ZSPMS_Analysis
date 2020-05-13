package org.jar.photo.d;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.jar.photo.b.a;
import org.jar.photo.bean.b;

final class d implements Runnable {
  d(String paramString, Context paramContext, int paramInt, Handler paramHandler) {}
  
  public void run() {
    String str1;
    ArrayList<b> arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_data like'");
    stringBuilder.append(this.a);
    stringBuilder.append("/%'");
    String str2 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("galleryPath:");
    stringBuilder.append(this.a);
    Log.i("queryGalleryPicture", stringBuilder.toString());
    List<b> list = a.a().c();
    String str3 = null;
    stringBuilder = null;
    try {
      Cursor cursor = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data" }, str2, null, null);
      if (cursor != null)
        try {
          if (cursor.getCount() > 0 && cursor.moveToFirst())
            do {
              str3 = cursor.getString(cursor.getColumnIndex("_data"));
              int i = cursor.getInt(cursor.getColumnIndex("_id"));
              b b = new b();
              this();
              b.a = str3;
              b.e = i;
              int j = list.size();
              for (i = 0; i < j; i++) {
                if (((b)list.get(i)).a.equals(b.a)) {
                  b.d = ((b)list.get(i)).d;
                  list.remove(i);
                  list.add(b);
                  break;
                } 
              } 
              arrayList.add(0, b);
            } while (cursor.moveToNext()); 
        } catch (Exception exception) {
        
        } finally {} 
      Message message = new Message();
      this();
      message.what = this.c;
    } catch (Exception exception) {
      str2 = str3;
    } finally {
      str2 = null;
      String str = str1;
      str1 = str2;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */