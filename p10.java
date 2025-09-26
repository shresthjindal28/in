import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p10 {
    public static Node rearrangeList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = reverse(slow.next);
        slow.next = null;
        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        return head;
    }

    private static Node reverse(Node head) {
        Node prev = null, curr = head, nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Empty list");
            return;
        }
        Node head = new Node(sc.nextInt());
        Node current = head;
        for (int i = 1; i < n; i++) {
            current.next = new Node(sc.nextInt());
            current = current.next;
        }
        printList(head);
        head = rearrangeList(head);
        printList(head);
        sc.close();
    }
}
