package okhttp3.internal.framed;

import java.util.Arrays;

public final class Settings {
  static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
  
  static final int COUNT = 10;
  
  static final int CURRENT_CWND = 5;
  
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
  
  static final int DOWNLOAD_BANDWIDTH = 2;
  
  static final int DOWNLOAD_RETRANS_RATE = 6;
  
  static final int ENABLE_PUSH = 2;
  
  static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
  
  static final int FLOW_CONTROL_OPTIONS = 10;
  
  static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
  
  static final int HEADER_TABLE_SIZE = 1;
  
  static final int INITIAL_WINDOW_SIZE = 7;
  
  static final int MAX_CONCURRENT_STREAMS = 4;
  
  static final int MAX_FRAME_SIZE = 5;
  
  static final int MAX_HEADER_LIST_SIZE = 6;
  
  static final int PERSISTED = 2;
  
  static final int PERSIST_VALUE = 1;
  
  static final int ROUND_TRIP_TIME = 3;
  
  static final int UPLOAD_BANDWIDTH = 1;
  
  private int persistValue;
  
  private int persisted;
  
  private int set;
  
  private final int[] values = new int[10];
  
  void clear() {
    this.persisted = 0;
    this.persistValue = 0;
    this.set = 0;
    Arrays.fill(this.values, 0);
  }
  
  int flags(int paramInt) {
    int i = 0;
    if (isPersisted(paramInt))
      i = 0x0 | 0x2; 
    int j = i;
    if (persistValue(paramInt))
      j = i | 0x1; 
    return j;
  }
  
  int get(int paramInt) {
    return this.values[paramInt];
  }
  
  int getClientCertificateVectorSize(int paramInt) {
    if ((this.set & 0x100) != 0)
      paramInt = this.values[8]; 
    return paramInt;
  }
  
  int getCurrentCwnd(int paramInt) {
    if ((this.set & 0x20) != 0)
      paramInt = this.values[5]; 
    return paramInt;
  }
  
  int getDownloadBandwidth(int paramInt) {
    if ((this.set & 0x4) != 0)
      paramInt = this.values[2]; 
    return paramInt;
  }
  
  int getDownloadRetransRate(int paramInt) {
    if ((this.set & 0x40) != 0)
      paramInt = this.values[6]; 
    return paramInt;
  }
  
  boolean getEnablePush(boolean paramBoolean) {
    boolean bool2;
    boolean bool1 = true;
    if ((this.set & 0x4) != 0) {
      bool2 = this.values[2];
    } else if (paramBoolean) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    return (bool2 == true) ? bool1 : false;
  }
  
  int getHeaderTableSize() {
    return ((this.set & 0x2) != 0) ? this.values[1] : -1;
  }
  
  int getInitialWindowSize(int paramInt) {
    if ((this.set & 0x80) != 0)
      paramInt = this.values[7]; 
    return paramInt;
  }
  
  int getMaxConcurrentStreams(int paramInt) {
    if ((this.set & 0x10) != 0)
      paramInt = this.values[4]; 
    return paramInt;
  }
  
  int getMaxFrameSize(int paramInt) {
    if ((this.set & 0x20) != 0)
      paramInt = this.values[5]; 
    return paramInt;
  }
  
  int getMaxHeaderListSize(int paramInt) {
    if ((this.set & 0x40) != 0)
      paramInt = this.values[6]; 
    return paramInt;
  }
  
  int getRoundTripTime(int paramInt) {
    if ((this.set & 0x8) != 0)
      paramInt = this.values[3]; 
    return paramInt;
  }
  
  int getUploadBandwidth(int paramInt) {
    if ((this.set & 0x2) != 0)
      paramInt = this.values[1]; 
    return paramInt;
  }
  
  boolean isFlowControlDisabled() {
    boolean bool2;
    boolean bool1 = false;
    if ((this.set & 0x400) != 0) {
      bool2 = this.values[10];
    } else {
      bool2 = false;
    } 
    if ((bool2 & true) != 0)
      bool1 = true; 
    return bool1;
  }
  
  boolean isPersisted(int paramInt) {
    boolean bool = true;
    if ((this.persisted & 1 << paramInt) == 0)
      bool = false; 
    return bool;
  }
  
  boolean isSet(int paramInt) {
    boolean bool = true;
    if ((this.set & 1 << paramInt) == 0)
      bool = false; 
    return bool;
  }
  
  void merge(Settings paramSettings) {
    for (byte b = 0; b < 10; b++) {
      if (paramSettings.isSet(b))
        set(b, paramSettings.flags(b), paramSettings.get(b)); 
    } 
  }
  
  boolean persistValue(int paramInt) {
    boolean bool = true;
    if ((this.persistValue & 1 << paramInt) == 0)
      bool = false; 
    return bool;
  }
  
  Settings set(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 < this.values.length) {
      int i = 1 << paramInt1;
      this.set |= i;
      if ((paramInt2 & 0x1) != 0) {
        this.persistValue |= i;
      } else {
        this.persistValue &= i ^ 0xFFFFFFFF;
      } 
      if ((paramInt2 & 0x2) != 0) {
        this.persisted |= i;
      } else {
        this.persisted &= i ^ 0xFFFFFFFF;
      } 
      this.values[paramInt1] = paramInt3;
    } 
    return this;
  }
  
  int size() {
    return Integer.bitCount(this.set);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */