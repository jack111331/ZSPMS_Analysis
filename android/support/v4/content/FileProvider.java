package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
  private static final String ATTR_NAME = "name";
  
  private static final String ATTR_PATH = "path";
  
  private static final String[] COLUMNS = new String[] { "_display_name", "_size" };
  
  private static final File DEVICE_ROOT = new File("/");
  
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  
  private static final String TAG_CACHE_PATH = "cache-path";
  
  private static final String TAG_EXTERNAL = "external-path";
  
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  
  private static final String TAG_FILES_PATH = "files-path";
  
  private static final String TAG_ROOT_PATH = "root-path";
  
  private static HashMap<String, PathStrategy> sCache = new HashMap<String, PathStrategy>();
  
  private PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      String str = paramVarArgs[b];
      if (str != null)
        paramFile = new File(paramFile, str); 
    } 
    return paramFile;
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt) {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static PathStrategy getPathStrategy(Context paramContext, String paramString) {
    synchronized (sCache) {
      PathStrategy pathStrategy1 = sCache.get(paramString);
      PathStrategy pathStrategy2 = pathStrategy1;
      if (pathStrategy1 == null)
        try {
          pathStrategy2 = parsePathStrategy(paramContext, paramString);
          sCache.put(paramString, pathStrategy2);
          return pathStrategy2;
        } catch (IOException iOException) {
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException);
          throw illegalArgumentException;
        } catch (XmlPullParserException xmlPullParserException) {
          IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
          this("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)xmlPullParserException);
          throw illegalArgumentException;
        }  
      return pathStrategy2;
    } 
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile) {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString) {
    if ("r".equals(paramString))
      return 268435456; 
    if ("w".equals(paramString) || "wt".equals(paramString))
      return 738197504; 
    if ("wa".equals(paramString))
      return 704643072; 
    if ("rw".equals(paramString))
      return 939524096; 
    if ("rwt".equals(paramString))
      return 1006632960; 
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static PathStrategy parsePathStrategy(Context paramContext, String paramString) {
    SimplePathStrategy simplePathStrategy = new SimplePathStrategy(paramString);
    XmlResourceParser xmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (xmlResourceParser == null)
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data"); 
    while (true) {
      int i = xmlResourceParser.next();
      if (i != 1) {
        if (i == 2) {
          paramString = xmlResourceParser.getName();
          String str1 = xmlResourceParser.getAttributeValue(null, "name");
          String str2 = xmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(paramString)) {
            file = DEVICE_ROOT;
            continue;
          } 
          if ("files-path".equals(file)) {
            file = paramContext.getFilesDir();
            continue;
          } 
          if ("cache-path".equals(file)) {
            file = paramContext.getCacheDir();
            continue;
          } 
          if ("external-path".equals(file)) {
            file = Environment.getExternalStorageDirectory();
            continue;
          } 
          if ("external-files-path".equals(file)) {
            File[] arrayOfFile = ContextCompat.getExternalFilesDirs(paramContext, null);
            if (arrayOfFile.length > 0) {
              file = arrayOfFile[0];
              continue;
            } 
          } else if ("external-cache-path".equals(file)) {
            File[] arrayOfFile = ContextCompat.getExternalCacheDirs(paramContext);
            if (arrayOfFile.length > 0) {
              File file1 = arrayOfFile[0];
              continue;
            } 
          } 
          File file = null;
          continue;
        } 
        continue;
      } 
      return simplePathStrategy;
      if (paramString != null)
        simplePathStrategy.addRoot((String)SYNTHETIC_LOCAL_VARIABLE_4, buildPath((File)paramString, new String[] { (String)SYNTHETIC_LOCAL_VARIABLE_5 })); 
    } 
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo) {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported)
      throw new SecurityException("Provider must not be exported"); 
    if (!paramProviderInfo.grantUriPermissions)
      throw new SecurityException("Provider must grant uri permissions"); 
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    return this.mStrategy.getFileForUri(paramUri).delete() ? 1 : 0;
  }
  
  public String getType(Uri paramUri) {
    File file = this.mStrategy.getFileForUri(paramUri);
    int i = file.getName().lastIndexOf('.');
    if (i >= 0) {
      String str = file.getName().substring(i + 1);
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
      if (str != null)
        return str; 
    } 
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate() {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString) {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    int i = 0;
    File file = this.mStrategy.getFileForUri(paramUri);
    String[] arrayOfString1 = paramArrayOfString1;
    if (paramArrayOfString1 == null)
      arrayOfString1 = COLUMNS; 
    String[] arrayOfString3 = new String[arrayOfString1.length];
    Object[] arrayOfObject2 = new Object[arrayOfString1.length];
    int j = arrayOfString1.length;
    for (byte b = 0; b < j; b++) {
      String str = arrayOfString1[b];
      if ("_display_name".equals(str)) {
        arrayOfString3[i] = "_display_name";
        int k = i + 1;
        arrayOfObject2[i] = file.getName();
        i = k;
      } else if ("_size".equals(str)) {
        arrayOfString3[i] = "_size";
        int k = i + 1;
        arrayOfObject2[i] = Long.valueOf(file.length());
        i = k;
      } 
    } 
    String[] arrayOfString2 = copyOf(arrayOfString3, i);
    Object[] arrayOfObject1 = copyOf(arrayOfObject2, i);
    MatrixCursor matrixCursor = new MatrixCursor(arrayOfString2, 1);
    matrixCursor.addRow(arrayOfObject1);
    return (Cursor)matrixCursor;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static interface PathStrategy {
    File getFileForUri(Uri param1Uri);
    
    Uri getUriForFile(File param1File);
  }
  
  static class SimplePathStrategy implements PathStrategy {
    private final String mAuthority;
    
    private final HashMap<String, File> mRoots = new HashMap<String, File>();
    
    public SimplePathStrategy(String param1String) {
      this.mAuthority = param1String;
    }
    
    public void addRoot(String param1String, File param1File) {
      if (TextUtils.isEmpty(param1String))
        throw new IllegalArgumentException("Name must not be empty"); 
      try {
        File file = param1File.getCanonicalFile();
        this.mRoots.put(param1String, file);
        return;
      } catch (IOException iOException) {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + param1File, iOException);
      } 
    }
    
    public File getFileForUri(Uri param1Uri) {
      File file2;
      String str1 = param1Uri.getEncodedPath();
      int i = str1.indexOf('/', 1);
      String str2 = Uri.decode(str1.substring(1, i));
      str1 = Uri.decode(str1.substring(i + 1));
      File file3 = this.mRoots.get(str2);
      if (file3 == null)
        throw new IllegalArgumentException("Unable to find configured root for " + param1Uri); 
      File file1 = new File(file3, str1);
      try {
        file2 = file1.getCanonicalFile();
        if (!file2.getPath().startsWith(file3.getPath()))
          throw new SecurityException("Resolved path jumped beyond configured root"); 
      } catch (IOException iOException) {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + file1);
      } 
      return file2;
    }
    
    public Uri getUriForFile(File param1File) {
      Object object;
      try {
        String str = param1File.getCanonicalPath();
        Iterator<Map.Entry> iterator = this.mRoots.entrySet().iterator();
        param1File = null;
        while (true) {
          if (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String str1 = ((File)entry.getValue()).getPath();
            if (str.startsWith(str1)) {
              Map.Entry entry1 = entry;
              if (object != null) {
                if (str1.length() > ((File)object.getValue()).getPath().length()) {
                  entry1 = entry;
                  continue;
                } 
              } else {
                continue;
              } 
            } 
          } else {
            if (object == null)
              throw new IllegalArgumentException("Failed to find configured root that contains " + str); 
            String str1 = ((File)object.getValue()).getPath();
            if (str1.endsWith("/")) {
              str1 = str.substring(str1.length());
              object = Uri.encode((String)object.getKey()) + '/' + Uri.encode(str1, "/");
              return (new Uri.Builder()).scheme("content").authority(this.mAuthority).encodedPath((String)object).build();
            } 
            str1 = str.substring(str1.length() + 1);
            object = Uri.encode((String)object.getKey()) + '/' + Uri.encode(str1, "/");
            return (new Uri.Builder()).scheme("content").authority(this.mAuthority).encodedPath((String)object).build();
          } 
          Object object1 = object;
          continue;
          object = SYNTHETIC_LOCAL_VARIABLE_6;
        } 
      } catch (IOException iOException) {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + object);
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\FileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */