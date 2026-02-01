// javac Penguin.java && java Penguin

interface Bird {
  void fly();
  void hop();
}

public class Penguin implements Bird {

  // private                    // illegal
  public                        // legal
    void fly()       { System.out.println("can't fly"); }
  public void hop()  { System.out.println("hop"); }

  public static void main(String[] args) {
    Penguin h=new Penguin();
    // Bird h=new Penguin();
    h.hop();
    h.fly();
  }

}
