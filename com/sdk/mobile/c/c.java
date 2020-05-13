package com.sdk.mobile.c;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sdk.mobile.manager.login.a.d;
import com.sdk.mobile.manager.login.a.e;
import com.sdk.mobile.manager.login.a.f;
import com.sdk.mobile.manager.login.a.g;
import com.sdk.mobile.manager.login.a.h;
import com.sdk.mobile.manager.login.a.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c {
  private static final String a = c.class.getSimpleName();
  
  private com.sdk.mobile.manager.login.b b;
  
  private HashMap<String, View> c;
  
  public c(com.sdk.mobile.manager.login.b paramb, HashMap<String, View> paramHashMap) {
    this.b = paramb;
    this.c = paramHashMap;
  }
  
  private void a(View paramView, int paramInt) {
    try {
      ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams();
      this(paramView.getLayoutParams());
      marginLayoutParams.setMargins(marginLayoutParams.leftMargin, paramInt, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams();
      this(marginLayoutParams);
      paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } catch (Throwable throwable) {
      com.sdk.base.framework.utils.f.b.c(a, "设置控件位置异常！\n" + throwable, Boolean.valueOf(com.sdk.base.framework.c.c.h));
    } 
  }
  
  public void a() {
    if (this.b != null && this.c != null) {
      b b1 = new b(this);
      a a = new a(this);
      Iterator<Map.Entry> iterator = this.c.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          byte b2;
          Map.Entry entry = iterator.next();
          String str = (String)entry.getKey();
          View view = (View)entry.getValue();
          switch (str.hashCode()) {
            default:
              b2 = -1;
              switch (b2) {
                case 0:
                  b1.a(view);
                  break;
                case 1:
                  b1.b(view);
                  break;
                case 2:
                  b1.c(view);
                  break;
                case 3:
                  b1.d(view);
                  break;
                case 4:
                  b1.e(view);
                  break;
                case 5:
                  b1.f(view);
                  break;
                case 6:
                  b1.g(view);
                  break;
                case 7:
                  b1.h(view);
                  break;
                case 8:
                  a.a(view);
                  break;
                case 9:
                  a.b(view);
                  break;
                case 10:
                  a.c(view);
                  break;
                case 11:
                  a.d(view);
                  break;
                case 12:
                  a.e(view);
                  break;
                case 13:
                  a.f(view);
                  break;
                case 14:
                  a.g(view);
                  break;
                case 15:
                  break;
              } 
              continue;
            case 1167648233:
            
            case 93997959:
            
            case 1391295940:
            
            case 1122498131:
            
            case 437703617:
            
            case 171412328:
            
            case -989163880:
            
            case -1361230470:
            
            case 1637776060:
            
            case -786964134:
            
            case 14527767:
            
            case 112936486:
            
            case -951993196:
            
            case -1017100101:
            
            case 161362923:
            
            case -879318579:
            
          } 
          continue;
        } 
        return;
        a.h((View)SYNTHETIC_LOCAL_VARIABLE_4);
      } 
    } 
  }
  
  public class a {
    public a(c this$0) {}
    
    void a(View param1View) {
      com.sdk.mobile.manager.login.a.a a1 = c.a(this.a).f();
      if (a1 != null) {
        TextView textView = (TextView)param1View;
        if (a1.a()) {
          i = 0;
        } else {
          i = 8;
        } 
        textView.setVisibility(i);
        c.a(this.a, (View)textView, a1.c());
        int i = a1.b();
        if (i != 0)
          textView.setTextColor(i); 
        i = a1.d();
        if (i != 0)
          textView.setTextSize(i); 
        textView.getPaint().setFakeBoldText(a1.e());
      } 
    }
    
    void b(View param1View) {
      com.sdk.mobile.manager.login.a.b b = c.a(this.a).g();
      if (b != null) {
        TextView textView = (TextView)param1View;
        if (b.c()) {
          i = 0;
        } else {
          i = 8;
        } 
        textView.setVisibility(i);
        c.a(this.a, (View)textView, b.b());
        int i = b.a();
        if (i != 0)
          textView.setTextColor(i); 
      } 
    }
    
    void c(View param1View) {
      d d = c.a(this.a).i();
      if (d != null) {
        EditText editText = (EditText)param1View;
        c.a(this.a, param1View, d.c());
        int i = d.b();
        if (i != 0)
          editText.setTextColor(i); 
        i = d.a();
        if (i != 0)
          editText.setTextSize(i); 
        editText.getPaint().setFakeBoldText(d.d());
      } 
    }
    
    void d(View param1View) {
      f f = c.a(this.a).j();
      if (f != null) {
        ImageView imageView = (ImageView)param1View;
        int i = f.c();
        int j = f.b();
        if (i != 0 && j != 0) {
          ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
          layoutParams.height = i;
          layoutParams.width = j;
          imageView.setLayoutParams(layoutParams);
        } 
        c.a(this.a, param1View, f.e());
        i = f.a();
        if (i != 0)
          imageView.setImageResource(i); 
        if (f.d()) {
          i = 0;
        } else {
          i = 8;
        } 
        imageView.setVisibility(i);
      } 
    }
    
    public void e(View param1View) {
      e e = c.a(this.a).k();
      if (e != null) {
        int i = e.c();
        int j = e.b();
        if (i != 0 && j != 0) {
          ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
          layoutParams.height = i;
          layoutParams.width = j;
          param1View.setLayoutParams(layoutParams);
        } 
        c.a(this.a, param1View, e.a());
        if (com.sdk.base.framework.utils.k.a.b(e.d()).booleanValue())
          ((Button)param1View).setText(e.d()); 
      } 
    }
    
    void f(View param1View) {
      g g = c.a(this.a).l();
      if (g != null) {
        int i = g.b();
        if (i != -2)
          ((LinearLayout)param1View).setBackgroundColor(i); 
        i = g.c();
        if (i != 0)
          ((Button)c.b(this.a).get("oauth_back_ctc")).setBackgroundResource(i); 
        i = g.e();
        TextView textView = (TextView)c.b(this.a).get("oauth_title_ctc");
        if (i != 0)
          textView.setTextColor(i); 
        i = g.d();
        if (i != 0)
          textView.setTextSize(i); 
        if (g.f())
          textView.setTypeface(Typeface.defaultFromStyle(1)); 
        if (!g.g())
          ((TextView)c.b(this.a).get("navigation_bar_line_ctc")).setVisibility(8); 
      } 
    }
    
    void g(View param1View) {
      i i = c.a(this.a).m();
      if (i != null) {
        int j = i.a();
        c.a(this.a, param1View, j);
        int k = i.b();
        j = i.c();
        TextView textView1 = (TextView)c.b(this.a).get("service_and_privacy_ctc");
        if (k != 0)
          textView1.setTextColor(k); 
        if (j != 0)
          textView1.setTextSize(j); 
        textView1 = (TextView)c.b(this.a).get(i.d());
        if (textView1 != null) {
          if (k != 0)
            textView1.setTextColor(k); 
          if (j != 0)
            textView1.setTextSize(j); 
        } 
        textView1 = (TextView)c.b(this.a).get(i.f());
        if (textView1 != null) {
          if (k != 0)
            textView1.setTextColor(k); 
          if (j != 0)
            textView1.setTextSize(j); 
        } 
        textView1 = (TextView)c.b(this.a).get("login_before_text_ctc");
        TextView textView2 = (TextView)c.b(this.a).get("authorize_app_ctc");
        if (i.h() != 0) {
          textView1.setTextColor(i.h());
          textView2.setTextColor(i.h());
        } 
      } 
    }
    
    void h(View param1View) {
      TextView textView = (TextView)param1View;
      h h = c.a(this.a).n();
      if (h != null) {
        int i = h.b();
        if (i != 0)
          textView.setTextColor(i); 
        String str = h.a();
        if (com.sdk.base.framework.utils.k.a.b(str).booleanValue())
          textView.setText(str); 
        textView.getPaint().setFakeBoldText(h.c());
        if (!h.d())
          textView.setVisibility(8); 
      } 
    }
  }
  
  public class b {
    public b(c this$0) {}
    
    void a(View param1View) {
      com.sdk.mobile.manager.login.a.a a = c.a(this.a).f();
      if (a != null) {
        TextView textView = (TextView)param1View;
        if (a.a()) {
          i = 0;
        } else {
          i = 8;
        } 
        textView.setVisibility(i);
        c.a(this.a, (View)textView, a.c());
        int i = a.b();
        if (i != 0)
          textView.setTextColor(i); 
        i = a.d();
        if (i != 0)
          textView.setTextSize(i); 
        textView.getPaint().setFakeBoldText(a.e());
      } 
    }
    
    void b(View param1View) {
      com.sdk.mobile.manager.login.a.b b1 = c.a(this.a).g();
      if (b1 != null) {
        TextView textView = (TextView)param1View;
        if (b1.c()) {
          i = 0;
        } else {
          i = 8;
        } 
        textView.setVisibility(i);
        c.a(this.a, (View)textView, b1.b());
        int i = b1.a();
        if (i != 0)
          textView.setTextColor(i); 
      } 
    }
    
    void c(View param1View) {
      d d = c.a(this.a).i();
      if (d != null) {
        EditText editText = (EditText)param1View;
        c.a(this.a, param1View, d.c());
        int i = d.b();
        if (i != 0)
          editText.setTextColor(i); 
        i = d.a();
        if (i != 0)
          editText.setTextSize(i); 
        editText.getPaint().setFakeBoldText(d.d());
      } 
    }
    
    void d(View param1View) {
      f f = c.a(this.a).j();
      if (f != null) {
        ImageView imageView = (ImageView)param1View;
        int i = f.c();
        int j = f.b();
        if (i != 0 && j != 0) {
          ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
          layoutParams.height = i;
          layoutParams.width = j;
          imageView.setLayoutParams(layoutParams);
        } 
        c.a(this.a, param1View, f.e());
        i = f.a();
        if (i != 0)
          imageView.setImageResource(i); 
        if (f.d()) {
          i = 0;
        } else {
          i = 8;
        } 
        imageView.setVisibility(i);
      } 
    }
    
    void e(View param1View) {
      e e = c.a(this.a).k();
      if (e != null) {
        int i = e.c();
        int j = e.b();
        if (i != 0 && j != 0) {
          ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
          layoutParams.height = i;
          layoutParams.width = j;
          param1View.setLayoutParams(layoutParams);
        } 
        c.a(this.a, param1View, e.a());
        if (com.sdk.base.framework.utils.k.a.b(e.d()).booleanValue())
          ((Button)param1View).setText(e.d()); 
      } 
    }
    
    void f(View param1View) {
      g g = c.a(this.a).l();
      if (g != null) {
        int i = g.b();
        if (i != -2)
          ((LinearLayout)param1View).setBackgroundColor(i); 
        i = g.c();
        if (i != 0)
          ((Button)c.b(this.a).get("oauth_back")).setBackgroundResource(i); 
        i = g.e();
        TextView textView = (TextView)c.b(this.a).get("oauth_title");
        if (i != 0)
          textView.setTextColor(i); 
        i = g.d();
        if (i != 0)
          textView.setTextSize(i); 
        if (g.f())
          textView.setTypeface(Typeface.defaultFromStyle(1)); 
        if (!g.g())
          ((TextView)c.b(this.a).get("navigation_bar_line")).setVisibility(8); 
      } 
    }
    
    void g(View param1View) {
      i i = c.a(this.a).m();
      if (i != null) {
        int j = i.a();
        c.a(this.a, param1View, j);
        j = i.b();
        int k = i.c();
        TextView textView1 = (TextView)c.b(this.a).get("service_and_privacy");
        if (j != 0)
          textView1.setTextColor(j); 
        if (k != 0)
          textView1.setTextSize(k); 
        textView1 = (TextView)c.b(this.a).get(i.d());
        if (textView1 != null) {
          if (j != 0)
            textView1.setTextColor(j); 
          if (k != 0)
            textView1.setTextSize(k); 
        } 
        textView1 = (TextView)c.b(this.a).get(i.f());
        if (textView1 != null) {
          if (j != 0)
            textView1.setTextColor(j); 
          if (k != 0)
            textView1.setTextSize(k); 
        } 
        TextView textView2 = (TextView)c.b(this.a).get("login_before_text");
        textView1 = (TextView)c.b(this.a).get("authorize_app");
        if (i.h() != 0) {
          textView2.setTextColor(i.h());
          textView1.setTextColor(i.h());
        } 
      } 
    }
    
    void h(View param1View) {
      TextView textView = (TextView)param1View;
      h h = c.a(this.a).n();
      if (h != null) {
        int i = h.b();
        if (i != 0)
          textView.setTextColor(i); 
        String str = h.a();
        if (com.sdk.base.framework.utils.k.a.b(str).booleanValue())
          textView.setText(str); 
        textView.getPaint().setFakeBoldText(h.c());
        if (!h.d())
          textView.setVisibility(8); 
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */