package ss8_java_collection_framework.practice.my_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static int DEFAULT_CAPACITY = 10;
    private Object element[];

    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity() {
        int newSize = element.length * 2;
        element = Arrays.copyOf(element, newSize);
    }

    public void add(E e) {
        if (size == element.length) {
            ensureCapacity();
        }
        element[size++] = e;
    }

    public E get(int i){
        if (i >=size || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i +", Size " + i);
        }
        return (E) element[i];
    }
}
