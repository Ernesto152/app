// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.portfolio.view.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    target.customerNameTextView = Utils.findRequiredViewAsType(source, R.id.customerNameTextView, "field 'customerNameTextView'", TextView.class);
    target.creditNumberTextView = Utils.findRequiredViewAsType(source, R.id.creditNumberTextView, "field 'creditNumberTextView'", TextView.class);
    target.customerAddressTextView = Utils.findRequiredViewAsType(source, R.id.customerAddressTextView, "field 'customerAddressTextView'", TextView.class);
    target.capitalBalanceTextView = Utils.findRequiredViewAsType(source, R.id.capitalBalanceTextView, "field 'capitalBalanceTextView'", TextView.class);
    target.amountReceivableTextView = Utils.findRequiredViewAsType(source, R.id.amountReceivableTextView, "field 'amountReceivableTextView'", TextView.class);
    target.shareRatioTextView = Utils.findRequiredViewAsType(source, R.id.shareRatioTextView, "field 'shareRatioTextView'", TextView.class);
    target.daysDelayTextView = Utils.findRequiredViewAsType(source, R.id.daysDelayTextView, "field 'daysDelayTextView'", TextView.class);
    target.expirationDateFirstSubscriptionTextView = Utils.findRequiredViewAsType(source, R.id.expirationDateFirstSubscriptionTextView, "field 'expirationDateFirstSubscriptionTextView'", TextView.class);
    target.phonesTextView = Utils.findRequiredViewAsType(source, R.id.phonesTextView, "field 'phonesTextView'", TextView.class);
    target.workAddressTextView = Utils.findRequiredViewAsType(source, R.id.workAddressTextView, "field 'workAddressTextView'", TextView.class);
    target.projectAddressTextView = Utils.findRequiredViewAsType(source, R.id.projectAddressTextView, "field 'projectAddressTextView'", TextView.class);
    target.priorityTextView = Utils.findRequiredViewAsType(source, R.id.priorityTextView, "field 'priorityTextView'", TextView.class);
    target.visitButton = Utils.findRequiredViewAsType(source, R.id.visitButton, "field 'visitButton'", Button.class);
    target.notVisitButton = Utils.findRequiredViewAsType(source, R.id.notVisitButton, "field 'notVisitButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.customerNameTextView = null;
    target.creditNumberTextView = null;
    target.customerAddressTextView = null;
    target.capitalBalanceTextView = null;
    target.amountReceivableTextView = null;
    target.shareRatioTextView = null;
    target.daysDelayTextView = null;
    target.expirationDateFirstSubscriptionTextView = null;
    target.phonesTextView = null;
    target.workAddressTextView = null;
    target.projectAddressTextView = null;
    target.priorityTextView = null;
    target.visitButton = null;
    target.notVisitButton = null;
  }
}
