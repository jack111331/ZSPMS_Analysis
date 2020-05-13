package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.sina.weibo.sdk.utils.ResourceManager;

public class LetterIndexBar extends View {
  public static final int INDEX_COUNT_DEFAULT = 27;
  
  public static final String SEARCH_ICON_LETTER = "";
  
  private int count = 27;
  
  private int mIndex;
  
  private String[] mIndexLetter;
  
  private int mItemHeight;
  
  private int mItemPadding;
  
  private OnIndexChangeListener mListener;
  
  private boolean[] mNeedIndex;
  
  private int mOrgTextSzie;
  
  private Paint mPaint = new Paint();
  
  private RectF mRect;
  
  private Drawable mSeatchIcon;
  
  private boolean mTouching;
  
  public LetterIndexBar(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public LetterIndexBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LetterIndexBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-10658467);
    this.mOrgTextSzie = ResourceManager.dp2px(getContext(), 13);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onDraw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield mTouching : Z
    //   9: ifeq -> 63
    //   12: aload_0
    //   13: getfield mPaint : Landroid/graphics/Paint;
    //   16: invokevirtual getColor : ()I
    //   19: istore_2
    //   20: aload_0
    //   21: getfield mPaint : Landroid/graphics/Paint;
    //   24: ldc -2005436536
    //   26: invokevirtual setColor : (I)V
    //   29: aload_1
    //   30: aload_0
    //   31: getfield mRect : Landroid/graphics/RectF;
    //   34: aload_0
    //   35: invokevirtual getMeasuredWidth : ()I
    //   38: iconst_2
    //   39: idiv
    //   40: i2f
    //   41: aload_0
    //   42: invokevirtual getMeasuredWidth : ()I
    //   45: iconst_2
    //   46: idiv
    //   47: i2f
    //   48: aload_0
    //   49: getfield mPaint : Landroid/graphics/Paint;
    //   52: invokevirtual drawRoundRect : (Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   55: aload_0
    //   56: getfield mPaint : Landroid/graphics/Paint;
    //   59: iload_2
    //   60: invokevirtual setColor : (I)V
    //   63: aload_0
    //   64: getfield mOrgTextSzie : I
    //   67: aload_0
    //   68: getfield mItemHeight : I
    //   71: if_icmple -> 82
    //   74: aload_0
    //   75: getfield mItemHeight : I
    //   78: istore_3
    //   79: goto -> 87
    //   82: aload_0
    //   83: getfield mOrgTextSzie : I
    //   86: istore_3
    //   87: aload_0
    //   88: getfield mPaint : Landroid/graphics/Paint;
    //   91: iload_3
    //   92: i2f
    //   93: invokevirtual setTextSize : (F)V
    //   96: aload_0
    //   97: getfield mIndexLetter : [Ljava/lang/String;
    //   100: astore #4
    //   102: iconst_0
    //   103: istore_2
    //   104: iconst_0
    //   105: istore #5
    //   107: aload #4
    //   109: ifnonnull -> 257
    //   112: bipush #65
    //   114: istore_2
    //   115: iload_2
    //   116: istore #6
    //   118: iload #5
    //   120: aload_0
    //   121: getfield count : I
    //   124: if_icmplt -> 130
    //   127: goto -> 265
    //   130: aload_0
    //   131: getfield mItemHeight : I
    //   134: istore #7
    //   136: aload_0
    //   137: invokevirtual getPaddingTop : ()I
    //   140: istore #8
    //   142: aload_0
    //   143: getfield mItemPadding : I
    //   146: istore #9
    //   148: aload_0
    //   149: getfield mNeedIndex : [Z
    //   152: ifnull -> 168
    //   155: iload #6
    //   157: istore_2
    //   158: aload_0
    //   159: getfield mNeedIndex : [Z
    //   162: iload #5
    //   164: baload
    //   165: ifeq -> 248
    //   168: iload #5
    //   170: aload_0
    //   171: getfield count : I
    //   174: iconst_1
    //   175: isub
    //   176: if_icmpne -> 189
    //   179: iload #6
    //   181: istore_2
    //   182: ldc '#'
    //   184: astore #4
    //   186: goto -> 202
    //   189: iload #6
    //   191: iconst_1
    //   192: iadd
    //   193: i2c
    //   194: istore_2
    //   195: iload #6
    //   197: invokestatic valueOf : (C)Ljava/lang/String;
    //   200: astore #4
    //   202: aload_0
    //   203: getfield mPaint : Landroid/graphics/Paint;
    //   206: aload #4
    //   208: invokevirtual measureText : (Ljava/lang/String;)F
    //   211: f2i
    //   212: istore #10
    //   214: aload_1
    //   215: aload #4
    //   217: aload_0
    //   218: invokevirtual getMeasuredWidth : ()I
    //   221: iload #10
    //   223: isub
    //   224: iconst_2
    //   225: idiv
    //   226: i2f
    //   227: iload #7
    //   229: iload #5
    //   231: imul
    //   232: iload #8
    //   234: iadd
    //   235: iload_3
    //   236: iadd
    //   237: iload #9
    //   239: iadd
    //   240: i2f
    //   241: aload_0
    //   242: getfield mPaint : Landroid/graphics/Paint;
    //   245: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   248: iinc #5, 1
    //   251: iload_2
    //   252: istore #6
    //   254: goto -> 118
    //   257: iload_2
    //   258: aload_0
    //   259: getfield count : I
    //   262: if_icmplt -> 266
    //   265: return
    //   266: aload_0
    //   267: getfield mItemHeight : I
    //   270: iload_2
    //   271: imul
    //   272: aload_0
    //   273: invokevirtual getPaddingTop : ()I
    //   276: iadd
    //   277: iload_3
    //   278: iadd
    //   279: aload_0
    //   280: getfield mItemPadding : I
    //   283: iadd
    //   284: istore #5
    //   286: aload_0
    //   287: getfield mNeedIndex : [Z
    //   290: ifnull -> 302
    //   293: aload_0
    //   294: getfield mNeedIndex : [Z
    //   297: iload_2
    //   298: baload
    //   299: ifeq -> 416
    //   302: aload_0
    //   303: getfield mIndexLetter : [Ljava/lang/String;
    //   306: iload_2
    //   307: aaload
    //   308: astore #4
    //   310: aload #4
    //   312: ldc ''
    //   314: invokevirtual equals : (Ljava/lang/Object;)Z
    //   317: ifeq -> 381
    //   320: aload_0
    //   321: getfield mPaint : Landroid/graphics/Paint;
    //   324: ldc 'M'
    //   326: invokevirtual measureText : (Ljava/lang/String;)F
    //   329: f2i
    //   330: istore #7
    //   332: aload_0
    //   333: invokevirtual getMeasuredWidth : ()I
    //   336: iload #7
    //   338: isub
    //   339: iconst_2
    //   340: idiv
    //   341: istore #8
    //   343: aload_0
    //   344: getfield mSeatchIcon : Landroid/graphics/drawable/Drawable;
    //   347: iload #8
    //   349: iload #5
    //   351: iload #8
    //   353: isub
    //   354: iload #7
    //   356: iload #8
    //   358: iadd
    //   359: iload #7
    //   361: iload #5
    //   363: iadd
    //   364: iload #8
    //   366: isub
    //   367: invokevirtual setBounds : (IIII)V
    //   370: aload_0
    //   371: getfield mSeatchIcon : Landroid/graphics/drawable/Drawable;
    //   374: aload_1
    //   375: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   378: goto -> 416
    //   381: aload_0
    //   382: getfield mPaint : Landroid/graphics/Paint;
    //   385: aload #4
    //   387: invokevirtual measureText : (Ljava/lang/String;)F
    //   390: f2i
    //   391: istore #7
    //   393: aload_1
    //   394: aload #4
    //   396: aload_0
    //   397: invokevirtual getMeasuredWidth : ()I
    //   400: iload #7
    //   402: isub
    //   403: iconst_2
    //   404: idiv
    //   405: i2f
    //   406: iload #5
    //   408: i2f
    //   409: aload_0
    //   410: getfield mPaint : Landroid/graphics/Paint;
    //   413: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   416: iinc #2, 1
    //   419: goto -> 257
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    this.mItemHeight = (paramInt1 - getPaddingTop() - getPaddingBottom()) / this.count;
    this.mItemPadding = (int)((this.mItemHeight - this.mPaint.getTextSize()) / 2.0F);
    setMeasuredDimension(this.mOrgTextSzie + getPaddingLeft() + getPaddingRight(), paramInt2);
    this.mRect = new RectF(0.0F, getPaddingTop(), getMeasuredWidth(), (paramInt1 - getPaddingTop() - getPaddingBottom()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    switch (paramMotionEvent.getAction()) {
      default:
        invalidate();
        return true;
      case 1:
      case 3:
      case 4:
        this.mTouching = false;
      case 0:
      case 2:
        break;
    } 
    this.mTouching = true;
    int i = ((int)paramMotionEvent.getY() - getPaddingTop()) / this.mItemHeight;
    if (i != this.mIndex && (this.mNeedIndex == null || this.mNeedIndex[i]) && i < this.count && i >= 0) {
      this.mIndex = i;
      if (this.mListener != null)
        this.mListener.onIndexChange(this.mIndex); 
    } 
  }
  
  public void setIndexChangeListener(OnIndexChangeListener paramOnIndexChangeListener) {
    this.mListener = paramOnIndexChangeListener;
  }
  
  public void setIndexLetter(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    this.mIndexLetter = paramArrayOfString;
    this.count = this.mIndexLetter.length;
    this.mIndex = -1;
    invalidate();
  }
  
  public void setIndexMark(boolean[] paramArrayOfboolean) {
    if (paramArrayOfboolean == null)
      return; 
    this.mNeedIndex = paramArrayOfboolean;
    invalidate();
  }
  
  public static interface OnIndexChangeListener {
    void onIndexChange(int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\LetterIndexBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */