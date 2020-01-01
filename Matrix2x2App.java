
package Matrix2x2;

public class Matrix2x2App {

    public static void main(String[] args) {
       Matrix2x2 C = new Matrix2x2(1,0,0,1);
       Matrix2x2 D = new Matrix2x2(1,9,4,16);
       Matrix2x2 E = D.transpose();
       Matrix2x2 B = E.multiply(4);
       Matrix2x2 F = B.inverse();
       Matrix2x2 A = F.multiply(C);
       Matrix2x2 Z = A.inverse();
       System.out.println("X = "+Z);
       
       
    }
    
}
