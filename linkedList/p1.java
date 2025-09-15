//LinkedList 
//Single Linked List
package linkedList;

public class p1 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted first element "+ head.data);
        head=head.next;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.next==null){
            System.out.println("Deleted last element "+ head.data);
            head=null;
            return;
        }
        Node currNode=head;
        while(currNode.next.next!=null){
            currNode=currNode.next;
        }
        System.out.println("Deleted last element "+ currNode.next.data);
        currNode.next=null;
    }

    void anywhere(int data, int pos) {
        Node newNode = new Node(data);

        if (pos < 1) {
            throw new IllegalArgumentException("Invalid Position");
        }

        if (pos == 1) {
            addFirst(data);
            return;
        }

        Node currNode = head;
        int count = 1;
        while (count < pos - 1) {
            currNode = currNode.next;
            count++;
        }
        if (currNode.next == null) {
            addLast(data);
            return;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    void deleteAnywhere(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(pos == 1){
            deleteFirst();
            return;
        }
        Node currNode = head;
        Node prevNode = null;
        int count = 1;
        while (currNode != null && count < pos) {
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        if (prevNode.next == null) {
            deleteLast();
            return;
        }
        System.out.println("Deleted element " + currNode.data);
        prevNode.next = currNode.next;
    }

    void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print("data ---> "+ currNode.data +" ");
            currNode=currNode.next;
        }
    }

    public static void main(String[] args) {
        p1 list = new p1();

        list.addFirst(10);
        list.addFirst(5);

        list.addLast(25);

        list.anywhere(15, 3);
        list.anywhere(20, 4);

        list.printList();


        list.deleteFirst();
        list.deleteLast();
        list.deleteAnywhere(2);

        list.printList();
    }

}