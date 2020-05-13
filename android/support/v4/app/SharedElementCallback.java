package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
  private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
  
  private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
  
  private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
  
  private static int MAX_IMAGE_SIZE = 1048576;
  
  private Matrix mTempMatrix;
  
  private static Bitmap createDrawableBitmap(Drawable paramDrawable) {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i <= 0 || j <= 0)
      return null; 
    float f = Math.min(1.0F, MAX_IMAGE_SIZE / (i * j));
    if (paramDrawable instanceof BitmapDrawable && f == 1.0F)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    i = (int)(i * f);
    int k = (int)(j * f);
    Bitmap bitmap = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Rect rect = paramDrawable.getBounds();
    int m = rect.left;
    j = rect.top;
    int n = rect.right;
    int i1 = rect.bottom;
    paramDrawable.setBounds(0, 0, i, k);
    paramDrawable.draw(canvas);
    paramDrawable.setBounds(m, j, n, i1);
    return bitmap;
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF) {
    float[] arrayOfFloat;
    if (paramView instanceof ImageView) {
      ImageView imageView = (ImageView)paramView;
      Drawable drawable1 = imageView.getDrawable();
      Drawable drawable2 = imageView.getBackground();
      if (drawable1 != null && drawable2 == null) {
        Bitmap bitmap = createDrawableBitmap(drawable1);
        if (bitmap != null) {
          null = new Bundle();
          null.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)bitmap);
          null.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
          if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            paramMatrix = imageView.getImageMatrix();
            arrayOfFloat = new float[9];
            paramMatrix.getValues(arrayOfFloat);
            null.putFloatArray("sharedElement:snapshot:imageMatrix", arrayOfFloat);
          } 
          return (Parcelable)null;
        } 
      } 
    } 
    int i = Math.round(arrayOfFloat.width());
    int j = Math.round(arrayOfFloat.height());
    if (i > 0 && j > 0) {
      float f = Math.min(1.0F, MAX_IMAGE_SIZE / (i * j));
      i = (int)(i * f);
      j = (int)(j * f);
      if (this.mTempMatrix == null)
        this.mTempMatrix = new Matrix(); 
      this.mTempMatrix.set(paramMatrix);
      this.mTempMatrix.postTranslate(-((RectF)arrayOfFloat).left, -((RectF)arrayOfFloat).top);
      this.mTempMatrix.postScale(f, f);
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      canvas.concat(this.mTempMatrix);
      null.draw(canvas);
      return (Parcelable)bitmap;
    } 
    return null;
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable) {
    Matrix matrix;
    Context context = null;
    if (paramParcelable instanceof Bundle) {
      Bundle bundle = (Bundle)paramParcelable;
      Bitmap bitmap = (Bitmap)bundle.getParcelable("sharedElement:snapshot:bitmap");
      if (bitmap == null)
        return (View)context; 
      null = new ImageView(paramContext);
      null.setImageBitmap(bitmap);
      null.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
      if (null.getScaleType() == ImageView.ScaleType.MATRIX) {
        float[] arrayOfFloat = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
        matrix = new Matrix();
        matrix.setValues(arrayOfFloat);
        null.setImageMatrix(matrix);
      } 
      return (View)null;
    } 
    if (matrix instanceof Bitmap) {
      Bitmap bitmap = (Bitmap)matrix;
      null = new ImageView((Context)null);
      null.setImageBitmap(bitmap);
      return (View)null;
    } 
    return null;
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public void onRejectSharedElements(List<View> paramList) {}
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, OnSharedElementsReadyListener paramOnSharedElementsReadyListener) {
    paramOnSharedElementsReadyListener.onSharedElementsReady();
  }
  
  public static interface OnSharedElementsReadyListener {
    void onSharedElementsReady();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\SharedElementCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */