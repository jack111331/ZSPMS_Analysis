package org.jar.photo.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class b {
  public static void a(Activity paramActivity, Handler paramHandler, int paramInt) {
    (new Thread(new c(paramActivity, paramInt, paramHandler))).start();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, ImageView paramImageView, Uri paramUri) {
    Picasso.with(paramContext).load(paramUri).resize(paramInt1, paramInt2).priority(Picasso.Priority.HIGH).centerInside().into(paramImageView);
  }
  
  public static void a(Context paramContext, int paramInt, Drawable paramDrawable, ImageView paramImageView, Uri paramUri) {
    Picasso.with(paramContext).load(paramUri).placeholder(paramDrawable).resize(paramInt, paramInt).centerCrop().into(paramImageView);
  }
  
  public static void a(Context paramContext, String paramString, Handler paramHandler, int paramInt) {
    (new Thread(new d(paramString, paramContext, paramInt, paramHandler))).start();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */