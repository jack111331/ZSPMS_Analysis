package android.support.v4.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

class DatagramSocketWrapper extends Socket {
  public DatagramSocketWrapper(DatagramSocket paramDatagramSocket, FileDescriptor paramFileDescriptor) {
    super(new DatagramSocketImplWrapper(paramDatagramSocket, paramFileDescriptor));
  }
  
  private static class DatagramSocketImplWrapper extends SocketImpl {
    public DatagramSocketImplWrapper(DatagramSocket param1DatagramSocket, FileDescriptor param1FileDescriptor) {
      this.localport = param1DatagramSocket.getLocalPort();
      this.fd = param1FileDescriptor;
    }
    
    protected void accept(SocketImpl param1SocketImpl) {
      throw new UnsupportedOperationException();
    }
    
    protected int available() {
      throw new UnsupportedOperationException();
    }
    
    protected void bind(InetAddress param1InetAddress, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected void close() {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(String param1String, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(InetAddress param1InetAddress, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected void connect(SocketAddress param1SocketAddress, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected void create(boolean param1Boolean) {
      throw new UnsupportedOperationException();
    }
    
    protected InputStream getInputStream() {
      throw new UnsupportedOperationException();
    }
    
    public Object getOption(int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected OutputStream getOutputStream() {
      throw new UnsupportedOperationException();
    }
    
    protected void listen(int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    protected void sendUrgentData(int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public void setOption(int param1Int, Object param1Object) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\net\DatagramSocketWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */