package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
  public static MapSerializer instance = new MapSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, paramObject1, paramObject2, paramType, paramInt, false);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   4: astore #7
    //   6: aload_2
    //   7: ifnonnull -> 16
    //   10: aload #7
    //   12: invokevirtual writeNull : ()V
    //   15: return
    //   16: aload_2
    //   17: checkcast java/util/Map
    //   20: astore #8
    //   22: getstatic com/alibaba/fastjson/serializer/SerializerFeature.MapSortField : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   25: getfield mask : I
    //   28: istore #9
    //   30: aload #7
    //   32: getfield features : I
    //   35: iload #9
    //   37: iand
    //   38: ifne -> 49
    //   41: iload #5
    //   43: iload #9
    //   45: iand
    //   46: ifeq -> 84
    //   49: aload #8
    //   51: instanceof java/util/SortedMap
    //   54: ifne -> 84
    //   57: aload #8
    //   59: instanceof java/util/LinkedHashMap
    //   62: ifne -> 84
    //   65: new java/util/TreeMap
    //   68: astore #4
    //   70: aload #4
    //   72: aload #8
    //   74: invokespecial <init> : (Ljava/util/Map;)V
    //   77: aload #4
    //   79: astore #8
    //   81: goto -> 84
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual containsReference : (Ljava/lang/Object;)Z
    //   89: ifeq -> 98
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual writeReference : (Ljava/lang/Object;)V
    //   97: return
    //   98: aload_1
    //   99: getfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   102: astore #10
    //   104: aload_1
    //   105: aload #10
    //   107: aload_2
    //   108: aload_3
    //   109: iconst_0
    //   110: invokevirtual setContext : (Lcom/alibaba/fastjson/serializer/SerialContext;Ljava/lang/Object;Ljava/lang/Object;I)V
    //   113: iload #6
    //   115: ifne -> 132
    //   118: aload #7
    //   120: bipush #123
    //   122: invokevirtual write : (I)V
    //   125: goto -> 132
    //   128: astore_2
    //   129: goto -> 1181
    //   132: aload_1
    //   133: invokevirtual incrementIndent : ()V
    //   136: aload #7
    //   138: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   141: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   144: ifeq -> 232
    //   147: aload_1
    //   148: getfield config : Lcom/alibaba/fastjson/serializer/SerializeConfig;
    //   151: getfield typeKey : Ljava/lang/String;
    //   154: astore_3
    //   155: aload #8
    //   157: invokevirtual getClass : ()Ljava/lang/Class;
    //   160: astore #4
    //   162: aload #4
    //   164: ldc com/alibaba/fastjson/JSONObject
    //   166: if_acmpeq -> 183
    //   169: aload #4
    //   171: ldc java/util/HashMap
    //   173: if_acmpeq -> 183
    //   176: aload #4
    //   178: ldc java/util/LinkedHashMap
    //   180: if_acmpne -> 200
    //   183: aload #8
    //   185: aload_3
    //   186: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   191: ifeq -> 200
    //   194: iconst_1
    //   195: istore #5
    //   197: goto -> 203
    //   200: iconst_0
    //   201: istore #5
    //   203: iload #5
    //   205: ifne -> 232
    //   208: aload #7
    //   210: aload_3
    //   211: invokevirtual writeFieldName : (Ljava/lang/String;)V
    //   214: aload #7
    //   216: aload_2
    //   217: invokevirtual getClass : ()Ljava/lang/Class;
    //   220: invokevirtual getName : ()Ljava/lang/String;
    //   223: invokevirtual writeString : (Ljava/lang/String;)V
    //   226: iconst_0
    //   227: istore #5
    //   229: goto -> 235
    //   232: iconst_1
    //   233: istore #5
    //   235: aload #8
    //   237: invokeinterface entrySet : ()Ljava/util/Set;
    //   242: invokeinterface iterator : ()Ljava/util/Iterator;
    //   247: astore #11
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_3
    //   252: astore #12
    //   254: aload #11
    //   256: invokeinterface hasNext : ()Z
    //   261: ifeq -> 1133
    //   264: aload #11
    //   266: invokeinterface next : ()Ljava/lang/Object;
    //   271: checkcast java/util/Map$Entry
    //   274: astore #4
    //   276: aload #4
    //   278: invokeinterface getValue : ()Ljava/lang/Object;
    //   283: astore #13
    //   285: aload #4
    //   287: invokeinterface getKey : ()Ljava/lang/Object;
    //   292: astore #4
    //   294: aload_1
    //   295: getfield propertyPreFilters : Ljava/util/List;
    //   298: astore #14
    //   300: aload #14
    //   302: ifnull -> 384
    //   305: aload #14
    //   307: invokeinterface size : ()I
    //   312: ifle -> 384
    //   315: aload #4
    //   317: ifnull -> 367
    //   320: aload #4
    //   322: instanceof java/lang/String
    //   325: ifeq -> 331
    //   328: goto -> 367
    //   331: aload #4
    //   333: invokevirtual getClass : ()Ljava/lang/Class;
    //   336: invokevirtual isPrimitive : ()Z
    //   339: ifne -> 350
    //   342: aload #4
    //   344: instanceof java/lang/Number
    //   347: ifeq -> 384
    //   350: aload_0
    //   351: aload_1
    //   352: aload_2
    //   353: aload #4
    //   355: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   358: invokevirtual applyName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   361: ifne -> 384
    //   364: goto -> 381
    //   367: aload_0
    //   368: aload_1
    //   369: aload_2
    //   370: aload #4
    //   372: checkcast java/lang/String
    //   375: invokevirtual applyName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   378: ifne -> 384
    //   381: goto -> 934
    //   384: aload_0
    //   385: getfield propertyPreFilters : Ljava/util/List;
    //   388: astore #14
    //   390: aload #14
    //   392: ifnull -> 474
    //   395: aload #14
    //   397: invokeinterface size : ()I
    //   402: ifle -> 474
    //   405: aload #4
    //   407: ifnull -> 457
    //   410: aload #4
    //   412: instanceof java/lang/String
    //   415: ifeq -> 421
    //   418: goto -> 457
    //   421: aload #4
    //   423: invokevirtual getClass : ()Ljava/lang/Class;
    //   426: invokevirtual isPrimitive : ()Z
    //   429: ifne -> 440
    //   432: aload #4
    //   434: instanceof java/lang/Number
    //   437: ifeq -> 474
    //   440: aload_0
    //   441: aload_1
    //   442: aload_2
    //   443: aload #4
    //   445: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokevirtual applyName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   451: ifne -> 474
    //   454: goto -> 381
    //   457: aload_0
    //   458: aload_1
    //   459: aload_2
    //   460: aload #4
    //   462: checkcast java/lang/String
    //   465: invokevirtual applyName : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   468: ifne -> 474
    //   471: goto -> 381
    //   474: aload_1
    //   475: getfield propertyFilters : Ljava/util/List;
    //   478: astore #14
    //   480: aload #14
    //   482: ifnull -> 568
    //   485: aload #14
    //   487: invokeinterface size : ()I
    //   492: ifle -> 568
    //   495: aload #4
    //   497: ifnull -> 549
    //   500: aload #4
    //   502: instanceof java/lang/String
    //   505: ifeq -> 511
    //   508: goto -> 549
    //   511: aload #4
    //   513: invokevirtual getClass : ()Ljava/lang/Class;
    //   516: invokevirtual isPrimitive : ()Z
    //   519: ifne -> 530
    //   522: aload #4
    //   524: instanceof java/lang/Number
    //   527: ifeq -> 568
    //   530: aload_0
    //   531: aload_1
    //   532: aload_2
    //   533: aload #4
    //   535: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   538: aload #13
    //   540: invokevirtual apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   543: ifne -> 568
    //   546: goto -> 381
    //   549: aload_0
    //   550: aload_1
    //   551: aload_2
    //   552: aload #4
    //   554: checkcast java/lang/String
    //   557: aload #13
    //   559: invokevirtual apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   562: ifne -> 568
    //   565: goto -> 381
    //   568: aload_0
    //   569: getfield propertyFilters : Ljava/util/List;
    //   572: astore #14
    //   574: aload #14
    //   576: ifnull -> 662
    //   579: aload #14
    //   581: invokeinterface size : ()I
    //   586: ifle -> 662
    //   589: aload #4
    //   591: ifnull -> 643
    //   594: aload #4
    //   596: instanceof java/lang/String
    //   599: ifeq -> 605
    //   602: goto -> 643
    //   605: aload #4
    //   607: invokevirtual getClass : ()Ljava/lang/Class;
    //   610: invokevirtual isPrimitive : ()Z
    //   613: ifne -> 624
    //   616: aload #4
    //   618: instanceof java/lang/Number
    //   621: ifeq -> 662
    //   624: aload_0
    //   625: aload_1
    //   626: aload_2
    //   627: aload #4
    //   629: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   632: aload #13
    //   634: invokevirtual apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   637: ifne -> 662
    //   640: goto -> 381
    //   643: aload_0
    //   644: aload_1
    //   645: aload_2
    //   646: aload #4
    //   648: checkcast java/lang/String
    //   651: aload #13
    //   653: invokevirtual apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   656: ifne -> 662
    //   659: goto -> 381
    //   662: aload_1
    //   663: getfield nameFilters : Ljava/util/List;
    //   666: astore #15
    //   668: aload #4
    //   670: astore #14
    //   672: aload #15
    //   674: ifnull -> 763
    //   677: aload #4
    //   679: astore #14
    //   681: aload #15
    //   683: invokeinterface size : ()I
    //   688: ifle -> 763
    //   691: aload #4
    //   693: ifnull -> 748
    //   696: aload #4
    //   698: instanceof java/lang/String
    //   701: ifeq -> 707
    //   704: goto -> 748
    //   707: aload #4
    //   709: invokevirtual getClass : ()Ljava/lang/Class;
    //   712: invokevirtual isPrimitive : ()Z
    //   715: ifne -> 730
    //   718: aload #4
    //   720: astore #14
    //   722: aload #4
    //   724: instanceof java/lang/Number
    //   727: ifeq -> 763
    //   730: aload_0
    //   731: aload_1
    //   732: aload_2
    //   733: aload #4
    //   735: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   738: aload #13
    //   740: invokevirtual processKey : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   743: astore #14
    //   745: goto -> 763
    //   748: aload_0
    //   749: aload_1
    //   750: aload_2
    //   751: aload #4
    //   753: checkcast java/lang/String
    //   756: aload #13
    //   758: invokevirtual processKey : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   761: astore #14
    //   763: aload_0
    //   764: getfield nameFilters : Ljava/util/List;
    //   767: astore #15
    //   769: aload #14
    //   771: astore #4
    //   773: aload #15
    //   775: ifnull -> 864
    //   778: aload #14
    //   780: astore #4
    //   782: aload #15
    //   784: invokeinterface size : ()I
    //   789: ifle -> 864
    //   792: aload #14
    //   794: ifnull -> 849
    //   797: aload #14
    //   799: instanceof java/lang/String
    //   802: ifeq -> 808
    //   805: goto -> 849
    //   808: aload #14
    //   810: invokevirtual getClass : ()Ljava/lang/Class;
    //   813: invokevirtual isPrimitive : ()Z
    //   816: ifne -> 831
    //   819: aload #14
    //   821: astore #4
    //   823: aload #14
    //   825: instanceof java/lang/Number
    //   828: ifeq -> 864
    //   831: aload_0
    //   832: aload_1
    //   833: aload_2
    //   834: aload #14
    //   836: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   839: aload #13
    //   841: invokevirtual processKey : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   844: astore #4
    //   846: goto -> 864
    //   849: aload_0
    //   850: aload_1
    //   851: aload_2
    //   852: aload #14
    //   854: checkcast java/lang/String
    //   857: aload #13
    //   859: invokevirtual processKey : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   862: astore #4
    //   864: aload #4
    //   866: ifnull -> 899
    //   869: aload #4
    //   871: instanceof java/lang/String
    //   874: ifeq -> 880
    //   877: goto -> 899
    //   880: aload_0
    //   881: aload_1
    //   882: aconst_null
    //   883: aload_2
    //   884: aload #4
    //   886: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   889: aload #13
    //   891: invokevirtual processValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   894: astore #13
    //   896: goto -> 915
    //   899: aload_0
    //   900: aload_1
    //   901: aconst_null
    //   902: aload_2
    //   903: aload #4
    //   905: checkcast java/lang/String
    //   908: aload #13
    //   910: invokevirtual processValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   913: astore #13
    //   915: aload_3
    //   916: astore #14
    //   918: aload #13
    //   920: ifnonnull -> 937
    //   923: aload #7
    //   925: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WRITE_MAP_NULL_FEATURES : I
    //   928: invokevirtual isEnabled : (I)Z
    //   931: ifne -> 937
    //   934: goto -> 254
    //   937: aload #4
    //   939: instanceof java/lang/String
    //   942: ifeq -> 988
    //   945: aload #4
    //   947: checkcast java/lang/String
    //   950: astore_3
    //   951: iload #5
    //   953: ifne -> 963
    //   956: aload #7
    //   958: bipush #44
    //   960: invokevirtual write : (I)V
    //   963: aload #7
    //   965: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   968: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   971: ifeq -> 978
    //   974: aload_1
    //   975: invokevirtual println : ()V
    //   978: aload #7
    //   980: aload_3
    //   981: iconst_1
    //   982: invokevirtual writeFieldName : (Ljava/lang/String;Z)V
    //   985: goto -> 1061
    //   988: iload #5
    //   990: ifne -> 1000
    //   993: aload #7
    //   995: bipush #44
    //   997: invokevirtual write : (I)V
    //   1000: aload #7
    //   1002: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserCompatible : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1005: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1008: ifne -> 1045
    //   1011: aload #7
    //   1013: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringKeyAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1016: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1019: ifne -> 1045
    //   1022: aload #7
    //   1024: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserSecure : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1027: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1030: ifeq -> 1036
    //   1033: goto -> 1045
    //   1036: aload_1
    //   1037: aload #4
    //   1039: invokevirtual write : (Ljava/lang/Object;)V
    //   1042: goto -> 1054
    //   1045: aload_1
    //   1046: aload #4
    //   1048: invokestatic toJSONString : (Ljava/lang/Object;)Ljava/lang/String;
    //   1051: invokevirtual write : (Ljava/lang/String;)V
    //   1054: aload #7
    //   1056: bipush #58
    //   1058: invokevirtual write : (I)V
    //   1061: aload #13
    //   1063: ifnonnull -> 1080
    //   1066: aload #7
    //   1068: invokevirtual writeNull : ()V
    //   1071: aload #14
    //   1073: astore_3
    //   1074: iconst_0
    //   1075: istore #5
    //   1077: goto -> 254
    //   1080: aload #13
    //   1082: invokevirtual getClass : ()Ljava/lang/Class;
    //   1085: astore_3
    //   1086: aload_3
    //   1087: aload #14
    //   1089: if_acmpne -> 1109
    //   1092: aload #12
    //   1094: aload_1
    //   1095: aload #13
    //   1097: aload #4
    //   1099: aconst_null
    //   1100: iconst_0
    //   1101: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   1106: goto -> 1071
    //   1109: aload_1
    //   1110: aload_3
    //   1111: invokevirtual getObjectWriter : (Ljava/lang/Class;)Lcom/alibaba/fastjson/serializer/ObjectSerializer;
    //   1114: astore #12
    //   1116: aload #12
    //   1118: aload_1
    //   1119: aload #13
    //   1121: aload #4
    //   1123: aconst_null
    //   1124: iconst_0
    //   1125: invokeinterface write : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V
    //   1130: goto -> 1074
    //   1133: aload_1
    //   1134: aload #10
    //   1136: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   1139: aload_1
    //   1140: invokevirtual decrementIdent : ()V
    //   1143: aload #7
    //   1145: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1148: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1151: ifeq -> 1168
    //   1154: aload #8
    //   1156: invokeinterface size : ()I
    //   1161: ifle -> 1168
    //   1164: aload_1
    //   1165: invokevirtual println : ()V
    //   1168: iload #6
    //   1170: ifne -> 1180
    //   1173: aload #7
    //   1175: bipush #125
    //   1177: invokevirtual write : (I)V
    //   1180: return
    //   1181: aload_1
    //   1182: aload #10
    //   1184: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   1187: aload_2
    //   1188: athrow
    //   1189: astore #4
    //   1191: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   65	77	1189	java/lang/Exception
    //   118	125	128	finally
    //   132	162	128	finally
    //   183	194	128	finally
    //   208	226	128	finally
    //   235	249	128	finally
    //   254	300	128	finally
    //   305	315	128	finally
    //   320	328	128	finally
    //   331	350	128	finally
    //   350	364	128	finally
    //   367	381	128	finally
    //   384	390	128	finally
    //   395	405	128	finally
    //   410	418	128	finally
    //   421	440	128	finally
    //   440	454	128	finally
    //   457	471	128	finally
    //   474	480	128	finally
    //   485	495	128	finally
    //   500	508	128	finally
    //   511	530	128	finally
    //   530	546	128	finally
    //   549	565	128	finally
    //   568	574	128	finally
    //   579	589	128	finally
    //   594	602	128	finally
    //   605	624	128	finally
    //   624	640	128	finally
    //   643	659	128	finally
    //   662	668	128	finally
    //   681	691	128	finally
    //   696	704	128	finally
    //   707	718	128	finally
    //   722	730	128	finally
    //   730	745	128	finally
    //   748	763	128	finally
    //   763	769	128	finally
    //   782	792	128	finally
    //   797	805	128	finally
    //   808	819	128	finally
    //   823	831	128	finally
    //   831	846	128	finally
    //   849	864	128	finally
    //   869	877	128	finally
    //   880	896	128	finally
    //   899	915	128	finally
    //   923	934	128	finally
    //   937	951	128	finally
    //   956	963	128	finally
    //   963	978	128	finally
    //   978	985	128	finally
    //   993	1000	128	finally
    //   1000	1033	128	finally
    //   1036	1042	128	finally
    //   1045	1054	128	finally
    //   1054	1061	128	finally
    //   1066	1071	128	finally
    //   1080	1086	128	finally
    //   1092	1106	128	finally
    //   1109	1130	128	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */