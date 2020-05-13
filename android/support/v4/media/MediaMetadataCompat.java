package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
  
  static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
  
  public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
  
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  
  public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
  
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  
  public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
  
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  
  static final int METADATA_TYPE_BITMAP = 2;
  
  static final int METADATA_TYPE_LONG = 0;
  
  static final int METADATA_TYPE_RATING = 3;
  
  static final int METADATA_TYPE_TEXT = 1;
  
  private static final String[] PREFERRED_BITMAP_ORDER;
  
  private static final String[] PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
  
  private static final String[] PREFERRED_URI_ORDER;
  
  private static final String TAG = "MediaMetadata";
  
  final Bundle mBundle;
  
  private MediaDescriptionCompat mDescription;
  
  private Object mMetadataObj;
  
  static {
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
    CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        public MediaMetadataCompat createFromParcel(Parcel param1Parcel) {
          return new MediaMetadataCompat(param1Parcel);
        }
        
        public MediaMetadataCompat[] newArray(int param1Int) {
          return new MediaMetadataCompat[param1Int];
        }
      };
  }
  
  MediaMetadataCompat(Bundle paramBundle) {
    this.mBundle = new Bundle(paramBundle);
  }
  
  MediaMetadataCompat(Parcel paramParcel) {
    this.mBundle = paramParcel.readBundle();
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject) {
    if (paramObject == null || Build.VERSION.SDK_INT < 21)
      return null; 
    Parcel parcel = Parcel.obtain();
    MediaMetadataCompatApi21.writeToParcel(paramObject, parcel, 0);
    parcel.setDataPosition(0);
    MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
    parcel.recycle();
    mediaMetadataCompat.mMetadataObj = paramObject;
    return mediaMetadataCompat;
  }
  
  public boolean containsKey(String paramString) {
    return this.mBundle.containsKey(paramString);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString) {
    try {
      Bitmap bitmap = (Bitmap)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", exception);
      exception = null;
    } 
    return (Bitmap)exception;
  }
  
  public Bundle getBundle() {
    return this.mBundle;
  }
  
  public MediaDescriptionCompat getDescription() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   6: ifnull -> 16
    //   9: aload_0
    //   10: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   13: astore_2
    //   14: aload_2
    //   15: areturn
    //   16: aload_0
    //   17: ldc 'android.media.metadata.MEDIA_ID'
    //   19: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_3
    //   23: iconst_3
    //   24: anewarray java/lang/CharSequence
    //   27: astore #4
    //   29: aload_0
    //   30: ldc 'android.media.metadata.DISPLAY_TITLE'
    //   32: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   35: astore_2
    //   36: aload_2
    //   37: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   40: ifne -> 281
    //   43: aload #4
    //   45: iconst_0
    //   46: aload_2
    //   47: aastore
    //   48: aload #4
    //   50: iconst_1
    //   51: aload_0
    //   52: ldc 'android.media.metadata.DISPLAY_SUBTITLE'
    //   54: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   57: aastore
    //   58: aload #4
    //   60: iconst_2
    //   61: aload_0
    //   62: ldc 'android.media.metadata.DISPLAY_DESCRIPTION'
    //   64: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   67: aastore
    //   68: iconst_0
    //   69: istore #5
    //   71: iload #5
    //   73: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_BITMAP_ORDER : [Ljava/lang/String;
    //   76: arraylength
    //   77: if_icmpge -> 366
    //   80: aload_0
    //   81: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_BITMAP_ORDER : [Ljava/lang/String;
    //   84: iload #5
    //   86: aaload
    //   87: invokevirtual getBitmap : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull -> 348
    //   95: iconst_0
    //   96: istore #5
    //   98: iload #5
    //   100: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_URI_ORDER : [Ljava/lang/String;
    //   103: arraylength
    //   104: if_icmpge -> 360
    //   107: aload_0
    //   108: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_URI_ORDER : [Ljava/lang/String;
    //   111: iload #5
    //   113: aaload
    //   114: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   117: astore #6
    //   119: aload #6
    //   121: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   124: ifne -> 354
    //   127: aload #6
    //   129: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   132: astore #6
    //   134: aload_0
    //   135: ldc 'android.media.metadata.MEDIA_URI'
    //   137: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   140: astore #7
    //   142: aload #7
    //   144: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   147: ifne -> 156
    //   150: aload #7
    //   152: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   155: astore_1
    //   156: new android/support/v4/media/MediaDescriptionCompat$Builder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #7
    //   165: aload #7
    //   167: aload_3
    //   168: invokevirtual setMediaId : (Ljava/lang/String;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   171: pop
    //   172: aload #7
    //   174: aload #4
    //   176: iconst_0
    //   177: aaload
    //   178: invokevirtual setTitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   181: pop
    //   182: aload #7
    //   184: aload #4
    //   186: iconst_1
    //   187: aaload
    //   188: invokevirtual setSubtitle : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   191: pop
    //   192: aload #7
    //   194: aload #4
    //   196: iconst_2
    //   197: aaload
    //   198: invokevirtual setDescription : (Ljava/lang/CharSequence;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   201: pop
    //   202: aload #7
    //   204: aload_2
    //   205: invokevirtual setIconBitmap : (Landroid/graphics/Bitmap;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   208: pop
    //   209: aload #7
    //   211: aload #6
    //   213: invokevirtual setIconUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   216: pop
    //   217: aload #7
    //   219: aload_1
    //   220: invokevirtual setMediaUri : (Landroid/net/Uri;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   223: pop
    //   224: aload_0
    //   225: getfield mBundle : Landroid/os/Bundle;
    //   228: ldc 'android.media.metadata.BT_FOLDER_TYPE'
    //   230: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   233: ifeq -> 264
    //   236: new android/os/Bundle
    //   239: dup
    //   240: invokespecial <init> : ()V
    //   243: astore_2
    //   244: aload_2
    //   245: ldc_w 'android.media.extra.BT_FOLDER_TYPE'
    //   248: aload_0
    //   249: ldc 'android.media.metadata.BT_FOLDER_TYPE'
    //   251: invokevirtual getLong : (Ljava/lang/String;)J
    //   254: invokevirtual putLong : (Ljava/lang/String;J)V
    //   257: aload #7
    //   259: aload_2
    //   260: invokevirtual setExtras : (Landroid/os/Bundle;)Landroid/support/v4/media/MediaDescriptionCompat$Builder;
    //   263: pop
    //   264: aload_0
    //   265: aload #7
    //   267: invokevirtual build : ()Landroid/support/v4/media/MediaDescriptionCompat;
    //   270: putfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   273: aload_0
    //   274: getfield mDescription : Landroid/support/v4/media/MediaDescriptionCompat;
    //   277: astore_2
    //   278: goto -> 14
    //   281: iconst_0
    //   282: istore #8
    //   284: iconst_0
    //   285: istore #5
    //   287: iload #8
    //   289: aload #4
    //   291: arraylength
    //   292: if_icmpge -> 68
    //   295: iload #5
    //   297: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER : [Ljava/lang/String;
    //   300: arraylength
    //   301: if_icmpge -> 68
    //   304: aload_0
    //   305: getstatic android/support/v4/media/MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER : [Ljava/lang/String;
    //   308: iload #5
    //   310: aaload
    //   311: invokevirtual getText : (Ljava/lang/String;)Ljava/lang/CharSequence;
    //   314: astore_2
    //   315: iload #8
    //   317: istore #9
    //   319: aload_2
    //   320: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   323: ifne -> 338
    //   326: aload #4
    //   328: iload #8
    //   330: aload_2
    //   331: aastore
    //   332: iload #8
    //   334: iconst_1
    //   335: iadd
    //   336: istore #9
    //   338: iinc #5, 1
    //   341: iload #9
    //   343: istore #8
    //   345: goto -> 287
    //   348: iinc #5, 1
    //   351: goto -> 71
    //   354: iinc #5, 1
    //   357: goto -> 98
    //   360: aconst_null
    //   361: astore #6
    //   363: goto -> 134
    //   366: aconst_null
    //   367: astore_2
    //   368: goto -> 95
  }
  
  public long getLong(String paramString) {
    return this.mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata() {
    if (this.mMetadataObj != null || Build.VERSION.SDK_INT < 21)
      return this.mMetadataObj; 
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    parcel.setDataPosition(0);
    this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(parcel);
    parcel.recycle();
    return this.mMetadataObj;
  }
  
  public RatingCompat getRating(String paramString) {
    try {
      if (Build.VERSION.SDK_INT >= 19)
        return RatingCompat.fromRating(this.mBundle.getParcelable(paramString)); 
      RatingCompat ratingCompat = (RatingCompat)this.mBundle.getParcelable(paramString);
    } catch (Exception exception) {
      Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception);
      exception = null;
    } 
    return (RatingCompat)exception;
  }
  
  public String getString(String paramString) {
    null = this.mBundle.getCharSequence(paramString);
    return (null != null) ? null.toString() : null;
  }
  
  public CharSequence getText(String paramString) {
    return this.mBundle.getCharSequence(paramString);
  }
  
  public Set<String> keySet() {
    return this.mBundle.keySet();
  }
  
  public int size() {
    return this.mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mBundle);
  }
  
  static {
    METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
    METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
    METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
    METADATA_KEYS_TYPE.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface BitmapKey {}
  
  public static final class Builder {
    private final Bundle mBundle = new Bundle();
    
    public Builder() {}
    
    public Builder(MediaMetadataCompat param1MediaMetadataCompat) {}
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Builder(MediaMetadataCompat param1MediaMetadataCompat, int param1Int) {
      this(param1MediaMetadataCompat);
      for (String str : this.mBundle.keySet()) {
        Object object = this.mBundle.get(str);
        if (object != null && object instanceof Bitmap) {
          object = object;
          if (object.getHeight() > param1Int || object.getWidth() > param1Int) {
            putBitmap(str, scaleBitmap((Bitmap)object, param1Int));
            continue;
          } 
          if (Build.VERSION.SDK_INT >= 14 && (str.equals("android.media.metadata.ART") || str.equals("android.media.metadata.ALBUM_ART")))
            putBitmap(str, object.copy(object.getConfig(), false)); 
        } 
      } 
    }
    
    private Bitmap scaleBitmap(Bitmap param1Bitmap, int param1Int) {
      float f = param1Int;
      f = Math.min(f / param1Bitmap.getWidth(), f / param1Bitmap.getHeight());
      param1Int = (int)(param1Bitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(param1Bitmap, (int)(f * param1Bitmap.getWidth()), param1Int, true);
    }
    
    public MediaMetadataCompat build() {
      return new MediaMetadataCompat(this.mBundle);
    }
    
    public Builder putBitmap(String param1String, Bitmap param1Bitmap) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 2)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a Bitmap"); 
      this.mBundle.putParcelable(param1String, (Parcelable)param1Bitmap);
      return this;
    }
    
    public Builder putLong(String param1String, long param1Long) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 0)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a long"); 
      this.mBundle.putLong(param1String, param1Long);
      return this;
    }
    
    public Builder putRating(String param1String, RatingCompat param1RatingCompat) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 3)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a Rating"); 
      if (Build.VERSION.SDK_INT >= 19) {
        this.mBundle.putParcelable(param1String, (Parcelable)param1RatingCompat.getRating());
        return this;
      } 
      this.mBundle.putParcelable(param1String, param1RatingCompat);
      return this;
    }
    
    public Builder putString(String param1String1, String param1String2) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String1)).intValue() != 1)
        throw new IllegalArgumentException("The " + param1String1 + " key cannot be used to put a String"); 
      this.mBundle.putCharSequence(param1String1, param1String2);
      return this;
    }
    
    public Builder putText(String param1String, CharSequence param1CharSequence) {
      if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(param1String) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(param1String)).intValue() != 1)
        throw new IllegalArgumentException("The " + param1String + " key cannot be used to put a CharSequence"); 
      this.mBundle.putCharSequence(param1String, param1CharSequence);
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface LongKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface RatingKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TextKey {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\media\MediaMetadataCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */