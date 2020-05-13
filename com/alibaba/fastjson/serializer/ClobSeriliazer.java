package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobSeriliazer implements ObjectSerializer {
  public static final ClobSeriliazer instance = new ClobSeriliazer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null)
      try {
        paramJSONSerializer.writeNull();
        return;
      } catch (SQLException sQLException) {
        throw new IOException("write clob error", sQLException);
      }  
    paramObject1 = ((Clob)paramObject1).getCharacterStream();
    paramObject2 = new StringBuilder();
    super();
    try {
      char[] arrayOfChar = new char[2048];
      while (true) {
        paramInt = paramObject1.read(arrayOfChar, 0, arrayOfChar.length);
        if (paramInt < 0) {
          paramObject2 = paramObject2.toString();
          paramObject1.close();
          sQLException.write((String)paramObject2);
          return;
        } 
        paramObject2.append(arrayOfChar, 0, paramInt);
      } 
    } catch (Exception exception) {
      JSONException jSONException = new JSONException();
      this("read string from reader error", exception);
      throw jSONException;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\ClobSeriliazer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */