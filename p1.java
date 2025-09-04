import java.util.Scanner;

class p1 {
    static void addElement(int arr[], int size, int idx, int value) {
        int newarr[] = new int[size + 1];
        for (int i = 0, j = 0; i <= size; i++) {
            if (i == idx)
                newarr[i] = value;
            else
                newarr[i] = arr[j++];
        }
        for (int i = 0; i < newarr.length; i++)
            System.out.print(newarr[i] + " ");
    }

    static void removeElement(int arr[], int size, int idx) {
        int newarr[] = new int[size];
        for (int i = 0; i < size; i++)
            if (i != idx)
                newarr[i] = arr[i];
        for (int i = 0; i < newarr.length; i++)
            System.out.print(newarr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 5;
        int arr[] = new int[size];
        System.out.println("Enter 5 elements:");
        for (int i = 0; i < size; i++) 
            arr[i] = sc.nextInt();
        System.out.println("Array before adding element: ");
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Enter position and element to be added:");
        int pos = sc.nextInt();
        System.out.println("Element at position " + pos);
        System.out.println("Enter element to be added:");
        int ele = sc.nextInt();
        System.out.println("Array after adding element: ");
        addElement(arr, size, pos, ele);
        System.out.println();
        System.out.println("Enter position from which element is to be removed:");
        int pos2 = sc.nextInt();
        System.out.println("Element at position " + pos2);
        System.out.println("Array after removing element: ");
        removeElement(arr, size, pos2);
        sc.close();
    }

}