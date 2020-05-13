package com.google.gson.stream;

enum JsonScope {
  CLOSED, DANGLING_NAME, EMPTY_ARRAY, EMPTY_DOCUMENT, EMPTY_OBJECT, NONEMPTY_ARRAY, NONEMPTY_DOCUMENT, NONEMPTY_OBJECT;
  
  static {
    EMPTY_OBJECT = new JsonScope("EMPTY_OBJECT", 2);
    DANGLING_NAME = new JsonScope("DANGLING_NAME", 3);
    NONEMPTY_OBJECT = new JsonScope("NONEMPTY_OBJECT", 4);
    EMPTY_DOCUMENT = new JsonScope("EMPTY_DOCUMENT", 5);
    NONEMPTY_DOCUMENT = new JsonScope("NONEMPTY_DOCUMENT", 6);
    CLOSED = new JsonScope("CLOSED", 7);
    $VALUES = new JsonScope[] { EMPTY_ARRAY, NONEMPTY_ARRAY, EMPTY_OBJECT, DANGLING_NAME, NONEMPTY_OBJECT, EMPTY_DOCUMENT, NONEMPTY_DOCUMENT, CLOSED };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\stream\JsonScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */