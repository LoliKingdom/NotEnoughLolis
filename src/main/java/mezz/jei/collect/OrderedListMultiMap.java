package mezz.jei.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class OrderedListMultiMap<K, V> extends OrderedMultiMap<K, V, List<V>> {
    public OrderedListMultiMap() {
        this(ArrayList::new);
    }

    public OrderedListMultiMap(Supplier<List<V>> collectionSupplier) {
        super(collectionSupplier);
    }

    public OrderedListMultiMap(Map<K, List<V>> map, Supplier<List<V>> collectionSupplier) {
        super(map, collectionSupplier);
    }
}
