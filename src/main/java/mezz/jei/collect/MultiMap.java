package mezz.jei.collect;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMultimap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class MultiMap<K, V, T extends Collection<V>> {
	protected final Map<K, T> map;
	private final List<K> keyOrder;
	private final Function<K, T> collectionMappingFunction;

	public MultiMap(Supplier<T> collectionSupplier) {
		this(new Object2ObjectOpenHashMap<>(), collectionSupplier);
	}

	public MultiMap(Map<K, T> map, Supplier<T> collectionSupplier) {
		this.map = map;
		this.keyOrder = new ArrayList<>();
		this.collectionMappingFunction = (k -> collectionSupplier.get());
	}

	public void insertAt(int index, K key, T values) {
		if (!map.containsKey(key)) {
			map.put(key, values);
			keyOrder.add(index, key);
		}
	}

	public T get(K key) {
		return map.computeIfAbsent(key, k -> {
			keyOrder.add(k);
			return collectionMappingFunction.apply(k);
		});
	}

	public boolean put(K key, V value) {
		return get(key).add(value);
	}

	public boolean remove(K key, V value) {
		T collection = map.get(key);
		return collection != null && collection.remove(value);
	}

	public void removeKey(K key) {
		map.remove(key);
	}

	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	public boolean contains(K key, V value) {
		T collection = map.get(key);
		return collection != null && collection.contains(value);
	}

	public List<Map.Entry<K, T>> entrySet() {
		List<Map.Entry<K, T>> orderedEntries = new LinkedList<>();
		for (K key : keyOrder) {
			orderedEntries.add(new AbstractMap.SimpleEntry<>(key, map.get(key)));
		}
		return orderedEntries;
	}

	public Stream<V> valueStream() {
		return map.values().stream().flatMap(Collection::stream);
	}

	public int getTotalSize() {
		int size = 0;
		for (T value : map.values()) {
			size += value.size();
		}
		return size;
	}

	public ImmutableMultimap<K, V> toImmutable() {
		ImmutableMultimap.Builder<K, V> builder = ImmutableMultimap.builder();
		for (K key : keyOrder) {
			for (V value : map.get(key)) {
				builder.put(key, value);
			}
		}
		return builder.build();
	}
}
