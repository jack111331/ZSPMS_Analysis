package org.jar.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompatLollipop {
  private static final String TAG = "ViewParentCompat";
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    try {
      return paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedFling");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2) {
    try {
      return paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedPreFling");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    try {
      paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedPreScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
    } 
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
    } 
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onNestedScrollAccepted");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
    } 
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt) {
    try {
      return paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onStartNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
      return false;
    } 
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView) {
    try {
      paramViewParent.onStopNestedScroll(paramView);
    } catch (AbstractMethodError abstractMethodError) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ViewParent ");
      stringBuilder.append(paramViewParent);
      stringBuilder.append(" does not implement interface method onStopNestedScroll");
      Log.e("ViewParentCompat", stringBuilder.toString(), abstractMethodError);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\view\ViewParentCompatLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */