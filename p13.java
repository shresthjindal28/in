import java.util.NoSuchElementException;

class CircularDeque {
    private int[] arr;
    private int front, rear, size, capacity;

    CircularDeque(int capacity) {
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

    public void insertRear(int val) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full!");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = val;
        size++;
    }

    public void insertFront(int val) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full!");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        arr[front] = val;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
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

    public int deleteRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
        int data = arr[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        return data;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
        return arr[rear];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }
        System.out.print("--------------> ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDeque dq = new CircularDeque(5);

        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertRear(30);

        dq.display();

        System.out.println("Deleted front: " + dq.deleteFront());
        dq.display();

        System.out.println("Deleted rear: " + dq.deleteRear());
        dq.display();

        dq.insertFront(40);

    }
}
