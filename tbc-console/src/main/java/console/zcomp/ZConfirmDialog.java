package console.zcomp;

import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;

public abstract class ZConfirmDialog extends ConfirmMessageBox {

	public ZConfirmDialog(String header, String text) {
		super(header, text);
		getBody().setPadding(new Padding(10));
		setIcon(ICONS.info());
		addDialogHideHandler(new DialogHideEvent.DialogHideHandler() {
			@Override
			public void onDialogHide(DialogHideEvent event) {
				if (event.getHideButton() == PredefinedButton.YES) {
					onConfirm();
				}
			}
		});
	}

	public abstract void onConfirm();
}

