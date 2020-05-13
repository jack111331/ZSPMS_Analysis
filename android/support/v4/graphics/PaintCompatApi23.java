package android.support.v4.graphics;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class PaintCompatApi23 {
  static boolean hasGlyph(@NonNull Paint paramPaint, @NonNull String paramString) {
    return paramPaint.hasGlyph(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\graphics\PaintCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */