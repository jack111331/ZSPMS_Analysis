package android.support.v4.text.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
  private static final Comparator<LinkSpec> COMPARATOR;
  
  private static final String[] EMPTY_STRING = new String[0];
  
  static {
    COMPARATOR = new Comparator<LinkSpec>() {
        public final int compare(LinkifyCompat.LinkSpec param1LinkSpec1, LinkifyCompat.LinkSpec param1LinkSpec2) {
          boolean bool = true;
          if (param1LinkSpec1.start >= param1LinkSpec2.start) {
            boolean bool1 = bool;
            if (param1LinkSpec1.start <= param1LinkSpec2.start) {
              bool1 = bool;
              if (param1LinkSpec1.end >= param1LinkSpec2.end) {
                if (param1LinkSpec1.end <= param1LinkSpec2.end)
                  return 0; 
              } else {
                return bool1;
              } 
            } else {
              return bool1;
            } 
          } 
          return -1;
        }
      };
  }
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView) {
    MovementMethod movementMethod = paramTextView.getMovementMethod();
    if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && paramTextView.getLinksClickable())
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance()); 
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString) {
    addLinks(paramTextView, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    addLinks(paramTextView, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    SpannableString spannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks((Spannable)spannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter)) {
      paramTextView.setText((CharSequence)spannableString);
      addLinkMovementMethod(paramTextView);
    } 
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, int paramInt) {
    if (paramInt == 0)
      return false; 
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int i = arrayOfURLSpan.length - 1; i >= 0; i--)
      paramSpannable.removeSpan(arrayOfURLSpan[i]); 
    if ((paramInt & 0x4) != 0)
      Linkify.addLinks(paramSpannable, 4); 
    ArrayList<LinkSpec> arrayList = new ArrayList();
    if ((paramInt & 0x1) != 0) {
      Pattern pattern = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter matchFilter = Linkify.sUrlMatchFilter;
      gatherLinks(arrayList, paramSpannable, pattern, new String[] { "http://", "https://", "rtsp://" }, matchFilter, null);
    } 
    if ((paramInt & 0x2) != 0)
      gatherLinks(arrayList, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null); 
    if ((paramInt & 0x8) != 0)
      gatherMapLinks(arrayList, paramSpannable); 
    pruneOverlaps(arrayList, paramSpannable);
    if (arrayList.size() == 0)
      return false; 
    for (LinkSpec linkSpec : arrayList) {
      if (linkSpec.frameworkAddedSpan == null)
        applyLink(linkSpec.url, linkSpec.start, linkSpec.end, paramSpannable); 
    } 
    return true;
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString) {
    return addLinks(paramSpannable, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    return addLinks(paramSpannable, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter) {
    // Byte code:
    //   0: aload_2
    //   1: astore #6
    //   3: aload_2
    //   4: ifnonnull -> 11
    //   7: ldc ''
    //   9: astore #6
    //   11: aload_3
    //   12: ifnull -> 23
    //   15: aload_3
    //   16: astore_2
    //   17: aload_3
    //   18: arraylength
    //   19: iconst_1
    //   20: if_icmpge -> 27
    //   23: getstatic android/support/v4/text/util/LinkifyCompat.EMPTY_STRING : [Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: arraylength
    //   29: iconst_1
    //   30: iadd
    //   31: anewarray java/lang/String
    //   34: astore #7
    //   36: aload #7
    //   38: iconst_0
    //   39: aload #6
    //   41: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   44: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   47: aastore
    //   48: iconst_0
    //   49: istore #8
    //   51: iload #8
    //   53: aload_2
    //   54: arraylength
    //   55: if_icmpge -> 95
    //   58: aload_2
    //   59: iload #8
    //   61: aaload
    //   62: astore_3
    //   63: aload_3
    //   64: ifnonnull -> 84
    //   67: ldc ''
    //   69: astore_3
    //   70: aload #7
    //   72: iload #8
    //   74: iconst_1
    //   75: iadd
    //   76: aload_3
    //   77: aastore
    //   78: iinc #8, 1
    //   81: goto -> 51
    //   84: aload_3
    //   85: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   88: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   91: astore_3
    //   92: goto -> 70
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   100: astore_1
    //   101: iconst_0
    //   102: istore #9
    //   104: aload_1
    //   105: invokevirtual find : ()Z
    //   108: ifeq -> 180
    //   111: aload_1
    //   112: invokevirtual start : ()I
    //   115: istore #10
    //   117: aload_1
    //   118: invokevirtual end : ()I
    //   121: istore #8
    //   123: aload #4
    //   125: ifnull -> 174
    //   128: aload #4
    //   130: aload_0
    //   131: iload #10
    //   133: iload #8
    //   135: invokeinterface acceptMatch : (Ljava/lang/CharSequence;II)Z
    //   140: istore #11
    //   142: iload #11
    //   144: ifeq -> 104
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual group : (I)Ljava/lang/String;
    //   152: aload #7
    //   154: aload_1
    //   155: aload #5
    //   157: invokestatic makeUrl : (Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;
    //   160: iload #10
    //   162: iload #8
    //   164: aload_0
    //   165: invokestatic applyLink : (Ljava/lang/String;IILandroid/text/Spannable;)V
    //   168: iconst_1
    //   169: istore #9
    //   171: goto -> 104
    //   174: iconst_1
    //   175: istore #11
    //   177: goto -> 142
    //   180: iload #9
    //   182: ireturn
  }
  
  public static final boolean addLinks(@NonNull TextView paramTextView, int paramInt) {
    if (paramInt == 0)
      return false; 
    CharSequence charSequence = paramTextView.getText();
    if (charSequence instanceof Spannable) {
      if (addLinks((Spannable)charSequence, paramInt)) {
        addLinkMovementMethod(paramTextView);
        return true;
      } 
      return false;
    } 
    SpannableString spannableString = SpannableString.valueOf(charSequence);
    if (addLinks((Spannable)spannableString, paramInt)) {
      addLinkMovementMethod(paramTextView);
      paramTextView.setText((CharSequence)spannableString);
      return true;
    } 
    return false;
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable) {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    Matcher matcher = paramPattern.matcher((CharSequence)paramSpannable);
    while (matcher.find()) {
      int i = matcher.start();
      int j = matcher.end();
      if (paramMatchFilter == null || paramMatchFilter.acceptMatch((CharSequence)paramSpannable, i, j)) {
        LinkSpec linkSpec = new LinkSpec();
        linkSpec.url = makeUrl(matcher.group(0), paramArrayOfString, matcher, paramTransformFilter);
        linkSpec.start = i;
        linkSpec.end = j;
        paramArrayList.add(linkSpec);
      } 
    } 
  }
  
  private static final void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    String str = paramSpannable.toString();
    int i = 0;
    while (true) {
      try {
        String str1 = WebView.findAddress(str);
        if (str1 != null) {
          int j = str.indexOf(str1);
          if (j >= 0) {
            LinkSpec linkSpec = new LinkSpec();
            this();
            int k = str1.length() + j;
            linkSpec.start = j + i;
            linkSpec.end = i + k;
            str = str.substring(k);
            i += k;
            try {
              String str2 = URLEncoder.encode(str1, "UTF-8");
              StringBuilder stringBuilder = new StringBuilder();
              this();
              linkSpec.url = stringBuilder.append("geo:0,0?q=").append(str2).toString();
              paramArrayList.add(linkSpec);
            } catch (UnsupportedEncodingException unsupportedEncodingException) {}
            continue;
          } 
        } 
      } catch (UnsupportedOperationException unsupportedOperationException) {}
      return;
    } 
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_3
    //   4: ifnull -> 161
    //   7: aload_3
    //   8: aload_2
    //   9: aload_0
    //   10: invokeinterface transformUrl : (Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: iconst_0
    //   17: istore #5
    //   19: iload #5
    //   21: aload_1
    //   22: arraylength
    //   23: if_icmpge -> 153
    //   26: aload_2
    //   27: iconst_1
    //   28: iconst_0
    //   29: aload_1
    //   30: iload #5
    //   32: aaload
    //   33: iconst_0
    //   34: aload_1
    //   35: iload #5
    //   37: aaload
    //   38: invokevirtual length : ()I
    //   41: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
    //   44: ifeq -> 147
    //   47: aload_2
    //   48: astore_0
    //   49: iload #4
    //   51: istore #6
    //   53: aload_2
    //   54: iconst_0
    //   55: iconst_0
    //   56: aload_1
    //   57: iload #5
    //   59: aaload
    //   60: iconst_0
    //   61: aload_1
    //   62: iload #5
    //   64: aaload
    //   65: invokevirtual length : ()I
    //   68: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
    //   71: ifne -> 110
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: aload_1
    //   82: iload #5
    //   84: aaload
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: aload_1
    //   90: iload #5
    //   92: aaload
    //   93: invokevirtual length : ()I
    //   96: invokevirtual substring : (I)Ljava/lang/String;
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual toString : ()Ljava/lang/String;
    //   105: astore_0
    //   106: iload #4
    //   108: istore #6
    //   110: aload_0
    //   111: astore_2
    //   112: iload #6
    //   114: ifne -> 145
    //   117: aload_0
    //   118: astore_2
    //   119: aload_1
    //   120: arraylength
    //   121: ifle -> 145
    //   124: new java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial <init> : ()V
    //   131: aload_1
    //   132: iconst_0
    //   133: aaload
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual toString : ()Ljava/lang/String;
    //   144: astore_2
    //   145: aload_2
    //   146: areturn
    //   147: iinc #5, 1
    //   150: goto -> 19
    //   153: iconst_0
    //   154: istore #6
    //   156: aload_2
    //   157: astore_0
    //   158: goto -> 110
    //   161: aload_0
    //   162: astore_2
    //   163: goto -> 16
  }
  
  private static final void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    byte b = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i;
    for (i = 0; i < arrayOfURLSpan.length; i++) {
      LinkSpec linkSpec = new LinkSpec();
      linkSpec.frameworkAddedSpan = arrayOfURLSpan[i];
      linkSpec.start = paramSpannable.getSpanStart(arrayOfURLSpan[i]);
      linkSpec.end = paramSpannable.getSpanEnd(arrayOfURLSpan[i]);
      paramArrayList.add(linkSpec);
    } 
    Collections.sort(paramArrayList, COMPARATOR);
    int j = paramArrayList.size();
    while (b < j - 1) {
      LinkSpec linkSpec1 = paramArrayList.get(b);
      LinkSpec linkSpec2 = paramArrayList.get(b + 1);
      if (linkSpec1.start <= linkSpec2.start && linkSpec1.end > linkSpec2.start) {
        if (linkSpec2.end <= linkSpec1.end) {
          i = b + 1;
        } else if (linkSpec1.end - linkSpec1.start > linkSpec2.end - linkSpec2.start) {
          i = b + 1;
        } else if (linkSpec1.end - linkSpec1.start < linkSpec2.end - linkSpec2.start) {
          i = b;
        } else {
          i = -1;
        } 
        if (i != -1) {
          URLSpan uRLSpan = ((LinkSpec)paramArrayList.get(i)).frameworkAddedSpan;
          if (uRLSpan != null)
            paramSpannable.removeSpan(uRLSpan); 
          paramArrayList.remove(i);
          j--;
          continue;
        } 
      } 
      b++;
    } 
  }
  
  private static class LinkSpec {
    int end;
    
    URLSpan frameworkAddedSpan;
    
    int start;
    
    String url;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkifyMask {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\tex\\util\LinkifyCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */