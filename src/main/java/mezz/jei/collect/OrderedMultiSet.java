package mezz.jei.collect;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OrderedMultiSet<T> extends AbstractSet<T>
{
    private final List<T> list = new LinkedList<>();

    @Override
    public boolean add(T element) {
        list.add(element);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }
}
