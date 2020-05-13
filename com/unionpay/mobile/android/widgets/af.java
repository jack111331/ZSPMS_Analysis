package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class af extends aa {
  private TextWatcher c = new ag(this);
  
  private ArrayList<a> o = null;
  
  public af(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    super(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
    this.b.a(this.c);
    this.b.a((InputFilter)new InputFilter.LengthFilter(23));
    this.b.a(2);
    if (this.i)
      this.b.setEnabled(false); 
    JSONArray jSONArray = j.d(paramJSONObject, "regex");
    if (jSONArray != null) {
      paramInt = bool;
      if (this.o == null) {
        this.o = new ArrayList<a>();
        paramInt = bool;
      } 
      while (paramInt < jSONArray.length()) {
        JSONObject jSONObject = (JSONObject)j.b(jSONArray, paramInt);
        if (jSONObject != null)
          this.o.add(new a(this, jSONObject)); 
        paramInt++;
      } 
    } 
  }
  
  private static boolean b(String paramString) {
    int i = paramString.length();
    char c = Character.MIN_VALUE;
    int j = i - 2;
    int k = 0;
    while (j >= 0) {
      int m = paramString.charAt(j) - 48;
      int n = m;
      if (c % 2 == 0) {
        n = m * 2;
        n = n % 10 + n / 10;
      } 
      k += n;
      j--;
      c++;
    } 
    if (k % 10 == 0) {
      c = '0';
    } else {
      c = (char)(10 - k % 10 + 48);
    } 
    return (c == paramString.charAt(i - 1));
  }
  
  public final String a() {
    if (this.i) {
      String str1 = i();
      return str1.replace(" ", "");
    } 
    String str = this.b.b();
    return str.replace(" ", "");
  }
  
  public final boolean b() {
    boolean bool = true;
    if (this.i)
      return bool; 
    String str = a();
    if (this.o != null && this.o.size() > 0) {
      byte b = 0;
      boolean bool1 = false;
      while (b < this.o.size()) {
        a a = this.o.get(b);
        if (a.a() != null)
          bool1 = str.matches(a.a()); 
        if (bool1)
          return a.c() ? b(a.b() + str) : ((13 <= str.length() && 19 >= str.length())); 
        b++;
      } 
    } 
    if (13 <= str.length() && 19 >= str.length()) {
      boolean bool1 = bool;
      return !b(str) ? false : bool1;
    } 
    return false;
  }
  
  protected final String d() {
    return "_input_cardNO";
  }
  
  final class a {
    private String b = null;
    
    private String c = null;
    
    private String d = null;
    
    public a(af this$0, JSONObject param1JSONObject) {
      this.b = j.a(param1JSONObject, "pattern");
      this.c = j.a(param1JSONObject, "prefix");
      this.d = j.a(param1JSONObject, "isCheck");
    }
    
    public final String a() {
      return this.b;
    }
    
    public final String b() {
      return this.c;
    }
    
    public final boolean c() {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (this.d != null) {
        bool2 = bool1;
        if ("false".equalsIgnoreCase(this.d))
          bool2 = false; 
      } 
      return bool2;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */