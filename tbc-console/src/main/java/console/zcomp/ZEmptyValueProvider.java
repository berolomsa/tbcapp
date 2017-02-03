package console.zcomp;

import com.sencha.gxt.core.client.ValueProvider;

public class ZEmptyValueProvider<T, V> implements ValueProvider<T, V> {

	String path;

	public ZEmptyValueProvider() {
		this("");
	}

	public ZEmptyValueProvider(String path) {
		this.path = path;
	}

	@Override
	public V getValue(T object) {
		return null;
	}

	@Override
	public void setValue(T object, V value) {

	}

	@Override
	public String getPath() {
		return path;
	}
}
