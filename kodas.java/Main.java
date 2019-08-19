import java.util.*;
public class Main{
    public static void main (String []args){

/*int a/
/*int v/
/*int m/
/*int n/
/* String t*/


Scanner scanner=new Scanner (System.in);
Random random = new Random();
        int size = scanner.nextInt();
        int a = (int) Math.pow(size, 2);
        /*int[][] v = {{3, 9, 7, 2, 8, 6, 5, 4, 1},
                {4, 1, 2, 5, 3, 9, 7, 6, 8},
                {8, 5, 6, 4, 7, 1, 3, 2, 9},
                {2, 8, 4, 1, 9, 5, 6, 3, 7},
                {6, 3, 9, 7, 4, 8, 2, 1, 5},
                {5, 7, 1, 3, 6, 2, 8, 9, 4},
                {7, 2, 8, 9, 1, 3, 4, 5, 6},
                {1, 6, 3, 8, 5, 4, 9, 7, 2},
                {9, 4, 5, 6, 2, 7, 1, 8, 3}};
*/
        int v [][]=new int[a][a];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
           v[i][j]=random.nextInt(9);
            }
        }
 
                for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int m = 1;
        int n = 1;
        String t=null;
        for (int i = 0; i <v.length; i++, m++) {
            for (int j = 0; j <v.length; j++, n++) {
                    if (v[i][j]!=v[m][n]){
                        t="Correct";
                    }
                    else {
                        t="Incorrect";
                    }
                n=n-1;
            }
            m=m-1;
        }
        System.out.println(t);
        scanner.close();
    }
}