import java.util.Iterator;

public class IteratorMyArrayList <E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    public IteratorMyArrayList(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
