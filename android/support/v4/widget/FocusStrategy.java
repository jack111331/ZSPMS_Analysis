package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {
  private static boolean beamBeats(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3) {
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool = beamsOverlap(paramInt, paramRect1, paramRect2);
    if (beamsOverlap(paramInt, paramRect1, paramRect3) || !bool)
      return false; 
    bool = bool2;
    if (isToDirectionOf(paramInt, paramRect1, paramRect3)) {
      bool = bool2;
      if (paramInt != 17) {
        bool = bool2;
        if (paramInt != 66) {
          bool = bool2;
          if (majorAxisDistance(paramInt, paramRect1, paramRect2) >= majorAxisDistanceToFarEdge(paramInt, paramRect1, paramRect3))
            bool = bool1; 
        } 
      } 
    } 
    return bool;
  }
  
  private static boolean beamsOverlap(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    boolean bool = false;
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
      case 66:
        null = bool;
        if (paramRect2.bottom >= paramRect1.top) {
          null = bool;
          if (paramRect2.top <= paramRect1.bottom)
            return true; 
        } 
        return null;
      case 33:
      case 130:
        break;
    } 
    null = bool;
    if (paramRect2.right >= paramRect1.left) {
      if (paramRect2.left > paramRect1.right)
        return bool; 
    } else {
      return null;
    } 
    return true;
  }
  
  public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, @NonNull Rect paramRect, int paramInt) {
    // Byte code:
    //   0: new android/graphics/Rect
    //   3: dup
    //   4: aload #4
    //   6: invokespecial <init> : (Landroid/graphics/Rect;)V
    //   9: astore #6
    //   11: iload #5
    //   13: lookupswitch default -> 56, 17 -> 66, 33 -> 150, 66 -> 133, 130 -> 166
    //   56: new java/lang/IllegalArgumentException
    //   59: dup
    //   60: ldc 'direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.'
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: athrow
    //   66: aload #6
    //   68: aload #4
    //   70: invokevirtual width : ()I
    //   73: iconst_1
    //   74: iadd
    //   75: iconst_0
    //   76: invokevirtual offset : (II)V
    //   79: aload_1
    //   80: aload_0
    //   81: invokeinterface size : (Ljava/lang/Object;)I
    //   86: istore #7
    //   88: new android/graphics/Rect
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: astore #8
    //   97: aconst_null
    //   98: astore #9
    //   100: iconst_0
    //   101: istore #10
    //   103: iload #10
    //   105: iload #7
    //   107: if_icmpge -> 221
    //   110: aload_1
    //   111: aload_0
    //   112: iload #10
    //   114: invokeinterface get : (Ljava/lang/Object;I)Ljava/lang/Object;
    //   119: astore #11
    //   121: aload #11
    //   123: aload_3
    //   124: if_acmpne -> 183
    //   127: iinc #10, 1
    //   130: goto -> 103
    //   133: aload #6
    //   135: aload #4
    //   137: invokevirtual width : ()I
    //   140: iconst_1
    //   141: iadd
    //   142: ineg
    //   143: iconst_0
    //   144: invokevirtual offset : (II)V
    //   147: goto -> 79
    //   150: aload #6
    //   152: iconst_0
    //   153: aload #4
    //   155: invokevirtual height : ()I
    //   158: iconst_1
    //   159: iadd
    //   160: invokevirtual offset : (II)V
    //   163: goto -> 79
    //   166: aload #6
    //   168: iconst_0
    //   169: aload #4
    //   171: invokevirtual height : ()I
    //   174: iconst_1
    //   175: iadd
    //   176: ineg
    //   177: invokevirtual offset : (II)V
    //   180: goto -> 79
    //   183: aload_2
    //   184: aload #11
    //   186: aload #8
    //   188: invokeinterface obtainBounds : (Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   193: iload #5
    //   195: aload #4
    //   197: aload #8
    //   199: aload #6
    //   201: invokestatic isBetterCandidate : (ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)Z
    //   204: ifeq -> 127
    //   207: aload #6
    //   209: aload #8
    //   211: invokevirtual set : (Landroid/graphics/Rect;)V
    //   214: aload #11
    //   216: astore #9
    //   218: goto -> 127
    //   221: aload #9
    //   223: areturn
  }
  
  public static <L, T> T findNextFocusInRelativeDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int i = paramCollectionAdapter.size(paramL);
    ArrayList<?> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(paramCollectionAdapter.get(paramL, b)); 
    Collections.sort(arrayList, new SequentialComparator(paramBoolean1, paramBoundsAdapter));
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
      case 2:
        return (T)getNextFocusable((L)paramT, (ArrayList)arrayList, paramBoolean2);
      case 1:
        break;
    } 
    return (T)getPreviousFocusable((L)paramT, (ArrayList)arrayList, paramBoolean2);
  }
  
  private static <T> T getNextFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int j;
    int i = paramArrayList.size();
    if (paramT == null) {
      j = -1;
    } else {
      j = paramArrayList.lastIndexOf(paramT);
    } 
    return (++j < i) ? paramArrayList.get(j) : ((paramBoolean && i > 0) ? paramArrayList.get(0) : null);
  }
  
  private static <T> T getPreviousFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int j;
    int i = paramArrayList.size();
    if (paramT == null) {
      j = i;
    } else {
      j = paramArrayList.indexOf(paramT);
    } 
    return (--j >= 0) ? paramArrayList.get(j) : ((paramBoolean && i > 0) ? paramArrayList.get(i - 1) : null);
  }
  
  private static int getWeightedDistanceFor(int paramInt1, int paramInt2) {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static boolean isBetterCandidate(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3) {
    boolean bool = false;
    if (!isCandidate(paramRect1, paramRect2, paramInt))
      return bool; 
    if (isCandidate(paramRect1, paramRect3, paramInt) && !beamBeats(paramInt, paramRect1, paramRect2, paramRect3)) {
      boolean bool1 = bool;
      if (!beamBeats(paramInt, paramRect1, paramRect3, paramRect2)) {
        bool1 = bool;
        if (getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect2), minorAxisDistance(paramInt, paramRect1, paramRect2)) < getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect3), minorAxisDistance(paramInt, paramRect1, paramRect3)))
          return true; 
      } 
      return bool1;
    } 
    return true;
  }
  
  private static boolean isCandidate(@NonNull Rect paramRect1, @NonNull Rect paramRect2, int paramInt) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_2
    //   3: lookupswitch default -> 44, 17 -> 54, 33 -> 141, 66 -> 99, 130 -> 183
    //   44: new java/lang/IllegalArgumentException
    //   47: dup
    //   48: ldc 'direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.'
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: athrow
    //   54: aload_0
    //   55: getfield right : I
    //   58: aload_1
    //   59: getfield right : I
    //   62: if_icmpgt -> 79
    //   65: iload_3
    //   66: istore #4
    //   68: aload_0
    //   69: getfield left : I
    //   72: aload_1
    //   73: getfield right : I
    //   76: if_icmplt -> 96
    //   79: iload_3
    //   80: istore #4
    //   82: aload_0
    //   83: getfield left : I
    //   86: aload_1
    //   87: getfield left : I
    //   90: if_icmple -> 96
    //   93: iconst_1
    //   94: istore #4
    //   96: iload #4
    //   98: ireturn
    //   99: aload_0
    //   100: getfield left : I
    //   103: aload_1
    //   104: getfield left : I
    //   107: if_icmplt -> 124
    //   110: iload_3
    //   111: istore #4
    //   113: aload_0
    //   114: getfield right : I
    //   117: aload_1
    //   118: getfield left : I
    //   121: if_icmpgt -> 96
    //   124: aload_0
    //   125: getfield right : I
    //   128: aload_1
    //   129: getfield right : I
    //   132: if_icmplt -> 93
    //   135: iload_3
    //   136: istore #4
    //   138: goto -> 96
    //   141: aload_0
    //   142: getfield bottom : I
    //   145: aload_1
    //   146: getfield bottom : I
    //   149: if_icmpgt -> 166
    //   152: iload_3
    //   153: istore #4
    //   155: aload_0
    //   156: getfield top : I
    //   159: aload_1
    //   160: getfield bottom : I
    //   163: if_icmplt -> 96
    //   166: aload_0
    //   167: getfield top : I
    //   170: aload_1
    //   171: getfield top : I
    //   174: if_icmpgt -> 93
    //   177: iload_3
    //   178: istore #4
    //   180: goto -> 96
    //   183: aload_0
    //   184: getfield top : I
    //   187: aload_1
    //   188: getfield top : I
    //   191: if_icmplt -> 208
    //   194: iload_3
    //   195: istore #4
    //   197: aload_0
    //   198: getfield bottom : I
    //   201: aload_1
    //   202: getfield top : I
    //   205: if_icmpgt -> 96
    //   208: aload_0
    //   209: getfield bottom : I
    //   212: aload_1
    //   213: getfield bottom : I
    //   216: if_icmplt -> 93
    //   219: iload_3
    //   220: istore #4
    //   222: goto -> 96
  }
  
  private static boolean isToDirectionOf(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    null = false;
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return (paramRect1.left >= paramRect2.right) ? true : null;
      case 66:
        return (paramRect1.right > paramRect2.left) ? null : true;
      case 33:
        return (paramRect1.top < paramRect2.bottom) ? SYNTHETIC_LOCAL_VARIABLE_3 : true;
      case 130:
        break;
    } 
    return (paramRect1.bottom > paramRect2.top) ? SYNTHETIC_LOCAL_VARIABLE_3 : true;
  }
  
  private static int majorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    return Math.max(0, majorAxisDistanceRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return paramRect1.left - paramRect2.right;
      case 66:
        return paramRect2.left - paramRect1.right;
      case 33:
        return paramRect1.top - paramRect2.bottom;
      case 130:
        break;
    } 
    return paramRect2.top - paramRect1.bottom;
  }
  
  private static int majorAxisDistanceToFarEdge(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    return Math.max(1, majorAxisDistanceToFarEdgeRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceToFarEdgeRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
        return paramRect1.left - paramRect2.left;
      case 66:
        return paramRect2.right - paramRect1.right;
      case 33:
        return paramRect1.top - paramRect2.top;
      case 130:
        break;
    } 
    return paramRect2.bottom - paramRect1.bottom;
  }
  
  private static int minorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2) {
    switch (paramInt) {
      default:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      case 17:
      case 66:
        return Math.abs(paramRect1.top + paramRect1.height() / 2 - paramRect2.top + paramRect2.height() / 2);
      case 33:
      case 130:
        break;
    } 
    return Math.abs(paramRect1.left + paramRect1.width() / 2 - paramRect2.left + paramRect2.width() / 2);
  }
  
  public static interface BoundsAdapter<T> {
    void obtainBounds(T param1T, Rect param1Rect);
  }
  
  public static interface CollectionAdapter<T, V> {
    V get(T param1T, int param1Int);
    
    int size(T param1T);
  }
  
  private static class SequentialComparator<T> implements Comparator<T> {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    
    private final boolean mIsLayoutRtl;
    
    private final Rect mTemp1 = new Rect();
    
    private final Rect mTemp2 = new Rect();
    
    SequentialComparator(boolean param1Boolean, FocusStrategy.BoundsAdapter<T> param1BoundsAdapter) {
      this.mIsLayoutRtl = param1Boolean;
      this.mAdapter = param1BoundsAdapter;
    }
    
    public int compare(T param1T1, T param1T2) {
      byte b1 = -1;
      byte b2 = 1;
      Rect rect1 = this.mTemp1;
      Rect rect2 = this.mTemp2;
      this.mAdapter.obtainBounds(param1T1, rect1);
      this.mAdapter.obtainBounds(param1T2, rect2);
      if (rect1.top >= rect2.top) {
        byte b = b2;
        if (rect1.top <= rect2.top) {
          if (rect1.left < rect2.left) {
            b = b1;
            if (this.mIsLayoutRtl)
              b = 1; 
            return b;
          } 
          if (rect1.left > rect2.left) {
            if (!this.mIsLayoutRtl)
              return b2; 
          } else if (rect1.bottom >= rect2.bottom) {
            b = b2;
            if (rect1.bottom <= rect2.bottom) {
              if (rect1.right < rect2.right) {
                b = b1;
                if (this.mIsLayoutRtl)
                  b = 1; 
                return b;
              } 
              if (rect1.right > rect2.right) {
                if (!this.mIsLayoutRtl)
                  return b2; 
              } else {
                return 0;
              } 
            } else {
              return b;
            } 
          } 
        } else {
          return b;
        } 
      } 
      return -1;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\widget\FocusStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */