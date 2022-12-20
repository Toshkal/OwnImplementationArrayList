import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OwnArrayListTest {
    private static OwnArrayList<Integer> integerList;
    private static OwnArrayList<String> stringList;
    private static OwnArrayList<Object> objectList;

    @BeforeAll
    public static void beforeAll() {
        integerList = new OwnArrayList();
        for (int i = 0; i < 1; i++) {
            integerList.addInArray(i);
        }
        System.out.println(integerList);

        stringList = new OwnArrayList();
        String foof = "D";
        for (char i = 0; i < 10; i++) {
            foof += "S";
            stringList.addInArray(foof);
        }
        System.out.println(stringList);

        objectList = new OwnArrayList();
        for (char i = 'A'; i < 'A' + 5; i++) {
            objectList.addInArray(i);
        }
        System.out.println(objectList);
    }

    @Test
    public void addInArray() {
        integerList.addInArray(555);
        System.out.println(integerList);
        stringList.addInArray("tutu");
        System.out.println(stringList);
        objectList.addInArray('r');
        System.out.println(objectList);
    }

    @Test
    public void size() {
        assertEquals(3, integerList.size());
        assertEquals(6, objectList.size());
        assertEquals(12, stringList.size());
    }

    @Test
    void testAddInArray() {
        integerList.addInArray(0,777);
        System.out.println(integerList);
        stringList.addInArray(2,"rabbit");
        System.out.println(stringList);
        objectList.addInArray(5,'O');
        System.out.println(objectList);
    }

    @Test
    void deleteObject() {
        System.out.println(objectList);
        Object expected = 'D';
        Object actual = objectList.deleteObject(2);
        assertEquals(5, objectList.size());
        assertEquals(expected, actual);

        assertEquals('A', objectList.getObject(0));
        assertEquals('B', objectList.getObject(1));
        assertEquals('D', objectList.getObject(2));
        assertEquals('E', objectList.getObject(3));
    }

    @Test
    void deleteAllObject() {
        System.out.println(stringList);
        stringList.deleteAllObject();
        System.out.println(stringList);
    }

    @Test
    void getObject() {
            assertEquals(0, integerList.getObject(0));

    }

    @Test
    @Timeout(8)
    void sort() {
        for (int i = 0; i < 100_000; i++) {
            integerList.addInArray((int)(Math.random()*1_000_000));
            }
            integerList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
        });
            System.out.println(integerList);
    }

    @Test
    void lengthArray() {
        assertEquals(4,4);
    }

    @Test
    void updateArray() {
        System.out.println(objectList);
        objectList.updateArray(2,'V');
        System.out.println(objectList);
    }
}