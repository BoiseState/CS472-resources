// javac TryBox.java && java TryBox

public class TryBox {

  public static void main(String[] args) {
    Box<String> b;
    String s="stuff";

    b=new BoxMagic<String>();
    b.put(s);
    System.out.println(b.get());
    System.out.println(b.get());

    b=new BoxPlain<String>();
    b.put(s);
    System.out.println(b.get());
    System.out.println(b.get());
  }

}
