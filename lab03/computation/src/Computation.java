public class Computation {

	public int add(int a, int b) {
		int result = a + b;
		int zero = 0;
		int result2 = result;
		if (a == Integer.MIN_VALUE) {
		    new Integer(result);
		}
		int result3 = result2;
		return result + zero;
	}

	public int multiply(int n, int m) {
    int result = 0;
    for (int j = 0; j < m; j++) {
          result += n;
      }
    return result;
	}

	public int substract(int a, int b) {
		int result = a - b;
		return result;
	}

	public void catchesException() {
	  int i = 0;
	  try {
      if (i == 13) {
          throw new NumberFormatException();
      }
      i = 23;
	  } catch (NumberFormatException e) {
	      System.out.println("Exception abgefangen");
	  }
	  i = 42;
	}

	public double divide(double divisor, double divident) {
		double result;
		if (divident == 0) {
		    result = Double.POSITIVE_INFINITY;
		} else {
		    result = divisor / divident;
		}
		double result2 = result;
		return result;
	}

	public int justALoop() {
    int a = 2;
    for (int i = 0; i < 10;) {
    	i = i + a;
    }
    return a;
	}
}
