package android.support.v4.app;

import android.os.Build;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
  static final int OP_ADD = 1;
  
  static final int OP_ATTACH = 7;
  
  static final int OP_DETACH = 6;
  
  static final int OP_HIDE = 4;
  
  static final int OP_NULL = 0;
  
  static final int OP_REMOVE = 3;
  
  static final int OP_REPLACE = 2;
  
  static final int OP_SHOW = 5;
  
  static final boolean SUPPORTS_TRANSITIONS;
  
  static final String TAG = "FragmentManager";
  
  boolean mAddToBackStack;
  
  boolean mAllowAddToBackStack = true;
  
  boolean mAllowOptimization = false;
  
  int mBreadCrumbShortTitleRes;
  
  CharSequence mBreadCrumbShortTitleText;
  
  int mBreadCrumbTitleRes;
  
  CharSequence mBreadCrumbTitleText;
  
  boolean mCommitted;
  
  int mEnterAnim;
  
  int mExitAnim;
  
  int mIndex = -1;
  
  final FragmentManagerImpl mManager;
  
  String mName;
  
  ArrayList<Op> mOps = new ArrayList<Op>();
  
  int mPopEnterAnim;
  
  int mPopExitAnim;
  
  ArrayList<String> mSharedElementSourceNames;
  
  ArrayList<String> mSharedElementTargetNames;
  
  int mTransition;
  
  int mTransitionStyle;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    SUPPORTS_TRANSITIONS = bool;
  }
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl) {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2) {
    Class<?> clazz = paramFragment.getClass();
    int i = clazz.getModifiers();
    if (clazz.isAnonymousClass() || !Modifier.isPublic(i) || (clazz.isMemberClass() && !Modifier.isStatic(i)))
      throw new IllegalStateException("Fragment " + clazz.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state."); 
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null) {
      if (paramFragment.mTag != null && !paramString.equals(paramFragment.mTag))
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString); 
      paramFragment.mTag = paramString;
    } 
    if (paramInt1 != 0) {
      if (paramInt1 == -1)
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id"); 
      if (paramFragment.mFragmentId != 0 && paramFragment.mFragmentId != paramInt1)
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1); 
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    } 
    Op op = new Op();
    op.cmd = paramInt2;
    op.fragment = paramFragment;
    addOp(op);
  }
  
  private static boolean isFragmentPostponed(Op paramOp) {
    Fragment fragment = paramOp.fragment;
    return (fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed());
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment) {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString) {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString) {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(Op paramOp) {
    this.mOps.add(paramOp);
    paramOp.enterAnim = this.mEnterAnim;
    paramOp.exitAnim = this.mExitAnim;
    paramOp.popEnterAnim = this.mPopEnterAnim;
    paramOp.popExitAnim = this.mPopExitAnim;
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString) {
    if (SUPPORTS_TRANSITIONS) {
      String str = ViewCompat.getTransitionName(paramView);
      if (str == null)
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements"); 
      if (this.mSharedElementSourceNames == null) {
        this.mSharedElementSourceNames = new ArrayList<String>();
        this.mSharedElementTargetNames = new ArrayList<String>();
      } else {
        if (this.mSharedElementTargetNames.contains(paramString))
          throw new IllegalArgumentException("A shared element with the target name '" + paramString + "' has already been added to the transaction."); 
        if (this.mSharedElementSourceNames.contains(str))
          throw new IllegalArgumentException("A shared element with the source name '" + str + " has already been added to the transaction."); 
      } 
      this.mSharedElementSourceNames.add(str);
      this.mSharedElementTargetNames.add(paramString);
    } 
    return this;
  }
  
  public FragmentTransaction addToBackStack(String paramString) {
    if (!this.mAllowAddToBackStack)
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack."); 
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 7;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt) {
    if (this.mAddToBackStack) {
      if (FragmentManagerImpl.DEBUG)
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt); 
      int i = this.mOps.size();
      byte b = 0;
      while (true) {
        if (b < i) {
          Op op = this.mOps.get(b);
          if (op.fragment != null) {
            Fragment fragment = op.fragment;
            fragment.mBackStackNesting += paramInt;
            if (FragmentManagerImpl.DEBUG)
              Log.v("FragmentManager", "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting); 
          } 
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public int commit() {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss() {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean) {
    if (this.mCommitted)
      throw new IllegalStateException("commit already called"); 
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Commit: " + this);
      PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
      dump("  ", null, printWriter, null);
      printWriter.close();
    } 
    this.mCommitted = true;
    if (this.mAddToBackStack) {
      this.mIndex = this.mManager.allocBackStackIndex(this);
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    } 
    this.mIndex = -1;
    this.mManager.enqueueAction(this, paramBoolean);
    return this.mIndex;
  }
  
  public void commitNow() {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, false);
  }
  
  public void commitNowAllowingStateLoss() {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, true);
  }
  
  public FragmentTransaction detach(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 6;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack() {
    if (this.mAddToBackStack)
      throw new IllegalStateException("This transaction is already being added to the back stack"); 
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
    // Byte code:
    //   0: iload_3
    //   1: ifeq -> 316
    //   4: aload_2
    //   5: aload_1
    //   6: invokevirtual print : (Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 'mName='
    //   13: invokevirtual print : (Ljava/lang/String;)V
    //   16: aload_2
    //   17: aload_0
    //   18: getfield mName : Ljava/lang/String;
    //   21: invokevirtual print : (Ljava/lang/String;)V
    //   24: aload_2
    //   25: ldc_w ' mIndex='
    //   28: invokevirtual print : (Ljava/lang/String;)V
    //   31: aload_2
    //   32: aload_0
    //   33: getfield mIndex : I
    //   36: invokevirtual print : (I)V
    //   39: aload_2
    //   40: ldc_w ' mCommitted='
    //   43: invokevirtual print : (Ljava/lang/String;)V
    //   46: aload_2
    //   47: aload_0
    //   48: getfield mCommitted : Z
    //   51: invokevirtual println : (Z)V
    //   54: aload_0
    //   55: getfield mTransition : I
    //   58: ifeq -> 102
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual print : (Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc_w 'mTransition=#'
    //   70: invokevirtual print : (Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_0
    //   75: getfield mTransition : I
    //   78: invokestatic toHexString : (I)Ljava/lang/String;
    //   81: invokevirtual print : (Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w ' mTransitionStyle=#'
    //   88: invokevirtual print : (Ljava/lang/String;)V
    //   91: aload_2
    //   92: aload_0
    //   93: getfield mTransitionStyle : I
    //   96: invokestatic toHexString : (I)Ljava/lang/String;
    //   99: invokevirtual println : (Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield mEnterAnim : I
    //   106: ifne -> 116
    //   109: aload_0
    //   110: getfield mExitAnim : I
    //   113: ifeq -> 157
    //   116: aload_2
    //   117: aload_1
    //   118: invokevirtual print : (Ljava/lang/String;)V
    //   121: aload_2
    //   122: ldc_w 'mEnterAnim=#'
    //   125: invokevirtual print : (Ljava/lang/String;)V
    //   128: aload_2
    //   129: aload_0
    //   130: getfield mEnterAnim : I
    //   133: invokestatic toHexString : (I)Ljava/lang/String;
    //   136: invokevirtual print : (Ljava/lang/String;)V
    //   139: aload_2
    //   140: ldc_w ' mExitAnim=#'
    //   143: invokevirtual print : (Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_0
    //   148: getfield mExitAnim : I
    //   151: invokestatic toHexString : (I)Ljava/lang/String;
    //   154: invokevirtual println : (Ljava/lang/String;)V
    //   157: aload_0
    //   158: getfield mPopEnterAnim : I
    //   161: ifne -> 171
    //   164: aload_0
    //   165: getfield mPopExitAnim : I
    //   168: ifeq -> 212
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual print : (Ljava/lang/String;)V
    //   176: aload_2
    //   177: ldc_w 'mPopEnterAnim=#'
    //   180: invokevirtual print : (Ljava/lang/String;)V
    //   183: aload_2
    //   184: aload_0
    //   185: getfield mPopEnterAnim : I
    //   188: invokestatic toHexString : (I)Ljava/lang/String;
    //   191: invokevirtual print : (Ljava/lang/String;)V
    //   194: aload_2
    //   195: ldc_w ' mPopExitAnim=#'
    //   198: invokevirtual print : (Ljava/lang/String;)V
    //   201: aload_2
    //   202: aload_0
    //   203: getfield mPopExitAnim : I
    //   206: invokestatic toHexString : (I)Ljava/lang/String;
    //   209: invokevirtual println : (Ljava/lang/String;)V
    //   212: aload_0
    //   213: getfield mBreadCrumbTitleRes : I
    //   216: ifne -> 226
    //   219: aload_0
    //   220: getfield mBreadCrumbTitleText : Ljava/lang/CharSequence;
    //   223: ifnull -> 264
    //   226: aload_2
    //   227: aload_1
    //   228: invokevirtual print : (Ljava/lang/String;)V
    //   231: aload_2
    //   232: ldc_w 'mBreadCrumbTitleRes=#'
    //   235: invokevirtual print : (Ljava/lang/String;)V
    //   238: aload_2
    //   239: aload_0
    //   240: getfield mBreadCrumbTitleRes : I
    //   243: invokestatic toHexString : (I)Ljava/lang/String;
    //   246: invokevirtual print : (Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w ' mBreadCrumbTitleText='
    //   253: invokevirtual print : (Ljava/lang/String;)V
    //   256: aload_2
    //   257: aload_0
    //   258: getfield mBreadCrumbTitleText : Ljava/lang/CharSequence;
    //   261: invokevirtual println : (Ljava/lang/Object;)V
    //   264: aload_0
    //   265: getfield mBreadCrumbShortTitleRes : I
    //   268: ifne -> 278
    //   271: aload_0
    //   272: getfield mBreadCrumbShortTitleText : Ljava/lang/CharSequence;
    //   275: ifnull -> 316
    //   278: aload_2
    //   279: aload_1
    //   280: invokevirtual print : (Ljava/lang/String;)V
    //   283: aload_2
    //   284: ldc_w 'mBreadCrumbShortTitleRes=#'
    //   287: invokevirtual print : (Ljava/lang/String;)V
    //   290: aload_2
    //   291: aload_0
    //   292: getfield mBreadCrumbShortTitleRes : I
    //   295: invokestatic toHexString : (I)Ljava/lang/String;
    //   298: invokevirtual print : (Ljava/lang/String;)V
    //   301: aload_2
    //   302: ldc_w ' mBreadCrumbShortTitleText='
    //   305: invokevirtual print : (Ljava/lang/String;)V
    //   308: aload_2
    //   309: aload_0
    //   310: getfield mBreadCrumbShortTitleText : Ljava/lang/CharSequence;
    //   313: invokevirtual println : (Ljava/lang/Object;)V
    //   316: aload_0
    //   317: getfield mOps : Ljava/util/ArrayList;
    //   320: invokevirtual isEmpty : ()Z
    //   323: ifne -> 709
    //   326: aload_2
    //   327: aload_1
    //   328: invokevirtual print : (Ljava/lang/String;)V
    //   331: aload_2
    //   332: ldc_w 'Operations:'
    //   335: invokevirtual println : (Ljava/lang/String;)V
    //   338: new java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: aload_1
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w '    '
    //   352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual toString : ()Ljava/lang/String;
    //   358: pop
    //   359: aload_0
    //   360: getfield mOps : Ljava/util/ArrayList;
    //   363: invokevirtual size : ()I
    //   366: istore #4
    //   368: iconst_0
    //   369: istore #5
    //   371: iload #5
    //   373: iload #4
    //   375: if_icmpge -> 709
    //   378: aload_0
    //   379: getfield mOps : Ljava/util/ArrayList;
    //   382: iload #5
    //   384: invokevirtual get : (I)Ljava/lang/Object;
    //   387: checkcast android/support/v4/app/BackStackRecord$Op
    //   390: astore #6
    //   392: aload #6
    //   394: getfield cmd : I
    //   397: tableswitch default -> 444, 0 -> 645, 1 -> 653, 2 -> 661, 3 -> 669, 4 -> 677, 5 -> 685, 6 -> 693, 7 -> 701
    //   444: new java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial <init> : ()V
    //   451: ldc_w 'cmd='
    //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload #6
    //   459: getfield cmd : I
    //   462: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   465: invokevirtual toString : ()Ljava/lang/String;
    //   468: astore #7
    //   470: aload_2
    //   471: aload_1
    //   472: invokevirtual print : (Ljava/lang/String;)V
    //   475: aload_2
    //   476: ldc_w '  Op #'
    //   479: invokevirtual print : (Ljava/lang/String;)V
    //   482: aload_2
    //   483: iload #5
    //   485: invokevirtual print : (I)V
    //   488: aload_2
    //   489: ldc_w ': '
    //   492: invokevirtual print : (Ljava/lang/String;)V
    //   495: aload_2
    //   496: aload #7
    //   498: invokevirtual print : (Ljava/lang/String;)V
    //   501: aload_2
    //   502: ldc_w ' '
    //   505: invokevirtual print : (Ljava/lang/String;)V
    //   508: aload_2
    //   509: aload #6
    //   511: getfield fragment : Landroid/support/v4/app/Fragment;
    //   514: invokevirtual println : (Ljava/lang/Object;)V
    //   517: iload_3
    //   518: ifeq -> 639
    //   521: aload #6
    //   523: getfield enterAnim : I
    //   526: ifne -> 537
    //   529: aload #6
    //   531: getfield exitAnim : I
    //   534: ifeq -> 580
    //   537: aload_2
    //   538: aload_1
    //   539: invokevirtual print : (Ljava/lang/String;)V
    //   542: aload_2
    //   543: ldc_w 'enterAnim=#'
    //   546: invokevirtual print : (Ljava/lang/String;)V
    //   549: aload_2
    //   550: aload #6
    //   552: getfield enterAnim : I
    //   555: invokestatic toHexString : (I)Ljava/lang/String;
    //   558: invokevirtual print : (Ljava/lang/String;)V
    //   561: aload_2
    //   562: ldc_w ' exitAnim=#'
    //   565: invokevirtual print : (Ljava/lang/String;)V
    //   568: aload_2
    //   569: aload #6
    //   571: getfield exitAnim : I
    //   574: invokestatic toHexString : (I)Ljava/lang/String;
    //   577: invokevirtual println : (Ljava/lang/String;)V
    //   580: aload #6
    //   582: getfield popEnterAnim : I
    //   585: ifne -> 596
    //   588: aload #6
    //   590: getfield popExitAnim : I
    //   593: ifeq -> 639
    //   596: aload_2
    //   597: aload_1
    //   598: invokevirtual print : (Ljava/lang/String;)V
    //   601: aload_2
    //   602: ldc_w 'popEnterAnim=#'
    //   605: invokevirtual print : (Ljava/lang/String;)V
    //   608: aload_2
    //   609: aload #6
    //   611: getfield popEnterAnim : I
    //   614: invokestatic toHexString : (I)Ljava/lang/String;
    //   617: invokevirtual print : (Ljava/lang/String;)V
    //   620: aload_2
    //   621: ldc_w ' popExitAnim=#'
    //   624: invokevirtual print : (Ljava/lang/String;)V
    //   627: aload_2
    //   628: aload #6
    //   630: getfield popExitAnim : I
    //   633: invokestatic toHexString : (I)Ljava/lang/String;
    //   636: invokevirtual println : (Ljava/lang/String;)V
    //   639: iinc #5, 1
    //   642: goto -> 371
    //   645: ldc_w 'NULL'
    //   648: astore #7
    //   650: goto -> 470
    //   653: ldc_w 'ADD'
    //   656: astore #7
    //   658: goto -> 470
    //   661: ldc_w 'REPLACE'
    //   664: astore #7
    //   666: goto -> 470
    //   669: ldc_w 'REMOVE'
    //   672: astore #7
    //   674: goto -> 470
    //   677: ldc_w 'HIDE'
    //   680: astore #7
    //   682: goto -> 470
    //   685: ldc_w 'SHOW'
    //   688: astore #7
    //   690: goto -> 470
    //   693: ldc_w 'DETACH'
    //   696: astore #7
    //   698: goto -> 470
    //   701: ldc_w 'ATTACH'
    //   704: astore #7
    //   706: goto -> 470
    //   709: return
  }
  
  void executeOps() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mOps : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: iload_1
    //   12: if_icmpge -> 277
    //   15: aload_0
    //   16: getfield mOps : Ljava/util/ArrayList;
    //   19: iload_2
    //   20: invokevirtual get : (I)Ljava/lang/Object;
    //   23: checkcast android/support/v4/app/BackStackRecord$Op
    //   26: astore_3
    //   27: aload_3
    //   28: getfield fragment : Landroid/support/v4/app/Fragment;
    //   31: astore #4
    //   33: aload #4
    //   35: aload_0
    //   36: getfield mTransition : I
    //   39: aload_0
    //   40: getfield mTransitionStyle : I
    //   43: invokevirtual setNextTransition : (II)V
    //   46: aload_3
    //   47: getfield cmd : I
    //   50: tableswitch default -> 92, 1 -> 123, 2 -> 92, 3 -> 172, 4 -> 193, 5 -> 214, 6 -> 235, 7 -> 256
    //   92: new java/lang/IllegalArgumentException
    //   95: dup
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: ldc_w 'Unknown cmd: '
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: getfield cmd : I
    //   113: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: invokespecial <init> : (Ljava/lang/String;)V
    //   122: athrow
    //   123: aload #4
    //   125: aload_3
    //   126: getfield enterAnim : I
    //   129: invokevirtual setNextAnim : (I)V
    //   132: aload_0
    //   133: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   136: aload #4
    //   138: iconst_0
    //   139: invokevirtual addFragment : (Landroid/support/v4/app/Fragment;Z)V
    //   142: aload_0
    //   143: getfield mAllowOptimization : Z
    //   146: ifne -> 166
    //   149: aload_3
    //   150: getfield cmd : I
    //   153: iconst_1
    //   154: if_icmpeq -> 166
    //   157: aload_0
    //   158: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   161: aload #4
    //   163: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   166: iinc #2, 1
    //   169: goto -> 10
    //   172: aload #4
    //   174: aload_3
    //   175: getfield exitAnim : I
    //   178: invokevirtual setNextAnim : (I)V
    //   181: aload_0
    //   182: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   185: aload #4
    //   187: invokevirtual removeFragment : (Landroid/support/v4/app/Fragment;)V
    //   190: goto -> 142
    //   193: aload #4
    //   195: aload_3
    //   196: getfield exitAnim : I
    //   199: invokevirtual setNextAnim : (I)V
    //   202: aload_0
    //   203: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   206: aload #4
    //   208: invokevirtual hideFragment : (Landroid/support/v4/app/Fragment;)V
    //   211: goto -> 142
    //   214: aload #4
    //   216: aload_3
    //   217: getfield enterAnim : I
    //   220: invokevirtual setNextAnim : (I)V
    //   223: aload_0
    //   224: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   227: aload #4
    //   229: invokevirtual showFragment : (Landroid/support/v4/app/Fragment;)V
    //   232: goto -> 142
    //   235: aload #4
    //   237: aload_3
    //   238: getfield exitAnim : I
    //   241: invokevirtual setNextAnim : (I)V
    //   244: aload_0
    //   245: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   248: aload #4
    //   250: invokevirtual detachFragment : (Landroid/support/v4/app/Fragment;)V
    //   253: goto -> 142
    //   256: aload #4
    //   258: aload_3
    //   259: getfield enterAnim : I
    //   262: invokevirtual setNextAnim : (I)V
    //   265: aload_0
    //   266: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   269: aload #4
    //   271: invokevirtual attachFragment : (Landroid/support/v4/app/Fragment;)V
    //   274: goto -> 142
    //   277: aload_0
    //   278: getfield mAllowOptimization : Z
    //   281: ifne -> 299
    //   284: aload_0
    //   285: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   288: aload_0
    //   289: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   292: getfield mCurState : I
    //   295: iconst_1
    //   296: invokevirtual moveToState : (IZ)V
    //   299: return
  }
  
  void executePopOps(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mOps : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: iconst_1
    //   8: isub
    //   9: istore_2
    //   10: iload_2
    //   11: iflt -> 281
    //   14: aload_0
    //   15: getfield mOps : Ljava/util/ArrayList;
    //   18: iload_2
    //   19: invokevirtual get : (I)Ljava/lang/Object;
    //   22: checkcast android/support/v4/app/BackStackRecord$Op
    //   25: astore_3
    //   26: aload_3
    //   27: getfield fragment : Landroid/support/v4/app/Fragment;
    //   30: astore #4
    //   32: aload #4
    //   34: aload_0
    //   35: getfield mTransition : I
    //   38: invokestatic reverseTransit : (I)I
    //   41: aload_0
    //   42: getfield mTransitionStyle : I
    //   45: invokevirtual setNextTransition : (II)V
    //   48: aload_3
    //   49: getfield cmd : I
    //   52: tableswitch default -> 96, 1 -> 127, 2 -> 96, 3 -> 175, 4 -> 197, 5 -> 218, 6 -> 239, 7 -> 260
    //   96: new java/lang/IllegalArgumentException
    //   99: dup
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: ldc_w 'Unknown cmd: '
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: getfield cmd : I
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokespecial <init> : (Ljava/lang/String;)V
    //   126: athrow
    //   127: aload #4
    //   129: aload_3
    //   130: getfield popExitAnim : I
    //   133: invokevirtual setNextAnim : (I)V
    //   136: aload_0
    //   137: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   140: aload #4
    //   142: invokevirtual removeFragment : (Landroid/support/v4/app/Fragment;)V
    //   145: aload_0
    //   146: getfield mAllowOptimization : Z
    //   149: ifne -> 169
    //   152: aload_3
    //   153: getfield cmd : I
    //   156: iconst_3
    //   157: if_icmpeq -> 169
    //   160: aload_0
    //   161: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   164: aload #4
    //   166: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   169: iinc #2, -1
    //   172: goto -> 10
    //   175: aload #4
    //   177: aload_3
    //   178: getfield popEnterAnim : I
    //   181: invokevirtual setNextAnim : (I)V
    //   184: aload_0
    //   185: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   188: aload #4
    //   190: iconst_0
    //   191: invokevirtual addFragment : (Landroid/support/v4/app/Fragment;Z)V
    //   194: goto -> 145
    //   197: aload #4
    //   199: aload_3
    //   200: getfield popEnterAnim : I
    //   203: invokevirtual setNextAnim : (I)V
    //   206: aload_0
    //   207: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   210: aload #4
    //   212: invokevirtual showFragment : (Landroid/support/v4/app/Fragment;)V
    //   215: goto -> 145
    //   218: aload #4
    //   220: aload_3
    //   221: getfield popExitAnim : I
    //   224: invokevirtual setNextAnim : (I)V
    //   227: aload_0
    //   228: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   231: aload #4
    //   233: invokevirtual hideFragment : (Landroid/support/v4/app/Fragment;)V
    //   236: goto -> 145
    //   239: aload #4
    //   241: aload_3
    //   242: getfield popEnterAnim : I
    //   245: invokevirtual setNextAnim : (I)V
    //   248: aload_0
    //   249: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   252: aload #4
    //   254: invokevirtual attachFragment : (Landroid/support/v4/app/Fragment;)V
    //   257: goto -> 145
    //   260: aload #4
    //   262: aload_3
    //   263: getfield popExitAnim : I
    //   266: invokevirtual setNextAnim : (I)V
    //   269: aload_0
    //   270: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   273: aload #4
    //   275: invokevirtual detachFragment : (Landroid/support/v4/app/Fragment;)V
    //   278: goto -> 145
    //   281: aload_0
    //   282: getfield mAllowOptimization : Z
    //   285: ifne -> 307
    //   288: iload_1
    //   289: ifeq -> 307
    //   292: aload_0
    //   293: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   296: aload_0
    //   297: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   300: getfield mCurState : I
    //   303: iconst_1
    //   304: invokevirtual moveToState : (IZ)V
    //   307: return
  }
  
  void expandReplaceOps(ArrayList<Fragment> paramArrayList) {
    int i = 0;
    while (i < this.mOps.size()) {
      Op op = this.mOps.get(i);
      int j = i;
      switch (op.cmd) {
        default:
          j = i;
        case 4:
        case 5:
          i = j + 1;
          continue;
        case 1:
        case 7:
          paramArrayList.add(op.fragment);
          j = i;
        case 3:
        case 6:
          paramArrayList.remove(op.fragment);
          j = i;
        case 2:
          break;
      } 
      Fragment fragment = op.fragment;
      int k = fragment.mContainerId;
      j = paramArrayList.size();
      boolean bool = false;
      int m = j - 1;
      j = i;
      i = bool;
      while (m >= 0) {
        Fragment fragment1 = paramArrayList.get(m);
        if (fragment1.mContainerId == k)
          if (fragment1 == fragment) {
            i = 1;
          } else {
            Op op1 = new Op();
            op1.cmd = 3;
            op1.fragment = fragment1;
            op1.enterAnim = op.enterAnim;
            op1.popEnterAnim = op.popEnterAnim;
            op1.exitAnim = op.exitAnim;
            op1.popExitAnim = op.popExitAnim;
            this.mOps.add(j, op1);
            paramArrayList.remove(fragment1);
            j++;
          }  
        m--;
      } 
      if (i != 0) {
        this.mOps.remove(j);
        j--;
      } 
      op.cmd = 1;
      paramArrayList.add(fragment);
    } 
  }
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (FragmentManagerImpl.DEBUG)
      Log.v("FragmentManager", "Run: " + this); 
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.mAddToBackStack)
      this.mManager.addBackStackState(this); 
    return true;
  }
  
  public CharSequence getBreadCrumbShortTitle() {
    return (this.mBreadCrumbShortTitleRes != 0) ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes() {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle() {
    return (this.mBreadCrumbTitleRes != 0) ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes() {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId() {
    return this.mIndex;
  }
  
  public String getName() {
    return this.mName;
  }
  
  public int getTransition() {
    return this.mTransition;
  }
  
  public int getTransitionStyle() {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 4;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  boolean interactsWith(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mOps : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_3
    //   10: iload_3
    //   11: iload_2
    //   12: if_icmpge -> 48
    //   15: aload_0
    //   16: getfield mOps : Ljava/util/ArrayList;
    //   19: iload_3
    //   20: invokevirtual get : (I)Ljava/lang/Object;
    //   23: checkcast android/support/v4/app/BackStackRecord$Op
    //   26: getfield fragment : Landroid/support/v4/app/Fragment;
    //   29: getfield mContainerId : I
    //   32: iload_1
    //   33: if_icmpne -> 42
    //   36: iconst_1
    //   37: istore #4
    //   39: iload #4
    //   41: ireturn
    //   42: iinc #3, 1
    //   45: goto -> 10
    //   48: iconst_0
    //   49: istore #4
    //   51: goto -> 39
  }
  
  boolean interactsWith(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2) {
    if (paramInt2 == paramInt1)
      return false; 
    int i = this.mOps.size();
    int j = -1;
    for (byte b = 0; b < i; b++) {
      int k = ((Op)this.mOps.get(b)).fragment.mContainerId;
      if (k != 0 && k != j) {
        for (j = paramInt1; j < paramInt2; j++) {
          BackStackRecord backStackRecord = paramArrayList.get(j);
          int m = backStackRecord.mOps.size();
          for (byte b1 = 0; b1 < m; b1++) {
            if (((Op)backStackRecord.mOps.get(b1)).fragment.mContainerId == k)
              return true; 
          } 
        } 
        j = k;
      } 
    } 
    return false;
  }
  
  public boolean isAddToBackStackAllowed() {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty() {
    return this.mOps.isEmpty();
  }
  
  boolean isPostponed() {
    boolean bool = false;
    for (byte b = 0;; b++) {
      boolean bool1 = bool;
      if (b < this.mOps.size()) {
        if (isFragmentPostponed(this.mOps.get(b)))
          return true; 
      } else {
        return bool1;
      } 
    } 
  }
  
  public FragmentTransaction remove(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 3;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment) {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString) {
    if (paramInt == 0)
      throw new IllegalArgumentException("Must use non-zero containerViewId"); 
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public FragmentTransaction setAllowOptimization(boolean paramBoolean) {
    this.mAllowOptimization = paramBoolean;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt) {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence) {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt) {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence) {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2) {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener) {
    for (byte b = 0; b < this.mOps.size(); b++) {
      Op op = this.mOps.get(b);
      if (isFragmentPostponed(op))
        op.fragment.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener); 
    } 
  }
  
  public FragmentTransaction setTransition(int paramInt) {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt) {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment) {
    Op op = new Op();
    op.cmd = 5;
    op.fragment = paramFragment;
    addOp(op);
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("BackStackEntry{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.mIndex);
    } 
    if (this.mName != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.mName);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  void trackAddedFragmentsInPop(ArrayList<Fragment> paramArrayList) {
    byte b = 0;
    while (b < this.mOps.size()) {
      Op op = this.mOps.get(b);
      switch (op.cmd) {
        default:
          b++;
          continue;
        case 1:
        case 7:
          paramArrayList.remove(op.fragment);
        case 3:
        case 6:
          break;
      } 
      paramArrayList.add(op.fragment);
    } 
  }
  
  static final class Op {
    int cmd;
    
    int enterAnim;
    
    int exitAnim;
    
    Fragment fragment;
    
    int popEnterAnim;
    
    int popExitAnim;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */