package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
  static final Interpolator ACCELERATE_CUBIC;
  
  static final Interpolator ACCELERATE_QUINT;
  
  static final int ANIM_DUR = 220;
  
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  
  static boolean DEBUG = false;
  
  static final Interpolator DECELERATE_CUBIC;
  
  static final Interpolator DECELERATE_QUINT;
  
  static final boolean HONEYCOMB;
  
  static final String TAG = "FragmentManager";
  
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  
  static final String TARGET_STATE_TAG = "android:target_state";
  
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  
  static final String VIEW_STATE_TAG = "android:view_state";
  
  static Field sAnimationListenerField = null;
  
  ArrayList<Fragment> mActive;
  
  ArrayList<Fragment> mAdded;
  
  ArrayList<Integer> mAvailBackStackIndices;
  
  ArrayList<Integer> mAvailIndices;
  
  ArrayList<BackStackRecord> mBackStack;
  
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  
  ArrayList<BackStackRecord> mBackStackIndices;
  
  FragmentContainer mContainer;
  
  ArrayList<Fragment> mCreatedMenus;
  
  int mCurState = 0;
  
  boolean mDestroyed;
  
  Runnable mExecCommit = new Runnable() {
      public void run() {
        FragmentManagerImpl.this.execPendingActions();
      }
    };
  
  boolean mExecutingActions;
  
  boolean mHavePendingDeferredStart;
  
  FragmentHostCallback mHost;
  
  private CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks;
  
  boolean mNeedMenuInvalidate;
  
  String mNoTransactionsBecause;
  
  Fragment mParent;
  
  ArrayList<OpGenerator> mPendingActions;
  
  ArrayList<StartEnterTransitionListener> mPostponedTransactions;
  
  SparseArray<Parcelable> mStateArray = null;
  
  Bundle mStateBundle = null;
  
  boolean mStateSaved;
  
  Runnable[] mTmpActions;
  
  ArrayList<Fragment> mTmpAddedFragments;
  
  ArrayList<Boolean> mTmpIsPop;
  
  ArrayList<BackStackRecord> mTmpRecords;
  
  static {
    DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(2.5F);
    ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(1.5F);
  }
  
  private void addAddedFragments(ArraySet<Fragment> paramArraySet) {
    if (this.mCurState >= 1) {
      int j;
      int i = Math.min(this.mCurState, 4);
      if (this.mAdded == null) {
        j = 0;
      } else {
        j = this.mAdded.size();
      } 
      byte b = 0;
      while (true) {
        if (b < j) {
          Fragment fragment = this.mAdded.get(b);
          if (fragment.mState < i) {
            moveToState(fragment, i, fragment.getNextAnim(), fragment.getNextTransition(), false);
            if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded)
              paramArraySet.add(fragment); 
          } 
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void checkStateLoss() {
    if (this.mStateSaved)
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState"); 
    if (this.mNoTransactionsBecause != null)
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause); 
  }
  
  private void cleanupExec() {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    ArrayList<BackStackRecord> arrayList = new ArrayList(1);
    ArrayList<Boolean> arrayList1 = new ArrayList(1);
    arrayList.add(paramBackStackRecord);
    arrayList1.add(Boolean.valueOf(paramBoolean1));
    executeOps(arrayList, arrayList1, 0, 1);
    if (paramBoolean2)
      FragmentTransition.startTransitions(this, arrayList, arrayList1, 0, 1, true); 
    if (paramBoolean3)
      moveToState(this.mCurState, true); 
    if (this.mActive != null) {
      int i = this.mActive.size();
      for (byte b = 0; b < i; b++) {
        Fragment fragment = this.mActive.get(b);
        if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && paramBackStackRecord.interactsWith(fragment.mContainerId)) {
          if (Build.VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0F)
            fragment.mView.setAlpha(fragment.mPostponedAlpha); 
          if (paramBoolean3) {
            fragment.mPostponedAlpha = 0.0F;
          } else {
            fragment.mPostponedAlpha = -1.0F;
            fragment.mIsNewlyAdded = false;
          } 
        } 
      } 
    } 
  }
  
  private void endAnimatingAwayFragments() {
    int i;
    if (this.mActive == null) {
      i = 0;
    } else {
      i = this.mActive.size();
    } 
    for (byte b = 0; b < i; b++) {
      Fragment fragment = this.mActive.get(b);
      if (fragment != null && fragment.getAnimatingAway() != null) {
        int j = fragment.getStateAfterAnimating();
        View view = fragment.getAnimatingAway();
        fragment.setAnimatingAway(null);
        Animation animation = view.getAnimation();
        if (animation != null)
          animation.cancel(); 
        moveToState(fragment, j, 0, 0, false);
      } 
    } 
  }
  
  private void ensureExecReady(boolean paramBoolean) {
    if (this.mExecutingActions)
      throw new IllegalStateException("FragmentManager is already executing transactions"); 
    if (Looper.myLooper() != this.mHost.getHandler().getLooper())
      throw new IllegalStateException("Must be called from main thread of fragment host"); 
    if (!paramBoolean)
      checkStateLoss(); 
    if (this.mTmpRecords == null) {
      this.mTmpRecords = new ArrayList<BackStackRecord>();
      this.mTmpIsPop = new ArrayList<Boolean>();
    } 
    this.mExecutingActions = true;
    try {
      executePostponedTransaction(null, null);
      return;
    } finally {
      this.mExecutingActions = false;
    } 
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt1);
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue()) {
        boolean bool;
        backStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 == paramInt2 - 1) {
          bool = true;
        } else {
          bool = false;
        } 
        backStackRecord.executePopOps(bool);
      } else {
        backStackRecord.bumpBackStackNesting(1);
        backStackRecord.executeOps();
      } 
      paramInt1++;
    } 
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    int j;
    boolean bool = ((BackStackRecord)paramArrayList.get(paramInt1)).mAllowOptimization;
    if (this.mTmpAddedFragments == null) {
      this.mTmpAddedFragments = new ArrayList<Fragment>();
    } else {
      this.mTmpAddedFragments.clear();
    } 
    if (this.mAdded != null)
      this.mTmpAddedFragments.addAll(this.mAdded); 
    boolean bool1 = false;
    int i;
    for (i = paramInt1; i < paramInt2; i++) {
      BackStackRecord backStackRecord = paramArrayList.get(i);
      if (!((Boolean)paramArrayList1.get(i)).booleanValue()) {
        backStackRecord.expandReplaceOps(this.mTmpAddedFragments);
      } else {
        backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments);
      } 
      if (bool1 || backStackRecord.mAddToBackStack) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } 
    this.mTmpAddedFragments.clear();
    if (!bool)
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false); 
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool) {
      ArraySet<Fragment> arraySet = new ArraySet();
      addAddedFragments(arraySet);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, arraySet);
      makeRemovedFragmentsInvisible(arraySet);
    } else {
      j = paramInt2;
    } 
    i = paramInt1;
    if (j != paramInt1) {
      i = paramInt1;
      if (bool) {
        FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, j, true);
        moveToState(this.mCurState, true);
        i = paramInt1;
      } 
    } 
    while (i < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue() && backStackRecord.mIndex >= 0) {
        freeBackStackIndex(backStackRecord.mIndex);
        backStackRecord.mIndex = -1;
      } 
      i++;
    } 
    if (bool1)
      reportBackStackChanged(); 
  }
  
  private void executePostponedTransaction(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   4: ifnonnull -> 107
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: istore #4
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_3
    //   15: iload #4
    //   17: if_icmpge -> 252
    //   20: aload_0
    //   21: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   24: iload_3
    //   25: invokevirtual get : (I)Ljava/lang/Object;
    //   28: checkcast android/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener
    //   31: astore #5
    //   33: aload_1
    //   34: ifnull -> 118
    //   37: aload #5
    //   39: invokestatic access$000 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   42: ifne -> 118
    //   45: aload_1
    //   46: aload #5
    //   48: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   51: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   54: istore #6
    //   56: iload #6
    //   58: iconst_m1
    //   59: if_icmpeq -> 118
    //   62: aload_2
    //   63: iload #6
    //   65: invokevirtual get : (I)Ljava/lang/Object;
    //   68: checkcast java/lang/Boolean
    //   71: invokevirtual booleanValue : ()Z
    //   74: ifeq -> 118
    //   77: aload #5
    //   79: invokevirtual cancelTransaction : ()V
    //   82: iload #4
    //   84: istore #6
    //   86: iload_3
    //   87: istore #4
    //   89: iload #6
    //   91: istore_3
    //   92: iload #4
    //   94: iconst_1
    //   95: iadd
    //   96: istore #6
    //   98: iload_3
    //   99: istore #4
    //   101: iload #6
    //   103: istore_3
    //   104: goto -> 14
    //   107: aload_0
    //   108: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   111: invokevirtual size : ()I
    //   114: istore_3
    //   115: goto -> 9
    //   118: aload #5
    //   120: invokevirtual isReady : ()Z
    //   123: ifne -> 161
    //   126: iload #4
    //   128: istore #7
    //   130: iload_3
    //   131: istore #6
    //   133: aload_1
    //   134: ifnull -> 242
    //   137: iload #4
    //   139: istore #7
    //   141: iload_3
    //   142: istore #6
    //   144: aload #5
    //   146: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   149: aload_1
    //   150: iconst_0
    //   151: aload_1
    //   152: invokevirtual size : ()I
    //   155: invokevirtual interactsWith : (Ljava/util/ArrayList;II)Z
    //   158: ifeq -> 242
    //   161: aload_0
    //   162: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   165: iload_3
    //   166: invokevirtual remove : (I)Ljava/lang/Object;
    //   169: pop
    //   170: iload_3
    //   171: iconst_1
    //   172: isub
    //   173: istore #6
    //   175: iload #4
    //   177: iconst_1
    //   178: isub
    //   179: istore #7
    //   181: aload_1
    //   182: ifnull -> 237
    //   185: aload #5
    //   187: invokestatic access$000 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Z
    //   190: ifne -> 237
    //   193: aload_1
    //   194: aload #5
    //   196: invokestatic access$100 : (Landroid/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener;)Landroid/support/v4/app/BackStackRecord;
    //   199: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   202: istore_3
    //   203: iload_3
    //   204: iconst_m1
    //   205: if_icmpeq -> 237
    //   208: aload_2
    //   209: iload_3
    //   210: invokevirtual get : (I)Ljava/lang/Object;
    //   213: checkcast java/lang/Boolean
    //   216: invokevirtual booleanValue : ()Z
    //   219: ifeq -> 237
    //   222: aload #5
    //   224: invokevirtual cancelTransaction : ()V
    //   227: iload #7
    //   229: istore_3
    //   230: iload #6
    //   232: istore #4
    //   234: goto -> 92
    //   237: aload #5
    //   239: invokevirtual completeTransaction : ()V
    //   242: iload #7
    //   244: istore_3
    //   245: iload #6
    //   247: istore #4
    //   249: goto -> 92
    //   252: return
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment) {
    Fragment fragment = null;
    ViewGroup viewGroup = paramFragment.mContainer;
    View view = paramFragment.mView;
    if (viewGroup == null || view == null)
      return null; 
    for (int i = this.mAdded.indexOf(paramFragment) - 1;; i--) {
      paramFragment = fragment;
      if (i >= 0) {
        Fragment fragment1 = this.mAdded.get(i);
        if (fragment1.mContainer == viewGroup) {
          paramFragment = fragment1;
          if (fragment1.mView == null)
            continue; 
          return paramFragment;
        } 
        continue;
      } 
      return paramFragment;
    } 
  }
  
  private void forcePostponedTransactions() {
    if (this.mPostponedTransactions != null)
      while (!this.mPostponedTransactions.isEmpty())
        ((StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();  
  }
  
  private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPendingActions : Ljava/util/ArrayList;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield mPendingActions : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifne -> 25
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: ireturn
    //   25: aload_0
    //   26: getfield mPendingActions : Ljava/util/ArrayList;
    //   29: invokevirtual size : ()I
    //   32: istore #4
    //   34: iconst_0
    //   35: istore #5
    //   37: iload #5
    //   39: iload #4
    //   41: if_icmpge -> 70
    //   44: aload_0
    //   45: getfield mPendingActions : Ljava/util/ArrayList;
    //   48: iload #5
    //   50: invokevirtual get : (I)Ljava/lang/Object;
    //   53: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   56: aload_1
    //   57: aload_2
    //   58: invokeinterface generateOps : (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   63: pop
    //   64: iinc #5, 1
    //   67: goto -> 37
    //   70: aload_0
    //   71: getfield mPendingActions : Ljava/util/ArrayList;
    //   74: invokevirtual clear : ()V
    //   77: aload_0
    //   78: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   81: invokevirtual getHandler : ()Landroid/os/Handler;
    //   84: aload_0
    //   85: getfield mExecCommit : Ljava/lang/Runnable;
    //   88: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: iload #4
    //   95: ifle -> 108
    //   98: iconst_1
    //   99: istore_3
    //   100: goto -> 23
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: iconst_0
    //   109: istore_3
    //   110: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	19	103	finally
    //   19	21	103	finally
    //   25	34	103	finally
    //   44	64	103	finally
    //   70	93	103	finally
    //   104	106	103	finally
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    return (Animation)alphaAnimation;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(DECELERATE_QUINT);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)alphaAnimation);
    return (Animation)animationSet;
  }
  
  private void makeRemovedFragmentsInvisible(ArraySet<Fragment> paramArraySet) {
    int i = paramArraySet.size();
    for (byte b = 0; b < i; b++) {
      Fragment fragment = (Fragment)paramArraySet.valueAt(b);
      if (!fragment.mAdded) {
        View view = fragment.getView();
        if (Build.VERSION.SDK_INT < 11) {
          fragment.getView().setVisibility(4);
        } else {
          fragment.mPostponedAlpha = view.getAlpha();
          view.setAlpha(0.0F);
        } 
      } 
    } 
  }
  
  static boolean modifiesAlpha(Animation paramAnimation) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: instanceof android/view/animation/AlphaAnimation
    //   6: ifeq -> 13
    //   9: iload_1
    //   10: istore_2
    //   11: iload_2
    //   12: ireturn
    //   13: aload_0
    //   14: instanceof android/view/animation/AnimationSet
    //   17: ifeq -> 61
    //   20: aload_0
    //   21: checkcast android/view/animation/AnimationSet
    //   24: invokevirtual getAnimations : ()Ljava/util/List;
    //   27: astore_0
    //   28: iconst_0
    //   29: istore_3
    //   30: iload_3
    //   31: aload_0
    //   32: invokeinterface size : ()I
    //   37: if_icmpge -> 61
    //   40: iload_1
    //   41: istore_2
    //   42: aload_0
    //   43: iload_3
    //   44: invokeinterface get : (I)Ljava/lang/Object;
    //   49: instanceof android/view/animation/AlphaAnimation
    //   52: ifne -> 11
    //   55: iinc #3, 1
    //   58: goto -> 30
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -> 11
  }
  
  private void optimizeAndExecuteOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    int i = 0;
    if (paramArrayList != null && !paramArrayList.isEmpty()) {
      if (paramArrayList1 == null || paramArrayList.size() != paramArrayList1.size())
        throw new IllegalStateException("Internal error with the back stack records"); 
      executePostponedTransaction(paramArrayList, paramArrayList1);
      int j = paramArrayList.size();
      for (int k = 0; k < j; k++) {
        if (!((BackStackRecord)paramArrayList.get(k)).mAllowOptimization) {
          if (i != k)
            executeOpsTogether(paramArrayList, paramArrayList1, i, k); 
          int m = k + 1;
          i = m;
          if (((Boolean)paramArrayList1.get(k)).booleanValue())
            while (true) {
              i = m;
              if (m < j) {
                i = m;
                if (((Boolean)paramArrayList1.get(m)).booleanValue()) {
                  i = m;
                  if (!((BackStackRecord)paramArrayList.get(m)).mAllowOptimization) {
                    m++;
                    continue;
                  } 
                } 
              } 
              break;
            }  
          executeOpsTogether(paramArrayList, paramArrayList1, k, i);
          k = i;
          m = i - 1;
          i = k;
          k = m;
        } 
      } 
      if (i != j)
        executeOpsTogether(paramArrayList, paramArrayList1, i, j); 
    } 
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2) {
    execPendingActions();
    ensureExecReady(true);
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        return bool;
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    return bool;
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, ArraySet<Fragment> paramArraySet) {
    int i = paramInt2;
    for (int j = paramInt2 - 1; j >= paramInt1; j--) {
      boolean bool1;
      BackStackRecord backStackRecord = paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(paramArrayList, j + 1, paramInt2)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        if (this.mPostponedTransactions == null)
          this.mPostponedTransactions = new ArrayList<StartEnterTransitionListener>(); 
        StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, bool);
        this.mPostponedTransactions.add(startEnterTransitionListener);
        backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
        if (bool) {
          backStackRecord.executeOps();
        } else {
          backStackRecord.executePopOps(false);
        } 
        if (j != --i) {
          paramArrayList.remove(j);
          paramArrayList.add(i, backStackRecord);
        } 
        addAddedFragments(paramArraySet);
      } 
    } 
    return i;
  }
  
  public static int reverseTransit(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 4097:
        return 8194;
      case 8194:
        return 4097;
      case 4099:
        break;
    } 
    return 4099;
  }
  
  private void scheduleCommit() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   8: ifnull -> 86
    //   11: aload_0
    //   12: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   15: invokevirtual isEmpty : ()Z
    //   18: ifne -> 86
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_0
    //   24: getfield mPendingActions : Ljava/util/ArrayList;
    //   27: ifnull -> 91
    //   30: aload_0
    //   31: getfield mPendingActions : Ljava/util/ArrayList;
    //   34: invokevirtual size : ()I
    //   37: iconst_1
    //   38: if_icmpne -> 91
    //   41: iload_2
    //   42: ifne -> 49
    //   45: iload_1
    //   46: ifeq -> 78
    //   49: aload_0
    //   50: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   53: invokevirtual getHandler : ()Landroid/os/Handler;
    //   56: aload_0
    //   57: getfield mExecCommit : Ljava/lang/Runnable;
    //   60: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   63: aload_0
    //   64: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   67: invokevirtual getHandler : ()Landroid/os/Handler;
    //   70: aload_0
    //   71: getfield mExecCommit : Ljava/lang/Runnable;
    //   74: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   77: pop
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -> 23
    //   91: iconst_0
    //   92: istore_1
    //   93: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   4	21	81	finally
    //   23	41	81	finally
    //   49	78	81	finally
    //   78	80	81	finally
    //   82	84	81	finally
  }
  
  private void setHWLayerAnimListenerIfAlpha(View paramView, Animation paramAnimation) {
    if (paramView != null && paramAnimation != null && shouldRunOnHWLayer(paramView, paramAnimation)) {
      try {
        if (sAnimationListenerField == null) {
          sAnimationListenerField = Animation.class.getDeclaredField("mListener");
          sAnimationListenerField.setAccessible(true);
        } 
        Animation.AnimationListener animationListener = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", noSuchFieldException);
        noSuchFieldException = null;
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("FragmentManager", "Cannot access Animation's mListener field", illegalAccessException);
        illegalAccessException = null;
      } 
      ViewCompat.setLayerType(paramView, 2, null);
      paramAnimation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(paramView, paramAnimation, (Animation.AnimationListener)illegalAccessException));
    } 
  }
  
  static boolean shouldRunOnHWLayer(View paramView, Animation paramAnimation) {
    return (Build.VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(paramView) == 0 && ViewCompat.hasOverlappingRendering(paramView) && modifiesAlpha(paramAnimation));
  }
  
  private void throwException(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
    if (this.mHost != null) {
      try {
        this.mHost.onDump("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
      throw paramRuntimeException;
    } 
    try {
      dump("  ", null, (PrintWriter)exception, new String[0]);
    } catch (Exception exception1) {
      Log.e("FragmentManager", "Failed dumping state", exception1);
    } 
    throw paramRuntimeException;
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return -1;
      case 4097:
        return paramBoolean ? 1 : 2;
      case 8194:
        return paramBoolean ? 3 : 4;
      case 4099:
        break;
    } 
    return paramBoolean ? 5 : 6;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord) {
    if (this.mBackStack == null)
      this.mBackStack = new ArrayList<BackStackRecord>(); 
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean) {
    if (this.mAdded == null)
      this.mAdded = new ArrayList<Fragment>(); 
    if (DEBUG)
      Log.v("FragmentManager", "add: " + paramFragment); 
    makeActive(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.mAdded.contains(paramFragment))
        throw new IllegalStateException("Fragment already added: " + paramFragment); 
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null)
        paramFragment.mHiddenChanged = false; 
      if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
        this.mNeedMenuInvalidate = true; 
      if (paramBoolean)
        moveToState(paramFragment); 
    } 
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.mBackStackChangeListeners == null)
      this.mBackStackChangeListeners = new ArrayList<FragmentManager.OnBackStackChangedListener>(); 
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 104
    //   19: aload_0
    //   20: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   23: ifnonnull -> 39
    //   26: new java/util/ArrayList
    //   29: astore_2
    //   30: aload_2
    //   31: invokespecial <init> : ()V
    //   34: aload_0
    //   35: aload_2
    //   36: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   39: aload_0
    //   40: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   43: invokevirtual size : ()I
    //   46: istore_3
    //   47: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   50: ifeq -> 91
    //   53: new java/lang/StringBuilder
    //   56: astore_2
    //   57: aload_2
    //   58: invokespecial <init> : ()V
    //   61: ldc 'FragmentManager'
    //   63: aload_2
    //   64: ldc_w 'Setting back stack index '
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_3
    //   71: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   74: ldc_w ' to '
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: aload_0
    //   92: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   95: aload_1
    //   96: invokevirtual add : (Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload_0
    //   101: monitorexit
    //   102: iload_3
    //   103: ireturn
    //   104: aload_0
    //   105: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   108: aload_0
    //   109: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   112: invokevirtual size : ()I
    //   115: iconst_1
    //   116: isub
    //   117: invokevirtual remove : (I)Ljava/lang/Object;
    //   120: checkcast java/lang/Integer
    //   123: invokevirtual intValue : ()I
    //   126: istore_3
    //   127: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   130: ifeq -> 171
    //   133: new java/lang/StringBuilder
    //   136: astore_2
    //   137: aload_2
    //   138: invokespecial <init> : ()V
    //   141: ldc 'FragmentManager'
    //   143: aload_2
    //   144: ldc_w 'Adding back stack index '
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_3
    //   151: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   154: ldc_w ' with '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual toString : ()Ljava/lang/String;
    //   167: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: aload_0
    //   172: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   175: iload_3
    //   176: aload_1
    //   177: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload_0
    //   182: monitorexit
    //   183: goto -> 102
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	186	finally
    //   19	39	186	finally
    //   39	91	186	finally
    //   91	102	186	finally
    //   104	171	186	finally
    //   171	183	186	finally
    //   187	189	186	finally
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment) {
    if (this.mHost != null)
      throw new IllegalStateException("Already attached"); 
    this.mHost = paramFragmentHostCallback;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment) {
    if (DEBUG)
      Log.v("FragmentManager", "attach: " + paramFragment); 
    if (paramFragment.mDetached) {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded) {
        if (this.mAdded == null)
          this.mAdded = new ArrayList<Fragment>(); 
        if (this.mAdded.contains(paramFragment))
          throw new IllegalStateException("Fragment already added: " + paramFragment); 
        if (DEBUG)
          Log.v("FragmentManager", "add from attach: " + paramFragment); 
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
      } 
    } 
  }
  
  public FragmentTransaction beginTransaction() {
    return new BackStackRecord(this);
  }
  
  void completeShowHideFragment(Fragment paramFragment) {
    if (paramFragment.mView != null) {
      boolean bool;
      int i = paramFragment.getNextTransition();
      if (!paramFragment.mHidden) {
        bool = true;
      } else {
        bool = false;
      } 
      Animation animation = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if (animation != null) {
        setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
        paramFragment.mView.startAnimation(animation);
        setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
        animation.start();
      } 
      if (paramFragment.mHidden && !paramFragment.isHideReplaced()) {
        i = 8;
      } else {
        i = 0;
      } 
      paramFragment.mView.setVisibility(i);
      if (paramFragment.isHideReplaced())
        paramFragment.setHideReplaced(false); 
    } 
    if (paramFragment.mAdded && paramFragment.mHasMenu && paramFragment.mMenuVisible)
      this.mNeedMenuInvalidate = true; 
    paramFragment.mHiddenChanged = false;
    paramFragment.onHiddenChanged(paramFragment.mHidden);
  }
  
  public void detachFragment(Fragment paramFragment) {
    if (DEBUG)
      Log.v("FragmentManager", "detach: " + paramFragment); 
    if (!paramFragment.mDetached) {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (this.mAdded != null) {
          if (DEBUG)
            Log.v("FragmentManager", "remove from detach: " + paramFragment); 
          this.mAdded.remove(paramFragment);
        } 
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
        paramFragment.mAdded = false;
      } 
    } 
  }
  
  public void dispatchActivityCreated() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(2, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    if (this.mAdded != null)
      for (byte b = 0; b < this.mAdded.size(); b++) {
        Fragment fragment = this.mAdded.get(b);
        if (fragment != null)
          fragment.performConfigurationChanged(paramConfiguration); 
      }  
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.mAdded != null)
      for (byte b = 0;; b++) {
        bool2 = bool1;
        if (b < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(b);
          if (fragment != null && fragment.performContextItemSelected(paramMenuItem))
            return true; 
        } else {
          return bool2;
        } 
      }  
    return bool2;
  }
  
  public void dispatchCreate() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(1, false);
    this.mExecutingActions = false;
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    boolean bool;
    byte b = 0;
    ArrayList<Fragment> arrayList1 = null;
    ArrayList<Fragment> arrayList2 = null;
    if (this.mAdded != null) {
      byte b1 = 0;
      boolean bool1 = false;
      while (true) {
        arrayList1 = arrayList2;
        bool = bool1;
        if (b1 < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(b1);
          arrayList1 = arrayList2;
          bool = bool1;
          if (fragment != null) {
            arrayList1 = arrayList2;
            bool = bool1;
            if (fragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)) {
              bool = true;
              arrayList1 = arrayList2;
              if (arrayList2 == null)
                arrayList1 = new ArrayList(); 
              arrayList1.add(fragment);
            } 
          } 
          b1++;
          bool1 = bool;
          arrayList2 = arrayList1;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    if (this.mCreatedMenus != null)
      for (byte b1 = b; b1 < this.mCreatedMenus.size(); b1++) {
        Fragment fragment = this.mCreatedMenus.get(b1);
        if (arrayList1 == null || !arrayList1.contains(fragment))
          fragment.onDestroyOptionsMenu(); 
      }  
    this.mCreatedMenus = arrayList1;
    return bool;
  }
  
  public void dispatchDestroy() {
    this.mDestroyed = true;
    execPendingActions();
    this.mExecutingActions = true;
    moveToState(0, false);
    this.mExecutingActions = false;
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView() {
    this.mExecutingActions = true;
    moveToState(1, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchLowMemory() {
    if (this.mAdded != null)
      for (byte b = 0; b < this.mAdded.size(); b++) {
        Fragment fragment = this.mAdded.get(b);
        if (fragment != null)
          fragment.performLowMemory(); 
      }  
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    if (this.mAdded != null) {
      int i = this.mAdded.size() - 1;
      while (true) {
        if (i >= 0) {
          Fragment fragment = this.mAdded.get(i);
          if (fragment != null)
            fragment.performMultiWindowModeChanged(paramBoolean); 
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentActivityCreated(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentAttached(paramFragment, paramContext, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentAttached(this, paramFragment, paramContext); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentCreated(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentCreated(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDestroyed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDestroyed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDetached(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentDetached(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPaused(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPaused(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreAttached(paramFragment, paramContext, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentPreAttached(this, paramFragment, paramContext); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentResumed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentResumed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentSaveInstanceState(this, paramFragment, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStarted(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStarted(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStopped(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentStopped(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewCreated(this, paramFragment, paramView, paramBundle); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManager fragmentManager = this.mParent.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewDestroyed(paramFragment, true); 
    } 
    if (this.mLifecycleCallbacks != null) {
      Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> iterator = this.mLifecycleCallbacks.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (!paramBoolean || ((Boolean)pair.second).booleanValue())
            ((FragmentManager.FragmentLifecycleCallbacks)pair.first).onFragmentViewDestroyed(this, paramFragment); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.mAdded != null)
      for (byte b = 0;; b++) {
        bool2 = bool1;
        if (b < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(b);
          if (fragment != null && fragment.performOptionsItemSelected(paramMenuItem))
            return true; 
        } else {
          return bool2;
        } 
      }  
    return bool2;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    if (this.mAdded != null)
      for (byte b = 0; b < this.mAdded.size(); b++) {
        Fragment fragment = this.mAdded.get(b);
        if (fragment != null)
          fragment.performOptionsMenuClosed(paramMenu); 
      }  
  }
  
  public void dispatchPause() {
    this.mExecutingActions = true;
    moveToState(4, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    if (this.mAdded != null) {
      int i = this.mAdded.size() - 1;
      while (true) {
        if (i >= 0) {
          Fragment fragment = this.mAdded.get(i);
          if (fragment != null)
            fragment.performPictureInPictureModeChanged(paramBoolean); 
          i--;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    boolean bool;
    if (this.mAdded != null) {
      byte b = 0;
      boolean bool1 = false;
      while (true) {
        bool = bool1;
        if (b < this.mAdded.size()) {
          Fragment fragment = this.mAdded.get(b);
          bool = bool1;
          if (fragment != null) {
            bool = bool1;
            if (fragment.performPrepareOptionsMenu(paramMenu))
              bool = true; 
          } 
          b++;
          bool1 = bool;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void dispatchReallyStop() {
    this.mExecutingActions = true;
    moveToState(2, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchResume() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(5, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchStart() {
    this.mStateSaved = false;
    this.mExecutingActions = true;
    moveToState(4, false);
    this.mExecutingActions = false;
  }
  
  public void dispatchStop() {
    this.mStateSaved = true;
    this.mExecutingActions = true;
    moveToState(3, false);
    this.mExecutingActions = false;
  }
  
  void doPendingDeferredStart() {
    if (this.mHavePendingDeferredStart) {
      boolean bool = false;
      for (byte b = 0; b < this.mActive.size(); b++) {
        Fragment fragment = this.mActive.get(b);
        if (fragment != null && fragment.mLoaderManager != null)
          bool |= fragment.mLoaderManager.hasRunningLoaders(); 
      } 
      if (!bool) {
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
      } 
    } 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #5
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: aload_1
    //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w '    '
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: astore #6
    //   25: aload_0
    //   26: getfield mActive : Ljava/util/ArrayList;
    //   29: ifnull -> 153
    //   32: aload_0
    //   33: getfield mActive : Ljava/util/ArrayList;
    //   36: invokevirtual size : ()I
    //   39: istore #7
    //   41: iload #7
    //   43: ifle -> 153
    //   46: aload_3
    //   47: aload_1
    //   48: invokevirtual print : (Ljava/lang/String;)V
    //   51: aload_3
    //   52: ldc_w 'Active Fragments in '
    //   55: invokevirtual print : (Ljava/lang/String;)V
    //   58: aload_3
    //   59: aload_0
    //   60: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   63: invokestatic toHexString : (I)Ljava/lang/String;
    //   66: invokevirtual print : (Ljava/lang/String;)V
    //   69: aload_3
    //   70: ldc_w ':'
    //   73: invokevirtual println : (Ljava/lang/String;)V
    //   76: iconst_0
    //   77: istore #8
    //   79: iload #8
    //   81: iload #7
    //   83: if_icmpge -> 153
    //   86: aload_0
    //   87: getfield mActive : Ljava/util/ArrayList;
    //   90: iload #8
    //   92: invokevirtual get : (I)Ljava/lang/Object;
    //   95: checkcast android/support/v4/app/Fragment
    //   98: astore #9
    //   100: aload_3
    //   101: aload_1
    //   102: invokevirtual print : (Ljava/lang/String;)V
    //   105: aload_3
    //   106: ldc_w '  #'
    //   109: invokevirtual print : (Ljava/lang/String;)V
    //   112: aload_3
    //   113: iload #8
    //   115: invokevirtual print : (I)V
    //   118: aload_3
    //   119: ldc_w ': '
    //   122: invokevirtual print : (Ljava/lang/String;)V
    //   125: aload_3
    //   126: aload #9
    //   128: invokevirtual println : (Ljava/lang/Object;)V
    //   131: aload #9
    //   133: ifnull -> 147
    //   136: aload #9
    //   138: aload #6
    //   140: aload_2
    //   141: aload_3
    //   142: aload #4
    //   144: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   147: iinc #8, 1
    //   150: goto -> 79
    //   153: aload_0
    //   154: getfield mAdded : Ljava/util/ArrayList;
    //   157: ifnull -> 250
    //   160: aload_0
    //   161: getfield mAdded : Ljava/util/ArrayList;
    //   164: invokevirtual size : ()I
    //   167: istore #7
    //   169: iload #7
    //   171: ifle -> 250
    //   174: aload_3
    //   175: aload_1
    //   176: invokevirtual print : (Ljava/lang/String;)V
    //   179: aload_3
    //   180: ldc_w 'Added Fragments:'
    //   183: invokevirtual println : (Ljava/lang/String;)V
    //   186: iconst_0
    //   187: istore #8
    //   189: iload #8
    //   191: iload #7
    //   193: if_icmpge -> 250
    //   196: aload_0
    //   197: getfield mAdded : Ljava/util/ArrayList;
    //   200: iload #8
    //   202: invokevirtual get : (I)Ljava/lang/Object;
    //   205: checkcast android/support/v4/app/Fragment
    //   208: astore #9
    //   210: aload_3
    //   211: aload_1
    //   212: invokevirtual print : (Ljava/lang/String;)V
    //   215: aload_3
    //   216: ldc_w '  #'
    //   219: invokevirtual print : (Ljava/lang/String;)V
    //   222: aload_3
    //   223: iload #8
    //   225: invokevirtual print : (I)V
    //   228: aload_3
    //   229: ldc_w ': '
    //   232: invokevirtual print : (Ljava/lang/String;)V
    //   235: aload_3
    //   236: aload #9
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: invokevirtual println : (Ljava/lang/String;)V
    //   244: iinc #8, 1
    //   247: goto -> 189
    //   250: aload_0
    //   251: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   254: ifnull -> 347
    //   257: aload_0
    //   258: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   261: invokevirtual size : ()I
    //   264: istore #7
    //   266: iload #7
    //   268: ifle -> 347
    //   271: aload_3
    //   272: aload_1
    //   273: invokevirtual print : (Ljava/lang/String;)V
    //   276: aload_3
    //   277: ldc_w 'Fragments Created Menus:'
    //   280: invokevirtual println : (Ljava/lang/String;)V
    //   283: iconst_0
    //   284: istore #8
    //   286: iload #8
    //   288: iload #7
    //   290: if_icmpge -> 347
    //   293: aload_0
    //   294: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   297: iload #8
    //   299: invokevirtual get : (I)Ljava/lang/Object;
    //   302: checkcast android/support/v4/app/Fragment
    //   305: astore #9
    //   307: aload_3
    //   308: aload_1
    //   309: invokevirtual print : (Ljava/lang/String;)V
    //   312: aload_3
    //   313: ldc_w '  #'
    //   316: invokevirtual print : (Ljava/lang/String;)V
    //   319: aload_3
    //   320: iload #8
    //   322: invokevirtual print : (I)V
    //   325: aload_3
    //   326: ldc_w ': '
    //   329: invokevirtual print : (Ljava/lang/String;)V
    //   332: aload_3
    //   333: aload #9
    //   335: invokevirtual toString : ()Ljava/lang/String;
    //   338: invokevirtual println : (Ljava/lang/String;)V
    //   341: iinc #8, 1
    //   344: goto -> 286
    //   347: aload_0
    //   348: getfield mBackStack : Ljava/util/ArrayList;
    //   351: ifnull -> 455
    //   354: aload_0
    //   355: getfield mBackStack : Ljava/util/ArrayList;
    //   358: invokevirtual size : ()I
    //   361: istore #7
    //   363: iload #7
    //   365: ifle -> 455
    //   368: aload_3
    //   369: aload_1
    //   370: invokevirtual print : (Ljava/lang/String;)V
    //   373: aload_3
    //   374: ldc_w 'Back Stack:'
    //   377: invokevirtual println : (Ljava/lang/String;)V
    //   380: iconst_0
    //   381: istore #8
    //   383: iload #8
    //   385: iload #7
    //   387: if_icmpge -> 455
    //   390: aload_0
    //   391: getfield mBackStack : Ljava/util/ArrayList;
    //   394: iload #8
    //   396: invokevirtual get : (I)Ljava/lang/Object;
    //   399: checkcast android/support/v4/app/BackStackRecord
    //   402: astore #9
    //   404: aload_3
    //   405: aload_1
    //   406: invokevirtual print : (Ljava/lang/String;)V
    //   409: aload_3
    //   410: ldc_w '  #'
    //   413: invokevirtual print : (Ljava/lang/String;)V
    //   416: aload_3
    //   417: iload #8
    //   419: invokevirtual print : (I)V
    //   422: aload_3
    //   423: ldc_w ': '
    //   426: invokevirtual print : (Ljava/lang/String;)V
    //   429: aload_3
    //   430: aload #9
    //   432: invokevirtual toString : ()Ljava/lang/String;
    //   435: invokevirtual println : (Ljava/lang/String;)V
    //   438: aload #9
    //   440: aload #6
    //   442: aload_2
    //   443: aload_3
    //   444: aload #4
    //   446: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   449: iinc #8, 1
    //   452: goto -> 383
    //   455: aload_0
    //   456: monitorenter
    //   457: aload_0
    //   458: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   461: ifnull -> 549
    //   464: aload_0
    //   465: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   468: invokevirtual size : ()I
    //   471: istore #7
    //   473: iload #7
    //   475: ifle -> 549
    //   478: aload_3
    //   479: aload_1
    //   480: invokevirtual print : (Ljava/lang/String;)V
    //   483: aload_3
    //   484: ldc_w 'Back Stack Indices:'
    //   487: invokevirtual println : (Ljava/lang/String;)V
    //   490: iconst_0
    //   491: istore #8
    //   493: iload #8
    //   495: iload #7
    //   497: if_icmpge -> 549
    //   500: aload_0
    //   501: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   504: iload #8
    //   506: invokevirtual get : (I)Ljava/lang/Object;
    //   509: checkcast android/support/v4/app/BackStackRecord
    //   512: astore_2
    //   513: aload_3
    //   514: aload_1
    //   515: invokevirtual print : (Ljava/lang/String;)V
    //   518: aload_3
    //   519: ldc_w '  #'
    //   522: invokevirtual print : (Ljava/lang/String;)V
    //   525: aload_3
    //   526: iload #8
    //   528: invokevirtual print : (I)V
    //   531: aload_3
    //   532: ldc_w ': '
    //   535: invokevirtual print : (Ljava/lang/String;)V
    //   538: aload_3
    //   539: aload_2
    //   540: invokevirtual println : (Ljava/lang/Object;)V
    //   543: iinc #8, 1
    //   546: goto -> 493
    //   549: aload_0
    //   550: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   553: ifnull -> 592
    //   556: aload_0
    //   557: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   560: invokevirtual size : ()I
    //   563: ifle -> 592
    //   566: aload_3
    //   567: aload_1
    //   568: invokevirtual print : (Ljava/lang/String;)V
    //   571: aload_3
    //   572: ldc_w 'mAvailBackStackIndices: '
    //   575: invokevirtual print : (Ljava/lang/String;)V
    //   578: aload_3
    //   579: aload_0
    //   580: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   583: invokevirtual toArray : ()[Ljava/lang/Object;
    //   586: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   589: invokevirtual println : (Ljava/lang/String;)V
    //   592: aload_0
    //   593: monitorexit
    //   594: aload_0
    //   595: getfield mPendingActions : Ljava/util/ArrayList;
    //   598: ifnull -> 692
    //   601: aload_0
    //   602: getfield mPendingActions : Ljava/util/ArrayList;
    //   605: invokevirtual size : ()I
    //   608: istore #7
    //   610: iload #7
    //   612: ifle -> 692
    //   615: aload_3
    //   616: aload_1
    //   617: invokevirtual print : (Ljava/lang/String;)V
    //   620: aload_3
    //   621: ldc_w 'Pending Actions:'
    //   624: invokevirtual println : (Ljava/lang/String;)V
    //   627: iload #5
    //   629: istore #8
    //   631: iload #8
    //   633: iload #7
    //   635: if_icmpge -> 692
    //   638: aload_0
    //   639: getfield mPendingActions : Ljava/util/ArrayList;
    //   642: iload #8
    //   644: invokevirtual get : (I)Ljava/lang/Object;
    //   647: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   650: astore_2
    //   651: aload_3
    //   652: aload_1
    //   653: invokevirtual print : (Ljava/lang/String;)V
    //   656: aload_3
    //   657: ldc_w '  #'
    //   660: invokevirtual print : (Ljava/lang/String;)V
    //   663: aload_3
    //   664: iload #8
    //   666: invokevirtual print : (I)V
    //   669: aload_3
    //   670: ldc_w ': '
    //   673: invokevirtual print : (Ljava/lang/String;)V
    //   676: aload_3
    //   677: aload_2
    //   678: invokevirtual println : (Ljava/lang/Object;)V
    //   681: iinc #8, 1
    //   684: goto -> 631
    //   687: astore_1
    //   688: aload_0
    //   689: monitorexit
    //   690: aload_1
    //   691: athrow
    //   692: aload_3
    //   693: aload_1
    //   694: invokevirtual print : (Ljava/lang/String;)V
    //   697: aload_3
    //   698: ldc_w 'FragmentManager misc state:'
    //   701: invokevirtual println : (Ljava/lang/String;)V
    //   704: aload_3
    //   705: aload_1
    //   706: invokevirtual print : (Ljava/lang/String;)V
    //   709: aload_3
    //   710: ldc_w '  mHost='
    //   713: invokevirtual print : (Ljava/lang/String;)V
    //   716: aload_3
    //   717: aload_0
    //   718: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   721: invokevirtual println : (Ljava/lang/Object;)V
    //   724: aload_3
    //   725: aload_1
    //   726: invokevirtual print : (Ljava/lang/String;)V
    //   729: aload_3
    //   730: ldc_w '  mContainer='
    //   733: invokevirtual print : (Ljava/lang/String;)V
    //   736: aload_3
    //   737: aload_0
    //   738: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   741: invokevirtual println : (Ljava/lang/Object;)V
    //   744: aload_0
    //   745: getfield mParent : Landroid/support/v4/app/Fragment;
    //   748: ifnull -> 771
    //   751: aload_3
    //   752: aload_1
    //   753: invokevirtual print : (Ljava/lang/String;)V
    //   756: aload_3
    //   757: ldc_w '  mParent='
    //   760: invokevirtual print : (Ljava/lang/String;)V
    //   763: aload_3
    //   764: aload_0
    //   765: getfield mParent : Landroid/support/v4/app/Fragment;
    //   768: invokevirtual println : (Ljava/lang/Object;)V
    //   771: aload_3
    //   772: aload_1
    //   773: invokevirtual print : (Ljava/lang/String;)V
    //   776: aload_3
    //   777: ldc_w '  mCurState='
    //   780: invokevirtual print : (Ljava/lang/String;)V
    //   783: aload_3
    //   784: aload_0
    //   785: getfield mCurState : I
    //   788: invokevirtual print : (I)V
    //   791: aload_3
    //   792: ldc_w ' mStateSaved='
    //   795: invokevirtual print : (Ljava/lang/String;)V
    //   798: aload_3
    //   799: aload_0
    //   800: getfield mStateSaved : Z
    //   803: invokevirtual print : (Z)V
    //   806: aload_3
    //   807: ldc_w ' mDestroyed='
    //   810: invokevirtual print : (Ljava/lang/String;)V
    //   813: aload_3
    //   814: aload_0
    //   815: getfield mDestroyed : Z
    //   818: invokevirtual println : (Z)V
    //   821: aload_0
    //   822: getfield mNeedMenuInvalidate : Z
    //   825: ifeq -> 848
    //   828: aload_3
    //   829: aload_1
    //   830: invokevirtual print : (Ljava/lang/String;)V
    //   833: aload_3
    //   834: ldc_w '  mNeedMenuInvalidate='
    //   837: invokevirtual print : (Ljava/lang/String;)V
    //   840: aload_3
    //   841: aload_0
    //   842: getfield mNeedMenuInvalidate : Z
    //   845: invokevirtual println : (Z)V
    //   848: aload_0
    //   849: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   852: ifnull -> 875
    //   855: aload_3
    //   856: aload_1
    //   857: invokevirtual print : (Ljava/lang/String;)V
    //   860: aload_3
    //   861: ldc_w '  mNoTransactionsBecause='
    //   864: invokevirtual print : (Ljava/lang/String;)V
    //   867: aload_3
    //   868: aload_0
    //   869: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   872: invokevirtual println : (Ljava/lang/String;)V
    //   875: aload_0
    //   876: getfield mAvailIndices : Ljava/util/ArrayList;
    //   879: ifnull -> 918
    //   882: aload_0
    //   883: getfield mAvailIndices : Ljava/util/ArrayList;
    //   886: invokevirtual size : ()I
    //   889: ifle -> 918
    //   892: aload_3
    //   893: aload_1
    //   894: invokevirtual print : (Ljava/lang/String;)V
    //   897: aload_3
    //   898: ldc_w '  mAvailIndices: '
    //   901: invokevirtual print : (Ljava/lang/String;)V
    //   904: aload_3
    //   905: aload_0
    //   906: getfield mAvailIndices : Ljava/util/ArrayList;
    //   909: invokevirtual toArray : ()[Ljava/lang/Object;
    //   912: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   915: invokevirtual println : (Ljava/lang/String;)V
    //   918: return
    // Exception table:
    //   from	to	target	type
    //   457	473	687	finally
    //   478	490	687	finally
    //   500	543	687	finally
    //   549	592	687	finally
    //   592	594	687	finally
    //   688	690	687	finally
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial checkStateLoss : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield mDestroyed : Z
    //   14: ifne -> 24
    //   17: aload_0
    //   18: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   21: ifnonnull -> 42
    //   24: new java/lang/IllegalStateException
    //   27: astore_1
    //   28: aload_1
    //   29: ldc_w 'Activity has been destroyed'
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: aload_1
    //   36: athrow
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: getfield mPendingActions : Ljava/util/ArrayList;
    //   46: ifnonnull -> 62
    //   49: new java/util/ArrayList
    //   52: astore_3
    //   53: aload_3
    //   54: invokespecial <init> : ()V
    //   57: aload_0
    //   58: aload_3
    //   59: putfield mPendingActions : Ljava/util/ArrayList;
    //   62: aload_0
    //   63: getfield mPendingActions : Ljava/util/ArrayList;
    //   66: aload_1
    //   67: invokevirtual add : (Ljava/lang/Object;)Z
    //   70: pop
    //   71: aload_0
    //   72: invokespecial scheduleCommit : ()V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    // Exception table:
    //   from	to	target	type
    //   10	24	37	finally
    //   24	37	37	finally
    //   38	40	37	finally
    //   42	62	37	finally
    //   62	77	37	finally
  }
  
  public boolean execPendingActions() {
    ensureExecReady(true);
    boolean bool = false;
    while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        return;
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
  }
  
  public boolean executePendingTransactions() {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  public Fragment findFragmentById(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAdded : Ljava/util/ArrayList;
    //   4: ifnull -> 53
    //   7: aload_0
    //   8: getfield mAdded : Ljava/util/ArrayList;
    //   11: invokevirtual size : ()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_2
    //   17: iload_2
    //   18: iflt -> 53
    //   21: aload_0
    //   22: getfield mAdded : Ljava/util/ArrayList;
    //   25: iload_2
    //   26: invokevirtual get : (I)Ljava/lang/Object;
    //   29: checkcast android/support/v4/app/Fragment
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull -> 47
    //   37: aload_3
    //   38: getfield mFragmentId : I
    //   41: iload_1
    //   42: if_icmpne -> 47
    //   45: aload_3
    //   46: areturn
    //   47: iinc #2, -1
    //   50: goto -> 17
    //   53: aload_0
    //   54: getfield mActive : Ljava/util/ArrayList;
    //   57: ifnull -> 110
    //   60: aload_0
    //   61: getfield mActive : Ljava/util/ArrayList;
    //   64: invokevirtual size : ()I
    //   67: iconst_1
    //   68: isub
    //   69: istore_2
    //   70: iload_2
    //   71: iflt -> 110
    //   74: aload_0
    //   75: getfield mActive : Ljava/util/ArrayList;
    //   78: iload_2
    //   79: invokevirtual get : (I)Ljava/lang/Object;
    //   82: checkcast android/support/v4/app/Fragment
    //   85: astore #4
    //   87: aload #4
    //   89: ifnull -> 104
    //   92: aload #4
    //   94: astore_3
    //   95: aload #4
    //   97: getfield mFragmentId : I
    //   100: iload_1
    //   101: if_icmpeq -> 45
    //   104: iinc #2, -1
    //   107: goto -> 70
    //   110: aconst_null
    //   111: astore_3
    //   112: goto -> 45
  }
  
  public Fragment findFragmentByTag(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAdded : Ljava/util/ArrayList;
    //   4: ifnull -> 60
    //   7: aload_1
    //   8: ifnull -> 60
    //   11: aload_0
    //   12: getfield mAdded : Ljava/util/ArrayList;
    //   15: invokevirtual size : ()I
    //   18: iconst_1
    //   19: isub
    //   20: istore_2
    //   21: iload_2
    //   22: iflt -> 60
    //   25: aload_0
    //   26: getfield mAdded : Ljava/util/ArrayList;
    //   29: iload_2
    //   30: invokevirtual get : (I)Ljava/lang/Object;
    //   33: checkcast android/support/v4/app/Fragment
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull -> 54
    //   41: aload_1
    //   42: aload_3
    //   43: getfield mTag : Ljava/lang/String;
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 54
    //   52: aload_3
    //   53: areturn
    //   54: iinc #2, -1
    //   57: goto -> 21
    //   60: aload_0
    //   61: getfield mActive : Ljava/util/ArrayList;
    //   64: ifnull -> 124
    //   67: aload_1
    //   68: ifnull -> 124
    //   71: aload_0
    //   72: getfield mActive : Ljava/util/ArrayList;
    //   75: invokevirtual size : ()I
    //   78: iconst_1
    //   79: isub
    //   80: istore_2
    //   81: iload_2
    //   82: iflt -> 124
    //   85: aload_0
    //   86: getfield mActive : Ljava/util/ArrayList;
    //   89: iload_2
    //   90: invokevirtual get : (I)Ljava/lang/Object;
    //   93: checkcast android/support/v4/app/Fragment
    //   96: astore #4
    //   98: aload #4
    //   100: ifnull -> 118
    //   103: aload #4
    //   105: astore_3
    //   106: aload_1
    //   107: aload #4
    //   109: getfield mTag : Ljava/lang/String;
    //   112: invokevirtual equals : (Ljava/lang/Object;)Z
    //   115: ifne -> 52
    //   118: iinc #2, -1
    //   121: goto -> 81
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -> 52
  }
  
  public Fragment findFragmentByWho(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mActive : Ljava/util/ArrayList;
    //   4: ifnull -> 61
    //   7: aload_1
    //   8: ifnull -> 61
    //   11: aload_0
    //   12: getfield mActive : Ljava/util/ArrayList;
    //   15: invokevirtual size : ()I
    //   18: iconst_1
    //   19: isub
    //   20: istore_2
    //   21: iload_2
    //   22: iflt -> 61
    //   25: aload_0
    //   26: getfield mActive : Ljava/util/ArrayList;
    //   29: iload_2
    //   30: invokevirtual get : (I)Ljava/lang/Object;
    //   33: checkcast android/support/v4/app/Fragment
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull -> 55
    //   41: aload_3
    //   42: aload_1
    //   43: invokevirtual findFragmentByWho : (Ljava/lang/String;)Landroid/support/v4/app/Fragment;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull -> 55
    //   51: aload_3
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: iinc #2, -1
    //   58: goto -> 21
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -> 53
  }
  
  public void freeBackStackIndex(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: iload_1
    //   7: aconst_null
    //   8: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   16: ifnonnull -> 32
    //   19: new java/util/ArrayList
    //   22: astore_2
    //   23: aload_2
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: aload_2
    //   29: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   32: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   35: ifeq -> 66
    //   38: new java/lang/StringBuilder
    //   41: astore_2
    //   42: aload_2
    //   43: invokespecial <init> : ()V
    //   46: ldc 'FragmentManager'
    //   48: aload_2
    //   49: ldc_w 'Freeing back stack index '
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_1
    //   56: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: aload_0
    //   67: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: invokevirtual add : (Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	81	finally
    //   32	66	81	finally
    //   66	80	81	finally
    //   82	84	81	finally
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt) {
    return this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount() {
    return (this.mBackStack != null) ? this.mBackStack.size() : 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString) {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1)
      return null; 
    if (i >= this.mActive.size())
      throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i)); 
    Fragment fragment2 = this.mActive.get(i);
    Fragment fragment1 = fragment2;
    if (fragment2 == null) {
      throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      fragment1 = fragment2;
    } 
    return fragment1;
  }
  
  public List<Fragment> getFragments() {
    return this.mActive;
  }
  
  LayoutInflaterFactory getLayoutInflaterFactory() {
    return this;
  }
  
  public void hideFragment(Fragment paramFragment) {
    boolean bool = true;
    if (DEBUG)
      Log.v("FragmentManager", "hide: " + paramFragment); 
    if (!paramFragment.mHidden) {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged)
        bool = false; 
      paramFragment.mHiddenChanged = bool;
    } 
  }
  
  public boolean isDestroyed() {
    return this.mDestroyed;
  }
  
  boolean isStateAtLeast(int paramInt) {
    return (this.mCurState >= paramInt);
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: aload_1
    //   4: invokevirtual getNextAnim : ()I
    //   7: invokevirtual onCreateAnimation : (IZI)Landroid/view/animation/Animation;
    //   10: astore #5
    //   12: aload #5
    //   14: ifnull -> 22
    //   17: aload #5
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: aload_1
    //   23: invokevirtual getNextAnim : ()I
    //   26: ifeq -> 53
    //   29: aload_0
    //   30: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   33: invokevirtual getContext : ()Landroid/content/Context;
    //   36: aload_1
    //   37: invokevirtual getNextAnim : ()I
    //   40: invokestatic loadAnimation : (Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   43: astore #5
    //   45: aload #5
    //   47: astore_1
    //   48: aload #5
    //   50: ifnonnull -> 20
    //   53: iload_2
    //   54: ifne -> 62
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -> 20
    //   62: iload_2
    //   63: iload_3
    //   64: invokestatic transitToStyleIndex : (IZ)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifge -> 77
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -> 20
    //   77: iload_2
    //   78: tableswitch default -> 116, 1 -> 154, 2 -> 174, 3 -> 194, 4 -> 214, 5 -> 234, 6 -> 250
    //   116: iload #4
    //   118: istore_2
    //   119: iload #4
    //   121: ifne -> 145
    //   124: iload #4
    //   126: istore_2
    //   127: aload_0
    //   128: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   131: invokevirtual onHasWindowAnimations : ()Z
    //   134: ifeq -> 145
    //   137: aload_0
    //   138: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   141: invokevirtual onGetWindowAnimations : ()I
    //   144: istore_2
    //   145: iload_2
    //   146: ifne -> 266
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -> 20
    //   154: aload_0
    //   155: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   158: invokevirtual getContext : ()Landroid/content/Context;
    //   161: ldc_w 1.125
    //   164: fconst_1
    //   165: fconst_0
    //   166: fconst_1
    //   167: invokestatic makeOpenCloseAnimation : (Landroid/content/Context;FFFF)Landroid/view/animation/Animation;
    //   170: astore_1
    //   171: goto -> 20
    //   174: aload_0
    //   175: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   178: invokevirtual getContext : ()Landroid/content/Context;
    //   181: fconst_1
    //   182: ldc_w 0.975
    //   185: fconst_1
    //   186: fconst_0
    //   187: invokestatic makeOpenCloseAnimation : (Landroid/content/Context;FFFF)Landroid/view/animation/Animation;
    //   190: astore_1
    //   191: goto -> 20
    //   194: aload_0
    //   195: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   198: invokevirtual getContext : ()Landroid/content/Context;
    //   201: ldc_w 0.975
    //   204: fconst_1
    //   205: fconst_0
    //   206: fconst_1
    //   207: invokestatic makeOpenCloseAnimation : (Landroid/content/Context;FFFF)Landroid/view/animation/Animation;
    //   210: astore_1
    //   211: goto -> 20
    //   214: aload_0
    //   215: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   218: invokevirtual getContext : ()Landroid/content/Context;
    //   221: fconst_1
    //   222: ldc_w 1.075
    //   225: fconst_1
    //   226: fconst_0
    //   227: invokestatic makeOpenCloseAnimation : (Landroid/content/Context;FFFF)Landroid/view/animation/Animation;
    //   230: astore_1
    //   231: goto -> 20
    //   234: aload_0
    //   235: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   238: invokevirtual getContext : ()Landroid/content/Context;
    //   241: fconst_0
    //   242: fconst_1
    //   243: invokestatic makeFadeAnimation : (Landroid/content/Context;FF)Landroid/view/animation/Animation;
    //   246: astore_1
    //   247: goto -> 20
    //   250: aload_0
    //   251: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   254: invokevirtual getContext : ()Landroid/content/Context;
    //   257: fconst_1
    //   258: fconst_0
    //   259: invokestatic makeFadeAnimation : (Landroid/content/Context;FF)Landroid/view/animation/Animation;
    //   262: astore_1
    //   263: goto -> 20
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -> 20
  }
  
  void makeActive(Fragment paramFragment) {
    if (paramFragment.mIndex < 0) {
      if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
        if (this.mActive == null)
          this.mActive = new ArrayList<Fragment>(); 
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      } else {
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      } 
      if (DEBUG)
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment); 
    } 
  }
  
  void makeInactive(Fragment paramFragment) {
    if (paramFragment.mIndex >= 0) {
      if (DEBUG)
        Log.v("FragmentManager", "Freeing fragment index " + paramFragment); 
      this.mActive.set(paramFragment.mIndex, null);
      if (this.mAvailIndices == null)
        this.mAvailIndices = new ArrayList<Integer>(); 
      this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
      this.mHost.inactivateFragment(paramFragment.mWho);
      paramFragment.initState();
    } 
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment) {
    if (paramFragment != null) {
      int i = this.mCurState;
      int j = i;
      if (paramFragment.mRemoving)
        if (paramFragment.isInBackStack()) {
          j = Math.min(i, 1);
        } else {
          j = Math.min(i, 0);
        }  
      moveToState(paramFragment, j, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
      if (paramFragment.mView != null) {
        Fragment fragment = findFragmentUnder(paramFragment);
        if (fragment != null) {
          View view = fragment.mView;
          ViewGroup viewGroup = paramFragment.mContainer;
          j = viewGroup.indexOfChild(view);
          i = viewGroup.indexOfChild(paramFragment.mView);
          if (i < j) {
            viewGroup.removeViewAt(i);
            viewGroup.addView(paramFragment.mView, j);
          } 
        } 
        if (paramFragment.mIsNewlyAdded && paramFragment.mContainer != null) {
          if (Build.VERSION.SDK_INT < 11) {
            paramFragment.mView.setVisibility(0);
          } else if (paramFragment.mPostponedAlpha > 0.0F) {
            paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
          } 
          paramFragment.mPostponedAlpha = 0.0F;
          paramFragment.mIsNewlyAdded = false;
          Animation animation = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
          if (animation != null) {
            setHWLayerAnimListenerIfAlpha(paramFragment.mView, animation);
            paramFragment.mView.startAnimation(animation);
          } 
        } 
      } 
      if (paramFragment.mHiddenChanged)
        completeShowHideFragment(paramFragment); 
    } 
  }
  
  void moveToState(int paramInt, boolean paramBoolean) {
    if (this.mHost == null && paramInt != 0)
      throw new IllegalStateException("No activity"); 
    if (paramBoolean || paramInt != this.mCurState) {
      this.mCurState = paramInt;
      if (this.mActive != null) {
        boolean bool1;
        boolean bool2;
        if (this.mAdded != null) {
          int j = this.mAdded.size();
          byte b1 = 0;
          paramInt = 0;
          while (true) {
            int k = paramInt;
            if (b1 < j) {
              Fragment fragment = this.mAdded.get(b1);
              moveFragmentToExpectedState(fragment);
              if (fragment.mLoaderManager != null)
                bool1 = fragment.mLoaderManager.hasRunningLoaders() | paramInt; 
              b1++;
              continue;
            } 
            break;
          } 
        } else {
          bool2 = false;
        } 
        int i = this.mActive.size();
        byte b = 0;
        while (true) {
          if (b < i) {
            Fragment fragment = this.mActive.get(b);
            if (fragment != null && (fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded) {
              moveFragmentToExpectedState(fragment);
              if (fragment.mLoaderManager != null) {
                bool1 = fragment.mLoaderManager.hasRunningLoaders() | bool2;
                continue;
              } 
            } 
          } else {
            if (!bool2)
              startPendingDeferredFragments(); 
            if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
              this.mHost.onSupportInvalidateOptionsMenu();
              this.mNeedMenuInvalidate = false;
            } 
            return;
          } 
          bool1 = bool2;
          continue;
          b++;
          bool2 = bool1;
        } 
      } 
    } 
  }
  
  void moveToState(Fragment paramFragment) {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #6
    //   3: aload_1
    //   4: getfield mAdded : Z
    //   7: ifeq -> 20
    //   10: iload_2
    //   11: istore #7
    //   13: aload_1
    //   14: getfield mDetached : Z
    //   17: ifeq -> 31
    //   20: iload_2
    //   21: istore #7
    //   23: iload_2
    //   24: iconst_1
    //   25: if_icmple -> 31
    //   28: iconst_1
    //   29: istore #7
    //   31: iload #7
    //   33: istore #8
    //   35: aload_1
    //   36: getfield mRemoving : Z
    //   39: ifeq -> 61
    //   42: iload #7
    //   44: istore #8
    //   46: iload #7
    //   48: aload_1
    //   49: getfield mState : I
    //   52: if_icmple -> 61
    //   55: aload_1
    //   56: getfield mState : I
    //   59: istore #8
    //   61: iload #8
    //   63: istore_2
    //   64: aload_1
    //   65: getfield mDeferStart : Z
    //   68: ifeq -> 93
    //   71: iload #8
    //   73: istore_2
    //   74: aload_1
    //   75: getfield mState : I
    //   78: iconst_4
    //   79: if_icmpge -> 93
    //   82: iload #8
    //   84: istore_2
    //   85: iload #8
    //   87: iconst_3
    //   88: if_icmple -> 93
    //   91: iconst_3
    //   92: istore_2
    //   93: aload_1
    //   94: getfield mState : I
    //   97: iload_2
    //   98: if_icmpge -> 1324
    //   101: aload_1
    //   102: getfield mFromLayout : Z
    //   105: ifeq -> 116
    //   108: aload_1
    //   109: getfield mInLayout : Z
    //   112: ifne -> 116
    //   115: return
    //   116: aload_1
    //   117: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   120: ifnull -> 140
    //   123: aload_1
    //   124: aconst_null
    //   125: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   128: aload_0
    //   129: aload_1
    //   130: aload_1
    //   131: invokevirtual getStateAfterAnimating : ()I
    //   134: iconst_0
    //   135: iconst_0
    //   136: iconst_1
    //   137: invokevirtual moveToState : (Landroid/support/v4/app/Fragment;IIIZ)V
    //   140: iload_2
    //   141: istore_3
    //   142: iload_2
    //   143: istore #7
    //   145: iload_2
    //   146: istore #8
    //   148: iload_2
    //   149: istore #4
    //   151: aload_1
    //   152: getfield mState : I
    //   155: tableswitch default -> 188, 0 -> 265, 1 -> 697, 2 -> 1090, 3 -> 1109, 4 -> 1165
    //   188: iload_2
    //   189: istore #8
    //   191: aload_1
    //   192: getfield mState : I
    //   195: iload #8
    //   197: if_icmpeq -> 115
    //   200: ldc 'FragmentManager'
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: ldc_w 'moveToState: Fragment state for '
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: ldc_w ' not updated inline; '
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 'expected state '
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload #8
    //   233: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   236: ldc_w ' found '
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_1
    //   243: getfield mState : I
    //   246: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   249: invokevirtual toString : ()Ljava/lang/String;
    //   252: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: aload_1
    //   257: iload #8
    //   259: putfield mState : I
    //   262: goto -> 115
    //   265: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   268: ifeq -> 297
    //   271: ldc 'FragmentManager'
    //   273: new java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial <init> : ()V
    //   280: ldc_w 'moveto CREATED: '
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_1
    //   287: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   296: pop
    //   297: iload_2
    //   298: istore #4
    //   300: aload_1
    //   301: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   304: ifnull -> 412
    //   307: aload_1
    //   308: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   311: aload_0
    //   312: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   315: invokevirtual getContext : ()Landroid/content/Context;
    //   318: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   321: invokevirtual setClassLoader : (Ljava/lang/ClassLoader;)V
    //   324: aload_1
    //   325: aload_1
    //   326: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   329: ldc 'android:view_state'
    //   331: invokevirtual getSparseParcelableArray : (Ljava/lang/String;)Landroid/util/SparseArray;
    //   334: putfield mSavedViewState : Landroid/util/SparseArray;
    //   337: aload_1
    //   338: aload_0
    //   339: aload_1
    //   340: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   343: ldc 'android:target_state'
    //   345: invokevirtual getFragment : (Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;
    //   348: putfield mTarget : Landroid/support/v4/app/Fragment;
    //   351: aload_1
    //   352: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   355: ifnull -> 372
    //   358: aload_1
    //   359: aload_1
    //   360: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   363: ldc 'android:target_req_state'
    //   365: iconst_0
    //   366: invokevirtual getInt : (Ljava/lang/String;I)I
    //   369: putfield mTargetRequestCode : I
    //   372: aload_1
    //   373: aload_1
    //   374: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   377: ldc 'android:user_visible_hint'
    //   379: iconst_1
    //   380: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   383: putfield mUserVisibleHint : Z
    //   386: iload_2
    //   387: istore #4
    //   389: aload_1
    //   390: getfield mUserVisibleHint : Z
    //   393: ifne -> 412
    //   396: aload_1
    //   397: iconst_1
    //   398: putfield mDeferStart : Z
    //   401: iload_2
    //   402: istore #4
    //   404: iload_2
    //   405: iconst_3
    //   406: if_icmple -> 412
    //   409: iconst_3
    //   410: istore #4
    //   412: aload_1
    //   413: aload_0
    //   414: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   417: putfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   420: aload_1
    //   421: aload_0
    //   422: getfield mParent : Landroid/support/v4/app/Fragment;
    //   425: putfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   428: aload_0
    //   429: getfield mParent : Landroid/support/v4/app/Fragment;
    //   432: ifnull -> 520
    //   435: aload_0
    //   436: getfield mParent : Landroid/support/v4/app/Fragment;
    //   439: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   442: astore #9
    //   444: aload_1
    //   445: aload #9
    //   447: putfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   450: aload_0
    //   451: aload_1
    //   452: aload_0
    //   453: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   456: invokevirtual getContext : ()Landroid/content/Context;
    //   459: iconst_0
    //   460: invokevirtual dispatchOnFragmentPreAttached : (Landroid/support/v4/app/Fragment;Landroid/content/Context;Z)V
    //   463: aload_1
    //   464: iconst_0
    //   465: putfield mCalled : Z
    //   468: aload_1
    //   469: aload_0
    //   470: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   473: invokevirtual getContext : ()Landroid/content/Context;
    //   476: invokevirtual onAttach : (Landroid/content/Context;)V
    //   479: aload_1
    //   480: getfield mCalled : Z
    //   483: ifne -> 532
    //   486: new android/support/v4/app/SuperNotCalledException
    //   489: dup
    //   490: new java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial <init> : ()V
    //   497: ldc_w 'Fragment '
    //   500: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_1
    //   504: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: ldc_w ' did not call through to super.onAttach()'
    //   510: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual toString : ()Ljava/lang/String;
    //   516: invokespecial <init> : (Ljava/lang/String;)V
    //   519: athrow
    //   520: aload_0
    //   521: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   524: invokevirtual getFragmentManagerImpl : ()Landroid/support/v4/app/FragmentManagerImpl;
    //   527: astore #9
    //   529: goto -> 444
    //   532: aload_1
    //   533: getfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   536: ifnonnull -> 1234
    //   539: aload_0
    //   540: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   543: aload_1
    //   544: invokevirtual onAttachFragment : (Landroid/support/v4/app/Fragment;)V
    //   547: aload_0
    //   548: aload_1
    //   549: aload_0
    //   550: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   553: invokevirtual getContext : ()Landroid/content/Context;
    //   556: iconst_0
    //   557: invokevirtual dispatchOnFragmentAttached : (Landroid/support/v4/app/Fragment;Landroid/content/Context;Z)V
    //   560: aload_1
    //   561: getfield mRetaining : Z
    //   564: ifne -> 1245
    //   567: aload_1
    //   568: aload_1
    //   569: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   572: invokevirtual performCreate : (Landroid/os/Bundle;)V
    //   575: aload_0
    //   576: aload_1
    //   577: aload_1
    //   578: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   581: iconst_0
    //   582: invokevirtual dispatchOnFragmentCreated : (Landroid/support/v4/app/Fragment;Landroid/os/Bundle;Z)V
    //   585: aload_1
    //   586: iconst_0
    //   587: putfield mRetaining : Z
    //   590: iload #4
    //   592: istore_3
    //   593: aload_1
    //   594: getfield mFromLayout : Z
    //   597: ifeq -> 697
    //   600: aload_1
    //   601: aload_1
    //   602: aload_1
    //   603: aload_1
    //   604: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   607: invokevirtual getLayoutInflater : (Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    //   610: aconst_null
    //   611: aload_1
    //   612: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   615: invokevirtual performCreateView : (Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   618: putfield mView : Landroid/view/View;
    //   621: aload_1
    //   622: getfield mView : Landroid/view/View;
    //   625: ifnull -> 1275
    //   628: aload_1
    //   629: aload_1
    //   630: getfield mView : Landroid/view/View;
    //   633: putfield mInnerView : Landroid/view/View;
    //   636: getstatic android/os/Build$VERSION.SDK_INT : I
    //   639: bipush #11
    //   641: if_icmplt -> 1261
    //   644: aload_1
    //   645: getfield mView : Landroid/view/View;
    //   648: iconst_0
    //   649: invokestatic setSaveFromParentEnabled : (Landroid/view/View;Z)V
    //   652: aload_1
    //   653: getfield mHidden : Z
    //   656: ifeq -> 668
    //   659: aload_1
    //   660: getfield mView : Landroid/view/View;
    //   663: bipush #8
    //   665: invokevirtual setVisibility : (I)V
    //   668: aload_1
    //   669: aload_1
    //   670: getfield mView : Landroid/view/View;
    //   673: aload_1
    //   674: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   677: invokevirtual onViewCreated : (Landroid/view/View;Landroid/os/Bundle;)V
    //   680: aload_0
    //   681: aload_1
    //   682: aload_1
    //   683: getfield mView : Landroid/view/View;
    //   686: aload_1
    //   687: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   690: iconst_0
    //   691: invokevirtual dispatchOnFragmentViewCreated : (Landroid/support/v4/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    //   694: iload #4
    //   696: istore_3
    //   697: iload_3
    //   698: istore #7
    //   700: iload_3
    //   701: iconst_1
    //   702: if_icmple -> 1090
    //   705: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   708: ifeq -> 737
    //   711: ldc 'FragmentManager'
    //   713: new java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial <init> : ()V
    //   720: ldc_w 'moveto ACTIVITY_CREATED: '
    //   723: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload_1
    //   727: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   730: invokevirtual toString : ()Ljava/lang/String;
    //   733: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   736: pop
    //   737: aload_1
    //   738: getfield mFromLayout : Z
    //   741: ifne -> 1049
    //   744: aload_1
    //   745: getfield mContainerId : I
    //   748: ifeq -> 1905
    //   751: aload_1
    //   752: getfield mContainerId : I
    //   755: iconst_m1
    //   756: if_icmpne -> 796
    //   759: aload_0
    //   760: new java/lang/IllegalArgumentException
    //   763: dup
    //   764: new java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial <init> : ()V
    //   771: ldc_w 'Cannot create fragment '
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload_1
    //   778: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   781: ldc_w ' for a container view with no id'
    //   784: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual toString : ()Ljava/lang/String;
    //   790: invokespecial <init> : (Ljava/lang/String;)V
    //   793: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   796: aload_0
    //   797: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   800: aload_1
    //   801: getfield mContainerId : I
    //   804: invokevirtual onFindViewById : (I)Landroid/view/View;
    //   807: checkcast android/view/ViewGroup
    //   810: astore #10
    //   812: aload #10
    //   814: astore #9
    //   816: aload #10
    //   818: ifnonnull -> 907
    //   821: aload #10
    //   823: astore #9
    //   825: aload_1
    //   826: getfield mRestored : Z
    //   829: ifne -> 907
    //   832: aload_1
    //   833: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   836: aload_1
    //   837: getfield mContainerId : I
    //   840: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   843: astore #9
    //   845: aload_0
    //   846: new java/lang/IllegalArgumentException
    //   849: dup
    //   850: new java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial <init> : ()V
    //   857: ldc_w 'No view found for id 0x'
    //   860: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload_1
    //   864: getfield mContainerId : I
    //   867: invokestatic toHexString : (I)Ljava/lang/String;
    //   870: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w ' ('
    //   876: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload #9
    //   881: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: ldc_w ') for fragment '
    //   887: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: aload_1
    //   891: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   894: invokevirtual toString : ()Ljava/lang/String;
    //   897: invokespecial <init> : (Ljava/lang/String;)V
    //   900: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   903: aload #10
    //   905: astore #9
    //   907: aload_1
    //   908: aload #9
    //   910: putfield mContainer : Landroid/view/ViewGroup;
    //   913: aload_1
    //   914: aload_1
    //   915: aload_1
    //   916: aload_1
    //   917: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   920: invokevirtual getLayoutInflater : (Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    //   923: aload #9
    //   925: aload_1
    //   926: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   929: invokevirtual performCreateView : (Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   932: putfield mView : Landroid/view/View;
    //   935: aload_1
    //   936: getfield mView : Landroid/view/View;
    //   939: ifnull -> 1316
    //   942: aload_1
    //   943: aload_1
    //   944: getfield mView : Landroid/view/View;
    //   947: putfield mInnerView : Landroid/view/View;
    //   950: getstatic android/os/Build$VERSION.SDK_INT : I
    //   953: bipush #11
    //   955: if_icmplt -> 1296
    //   958: aload_1
    //   959: getfield mView : Landroid/view/View;
    //   962: iconst_0
    //   963: invokestatic setSaveFromParentEnabled : (Landroid/view/View;Z)V
    //   966: aload #9
    //   968: ifnull -> 980
    //   971: aload #9
    //   973: aload_1
    //   974: getfield mView : Landroid/view/View;
    //   977: invokevirtual addView : (Landroid/view/View;)V
    //   980: aload_1
    //   981: getfield mHidden : Z
    //   984: ifeq -> 996
    //   987: aload_1
    //   988: getfield mView : Landroid/view/View;
    //   991: bipush #8
    //   993: invokevirtual setVisibility : (I)V
    //   996: aload_1
    //   997: aload_1
    //   998: getfield mView : Landroid/view/View;
    //   1001: aload_1
    //   1002: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1005: invokevirtual onViewCreated : (Landroid/view/View;Landroid/os/Bundle;)V
    //   1008: aload_0
    //   1009: aload_1
    //   1010: aload_1
    //   1011: getfield mView : Landroid/view/View;
    //   1014: aload_1
    //   1015: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1018: iconst_0
    //   1019: invokevirtual dispatchOnFragmentViewCreated : (Landroid/support/v4/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    //   1022: aload_1
    //   1023: getfield mView : Landroid/view/View;
    //   1026: invokevirtual getVisibility : ()I
    //   1029: ifne -> 1310
    //   1032: aload_1
    //   1033: getfield mContainer : Landroid/view/ViewGroup;
    //   1036: ifnull -> 1310
    //   1039: iload #6
    //   1041: istore #5
    //   1043: aload_1
    //   1044: iload #5
    //   1046: putfield mIsNewlyAdded : Z
    //   1049: aload_1
    //   1050: aload_1
    //   1051: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1054: invokevirtual performActivityCreated : (Landroid/os/Bundle;)V
    //   1057: aload_0
    //   1058: aload_1
    //   1059: aload_1
    //   1060: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1063: iconst_0
    //   1064: invokevirtual dispatchOnFragmentActivityCreated : (Landroid/support/v4/app/Fragment;Landroid/os/Bundle;Z)V
    //   1067: aload_1
    //   1068: getfield mView : Landroid/view/View;
    //   1071: ifnull -> 1082
    //   1074: aload_1
    //   1075: aload_1
    //   1076: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1079: invokevirtual restoreViewState : (Landroid/os/Bundle;)V
    //   1082: aload_1
    //   1083: aconst_null
    //   1084: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1087: iload_3
    //   1088: istore #7
    //   1090: iload #7
    //   1092: istore #8
    //   1094: iload #7
    //   1096: iconst_2
    //   1097: if_icmple -> 1109
    //   1100: aload_1
    //   1101: iconst_3
    //   1102: putfield mState : I
    //   1105: iload #7
    //   1107: istore #8
    //   1109: iload #8
    //   1111: istore #4
    //   1113: iload #8
    //   1115: iconst_3
    //   1116: if_icmple -> 1165
    //   1119: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1122: ifeq -> 1151
    //   1125: ldc 'FragmentManager'
    //   1127: new java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial <init> : ()V
    //   1134: ldc_w 'moveto STARTED: '
    //   1137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: aload_1
    //   1141: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1144: invokevirtual toString : ()Ljava/lang/String;
    //   1147: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1150: pop
    //   1151: aload_1
    //   1152: invokevirtual performStart : ()V
    //   1155: aload_0
    //   1156: aload_1
    //   1157: iconst_0
    //   1158: invokevirtual dispatchOnFragmentStarted : (Landroid/support/v4/app/Fragment;Z)V
    //   1161: iload #8
    //   1163: istore #4
    //   1165: iload #4
    //   1167: istore #8
    //   1169: iload #4
    //   1171: iconst_4
    //   1172: if_icmple -> 191
    //   1175: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1178: ifeq -> 1207
    //   1181: ldc 'FragmentManager'
    //   1183: new java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial <init> : ()V
    //   1190: ldc_w 'moveto RESUMED: '
    //   1193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_1
    //   1197: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1200: invokevirtual toString : ()Ljava/lang/String;
    //   1203: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1206: pop
    //   1207: aload_1
    //   1208: invokevirtual performResume : ()V
    //   1211: aload_0
    //   1212: aload_1
    //   1213: iconst_0
    //   1214: invokevirtual dispatchOnFragmentResumed : (Landroid/support/v4/app/Fragment;Z)V
    //   1217: aload_1
    //   1218: aconst_null
    //   1219: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1222: aload_1
    //   1223: aconst_null
    //   1224: putfield mSavedViewState : Landroid/util/SparseArray;
    //   1227: iload #4
    //   1229: istore #8
    //   1231: goto -> 191
    //   1234: aload_1
    //   1235: getfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   1238: aload_1
    //   1239: invokevirtual onAttachFragment : (Landroid/support/v4/app/Fragment;)V
    //   1242: goto -> 547
    //   1245: aload_1
    //   1246: aload_1
    //   1247: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1250: invokevirtual restoreChildFragmentState : (Landroid/os/Bundle;)V
    //   1253: aload_1
    //   1254: iconst_1
    //   1255: putfield mState : I
    //   1258: goto -> 585
    //   1261: aload_1
    //   1262: aload_1
    //   1263: getfield mView : Landroid/view/View;
    //   1266: invokestatic wrap : (Landroid/view/View;)Landroid/view/ViewGroup;
    //   1269: putfield mView : Landroid/view/View;
    //   1272: goto -> 652
    //   1275: aload_1
    //   1276: aconst_null
    //   1277: putfield mInnerView : Landroid/view/View;
    //   1280: iload #4
    //   1282: istore_3
    //   1283: goto -> 697
    //   1286: astore #9
    //   1288: ldc_w 'unknown'
    //   1291: astore #9
    //   1293: goto -> 845
    //   1296: aload_1
    //   1297: aload_1
    //   1298: getfield mView : Landroid/view/View;
    //   1301: invokestatic wrap : (Landroid/view/View;)Landroid/view/ViewGroup;
    //   1304: putfield mView : Landroid/view/View;
    //   1307: goto -> 966
    //   1310: iconst_0
    //   1311: istore #5
    //   1313: goto -> 1043
    //   1316: aload_1
    //   1317: aconst_null
    //   1318: putfield mInnerView : Landroid/view/View;
    //   1321: goto -> 1049
    //   1324: iload_2
    //   1325: istore #8
    //   1327: aload_1
    //   1328: getfield mState : I
    //   1331: iload_2
    //   1332: if_icmple -> 191
    //   1335: aload_1
    //   1336: getfield mState : I
    //   1339: tableswitch default -> 1372, 1 -> 1378, 2 -> 1569, 3 -> 1528, 4 -> 1481, 5 -> 1434
    //   1372: iload_2
    //   1373: istore #8
    //   1375: goto -> 191
    //   1378: iload_2
    //   1379: istore #8
    //   1381: iload_2
    //   1382: iconst_1
    //   1383: if_icmpge -> 191
    //   1386: aload_0
    //   1387: getfield mDestroyed : Z
    //   1390: ifeq -> 1416
    //   1393: aload_1
    //   1394: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1397: ifnull -> 1416
    //   1400: aload_1
    //   1401: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1404: astore #9
    //   1406: aload_1
    //   1407: aconst_null
    //   1408: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   1411: aload #9
    //   1413: invokevirtual clearAnimation : ()V
    //   1416: aload_1
    //   1417: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1420: ifnull -> 1785
    //   1423: aload_1
    //   1424: iload_2
    //   1425: invokevirtual setStateAfterAnimating : (I)V
    //   1428: iconst_1
    //   1429: istore #8
    //   1431: goto -> 191
    //   1434: iload_2
    //   1435: iconst_5
    //   1436: if_icmpge -> 1481
    //   1439: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1442: ifeq -> 1471
    //   1445: ldc 'FragmentManager'
    //   1447: new java/lang/StringBuilder
    //   1450: dup
    //   1451: invokespecial <init> : ()V
    //   1454: ldc_w 'movefrom RESUMED: '
    //   1457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: aload_1
    //   1461: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual toString : ()Ljava/lang/String;
    //   1467: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1470: pop
    //   1471: aload_1
    //   1472: invokevirtual performPause : ()V
    //   1475: aload_0
    //   1476: aload_1
    //   1477: iconst_0
    //   1478: invokevirtual dispatchOnFragmentPaused : (Landroid/support/v4/app/Fragment;Z)V
    //   1481: iload_2
    //   1482: iconst_4
    //   1483: if_icmpge -> 1528
    //   1486: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1489: ifeq -> 1518
    //   1492: ldc 'FragmentManager'
    //   1494: new java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial <init> : ()V
    //   1501: ldc_w 'movefrom STARTED: '
    //   1504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: aload_1
    //   1508: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1511: invokevirtual toString : ()Ljava/lang/String;
    //   1514: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1517: pop
    //   1518: aload_1
    //   1519: invokevirtual performStop : ()V
    //   1522: aload_0
    //   1523: aload_1
    //   1524: iconst_0
    //   1525: invokevirtual dispatchOnFragmentStopped : (Landroid/support/v4/app/Fragment;Z)V
    //   1528: iload_2
    //   1529: iconst_3
    //   1530: if_icmpge -> 1569
    //   1533: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1536: ifeq -> 1565
    //   1539: ldc 'FragmentManager'
    //   1541: new java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial <init> : ()V
    //   1548: ldc_w 'movefrom STOPPED: '
    //   1551: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: aload_1
    //   1555: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1558: invokevirtual toString : ()Ljava/lang/String;
    //   1561: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1564: pop
    //   1565: aload_1
    //   1566: invokevirtual performReallyStop : ()V
    //   1569: iload_2
    //   1570: iconst_2
    //   1571: if_icmpge -> 1378
    //   1574: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1577: ifeq -> 1606
    //   1580: ldc 'FragmentManager'
    //   1582: new java/lang/StringBuilder
    //   1585: dup
    //   1586: invokespecial <init> : ()V
    //   1589: ldc_w 'movefrom ACTIVITY_CREATED: '
    //   1592: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: aload_1
    //   1596: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1599: invokevirtual toString : ()Ljava/lang/String;
    //   1602: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1605: pop
    //   1606: aload_1
    //   1607: getfield mView : Landroid/view/View;
    //   1610: ifnull -> 1636
    //   1613: aload_0
    //   1614: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   1617: aload_1
    //   1618: invokevirtual onShouldSaveFragmentState : (Landroid/support/v4/app/Fragment;)Z
    //   1621: ifeq -> 1636
    //   1624: aload_1
    //   1625: getfield mSavedViewState : Landroid/util/SparseArray;
    //   1628: ifnonnull -> 1636
    //   1631: aload_0
    //   1632: aload_1
    //   1633: invokevirtual saveFragmentViewState : (Landroid/support/v4/app/Fragment;)V
    //   1636: aload_1
    //   1637: invokevirtual performDestroyView : ()V
    //   1640: aload_0
    //   1641: aload_1
    //   1642: iconst_0
    //   1643: invokevirtual dispatchOnFragmentViewDestroyed : (Landroid/support/v4/app/Fragment;Z)V
    //   1646: aload_1
    //   1647: getfield mView : Landroid/view/View;
    //   1650: ifnull -> 1767
    //   1653: aload_1
    //   1654: getfield mContainer : Landroid/view/ViewGroup;
    //   1657: ifnull -> 1767
    //   1660: aload_0
    //   1661: getfield mCurState : I
    //   1664: ifle -> 1899
    //   1667: aload_0
    //   1668: getfield mDestroyed : Z
    //   1671: ifne -> 1899
    //   1674: aload_1
    //   1675: getfield mView : Landroid/view/View;
    //   1678: invokevirtual getVisibility : ()I
    //   1681: ifne -> 1899
    //   1684: aload_1
    //   1685: getfield mPostponedAlpha : F
    //   1688: fconst_0
    //   1689: fcmpl
    //   1690: iflt -> 1899
    //   1693: aload_0
    //   1694: aload_1
    //   1695: iload_3
    //   1696: iconst_0
    //   1697: iload #4
    //   1699: invokevirtual loadAnimation : (Landroid/support/v4/app/Fragment;IZI)Landroid/view/animation/Animation;
    //   1702: astore #9
    //   1704: aload_1
    //   1705: fconst_0
    //   1706: putfield mPostponedAlpha : F
    //   1709: aload #9
    //   1711: ifnull -> 1756
    //   1714: aload_1
    //   1715: aload_1
    //   1716: getfield mView : Landroid/view/View;
    //   1719: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   1722: aload_1
    //   1723: iload_2
    //   1724: invokevirtual setStateAfterAnimating : (I)V
    //   1727: aload #9
    //   1729: new android/support/v4/app/FragmentManagerImpl$2
    //   1732: dup
    //   1733: aload_0
    //   1734: aload_1
    //   1735: getfield mView : Landroid/view/View;
    //   1738: aload #9
    //   1740: aload_1
    //   1741: invokespecial <init> : (Landroid/support/v4/app/FragmentManagerImpl;Landroid/view/View;Landroid/view/animation/Animation;Landroid/support/v4/app/Fragment;)V
    //   1744: invokevirtual setAnimationListener : (Landroid/view/animation/Animation$AnimationListener;)V
    //   1747: aload_1
    //   1748: getfield mView : Landroid/view/View;
    //   1751: aload #9
    //   1753: invokevirtual startAnimation : (Landroid/view/animation/Animation;)V
    //   1756: aload_1
    //   1757: getfield mContainer : Landroid/view/ViewGroup;
    //   1760: aload_1
    //   1761: getfield mView : Landroid/view/View;
    //   1764: invokevirtual removeView : (Landroid/view/View;)V
    //   1767: aload_1
    //   1768: aconst_null
    //   1769: putfield mContainer : Landroid/view/ViewGroup;
    //   1772: aload_1
    //   1773: aconst_null
    //   1774: putfield mView : Landroid/view/View;
    //   1777: aload_1
    //   1778: aconst_null
    //   1779: putfield mInnerView : Landroid/view/View;
    //   1782: goto -> 1378
    //   1785: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   1788: ifeq -> 1817
    //   1791: ldc 'FragmentManager'
    //   1793: new java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial <init> : ()V
    //   1800: ldc_w 'movefrom CREATED: '
    //   1803: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: aload_1
    //   1807: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1810: invokevirtual toString : ()Ljava/lang/String;
    //   1813: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1816: pop
    //   1817: aload_1
    //   1818: getfield mRetaining : Z
    //   1821: ifne -> 1870
    //   1824: aload_1
    //   1825: invokevirtual performDestroy : ()V
    //   1828: aload_0
    //   1829: aload_1
    //   1830: iconst_0
    //   1831: invokevirtual dispatchOnFragmentDestroyed : (Landroid/support/v4/app/Fragment;Z)V
    //   1834: aload_1
    //   1835: invokevirtual performDetach : ()V
    //   1838: aload_0
    //   1839: aload_1
    //   1840: iconst_0
    //   1841: invokevirtual dispatchOnFragmentDetached : (Landroid/support/v4/app/Fragment;Z)V
    //   1844: iload_2
    //   1845: istore #8
    //   1847: iload #5
    //   1849: ifne -> 191
    //   1852: aload_1
    //   1853: getfield mRetaining : Z
    //   1856: ifne -> 1878
    //   1859: aload_0
    //   1860: aload_1
    //   1861: invokevirtual makeInactive : (Landroid/support/v4/app/Fragment;)V
    //   1864: iload_2
    //   1865: istore #8
    //   1867: goto -> 191
    //   1870: aload_1
    //   1871: iconst_0
    //   1872: putfield mState : I
    //   1875: goto -> 1834
    //   1878: aload_1
    //   1879: aconst_null
    //   1880: putfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   1883: aload_1
    //   1884: aconst_null
    //   1885: putfield mParentFragment : Landroid/support/v4/app/Fragment;
    //   1888: aload_1
    //   1889: aconst_null
    //   1890: putfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   1893: iload_2
    //   1894: istore #8
    //   1896: goto -> 191
    //   1899: aconst_null
    //   1900: astore #9
    //   1902: goto -> 1704
    //   1905: aconst_null
    //   1906: astore #9
    //   1908: goto -> 907
    // Exception table:
    //   from	to	target	type
    //   832	845	1286	android/content/res/Resources$NotFoundException
  }
  
  public void noteStateNotSaved() {
    this.mStateSaved = false;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    Fragment fragment1;
    boolean bool;
    if (!"fragment".equals(paramString))
      return null; 
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray typedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
    if (str1 == null)
      str1 = typedArray2.getString(0); 
    int i = typedArray2.getResourceId(1, -1);
    String str2 = typedArray2.getString(2);
    typedArray2.recycle();
    if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), str1))
      return null; 
    if (paramView != null) {
      bool = paramView.getId();
    } else {
      bool = false;
    } 
    if (bool == -1 && i == -1 && str2 == null)
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1); 
    if (i != -1) {
      Fragment fragment = findFragmentById(i);
    } else {
      typedArray2 = null;
    } 
    TypedArray typedArray1 = typedArray2;
    if (typedArray2 == null) {
      typedArray1 = typedArray2;
      if (str2 != null)
        fragment1 = findFragmentByTag(str2); 
    } 
    Fragment fragment2 = fragment1;
    if (fragment1 == null) {
      fragment2 = fragment1;
      if (bool != -1)
        fragment2 = findFragmentById(bool); 
    } 
    if (DEBUG)
      Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(i) + " fname=" + str1 + " existing=" + fragment2); 
    if (fragment2 == null) {
      boolean bool1;
      fragment1 = Fragment.instantiate(paramContext, str1);
      fragment1.mFromLayout = true;
      if (i != 0) {
        bool1 = i;
      } else {
        bool1 = bool;
      } 
      fragment1.mFragmentId = bool1;
      fragment1.mContainerId = bool;
      fragment1.mTag = str2;
      fragment1.mInLayout = true;
      fragment1.mFragmentManager = this;
      fragment1.mHost = this.mHost;
      fragment1.onInflate(this.mHost.getContext(), paramAttributeSet, fragment1.mSavedFragmentState);
      addFragment(fragment1, true);
    } else {
      if (fragment2.mInLayout)
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(bool) + " with another fragment for " + str1); 
      fragment2.mInLayout = true;
      fragment2.mHost = this.mHost;
      if (!fragment2.mRetaining)
        fragment2.onInflate(this.mHost.getContext(), paramAttributeSet, fragment2.mSavedFragmentState); 
      fragment1 = fragment2;
    } 
    if (this.mCurState < 1 && fragment1.mFromLayout) {
      moveToState(fragment1, 1, 0, 0, false);
    } else {
      moveToState(fragment1);
    } 
    if (fragment1.mView == null)
      throw new IllegalStateException("Fragment " + str1 + " did not create a view."); 
    if (i != 0)
      fragment1.mView.setId(i); 
    if (fragment1.mView.getTag() == null)
      fragment1.mView.setTag(str2); 
    return fragment1.mView;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment) {
    if (paramFragment.mDeferStart) {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
        return;
      } 
    } else {
      return;
    } 
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public void popBackStack() {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2) {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Bad id: " + paramInt1); 
    enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt) {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate() {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2) {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Bad id: " + paramInt1); 
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt) {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2) {
    if (this.mBackStack == null)
      return false; 
    if (paramString == null && paramInt1 < 0 && (paramInt2 & 0x1) == 0) {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0)
        return false; 
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    } else {
      int i = -1;
      if (paramString != null || paramInt1 >= 0) {
        int j = this.mBackStack.size() - 1;
        while (true) {
          if (j >= 0) {
            BackStackRecord backStackRecord = this.mBackStack.get(j);
            if ((paramString == null || !paramString.equals(backStackRecord.getName())) && (paramInt1 < 0 || paramInt1 != backStackRecord.mIndex)) {
              j--;
              continue;
            } 
          } 
          if (j < 0) {
            boolean bool = false;
            // Byte code: goto -> 10
          } 
          i = j;
          if ((paramInt2 & 0x1) != 0)
            for (paramInt2 = j - 1;; paramInt2--) {
              i = paramInt2;
              if (paramInt2 >= 0) {
                BackStackRecord backStackRecord = this.mBackStack.get(paramInt2);
                if (paramString == null || !paramString.equals(backStackRecord.getName())) {
                  i = paramInt2;
                  if (paramInt1 >= 0) {
                    i = paramInt2;
                    if (paramInt1 == backStackRecord.mIndex)
                      continue; 
                  } 
                  break;
                } 
                continue;
              } 
              break;
            }  
          if (i == this.mBackStack.size() - 1) {
            boolean bool = false;
            // Byte code: goto -> 10
          } 
        } 
      } 
      if (i == this.mBackStack.size() - 1) {
        boolean bool = false;
        // Byte code: goto -> 10
      } 
    } 
    return true;
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment) {
    if (paramFragment.mIndex < 0)
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager")); 
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean) {
    if (this.mLifecycleCallbacks == null)
      this.mLifecycleCallbacks = new CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>>(); 
    this.mLifecycleCallbacks.add(new Pair(paramFragmentLifecycleCallbacks, Boolean.valueOf(paramBoolean)));
  }
  
  public void removeFragment(Fragment paramFragment) {
    boolean bool;
    if (DEBUG)
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting); 
    if (!paramFragment.isInBackStack()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!paramFragment.mDetached || bool) {
      if (this.mAdded != null)
        this.mAdded.remove(paramFragment); 
      if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
        this.mNeedMenuInvalidate = true; 
      paramFragment.mAdded = false;
      paramFragment.mRemoving = true;
    } 
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.mBackStackChangeListeners != null)
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener); 
  }
  
  void reportBackStackChanged() {
    if (this.mBackStackChangeListeners != null)
      for (byte b = 0; b < this.mBackStackChangeListeners.size(); b++)
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(b)).onBackStackChanged();  
  }
  
  void restoreAllState(Parcelable<FragmentManagerNonConfig> paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (paramParcelable != null) {
      FragmentManagerState fragmentManagerState = (FragmentManagerState)paramParcelable;
      if (fragmentManagerState.mActive != null) {
        if (paramFragmentManagerNonConfig != null) {
          byte b1;
          List<Fragment> list1 = paramFragmentManagerNonConfig.getFragments();
          List<FragmentManagerNonConfig> list = paramFragmentManagerNonConfig.getChildNonConfigs();
          if (list1 != null) {
            b1 = list1.size();
          } else {
            b1 = 0;
          } 
          for (byte b2 = 0; b2 < b1; b2++) {
            Fragment fragment = list1.get(b2);
            if (DEBUG)
              Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment); 
            FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
            fragmentState.mInstance = fragment;
            fragment.mSavedViewState = null;
            fragment.mBackStackNesting = 0;
            fragment.mInLayout = false;
            fragment.mAdded = false;
            fragment.mTarget = null;
            if (fragmentState.mSavedFragmentState != null) {
              fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
              fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
              fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
            } 
          } 
        } else {
          paramParcelable = null;
        } 
        this.mActive = new ArrayList<Fragment>(fragmentManagerState.mActive.length);
        if (this.mAvailIndices != null)
          this.mAvailIndices.clear(); 
        int i = 0;
        while (true) {
          if (i < fragmentManagerState.mActive.length) {
            FragmentState fragmentState = fragmentManagerState.mActive[i];
            if (fragmentState != null) {
              if (paramParcelable != null && i < paramParcelable.size()) {
                fragment = (Fragment)paramParcelable.get(i);
              } else {
                fragment = null;
              } 
              Fragment fragment = fragmentState.instantiate(this.mHost, this.mParent, (FragmentManagerNonConfig)fragment);
              if (DEBUG)
                Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + fragment); 
              this.mActive.add(fragment);
              fragmentState.mInstance = null;
            } else {
              this.mActive.add(null);
              if (this.mAvailIndices == null)
                this.mAvailIndices = new ArrayList<Integer>(); 
              if (DEBUG)
                Log.v("FragmentManager", "restoreAllState: avail #" + i); 
              this.mAvailIndices.add(Integer.valueOf(i));
            } 
            i++;
            continue;
          } 
          if (paramFragmentManagerNonConfig != null) {
            List<Fragment> list = paramFragmentManagerNonConfig.getFragments();
            if (list != null) {
              i = list.size();
            } else {
              i = 0;
            } 
            for (byte b = 0; b < i; b++) {
              Fragment fragment = list.get(b);
              if (fragment.mTargetIndex >= 0)
                if (fragment.mTargetIndex < this.mActive.size()) {
                  fragment.mTarget = this.mActive.get(fragment.mTargetIndex);
                } else {
                  Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                  fragment.mTarget = null;
                }  
            } 
          } 
          if (fragmentManagerState.mAdded != null) {
            this.mAdded = new ArrayList<Fragment>(fragmentManagerState.mAdded.length);
            for (i = 0; i < fragmentManagerState.mAdded.length; i++) {
              Fragment fragment = this.mActive.get(fragmentManagerState.mAdded[i]);
              if (fragment == null)
                throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i])); 
              fragment.mAdded = true;
              if (DEBUG)
                Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment); 
              if (this.mAdded.contains(fragment))
                throw new IllegalStateException("Already added!"); 
              this.mAdded.add(fragment);
            } 
          } else {
            this.mAdded = null;
          } 
          if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList<BackStackRecord>(fragmentManagerState.mBackStack.length);
            i = 0;
            while (true) {
              if (i < fragmentManagerState.mBackStack.length) {
                BackStackRecord backStackRecord = fragmentManagerState.mBackStack[i].instantiate(this);
                if (DEBUG) {
                  Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + backStackRecord.mIndex + "): " + backStackRecord);
                  PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
                  backStackRecord.dump("  ", printWriter, false);
                  printWriter.close();
                } 
                this.mBackStack.add(backStackRecord);
                if (backStackRecord.mIndex >= 0)
                  setBackStackIndex(backStackRecord.mIndex, backStackRecord); 
                i++;
                continue;
              } 
              return;
            } 
            break;
          } 
          this.mBackStack = null;
          // Byte code: goto -> 4
        } 
      } 
    } 
  }
  
  FragmentManagerNonConfig retainNonConfig() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield mActive : Ljava/util/ArrayList;
    //   6: ifnull -> 283
    //   9: iconst_0
    //   10: istore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore #4
    //   16: aload_3
    //   17: astore #5
    //   19: aload #4
    //   21: astore #6
    //   23: iload_2
    //   24: aload_0
    //   25: getfield mActive : Ljava/util/ArrayList;
    //   28: invokevirtual size : ()I
    //   31: if_icmpge -> 289
    //   34: aload_0
    //   35: getfield mActive : Ljava/util/ArrayList;
    //   38: iload_2
    //   39: invokevirtual get : (I)Ljava/lang/Object;
    //   42: checkcast android/support/v4/app/Fragment
    //   45: astore #7
    //   47: aload #7
    //   49: ifnull -> 327
    //   52: aload_3
    //   53: astore #6
    //   55: aload #7
    //   57: getfield mRetainInstance : Z
    //   60: ifeq -> 159
    //   63: aload_3
    //   64: astore #5
    //   66: aload_3
    //   67: ifnonnull -> 79
    //   70: new java/util/ArrayList
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #5
    //   79: aload #5
    //   81: aload #7
    //   83: invokevirtual add : (Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload #7
    //   89: iconst_1
    //   90: putfield mRetaining : Z
    //   93: aload #7
    //   95: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   98: ifnull -> 224
    //   101: aload #7
    //   103: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   106: getfield mIndex : I
    //   109: istore #8
    //   111: aload #7
    //   113: iload #8
    //   115: putfield mTargetIndex : I
    //   118: aload #5
    //   120: astore #6
    //   122: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   125: ifeq -> 159
    //   128: ldc 'FragmentManager'
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: ldc_w 'retainNonConfig: keeping retained '
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload #7
    //   145: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual toString : ()Ljava/lang/String;
    //   151: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload #5
    //   157: astore #6
    //   159: aload #7
    //   161: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   164: ifnull -> 321
    //   167: aload #7
    //   169: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   172: invokevirtual retainNonConfig : ()Landroid/support/v4/app/FragmentManagerNonConfig;
    //   175: astore #5
    //   177: aload #5
    //   179: ifnull -> 321
    //   182: aload #4
    //   184: astore_3
    //   185: aload #4
    //   187: ifnonnull -> 230
    //   190: new java/util/ArrayList
    //   193: dup
    //   194: invokespecial <init> : ()V
    //   197: astore #4
    //   199: iconst_0
    //   200: istore #8
    //   202: aload #4
    //   204: astore_3
    //   205: iload #8
    //   207: iload_2
    //   208: if_icmpge -> 230
    //   211: aload #4
    //   213: aconst_null
    //   214: invokevirtual add : (Ljava/lang/Object;)Z
    //   217: pop
    //   218: iinc #8, 1
    //   221: goto -> 202
    //   224: iconst_m1
    //   225: istore #8
    //   227: goto -> 111
    //   230: aload_3
    //   231: aload #5
    //   233: invokevirtual add : (Ljava/lang/Object;)Z
    //   236: pop
    //   237: aload_3
    //   238: astore #4
    //   240: iconst_1
    //   241: istore #8
    //   243: aload #4
    //   245: ifnull -> 260
    //   248: iload #8
    //   250: ifne -> 260
    //   253: aload #4
    //   255: aconst_null
    //   256: invokevirtual add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: aload #4
    //   262: astore_3
    //   263: aload #6
    //   265: astore #4
    //   267: iinc #2, 1
    //   270: aload_3
    //   271: astore #6
    //   273: aload #4
    //   275: astore_3
    //   276: aload #6
    //   278: astore #4
    //   280: goto -> 16
    //   283: aconst_null
    //   284: astore #5
    //   286: aconst_null
    //   287: astore #6
    //   289: aload #5
    //   291: ifnonnull -> 305
    //   294: aload #6
    //   296: ifnonnull -> 305
    //   299: aload_1
    //   300: astore #4
    //   302: aload #4
    //   304: areturn
    //   305: new android/support/v4/app/FragmentManagerNonConfig
    //   308: dup
    //   309: aload #5
    //   311: aload #6
    //   313: invokespecial <init> : (Ljava/util/List;Ljava/util/List;)V
    //   316: astore #4
    //   318: goto -> 302
    //   321: iconst_0
    //   322: istore #8
    //   324: goto -> 243
    //   327: aload_3
    //   328: astore #6
    //   330: aload #4
    //   332: astore_3
    //   333: aload #6
    //   335: astore #4
    //   337: goto -> 267
  }
  
  Parcelable saveAllState() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokespecial forcePostponedTransactions : ()V
    //   8: aload_0
    //   9: invokespecial endAnimatingAwayFragments : ()V
    //   12: aload_0
    //   13: invokevirtual execPendingActions : ()Z
    //   16: pop
    //   17: getstatic android/support/v4/app/FragmentManagerImpl.HONEYCOMB : Z
    //   20: ifeq -> 28
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield mStateSaved : Z
    //   28: aload_2
    //   29: astore_3
    //   30: aload_0
    //   31: getfield mActive : Ljava/util/ArrayList;
    //   34: ifnull -> 49
    //   37: aload_0
    //   38: getfield mActive : Ljava/util/ArrayList;
    //   41: invokevirtual size : ()I
    //   44: ifgt -> 51
    //   47: aload_2
    //   48: astore_3
    //   49: aload_3
    //   50: areturn
    //   51: aload_0
    //   52: getfield mActive : Ljava/util/ArrayList;
    //   55: invokevirtual size : ()I
    //   58: istore #4
    //   60: iload #4
    //   62: anewarray android/support/v4/app/FragmentState
    //   65: astore #5
    //   67: iconst_0
    //   68: istore #6
    //   70: iconst_0
    //   71: istore #7
    //   73: iload #7
    //   75: iload #4
    //   77: if_icmpge -> 381
    //   80: aload_0
    //   81: getfield mActive : Ljava/util/ArrayList;
    //   84: iload #7
    //   86: invokevirtual get : (I)Ljava/lang/Object;
    //   89: checkcast android/support/v4/app/Fragment
    //   92: astore #8
    //   94: aload #8
    //   96: ifnull -> 735
    //   99: aload #8
    //   101: getfield mIndex : I
    //   104: ifge -> 153
    //   107: aload_0
    //   108: new java/lang/IllegalStateException
    //   111: dup
    //   112: new java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: ldc_w 'Failure saving state: active '
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload #8
    //   127: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: ldc_w ' has cleared index: '
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload #8
    //   138: getfield mIndex : I
    //   141: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   153: new android/support/v4/app/FragmentState
    //   156: dup
    //   157: aload #8
    //   159: invokespecial <init> : (Landroid/support/v4/app/Fragment;)V
    //   162: astore_3
    //   163: aload #5
    //   165: iload #7
    //   167: aload_3
    //   168: aastore
    //   169: aload #8
    //   171: getfield mState : I
    //   174: ifle -> 369
    //   177: aload_3
    //   178: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   181: ifnonnull -> 369
    //   184: aload_3
    //   185: aload_0
    //   186: aload #8
    //   188: invokevirtual saveFragmentBasicState : (Landroid/support/v4/app/Fragment;)Landroid/os/Bundle;
    //   191: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   194: aload #8
    //   196: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   199: ifnull -> 314
    //   202: aload #8
    //   204: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   207: getfield mIndex : I
    //   210: ifge -> 259
    //   213: aload_0
    //   214: new java/lang/IllegalStateException
    //   217: dup
    //   218: new java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial <init> : ()V
    //   225: ldc_w 'Failure saving state: '
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload #8
    //   233: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: ldc_w ' has target not in fragment manager: '
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload #8
    //   244: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   247: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokespecial <init> : (Ljava/lang/String;)V
    //   256: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   259: aload_3
    //   260: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   263: ifnonnull -> 277
    //   266: aload_3
    //   267: new android/os/Bundle
    //   270: dup
    //   271: invokespecial <init> : ()V
    //   274: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   277: aload_0
    //   278: aload_3
    //   279: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   282: ldc 'android:target_state'
    //   284: aload #8
    //   286: getfield mTarget : Landroid/support/v4/app/Fragment;
    //   289: invokevirtual putFragment : (Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V
    //   292: aload #8
    //   294: getfield mTargetRequestCode : I
    //   297: ifeq -> 314
    //   300: aload_3
    //   301: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   304: ldc 'android:target_req_state'
    //   306: aload #8
    //   308: getfield mTargetRequestCode : I
    //   311: invokevirtual putInt : (Ljava/lang/String;I)V
    //   314: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   317: ifeq -> 360
    //   320: ldc 'FragmentManager'
    //   322: new java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial <init> : ()V
    //   329: ldc_w 'Saved state of '
    //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload #8
    //   337: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   340: ldc_w ': '
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_3
    //   347: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   350: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: invokevirtual toString : ()Ljava/lang/String;
    //   356: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   359: pop
    //   360: iconst_1
    //   361: istore #6
    //   363: iinc #7, 1
    //   366: goto -> 73
    //   369: aload_3
    //   370: aload #8
    //   372: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   375: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   378: goto -> 314
    //   381: iload #6
    //   383: ifne -> 408
    //   386: aload_2
    //   387: astore_3
    //   388: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   391: ifeq -> 49
    //   394: ldc 'FragmentManager'
    //   396: ldc_w 'saveAllState: no fragments!'
    //   399: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   402: pop
    //   403: aload_2
    //   404: astore_3
    //   405: goto -> 49
    //   408: aload_0
    //   409: getfield mAdded : Ljava/util/ArrayList;
    //   412: ifnull -> 581
    //   415: aload_0
    //   416: getfield mAdded : Ljava/util/ArrayList;
    //   419: invokevirtual size : ()I
    //   422: istore #7
    //   424: iload #7
    //   426: ifle -> 581
    //   429: iload #7
    //   431: newarray int
    //   433: astore_2
    //   434: iconst_0
    //   435: istore #6
    //   437: aload_2
    //   438: astore_3
    //   439: iload #6
    //   441: iload #7
    //   443: if_icmpge -> 583
    //   446: aload_2
    //   447: iload #6
    //   449: aload_0
    //   450: getfield mAdded : Ljava/util/ArrayList;
    //   453: iload #6
    //   455: invokevirtual get : (I)Ljava/lang/Object;
    //   458: checkcast android/support/v4/app/Fragment
    //   461: getfield mIndex : I
    //   464: iastore
    //   465: aload_2
    //   466: iload #6
    //   468: iaload
    //   469: ifge -> 524
    //   472: aload_0
    //   473: new java/lang/IllegalStateException
    //   476: dup
    //   477: new java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial <init> : ()V
    //   484: ldc_w 'Failure saving state: active '
    //   487: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield mAdded : Ljava/util/ArrayList;
    //   494: iload #6
    //   496: invokevirtual get : (I)Ljava/lang/Object;
    //   499: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: ldc_w ' has cleared index: '
    //   505: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_2
    //   509: iload #6
    //   511: iaload
    //   512: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   515: invokevirtual toString : ()Ljava/lang/String;
    //   518: invokespecial <init> : (Ljava/lang/String;)V
    //   521: invokespecial throwException : (Ljava/lang/RuntimeException;)V
    //   524: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   527: ifeq -> 575
    //   530: ldc 'FragmentManager'
    //   532: new java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial <init> : ()V
    //   539: ldc_w 'saveAllState: adding fragment #'
    //   542: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: iload #6
    //   547: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   550: ldc_w ': '
    //   553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield mAdded : Ljava/util/ArrayList;
    //   560: iload #6
    //   562: invokevirtual get : (I)Ljava/lang/Object;
    //   565: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: invokevirtual toString : ()Ljava/lang/String;
    //   571: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   574: pop
    //   575: iinc #6, 1
    //   578: goto -> 437
    //   581: aconst_null
    //   582: astore_3
    //   583: aload_1
    //   584: astore_2
    //   585: aload_0
    //   586: getfield mBackStack : Ljava/util/ArrayList;
    //   589: ifnull -> 706
    //   592: aload_0
    //   593: getfield mBackStack : Ljava/util/ArrayList;
    //   596: invokevirtual size : ()I
    //   599: istore #7
    //   601: aload_1
    //   602: astore_2
    //   603: iload #7
    //   605: ifle -> 706
    //   608: iload #7
    //   610: anewarray android/support/v4/app/BackStackState
    //   613: astore_1
    //   614: iconst_0
    //   615: istore #6
    //   617: aload_1
    //   618: astore_2
    //   619: iload #6
    //   621: iload #7
    //   623: if_icmpge -> 706
    //   626: aload_1
    //   627: iload #6
    //   629: new android/support/v4/app/BackStackState
    //   632: dup
    //   633: aload_0
    //   634: getfield mBackStack : Ljava/util/ArrayList;
    //   637: iload #6
    //   639: invokevirtual get : (I)Ljava/lang/Object;
    //   642: checkcast android/support/v4/app/BackStackRecord
    //   645: invokespecial <init> : (Landroid/support/v4/app/BackStackRecord;)V
    //   648: aastore
    //   649: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   652: ifeq -> 700
    //   655: ldc 'FragmentManager'
    //   657: new java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial <init> : ()V
    //   664: ldc_w 'saveAllState: adding back stack #'
    //   667: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload #6
    //   672: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   675: ldc_w ': '
    //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_0
    //   682: getfield mBackStack : Ljava/util/ArrayList;
    //   685: iload #6
    //   687: invokevirtual get : (I)Ljava/lang/Object;
    //   690: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   693: invokevirtual toString : ()Ljava/lang/String;
    //   696: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   699: pop
    //   700: iinc #6, 1
    //   703: goto -> 617
    //   706: new android/support/v4/app/FragmentManagerState
    //   709: dup
    //   710: invokespecial <init> : ()V
    //   713: astore_1
    //   714: aload_1
    //   715: aload #5
    //   717: putfield mActive : [Landroid/support/v4/app/FragmentState;
    //   720: aload_1
    //   721: aload_3
    //   722: putfield mAdded : [I
    //   725: aload_1
    //   726: aload_2
    //   727: putfield mBackStack : [Landroid/support/v4/app/BackStackState;
    //   730: aload_1
    //   731: astore_3
    //   732: goto -> 49
    //   735: goto -> 363
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment) {
    if (this.mStateBundle == null)
      this.mStateBundle = new Bundle(); 
    paramFragment.performSaveInstanceState(this.mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, this.mStateBundle, false);
    if (!this.mStateBundle.isEmpty()) {
      bundle1 = this.mStateBundle;
      this.mStateBundle = null;
    } else {
      bundle1 = null;
    } 
    if (paramFragment.mView != null)
      saveFragmentViewState(paramFragment); 
    Bundle bundle2 = bundle1;
    if (paramFragment.mSavedViewState != null) {
      bundle2 = bundle1;
      if (bundle1 == null)
        bundle2 = new Bundle(); 
      bundle2.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    } 
    Bundle bundle1 = bundle2;
    if (!paramFragment.mUserVisibleHint) {
      bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      bundle1.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    } 
    return bundle1;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment) {
    Fragment.SavedState savedState1 = null;
    if (paramFragment.mIndex < 0)
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager")); 
    Fragment.SavedState savedState2 = savedState1;
    if (paramFragment.mState > 0) {
      Bundle bundle = saveFragmentBasicState(paramFragment);
      savedState2 = savedState1;
      if (bundle != null)
        savedState2 = new Fragment.SavedState(bundle); 
    } 
    return savedState2;
  }
  
  void saveFragmentViewState(Fragment paramFragment) {
    if (paramFragment.mInnerView != null) {
      if (this.mStateArray == null) {
        this.mStateArray = new SparseArray();
      } else {
        this.mStateArray.clear();
      } 
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() > 0) {
        paramFragment.mSavedViewState = this.mStateArray;
        this.mStateArray = null;
      } 
    } 
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnonnull -> 22
    //   9: new java/util/ArrayList
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: aload_3
    //   19: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   22: aload_0
    //   23: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   26: invokevirtual size : ()I
    //   29: istore #4
    //   31: iload #4
    //   33: istore #5
    //   35: iload_1
    //   36: iload #4
    //   38: if_icmpge -> 98
    //   41: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   44: ifeq -> 85
    //   47: new java/lang/StringBuilder
    //   50: astore_3
    //   51: aload_3
    //   52: invokespecial <init> : ()V
    //   55: ldc 'FragmentManager'
    //   57: aload_3
    //   58: ldc_w 'Setting back stack index '
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload_1
    //   65: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   68: ldc_w ' to '
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: aload_0
    //   86: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   89: iload_1
    //   90: aload_2
    //   91: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: iload #5
    //   100: iload_1
    //   101: if_icmpge -> 187
    //   104: aload_0
    //   105: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   108: aconst_null
    //   109: invokevirtual add : (Ljava/lang/Object;)Z
    //   112: pop
    //   113: aload_0
    //   114: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   117: ifnonnull -> 133
    //   120: new java/util/ArrayList
    //   123: astore_3
    //   124: aload_3
    //   125: invokespecial <init> : ()V
    //   128: aload_0
    //   129: aload_3
    //   130: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   133: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   136: ifeq -> 168
    //   139: new java/lang/StringBuilder
    //   142: astore_3
    //   143: aload_3
    //   144: invokespecial <init> : ()V
    //   147: ldc 'FragmentManager'
    //   149: aload_3
    //   150: ldc_w 'Adding available back stack index '
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload #5
    //   158: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aload_0
    //   169: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   172: iload #5
    //   174: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   177: invokevirtual add : (Ljava/lang/Object;)Z
    //   180: pop
    //   181: iinc #5, 1
    //   184: goto -> 98
    //   187: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   190: ifeq -> 231
    //   193: new java/lang/StringBuilder
    //   196: astore_3
    //   197: aload_3
    //   198: invokespecial <init> : ()V
    //   201: ldc 'FragmentManager'
    //   203: aload_3
    //   204: ldc_w 'Adding back stack index '
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_1
    //   211: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   214: ldc_w ' with '
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_2
    //   221: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: aload_0
    //   232: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   235: aload_2
    //   236: invokevirtual add : (Ljava/lang/Object;)Z
    //   239: pop
    //   240: goto -> 95
    //   243: astore_2
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_2
    //   247: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	243	finally
    //   22	31	243	finally
    //   41	85	243	finally
    //   85	95	243	finally
    //   95	97	243	finally
    //   104	133	243	finally
    //   133	168	243	finally
    //   168	181	243	finally
    //   187	231	243	finally
    //   231	240	243	finally
    //   244	246	243	finally
  }
  
  public void showFragment(Fragment paramFragment) {
    boolean bool = false;
    if (DEBUG)
      Log.v("FragmentManager", "show: " + paramFragment); 
    if (paramFragment.mHidden) {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged)
        bool = true; 
      paramFragment.mHiddenChanged = bool;
    } 
  }
  
  void startPendingDeferredFragments() {
    if (this.mActive != null) {
      byte b = 0;
      while (true) {
        if (b < this.mActive.size()) {
          Fragment fragment = this.mActive.get(b);
          if (fragment != null)
            performPendingDeferredStart(fragment); 
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    } 
    DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks) {
    if (this.mLifecycleCallbacks != null)
      synchronized (this.mLifecycleCallbacks) {
        int i = this.mLifecycleCallbacks.size();
        byte b = 0;
        while (true) {
          if (b < i)
            if (((Pair)this.mLifecycleCallbacks.get(b)).first == paramFragmentLifecycleCallbacks) {
              this.mLifecycleCallbacks.remove(b);
            } else {
              b++;
              continue;
            }  
          return;
        } 
      }  
  }
  
  static {
    boolean bool = false;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 11)
      bool = true; 
    HONEYCOMB = bool;
  }
  
  static class AnimateOnHWLayerIfNeededListener implements Animation.AnimationListener {
    private Animation.AnimationListener mOriginalListener;
    
    private boolean mShouldRunOnHWLayer;
    
    View mView;
    
    public AnimateOnHWLayerIfNeededListener(View param1View, Animation param1Animation) {
      if (param1View != null && param1Animation != null)
        this.mView = param1View; 
    }
    
    public AnimateOnHWLayerIfNeededListener(View param1View, Animation param1Animation, Animation.AnimationListener param1AnimationListener) {
      if (param1View != null && param1Animation != null) {
        this.mOriginalListener = param1AnimationListener;
        this.mView = param1View;
        this.mShouldRunOnHWLayer = true;
      } 
    }
    
    @CallSuper
    public void onAnimationEnd(Animation param1Animation) {
      if (this.mView != null && this.mShouldRunOnHWLayer)
        if (ViewCompat.isAttachedToWindow(this.mView) || BuildCompat.isAtLeastN()) {
          this.mView.post(new Runnable() {
                public void run() {
                  ViewCompat.setLayerType(FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.this.mView, 0, null);
                }
              });
        } else {
          ViewCompat.setLayerType(this.mView, 0, null);
        }  
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationEnd(param1Animation); 
    }
    
    public void onAnimationRepeat(Animation param1Animation) {
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationRepeat(param1Animation); 
    }
    
    @CallSuper
    public void onAnimationStart(Animation param1Animation) {
      if (this.mOriginalListener != null)
        this.mOriginalListener.onAnimationStart(param1Animation); 
    }
  }
  
  class null implements Runnable {
    public void run() {
      ViewCompat.setLayerType(this.this$0.mView, 0, null);
    }
  }
  
  static class FragmentTag {
    public static final int[] Fragment = new int[] { 16842755, 16842960, 16842961 };
    
    public static final int Fragment_id = 1;
    
    public static final int Fragment_name = 0;
    
    public static final int Fragment_tag = 2;
  }
  
  static interface OpGenerator {
    boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1);
  }
  
  private class PopBackStackState implements OpGenerator {
    final int mFlags;
    
    final int mId;
    
    final String mName;
    
    PopBackStackState(String param1String, int param1Int1, int param1Int2) {
      this.mName = param1String;
      this.mId = param1Int1;
      this.mFlags = param1Int2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1) {
      return FragmentManagerImpl.this.popBackStackState(param1ArrayList, param1ArrayList1, this.mName, this.mId, this.mFlags);
    }
  }
  
  static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
    private final boolean mIsBack;
    
    private int mNumPostponed;
    
    private final BackStackRecord mRecord;
    
    StartEnterTransitionListener(BackStackRecord param1BackStackRecord, boolean param1Boolean) {
      this.mIsBack = param1Boolean;
      this.mRecord = param1BackStackRecord;
    }
    
    public void cancelTransaction() {
      this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }
    
    public void completeTransaction() {
      boolean bool2;
      boolean bool1 = false;
      if (this.mNumPostponed > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
      int i = fragmentManagerImpl.mAdded.size();
      for (byte b = 0; b < i; b++) {
        Fragment fragment = fragmentManagerImpl.mAdded.get(b);
        fragment.setOnStartEnterTransitionListener(null);
        if (bool2 && fragment.isPostponed())
          fragment.startPostponedEnterTransition(); 
      } 
      fragmentManagerImpl = this.mRecord.mManager;
      BackStackRecord backStackRecord = this.mRecord;
      boolean bool = this.mIsBack;
      if (!bool2)
        bool1 = true; 
      fragmentManagerImpl.completeExecute(backStackRecord, bool, bool1, true);
    }
    
    public boolean isReady() {
      return (this.mNumPostponed == 0);
    }
    
    public void onStartEnterTransition() {
      this.mNumPostponed--;
      if (this.mNumPostponed == 0)
        this.mRecord.mManager.scheduleCommit(); 
    }
    
    public void startListening() {
      this.mNumPostponed++;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */