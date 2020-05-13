package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

final class State {
  static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
  
  private final int binaryShiftByteCount;
  
  private final int bitCount;
  
  private final int mode;
  
  private final Token token;
  
  private State(Token paramToken, int paramInt1, int paramInt2, int paramInt3) {
    this.token = paramToken;
    this.mode = paramInt1;
    this.binaryShiftByteCount = paramInt2;
    this.bitCount = paramInt3;
  }
  
  State addBinaryShiftChar(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield token : Lcom/google/zxing/aztec/encoder/Token;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield mode : I
    //   9: istore_3
    //   10: aload_0
    //   11: getfield bitCount : I
    //   14: istore #4
    //   16: aload_0
    //   17: getfield mode : I
    //   20: iconst_4
    //   21: if_icmpeq -> 42
    //   24: aload_2
    //   25: astore #5
    //   27: iload_3
    //   28: istore #6
    //   30: iload #4
    //   32: istore #7
    //   34: aload_0
    //   35: getfield mode : I
    //   38: iconst_2
    //   39: if_icmpne -> 81
    //   42: getstatic com/google/zxing/aztec/encoder/HighLevelEncoder.LATCH_TABLE : [[I
    //   45: iload_3
    //   46: aaload
    //   47: iconst_0
    //   48: iaload
    //   49: istore #6
    //   51: iload #6
    //   53: bipush #16
    //   55: ishr
    //   56: istore #7
    //   58: aload_2
    //   59: ldc 65535
    //   61: iload #6
    //   63: iand
    //   64: iload #7
    //   66: invokevirtual add : (II)Lcom/google/zxing/aztec/encoder/Token;
    //   69: astore #5
    //   71: iload #4
    //   73: iload #7
    //   75: iadd
    //   76: istore #7
    //   78: iconst_0
    //   79: istore #6
    //   81: aload_0
    //   82: getfield binaryShiftByteCount : I
    //   85: ifeq -> 123
    //   88: aload_0
    //   89: getfield binaryShiftByteCount : I
    //   92: bipush #31
    //   94: if_icmpne -> 100
    //   97: goto -> 123
    //   100: aload_0
    //   101: getfield binaryShiftByteCount : I
    //   104: bipush #62
    //   106: if_icmpne -> 116
    //   109: bipush #9
    //   111: istore #4
    //   113: goto -> 127
    //   116: bipush #8
    //   118: istore #4
    //   120: goto -> 127
    //   123: bipush #18
    //   125: istore #4
    //   127: new com/google/zxing/aztec/encoder/State
    //   130: dup
    //   131: aload #5
    //   133: iload #6
    //   135: aload_0
    //   136: getfield binaryShiftByteCount : I
    //   139: iconst_1
    //   140: iadd
    //   141: iload #7
    //   143: iload #4
    //   145: iadd
    //   146: invokespecial <init> : (Lcom/google/zxing/aztec/encoder/Token;III)V
    //   149: astore_2
    //   150: aload_2
    //   151: astore #5
    //   153: aload_2
    //   154: getfield binaryShiftByteCount : I
    //   157: sipush #2078
    //   160: if_icmpne -> 172
    //   163: aload_2
    //   164: iload_1
    //   165: iconst_1
    //   166: iadd
    //   167: invokevirtual endBinaryShift : (I)Lcom/google/zxing/aztec/encoder/State;
    //   170: astore #5
    //   172: aload #5
    //   174: areturn
  }
  
  State endBinaryShift(int paramInt) {
    return (this.binaryShiftByteCount == 0) ? this : new State(this.token.addBinaryShift(paramInt - this.binaryShiftByteCount, this.binaryShiftByteCount), this.mode, 0, this.bitCount);
  }
  
  int getBinaryShiftByteCount() {
    return this.binaryShiftByteCount;
  }
  
  int getBitCount() {
    return this.bitCount;
  }
  
  int getMode() {
    return this.mode;
  }
  
  Token getToken() {
    return this.token;
  }
  
  boolean isBetterThanOrEqualTo(State paramState) {
    // Byte code:
    //   0: aload_0
    //   1: getfield bitCount : I
    //   4: getstatic com/google/zxing/aztec/encoder/HighLevelEncoder.LATCH_TABLE : [[I
    //   7: aload_0
    //   8: getfield mode : I
    //   11: aaload
    //   12: aload_1
    //   13: getfield mode : I
    //   16: iaload
    //   17: bipush #16
    //   19: ishr
    //   20: iadd
    //   21: istore_2
    //   22: iload_2
    //   23: istore_3
    //   24: aload_1
    //   25: getfield binaryShiftByteCount : I
    //   28: ifle -> 56
    //   31: aload_0
    //   32: getfield binaryShiftByteCount : I
    //   35: ifeq -> 51
    //   38: iload_2
    //   39: istore_3
    //   40: aload_0
    //   41: getfield binaryShiftByteCount : I
    //   44: aload_1
    //   45: getfield binaryShiftByteCount : I
    //   48: if_icmple -> 56
    //   51: iload_2
    //   52: bipush #10
    //   54: iadd
    //   55: istore_3
    //   56: iload_3
    //   57: aload_1
    //   58: getfield bitCount : I
    //   61: if_icmpgt -> 66
    //   64: iconst_1
    //   65: ireturn
    //   66: iconst_0
    //   67: ireturn
  }
  
  State latchAndAppend(int paramInt1, int paramInt2) {
    int i = this.bitCount;
    Token token1 = this.token;
    int j = i;
    Token token2 = token1;
    if (paramInt1 != this.mode) {
      j = HighLevelEncoder.LATCH_TABLE[this.mode][paramInt1];
      int k = j >> 16;
      token2 = token1.add(0xFFFF & j, k);
      j = i + k;
    } 
    if (paramInt1 == 2) {
      i = 4;
    } else {
      i = 5;
    } 
    return new State(token2.add(paramInt2, i), paramInt1, 0, j + i);
  }
  
  State shiftAndAppend(int paramInt1, int paramInt2) {
    byte b;
    Token token = this.token;
    if (this.mode == 2) {
      b = 4;
    } else {
      b = 5;
    } 
    return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][paramInt1], b).add(paramInt2, 5), this.mode, 0, this.bitCount + b + 5);
  }
  
  BitArray toBitArray(byte[] paramArrayOfbyte) {
    LinkedList<Token> linkedList = new LinkedList();
    for (Token token = (endBinaryShift(paramArrayOfbyte.length)).token; token != null; token = token.getPrevious())
      linkedList.addFirst(token); 
    BitArray bitArray = new BitArray();
    Iterator<Token> iterator = linkedList.iterator();
    while (iterator.hasNext())
      ((Token)iterator.next()).appendTo(bitArray, paramArrayOfbyte); 
    return bitArray;
  }
  
  public String toString() {
    return String.format("%s bits=%d bytes=%d", new Object[] { HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount) });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\encoder\State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */