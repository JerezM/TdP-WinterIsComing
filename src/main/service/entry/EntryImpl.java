package main.service.entry;

public class EntryImpl<K, V> implements EntryPersonalized<K, V> {
	
	private K key;
	private V value;
	
	public EntryImpl(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		
		return oldValue;
	}

	@Override
	public K setKey(K key) {
		K oldKey = this.key;
		this.key = key;
		
		return oldKey;
	}

}
