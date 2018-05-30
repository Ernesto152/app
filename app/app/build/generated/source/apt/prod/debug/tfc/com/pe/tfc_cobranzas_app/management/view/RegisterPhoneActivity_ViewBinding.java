// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.management.view;

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
import tfc.com.pe.tfc_cobranzas_app.management.view.ui.TelephoneReferenceActivity;

public class RegisterPhoneActivity_ViewBinding implements Unbinder {
  private TelephoneReferenceActivity target;

  @UiThread
  public RegisterPhoneActivity_ViewBinding(TelephoneReferenceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterPhoneActivity_ViewBinding(TelephoneReferenceActivity target, View source) {
    this.target = target;

    target.contactNameEditText = Utils.findRequiredViewAsType(source, R.id.contactNameEditText, "field 'contactNameEditText'", EditText.class);
    target.economicActivityEditText = Utils.findRequiredViewAsType(source, R.id.economicActivityEditText, "field 'economicActivityEditText'", EditText.class);
    target.typeKinButton = Utils.findRequiredViewAsType(source, R.id.typeKinButton, "field 'typeKinButton'", Button.class);
    target.typePhoneButton = Utils.findRequiredViewAsType(source, R.id.typePhoneButton, "field 'typePhoneButton'", Button.class);
    target.registerPhoneReferenceButton = Utils.findRequiredViewAsType(source, R.id.registerPhoneReferenceButton, "field 'registerPhoneReferenceButton'", Button.class);
    target.checkTypeKinImageView = Utils.findRequiredViewAsType(source, R.id.checkTypeKinImageView, "field 'checkTypeKinImageView'", ImageView.class);
    target.checkTypePhoneImageView = Utils.findRequiredViewAsType(source, R.id.checkTypePhoneImageView, "field 'checkTypePhoneImageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TelephoneReferenceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.contactNameEditText = null;
    target.economicActivityEditText = null;
    target.typeKinButton = null;
    target.typePhoneButton = null;
    target.registerPhoneReferenceButton = null;
    target.checkTypeKinImageView = null;
    target.checkTypePhoneImageView = null;
  }
}
