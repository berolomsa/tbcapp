package console.zcomp;

import com.sencha.gxt.core.client.ValueProvider;

public abstract class ZStringProvider<T> implements ValueProvider<T, String> {

	@Override
	public String getValue(T object) {
		return getProperty(object);
	}

	@Override
	public void setValue(T object, String value) {}

	@Override
	public String getPath() {
		return null;
	}

	public abstract String getProperty(T object);
}
