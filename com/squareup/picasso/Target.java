package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface Target {
  void onBitmapFailed(Drawable paramDrawable);
  
  void onBitmapLoaded(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  void onPrepareLoad(Drawable paramDrawable);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\squareup\picasso\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */