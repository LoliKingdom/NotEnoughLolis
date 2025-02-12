package mezz.jei.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMultimap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class MultiMap<K, V, T extends Collection<V>> {
    protected final Map<K, T> map;
    protected final Function<K, T> collectionMappingFunction;

    public MultiMap(Supplier<T> collectionSupplier) {
        this(new Object2ObjectOpenHashMap<>(), collectionSupplier);
    }

    public MultiMap(Map<K, T> map, Supplier<T> collectionSupplier) {
        this.map = map;
        this.collectionMappingFunction = (k -> collectionSupplier.get());
    }

    public T get(K key) {
        return map.computeIfAbsent(key, collectionMappingFunction);
    }

    public boolean put(K key, V value) {
        return get(key).add(value);
    }

    public boolean put(K key, T values) {
        return get(key).addAll(values);
    }

    public void putAll(Map<K, T> map) {
        this.map.putAll(map);
    }

    public void putAll(MultiMap<K, V, T> map) {
        this.map.putAll(map.map);
    }

    public boolean remove(K key) {
        return map.remove(key) != null;
    }

    public boolean remove(K key, V value) {
        T collection = map.get(key);
        return collection != null && collection.remove(value);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean contains(K key, V value) {
        T collection = map.get(key);
        return collection != null && collection.contains(value);
    }

    public Set<Map.Entry<K, T>> entrySet() {
        return map.entrySet();
    }

    public Stream<V> valueStream() {
        return map.values().stream().flatMap(Collection::stream);
    }

    public void clear() {
        map.clear();
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
        for (Map.Entry<K, T> entry : map.entrySet()) {
            K key = entry.getKey();
            for (V value : entry.getValue()) {
                builder.put(key, value);
            }
        }
        return builder.build();
    }
}