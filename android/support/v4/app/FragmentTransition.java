package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class FragmentTransition {
  private static final int[] INVERSE_OPS = new int[] { 0, 3, 0, 1, 5, 4, 7, 6 };
  
  private static void addSharedElementsWithMatchingNames(ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, Collection<String> paramCollection) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      View view = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(view)))
        paramArrayList.add(view); 
    } 
  }
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord.Op paramOp, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_1
    //   1: getfield fragment : Landroid/support/v4/app/Fragment;
    //   4: astore #5
    //   6: aload #5
    //   8: getfield mContainerId : I
    //   11: istore #6
    //   13: iload #6
    //   15: ifne -> 19
    //   18: return
    //   19: iload_3
    //   20: ifeq -> 277
    //   23: getstatic android/support/v4/app/FragmentTransition.INVERSE_OPS : [I
    //   26: aload_1
    //   27: getfield cmd : I
    //   30: iaload
    //   31: istore #7
    //   33: iload #7
    //   35: tableswitch default -> 76, 1 -> 346, 2 -> 76, 3 -> 484, 4 -> 398, 5 -> 286, 6 -> 484, 7 -> 346
    //   76: iconst_0
    //   77: istore #8
    //   79: iconst_0
    //   80: istore #7
    //   82: iconst_0
    //   83: istore #9
    //   85: iconst_0
    //   86: istore #10
    //   88: aload_2
    //   89: iload #6
    //   91: invokevirtual get : (I)Ljava/lang/Object;
    //   94: checkcast android/support/v4/app/FragmentTransition$FragmentContainerTransition
    //   97: astore_1
    //   98: iload #8
    //   100: ifeq -> 588
    //   103: aload_1
    //   104: aload_2
    //   105: iload #6
    //   107: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   110: astore_1
    //   111: aload_1
    //   112: aload #5
    //   114: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   117: aload_1
    //   118: iload_3
    //   119: putfield lastInIsPop : Z
    //   122: aload_1
    //   123: aload_0
    //   124: putfield lastInTransaction : Landroid/support/v4/app/BackStackRecord;
    //   127: iload #4
    //   129: ifne -> 204
    //   132: iload #7
    //   134: ifeq -> 204
    //   137: aload_1
    //   138: ifnull -> 155
    //   141: aload_1
    //   142: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   145: aload #5
    //   147: if_acmpne -> 155
    //   150: aload_1
    //   151: aconst_null
    //   152: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   155: aload_0
    //   156: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   159: astore #11
    //   161: aload #5
    //   163: getfield mState : I
    //   166: iconst_1
    //   167: if_icmpge -> 204
    //   170: aload #11
    //   172: getfield mCurState : I
    //   175: iconst_1
    //   176: if_icmplt -> 204
    //   179: aload_0
    //   180: getfield mAllowOptimization : Z
    //   183: ifne -> 204
    //   186: aload #11
    //   188: aload #5
    //   190: invokevirtual makeActive : (Landroid/support/v4/app/Fragment;)V
    //   193: aload #11
    //   195: aload #5
    //   197: iconst_1
    //   198: iconst_0
    //   199: iconst_0
    //   200: iconst_0
    //   201: invokevirtual moveToState : (Landroid/support/v4/app/Fragment;IIIZ)V
    //   204: iload #10
    //   206: ifeq -> 583
    //   209: aload_1
    //   210: ifnull -> 220
    //   213: aload_1
    //   214: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   217: ifnonnull -> 583
    //   220: aload_1
    //   221: aload_2
    //   222: iload #6
    //   224: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   227: astore_1
    //   228: aload_1
    //   229: aload #5
    //   231: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   234: aload_1
    //   235: iload_3
    //   236: putfield firstOutIsPop : Z
    //   239: aload_1
    //   240: aload_0
    //   241: putfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   244: aload_1
    //   245: astore_0
    //   246: iload #4
    //   248: ifne -> 18
    //   251: iload #9
    //   253: ifeq -> 18
    //   256: aload_0
    //   257: ifnull -> 18
    //   260: aload_0
    //   261: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   264: aload #5
    //   266: if_acmpne -> 18
    //   269: aload_0
    //   270: aconst_null
    //   271: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   274: goto -> 18
    //   277: aload_1
    //   278: getfield cmd : I
    //   281: istore #7
    //   283: goto -> 33
    //   286: iload #4
    //   288: ifeq -> 336
    //   291: aload #5
    //   293: getfield mHiddenChanged : Z
    //   296: ifeq -> 330
    //   299: aload #5
    //   301: getfield mHidden : Z
    //   304: ifne -> 330
    //   307: aload #5
    //   309: getfield mAdded : Z
    //   312: ifeq -> 330
    //   315: iconst_1
    //   316: istore #8
    //   318: iconst_1
    //   319: istore #7
    //   321: iconst_0
    //   322: istore #9
    //   324: iconst_0
    //   325: istore #10
    //   327: goto -> 88
    //   330: iconst_0
    //   331: istore #8
    //   333: goto -> 318
    //   336: aload #5
    //   338: getfield mHidden : Z
    //   341: istore #8
    //   343: goto -> 318
    //   346: iload #4
    //   348: ifeq -> 370
    //   351: aload #5
    //   353: getfield mIsNewlyAdded : Z
    //   356: istore #8
    //   358: iconst_1
    //   359: istore #7
    //   361: iconst_0
    //   362: istore #9
    //   364: iconst_0
    //   365: istore #10
    //   367: goto -> 88
    //   370: aload #5
    //   372: getfield mAdded : Z
    //   375: ifne -> 392
    //   378: aload #5
    //   380: getfield mHidden : Z
    //   383: ifne -> 392
    //   386: iconst_1
    //   387: istore #8
    //   389: goto -> 358
    //   392: iconst_0
    //   393: istore #8
    //   395: goto -> 358
    //   398: iload #4
    //   400: ifeq -> 456
    //   403: aload #5
    //   405: getfield mHiddenChanged : Z
    //   408: ifeq -> 450
    //   411: aload #5
    //   413: getfield mAdded : Z
    //   416: ifeq -> 450
    //   419: aload #5
    //   421: getfield mHidden : Z
    //   424: ifeq -> 450
    //   427: iconst_1
    //   428: istore #7
    //   430: iconst_0
    //   431: istore #8
    //   433: iconst_0
    //   434: istore #12
    //   436: iconst_1
    //   437: istore #9
    //   439: iload #7
    //   441: istore #10
    //   443: iload #12
    //   445: istore #7
    //   447: goto -> 88
    //   450: iconst_0
    //   451: istore #7
    //   453: goto -> 430
    //   456: aload #5
    //   458: getfield mAdded : Z
    //   461: ifeq -> 478
    //   464: aload #5
    //   466: getfield mHidden : Z
    //   469: ifne -> 478
    //   472: iconst_1
    //   473: istore #7
    //   475: goto -> 430
    //   478: iconst_0
    //   479: istore #7
    //   481: goto -> 430
    //   484: iload #4
    //   486: ifeq -> 555
    //   489: aload #5
    //   491: getfield mAdded : Z
    //   494: ifne -> 549
    //   497: aload #5
    //   499: getfield mView : Landroid/view/View;
    //   502: ifnull -> 549
    //   505: aload #5
    //   507: getfield mView : Landroid/view/View;
    //   510: invokevirtual getVisibility : ()I
    //   513: ifne -> 549
    //   516: aload #5
    //   518: getfield mPostponedAlpha : F
    //   521: fconst_0
    //   522: fcmpl
    //   523: iflt -> 549
    //   526: iconst_1
    //   527: istore #7
    //   529: iconst_0
    //   530: istore #8
    //   532: iconst_0
    //   533: istore #12
    //   535: iconst_1
    //   536: istore #9
    //   538: iload #7
    //   540: istore #10
    //   542: iload #12
    //   544: istore #7
    //   546: goto -> 88
    //   549: iconst_0
    //   550: istore #7
    //   552: goto -> 529
    //   555: aload #5
    //   557: getfield mAdded : Z
    //   560: ifeq -> 577
    //   563: aload #5
    //   565: getfield mHidden : Z
    //   568: ifne -> 577
    //   571: iconst_1
    //   572: istore #7
    //   574: goto -> 529
    //   577: iconst_0
    //   578: istore #7
    //   580: goto -> 529
    //   583: aload_1
    //   584: astore_0
    //   585: goto -> 246
    //   588: goto -> 127
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    int i = paramBackStackRecord.mOps.size();
    for (byte b = 0; b < i; b++)
      addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(b), paramSparseArray, false, paramBoolean); 
  }
  
  private static ArrayMap<String, String> calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    label27: while (--paramInt3 >= paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt3);
      if (!backStackRecord.interactsWith(paramInt1))
        continue; 
      boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
      if (backStackRecord.mSharedElementSourceNames != null) {
        ArrayList<String> arrayList1;
        ArrayList<String> arrayList2;
        int i = backStackRecord.mSharedElementSourceNames.size();
        if (bool) {
          arrayList1 = backStackRecord.mSharedElementSourceNames;
          arrayList2 = backStackRecord.mSharedElementTargetNames;
        } else {
          arrayList2 = backStackRecord.mSharedElementSourceNames;
          arrayList1 = backStackRecord.mSharedElementTargetNames;
        } 
        byte b = 0;
        while (true) {
          if (b < i) {
            String str2 = arrayList2.get(b);
            String str1 = arrayList1.get(b);
            String str3 = (String)arrayMap.remove(str1);
            if (str3 != null) {
              arrayMap.put(str2, str3);
            } else {
              arrayMap.put(str2, str1);
            } 
            b++;
            continue;
          } 
          paramInt3--;
          continue label27;
        } 
      } 
      continue;
    } 
    return arrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    if (paramBackStackRecord.mManager.mContainer.onHasView()) {
      int i = paramBackStackRecord.mOps.size() - 1;
      while (true) {
        if (i >= 0) {
          addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(i), paramSparseArray, true, paramBoolean);
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2) {
    SharedElementCallback sharedElementCallback;
    ArrayList<Object> arrayList1;
    ArrayList<Object> arrayList2;
    int i = 0;
    if (paramBoolean1) {
      sharedElementCallback = paramFragment2.getEnterTransitionCallback();
    } else {
      sharedElementCallback = sharedElementCallback.getEnterTransitionCallback();
    } 
    if (sharedElementCallback != null) {
      byte b;
      arrayList2 = new ArrayList();
      arrayList1 = new ArrayList();
      if (paramArrayMap == null) {
        b = 0;
      } else {
        i = paramArrayMap.size();
        b = 0;
      } 
      while (b < i) {
        arrayList1.add(paramArrayMap.keyAt(b));
        arrayList2.add(paramArrayMap.valueAt(b));
        b++;
      } 
      if (paramBoolean2) {
        sharedElementCallback.onSharedElementStart(arrayList1, arrayList2, null);
        return;
      } 
    } else {
      return;
    } 
    sharedElementCallback.onSharedElementEnd(arrayList1, arrayList2, null);
  }
  
  private static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> paramArrayMap, Object<String> paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    SharedElementCallback sharedElementCallback;
    Fragment fragment = paramFragmentContainerTransition.lastIn;
    View view = fragment.getView();
    if (paramArrayMap.isEmpty() || paramObject == null || view == null) {
      paramArrayMap.clear();
      return null;
    } 
    ArrayMap<String, View> arrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews((Map<String, View>)arrayMap, view);
    paramObject = (Object<String>)paramFragmentContainerTransition.lastInTransaction;
    if (paramFragmentContainerTransition.lastInIsPop) {
      sharedElementCallback = fragment.getExitTransitionCallback();
      paramObject = (Object<String>)((BackStackRecord)paramObject).mSharedElementSourceNames;
    } else {
      sharedElementCallback = fragment.getEnterTransitionCallback();
      arrayList = ((BackStackRecord)paramObject).mSharedElementTargetNames;
    } 
    if (arrayList != null)
      arrayMap.retainAll(arrayList); 
    if (sharedElementCallback != null) {
      sharedElementCallback.onMapSharedElements(arrayList, (Map<String, View>)arrayMap);
      for (int i = arrayList.size() - 1; i >= 0; i--) {
        String str1;
        String str2 = arrayList.get(i);
        View view1 = (View)arrayMap.get(str2);
        if (view1 == null) {
          str1 = findKeyForValue(paramArrayMap, str2);
          if (str1 != null)
            paramArrayMap.remove(str1); 
        } else if (!str2.equals(ViewCompat.getTransitionName((View)str1))) {
          str2 = findKeyForValue(paramArrayMap, str2);
          if (str2 != null)
            paramArrayMap.put(str2, ViewCompat.getTransitionName((View)str1)); 
        } 
      } 
    } else {
      retainValues(paramArrayMap, arrayMap);
    } 
    return arrayMap;
  }
  
  private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> paramArrayMap, Object<String> paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    SharedElementCallback sharedElementCallback;
    if (paramArrayMap.isEmpty() || paramObject == null) {
      paramArrayMap.clear();
      return null;
    } 
    Fragment fragment = paramFragmentContainerTransition.firstOut;
    ArrayMap<String, String> arrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews((Map)arrayMap, fragment.getView());
    paramObject = (Object<String>)paramFragmentContainerTransition.firstOutTransaction;
    if (paramFragmentContainerTransition.firstOutIsPop) {
      sharedElementCallback = fragment.getEnterTransitionCallback();
      paramObject = (Object<String>)((BackStackRecord)paramObject).mSharedElementTargetNames;
    } else {
      sharedElementCallback = fragment.getExitTransitionCallback();
      arrayList = ((BackStackRecord)paramObject).mSharedElementSourceNames;
    } 
    arrayMap.retainAll(arrayList);
    if (sharedElementCallback != null) {
      sharedElementCallback.onMapSharedElements(arrayList, (Map)arrayMap);
      for (int i = arrayList.size() - 1; i >= 0; i--) {
        String str = arrayList.get(i);
        View view = (View)arrayMap.get(str);
        if (view == null) {
          paramArrayMap.remove(str);
        } else if (!str.equals(ViewCompat.getTransitionName(view))) {
          str = (String)paramArrayMap.remove(str);
          paramArrayMap.put(ViewCompat.getTransitionName(view), str);
        } 
      } 
    } else {
      paramArrayMap.retainAll(arrayMap.keySet());
    } 
    return (ArrayMap)arrayMap;
  }
  
  private static ArrayList<View> configureEnteringExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView) {
    ArrayList<View> arrayList = null;
    if (paramObject != null) {
      ArrayList<View> arrayList1 = new ArrayList();
      View view = paramFragment.getView();
      if (view != null)
        FragmentTransitionCompat21.captureTransitioningViews(arrayList1, view); 
      if (paramArrayList != null)
        arrayList1.removeAll(paramArrayList); 
      arrayList = arrayList1;
      if (!arrayList1.isEmpty()) {
        arrayList1.add(paramView);
        FragmentTransitionCompat21.addTargets(paramObject, arrayList1);
        arrayList = arrayList1;
      } 
    } 
    return arrayList;
  }
  
  private static Object configureSharedElementsOptimized(ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #9
    //   6: aload_3
    //   7: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   10: astore #10
    //   12: aload_3
    //   13: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   16: astore #11
    //   18: aload #10
    //   20: ifnull -> 32
    //   23: aload #10
    //   25: invokevirtual getView : ()Landroid/view/View;
    //   28: iconst_0
    //   29: invokevirtual setVisibility : (I)V
    //   32: aload #9
    //   34: astore #12
    //   36: aload #10
    //   38: ifnull -> 50
    //   41: aload #11
    //   43: ifnonnull -> 53
    //   46: aload #9
    //   48: astore #12
    //   50: aload #12
    //   52: areturn
    //   53: aload_3
    //   54: getfield lastInIsPop : Z
    //   57: istore #13
    //   59: aload_2
    //   60: invokevirtual isEmpty : ()Z
    //   63: ifeq -> 253
    //   66: aconst_null
    //   67: astore #12
    //   69: aload_2
    //   70: aload #12
    //   72: aload_3
    //   73: invokestatic captureOutSharedElements : (Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    //   76: astore #14
    //   78: aload_2
    //   79: aload #12
    //   81: aload_3
    //   82: invokestatic captureInSharedElements : (Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    //   85: astore #15
    //   87: aload_2
    //   88: invokevirtual isEmpty : ()Z
    //   91: ifeq -> 267
    //   94: aload #14
    //   96: ifnull -> 104
    //   99: aload #14
    //   101: invokevirtual clear : ()V
    //   104: aload #15
    //   106: ifnull -> 303
    //   109: aload #15
    //   111: invokevirtual clear : ()V
    //   114: aconst_null
    //   115: astore_2
    //   116: aload #6
    //   118: ifnonnull -> 134
    //   121: aload #7
    //   123: ifnonnull -> 134
    //   126: aload #9
    //   128: astore #12
    //   130: aload_2
    //   131: ifnull -> 50
    //   134: aload #10
    //   136: aload #11
    //   138: iload #13
    //   140: aload #14
    //   142: iconst_1
    //   143: invokestatic callSharedElementStartEnd : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V
    //   146: aload_2
    //   147: ifnull -> 295
    //   150: aload #5
    //   152: aload_1
    //   153: invokevirtual add : (Ljava/lang/Object;)Z
    //   156: pop
    //   157: aload_2
    //   158: aload_1
    //   159: aload #4
    //   161: invokestatic setSharedElementTargets : (Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V
    //   164: aload_2
    //   165: aload #7
    //   167: aload #14
    //   169: aload_3
    //   170: getfield firstOutIsPop : Z
    //   173: aload_3
    //   174: getfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   177: invokestatic setOutEpicenter : (Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V
    //   180: new android/graphics/Rect
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore #4
    //   189: aload #15
    //   191: aload_3
    //   192: aload #6
    //   194: iload #13
    //   196: invokestatic getInEpicenterView : (Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;
    //   199: astore #5
    //   201: aload #5
    //   203: astore_1
    //   204: aload #4
    //   206: astore_3
    //   207: aload #5
    //   209: ifnull -> 225
    //   212: aload #6
    //   214: aload #4
    //   216: invokestatic setEpicenter : (Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   219: aload #4
    //   221: astore_3
    //   222: aload #5
    //   224: astore_1
    //   225: aload_0
    //   226: new android/support/v4/app/FragmentTransition$3
    //   229: dup
    //   230: aload #10
    //   232: aload #11
    //   234: iload #13
    //   236: aload #15
    //   238: aload_1
    //   239: aload_3
    //   240: invokespecial <init> : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Landroid/view/View;Landroid/graphics/Rect;)V
    //   243: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   246: pop
    //   247: aload_2
    //   248: astore #12
    //   250: goto -> 50
    //   253: aload #10
    //   255: aload #11
    //   257: iload #13
    //   259: invokestatic getSharedElementTransition : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   262: astore #12
    //   264: goto -> 69
    //   267: aload #4
    //   269: aload #14
    //   271: aload_2
    //   272: invokevirtual keySet : ()Ljava/util/Set;
    //   275: invokestatic addSharedElementsWithMatchingNames : (Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V
    //   278: aload #5
    //   280: aload #15
    //   282: aload_2
    //   283: invokevirtual values : ()Ljava/util/Collection;
    //   286: invokestatic addSharedElementsWithMatchingNames : (Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V
    //   289: aload #12
    //   291: astore_2
    //   292: goto -> 116
    //   295: aconst_null
    //   296: astore_3
    //   297: aload #8
    //   299: astore_1
    //   300: goto -> 225
    //   303: aconst_null
    //   304: astore_2
    //   305: goto -> 116
  }
  
  private static Object configureSharedElementsUnoptimized(ViewGroup paramViewGroup, final View nonExistentView, final ArrayMap<String, String> nameOverrides, final FragmentContainerTransition fragments, final ArrayList<View> sharedElementsOut, final ArrayList<View> sharedElementsIn, final Object enterTransition, final Object inEpicenter) {
    final Object finalSharedElementTransition;
    final Fragment inFragment = fragments.lastIn;
    final Fragment outFragment = fragments.firstOut;
    if (fragment1 == null || fragment2 == null)
      return null; 
    final boolean inIsPop = fragments.lastInIsPop;
    if (nameOverrides.isEmpty()) {
      object = null;
    } else {
      object = getSharedElementTransition(fragment1, fragment2, bool);
    } 
    ArrayMap<String, View> arrayMap = captureOutSharedElements(nameOverrides, object, fragments);
    if (nameOverrides.isEmpty()) {
      object = null;
    } else {
      sharedElementsOut.addAll(arrayMap.values());
    } 
    if (enterTransition == null && inEpicenter == null && object == null)
      return null; 
    callSharedElementStartEnd(fragment1, fragment2, bool, arrayMap, true);
    if (object != null) {
      Rect rect = new Rect();
      FragmentTransitionCompat21.setSharedElementTargets(object, nonExistentView, sharedElementsOut);
      setOutEpicenter(object, inEpicenter, arrayMap, fragments.firstOutIsPop, fragments.firstOutTransaction);
      inEpicenter = rect;
      if (enterTransition != null) {
        FragmentTransitionCompat21.setEpicenter(enterTransition, rect);
        inEpicenter = rect;
      } 
    } else {
      inEpicenter = null;
    } 
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            ArrayMap arrayMap = FragmentTransition.captureInSharedElements(nameOverrides, finalSharedElementTransition, fragments);
            if (arrayMap != null) {
              sharedElementsIn.addAll(arrayMap.values());
              sharedElementsIn.add(nonExistentView);
            } 
            FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, arrayMap, false);
            if (finalSharedElementTransition != null) {
              FragmentTransitionCompat21.swapSharedElementTargets(finalSharedElementTransition, sharedElementsOut, sharedElementsIn);
              View view = FragmentTransition.getInEpicenterView(arrayMap, fragments, enterTransition, inIsPop);
              if (view != null)
                FragmentTransitionCompat21.getBoundsOnScreen(view, inEpicenter); 
            } 
          }
        });
    return object;
  }
  
  private static void configureTransitionsOptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    boolean bool = paramFragmentManagerImpl.mContainer.onHasView();
    ViewGroup viewGroup = null;
    if (bool)
      viewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt); 
    if (viewGroup != null) {
      Fragment fragment1 = paramFragmentContainerTransition.lastIn;
      Fragment fragment2 = paramFragmentContainerTransition.firstOut;
      bool = paramFragmentContainerTransition.lastInIsPop;
      boolean bool1 = paramFragmentContainerTransition.firstOutIsPop;
      ArrayList<View> arrayList2 = new ArrayList();
      ArrayList<View> arrayList1 = new ArrayList();
      Object object2 = getEnterTransition(fragment1, bool);
      Object object3 = getExitTransition(fragment2, bool1);
      Object object1 = configureSharedElementsOptimized(viewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList1, arrayList2, object2, object3);
      if (object2 != null || object1 != null || object3 != null) {
        ArrayList<View> arrayList4 = configureEnteringExitingViews(object3, fragment2, arrayList1, paramView);
        ArrayList<View> arrayList3 = configureEnteringExitingViews(object2, fragment1, arrayList2, paramView);
        setViewVisibility(arrayList3, 4);
        Object object = mergeTransitions(object2, object3, object1, fragment1, bool);
        if (object != null) {
          replaceHide(object3, fragment2, arrayList4);
          ArrayList<String> arrayList = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(arrayList2);
          FragmentTransitionCompat21.scheduleRemoveTargets(object, object2, arrayList3, object3, arrayList4, object1, arrayList2);
          FragmentTransitionCompat21.beginDelayedTransition(viewGroup, object);
          FragmentTransitionCompat21.setNameOverridesOptimized((View)viewGroup, arrayList1, arrayList2, arrayList, (Map<String, String>)paramArrayMap);
          setViewVisibility(arrayList3, 0);
          FragmentTransitionCompat21.swapSharedElementTargets(object1, arrayList1, arrayList2);
        } 
      } 
    } 
  }
  
  private static void configureTransitionsUnoptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    boolean bool = paramFragmentManagerImpl.mContainer.onHasView();
    ViewGroup viewGroup = null;
    if (bool)
      viewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt); 
    if (viewGroup != null) {
      Fragment fragment1 = paramFragmentContainerTransition.lastIn;
      Fragment fragment2 = paramFragmentContainerTransition.firstOut;
      boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
      bool = paramFragmentContainerTransition.firstOutIsPop;
      Object object2 = getEnterTransition(fragment1, bool1);
      Object object1 = getExitTransition(fragment2, bool);
      ArrayList<View> arrayList1 = new ArrayList();
      ArrayList<View> arrayList2 = new ArrayList();
      Object object3 = configureSharedElementsUnoptimized(viewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList1, arrayList2, object2, object1);
      if (object2 != null || object3 != null || object1 != null) {
        arrayList1 = configureEnteringExitingViews(object1, fragment2, arrayList1, paramView);
        if (arrayList1 == null || arrayList1.isEmpty())
          object1 = null; 
        FragmentTransitionCompat21.addTarget(object2, paramView);
        Object object = mergeTransitions(object2, object1, object3, fragment1, paramFragmentContainerTransition.lastInIsPop);
        if (object != null) {
          ArrayList<View> arrayList = new ArrayList();
          FragmentTransitionCompat21.scheduleRemoveTargets(object, object2, arrayList, object1, arrayList1, object3, arrayList2);
          scheduleTargetChange(viewGroup, fragment1, paramView, arrayList2, object2, arrayList, object1, arrayList1);
          FragmentTransitionCompat21.setNameOverridesUnoptimized((View)viewGroup, arrayList2, (Map<String, String>)paramArrayMap);
          FragmentTransitionCompat21.beginDelayedTransition(viewGroup, object);
          FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList2, (Map<String, String>)paramArrayMap);
        } 
      } 
    } 
  }
  
  private static FragmentContainerTransition ensureContainer(FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentContainerTransition> paramSparseArray, int paramInt) {
    FragmentContainerTransition fragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null) {
      fragmentContainerTransition = new FragmentContainerTransition();
      paramSparseArray.put(paramInt, fragmentContainerTransition);
    } 
    return fragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap<String, String> paramArrayMap, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual size : ()I
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: iload_2
    //   9: if_icmpge -> 41
    //   12: aload_1
    //   13: aload_0
    //   14: iload_3
    //   15: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifeq -> 35
    //   24: aload_0
    //   25: iload_3
    //   26: invokevirtual keyAt : (I)Ljava/lang/Object;
    //   29: checkcast java/lang/String
    //   32: astore_0
    //   33: aload_0
    //   34: areturn
    //   35: iinc #3, 1
    //   38: goto -> 7
    //   41: aconst_null
    //   42: astore_0
    //   43: goto -> 33
  }
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean) {
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      null = paramFragment.getReenterTransition();
    } else {
      null = null.getEnterTransition();
    } 
    return FragmentTransitionCompat21.cloneTransition(null);
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean) {
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      null = paramFragment.getReturnTransition();
    } else {
      null = null.getExitTransition();
    } 
    return FragmentTransitionCompat21.cloneTransition(null);
  }
  
  private static View getInEpicenterView(ArrayMap<String, View> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean) {
    BackStackRecord backStackRecord = paramFragmentContainerTransition.lastInTransaction;
    if (paramObject != null && paramArrayMap != null && backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = backStackRecord.mSharedElementSourceNames.get(0);
      } else {
        str = ((BackStackRecord)str).mSharedElementTargetNames.get(0);
      } 
      return (View)paramArrayMap.get(str);
    } 
    return null;
  }
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean) {
    if (paramFragment1 == null || paramFragment2 == null)
      return null; 
    if (paramBoolean) {
      null = paramFragment2.getSharedElementReturnTransition();
    } else {
      null = null.getSharedElementEnterTransition();
    } 
    return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(null));
  }
  
  private static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean) {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramObject1 != null) {
      bool2 = bool1;
      if (paramObject2 != null) {
        bool2 = bool1;
        if (paramFragment != null)
          if (paramBoolean) {
            bool2 = paramFragment.getAllowReturnTransitionOverlap();
          } else {
            bool2 = paramFragment.getAllowEnterTransitionOverlap();
          }  
      } 
    } 
    return bool2 ? FragmentTransitionCompat21.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3) : FragmentTransitionCompat21.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(Object paramObject, Fragment paramFragment, final ArrayList<View> exitingViews) {
    if (paramFragment != null && paramObject != null && paramFragment.mAdded && paramFragment.mHidden && paramFragment.mHiddenChanged) {
      paramFragment.setHideReplaced(true);
      FragmentTransitionCompat21.scheduleHideFragmentView(paramObject, paramFragment.getView(), exitingViews);
      OneShotPreDrawListener.add((View)paramFragment.mContainer, new Runnable() {
            public void run() {
              FragmentTransition.setViewVisibility(exitingViews, 4);
            }
          });
    } 
  }
  
  private static void retainValues(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      if (!paramArrayMap1.containsKey(paramArrayMap.valueAt(i)))
        paramArrayMap.removeAt(i); 
    } 
  }
  
  private static void scheduleTargetChange(ViewGroup paramViewGroup, final Fragment inFragment, final View nonExistentView, final ArrayList<View> sharedElementsIn, final Object enterTransition, final ArrayList<View> enteringViews, final Object exitTransition, final ArrayList<View> exitingViews) {
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable() {
          public void run() {
            if (enterTransition != null) {
              FragmentTransitionCompat21.removeTarget(enterTransition, nonExistentView);
              ArrayList arrayList = FragmentTransition.configureEnteringExitingViews(enterTransition, inFragment, sharedElementsIn, nonExistentView);
              enteringViews.addAll(arrayList);
            } 
            if (exitingViews != null) {
              if (exitTransition != null) {
                ArrayList<View> arrayList = new ArrayList();
                arrayList.add(nonExistentView);
                FragmentTransitionCompat21.replaceTargets(exitTransition, exitingViews, arrayList);
              } 
              exitingViews.clear();
              exitingViews.add(nonExistentView);
            } 
          }
        });
  }
  
  private static void setOutEpicenter(Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord) {
    if (paramBackStackRecord.mSharedElementSourceNames != null && !paramBackStackRecord.mSharedElementSourceNames.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = paramBackStackRecord.mSharedElementTargetNames.get(0);
      } else {
        str = ((BackStackRecord)str).mSharedElementSourceNames.get(0);
      } 
      View view = (View)paramArrayMap.get(str);
      FragmentTransitionCompat21.setEpicenter(paramObject1, view);
      if (paramObject2 != null)
        FragmentTransitionCompat21.setEpicenter(paramObject2, view); 
    } 
  }
  
  private static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt) {
    if (paramArrayList != null) {
      int i = paramArrayList.size() - 1;
      while (true) {
        if (i >= 0) {
          ((View)paramArrayList.get(i)).setVisibility(paramInt);
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramFragmentManagerImpl.mCurState >= 1 && Build.VERSION.SDK_INT >= 21) {
      SparseArray<FragmentContainerTransition> sparseArray = new SparseArray();
      int i;
      for (i = paramInt1; i < paramInt2; i++) {
        BackStackRecord backStackRecord = paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
          calculatePopFragments(backStackRecord, sparseArray, paramBoolean);
        } else {
          calculateFragments(backStackRecord, sparseArray, paramBoolean);
        } 
      } 
      if (sparseArray.size() != 0) {
        View view = new View(paramFragmentManagerImpl.mHost.getContext());
        int j = sparseArray.size();
        i = 0;
        while (true) {
          if (i < j) {
            int k = sparseArray.keyAt(i);
            ArrayMap<String, String> arrayMap = calculateNameOverrides(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
            FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition)sparseArray.valueAt(i);
            if (paramBoolean) {
              configureTransitionsOptimized(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
            } else {
              configureTransitionsUnoptimized(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
            } 
            i++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  static class FragmentContainerTransition {
    public Fragment firstOut;
    
    public boolean firstOutIsPop;
    
    public BackStackRecord firstOutTransaction;
    
    public Fragment lastIn;
    
    public boolean lastInIsPop;
    
    public BackStackRecord lastInTransaction;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\FragmentTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */