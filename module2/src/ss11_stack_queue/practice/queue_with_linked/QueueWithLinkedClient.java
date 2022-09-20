package ss11_stack_queue.practice.queue_with_linked;

public class QueueWithLinkedClient {
    public static void main(String[] args) {
        QueueWithLinked queue = new QueueWithLinked();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Dequeue item is " + queue.dequeue().key);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Dequeue item is " + queue.dequeue().key);
    }
}
