package com.unionpay.mobile.android.widgets;

import android.view.View;

final class l implements View.OnClickListener {
  l(k paramk) {}
  
  public final void onClick(View paramView) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   4: invokestatic a : (Lcom/unionpay/mobile/android/widgets/k;)Z
    //   7: ifeq -> 197
    //   10: new org/json/JSONObject
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   22: invokevirtual a : ()Ljava/lang/String;
    //   25: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   28: ifne -> 165
    //   31: aload_0
    //   32: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   35: invokevirtual a : ()Ljava/lang/String;
    //   38: ldc '[A-Za-z0-9]{8,32}'
    //   40: invokevirtual matches : (Ljava/lang/String;)Z
    //   43: ifeq -> 125
    //   46: aload_0
    //   47: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   50: iconst_1
    //   51: invokevirtual a : (Z)V
    //   54: aload_2
    //   55: ldc 'value'
    //   57: aload_0
    //   58: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   61: invokevirtual h : ()Ljava/lang/String;
    //   64: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_2
    //   69: ldc 'action'
    //   71: aload_0
    //   72: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   75: invokestatic b : (Lcom/unionpay/mobile/android/widgets/k;)Ljava/lang/String;
    //   78: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual setTag : (Ljava/lang/Object;)V
    //   87: aload_0
    //   88: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   91: invokestatic c : (Lcom/unionpay/mobile/android/widgets/k;)Ljava/util/ArrayList;
    //   94: invokevirtual iterator : ()Ljava/util/Iterator;
    //   97: astore_3
    //   98: aload_3
    //   99: invokeinterface hasNext : ()Z
    //   104: ifeq -> 253
    //   107: aload_3
    //   108: invokeinterface next : ()Ljava/lang/Object;
    //   113: checkcast android/view/View$OnClickListener
    //   116: aload_1
    //   117: invokeinterface onClick : (Landroid/view/View;)V
    //   122: goto -> 98
    //   125: aload_2
    //   126: ldc 'errMsg'
    //   128: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   131: getfield aD : Ljava/lang/String;
    //   134: iconst_1
    //   135: anewarray java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   143: getfield C : Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   150: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: goto -> 82
    //   157: astore_3
    //   158: aload_3
    //   159: invokevirtual printStackTrace : ()V
    //   162: goto -> 82
    //   165: aload_2
    //   166: ldc 'errMsg'
    //   168: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   171: getfield aC : Ljava/lang/String;
    //   174: iconst_1
    //   175: anewarray java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   183: getfield C : Ljava/lang/String;
    //   186: aastore
    //   187: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: goto -> 82
    //   197: aload_0
    //   198: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   201: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   204: invokevirtual e : ()V
    //   207: aload_0
    //   208: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   211: iconst_0
    //   212: invokevirtual a : (Z)V
    //   215: aload_0
    //   216: getfield a : Lcom/unionpay/mobile/android/widgets/k;
    //   219: invokestatic d : (Lcom/unionpay/mobile/android/widgets/k;)Ljava/util/ArrayList;
    //   222: invokevirtual iterator : ()Ljava/util/Iterator;
    //   225: astore_3
    //   226: aload_3
    //   227: invokeinterface hasNext : ()Z
    //   232: ifeq -> 253
    //   235: aload_3
    //   236: invokeinterface next : ()Ljava/lang/Object;
    //   241: checkcast android/view/View$OnClickListener
    //   244: aload_1
    //   245: invokeinterface onClick : (Landroid/view/View;)V
    //   250: goto -> 226
    //   253: return
    // Exception table:
    //   from	to	target	type
    //   18	82	157	org/json/JSONException
    //   125	154	157	org/json/JSONException
    //   165	194	157	org/json/JSONException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */