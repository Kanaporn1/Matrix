package Matrix2x2;

public class Matrix2x2 implements Matrix2x2ADT {
    private double[][] a;
    
    public Matrix2x2(double d1,double d2,double d3,double d4) {
     a = new double[2][2];
     a[0][0] = d1;
     a[0][1] = d2;
     a[1][0] = d3;
     a[1][1] = d4;
    } 
    public double getElem(int i,int j) {
         if (i < 0 || j < 0 || i > 1 || j > 1) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return a[i][j];
    }
    public boolean equals(Matrix2x2 A) {
        boolean e = false;
        if ( A.getElem(0, 0) == a[0][0]) {
            if ( A.getElem(0, 1) == a[0][1]) {
                 if ( A.getElem(1, 0) == a[1][0]) {
                     if ( A.getElem(1, 1) == a[1][1]) {
                         e = true;
                     }
                 }
            }
        }
        return e;
    }
    public Matrix2x2 transpose() {
        return new Matrix2x2(a[0][0],a[1][0],a[0][1],a[1][1]);
    }
    public Matrix2x2 add(Matrix2x2 b) {
        double y1 = a[0][0]+b.getElem(0, 0);
        double y2 = a[0][1]+b.getElem(0, 1);
        double y3 = a[1][0]+b.getElem(1, 0); 
        double y4 = a[1][1]+b.getElem(1, 1);
        return new Matrix2x2(y1,y2,y3,y4);
    }
    public Matrix2x2 multiply(double r) {
        double y1 = r*a[0][0];
        double y2 = r*a[0][1];
        double y3 = r*a[1][0];
        double y4 = r*a[1][1];
        return new Matrix2x2(y1,y2,y3,y4);
    }
    public Matrix2x2 multiply(Matrix2x2 b){
        double y1 = ((a[0][0])*b.getElem(0, 0))+((a[0][1])*b.getElem(1, 0));
        double y2 = ((a[0][0])*b.getElem(0, 1))+((a[0][1])*b.getElem(1, 1));
        double y3 = ((a[1][0])*b.getElem(0, 0))+((a[1][1])*b.getElem(1, 0));
        double y4 = ((a[1][0])*b.getElem(0, 1))+((a[1][1])*b.getElem(1, 1));
        return new Matrix2x2(y1,y2,y3,y4);
    }
    public double det() {
        double det = (a[0][0]*a[1][1]) - (a[1][0]*a[0][1]);
        return det;
    }
    public double cofactor(int i,int j){
         if (i < 0 || j < 0 || i > 1 || j > 1) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if (i == 0 && j == 0) {
            a[i][j] = a[1][1];
        }
        else if (i == 0 && j == 1) {
            a[i][j] = -a[1][0];
        }
        else if (i == 1 && j == 0) {
            a[i][j] = -a[0][1];
        }
        else if (i == 1 && j == 1) {
            a[i][j] = a[0][0];
        }
        return a[i][j];
    }
    
    
    
    
    
    
    
    
    public Matrix2x2 adjoint() {
        double[][] z = new double[2][2];
        z[0][0] = cofactor(0, 0);
        z[0][1] = cofactor(0, 1);
        z[1][0] = cofactor(1, 0);
        z[1][1] = cofactor(1, 1);
        Matrix2x2 b = new Matrix2x2 (z[0][0], z[0][1], z[1][0], z[1][1]);
        return b.transpose();
    }
    public boolean isSingular(){
        Matrix2x2 b = new Matrix2x2 (a[0][0],a[0][1],a[1][0],a[1][1]);
        if ( b.det() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Matrix2x2 inverse(){
        if (det() != 0) {
            Matrix2x2 b = adjoint();
            return b.multiply(1/b.det());
        }
        else  {
            return null;
        }  
    }
    public String toString() {
        return a[0][0] + " " + a[0][1] + " " + a[1][0] + " " + a[1][1];
    }
    
}
    
    


