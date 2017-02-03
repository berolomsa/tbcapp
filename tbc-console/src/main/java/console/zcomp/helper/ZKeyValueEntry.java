package console.zcomp.helper;

public class ZKeyValueEntry<K,V> implements java.io.Serializable {

	private K key;

	private V value;

	public ZKeyValueEntry() {
	}

	public ZKeyValueEntry(K key, V value) {
		this.key   = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}