package org.apache.http.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

@Deprecated
public interface HttpMessageParser {
  HttpMessage parse() throws IOException, HttpException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\io\HttpMessageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */