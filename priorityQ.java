public class priorityQ {
    static class Node {
        int data;
        int priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    Node head = null;

    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (head == null || head.priority > priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty"); 
        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if (head == null)
            throw new RuntimeException("Queue is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Data: " + temp.data + " Priority: " + temp.priority);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        priorityQ pq = new priorityQ();
        pq.enqueue(10, 2);
        pq.enqueue(5, 1);
        pq.enqueue(15, 3);
        pq.display();
        System.out.println("Dequeued: " + pq.dequeue());
        pq.display();
    }
}