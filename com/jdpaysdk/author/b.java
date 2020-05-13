package com.jdpaysdk.author;

import android.os.Message;

class b implements Runnable {
  b(AuthorActivity paramAuthorActivity, String paramString) {}
  
  public void run() {
    Message message = new Message();
    message.what = 0;
    message.obj = this.a;
    AuthorActivity.a(this.b).sendMessage(message);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */