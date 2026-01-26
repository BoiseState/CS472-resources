// javac TryBox.java && java TryBox

public class TryBox {

  public static void main(String[] args) {
    Box<String> b;		// program to an interface!
    String s="stuff";

    b=new BoxMagic<>();
    b.put(s);
    System.out.println(b.get());
    System.out.println(b.get());

    b=new BoxPlain<>();
    b.put(s);
    System.out.println(b.get());
    System.out.println(b.get());
  }

}
