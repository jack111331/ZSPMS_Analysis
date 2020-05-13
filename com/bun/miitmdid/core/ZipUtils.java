package com.bun.miitmdid.core;

import android.support.annotation.Keep;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

@Keep
public class ZipUtils {
  private static final int BUFFER_SIZE = 16384;
  
  private static final int ENDHDR = 22;
  
  private static final int ENDSIG = 101010256;
  
  static long computeCrcOfCentralDir(RandomAccessFile paramRandomAccessFile, CentralDirectory paramCentralDirectory) throws IOException {
    CRC32 cRC32 = new CRC32();
    long l = paramCentralDirectory.size;
    paramRandomAccessFile.seek(paramCentralDirectory.offset);
    int i = (int)Math.min(16384L, l);
    byte[] arrayOfByte = new byte[16384];
    while (true) {
      i = paramRandomAccessFile.read(arrayOfByte, 0, i);
      if (i == -1)
        break; 
      cRC32.update(arrayOfByte, 0, i);
      l -= i;
      if (l != 0L) {
        i = (int)Math.min(16384L, l);
        continue;
      } 
      break;
    } 
    return cRC32.getValue();
  }
  
  @Keep
  static CentralDirectory findCentralDirectory(RandomAccessFile paramRandomAccessFile) throws IOException, ZipException {
    long l1 = paramRandomAccessFile.length() - 22L;
    long l2 = 0L;
    if (l1 >= 0L) {
      long l = l1 - 65536L;
      if (l < 0L)
        l = l2; 
      int i = Integer.reverseBytes(101010256);
      while (true) {
        paramRandomAccessFile.seek(l1);
        if (paramRandomAccessFile.readInt() == i) {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          CentralDirectory centralDirectory = new CentralDirectory();
          centralDirectory.size = Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFFL;
          centralDirectory.offset = Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFFL;
          return centralDirectory;
        } 
        l1--;
        if (l1 >= l)
          continue; 
        throw new ZipException("End Of Central Directory signature not found");
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder("File too short to be a zip file: ");
    stringBuilder.append(paramRandomAccessFile.length());
    throw new ZipException(stringBuilder.toString());
  }
  
  @Keep
  public static long getZipCrc(File paramFile) throws IOException {
    RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "r");
    try {
      return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
    } finally {
      randomAccessFile.close();
    } 
  }
  
  static class CentralDirectory {
    long offset;
    
    long size;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\core\ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */