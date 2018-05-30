// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.user.account.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;

public class AccountsFragment_ViewBinding implements Unbinder {
  private AccountsFragment target;

  @UiThread
  public AccountsFragment_ViewBinding(AccountsFragment target, View source) {
    this.target = target;

    target.exchangeRateTextView = Utils.findRequiredViewAsType(source, R.id.exchangeRateTextView, "field 'exchangeRateTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccountsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.exchangeRateTextView = null;
  }
}
