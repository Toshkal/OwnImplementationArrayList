import java.util.Arrays;
import java.util.Comparator;

public class Start {
    public static void main(String[] args) {
        OwnArrayList<Integer> integers = new OwnArrayList<>();
        integers.addInArray(654);
        integers.addInArray(95481);
        integers.addInArray(65);
        integers.addInArray(514);
        integers.addInArray(89);

        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(integers);

        System.out.println(integers.getObject(1));
        integers.updateArray(1,511);
        System.out.println(integers.getObject(1));
        System.out.println(integers.lengthArray());
        integers.deleteObject(1);
        System.out.println(integers.getObject(1));

        integers.addInArray(1, 7777);
        System.out.println(integers.getObject(1));

        integers.deleteAllObject();
        System.out.println(integers.lengthArray());
        System.out.println(integers.getObject(0));

        for (int i = 0; i < 1000; i++) {
            OwnArrayList<Object> objects = new OwnArrayList<>();
            objects.addInArray( new Object());
        }

    }
}
