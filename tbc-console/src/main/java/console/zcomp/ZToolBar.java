package console.zcomp;

import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class ZToolBar extends ToolBar {

	public ZToolBar() {
		this(5, 5);
	}

	public ZToolBar(int horizontalSpacing, int verticalSpacing) {
		setHorizontalSpacing(horizontalSpacing);
		setVerticalSpacing(verticalSpacing);
	}
}
