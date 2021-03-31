package main.service.entry;

import java.util.Map.Entry;

public interface EntryPersonalized<K, V> extends Entry<K, V>{

	/**
	 * Replaces the key corresponding to this entry with the specified key.
	 * @param key new key to be stored in this entry.
	 * @return old value corresponding to the entry.
	 */
	public K setKey(K key);
	
}
