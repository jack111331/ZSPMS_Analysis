package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
  static final Logger logger = Logger.getLogger(Okio.class.getName());
  
  public static Sink appendingSink(File paramFile) throws FileNotFoundException {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null"); 
    return sink(new FileOutputStream(paramFile, true));
  }
  
  public static BufferedSink buffer(Sink paramSink) {
    if (paramSink == null)
      throw new IllegalArgumentException("sink == null"); 
    return new RealBufferedSink(paramSink);
  }
  
  public static BufferedSource buffer(Source paramSource) {
    if (paramSource == null)
      throw new IllegalArgumentException("source == null"); 
    return new RealBufferedSource(paramSource);
  }
  
  static boolean isAndroidGetsocknameError(AssertionError paramAssertionError) {
    return (paramAssertionError.getCause() != null && paramAssertionError.getMessage() != null && paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static Sink sink(File paramFile) throws FileNotFoundException {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null"); 
    return sink(new FileOutputStream(paramFile));
  }
  
  public static Sink sink(OutputStream paramOutputStream) {
    return sink(paramOutputStream, new Timeout());
  }
  
  private static Sink sink(final OutputStream out, final Timeout timeout) {
    if (out == null)
      throw new IllegalArgumentException("out == null"); 
    if (timeout == null)
      throw new IllegalArgumentException("timeout == null"); 
    return new Sink() {
        public void close() throws IOException {
          out.close();
        }
        
        public void flush() throws IOException {
          out.flush();
        }
        
        public Timeout timeout() {
          return timeout;
        }
        
        public String toString() {
          return "sink(" + out + ")";
        }
        
        public void write(Buffer param1Buffer, long param1Long) throws IOException {
          Util.checkOffsetAndCount(param1Buffer.size, 0L, param1Long);
          while (param1Long > 0L) {
            timeout.throwIfReached();
            Segment segment = param1Buffer.head;
            int i = (int)Math.min(param1Long, (segment.limit - segment.pos));
            out.write(segment.data, segment.pos, i);
            segment.pos += i;
            long l = param1Long - i;
            param1Buffer.size -= i;
            param1Long = l;
            if (segment.pos == segment.limit) {
              param1Buffer.head = segment.pop();
              SegmentPool.recycle(segment);
              param1Long = l;
            } 
          } 
        }
      };
  }
  
  public static Sink sink(Socket paramSocket) throws IOException {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null"); 
    AsyncTimeout asyncTimeout = timeout(paramSocket);
    return asyncTimeout.sink(sink(paramSocket.getOutputStream(), asyncTimeout));
  }
  
  @IgnoreJRERequirement
  public static Sink sink(Path paramPath, OpenOption... paramVarArgs) throws IOException {
    if (paramPath == null)
      throw new IllegalArgumentException("path == null"); 
    return sink(Files.newOutputStream(paramPath, paramVarArgs));
  }
  
  public static Source source(File paramFile) throws FileNotFoundException {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null"); 
    return source(new FileInputStream(paramFile));
  }
  
  public static Source source(InputStream paramInputStream) {
    return source(paramInputStream, new Timeout());
  }
  
  private static Source source(final InputStream in, final Timeout timeout) {
    if (in == null)
      throw new IllegalArgumentException("in == null"); 
    if (timeout == null)
      throw new IllegalArgumentException("timeout == null"); 
    return new Source() {
        public void close() throws IOException {
          in.close();
        }
        
        public long read(Buffer param1Buffer, long param1Long) throws IOException {
          long l = 0L;
          if (param1Long < 0L)
            throw new IllegalArgumentException("byteCount < 0: " + param1Long); 
          if (param1Long == 0L)
            return l; 
          try {
            timeout.throwIfReached();
            Segment segment = param1Buffer.writableSegment(1);
            int i = (int)Math.min(param1Long, (8192 - segment.limit));
            i = in.read(segment.data, segment.limit, i);
            if (i == -1)
              return -1L; 
            segment.limit += i;
            param1Buffer.size += i;
            return i;
          } catch (AssertionError assertionError) {
            if (Okio.isAndroidGetsocknameError(assertionError))
              throw new IOException(assertionError); 
            throw assertionError;
          } 
        }
        
        public Timeout timeout() {
          return timeout;
        }
        
        public String toString() {
          return "source(" + in + ")";
        }
      };
  }
  
  public static Source source(Socket paramSocket) throws IOException {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null"); 
    AsyncTimeout asyncTimeout = timeout(paramSocket);
    return asyncTimeout.source(source(paramSocket.getInputStream(), asyncTimeout));
  }
  
  @IgnoreJRERequirement
  public static Source source(Path paramPath, OpenOption... paramVarArgs) throws IOException {
    if (paramPath == null)
      throw new IllegalArgumentException("path == null"); 
    return source(Files.newInputStream(paramPath, paramVarArgs));
  }
  
  private static AsyncTimeout timeout(final Socket socket) {
    return new AsyncTimeout() {
        protected IOException newTimeoutException(IOException param1IOException) {
          SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
          if (param1IOException != null)
            socketTimeoutException.initCause(param1IOException); 
          return socketTimeoutException;
        }
        
        protected void timedOut() {
          try {
            socket.close();
            return;
          } catch (Exception exception) {
            Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, exception);
            return;
          } catch (AssertionError assertionError) {
            if (Okio.isAndroidGetsocknameError(assertionError)) {
              Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + socket, assertionError);
              return;
            } 
            throw assertionError;
          } 
        }
      };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\Okio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */