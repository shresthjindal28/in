import java.util.Scanner;

public class p7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        System.out.print("Enter value for row & column : ");
        row = sc.nextInt();
        col = sc.nextInt();

        if (row < 3 || col < 3) {
            System.exit(0);
        }

        int[][] a = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        int Tsum = 0;

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j] + a[i + 2][j + 1]
                        + a[i + 2][j + 2];
            }
            System.out.println();
            if (Tsum < sum) {
                Tsum = sum;
            }
            sum = 0;
        }

        System.out.println(Tsum);
        sc.close();
    }
}