import java.util.Scanner;

public class p9 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int jag[][]=new int[3][];
        // for(int i = 0;i<3;i++) {
        //     jag[i]= new int[sc.nextInt()];
        // }
        jag[0]= new int[2];
        jag[1]= new int[4];
        jag[2]= new int[1];

        for(int i=0; i<3; i++) {
            for(int j=0; j<jag[i].length; j++) {
                jag[i][j]= sc.nextInt();
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<jag[i].length; j++) {
                System.out.print(jag[i][j]);
            }
            System.out.println();
        }
    }
}