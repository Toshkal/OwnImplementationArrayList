import java.util.Iterator;

public class OwnArrayList<E> implements BasicMethods<E> {
    private E[] values;

    public OwnArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean addInArrayEnd(E e) {
        try {
            E[] pointer = values;
            values = (E[]) new Object[pointer.length + 1];
            System.arraycopy(pointer, 0, values, 0, pointer.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addInArrayMiddle(int index, E e) {
        try {
            E[] pointer = values;
            values = (E[]) new Object[pointer.length + 1];
            System.arraycopy(pointer, 0, values, 0, index-1);
            values[index] = e;
            System.arraycopy(pointer, index, values, index+1, pointer.length-1);
            return true;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteObject(int index) {
        try {
            E[] pointer = values;
            values = (E[]) new Object[pointer.length - 1];
            System.arraycopy(pointer, 0, values, 0, index);
            int quantityAfter = pointer.length - index - 1;
            System.arraycopy(pointer, index + 1, values, index, quantityAfter);
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
    }

    @Override
    public void deleteAllObject() {
        E[] pointer = values;
        values = (E[]) new Object[pointer.length - 1];
        for(int i = 0; i<pointer.length;i++)
pointer[i] = null;
    }

    @Override
    public E getObject(int index) {
        return values[index];
    }

    @Override
    public int lengthArray() {
        return values.length;
    }

    @Override
    public void updateArray(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {

        return new IteratorMyArrayList<>(values);
    }
}