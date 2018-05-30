// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.portfolio.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;

public class CustomerDetailActivity_ViewBinding implements Unbinder {
  private CustomerDetailActivity target;

  @UiThread
  public CustomerDetailActivity_ViewBinding(CustomerDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomerDetailActivity_ViewBinding(CustomerDetailActivity target, View source) {
    this.target = target;

    target.visitButton = Utils.findRequiredViewAsType(source, R.id.visitButton, "field 'visitButton'", Button.class);
    target.notVisitButton = Utils.findRequiredViewAsType(source, R.id.notVisitButton, "field 'notVisitButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.visitButton = null;
    target.notVisitButton = null;
  }
}
