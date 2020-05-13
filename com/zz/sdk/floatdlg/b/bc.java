package com.zz.sdk.floatdlg.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.da;
import com.zz.sdk.a.gt;
import com.zz.sdk.h.f;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import java.util.Map;

public class bc extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
  private t a;
  
  private int b;
  
  private Switch c;
  
  private Switch d;
  
  private TextView e;
  
  private String f;
  
  private Context g;
  
  private TextView h;
  
  public static bc a(String paramString) {
    bc bc1 = new bc();
    Bundle bundle = new Bundle();
    bundle.putString("account", paramString);
    bc1.setArguments(bundle);
    return bc1;
  }
  
  private void a(View paramView) {
    try {
      this.f = getArguments().getString("account");
      this.h = (TextView)paramView.findViewById(ci.a(this.g, 2131296604));
      this.h.setText("v3.4.4");
      paramView.findViewById(ci.a(this.g, 2131296508)).setOnClickListener(this);
      paramView.findViewById(ci.a(this.g, 2131296564)).setOnClickListener(this);
      paramView.findViewById(ci.a(this.g, 2131296565)).setOnClickListener(this);
      paramView.findViewById(ci.a(this.g, 2131296602)).setOnClickListener(this);
      paramView.findViewById(ci.a(this.g, 2131296603)).setOnClickListener(this);
      this.c = (Switch)paramView.findViewById(ci.a(this.g, 2131296599));
      if (cm.c(this.g, cq.a(this.g).s()) == 1) {
        this.c.setChecked(true);
      } else {
        this.c.setChecked(false);
      } 
      this.c.setOnCheckedChangeListener(this);
      this.d = (Switch)paramView.findViewById(ci.a(this.g, 2131296601));
      this.d.setOnCheckedChangeListener(this);
      if (SDKManager.isShowFloat())
        if (f.b((Activity)getActivity()).c()) {
          this.d.setChecked(false);
        } else {
          this.d.setChecked(true);
        }  
      this.e = (TextView)paramView.findViewById(ci.a(this.g, 2131296563));
    } catch (Exception exception) {}
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    this.a = t.a((Context)getActivity());
    int i = paramCompoundButton.getId();
    if (i == ci.a(this.g, 2131296599)) {
      if (paramBoolean) {
        this.b = 1;
      } else {
        this.b = 0;
      } 
      (new Thread(new bd(this))).start();
      return;
    } 
    if (i == ci.a(this.g, 2131296601)) {
      if (paramBoolean) {
        SDKManager.tryShowFloat((Activity)getActivity(), null);
        return;
      } 
      SDKManager.tryHideFloat((Activity)getActivity());
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == ci.a(this.g, 2131296508) || i == ci.a(this.g, 2131296564)) {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
      return;
    } 
    if (i == ci.a(this.g, 2131296565)) {
      if (this.e.getText().toString().equals("帮助中心")) {
        this.e.setText("设置");
        return;
      } 
      getActivity().getSupportFragmentManager().popBackStack();
      return;
    } 
    if (i == ci.a(this.g, 2131296602)) {
      bv.a(false);
      bv.a((Activity)getActivity(), da.class, (Map)bv.a().a("account", this.f), false);
      return;
    } 
    if (i == ci.a(this.g, 2131296603)) {
      bv.a(false);
      bv.a((Activity)getActivity(), gt.class, (Map)bv.a());
    } 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.g = (Context)getActivity();
    View view = paramLayoutInflater.inflate(ci.a(this.g, 2130903122), paramViewGroup, false);
    a(view);
    return view;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */