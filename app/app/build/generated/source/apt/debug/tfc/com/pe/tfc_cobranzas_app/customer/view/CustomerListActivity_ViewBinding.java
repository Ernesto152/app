// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.portfolio.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;

public class CustomerListActivity_ViewBinding implements Unbinder {
  private CustomerListActivity target;

  @UiThread
  public CustomerListActivity_ViewBinding(CustomerListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomerListActivity_ViewBinding(CustomerListActivity target, View source) {
    this.target = target;

    target.customerRecyclerView = Utils.findRequiredViewAsType(source, R.id.customerRecyclerView, "field 'customerRecyclerView'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.customerRecyclerView = null;
    target.progressBar = null;
  }
}
