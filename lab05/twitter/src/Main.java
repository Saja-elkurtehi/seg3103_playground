public class Main {

  public static void main( String[] args ) {
    printToScreen("Twitter Text Feed");
    Twitter twitter = new Twitter();
    printToScreen(twitter.loadTweet());
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