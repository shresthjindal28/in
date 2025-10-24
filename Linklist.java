class Listnode {

    int data;
    Listnode next;

    Listnode(int d) {
        data = d;
    }
}

public class Linklist {
    Listnode head; 

    void insertfirst(int d) {
        Listnode newnode = new Listnode(d);
        newnode.next = head;
        head = newnode;
    }

    void insertLast(int d) {
        Listnode newnode = new Listnode(d);
        if (head == null) {
            head = newnode;
        } else {
            Listnode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newnode;
        }
    }

    void insertAT(int d, int ind) {
        Listnode newnode = new Listnode(d);
        Listnode cur = head;
        int count = 0;
        if (ind == 0) {
            insertfirst(d);
            return;
        }

        while (cur.next != null && count != ind - 1) {
            cur = cur.next;
            count++;
        }
        newnode.next = cur.next;
        cur.next = newnode;
    }

    void traverse(String msg, Listnode h) {
        System.out.println(msg);
        Listnode cur = h;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    void deletefirst() {
        head = head.next;
    }

    void deletelast() {
        Listnode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    void deleteat(int ind) {
        Listnode cur = head;
        int count = 0;
        if (ind == 0) {
            deletefirst();
            return;
        }
        while (cur.next != null && count != ind - 1) {
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        Linklist l = new Linklist();
        l.insertLast(10);
        l.insertLast(20);
        l.insertLast(30);
        l.insertLast(40);
        l.insertLast(50);
        l.traverse("Initial phase", l.head);
        l.insertfirst(60);
        l.traverse("After insertion at first", l.head);
        l.deletefirst();
        l.traverse("After deletion of first element", l.head);
        l.deletelast();
        l.traverse("After deletion of last element", l.head);
        l.insertAT(25, 2);
        l.traverse("After insertion at index 2", l.head);
        l.deleteat(3);
        l.traverse("After deletion at index 3", l.head);
    }
}