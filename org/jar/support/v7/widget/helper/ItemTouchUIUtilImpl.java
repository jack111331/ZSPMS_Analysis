package org.jar.support.v7.widget.helper;

import android.graphics.Canvas;
import android.view.View;
import org.jar.support.v4.view.ViewCompat;
import org.jar.support.v7.widget.RecyclerView;

class ItemTouchUIUtilImpl {
  static class Gingerbread implements ItemTouchUIUtil {
    private void draw(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2) {
      param1Canvas.save();
      param1Canvas.translate(param1Float1, param1Float2);
      param1RecyclerView.drawChild(param1Canvas, param1View, 0L);
      param1Canvas.restore();
    }
    
    public void clearView(View param1View) {
      param1View.setVisibility(0);
    }
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      if (param1Int != 2)
        draw(param1Canvas, param1RecyclerView, param1View, param1Float1, param1Float2); 
    }
    
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      if (param1Int == 2)
        draw(param1Canvas, param1RecyclerView, param1View, param1Float1, param1Float2); 
    }
    
    public void onSelected(View param1View) {
      param1View.setVisibility(4);
    }
  }
  
  static class Honeycomb implements ItemTouchUIUtil {
    public void clearView(View param1View) {
      ViewCompat.setTranslationX(param1View, 0.0F);
      ViewCompat.setTranslationY(param1View, 0.0F);
    }
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      ViewCompat.setTranslationX(param1View, param1Float1);
      ViewCompat.setTranslationY(param1View, param1Float2);
    }
    
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {}
    
    public void onSelected(View param1View) {}
  }
  
  static class Lollipop extends Honeycomb {
    private float findMaxElevation(RecyclerView param1RecyclerView, View param1View) {
      int i = param1RecyclerView.getChildCount();
      float f = 0.0F;
      byte b = 0;
      while (b < i) {
        float f1;
        View view = param1RecyclerView.getChildAt(b);
        if (view == param1View) {
          f1 = f;
        } else {
          float f2 = ViewCompat.getElevation(view);
          f1 = f;
          if (f2 > f)
            f1 = f2; 
        } 
        b++;
        f = f1;
      } 
      return f;
    }
    
    public void clearView(View param1View) {
      Object object = param1View.getTag(16908313);
      if (object != null && object instanceof Float)
        ViewCompat.setElevation(param1View, ((Float)object).floatValue()); 
      param1View.setTag(16908313, null);
      super.clearView(param1View);
    }
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, View param1View, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      if (param1Boolean && param1View.getTag(16908313) == null) {
        float f = ViewCompat.getElevation(param1View);
        ViewCompat.setElevation(param1View, findMaxElevation(param1RecyclerView, param1View) + 1.0F);
        param1View.setTag(16908313, Float.valueOf(f));
      } 
      super.onDraw(param1Canvas, param1RecyclerView, param1View, param1Float1, param1Float2, param1Int, param1Boolean);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v7\widget\helper\ItemTouchUIUtilImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */