public interface BasicMethods <E> extends Iterable<E> {
    boolean addInArrayEnd(E e);
    boolean addInArrayMiddle(int posithion, E e);
    void deleteObject(int index);
    void deleteAllObject();
    E getObject(int index);
    int lengthArray();
    void updateArray(int index, E e);
}
