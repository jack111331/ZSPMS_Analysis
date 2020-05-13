package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class HighLevelEncoder {
  private static final int[][] CHAR_MAP;
  
  static final int[][] LATCH_TABLE;
  
  static final int MODE_DIGIT = 2;
  
  static final int MODE_LOWER = 1;
  
  static final int MODE_MIXED = 3;
  
  static final String[] MODE_NAMES = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
  
  static final int MODE_PUNCT = 4;
  
  static final int MODE_UPPER = 0;
  
  static final int[][] SHIFT_TABLE;
  
  private final byte[] text;
  
  static {
    int[] arrayOfInt4 = { 262158, 590300, 0, 590301, 932798 };
    int[] arrayOfInt5 = { 327711, 656380, 656382, 656381, 0 };
    LATCH_TABLE = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, arrayOfInt4, { 327709, 327708, 656318, 0, 327710 }, arrayOfInt5 };
    int[][] arrayOfInt3 = new int[5][256];
    CHAR_MAP = arrayOfInt3;
    arrayOfInt3[0][32] = 1;
    byte b;
    for (b = 65; b <= 90; b++)
      CHAR_MAP[0][b] = b - 65 + 2; 
    CHAR_MAP[1][32] = 1;
    for (b = 97; b <= 122; b++)
      CHAR_MAP[1][b] = b - 97 + 2; 
    CHAR_MAP[2][32] = 1;
    for (b = 48; b <= 57; b++)
      CHAR_MAP[2][b] = b - 48 + 2; 
    CHAR_MAP[2][44] = 12;
    CHAR_MAP[2][46] = 13;
    for (b = 0; b < 28; b++) {
      (new int[28])[0] = 0;
      (new int[28])[1] = 32;
      (new int[28])[2] = 1;
      (new int[28])[3] = 2;
      (new int[28])[4] = 3;
      (new int[28])[5] = 4;
      (new int[28])[6] = 5;
      (new int[28])[7] = 6;
      (new int[28])[8] = 7;
      (new int[28])[9] = 8;
      (new int[28])[10] = 9;
      (new int[28])[11] = 10;
      (new int[28])[12] = 11;
      (new int[28])[13] = 12;
      (new int[28])[14] = 13;
      (new int[28])[15] = 27;
      (new int[28])[16] = 28;
      (new int[28])[17] = 29;
      (new int[28])[18] = 30;
      (new int[28])[19] = 31;
      (new int[28])[20] = 64;
      (new int[28])[21] = 92;
      (new int[28])[22] = 94;
      (new int[28])[23] = 95;
      (new int[28])[24] = 96;
      (new int[28])[25] = 124;
      (new int[28])[26] = 126;
      (new int[28])[27] = 127;
      CHAR_MAP[3][(new int[28])[b]] = b;
    } 
    int[] arrayOfInt2 = new int[31];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 13;
    arrayOfInt2[2] = 0;
    arrayOfInt2[3] = 0;
    arrayOfInt2[4] = 0;
    arrayOfInt2[5] = 0;
    arrayOfInt2[6] = 33;
    arrayOfInt2[7] = 39;
    arrayOfInt2[8] = 35;
    arrayOfInt2[9] = 36;
    arrayOfInt2[10] = 37;
    arrayOfInt2[11] = 38;
    arrayOfInt2[12] = 39;
    arrayOfInt2[13] = 40;
    arrayOfInt2[14] = 41;
    arrayOfInt2[15] = 42;
    arrayOfInt2[16] = 43;
    arrayOfInt2[17] = 44;
    arrayOfInt2[18] = 45;
    arrayOfInt2[19] = 46;
    arrayOfInt2[20] = 47;
    arrayOfInt2[21] = 58;
    arrayOfInt2[22] = 59;
    arrayOfInt2[23] = 60;
    arrayOfInt2[24] = 61;
    arrayOfInt2[25] = 62;
    arrayOfInt2[26] = 63;
    arrayOfInt2[27] = 91;
    arrayOfInt2[28] = 93;
    arrayOfInt2[29] = 123;
    arrayOfInt2[30] = 125;
    for (b = 0; b < 31; b++) {
      if (arrayOfInt2[b] > 0)
        CHAR_MAP[4][arrayOfInt2[b]] = b; 
    } 
    int[][] arrayOfInt1 = new int[6][6];
    SHIFT_TABLE = arrayOfInt1;
    int i = arrayOfInt1.length;
    for (b = 0; b < i; b++)
      Arrays.fill(arrayOfInt1[b], -1); 
    SHIFT_TABLE[0][4] = 0;
    SHIFT_TABLE[1][4] = 0;
    SHIFT_TABLE[1][0] = 28;
    SHIFT_TABLE[3][4] = 0;
    SHIFT_TABLE[2][4] = 0;
    SHIFT_TABLE[2][0] = 15;
  }
  
  public HighLevelEncoder(byte[] paramArrayOfbyte) {
    this.text = paramArrayOfbyte;
  }
  
  private static Collection<State> simplifyStates(Iterable<State> paramIterable) {
    LinkedList<State> linkedList = new LinkedList();
    for (State state : paramIterable) {
      boolean bool2;
      boolean bool1 = true;
      Iterator<State> iterator = linkedList.iterator();
      while (true) {
        bool2 = bool1;
        if (iterator.hasNext()) {
          State state1 = iterator.next();
          if (state1.isBetterThanOrEqualTo(state)) {
            bool2 = false;
            break;
          } 
          if (state.isBetterThanOrEqualTo(state1))
            iterator.remove(); 
          continue;
        } 
        break;
      } 
      if (bool2)
        linkedList.add(state); 
    } 
    return linkedList;
  }
  
  private void updateStateForChar(State paramState, int paramInt, Collection<State> paramCollection) {
    char c = (char)(this.text[paramInt] & 0xFF);
    int i = CHAR_MAP[paramState.getMode()][c];
    byte b = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    for (State state = null; b <= 4; state = state1) {
      int j = CHAR_MAP[b][c];
      State state1 = state;
      if (j > 0) {
        State state2 = state;
        if (state == null)
          state2 = paramState.endBinaryShift(paramInt); 
        if (i == 0 || b == paramState.getMode() || b == 2)
          paramCollection.add(state2.latchAndAppend(b, j)); 
        state1 = state2;
        if (i == 0) {
          state1 = state2;
          if (SHIFT_TABLE[paramState.getMode()][b] >= 0) {
            paramCollection.add(state2.shiftAndAppend(b, j));
            state1 = state2;
          } 
        } 
      } 
      b++;
    } 
    if (paramState.getBinaryShiftByteCount() > 0 || CHAR_MAP[paramState.getMode()][c] == 0)
      paramCollection.add(paramState.addBinaryShiftChar(paramInt)); 
  }
  
  private static void updateStateForPair(State paramState, int paramInt1, int paramInt2, Collection<State> paramCollection) {
    State state = paramState.endBinaryShift(paramInt1);
    paramCollection.add(state.latchAndAppend(4, paramInt2));
    if (paramState.getMode() != 4)
      paramCollection.add(state.shiftAndAppend(4, paramInt2)); 
    if (paramInt2 == 3 || paramInt2 == 4)
      paramCollection.add(state.latchAndAppend(2, 16 - paramInt2).latchAndAppend(2, 1)); 
    if (paramState.getBinaryShiftByteCount() > 0)
      paramCollection.add(paramState.addBinaryShiftChar(paramInt1).addBinaryShiftChar(paramInt1 + 1)); 
  }
  
  private Collection<State> updateStateListForChar(Iterable<State> paramIterable, int paramInt) {
    LinkedList<State> linkedList = new LinkedList();
    Iterator<State> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      updateStateForChar(iterator.next(), paramInt, linkedList); 
    return simplifyStates(linkedList);
  }
  
  private static Collection<State> updateStateListForPair(Iterable<State> paramIterable, int paramInt1, int paramInt2) {
    LinkedList<State> linkedList = new LinkedList();
    Iterator<State> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      updateStateForPair(iterator.next(), paramInt1, paramInt2, linkedList); 
    return simplifyStates(linkedList);
  }
  
  public BitArray encode() {
    // Byte code:
    //   0: getstatic com/google/zxing/aztec/encoder/State.INITIAL_STATE : Lcom/google/zxing/aztec/encoder/State;
    //   3: invokestatic singletonList : (Ljava/lang/Object;)Ljava/util/List;
    //   6: astore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield text : [B
    //   14: arraylength
    //   15: if_icmpge -> 167
    //   18: iload_2
    //   19: iconst_1
    //   20: iadd
    //   21: istore_3
    //   22: iload_3
    //   23: aload_0
    //   24: getfield text : [B
    //   27: arraylength
    //   28: if_icmpge -> 42
    //   31: aload_0
    //   32: getfield text : [B
    //   35: iload_3
    //   36: baload
    //   37: istore #4
    //   39: goto -> 45
    //   42: iconst_0
    //   43: istore #4
    //   45: aload_0
    //   46: getfield text : [B
    //   49: iload_2
    //   50: baload
    //   51: istore #5
    //   53: iload #5
    //   55: bipush #13
    //   57: if_icmpeq -> 126
    //   60: iload #5
    //   62: bipush #44
    //   64: if_icmpeq -> 113
    //   67: iload #5
    //   69: bipush #46
    //   71: if_icmpeq -> 100
    //   74: iload #5
    //   76: bipush #58
    //   78: if_icmpeq -> 87
    //   81: iconst_0
    //   82: istore #4
    //   84: goto -> 136
    //   87: iload #4
    //   89: bipush #32
    //   91: if_icmpne -> 81
    //   94: iconst_5
    //   95: istore #4
    //   97: goto -> 136
    //   100: iload #4
    //   102: bipush #32
    //   104: if_icmpne -> 81
    //   107: iconst_3
    //   108: istore #4
    //   110: goto -> 136
    //   113: iload #4
    //   115: bipush #32
    //   117: if_icmpne -> 81
    //   120: iconst_4
    //   121: istore #4
    //   123: goto -> 136
    //   126: iload #4
    //   128: bipush #10
    //   130: if_icmpne -> 81
    //   133: iconst_2
    //   134: istore #4
    //   136: iload #4
    //   138: ifle -> 154
    //   141: aload_1
    //   142: iload_2
    //   143: iload #4
    //   145: invokestatic updateStateListForPair : (Ljava/lang/Iterable;II)Ljava/util/Collection;
    //   148: astore_1
    //   149: iload_3
    //   150: istore_2
    //   151: goto -> 161
    //   154: aload_0
    //   155: aload_1
    //   156: iload_2
    //   157: invokespecial updateStateListForChar : (Ljava/lang/Iterable;I)Ljava/util/Collection;
    //   160: astore_1
    //   161: iinc #2, 1
    //   164: goto -> 9
    //   167: aload_1
    //   168: new com/google/zxing/aztec/encoder/HighLevelEncoder$1
    //   171: dup
    //   172: aload_0
    //   173: invokespecial <init> : (Lcom/google/zxing/aztec/encoder/HighLevelEncoder;)V
    //   176: invokestatic min : (Ljava/util/Collection;Ljava/util/Comparator;)Ljava/lang/Object;
    //   179: checkcast com/google/zxing/aztec/encoder/State
    //   182: aload_0
    //   183: getfield text : [B
    //   186: invokevirtual toBitArray : ([B)Lcom/google/zxing/common/BitArray;
    //   189: areturn
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\encoder\HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */