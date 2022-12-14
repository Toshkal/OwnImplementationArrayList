public class Start {
    public static void main(String[] args) {
        BasicMethods<String> strings = new OwnArrayList<>();
        strings.addInArrayEnd("Anton");
        strings.addInArrayEnd("Alex");
        strings.addInArrayEnd("Alexsey");

        System.out.println(strings.getObject(1));
        strings.updateArray(1,"Retro");
        System.out.println(strings.getObject(1));
        System.out.println(strings.lengthArray());
        strings.deleteObject(1);
        System.out.println(strings.getObject(1));

        strings.addInArrayMiddle(1, "DoDo");
        System.out.println(strings.getObject(1));

        strings.deleteAllObject();
        System.out.println(strings.lengthArray());
        System.out.println(strings.getObject(0));

    }
}
