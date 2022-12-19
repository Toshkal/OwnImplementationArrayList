import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OwnArrayListTest {
    private static OwnArrayList integerList;
    private static OwnArrayList stringList;
    private static OwnArrayList objectList;

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

    @org.junit.jupiter.api.Test
    public void addInArray() {
        integerList.addInArray(555);
        System.out.println(integerList);
        stringList.addInArray("tutu");
        System.out.println(stringList);
        objectList.addInArray('r');
        System.out.println(objectList);
    }

    @org.junit.jupiter.api.Test
    public void size() {
        assertEquals(1, integerList.size());
        assertEquals(5, objectList.size());
        assertEquals(10, stringList.size());
    }

    @org.junit.jupiter.api.Test
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
        assertEquals(4, objectList.size());
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
        for (int i = 0; i < integerList.size(); i++) {
            assertEquals(i, integerList.getObject(i));
        }
    }

    @org.junit.jupiter.api.Test
    void sort() {
        System.out.println(integerList);
        integerList.sort();
    }

    @org.junit.jupiter.api.Test
    void lengthArray() {
    }

    @org.junit.jupiter.api.Test
    void updateArray() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}