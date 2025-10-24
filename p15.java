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
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        length--;
        return data;
    }

    public int size() {
        return length;
    }
}

public class p15 {
    static class StackUsingQueue {
        Queue q = new Queue();

        void push(int x) {
            q.EnQueue(x);
            int n = q.size();
            for (int i = 0; i < n - 1; i++) {
                q.EnQueue(q.DeQueue());
            }
        }

        int pop() {
            if (q.isEmpty()) throw new NoSuchElementException("Stack is empty!");
            return q.DeQueue();
        }

        int top() {
            if (q.isEmpty()) throw new NoSuchElementException("Stack is empty!");
            int val = q.DeQueue();
            q.EnQueue(val);
            for (int i = 0; i < q.size() - 1; i++) {
                q.EnQueue(q.DeQueue());
            }
            return val;
        }

        boolean isEmpty() {
            return q.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.isEmpty());
    }
}
