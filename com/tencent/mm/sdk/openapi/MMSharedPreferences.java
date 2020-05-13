package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.c.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences implements SharedPreferences {
  private final String[] columns = new String[] { "_id", "key", "type", "value" };
  
  private final ContentResolver cr;
  
  private REditor editor = null;
  
  private final HashMap<String, Object> values = new HashMap<String, Object>();
  
  public MMSharedPreferences(Context paramContext) {
    this.cr = paramContext.getContentResolver();
  }
  
  private Object getValue(String paramString) {
    try {
      Cursor cursor = this.cr.query(a.b.CONTENT_URI, this.columns, "key = ?", new String[] { paramString }, null);
      if (cursor == null)
        return null; 
      int i = cursor.getColumnIndex("type");
      int j = cursor.getColumnIndex("value");
      if (cursor.moveToFirst()) {
        object = a.a.a(cursor.getInt(i), cursor.getString(j));
      } else {
        paramString = null;
      } 
      cursor.close();
    } catch (Exception object) {
      object.printStackTrace();
      object = null;
    } 
    return object;
  }
  
  public boolean contains(String paramString) {
    return (getValue(paramString) != null);
  }
  
  public SharedPreferences.Editor edit() {
    if (this.editor == null)
      this.editor = new REditor(this.cr); 
    return this.editor;
  }
  
  public Map<String, ?> getAll() {
    try {
      Cursor cursor = this.cr.query(a.b.CONTENT_URI, this.columns, null, null, null);
      if (cursor == null)
        return null; 
      int i = cursor.getColumnIndex("key");
      int j = cursor.getColumnIndex("type");
      int k = cursor.getColumnIndex("value");
      while (cursor.moveToNext()) {
        Object object = a.a.a(cursor.getInt(j), cursor.getString(k));
        this.values.put(cursor.getString(i), object);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return this.values;
    } 
    SYNTHETIC_LOCAL_VARIABLE_1.close();
    return this.values;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean) {
    Object object = getValue(paramString);
    boolean bool = paramBoolean;
    if (object != null) {
      bool = paramBoolean;
      if (object instanceof Boolean)
        bool = ((Boolean)object).booleanValue(); 
    } 
    return bool;
  }
  
  public float getFloat(String paramString, float paramFloat) {
    Object object = getValue(paramString);
    float f = paramFloat;
    if (object != null) {
      f = paramFloat;
      if (object instanceof Float)
        f = ((Float)object).floatValue(); 
    } 
    return f;
  }
  
  public int getInt(String paramString, int paramInt) {
    Object object = getValue(paramString);
    int i = paramInt;
    if (object != null) {
      i = paramInt;
      if (object instanceof Integer)
        i = ((Integer)object).intValue(); 
    } 
    return i;
  }
  
  public long getLong(String paramString, long paramLong) {
    Object object = getValue(paramString);
    long l = paramLong;
    if (object != null) {
      l = paramLong;
      if (object instanceof Long)
        l = ((Long)object).longValue(); 
    } 
    return l;
  }
  
  public String getString(String paramString1, String paramString2) {
    null = getValue(paramString1);
    return (null != null && null instanceof String) ? (String)null : paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet) {
    return null;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  private static class REditor implements SharedPreferences.Editor {
    private boolean clear = false;
    
    private ContentResolver cr;
    
    private Set<String> remove = new HashSet<String>();
    
    private Map<String, Object> values = new HashMap<String, Object>();
    
    public REditor(ContentResolver param1ContentResolver) {
      this.cr = param1ContentResolver;
    }
    
    public void apply() {}
    
    public SharedPreferences.Editor clear() {
      this.clear = true;
      return this;
    }
    
    public boolean commit() {
      ContentValues contentValues = new ContentValues();
      if (this.clear) {
        this.cr.delete(a.b.CONTENT_URI, null, null);
        this.clear = false;
      } 
      for (String str : this.remove) {
        this.cr.delete(a.b.CONTENT_URI, "key = ?", new String[] { str });
      } 
      for (Map.Entry<String, Object> entry : this.values.entrySet()) {
        boolean bool;
        Object object = entry.getValue();
        if (object == null) {
          a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
          bool = false;
        } else if (object instanceof Integer) {
          bool = true;
        } else if (object instanceof Long) {
          bool = true;
        } else if (object instanceof String) {
          bool = true;
        } else if (object instanceof Boolean) {
          bool = true;
        } else if (object instanceof Float) {
          bool = true;
        } else if (object instanceof Double) {
          bool = true;
        } else {
          a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + object.getClass().toString());
          bool = false;
        } 
        if (!bool) {
          bool = false;
        } else {
          contentValues.put("type", Integer.valueOf(bool));
          contentValues.put("value", object.toString());
          bool = true;
        } 
        if (bool)
          this.cr.update(a.b.CONTENT_URI, contentValues, "key = ?", new String[] { (String)entry.getKey() }); 
      } 
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(String param1String, boolean param1Boolean) {
      this.values.put(param1String, Boolean.valueOf(param1Boolean));
      this.remove.remove(param1String);
      return this;
    }
    
    public SharedPreferences.Editor putFloat(String param1String, float param1Float) {
      this.values.put(param1String, Float.valueOf(param1Float));
      this.remove.remove(param1String);
      return this;
    }
    
    public SharedPreferences.Editor putInt(String param1String, int param1Int) {
      this.values.put(param1String, Integer.valueOf(param1Int));
      this.remove.remove(param1String);
      return this;
    }
    
    public SharedPreferences.Editor putLong(String param1String, long param1Long) {
      this.values.put(param1String, Long.valueOf(param1Long));
      this.remove.remove(param1String);
      return this;
    }
    
    public SharedPreferences.Editor putString(String param1String1, String param1String2) {
      this.values.put(param1String1, param1String2);
      this.remove.remove(param1String1);
      return this;
    }
    
    public SharedPreferences.Editor putStringSet(String param1String, Set<String> param1Set) {
      return null;
    }
    
    public SharedPreferences.Editor remove(String param1String) {
      this.remove.add(param1String);
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\openapi\MMSharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */