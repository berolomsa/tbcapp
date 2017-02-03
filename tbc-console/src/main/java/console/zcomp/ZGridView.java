package console.zcomp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.sencha.gxt.widget.core.client.grid.GridView;

public class ZGridView<M> extends GridView<M> {

	public ZGridView() {
		this(GWT.<GridAppearance>create(GridAppearance.class));
	}

	public ZGridView(GridAppearance appearance) {
		super(appearance);
		setProperties();
	}

	private void setProperties() {
		setForceFit(true);
		setAutoFill(true);
		setColumnLines(false);
	}

	@Override
	protected void afterRender() {
		dataTable.getStyle().setProperty("tableLayout", "auto");
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				dataTable.getStyle().setProperty("tableLayout", "fixed");
			}
		});
		super.afterRender();
	}
}
