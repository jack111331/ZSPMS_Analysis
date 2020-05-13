package org.jar.photo.d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;
import org.jar.bloc.utils.ae;
import org.jar.photo.bean.EntityVideo;

public class e {
  private static Cursor a;
  
  private static Cursor b;
  
  private static MediaMetadataRetriever c = new MediaMetadataRetriever();
  
  public static String a(long paramLong) {
    String str;
    long l = 86400000L;
    Throwable throwable1 = null;
    try {
      StringBuilder stringBuilder1;
      paramLong -= paramLong / l * l;
      l = 3600000L;
      long l1 = paramLong - paramLong / l * l;
      l = 60000L;
      paramLong = l1 / l;
      l = (l1 - l * paramLong) / 1000L;
      if (paramLong < 10L) {
        stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("0");
        stringBuilder1.append(paramLong);
      } else {
        stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("");
        stringBuilder1.append(paramLong);
      } 
      str = stringBuilder1.toString();
      if (l < 10L) {
        try {
          StringBuilder stringBuilder2 = new StringBuilder();
          this();
          stringBuilder2.append("0");
          stringBuilder2.append(l);
          String str1 = stringBuilder2.toString();
        } catch (Throwable null) {
          throwable2.printStackTrace();
          throwable2 = throwable1;
        } 
      } else {
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append("");
        stringBuilder2.append(l);
        String str1 = stringBuilder2.toString();
      } 
    } catch (Throwable throwable2) {
      str = null;
      throwable2.printStackTrace();
      throwable2 = throwable1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" : ");
    stringBuilder.append((String)throwable2);
    return stringBuilder.toString();
  }
  
  public static List<EntityVideo> a(Context paramContext) {
    ArrayList<EntityVideo> arrayList = new ArrayList();
    a = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "duration" }, null, null, null);
    if (a == null)
      return arrayList; 
    if (a.moveToFirst())
      while (true) {
        EntityVideo entityVideo = new EntityVideo();
        int i = a.getInt(a.getColumnIndex("_id"));
        ContentResolver contentResolver = paramContext.getContentResolver();
        Uri uri = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("video_id=");
        stringBuilder.append(i);
        String str = stringBuilder.toString();
        b = contentResolver.query(uri, new String[] { "_data", "video_id" }, str, null, null);
        if (b == null)
          return null; 
        if (b.moveToFirst())
          entityVideo.b(b.getString(b.getColumnIndex("_data"))); 
        b.close();
        entityVideo.c(a.getString(a.getColumnIndexOrThrow("_data")));
        entityVideo.a(a.getInt(a.getColumnIndexOrThrow("duration")));
        entityVideo.a(a.getString(a.getColumnIndexOrThrow("_id")));
        if (ae.e(entityVideo.b()))
          arrayList.add(entityVideo); 
        if (!a.moveToNext()) {
          a.close();
          break;
        } 
      }  
    return arrayList;
  }
  
  public static void a() {
    try {
      if (b != null)
        b.close(); 
      if (a != null)
        a.close(); 
      b = null;
      a = null;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */