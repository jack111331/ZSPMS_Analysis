package com.hu.scan.permission.a;

import android.media.MediaRecorder;
import java.io.File;

class r implements o {
  private File a = null;
  
  private MediaRecorder b = null;
  
  r() {
    this.b = new MediaRecorder();
  }
  
  private void b() {
    if (this.b != null) {
      try {
        this.b.stop();
      } catch (Exception exception) {}
      try {
        this.b.release();
      } catch (Exception exception) {}
    } 
    if (this.a != null && this.a.exists())
      this.a.delete(); 
  }
  
  public boolean a() {
    try {
      this.a = File.createTempFile("permission", "test");
      this.b.setAudioSource(1);
      this.b.setOutputFormat(3);
      this.b.setAudioEncoder(1);
      this.b.setOutputFile(this.a.getAbsolutePath());
      this.b.prepare();
      this.b.start();
      return true;
    } finally {
      b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */