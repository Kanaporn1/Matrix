
package Matrix2x2;

public interface Matrix2x2ADT {
    public double getElem(int i,int j);
    //throws IndexOutOfBoundsException;
    public boolean equals(Matrix2x2 b);
    public Matrix2x2 transpose();
    public Matrix2x2 add(Matrix2x2 b);
    public Matrix2x2 multiply(double c);
    public Matrix2x2 multiply(Matrix2x2 b);
    public double det();
    public double cofactor(int i, int j)
    throws IndexOutOfBoundsException;
    public Matrix2x2 adjoint();
    public boolean isSingular();
    public Matrix2x2 inverse();
    @Override
    public String toString(); 

      
}
