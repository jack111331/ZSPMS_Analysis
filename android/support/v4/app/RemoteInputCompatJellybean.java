package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(16)
@RequiresApi(16)
class RemoteInputCompatJellybean {
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  
  private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
  
  private static final String KEY_CHOICES = "choices";
  
  private static final String KEY_EXTRAS = "extras";
  
  private static final String KEY_LABEL = "label";
  
  private static final String KEY_RESULT_KEY = "resultKey";
  
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  
  static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle) {
    Bundle bundle = new Bundle();
    int i = paramArrayOfRemoteInput.length;
    for (byte b = 0; b < i; b++) {
      RemoteInputCompatBase.RemoteInput remoteInput = paramArrayOfRemoteInput[b];
      Object object = paramBundle.get(remoteInput.getResultKey());
      if (object instanceof CharSequence)
        bundle.putCharSequence(remoteInput.getResultKey(), (CharSequence)object); 
    } 
    Intent intent = new Intent();
    intent.putExtra("android.remoteinput.resultsData", bundle);
    paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", intent));
  }
  
  static RemoteInputCompatBase.RemoteInput fromBundle(Bundle paramBundle, RemoteInputCompatBase.RemoteInput$Factory paramRemoteInput$Factory) {
    return paramRemoteInput$Factory.build(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), paramBundle.getBundle("extras"));
  }
  
  static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] paramArrayOfBundle, RemoteInputCompatBase.RemoteInput$Factory paramRemoteInput$Factory) {
    if (paramArrayOfBundle == null)
      return null; 
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramRemoteInput$Factory.newArray(paramArrayOfBundle.length);
    for (byte b = 0; b < paramArrayOfBundle.length; b++)
      arrayOfRemoteInput[b] = fromBundle(paramArrayOfBundle[b], paramRemoteInput$Factory); 
    return arrayOfRemoteInput;
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent) {
    null = paramIntent.getClipData();
    if (null != null) {
      ClipDescription clipDescription = null.getDescription();
      if (clipDescription.hasMimeType("text/vnd.android.intent") && clipDescription.getLabel().equals("android.remoteinput.results"))
        return (Bundle)null.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData"); 
    } 
    return null;
  }
  
  static Bundle toBundle(RemoteInputCompatBase.RemoteInput paramRemoteInput) {
    Bundle bundle = new Bundle();
    bundle.putString("resultKey", paramRemoteInput.getResultKey());
    bundle.putCharSequence("label", paramRemoteInput.getLabel());
    bundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    bundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    bundle.putBundle("extras", paramRemoteInput.getExtras());
    return bundle;
  }
  
  static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    for (byte b = 0; b < paramArrayOfRemoteInput.length; b++)
      arrayOfBundle[b] = toBundle(paramArrayOfRemoteInput[b]); 
    return arrayOfBundle;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\app\RemoteInputCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */