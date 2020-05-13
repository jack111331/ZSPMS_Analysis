package com.chuanglan.shanyan_sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.chuanglan.shanyan_sdk.utils.L;
import java.lang.reflect.Field;

public class BaseEditText extends EditText {
  private static Field a;
  
  static {
    try {
      a = View.class.getDeclaredField("mParent");
      a.setAccessible(true);
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      L.d("ExceptionLogger", "onDetachedFromWindow()Exception == " + noSuchFieldException.toString());
    } 
  }
  
  public BaseEditText(Context paramContext) {
    super(paramContext.getApplicationContext());
  }
  
  public BaseEditText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext.getApplicationContext(), paramAttributeSet);
  }
  
  public BaseEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
  }
  
  protected void onDetachedFromWindow() {
    try {
      if (a != null)
        a.set(this, null); 
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      L.d("ExceptionLogger", "onDetachedFromWindow()Exception == " + illegalAccessException.toString());
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
      L.d("ExceptionLogger", "onDetachedFromWindow()Exception == " + illegalArgumentException.toString());
    } 
    super.onDetachedFromWindow();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\view\BaseEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */