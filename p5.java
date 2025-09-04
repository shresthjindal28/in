import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Input n");
        n = sc.nextInt();
        int a[] = new int[n - 1];
        System.out.println("Input Array");
        int x1 = 0, x2 = 0;
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextInt();
            x1 = x1 ^ a[i];
            x2 = x2 ^ (i + 1);
        }

        x2 = x2 ^ n;
        int x = (x1 ^ x2);
        System.out.println("missing number is " + x);

        sc.close();
    }
}

// Let the array length = n-1 (since one number is missing )

// compute the expected sun of first n natural numbers using the formula :
// expected sum = nx(n+1)/2

// travese through the given array and subtract each element from expectedSum

// after the loop the remaining value in expectedSum in the missing number