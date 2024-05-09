public class Main {

  public static void main( String[] args ) {

    printToScreen("Newmath (type 'exit' to exit program)");

    while (true) {

      printToScreen("Numerator: " , false);
      String numeratorInput = System.console().readLine();

      if ("exit".equals(numeratorInput)) {
        break;
      }

      printToScreen("Demoninator: " , false);
      String denominatorInput = System.console().readLine();

      int numerator = Integer.parseInt(numeratorInput);
      int denominator = Integer.parseInt(denominatorInput);

      int result = Newmath.div(numerator, denominator);
      printToScreen(String.format("%d / %d = %d", numerator, denominator, result));
    }
  }

  private static void printToScreen(String message) {
    printToScreen(message, true);
  }

  private static void printToScreen(String message, boolean newline) {
    if (message != null) {
      System.out.print(message);
      if (newline) {
        System.out.println("");
      }
    }
  }

}