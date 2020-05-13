package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;
import org.xmlpull.v1.XmlPullParser;

public class ResourceManager {
  private static final String DRAWABLE = "drawable";
  
  private static final String DRAWABLE_HDPI = "drawable-hdpi";
  
  private static final String DRAWABLE_LDPI = "drawable-ldpi";
  
  private static final String DRAWABLE_MDPI = "drawable-mdpi";
  
  private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
  
  private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
  
  private static final String[] PRE_INSTALL_DRAWBLE_PATHS = new String[] { "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable" };
  
  private static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";
  
  public static ColorStateList createColorStateList(int paramInt1, int paramInt2) {
    int[] arrayOfInt1 = { 16842919 };
    int[] arrayOfInt2 = StateSet.WILD_CARD;
    return new ColorStateList(new int[][] { arrayOfInt1, { 16842913 }, , { 16842908 }, , arrayOfInt2 }, new int[] { paramInt2, paramInt2, paramInt2, paramInt1 });
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2) {
    Drawable drawable1;
    Drawable drawable2;
    if (paramString1.indexOf(".9") > -1) {
      drawable2 = getNinePatchDrawable(paramContext, paramString1);
    } else {
      drawable2 = getDrawable(paramContext, (String)drawable2);
    } 
    if (paramString2.indexOf(".9") > -1) {
      drawable1 = getNinePatchDrawable(paramContext, paramString2);
    } else {
      drawable1 = getDrawable((Context)drawable1, paramString2);
    } 
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, drawable1);
    stateListDrawable.addState(new int[] { 16842913 }, drawable1);
    stateListDrawable.addState(new int[] { 16842908 }, drawable1);
    stateListDrawable.addState(StateSet.WILD_CARD, drawable2);
    return stateListDrawable;
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Drawable drawable1;
    Drawable drawable2;
    Drawable drawable3;
    if (paramString1.indexOf(".9") > -1) {
      drawable2 = getNinePatchDrawable(paramContext, paramString1);
    } else {
      drawable2 = getDrawable(paramContext, (String)drawable2);
    } 
    if (paramString3.indexOf(".9") > -1) {
      drawable3 = getNinePatchDrawable(paramContext, paramString3);
    } else {
      drawable3 = getDrawable(paramContext, (String)drawable3);
    } 
    if (paramString2.indexOf(".9") > -1) {
      drawable1 = getNinePatchDrawable(paramContext, paramString2);
    } else {
      drawable1 = getDrawable((Context)drawable1, paramString2);
    } 
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, drawable1);
    stateListDrawable.addState(new int[] { 16842913 }, drawable1);
    stateListDrawable.addState(new int[] { 16842908 }, drawable1);
    stateListDrawable.addState(new int[] { 16842766 }, drawable3);
    stateListDrawable.addState(StateSet.WILD_CARD, drawable2);
    return stateListDrawable;
  }
  
  public static int dp2px(Context paramContext, int paramInt) {
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    double d = (paramInt * displayMetrics.density);
    Double.isNaN(d);
    return (int)(d + 0.5D);
  }
  
  private static Drawable extractDrawable(Context paramContext, String paramString) throws Exception {
    InputStream inputStream = paramContext.getAssets().open(paramString);
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    TypedValue typedValue = new TypedValue();
    typedValue.density = displayMetrics.densityDpi;
    Drawable drawable = Drawable.createFromResourceStream(paramContext.getResources(), typedValue, inputStream, paramString);
    inputStream.close();
    return drawable;
  }
  
  private static View extractView(Context paramContext, String paramString, ViewGroup paramViewGroup) throws Exception {
    XmlResourceParser xmlResourceParser = paramContext.getAssets().openXmlResourceParser(paramString);
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate((XmlPullParser)xmlResourceParser, paramViewGroup);
  }
  
  private static String getAppropriatePathOfDrawable(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 17
    //   7: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   10: ldc 'id is NOT correct!'
    //   12: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokestatic getCurrentDpiFolder : (Landroid/content/Context;)Ljava/lang/String;
    //   21: astore_2
    //   22: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   25: ldc 'find Appropriate path...'
    //   27: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: iconst_0
    //   31: istore_3
    //   32: iconst_m1
    //   33: istore #4
    //   35: iconst_m1
    //   36: istore #5
    //   38: iconst_m1
    //   39: istore #6
    //   41: iload_3
    //   42: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   45: arraylength
    //   46: if_icmplt -> 59
    //   49: iconst_m1
    //   50: istore #7
    //   52: iload #5
    //   54: istore #8
    //   56: goto -> 153
    //   59: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   62: iload_3
    //   63: aaload
    //   64: aload_2
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifeq -> 74
    //   71: iload_3
    //   72: istore #5
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   81: iload_3
    //   82: aaload
    //   83: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: astore #9
    //   91: aload #9
    //   93: ldc '/'
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #9
    //   101: aload_1
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #9
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: astore #9
    //   113: iload #6
    //   115: istore #7
    //   117: aload_0
    //   118: aload #9
    //   120: invokestatic isFileExisted : (Landroid/content/Context;Ljava/lang/String;)Z
    //   123: ifeq -> 276
    //   126: iload #5
    //   128: iload_3
    //   129: if_icmpne -> 135
    //   132: aload #9
    //   134: areturn
    //   135: iload_3
    //   136: istore #7
    //   138: iload #5
    //   140: istore #8
    //   142: iload #5
    //   144: ifge -> 153
    //   147: iload_3
    //   148: istore #7
    //   150: goto -> 276
    //   153: iload #6
    //   155: ifle -> 185
    //   158: iload #7
    //   160: ifle -> 185
    //   163: iload #8
    //   165: iload #7
    //   167: isub
    //   168: invokestatic abs : (I)I
    //   171: iload #8
    //   173: iload #6
    //   175: isub
    //   176: invokestatic abs : (I)I
    //   179: if_icmpgt -> 195
    //   182: goto -> 211
    //   185: iload #6
    //   187: ifle -> 201
    //   190: iload #7
    //   192: ifge -> 201
    //   195: iload #6
    //   197: istore_3
    //   198: goto -> 228
    //   201: iload #6
    //   203: ifge -> 217
    //   206: iload #7
    //   208: ifle -> 217
    //   211: iload #7
    //   213: istore_3
    //   214: goto -> 228
    //   217: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   220: ldc 'Not find the appropriate path for drawable'
    //   222: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   225: iload #4
    //   227: istore_3
    //   228: iload_3
    //   229: ifge -> 242
    //   232: getstatic com/sina/weibo/sdk/utils/ResourceManager.TAG : Ljava/lang/String;
    //   235: ldc 'Not find the appropriate path for drawable'
    //   237: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   240: aconst_null
    //   241: areturn
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: getstatic com/sina/weibo/sdk/utils/ResourceManager.PRE_INSTALL_DRAWBLE_PATHS : [Ljava/lang/String;
    //   249: iload_3
    //   250: aaload
    //   251: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   254: invokespecial <init> : (Ljava/lang/String;)V
    //   257: astore_0
    //   258: aload_0
    //   259: ldc '/'
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_0
    //   266: aload_1
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_0
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: areturn
    //   276: iinc #3, 1
    //   279: iload #7
    //   281: istore #6
    //   283: goto -> 41
  }
  
  private static String getCurrentDpiFolder(Context paramContext) {
    int i = (paramContext.getResources().getDisplayMetrics()).densityDpi;
    return (i <= 120) ? "drawable-ldpi" : ((i > 120 && i <= 160) ? "drawable-mdpi" : ((i > 160 && i <= 240) ? "drawable-hdpi" : ((i > 240 && i <= 320) ? "drawable-xhdpi" : "drawable-xxhdpi")));
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString) {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), false);
  }
  
  private static Drawable getDrawableFromAssert(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore #4
    //   8: aconst_null
    //   9: astore #5
    //   11: aconst_null
    //   12: astore #6
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_3
    //   20: aload #6
    //   22: astore_1
    //   23: aload_3
    //   24: ifnull -> 176
    //   27: aload_3
    //   28: astore_1
    //   29: aload_3
    //   30: invokestatic decodeStream : (Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   33: astore #6
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   41: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   44: astore #7
    //   46: iload_2
    //   47: ifeq -> 136
    //   50: aload_3
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   56: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   59: astore #8
    //   61: aload_3
    //   62: astore_1
    //   63: new android/content/res/Resources
    //   66: astore #9
    //   68: aload_3
    //   69: astore_1
    //   70: aload #9
    //   72: aload_0
    //   73: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   76: aload #7
    //   78: aload #8
    //   80: invokespecial <init> : (Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   83: aload_3
    //   84: astore_1
    //   85: new android/graphics/drawable/NinePatchDrawable
    //   88: astore_0
    //   89: aload_3
    //   90: astore_1
    //   91: aload #6
    //   93: invokevirtual getNinePatchChunk : ()[B
    //   96: astore #8
    //   98: aload_3
    //   99: astore_1
    //   100: new android/graphics/Rect
    //   103: astore #7
    //   105: aload_3
    //   106: astore_1
    //   107: aload #7
    //   109: iconst_0
    //   110: iconst_0
    //   111: iconst_0
    //   112: iconst_0
    //   113: invokespecial <init> : (IIII)V
    //   116: aload_3
    //   117: astore_1
    //   118: aload_0
    //   119: aload #9
    //   121: aload #6
    //   123: aload #8
    //   125: aload #7
    //   127: aconst_null
    //   128: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   131: aload_0
    //   132: astore_1
    //   133: goto -> 176
    //   136: aload_3
    //   137: astore_1
    //   138: aload #6
    //   140: aload #7
    //   142: getfield densityDpi : I
    //   145: invokevirtual setDensity : (I)V
    //   148: aload_3
    //   149: astore_1
    //   150: new android/graphics/drawable/BitmapDrawable
    //   153: dup
    //   154: aload_0
    //   155: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   158: aload #6
    //   160: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   163: astore_0
    //   164: aload_0
    //   165: astore_1
    //   166: goto -> 176
    //   169: astore #6
    //   171: aload_3
    //   172: astore_0
    //   173: goto -> 214
    //   176: aload_1
    //   177: astore #6
    //   179: aload_3
    //   180: ifnull -> 241
    //   183: aload_1
    //   184: astore #6
    //   186: aload_3
    //   187: invokevirtual close : ()V
    //   190: aload_1
    //   191: astore #6
    //   193: goto -> 241
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual printStackTrace : ()V
    //   201: goto -> 241
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -> 245
    //   210: astore #6
    //   212: aconst_null
    //   213: astore_0
    //   214: aload_0
    //   215: astore_1
    //   216: aload #6
    //   218: invokevirtual printStackTrace : ()V
    //   221: aload #5
    //   223: astore #6
    //   225: aload_0
    //   226: ifnull -> 241
    //   229: aload #4
    //   231: astore #6
    //   233: aload_0
    //   234: invokevirtual close : ()V
    //   237: aload #5
    //   239: astore #6
    //   241: aload #6
    //   243: areturn
    //   244: astore_0
    //   245: aload_1
    //   246: ifnull -> 261
    //   249: aload_1
    //   250: invokevirtual close : ()V
    //   253: goto -> 261
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual printStackTrace : ()V
    //   261: aload_0
    //   262: athrow
    // Exception table:
    //   from	to	target	type
    //   14	20	210	java/io/IOException
    //   14	20	204	finally
    //   29	35	169	java/io/IOException
    //   29	35	244	finally
    //   37	46	169	java/io/IOException
    //   37	46	244	finally
    //   52	61	169	java/io/IOException
    //   52	61	244	finally
    //   63	68	169	java/io/IOException
    //   63	68	244	finally
    //   70	83	169	java/io/IOException
    //   70	83	244	finally
    //   85	89	169	java/io/IOException
    //   85	89	244	finally
    //   91	98	169	java/io/IOException
    //   91	98	244	finally
    //   100	105	169	java/io/IOException
    //   100	105	244	finally
    //   107	116	169	java/io/IOException
    //   107	116	244	finally
    //   118	131	169	java/io/IOException
    //   118	131	244	finally
    //   138	148	169	java/io/IOException
    //   138	148	244	finally
    //   150	164	169	java/io/IOException
    //   150	164	244	finally
    //   186	190	196	java/io/IOException
    //   216	221	244	finally
    //   233	237	196	java/io/IOException
    //   249	253	256	java/io/IOException
  }
  
  public static Locale getLanguage() {
    Locale locale = Locale.getDefault();
    return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : Locale.ENGLISH;
  }
  
  public static Drawable getNinePatchDrawable(Context paramContext, String paramString) {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), true);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Locale locale = getLanguage();
    return Locale.SIMPLIFIED_CHINESE.equals(locale) ? paramString2 : (Locale.TRADITIONAL_CHINESE.equals(locale) ? paramString3 : paramString1);
  }
  
  private static boolean isFileExisted(Context paramContext, String paramString) {
    if (paramContext == null || TextUtils.isEmpty(paramString))
      return false; 
    AssetManager assetManager2 = paramContext.getAssets();
    StringBuilder stringBuilder = null;
    paramContext = null;
    try {
      InputStream inputStream;
    } catch (IOException iOException1) {
    
    } finally {
      assetManager2 = null;
      iOException2 = iOException1;
      AssetManager assetManager = assetManager2;
      if (iOException2 != null)
        try {
          iOException2.close();
        } catch (IOException iOException2) {
          iOException2.printStackTrace();
        }  
    } 
    AssetManager assetManager1 = assetManager2;
    String str = TAG;
    assetManager1 = assetManager2;
    stringBuilder = new StringBuilder();
    assetManager1 = assetManager2;
    this("file [");
    assetManager1 = assetManager2;
    stringBuilder.append((String)iOException2);
    assetManager1 = assetManager2;
    stringBuilder.append("] NOT existed");
    assetManager1 = assetManager2;
    LogUtil.d(str, stringBuilder.toString());
    if (assetManager2 != null)
      try {
        assetManager2.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return false;
  }
  
  public static String readCountryFromAsset(Context paramContext, String paramString) {
    String str1;
    String str2 = "";
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      str1 = str2;
      if (inputStream != null) {
        DataInputStream dataInputStream = new DataInputStream();
        this(inputStream);
        byte[] arrayOfByte = new byte[dataInputStream.available()];
        dataInputStream.read(arrayOfByte);
        String str = EncodingUtils.getString(arrayOfByte, "UTF-8");
        try {
          inputStream.close();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } 
    } catch (IOException iOException) {
      str1 = str2;
      iOException.printStackTrace();
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\ResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */