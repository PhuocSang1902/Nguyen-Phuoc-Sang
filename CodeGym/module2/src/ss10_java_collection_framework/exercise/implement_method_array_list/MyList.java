package ss10_java_collection_framework.exercise.implement_method_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public MyList() {
        this.element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if(capacity >= 0) {
            this.element = new Object[capacity];
        } else {
            System.out.println("Input the number greater than or equal 0");
        }
    }

    public void addLast(E element) {
        if (size == this.element.length) {
            ensureCapacity(5);
        }
        this.element[size] = element;
        size++;
    }

    public void add(E element, int index) {
        if (index>this.element.length || index < 0){
            System.out.println("Enter index again");
        }else if (this.element.length == size){
            this.ensureCapacity(5);
        }
        if (this.element[index] == null){
            this.element[index] = element;
            this.size ++;
        }else {
            for (int i = size; i > index; i--) {
                this.element[i] = this.element[i - 1];
            }
        }
        this.element[index] = element;
        size++;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >=0) {
            int newSize = element.length * minCapacity;
            element = Arrays.copyOf(element, newSize);
        }else {
            System.out.println("Input number greater than or equal 0");
        }
    }

    public int size(){
        return this.size;
    }

    public E get(int i){
        if (i >=size || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i +", Size " + i);
        }
        return (E) element[i];
    }
    public void clear(){
        for (int i = 0; i <this.element.length; i++) {
            element[i] = null;
        }
    }

    public int indexOf(E element){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.element[i].equals(element)){
                return i;
            }
        }
        return index;
    }

    public boolean contains (E element){
        return this.indexOf(element) >= 0;
    }

    public MyList<E> clone(){
        MyList<E> v = new MyList<>();
        v.element = Arrays.copyOf(this.element, this.size);
        v.size = this.size;
        return v;
    }

    public E remove(int index){
        if (index<0||index>element.length){
            System.out.println("Error index");
        }
        E element = (E) this.element[index];
        for (int i = 0; i < size - 1; i++) {
            this.element[i] = this.element[i+1];
        }
        this.element[size - 1] = null;
        size --;
        return element;

    }

}
