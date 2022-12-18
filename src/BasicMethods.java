import java.util.Comparator;

public interface BasicMethods <E> extends Iterable<E> {
    boolean addInArray(E e);
    boolean addInArray(int index, E e);
    void deleteObject(int index);
    void deleteAllObject();
    E getObject(int index);
    int lengthArray();
    void updateArray(int index, E e);
    void sort(Comparator<E> c);
}
