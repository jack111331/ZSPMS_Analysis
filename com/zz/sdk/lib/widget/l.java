package com.zz.sdk.lib.widget;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class l extends PopupWindow {
  public l() {}
  
  public l(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public l(Context paramContext) {
    super(paramContext);
  }
  
  public l(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public l(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public l(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public l(View paramView) {
    super(paramView);
  }
  
  public l(View paramView, int paramInt1, int paramInt2) {
    super(paramView, paramInt1, paramInt2);
  }
  
  public l(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  private Object a(String paramString) {
    Object object;
    String str = null;
    if (TextUtils.isEmpty(paramString))
      return str; 
    try {
      Field field = PopupWindow.class.getDeclaredField(paramString);
      field.setAccessible(true);
      object = field.get(this);
    } catch (Exception exception) {
      exception.printStackTrace();
      object = str;
    } 
    return object;
  }
  
  private Object a(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    Object object;
    String str = null;
    if (TextUtils.isEmpty(paramString))
      return str; 
    try {
      Method method = a(PopupWindow.class, paramString, paramArrayOfClass);
      method.setAccessible(true);
      object = method.invoke(this, paramArrayOfObject);
    } catch (Exception exception) {
      exception.printStackTrace();
      object = str;
    } 
    return object;
  }
  
  private Method a(Class paramClass, String paramString, Class[] paramArrayOfClass) {
    Method method = null;
    try {
      Method method1 = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      method = method1;
    } catch (NoSuchMethodException noSuchMethodException) {}
    return method;
  }
  
  private void a(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString))
      try {
        Field field = PopupWindow.class.getDeclaredField(paramString);
        field.setAccessible(true);
        field.set(this, paramObject);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 24) {
      super.update(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
      return;
    } 
    if (paramInt3 >= 0) {
      a("mLastWidth", Integer.valueOf(paramInt3));
      setWidth(paramInt3);
    } 
    if (paramInt4 >= 0) {
      a("mLastHeight", Integer.valueOf(paramInt4));
      setHeight(paramInt4);
    } 
    Object object = a("mContentView");
    if (object instanceof View) {
      object = object;
    } else {
      object = null;
    } 
    if (isShowing() && object != null) {
      int i;
      byte b;
      object = a("mDecorView");
      if (object instanceof View) {
        object = object;
      } else {
        object = null;
      } 
      WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)object.getLayoutParams();
      Object<int> object1 = (Object<int>)a("mWidthMode");
      if (object1 != null) {
        i = ((Integer)object1).intValue();
      } else {
        i = 0;
      } 
      object1 = (Object<int>)a("mLastWidth");
      if (object1 != null) {
        b = ((Integer)object1).intValue();
      } else {
        b = 0;
      } 
      if (!i)
        i = b; 
      boolean bool1 = paramBoolean;
      if (paramInt3 != -1) {
        bool1 = paramBoolean;
        if (layoutParams.width != i) {
          layoutParams.width = i;
          a("mLastWidth", Integer.valueOf(i));
          bool1 = true;
        } 
      } 
      object1 = (Object<int>)a("mHeightMode");
      if (object1 != null) {
        paramInt3 = ((Integer)object1).intValue();
      } else {
        paramInt3 = 0;
      } 
      object1 = (Object<int>)a("mLastHeight");
      if (object1 != null) {
        i = ((Integer)object1).intValue();
      } else {
        i = 0;
      } 
      if (paramInt3 >= 0)
        paramInt3 = i; 
      paramBoolean = bool1;
      if (paramInt4 != -1) {
        paramBoolean = bool1;
        if (layoutParams.height != paramInt3) {
          layoutParams.height = paramInt3;
          a("mLastHeight", Integer.valueOf(paramInt3));
          paramBoolean = true;
        } 
      } 
      if (layoutParams.x != paramInt1) {
        layoutParams.x = paramInt1;
        paramBoolean = true;
      } 
      if (layoutParams.y != paramInt2) {
        layoutParams.y = paramInt2;
        paramBoolean = true;
      } 
      object1 = (Object<int>)a("computeAnimationResource", new Class[0], new Object[0]);
      if (object1 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((Integer)object1).intValue();
      } 
      if (paramInt1 != layoutParams.windowAnimations) {
        layoutParams.windowAnimations = paramInt1;
        paramBoolean = true;
      } 
      object1 = (Object<int>)int.class;
      paramInt1 = layoutParams.flags;
      object1 = (Object<int>)a("computeFlags", new Class[] { (Class)object1 }, new Object[] { Integer.valueOf(paramInt1) });
      if (object1 == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = ((Integer)object1).intValue();
      } 
      if (paramInt1 != layoutParams.flags) {
        layoutParams.flags = paramInt1;
        paramBoolean = bool;
      } 
      if (paramBoolean) {
        a("setLayoutDirectionFromAnchor", new Class[0], new Object[0]);
        object1 = (Object<int>)a("mWindowManager");
        if (object1 instanceof WindowManager) {
          WindowManager windowManager = (WindowManager)object1;
        } else {
          object1 = null;
        } 
        if (object1 != null)
          object1.updateViewLayout((View)object, (ViewGroup.LayoutParams)layoutParams); 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */