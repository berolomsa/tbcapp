package console.zcomp;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;

public class ZWindow extends Window {

	private FramedPanel framedPanel;

    public ZWindow() {
        setModal(true);
        setBodyBorder(false);
        setResizable(false);
        setClosable(true);
        setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);
        getButtonBar().setSpacing(10);
    }

	public ZWindow(int width, int height) {
		this(null, width, height);
	}

	public ZWindow(String header, int width, int height) {
		this(header, width, height, true);
	}

	public ZWindow(String header, int width, int height, boolean frameContent) {
		this.setWidth(width);
		this.setHeight(height);
		if (header != null) {
			this.setHeadingText(header);
		}

		setModal(true);
		setBodyBorder(false);
		setResizable(false);
		setClosable(true);
		setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);
		getButtonBar().setSpacing(10);

		if (frameContent) {
			framedPanel = new FramedPanel();
			framedPanel.getElement().getStyle().setBorderWidth(1, Style.Unit.PX);
			framedPanel.setHeaderVisible(false);
			super.add(framedPanel, new MarginData(5));
		}
	}

	@Override
	public void add(Widget child) {
		add(child, new MarginData(15));
	}

	@Override
	public void add(Widget child, MarginData marginData) {
		if (framedPanel != null) {
			framedPanel.add(child, marginData);
		} else {
			super.add(child, marginData);
		}
	}

    public void showInCenter() {
        show();
        center();
    }
}
