import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс для реализации методов своего ArrayList
 * @param <E> для любых объектов
 */
public class OwnArrayList<E> implements BasicMethods<E> {

    private E[] array;
    /**
     * Размер OwnArrayList (количество элементов, которые он содержит).
     * @serial
     */
    private int size;
    /**
     * Начальный размер по умолчанию.
     */
    private static final int DEF_SIZE = 8;
    /**
     * Создает пустой список с начальной вместимостью восемь.
     */
    public OwnArrayList() {
        this(DEF_SIZE);
    }
    /**
     * Создает пустой список с заданной начальной емкостью.
     *
     * @param capasity начальный размер списка
     *выбрасывает исключение IllegalArgumentException, если указанная начальная емкость
     * является отрицательным
     */
    public OwnArrayList(int capasity) {
        if (capasity<1)
            throw new IllegalArgumentException();
        array = (E[]) new Object[capasity];
        size = 0;
    }

    /**
     * @return Возвращает актуальную длину списка
     */
    public int size() {
        return size;
    }

    /**
     * Метод проверяет входящий индекс, на соответствие размеру массива
     * При выходе за размер, выбрасывает исключение
     * @param index входящий индекс для проверки вхождения в массив
     */
    private void examinationIndex(int index) {
        if (index < 0 || index > size) throw new IllegalStateException();
    }

    /**
     * Проверяет размер массива для вставки нового элемента, и создает новый если элемент не вмещается
     * @param addElement добавляемый элемент в массив
     */
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
    /**
     * Добавляет указанный элемент в конец этого списка.
     * элемент @param e, который будет добавлен в этот список
     */
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
    /**
     * Добавляет указанный элемент по индексу.
     * элемент @param index, указывает место вставки в список
     * элемент @param e, который будет добавлен в этот список
     */
    @Override
    public boolean addInArray(int index, E e) {
        try {
            ensureLength(1);
            examinationIndex(index); // метод проверки на выход за пределы массива
            for (int i = size; i > index; --i)
                array[i] = array[i-1];
            array[index] = e;
            ++size;

        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }
    /**
     * Удаляет элемент в указанной позиции в этом списке.
     * Сдвигает любые последующие элементы влево (вычитает один из их
     * индексы).
     *
     * @param index индекс элемента, подлежащего удалению
     * @return возврат нового значения по тому же индексу
     */
    @Override
    public Object deleteObject(int index) {
        try {
            examinationIndex(index); // проверка индекса
            for (int i = index; i < size-1; ++i)
                array[i] = array[i+1];
            --size;
            array[size] = null;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return array[index];
    }

    /**
     * Удаляет все значения присваиванием null, уменьшает длинну списка до 0
     */
    @Override
    public void deleteAllObject() {
        for (int i = 0; i < size; ++i)
            array[i] = null;
        size = 0;
    }

    /**
     * возврат значения элемента по индексу
     * @param index входящий индекс элемена
     * @return возвращает значение
     */
    @Override
    public E getObject(int index) {
        examinationIndex(index); // проверка индекса
        return array[index];
    }

    /**
     * вызывает метод сортировки
     * @param c объект компаратора
     */
    @Override
    public void sort(Comparator<E> c) {
        quickSort(array,0,size,c);
    }

    /**
     * Реализация быстрой сортировки
     * @param array входящий список
     * @param low нижняя граница
     * @param high верхняя граница
     * @param c объект компаратора
     * @param <E> универсальность
     */
    private <E> void quickSort(E [] array, int low, int high, Comparator<? super E> c) {
        if (array.length == 0) //завершить выполнение если длина массива равна 0
            return;

        if (low >= high)         //завершить выполнение если уже нечего делить
            return;

        int middle = low + (high-low) / 2; // выбрать опорный элемент
        E opora = array[middle];

        int i = low, j = high-1; // разделить на подмассивы, который больше и меньше опорного элемента
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

    /**
     * @return возвращает актуальную длинну списка
     */
    @Override
    public int lengthArray() {
        return array.length;
    }

    /**
     * Заменяет значение на новое
     * @param index индекс заменяемого значения
     * @param e новое значение
     */
    @Override
    public void updateArray(int index, E e) {
        array[index] = e;
    }

    /**
     * @return Возвращает итератор списка по элементам списка
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorMyArrayList();
    }

    /**
     * @return для возврата наглядного представления отсортированного массива, или пустого
     */
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

    /**
     * Класс для переопределения и использования методов Iteratora
     * @param <E> для любых объектов
     */
    public class IteratorMyArrayList<E> implements Iterator<E> {
        int position; // начальное положение
        boolean removeGood; // логический результат

        /**
         * инициализация значений
         */
        public IteratorMyArrayList() {
            position = 0;
            removeGood = false;
        }

        /**
         * @return значение позиции по длинне списка
         */
        @Override
        public boolean hasNext() {
            return position < size();
        }

        /**
         * реализует итерирование на один шаг
         * @return позиции во время итерации
         */

        @Override
        public E next() {
            if (!hasNext()) // проверка на не выполнения HasNext
                throw new NoSuchElementException();
            E value = (E)getObject(position);
            ++position;
            removeGood = true;
            return value;
        }
    }
}