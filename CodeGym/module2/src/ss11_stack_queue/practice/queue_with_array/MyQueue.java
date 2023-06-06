package ss11_stack_queue.practice.queue_with_array;

public class MyQueue {
    private int capacity = 10;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;


    public MyQueue(int size) {
        this.capacity = size;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element.");
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue!");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow! Unable to remove from Queue");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop operation done! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
