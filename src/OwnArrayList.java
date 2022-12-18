import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OwnArrayList<E> implements BasicMethods<E> {
    private E[] array;
    private int size;
    private static final int DEF_SIZE = 100;

    public OwnArrayList() {
        this(DEF_SIZE);
    }

    public OwnArrayList(int capasity) {
        if (capasity<1)
            throw new IllegalArgumentException();
        array = (E[]) new Object[capasity];
        size = 0;
    }
    public int size() {
        return size;
    }

    private void examinationIndex(int index) {
        if (index < 0 || index > size) throw new IllegalStateException();
    }

    private void ensureLength(int addElement) {
        int requiredLength = size + addElement;
        if (requiredLength > array.length) {
            int newLength = requiredLength * 2;
            E[] newList = (E[]) new Object[newLength];
            for (int i = 0; i < size; ++i)
                newList[i] = array[i];
            array = newList;
        }
    }

    @Override
    public boolean addInArray(E e) {
        try {
            ensureLength(1);
            array[size] = e;
            ++size;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addInArray(int index, E e) {
        try {
            ensureLength(1);
            examinationIndex(index);
            for (int i = size; i > index; --i)
                array[i] = array[i-1];
            array[index] = e;
            ++size;

        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteObject(int index) {
        try {
            examinationIndex(index);
            for (int i = index; i < size-1; ++i)
                array[i] = array[i+1];
            --size;
            array[size] = null;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
    }

    @Override
    public void deleteAllObject() {
        for (int i = 0; i < size; ++i)
            array[i] = null;
        size = 0;
    }

    @Override
    public E getObject(int index) {
        examinationIndex(index);
        return array[index];
    }

    @Override
    public void sort(Comparator<E> c) {
        quickSort(array,0,size,c);
    }
    private <E> void quickSort(E [] array, int low, int high, Comparator<? super E> c) {
        if (array.length == 0)
            return;
        //завершить выполнение если длина массива равна 0

        if (low >= high)
            return;
        //завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high-low) / 2;
        E opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high-1;
        if (high<size) j = j+1;
        while (i <= j) {
            while (c.compare(array[i], opora)<0) {
                i++;
            }

            while (c.compare(array[j], opora)>0) {
                j--;
            }
            if (i <= j) {//меняем местами
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части

        if (low < j)
            quickSort(array, low, j,c);

        if (high > i)
            quickSort(array, i, high,c);
    }

    @Override
    public int lengthArray() {
        return array.length;
    }

    @Override
    public void updateArray(int index, E e) {
        array[index] = e;
    }

    @Override
    public Iterator<E> iterator() {

        return new IteratorMyArrayList();
    }

    public String toString(){
        IteratorMyArrayList <E> iterator = new IteratorMyArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if(!iterator.hasNext()) return "[]";
        stringBuilder.append("[");
        while (true){
            E e = iterator.next();
            stringBuilder.append(e);
            if(!iterator.hasNext()){
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            stringBuilder.append(", ");
        }
    }


    public class IteratorMyArrayList<E> implements Iterator<E> {
        int position;
        boolean removeGood;
        public IteratorMyArrayList() {
            position = 0;
            removeGood = false;
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E value = (E)getObject(position);
            ++position;
            removeGood = true;
            return value;
        }
    }
}