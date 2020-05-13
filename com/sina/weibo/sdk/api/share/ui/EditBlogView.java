package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditBlogView extends EditText {
  private boolean canSelectionChanged = true;
  
  private int count;
  
  private Context ctx;
  
  private List<OnSelectionListener> listeners;
  
  private OnEnterListener mOnEnterListener;
  
  public EditBlogView(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EditBlogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.ctx = getContext();
    this.listeners = new ArrayList<OnSelectionListener>();
  }
  
  public int correctPosition(int paramInt) {
    if (paramInt == -1)
      return paramInt; 
    Editable editable = getText();
    if (paramInt >= editable.length())
      return paramInt; 
    Object[] arrayOfObject = editable.getSpans(paramInt, paramInt, ImageSpan.class);
    return (arrayOfObject != null && arrayOfObject.length != 0 && paramInt != editable.getSpanStart(arrayOfObject[0])) ? editable.getSpanEnd(arrayOfObject[0]) : paramInt;
  }
  
  public void enableSelectionChanged(boolean paramBoolean) {
    this.canSelectionChanged = paramBoolean;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return (InputConnection)new InputConnectionWrapper(super.onCreateInputConnection(paramEditorInfo), false) {
        public boolean commitText(CharSequence param1CharSequence, int param1Int) {
          Editable editable = EditBlogView.this.getEditableText();
          new String(editable.toString());
          int i = Selection.getSelectionStart((CharSequence)editable);
          int j = Selection.getSelectionEnd((CharSequence)editable);
          if (i != -1 && j != -1) {
            int k = EditBlogView.this.correctPosition(i);
            int m = EditBlogView.this.correctPosition(j);
            int n = k;
            int i1 = m;
            if (k > m) {
              i1 = k;
              n = m;
            } 
            if (n != i || i1 != j)
              Selection.setSelection((Spannable)editable, n, i1); 
            if (n != i1)
              EditBlogView.this.getText().delete(n, i1); 
          } 
          return super.commitText(param1CharSequence, param1Int);
        }
        
        public boolean setComposingText(CharSequence param1CharSequence, int param1Int) {
          Editable editable = EditBlogView.this.getEditableText();
          new String(editable.toString());
          int i = Selection.getSelectionStart((CharSequence)editable);
          int j = Selection.getSelectionEnd((CharSequence)editable);
          if (i != -1 && j != -1) {
            int k = EditBlogView.this.correctPosition(i);
            int m = EditBlogView.this.correctPosition(j);
            int n = k;
            int i1 = m;
            if (k > m) {
              i1 = k;
              n = m;
            } 
            if (n != i || i1 != j)
              Selection.setSelection((Spannable)editable, n, i1); 
            if (n != i1)
              EditBlogView.this.getText().delete(n, i1); 
          } 
          return super.setComposingText(param1CharSequence, param1Int);
        }
      };
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 66 && this.mOnEnterListener != null)
      this.mOnEnterListener.onEnterKey(); 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2) {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (!this.canSelectionChanged || this.listeners == null || this.listeners.isEmpty())
      return; 
    Iterator<OnSelectionListener> iterator = this.listeners.iterator();
    while (true) {
      if (!iterator.hasNext())
        return; 
      ((OnSelectionListener)iterator.next()).onSelectionChanged(paramInt1, paramInt2);
    } 
  }
  
  public void setOnEnterListener(OnEnterListener paramOnEnterListener) {
    this.mOnEnterListener = paramOnEnterListener;
  }
  
  public void setOnSelectionListener(OnSelectionListener paramOnSelectionListener) {
    this.listeners.add(paramOnSelectionListener);
  }
  
  public static interface OnEnterListener {
    void onEnterKey();
  }
  
  public static interface OnSelectionListener {
    void onSelectionChanged(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\api\shar\\ui\EditBlogView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */