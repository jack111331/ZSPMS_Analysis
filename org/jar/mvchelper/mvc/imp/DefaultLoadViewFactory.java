package org.jar.mvchelper.mvc.imp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.mvchelper.mvc.ILoadViewFactory;
import org.jar.mvchelper.vary.VaryViewHelper;

public class DefaultLoadViewFactory implements ILoadViewFactory {
  public static int dip2px(Context paramContext, float paramFloat) {
    return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  public ILoadViewFactory.ILoadMoreView madeLoadMoreView() {
    return new LoadMoreHelper();
  }
  
  public ILoadViewFactory.ILoadView madeLoadView() {
    return new LoadViewHelper();
  }
  
  private static class LoadMoreHelper implements ILoadViewFactory.ILoadMoreView {
    protected TextView footView;
    
    protected View.OnClickListener onClickRefreshListener;
    
    private LoadMoreHelper() {}
    
    public void init(ILoadViewFactory.FootViewAdder param1FootViewAdder, View.OnClickListener param1OnClickListener) {
      Context context = param1FootViewAdder.getContentView().getContext();
      TextView textView = new TextView(context);
      textView.setTextColor(-7829368);
      textView.setPadding(0, DefaultLoadViewFactory.dip2px(context, 16.0F), 0, DefaultLoadViewFactory.dip2px(context, 16.0F));
      textView.setGravity(17);
      param1FootViewAdder.addFootView((View)textView);
      this.footView = textView;
      this.onClickRefreshListener = param1OnClickListener;
      showNormal();
    }
    
    public void showFail(Exception param1Exception) {
      this.footView.setText(ResUtils.id(this.footView.getContext(), R.string.bloc_foot_click_reload));
      this.footView.setOnClickListener(this.onClickRefreshListener);
    }
    
    public void showLoading() {
      this.footView.setText(ResUtils.id(this.footView.getContext(), R.string.bloc_foot_loading));
      this.footView.setOnClickListener(null);
    }
    
    public void showNomore() {
      this.footView.setText(ResUtils.id(this.footView.getContext(), R.string.bloc_foot_load_complete));
      this.footView.setOnClickListener(null);
    }
    
    public void showNormal() {
      this.footView.setText(ResUtils.id(this.footView.getContext(), R.string.bloc_foot_click_load_more));
      this.footView.setOnClickListener(this.onClickRefreshListener);
    }
  }
  
  private static class LoadViewHelper implements ILoadViewFactory.ILoadView {
    private Context context;
    
    private VaryViewHelper helper;
    
    private View.OnClickListener onClickRefreshListener;
    
    private LoadViewHelper() {}
    
    public void init(View param1View, View.OnClickListener param1OnClickListener) {
      this.context = param1View.getContext().getApplicationContext();
      this.onClickRefreshListener = param1OnClickListener;
      this.helper = new VaryViewHelper(param1View);
    }
    
    public void restore() {
      this.helper.restoreView();
    }
    
    public void showEmpty() {
      Context context = this.helper.getContext();
      LinearLayout linearLayout = new LinearLayout(context);
      linearLayout.setOrientation(1);
      linearLayout.setGravity(17);
      TextView textView = new TextView(context);
      textView.setText(ResUtils.id(context, R.string.bloc_tip_nodata));
      textView.setGravity(17);
      linearLayout.addView((View)textView);
      Button button = new Button(context);
      button.setText(ResUtils.id(context, R.string.bloc_tip_retry));
      button.setOnClickListener(this.onClickRefreshListener);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.setMargins(0, DefaultLoadViewFactory.dip2px(context, 12.0F), 0, 0);
      linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
      this.helper.showLayout((View)linearLayout);
    }
    
    public void showFail(Exception param1Exception) {
      Context context = this.helper.getContext();
      LinearLayout linearLayout = new LinearLayout(context);
      linearLayout.setOrientation(1);
      linearLayout.setGravity(17);
      TextView textView = new TextView(context);
      textView.setText(ResUtils.id(context, R.string.bloc_tip_netword_load_fail));
      textView.setGravity(17);
      linearLayout.addView((View)textView);
      Button button = new Button(context);
      button.setText(ResUtils.id(context, R.string.bloc_tip_retry));
      button.setOnClickListener(this.onClickRefreshListener);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.setMargins(0, DefaultLoadViewFactory.dip2px(context, 12.0F), 0, 0);
      linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
      this.helper.showLayout((View)linearLayout);
    }
    
    public void showLoading() {
      Context context = this.helper.getContext();
      LinearLayout linearLayout = new LinearLayout(context);
      linearLayout.setOrientation(1);
      linearLayout.setGravity(17);
      linearLayout.addView((View)new ProgressBar(context));
      TextView textView = new TextView(context);
      textView.setText(ResUtils.id(context, R.string.bloc_tip_loading));
      textView.setGravity(17);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.setMargins(0, DefaultLoadViewFactory.dip2px(context, 12.0F), 0, 0);
      linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
      this.helper.showLayout((View)linearLayout);
    }
    
    public void tipFail(Exception param1Exception) {
      Toast.makeText(this.context, ResUtils.id(this.context, R.string.bloc_tip_netword_load_fail), 0).show();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\imp\DefaultLoadViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */