// Generated code from Butter Knife. Do not modify!
package tfc.com.pe.tfc_cobranzas_app.management.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import java.lang.IllegalStateException;
import java.lang.Override;
import tfc.com.pe.tfc_cobranzas_app.R;
import tfc.com.pe.tfc_cobranzas_app.management.view.ui.AdvancedActivity;

public class AdvancedActivity_ViewBinding implements Unbinder {
  private AdvancedActivity target;

  @UiThread
  public AdvancedActivity_ViewBinding(AdvancedActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AdvancedActivity_ViewBinding(AdvancedActivity target, View source) {
    this.target = target;

    target.advancedPieChart = Utils.findRequiredViewAsType(source, R.id.advancedPieChart, "field 'advancedPieChart'", PieChart.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdvancedActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.advancedPieChart = null;
  }
}
