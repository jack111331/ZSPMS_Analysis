package com.xy.whf.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xy.whf.helper.e;

public class DefaultAlertDialog extends Dialog {
  private TextView detailView;
  
  private LinearLayout linearLayout;
  
  private ActionListener negativeListener;
  
  private TextView negativeView;
  
  private ActionListener positiveListener;
  
  private TextView positiveView;
  
  private RelativeLayout rootLayout;
  
  private TextView titleView;
  
  public DefaultAlertDialog(@NonNull Context paramContext) {
    super(paramContext);
    initView(paramContext);
  }
  
  public DefaultAlertDialog(@NonNull Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    initView(paramContext);
  }
  
  protected DefaultAlertDialog(@NonNull Context paramContext, boolean paramBoolean, @Nullable DialogInterface.OnCancelListener paramOnCancelListener) {
    super(paramContext, paramBoolean, paramOnCancelListener);
    initView(paramContext);
  }
  
  private void addNegativeAction(String paramString, ActionListener paramActionListener) {
    if (paramString != null && paramString.trim().length() > 0) {
      this.negativeView.setVisibility(0);
      this.negativeView.setText(paramString);
      this.negativeListener = paramActionListener;
      return;
    } 
    this.negativeView.setVisibility(8);
  }
  
  private void addPositiveAction(String paramString, ActionListener paramActionListener) {
    if (paramString != null && paramString.trim().length() > 0) {
      this.positiveView.setVisibility(0);
      this.positiveView.setText(paramString);
      this.positiveListener = paramActionListener;
      return;
    } 
    this.positiveView.setVisibility(8);
  }
  
  private Drawable getCircleDrawable(float[] paramArrayOffloat, String paramString) {
    ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(paramArrayOffloat, null, null));
    shapeDrawable.getPaint().setColor(Color.parseColor(paramString));
    shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    return (Drawable)shapeDrawable;
  }
  
  private void initView(Context paramContext) {
    this.rootLayout = new RelativeLayout(paramContext);
    this.rootLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.rootLayout.setGravity(17);
    (this.rootLayout.getLayoutParams()).width = (int)((e.a(paramContext)).widthPixels * 0.73D);
    this.rootLayout.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    setContentView((View)this.rootLayout);
    Window window = getWindow();
    if (window != null) {
      (window.getAttributes()).dimAmount = 0.55F;
      window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    } 
    this.linearLayout = new LinearLayout(paramContext);
    this.linearLayout.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.linearLayout.setBackgroundDrawable(getCircleDrawable(new float[] { 20.0F, 20.0F, 20.0F, 20.0F, 20.0F, 20.0F, 20.0F, 20.0F }, "#F9F9F9"));
    this.linearLayout.setGravity(17);
    this.rootLayout.addView((View)this.linearLayout, (ViewGroup.LayoutParams)layoutParams);
    this.titleView = new TextView(paramContext);
    this.titleView.setPadding(e.a(paramContext, 15), 0, e.a(paramContext, 25), e.a(paramContext, 20));
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, e.a(paramContext, -2));
    this.titleView.setGravity(17);
    this.titleView.setTextSize(2, 16.0F);
    this.titleView.setEllipsize(TextUtils.TruncateAt.END);
    this.titleView.setTextColor(Color.parseColor("#000000"));
    this.titleView.setVisibility(4);
    this.linearLayout.addView((View)this.titleView, (ViewGroup.LayoutParams)layoutParams2);
    this.detailView = new TextView(paramContext);
    this.detailView.setPadding(e.a(paramContext, 15), 0, e.a(paramContext, 15), e.a(paramContext, 35));
    this.detailView.setGravity(17);
    this.detailView.setTextSize(2, 15.0F);
    this.detailView.setLineSpacing(1.2F, 1.0F);
    layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    this.linearLayout.addView((View)this.detailView, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView2 = new TextView(paramContext);
    layoutParams2 = new LinearLayout.LayoutParams(-1, 3);
    layoutParams2.setMargins(10, 0, 10, 0);
    textView2.setBackgroundColor(Color.parseColor("#DEE0E2"));
    this.linearLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, e.a(paramContext, 50));
    linearLayout.setOrientation(0);
    linearLayout.setGravity(17);
    this.linearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams3);
    this.negativeView = new TextView(paramContext);
    this.negativeView.setVisibility(8);
    layoutParams3 = new LinearLayout.LayoutParams(-1, e.a(paramContext, 50));
    layoutParams3.weight = 1.0F;
    this.negativeView.setGravity(17);
    this.negativeView.setTextSize(2, 16.0F);
    this.negativeView.setClickable(true);
    this.negativeView.setTextColor(Color.parseColor("#333333"));
    this.negativeView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DefaultAlertDialog.this.negativeListener.onClick(param1View, DefaultAlertDialog.this);
          }
        });
    linearLayout.addView((View)this.negativeView, (ViewGroup.LayoutParams)layoutParams3);
    TextView textView1 = new TextView(paramContext);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(3, -2);
    layoutParams4.setMargins(0, 5, 0, 5);
    textView1.setBackgroundColor(Color.parseColor("#DEE0E2"));
    linearLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams4);
    this.positiveView = new TextView(paramContext);
    this.positiveView.setVisibility(8);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, e.a(paramContext, 50));
    layoutParams1.weight = 1.0F;
    this.positiveView.setGravity(17);
    this.positiveView.setTextSize(2, 16.0F);
    this.positiveView.setClickable(true);
    this.positiveView.setTextColor(Color.parseColor("#1B88EE"));
    this.positiveView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DefaultAlertDialog.this.positiveListener.onClick(param1View, DefaultAlertDialog.this);
          }
        });
    linearLayout.addView((View)this.positiveView, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  public static interface ActionListener {
    void onClick(View param1View, DefaultAlertDialog param1DefaultAlertDialog);
  }
  
  public static class MessageDialogBuilder {
    private Context context;
    
    private DefaultAlertDialog dialog;
    
    public MessageDialogBuilder(Context param1Context) {
      this.context = param1Context;
      this.dialog = new DefaultAlertDialog(param1Context);
    }
    
    public MessageDialogBuilder addNegativeAction(String param1String, DefaultAlertDialog.ActionListener param1ActionListener) {
      this.dialog.addNegativeAction(param1String, param1ActionListener);
      this.dialog.negativeView.setVisibility(0);
      return this;
    }
    
    public MessageDialogBuilder addPositiveAction(String param1String, DefaultAlertDialog.ActionListener param1ActionListener) {
      this.dialog.addPositiveAction(param1String, param1ActionListener);
      this.dialog.positiveView.setVisibility(0);
      return this;
    }
    
    public DefaultAlertDialog create() {
      return this.dialog;
    }
    
    public MessageDialogBuilder setCancelable(boolean param1Boolean) {
      this.dialog.setCancelable(param1Boolean);
      return this;
    }
    
    public MessageDialogBuilder setMessage(String param1String) {
      this.dialog.detailView.setVisibility(0);
      this.dialog.detailView.setText(param1String);
      return this;
    }
    
    public MessageDialogBuilder setTitle(String param1String) {
      this.dialog.titleView.setVisibility(0);
      this.dialog.titleView.setText(param1String);
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\widget\DefaultAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */