public static void main(String[] args) {
}
public class Apskritimas {
    int x, y;
    double r;
    
public static void main(String[] args) {
 System.out.print("x=" +  " y=" +  " r=" );   
}
    
//konstruktoriai
public Apskritimas () {x=0; y=0; r=0;}
public Apskritimas (int xA, int yA, double rA) {x = xA; y = yA; r = rA;}
//metodas - pakeisti reiškmes
public void Pakeisti (int n_X, int n_Y, double n_r) { x = n_X; y =n_Y; r = n_r;}
}