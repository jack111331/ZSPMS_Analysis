package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {
  protected char[] applyJsonQuoting(String paramString) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer();
      this(serializeWriter);
      jSONSerializer.write(paramString);
      return serializeWriter.toCharArrayForSpringWebSocket();
    } finally {
      serializeWriter.close();
    } 
  }
  
  public String[] decode(String paramString) throws IOException {
    return (String[])JSON.parseObject(paramString, String[].class);
  }
  
  public String[] decodeInputStream(InputStream paramInputStream) throws IOException {
    return (String[])JSON.parseObject(paramInputStream, String[].class, new com.alibaba.fastjson.parser.Feature[0]);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\FastjsonSockJsMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */