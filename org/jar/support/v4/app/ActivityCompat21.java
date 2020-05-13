package org.jar.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.session.MediaController;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

@TargetApi(21)
class ActivityCompat21 {
  private static SharedElementCallback createCallback(SharedElementCallback21 paramSharedElementCallback21) {
    if (paramSharedElementCallback21 != null) {
      SharedElementCallbackImpl sharedElementCallbackImpl = new SharedElementCallbackImpl(paramSharedElementCallback21);
    } else {
      paramSharedElementCallback21 = null;
    } 
    return (SharedElementCallback)paramSharedElementCallback21;
  }
  
  public static void finishAfterTransition(Activity paramActivity) {
    paramActivity.finishAfterTransition();
  }
  
  public static void postponeEnterTransition(Activity paramActivity) {
    paramActivity.postponeEnterTransition();
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21) {
    paramActivity.setEnterSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback21 paramSharedElementCallback21) {
    paramActivity.setExitSharedElementCallback(createCallback(paramSharedElementCallback21));
  }
  
  public static void setMediaController(Activity paramActivity, Object paramObject) {
    paramActivity.setMediaController((MediaController)paramObject);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity) {
    paramActivity.startPostponedEnterTransition();
  }
  
  public static abstract class SharedElementCallback21 {
    public abstract Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF);
    
    public abstract View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable);
    
    public abstract void onMapSharedElements(List<String> param1List, Map<String, View> param1Map);
    
    public abstract void onRejectSharedElements(List<View> param1List);
    
    public abstract void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2);
    
    public abstract void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2);
  }
  
  private static class SharedElementCallbackImpl extends SharedElementCallback {
    private ActivityCompat21.SharedElementCallback21 mCallback;
    
    public SharedElementCallbackImpl(ActivityCompat21.SharedElementCallback21 param1SharedElementCallback21) {
      this.mCallback = param1SharedElementCallback21;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF) {
      return this.mCallback.onCaptureSharedElementSnapshot(param1View, param1Matrix, param1RectF);
    }
    
    public View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable) {
      return this.mCallback.onCreateSnapshotView(param1Context, param1Parcelable);
    }
    
    public void onMapSharedElements(List<String> param1List, Map<String, View> param1Map) {
      this.mCallback.onMapSharedElements(param1List, param1Map);
    }
    
    public void onRejectSharedElements(List<View> param1List) {
      this.mCallback.onRejectSharedElements(param1List);
    }
    
    public void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementEnd(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.mCallback.onSharedElementStart(param1List, param1List1, param1List2);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\ActivityCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */