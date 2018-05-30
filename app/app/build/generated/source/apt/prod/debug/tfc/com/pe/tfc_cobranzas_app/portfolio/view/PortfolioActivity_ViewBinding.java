// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.portfolio.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;
import tfc.com.pe.tfc_cobranzas_app.portfolio.view.ui.PortfolioActivity;

public class PortfolioActivity_ViewBinding implements Unbinder {
  private PortfolioActivity target;

  @UiThread
  public PortfolioActivity_ViewBinding(PortfolioActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PortfolioActivity_ViewBinding(PortfolioActivity target, View source) {
    this.target = target;

    target.customerRecyclerView = Utils.findRequiredViewAsType(source, R.id.customerRecyclerView, "field 'customerRecyclerView'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
    target.syncDataButton = Utils.findRequiredViewAsType(source, R.id.syncDataButton, "field 'syncDataButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PortfolioActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.customerRecyclerView = null;
    target.progressBar = null;
    target.syncDataButton = null;
  }
}
