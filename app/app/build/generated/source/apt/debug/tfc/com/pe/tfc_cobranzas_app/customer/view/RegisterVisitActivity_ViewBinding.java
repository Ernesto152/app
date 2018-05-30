// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.portfolio.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;
import tfc.com.pe.tfc_cobranzas_app.management.view.RegisterVisitActivity;

public class RegisterVisitActivity_ViewBinding implements Unbinder {
  private RegisterVisitActivity target;

  @UiThread
  public RegisterVisitActivity_ViewBinding(RegisterVisitActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterVisitActivity_ViewBinding(RegisterVisitActivity target, View source) {
    this.target = target;

    target.typeManagementButton = Utils.findRequiredViewAsType(source, R.id.typeManagementButton, "field 'typeManagementButton'", Button.class);
    target.responseManagementButton = Utils.findRequiredViewAsType(source, R.id.responseManagementButton, "field 'responseManagementButton'", Button.class);
    target.takePhotoButton = Utils.findRequiredViewAsType(source, R.id.takePhotoButton, "field 'takePhotoButton'", Button.class);
    target.getLocationButton = Utils.findRequiredViewAsType(source, R.id.getLocationButton, "field 'getLocationButton'", Button.class);
    target.pictureImageView = Utils.findRequiredViewAsType(source, R.id.pictureImageView, "field 'pictureImageView'", ImageView.class);
    target.layout = Utils.findRequiredViewAsType(source, R.id.registerVisitLinerLayout, "field 'layout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterVisitActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.typeManagementButton = null;
    target.responseManagementButton = null;
    target.takePhotoButton = null;
    target.getLocationButton = null;
    target.pictureImageView = null;
    target.layout = null;
  }
}
