package com.hu.zxlib.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.Hashtable;
import java.util.Vector;

public class e extends Thread {
  private String a;
  
  private d b;
  
  private Bitmap c;
  
  public e(String paramString, d paramd) {
    this.a = paramString;
    this.b = paramd;
  }
  
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    while (true) {
      j >>= 1;
      if (j >= paramInt1) {
        i >>= 1;
        if (i >= paramInt2) {
          k <<= 1;
          continue;
        } 
      } 
      break;
    } 
    return k;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    options.inSampleSize = a(options, paramInt1, paramInt2);
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  public void run() {
    super.run();
    if (!TextUtils.isEmpty(this.a) && this.b != null) {
      Bitmap bitmap = a(this.a, 400, 400);
      MultiFormatReader multiFormatReader = new MultiFormatReader();
      Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>(2);
      Vector<BarcodeFormat> vector1 = new Vector();
      Vector<BarcodeFormat> vector2 = vector1;
      if (vector1.isEmpty()) {
        vector2 = new Vector();
        vector2.addAll(b.c);
        vector2.addAll(b.d);
        vector2.addAll(b.e);
      } 
      hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector2);
      multiFormatReader.setHints(hashtable);
      try {
        BinaryBitmap binaryBitmap = new BinaryBitmap();
        HybridBinarizer hybridBinarizer = new HybridBinarizer();
        a a = new a();
        this(bitmap);
        this(a);
        this((Binarizer)hybridBinarizer);
        Result result = multiFormatReader.decodeWithState(binaryBitmap);
        try {
          Log.i("解析结果", result.getText());
        } catch (Exception null) {}
      } catch (Exception exception) {
        vector2 = null;
      } 
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */