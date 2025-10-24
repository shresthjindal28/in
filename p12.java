import java.util.NoSuchElementException;

class CircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void EnQueue(int val) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full!");
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = val;
        size++;
    }

    public int DeQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        int data = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.EnQueue(10);
        cq.EnQueue(20);
        cq.EnQueue(30);
        cq.display();

        System.out.println("Dequeued: " + cq.DeQueue());
        cq.display();
    }
}
