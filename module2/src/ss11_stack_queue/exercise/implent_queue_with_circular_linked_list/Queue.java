package ss11_stack_queue.exercise.implent_queue_with_circular_linked_list;

public class Queue {
    Node front;
    Node rear;

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (front == null) {
            front = rear = temp;
        }
        rear = temp;
        rear.link = front;
    }

    public Node deQueue() {

        if (front == null) {
            return null;
        }
        Node temp = this.front;
        this.front = this.front.link;
        if (this.front == null) {
            this.rear = null;
        }
        return temp;
    }
}
