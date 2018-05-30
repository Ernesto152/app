// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.management.view.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;

public class HomeReferenceActivity_ViewBinding implements Unbinder {
  private HomeReferenceActivity target;

  @UiThread
  public HomeReferenceActivity_ViewBinding(HomeReferenceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeReferenceActivity_ViewBinding(HomeReferenceActivity target, View source) {
    this.target = target;

    target.contactNameEditText = Utils.findRequiredViewAsType(source, R.id.contactNameEditText, "field 'contactNameEditText'", EditText.class);
    target.addressEditText = Utils.findRequiredViewAsType(source, R.id.addressEditText, "field 'addressEditText'", EditText.class);
    target.typeAddressButton = Utils.findRequiredViewAsType(source, R.id.typeAddressButton, "field 'typeAddressButton'", Button.class);
    target.registerAddressReferenceButton = Utils.findRequiredViewAsType(source, R.id.registerAddressReferenceButton, "field 'registerAddressReferenceButton'", Button.class);
    target.checkTypeAddressImageView = Utils.findRequiredViewAsType(source, R.id.checkTypeAddressImageView, "field 'checkTypeAddressImageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeReferenceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactNameEditText = null;
    target.addressEditText = null;
    target.typeAddressButton = null;
    target.registerAddressReferenceButton = null;
    target.checkTypeAddressImageView = null;
  }
}
