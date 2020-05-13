package com.zz.lib.org.myapache.commons.codec.net;

import com.zz.lib.org.myapache.commons.codec.DecoderException;

class Utils {
  static int digit16(byte paramByte) throws DecoderException {
    int i = Character.digit((char)paramByte, 16);
    if (i == -1)
      throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + paramByte); 
    return i;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */