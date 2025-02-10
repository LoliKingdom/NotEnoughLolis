package mezz.jei.collect;

import java.util.*;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMultimap;

public class OrderedMultiMap<K, V, T extends Collection<V>> extends MultiMap<K, V, T> {
	private final List<K> keyOrder;

	public OrderedMultiMap(Supplier<T> collectionSupplier) {
		super(collectionSupplier);
		this.keyOrder = new ArrayList<>();
	}

	public OrderedMultiMap(Map<K, T> map, Supplier<T> collectionSupplier) {
		super(map, collectionSupplier);
		this.keyOrder = new ArrayList<>();
	}

	public void insertAt(int index, K key, T values) {
		if (!map.containsKey(key)) {
			map.put(key, values);
			keyOrder.add(index, key);
		}
	}

	@Override
	public T get(K key) {
		return map.computeIfAbsent(key, k -> {
			keyOrder.add(k);
			return collectionMappingFunction.apply(k);
		});
	}

	public void removeKey(K key) {
		map.remove(key);
		keyOrder.remove(key);
	}

	@Override
	public Set<Map.Entry<K, T>> entrySet() {
		Set<Map.Entry<K, T>> orderedEntries = new OrderedMultiSet<>();
		for (K key : keyOrder) {
			orderedEntries.add(new AbstractMap.SimpleEntry<>(key, map.get(key)));
		}
		return orderedEntries;
	}

	@Override
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
