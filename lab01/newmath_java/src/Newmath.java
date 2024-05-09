public class Newmath {

  public static int div(int a, int b) {
    if ( b == 0 ) {
      throw new ArithmeticException("Attempt to divide by zero.");
    }
    return a / b;
  }

  public static void main( String[] args ) {
    int result = Newmath.div( 6, 2 );
    System.out.println(result);
  }

}