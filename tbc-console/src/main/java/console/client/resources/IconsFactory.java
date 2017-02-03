package console.client.resources;

import com.google.gwt.core.client.GWT;

public class IconsFactory {

	private static final Icons ICONS = GWT.create(Icons.class);

	public static Icons getIcons() {
		return ICONS;
	}
}
