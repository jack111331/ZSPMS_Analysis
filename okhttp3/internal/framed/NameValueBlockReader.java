package okhttp3.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

class NameValueBlockReader {
  private int compressedLimit;
  
  private final InflaterSource inflaterSource;
  
  private final BufferedSource source;
  
  public NameValueBlockReader(BufferedSource paramBufferedSource) {
    this.inflaterSource = new InflaterSource((Source)new ForwardingSource((Source)paramBufferedSource) {
          public long read(Buffer param1Buffer, long param1Long) throws IOException {
            if (NameValueBlockReader.this.compressedLimit == 0)
              return -1L; 
            param1Long = super.read(param1Buffer, Math.min(param1Long, NameValueBlockReader.this.compressedLimit));
            if (param1Long == -1L)
              return -1L; 
            NameValueBlockReader.access$002(NameValueBlockReader.this, (int)(NameValueBlockReader.this.compressedLimit - param1Long));
            return param1Long;
          }
        }new Inflater() {
          public int inflate(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws DataFormatException {
            int i = super.inflate(param1ArrayOfbyte, param1Int1, param1Int2);
            int j = i;
            if (i == 0) {
              j = i;
              if (needsDictionary()) {
                setDictionary(Spdy3.DICTIONARY);
                j = super.inflate(param1ArrayOfbyte, param1Int1, param1Int2);
              } 
            } 
            return j;
          }
        });
    this.source = Okio.buffer((Source)this.inflaterSource);
  }
  
  private void doneReading() throws IOException {
    if (this.compressedLimit > 0) {
      this.inflaterSource.refill();
      if (this.compressedLimit != 0)
        throw new IOException("compressedLimit > 0: " + this.compressedLimit); 
    } 
  }
  
  private ByteString readByteString() throws IOException {
    int i = this.source.readInt();
    return this.source.readByteString(i);
  }
  
  public void close() throws IOException {
    this.source.close();
  }
  
  public List<Header> readNameValueBlock(int paramInt) throws IOException {
    this.compressedLimit += paramInt;
    int i = this.source.readInt();
    if (i < 0)
      throw new IOException("numberOfPairs < 0: " + i); 
    if (i > 1024)
      throw new IOException("numberOfPairs > 1024: " + i); 
    ArrayList<Header> arrayList = new ArrayList(i);
    for (paramInt = 0; paramInt < i; paramInt++) {
      ByteString byteString1 = readByteString().toAsciiLowercase();
      ByteString byteString2 = readByteString();
      if (byteString1.size() == 0)
        throw new IOException("name.size == 0"); 
      arrayList.add(new Header(byteString1, byteString2));
    } 
    doneReading();
    return arrayList;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\NameValueBlockReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */