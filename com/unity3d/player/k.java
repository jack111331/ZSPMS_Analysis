package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class k extends Dialog implements TextWatcher, View.OnClickListener {
  private static int c = 1627389952;
  
  private static int d = -1;
  
  private static int e = 134217728;
  
  private static int f = 67108864;
  
  private Context a = null;
  
  private UnityPlayer b = null;
  
  public k(Context paramContext, UnityPlayer paramUnityPlayer, String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, int paramInt2, boolean paramBoolean4) {
    super(paramContext);
    this.a = paramContext;
    this.b = paramUnityPlayer;
    a(paramBoolean4);
    getWindow().requestFeature(1);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    setContentView(createSoftInputView());
    getWindow().setLayout(-1, -2);
    getWindow().clearFlags(2);
    if (j.a) {
      getWindow().clearFlags(e);
      getWindow().clearFlags(f);
    } 
    EditText editText = (EditText)findViewById(1057292289);
    Button button = (Button)findViewById(1057292290);
    a(editText, paramString1, paramInt1, paramBoolean1, paramBoolean2, paramBoolean3, paramString2, paramInt2);
    button.setOnClickListener(this);
    editText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public final void onFocusChange(View param1View, boolean param1Boolean) {
            if (param1Boolean)
              this.a.getWindow().setSoftInputMode(5); 
          }
        });
    editText.requestFocus();
  }
  
  private static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    byte b;
    if (paramBoolean1) {
      i = 32768;
    } else {
      i = 524288;
    } 
    char c = Character.MIN_VALUE;
    if (paramBoolean2) {
      b = 131072;
    } else {
      b = 0;
    } 
    if (paramBoolean3)
      c = ''; 
    int i = i | b | c;
    if (paramInt < 0 || paramInt > 11)
      return i; 
    int[] arrayOfInt = new int[12];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 16385;
    arrayOfInt[2] = 12290;
    arrayOfInt[3] = 17;
    arrayOfInt[4] = 2;
    arrayOfInt[5] = 3;
    arrayOfInt[6] = 8289;
    arrayOfInt[7] = 33;
    arrayOfInt[8] = 1;
    arrayOfInt[9] = 16417;
    arrayOfInt[10] = 17;
    arrayOfInt[11] = 8194;
    return ((arrayOfInt[paramInt] & 0x2) != 0) ? arrayOfInt[paramInt] : (arrayOfInt[paramInt] | i);
  }
  
  private String a() {
    EditText editText = (EditText)findViewById(1057292289);
    return (editText == null) ? null : editText.getText().toString().trim();
  }
  
  private void a(EditText paramEditText, String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, int paramInt2) {
    paramEditText.setImeOptions(6);
    paramEditText.setText(paramString1);
    paramEditText.setHint(paramString2);
    paramEditText.setHintTextColor(c);
    paramEditText.setInputType(a(paramInt1, paramBoolean1, paramBoolean2, paramBoolean3));
    paramEditText.setImeOptions(33554432);
    if (paramInt2 > 0)
      paramEditText.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(paramInt2) }); 
    paramEditText.addTextChangedListener(this);
    paramEditText.setSelection(paramEditText.getText().length());
    paramEditText.setClickable(true);
  }
  
  private void a(String paramString, boolean paramBoolean) {
    ((EditText)findViewById(1057292289)).setSelection(0, 0);
    this.b.reportSoftInputStr(paramString, 1, paramBoolean);
  }
  
  public final void a(int paramInt) {
    EditText editText = (EditText)findViewById(1057292289);
    if (editText != null) {
      if (paramInt > 0) {
        editText.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(paramInt) });
        return;
      } 
      editText.setFilters(new InputFilter[0]);
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    EditText editText = (EditText)findViewById(1057292289);
    if (editText != null) {
      int i = editText.getText().length();
      paramInt2 += paramInt1;
      if (i >= paramInt2)
        editText.setSelection(paramInt1, paramInt2); 
    } 
  }
  
  public final void a(String paramString) {
    EditText editText = (EditText)findViewById(1057292289);
    if (editText != null) {
      editText.setText(paramString);
      editText.setSelection(paramString.length());
    } 
  }
  
  public final void a(boolean paramBoolean) {
    boolean bool;
    Window window = getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    if (paramBoolean) {
      layoutParams.gravity = 8;
      bool = true;
    } else {
      layoutParams.gravity = 80;
      bool = false;
    } 
    layoutParams.x = bool;
    layoutParams.y = bool;
    window.setAttributes(layoutParams);
  }
  
  public final void afterTextChanged(Editable paramEditable) {
    this.b.reportSoftInputStr(paramEditable.toString(), 0, false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected final View createSoftInputView() {
    RelativeLayout relativeLayout = new RelativeLayout(this.a);
    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    relativeLayout.setBackgroundColor(d);
    EditText editText = new EditText(this, this.a) {
        public final boolean onKeyPreIme(int param1Int, KeyEvent param1KeyEvent) {
          if (param1Int == 4) {
            k.a(this.a, k.a(this.a), true);
            return true;
          } 
          return (param1Int == 84) ? true : super.onKeyPreIme(param1Int, param1KeyEvent);
        }
        
        protected final void onSelectionChanged(int param1Int1, int param1Int2) {
          k.c(this.a).reportSoftInputSelection(param1Int1, param1Int2 - param1Int1);
        }
        
        public final void onWindowFocusChanged(boolean param1Boolean) {
          super.onWindowFocusChanged(param1Boolean);
          if (param1Boolean)
            ((InputMethodManager)k.b(this.a).getSystemService("input_method")).showSoftInput((View)this, 0); 
        }
      };
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(15);
    layoutParams2.addRule(0, 1057292290);
    editText.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    editText.setId(1057292289);
    relativeLayout.addView((View)editText);
    Button button = new Button(this.a);
    button.setText(this.a.getResources().getIdentifier("ok", "string", "android"));
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.addRule(15);
    layoutParams1.addRule(11);
    button.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    button.setId(1057292290);
    button.setBackgroundColor(0);
    relativeLayout.addView((View)button);
    ((EditText)relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public final boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 6)
              k.a(this.a, k.a(this.a), false); 
            return false;
          }
        });
    relativeLayout.setPadding(16, 16, 16, 16);
    return (View)relativeLayout;
  }
  
  public final void onBackPressed() {
    a(a(), true);
  }
  
  public final void onClick(View paramView) {
    a(a(), false);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */