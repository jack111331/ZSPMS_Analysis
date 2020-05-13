package org.jar.photo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import org.jar.bloc.R;
import org.jar.bloc.utils.ResUtils;
import org.jar.photo.bean.EntityVideo;

public class VideoPlayActivity extends Activity implements MediaPlayer.OnCompletionListener, View.OnClickListener {
  private boolean a = false;
  
  private TextView b;
  
  private TextView c;
  
  private ImageView d;
  
  private LinearLayout e;
  
  private EntityVideo f;
  
  private VideoView g;
  
  private boolean h = false;
  
  public void onClick(View paramView) {
    if (paramView != this.b) {
      Intent intent;
      if (paramView == this.c) {
        if (this.c.getText().toString().equals("确定")) {
          this.a = this.g.isPlaying();
          intent = new Intent((Context)this, ThumbSelectActivity.class);
          intent.putExtra("entity_video", (Parcelable)this.f);
          setResult(1005, intent);
        } else {
          return;
        } 
      } else {
        if (intent == this.d) {
          this.d.setVisibility(8);
          this.g.start();
        } 
        return;
      } 
    } 
    finish();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    this.d.setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(ResUtils.id((Context)this, R.layout.bloc_photo_video_play_layout));
    this.b = (TextView)findViewById(ResUtils.id((Context)this, R.id.txt_back));
    this.c = (TextView)findViewById(ResUtils.id((Context)this, R.id.txt_confirm));
    this.d = (ImageView)findViewById(ResUtils.id((Context)this, R.id.img_play));
    this.e = (LinearLayout)findViewById(ResUtils.id((Context)this, R.id.layout_videoView));
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    Intent intent = getIntent();
    this.h = intent.getBooleanExtra("btn_dismiss", false);
    if (this.h) {
      this.c.setVisibility(8);
      this.b.setText("返回");
    } 
    this.f = (EntityVideo)intent.getParcelableExtra("videoResult");
    this.g = new VideoView(getApplicationContext());
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.e.addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
    this.g.setVideoPath(this.f.b());
    this.g.start();
    this.g.setOnCompletionListener(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\photo\activity\VideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */