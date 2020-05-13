package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode {
  public static final int NUM_MASK_PATTERNS = 8;
  
  private ErrorCorrectionLevel ecLevel;
  
  private int maskPattern = -1;
  
  private ByteMatrix matrix;
  
  private Mode mode;
  
  private Version version;
  
  public static boolean isValidMaskPattern(int paramInt) {
    return (paramInt >= 0 && paramInt < 8);
  }
  
  public ErrorCorrectionLevel getECLevel() {
    return this.ecLevel;
  }
  
  public int getMaskPattern() {
    return this.maskPattern;
  }
  
  public ByteMatrix getMatrix() {
    return this.matrix;
  }
  
  public Mode getMode() {
    return this.mode;
  }
  
  public Version getVersion() {
    return this.version;
  }
  
  public void setECLevel(ErrorCorrectionLevel paramErrorCorrectionLevel) {
    this.ecLevel = paramErrorCorrectionLevel;
  }
  
  public void setMaskPattern(int paramInt) {
    this.maskPattern = paramInt;
  }
  
  public void setMatrix(ByteMatrix paramByteMatrix) {
    this.matrix = paramByteMatrix;
  }
  
  public void setMode(Mode paramMode) {
    this.mode = paramMode;
  }
  
  public void setVersion(Version paramVersion) {
    this.version = paramVersion;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(200);
    stringBuilder.append("<<\n");
    stringBuilder.append(" mode: ");
    stringBuilder.append(this.mode);
    stringBuilder.append("\n ecLevel: ");
    stringBuilder.append(this.ecLevel);
    stringBuilder.append("\n version: ");
    stringBuilder.append(this.version);
    stringBuilder.append("\n maskPattern: ");
    stringBuilder.append(this.maskPattern);
    if (this.matrix == null) {
      stringBuilder.append("\n matrix: null\n");
    } else {
      stringBuilder.append("\n matrix:\n");
      stringBuilder.append(this.matrix);
    } 
    stringBuilder.append(">>\n");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\QRCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */