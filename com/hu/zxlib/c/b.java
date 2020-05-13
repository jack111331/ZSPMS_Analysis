package com.hu.zxlib.c;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class b {
  public static final Set<BarcodeFormat> a;
  
  static final Set<BarcodeFormat> b;
  
  static final Set<BarcodeFormat> c;
  
  static final Set<BarcodeFormat> d;
  
  static final Set<BarcodeFormat> e;
  
  static final Set<BarcodeFormat> f;
  
  static final Set<BarcodeFormat> g;
  
  private static final Pattern h = Pattern.compile(",");
  
  private static final Map<String, Set<BarcodeFormat>> i;
  
  static {
    d = EnumSet.of(BarcodeFormat.QR_CODE);
    e = EnumSet.of(BarcodeFormat.DATA_MATRIX);
    f = EnumSet.of(BarcodeFormat.AZTEC);
    g = EnumSet.of(BarcodeFormat.PDF_417);
    a = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[] { BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED });
    b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
    c = EnumSet.copyOf(a);
    c.addAll(b);
    i = new HashMap<String, Set<BarcodeFormat>>();
    i.put("ONE_D_MODE", c);
    i.put("PRODUCT_MODE", a);
    i.put("QR_CODE_MODE", d);
    i.put("DATA_MATRIX_MODE", e);
    i.put("AZTEC_MODE", f);
    i.put("PDF417_MODE", g);
  }
  
  public static Set<BarcodeFormat> a(Intent paramIntent) {
    String str = paramIntent.getStringExtra("SCAN_FORMATS");
    if (str != null) {
      List<String> list = Arrays.asList(h.split(str));
    } else {
      str = null;
    } 
    return a((Iterable<String>)str, paramIntent.getStringExtra("SCAN_MODE"));
  }
  
  public static Set<BarcodeFormat> a(Uri paramUri) {
    List<CharSequence> list1 = paramUri.getQueryParameters("SCAN_FORMATS");
    List<CharSequence> list2 = list1;
    if (list1 != null) {
      list2 = list1;
      if (list1.size() == 1) {
        list2 = list1;
        if (list1.get(0) != null)
          list2 = Arrays.asList(h.split(list1.get(0))); 
      } 
    } 
    return a((Iterable)list2, paramUri.getQueryParameter("SCAN_MODE"));
  }
  
  private static Set<BarcodeFormat> a(Iterable<String> paramIterable, String paramString) {
    if (paramIterable != null) {
      EnumSet<BarcodeFormat> enumSet = EnumSet.noneOf(BarcodeFormat.class);
      try {
        Iterator<String> iterator = paramIterable.iterator();
        while (iterator.hasNext())
          enumSet.add(BarcodeFormat.valueOf(iterator.next())); 
        return enumSet;
      } catch (IllegalArgumentException illegalArgumentException) {}
    } 
    return (paramString != null) ? i.get(paramString) : null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */