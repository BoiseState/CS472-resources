public class Error {

  public static void warn(String s) {
    System.err.println(s);
  }

  public static void fatal(String s) {
    System.err.println(s);
    System.exit(1);
  }

  public static void usage(String s) {
    System.err.println(s);
    System.err.print(Args.instance());
    System.exit(1);
  }

}
