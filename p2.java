import java.util.Scanner; 
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = -1, position = -1;
        int arr[] = new int[5];
       
        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
         System.out.println("Enter value of x:");
        int x = sc.nextInt();
        for (int i = 0; i < 5; i++) {
            if (arr[i] == x) {
                flag = 0;
                position = i;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Element found at position: " + position);
        } else {
            System.out.println("Zero not found");
        }
        sc.close();
    }   
}
