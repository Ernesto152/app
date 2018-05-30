// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.user.login.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.dniEditText = Utils.findRequiredViewAsType(source, R.id.dniEditText, "field 'dniEditText'", EditText.class);
    target.passwordEditText = Utils.findRequiredViewAsType(source, R.id.passwordEditText, "field 'passwordEditText'", EditText.class);
    target.logInButton = Utils.findRequiredViewAsType(source, R.id.logInButton, "field 'logInButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dniEditText = null;
    target.passwordEditText = null;
    target.logInButton = null;
  }
}
