package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class GeneralAppIdDecoder {
  private final StringBuilder buffer = new StringBuilder();
  
  private final CurrentParsingState current = new CurrentParsingState();
  
  private final BitArray information;
  
  GeneralAppIdDecoder(BitArray paramBitArray) {
    this.information = paramBitArray;
  }
  
  private DecodedChar decodeAlphanumeric(int paramInt) {
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i == 15)
      return new DecodedChar(paramInt + 5, '$'); 
    if (i >= 5 && i < 15)
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5)); 
    i = extractNumericValueFromBitArray(paramInt, 6);
    if (i >= 32 && i < 58)
      return new DecodedChar(paramInt + 6, (char)(i + 33)); 
    switch (i) {
      default:
        throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(i)));
      case 62:
        i = 47;
        j = i;
        return new DecodedChar(paramInt + 6, j);
      case 61:
        i = 46;
        j = i;
        return new DecodedChar(paramInt + 6, j);
      case 60:
        i = 45;
        j = i;
        return new DecodedChar(paramInt + 6, j);
      case 59:
        i = 44;
        j = i;
        return new DecodedChar(paramInt + 6, j);
      case 58:
        break;
    } 
    i = 42;
    int j = i;
    return new DecodedChar(paramInt + 6, j);
  }
  
  private DecodedChar decodeIsoIec646(int paramInt) throws FormatException {
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i == 15)
      return new DecodedChar(paramInt + 5, '$'); 
    if (i >= 5 && i < 15)
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5)); 
    i = extractNumericValueFromBitArray(paramInt, 7);
    if (i >= 64 && i < 90)
      return new DecodedChar(paramInt + 7, (char)(i + 1)); 
    if (i >= 90 && i < 116)
      return new DecodedChar(paramInt + 7, (char)(i + 7)); 
    switch (extractNumericValueFromBitArray(paramInt, 8)) {
      default:
        throw FormatException.getFormatInstance();
      case 252:
        i = 32;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 251:
        i = 95;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 250:
        i = 63;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 249:
        i = 62;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 248:
        i = 61;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 247:
        i = 60;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 246:
        i = 59;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 245:
        i = 58;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 244:
        i = 47;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 243:
        i = 46;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 242:
        i = 45;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 241:
        i = 44;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 240:
        i = 43;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 239:
        i = 42;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 238:
        i = 41;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 237:
        i = 40;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 236:
        i = 39;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 235:
        i = 38;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 234:
        i = 37;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 233:
        i = 34;
        j = i;
        return new DecodedChar(paramInt + 8, j);
      case 232:
        break;
    } 
    i = 33;
    int j = i;
    return new DecodedChar(paramInt + 8, j);
  }
  
  private DecodedNumeric decodeNumeric(int paramInt) throws FormatException {
    int i = paramInt + 7;
    if (i > this.information.getSize()) {
      paramInt = extractNumericValueFromBitArray(paramInt, 4);
      return (paramInt == 0) ? new DecodedNumeric(this.information.getSize(), 10, 10) : new DecodedNumeric(this.information.getSize(), paramInt - 1, 10);
    } 
    paramInt = extractNumericValueFromBitArray(paramInt, 7) - 8;
    return new DecodedNumeric(i, paramInt / 11, paramInt % 11);
  }
  
  static int extractNumericValueFromBitArray(BitArray paramBitArray, int paramInt1, int paramInt2) {
    byte b = 0;
    int i;
    for (i = 0; b < paramInt2; i = j) {
      int j = i;
      if (paramBitArray.get(paramInt1 + b))
        j = i | 1 << paramInt2 - b - 1; 
      b++;
    } 
    return i;
  }
  
  private boolean isAlphaOr646ToNumericLatch(int paramInt) {
    int i = paramInt + 3;
    if (i > this.information.getSize())
      return false; 
    while (paramInt < i) {
      if (this.information.get(paramInt))
        return false; 
      paramInt++;
    } 
    return true;
  }
  
  private boolean isAlphaTo646ToAlphaLatch(int paramInt) {
    if (paramInt + 1 > this.information.getSize())
      return false; 
    byte b = 0;
    while (b < 5) {
      int i = b + paramInt;
      if (i < this.information.getSize()) {
        if (b == 2) {
          if (!this.information.get(paramInt + 2))
            return false; 
        } else if (this.information.get(i)) {
          return false;
        } 
        b++;
      } 
    } 
    return true;
  }
  
  private boolean isNumericToAlphaNumericLatch(int paramInt) {
    if (paramInt + 1 > this.information.getSize())
      return false; 
    byte b = 0;
    while (b < 4) {
      int i = b + paramInt;
      if (i < this.information.getSize()) {
        if (this.information.get(i))
          return false; 
        b++;
      } 
    } 
    return true;
  }
  
  private boolean isStillAlpha(int paramInt) {
    if (paramInt + 5 > this.information.getSize())
      return false; 
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i >= 5 && i < 16)
      return true; 
    if (paramInt + 6 > this.information.getSize())
      return false; 
    paramInt = extractNumericValueFromBitArray(paramInt, 6);
    return (paramInt >= 16 && paramInt < 63);
  }
  
  private boolean isStillIsoIec646(int paramInt) {
    if (paramInt + 5 > this.information.getSize())
      return false; 
    int i = extractNumericValueFromBitArray(paramInt, 5);
    if (i >= 5 && i < 16)
      return true; 
    if (paramInt + 7 > this.information.getSize())
      return false; 
    i = extractNumericValueFromBitArray(paramInt, 7);
    if (i >= 64 && i < 116)
      return true; 
    if (paramInt + 8 > this.information.getSize())
      return false; 
    paramInt = extractNumericValueFromBitArray(paramInt, 8);
    return (paramInt >= 232 && paramInt < 253);
  }
  
  private boolean isStillNumeric(int paramInt) {
    if (paramInt + 7 > this.information.getSize())
      return (paramInt + 4 <= this.information.getSize()); 
    int i = paramInt;
    while (true) {
      int j = paramInt + 3;
      if (i < j) {
        if (this.information.get(i))
          return true; 
        i++;
        continue;
      } 
      return this.information.get(j);
    } 
  }
  
  private BlockParsedResult parseAlphaBlock() {
    while (isStillAlpha(this.current.getPosition())) {
      DecodedChar decodedChar = decodeAlphanumeric(this.current.getPosition());
      this.current.setPosition(decodedChar.getNewPosition());
      if (decodedChar.isFNC1())
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true); 
      this.buffer.append(decodedChar.getValue());
    } 
    if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
      this.current.incrementPosition(3);
      this.current.setNumeric();
    } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
      if (this.current.getPosition() + 5 < this.information.getSize()) {
        this.current.incrementPosition(5);
      } else {
        this.current.setPosition(this.information.getSize());
      } 
      this.current.setIsoIec646();
    } 
    return new BlockParsedResult(false);
  }
  
  private DecodedInformation parseBlocks() throws FormatException {
    int i;
    BlockParsedResult blockParsedResult;
    boolean bool;
    do {
      i = this.current.getPosition();
      if (this.current.isAlpha()) {
        blockParsedResult = parseAlphaBlock();
        bool = blockParsedResult.isFinished();
      } else if (this.current.isIsoIec646()) {
        blockParsedResult = parseIsoIec646Block();
        bool = blockParsedResult.isFinished();
      } else {
        blockParsedResult = parseNumericBlock();
        bool = blockParsedResult.isFinished();
      } 
      if (i != this.current.getPosition()) {
        i = 1;
      } else {
        i = 0;
      } 
    } while ((i != 0 || bool) && !bool);
    return blockParsedResult.getDecodedInformation();
  }
  
  private BlockParsedResult parseIsoIec646Block() throws FormatException {
    while (isStillIsoIec646(this.current.getPosition())) {
      DecodedChar decodedChar = decodeIsoIec646(this.current.getPosition());
      this.current.setPosition(decodedChar.getNewPosition());
      if (decodedChar.isFNC1())
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true); 
      this.buffer.append(decodedChar.getValue());
    } 
    if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
      this.current.incrementPosition(3);
      this.current.setNumeric();
    } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
      if (this.current.getPosition() + 5 < this.information.getSize()) {
        this.current.incrementPosition(5);
      } else {
        this.current.setPosition(this.information.getSize());
      } 
      this.current.setAlpha();
    } 
    return new BlockParsedResult(false);
  }
  
  private BlockParsedResult parseNumericBlock() throws FormatException {
    while (isStillNumeric(this.current.getPosition())) {
      DecodedInformation decodedInformation;
      DecodedNumeric decodedNumeric = decodeNumeric(this.current.getPosition());
      this.current.setPosition(decodedNumeric.getNewPosition());
      if (decodedNumeric.isFirstDigitFNC1()) {
        if (decodedNumeric.isSecondDigitFNC1()) {
          decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        } else {
          decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodedInformation.getSecondDigit());
        } 
        return new BlockParsedResult(decodedInformation, true);
      } 
      this.buffer.append(decodedInformation.getFirstDigit());
      if (decodedInformation.isSecondDigitFNC1())
        return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true); 
      this.buffer.append(decodedInformation.getSecondDigit());
    } 
    if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
      this.current.setAlpha();
      this.current.incrementPosition(4);
    } 
    return new BlockParsedResult(false);
  }
  
  String decodeAllCodes(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException, FormatException {
    String str = null;
    while (true) {
      DecodedInformation decodedInformation = decodeGeneralPurposeField(paramInt, str);
      str = FieldParser.parseFieldsInGeneralPurpose(decodedInformation.getNewString());
      if (str != null)
        paramStringBuilder.append(str); 
      if (decodedInformation.isRemaining()) {
        str = String.valueOf(decodedInformation.getRemainingValue());
      } else {
        str = null;
      } 
      if (paramInt != decodedInformation.getNewPosition()) {
        paramInt = decodedInformation.getNewPosition();
        continue;
      } 
      return paramStringBuilder.toString();
    } 
  }
  
  DecodedInformation decodeGeneralPurposeField(int paramInt, String paramString) throws FormatException {
    this.buffer.setLength(0);
    if (paramString != null)
      this.buffer.append(paramString); 
    this.current.setPosition(paramInt);
    DecodedInformation decodedInformation = parseBlocks();
    return (decodedInformation != null && decodedInformation.isRemaining()) ? new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodedInformation.getRemainingValue()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString());
  }
  
  int extractNumericValueFromBitArray(int paramInt1, int paramInt2) {
    return extractNumericValueFromBitArray(this.information, paramInt1, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\GeneralAppIdDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */