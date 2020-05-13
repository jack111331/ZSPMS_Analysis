package com.qiniu.android.storage.persistent;

import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

public final class FileRecorder implements Recorder {
  public String directory;
  
  public FileRecorder(String paramString) throws IOException {
    this.directory = paramString;
    File file = new File(paramString);
    if (!file.exists()) {
      if (file.mkdirs())
        return; 
      throw new IOException("mkdir failed");
    } 
    if (file.isDirectory())
      return; 
    throw new IOException("does not mkdir");
  }
  
  private static String hash(String paramString) {
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("SHA-1").digest(paramString.getBytes());
      StringBuffer stringBuffer = new StringBuffer();
      this();
      for (byte b = 0; b < arrayOfByte.length; b++)
        stringBuffer.append(Integer.toString((arrayOfByte[b] & 0xFF) + 256, 16).substring(1)); 
      return stringBuffer.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private boolean outOfDate(File paramFile) {
    boolean bool;
    if (paramFile.lastModified() + 172800000L < (new Date()).getTime()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void del(String paramString) {
    (new File(this.directory, hash(paramString))).delete();
  }
  
  public byte[] get(String paramString) {
    File file = new File(this.directory, hash(paramString));
    try {
      if (outOfDate(file)) {
        file.delete();
        return null;
      } 
      byte[] arrayOfByte = new byte[(int)file.length()];
      try {
        FileInputStream fileInputStream = new FileInputStream();
        this(file);
        try {
          int i = fileInputStream.read(arrayOfByte);
        } catch (IOException null) {}
      } catch (IOException null) {
        paramString = null;
      } 
    } catch (IOException iOException) {
      String str = null;
      paramString = str;
    } 
    iOException.printStackTrace();
    boolean bool = false;
  }
  
  public void set(String paramString, byte[] paramArrayOfbyte) {
    File file = new File(this.directory, hash(paramString));
    try {
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(file);
      try {
        fileOutputStream.write(paramArrayOfbyte);
      } catch (IOException null) {}
    } catch (IOException iOException) {
      paramString = null;
    } 
    iOException.printStackTrace();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\persistent\FileRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */