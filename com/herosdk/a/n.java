package com.herosdk.a;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.herosdk.b.a;
import com.herosdk.d.au;
import com.herosdk.d.az;
import com.herosdk.d.r;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ICommonListener;
import com.herosdk.widget.FancyButton;
import java.util.Map;
import java.util.regex.Pattern;

public class n extends a implements View.OnClickListener {
  private static int A = 0;
  
  public static final String[] n;
  
  static final String o = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";
  
  private static String p = "frameLib.nrnd";
  
  private static final float q = 480.0F;
  
  private static final float r = 400.0F;
  
  private static final float s = 650.0F;
  
  private static int z;
  
  private FancyButton t;
  
  private String u;
  
  private String v;
  
  private EditText w;
  
  private EditText x;
  
  private ICommonListener y = null;
  
  static {
    n = new String[] { "请填写真实有效的姓名", "请输入有效的身份证号", "抱歉，实名认证需要18岁以上", "身份证号不能为空" };
  }
  
  public n(Activity paramActivity) {
    this(paramActivity, au.j((Context)paramActivity, "HuThemeCustomDialog"));
  }
  
  public n(Activity paramActivity, int paramInt) {
    super(paramActivity, paramInt);
  }
  
  private void C() {
    try {
      Log.d(p, "RND tARN");
      this.u = this.w.getText().toString().trim();
      Pair<Boolean, String> pair = c(this.u);
      if (!((Boolean)pair.first).booleanValue()) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        a(stringBuilder.append((String)pair.second).append("").toString());
        return;
      } 
      this.v = this.x.getText().toString().trim();
      pair = b(this.v);
      if (!((Boolean)pair.first).booleanValue()) {
        a((CharSequence)pair.second);
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    r.a().a((Context)this.a);
    a a1 = a.a();
    Activity activity = this.a;
    String str1 = this.u;
    String str2 = this.v;
    q q = new q();
    this(this);
    a1.a((Context)activity, str1, str2, q);
  }
  
  public static int a(float paramFloat1, float paramFloat2) {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static int a(Context paramContext, int paramInt) {
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    return a(paramInt, f);
  }
  
  public static Pair<Boolean, String> b(String paramString) {
    boolean bool = false;
    String str = paramString;
    if (paramString != null)
      str = paramString.trim(); 
    if (str == null || str.length() == 0) {
      paramString = n[3];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    if (!str.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$")) {
      paramString = n[1];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = null;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static Pair<Boolean, String> c(String paramString) {
    boolean bool = false;
    String str1 = null;
    String str2 = paramString;
    if (paramString != null)
      str2 = paramString.trim(); 
    if (str2 == null || str2.length() < 2 || str2.length() > 10 || !d(str2)) {
      paramString = n[0];
      return new Pair(Boolean.valueOf(bool), paramString);
    } 
    bool = true;
    paramString = str1;
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static boolean d(String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      if ("".equals(paramString.trim()))
        return bool1; 
    } else {
      return bool2;
    } 
    char[] arrayOfChar = paramString.toCharArray();
    byte b = 0;
    while (true) {
      bool2 = bool1;
      if (b < arrayOfChar.length) {
        if (Pattern.matches("[一-龥]", String.valueOf(arrayOfChar[b])))
          return true; 
        b++;
        continue;
      } 
      return bool2;
    } 
  }
  
  public int A() {
    float f1 = 1.0F;
    if (z > 0)
      return z; 
    float f2 = 480.0F / this.l.densityDpi;
    if (f2 > 1.0F)
      f2 = f1; 
    null = Math.min(this.l.widthPixels, this.l.heightPixels);
    z = Math.min((int)((f2 * null) * 0.9D), a(400.0F));
    if (z > null)
      z = null; 
    return z;
  }
  
  public int a() {
    float f1 = 1.0F;
    if (A > 0)
      return A; 
    float f2 = 480.0F / this.l.densityDpi;
    if (f2 <= 1.0F)
      f1 = f2; 
    null = Math.min(this.l.widthPixels, this.l.heightPixels);
    A = Math.min((int)((f1 * null) * 0.8D), a(650.0F));
    if (A > null)
      A = null; 
    return A;
  }
  
  public void a(Map<String, Object> paramMap) {
    super.a(paramMap);
    try {
      Log.d(p, "RND iD");
      this.y = a("key_callback", (ICommonListener)null);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  protected void b() {
    try {
      f.d(this.a);
      if (this.y != null) {
        Log.d(p, "RND oCC...if");
        this.y.onSuccess(1084567, "close dialog success");
        return;
      } 
      Log.d(p, "RND oCC...else");
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  void i() {
    try {
      Log.d(p, "RND iV");
      az.a = Boolean.valueOf(true);
      setTitle("实名制信息登记");
      this.w = (EditText)findViewById(au.g((Context)this.a, "huat_editTextName"));
      this.x = (EditText)findViewById(au.g((Context)this.a, "huat_editTextCardNum"));
      this.t = (FancyButton)findViewById(au.g((Context)this.a, "huat_btn_confirm"));
      FancyButton fancyButton = this.t;
      o o = new o();
      this(this);
      fancyButton.setOnClickListener(o);
      View view = findViewById(au.g((Context)this.a, "huat_img_close"));
      p p = new p();
      this(this);
      view.setOnClickListener(p);
      ((TextView)findViewById(au.g((Context)this.a, "huat_realname_tip"))).setText((CharSequence)Html.fromHtml(this.a.getString(au.d((Context)this.a, "hus_float_gift_realname_tip"))));
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  int j() {
    return au.h((Context)this.a, "hu_dialog_anti_addiction");
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView) {}
  
  public void q() {
    super.q();
    Log.d(p, "RND onD");
    az.a = Boolean.valueOf(false);
  }
  
  public void show() {
    super.show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */