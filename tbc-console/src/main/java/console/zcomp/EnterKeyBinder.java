package console.zcomp;

import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

import java.util.ArrayList;
import java.util.List;

public class EnterKeyBinder {

	private EnterKeyBinder() {}

	public static class Builder {
		private List<HasKeyDownHandlers> fields = new ArrayList<>();
		private ZButton button;
		private KeyDownHandler handler;

		public Builder (ZButton button) {
			this.button = button;
			createHandler();
		}

		public Builder add(HasKeyDownHandlers field) {
			this.fields.add(field);
			return this;
		}

		public void bind() {
			for (HasKeyDownHandlers field : fields) {
				field.addKeyDownHandler(handler);
			}
		}

		private void createHandler() {
			handler = new KeyDownHandler() {
				@Override
				public void onKeyDown(KeyDownEvent event) {
					if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {

						button.focus();
						button.fireEvent(new SelectEvent());
					}
				}
			};
		}
	}
}
