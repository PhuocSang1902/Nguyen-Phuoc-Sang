package ss8_java_collection_framework.exercise.implement_method_array_list;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.add(7,1);
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.size());
        System.out.println(list.indexOf(3));
        System.out.println(list.contains(2));
    }
}
