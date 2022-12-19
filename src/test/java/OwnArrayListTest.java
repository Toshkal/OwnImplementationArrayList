import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class OwnArrayListTest {
    private static OwnArrayList integerList;
    private static OwnArrayList stringList;
    private static OwnArrayList objectList;

    @BeforeAll
    public static void beforeAll() {
        integerList = new OwnArrayList();
        stringList = new OwnArrayList();
        objectList = new OwnArrayList();
    }

    @org.junit.jupiter.api.Test
    public void addInArray() {
        for (int i = 0; i < 1; i++) {
            integerList.addInArray(i);
        }
        System.out.println(integerList);
        for (char i = 'A'; i < 'A' + 5; i++) {
            objectList.addInArray(i);
        }
        System.out.println(objectList);
        String foof = "D";
        for (char i = 0; i < 10; i++) {
            foof += "S";
            stringList.addInArray(foof);
        }
        System.out.println(stringList);
    }

    @org.junit.jupiter.api.Test
    public void size() {
        assertEquals(0, integerList.size());
        assertEquals(5, objectList.size());
        assertEquals(10, stringList.size());
    }
    @org.junit.jupiter.api.Test
    void testAddInArray() {

    }

    @org.junit.jupiter.api.Test
    void deleteObject() {
        System.out.println(objectList);
        Object expected = 'D';
        Object actual = objectList.deleteObject(2);
        assertEquals(4, objectList.size());
        assertEquals(expected, actual);

        assertEquals(0, objectList.getObject(0));
        assertEquals(1, objectList.getObject(1));
        assertEquals(3, objectList.getObject(2));
        assertEquals(4, objectList.getObject(3));
    }

    @org.junit.jupiter.api.Test
    void deleteAllObject() {
    }

    @org.junit.jupiter.api.Test
    void getObject() {
        for (int i = 0; i < integerList.size(); i++) {
            assertEquals(i, integerList.getObject(i));
        }
    }

    @org.junit.jupiter.api.Test
    void sort() {
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