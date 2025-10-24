import java.util.NoSuchElementException;

class Queue {

    Node front;
    Node rear;
    int length;

    Queue() {
        front = rear = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
        }
    }

    public void EnQueue(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public int DeQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        if (front == rear) {
            rear = null;
        }
        int data = front.data;
        front = front.next;
        length--;
        return data; // ✅ return the dequeued value
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return front.data;
    }

    public static void main(String[] name) {
        Queue queue = new Queue();
        queue.EnQueue(10);
        queue.EnQueue(20);
        queue.EnQueue(30);
        System.out.println(queue.DeQueue());
        System.out.println(queue.peek());
    }
}
