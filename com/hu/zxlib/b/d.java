package com.hu.zxlib.b;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

final class d {
  private static final String a = "d";
  
  private static final int b = 5;
  
  private static final int c = 30;
  
  private static final Pattern d = Pattern.compile(",");
  
  private final Context e;
  
  private Point f;
  
  private Point g;
  
  d(Context paramContext) {
    this.e = paramContext;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt) {
    String[] arrayOfString = d.split(paramCharSequence);
    int i = arrayOfString.length;
    byte b = 0;
    int j = 0;
    while (b < i) {
      paramCharSequence = arrayOfString[b].trim();
      try {
        double d1 = Double.parseDouble((String)paramCharSequence);
        int k = (int)(10.0D * d1);
        double d2 = paramInt;
        Double.isNaN(d2);
        int m = j;
        if (Math.abs(d2 - d1) < Math.abs(paramInt - j))
          m = k; 
        b++;
        j = m;
      } catch (NumberFormatException numberFormatException) {
        return paramInt;
      } 
    } 
    return j;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint) {
    Point point1;
    String str1 = paramParameters.get("preview-size-values");
    String str2 = str1;
    if (str1 == null)
      str2 = paramParameters.get("preview-size-value"); 
    paramParameters = null;
    if (str2 != null) {
      str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("preview-size-values parameter: ");
      stringBuilder.append(str2);
      Log.d(str1, stringBuilder.toString());
      point1 = a(str2, paramPoint);
    } 
    Point point2 = point1;
    if (point1 == null)
      point2 = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3); 
    return point2;
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint) {
    int n;
    int i1;
    String[] arrayOfString = d.split(paramCharSequence);
    int i = arrayOfString.length;
    byte b = 0;
    int j = 0;
    int k = 0;
    int m = Integer.MAX_VALUE;
    while (true) {
      StringBuilder stringBuilder;
      String str1;
      String str2;
      n = j;
      i1 = k;
      if (b < i) {
        str1 = arrayOfString[b].trim();
        i1 = str1.indexOf('x');
        if (i1 < 0) {
          str2 = a;
          paramCharSequence = new StringBuilder();
        } else {
          int i3;
          try {
            n = Integer.parseInt(str1.substring(0, i1));
            i1 = Integer.parseInt(str1.substring(i1 + 1));
            int i4 = Math.abs(n - paramPoint.x) + Math.abs(i1 - paramPoint.y);
            if (i4 == 0) {
              k = n;
              n = i1;
              i1 = k;
              break;
            } 
            i3 = m;
            if (i4 < m) {
              i3 = i4;
              j = i1;
              k = n;
            } 
          } catch (NumberFormatException numberFormatException) {
            str2 = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bad preview-size: ");
            stringBuilder.append(str1);
            Log.w(str2, stringBuilder.toString());
            i3 = m;
          } 
          b++;
          m = i3;
          continue;
        } 
      } else {
        break;
      } 
      stringBuilder.append("Bad preview-size: ");
      stringBuilder.append(str1);
      Log.w(str2, stringBuilder.toString());
      int i2 = m;
    } 
    return (i1 > 0 && n > 0) ? new Point(i1, n) : null;
  }
  
  private void a(Camera.Parameters paramParameters) {
    String str1 = paramParameters.get("zoom-supported");
    if (str1 != null && !Boolean.parseBoolean(str1))
      return; 
    int i = 5;
    str1 = paramParameters.get("max-zoom");
    int j = i;
    if (str1 != null)
      try {
        double d1 = Double.parseDouble(str1);
        int m = (int)(d1 * 10.0D);
        j = i;
        if (5 > m)
          j = m; 
      } catch (NumberFormatException numberFormatException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad max-zoom: ");
        stringBuilder.append(str1);
        Log.w(str, stringBuilder.toString());
        j = i;
      }  
    String str2 = paramParameters.get("taking-picture-zoom-max");
    int k = j;
    if (str2 != null)
      try {
        i = Integer.parseInt(str2);
        k = j;
        if (j > i)
          k = i; 
      } catch (NumberFormatException numberFormatException) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad taking-picture-zoom-max: ");
        stringBuilder.append(str2);
        Log.w(str, stringBuilder.toString());
        k = j;
      }  
    String str3 = paramParameters.get("mot-zoom-values");
    j = k;
    if (str3 != null)
      j = a(str3, k); 
    String str4 = paramParameters.get("mot-zoom-step");
    k = j;
    if (str4 != null)
      try {
        i = (int)(Double.parseDouble(str4.trim()) * 10.0D);
        k = j;
        if (i > 1)
          k = j - j % i; 
      } catch (NumberFormatException numberFormatException) {
        k = j;
      }  
    if (str1 != null || str3 != null) {
      double d1 = k;
      Double.isNaN(d1);
      paramParameters.set("zoom", String.valueOf(d1 / 10.0D));
    } 
    if (str2 != null)
      paramParameters.set("taking-picture-zoom", k); 
  }
  
  public static int c() {
    return 30;
  }
  
  Point a() {
    return this.g;
  }
  
  void a(Camera paramCamera) {
    Camera.Parameters parameters = paramCamera.getParameters();
    Display display = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
    this.f = new Point(display.getWidth(), display.getHeight());
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Screen resolution: ");
    stringBuilder.append(this.f);
    Log.d(str, stringBuilder.toString());
    Point point = new Point();
    point.x = this.f.x;
    point.y = this.f.y;
    if (this.f.x < this.f.y) {
      point.x = this.f.y;
      point.y = this.f.x;
    } 
    this.g = a(parameters, point);
  }
  
  Point b() {
    return this.f;
  }
  
  void b(Camera paramCamera) {
    Camera.Parameters parameters = paramCamera.getParameters();
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Setting preview size: ");
    stringBuilder.append(this.g);
    Log.d(str, stringBuilder.toString());
    parameters.setPreviewSize(this.g.x, this.g.y);
    a(parameters);
    paramCamera.setDisplayOrientation(90);
    paramCamera.setParameters(parameters);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */