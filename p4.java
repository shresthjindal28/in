import java.util.Scanner;
public class p4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[3][];
        System.out.println("Enter the size of each row:");
        for(int i=0;i<3;i++){
            arr[i] = new int[sc.nextInt()];
        }
        System.out.println("Enter the elements:");
        for(int i=0;i<3;i++){
            for(int j= 0; j< arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("The elements are:");
        for(int i=0;i<3;i++){
            for(int j= 0; j< arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        sc.close();
    }
    
}
