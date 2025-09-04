import java.util.Scanner;

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter n");
        n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0, j = 0; i < n; i++) {
            if (a[i] != 0 && a[j] == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            if (a[j] != 0) {
                j++;
            }
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println(a[i]);
        }

        sc.close();
    }
}

//