// javac InclRand.java && java InclRand

import java.util.Random;

class A           { public String foo() { return "A"; } }

class X extends A { public String foo() { return "X"; } }
class Y extends A { public String foo() { return "Y"; } }

class Z extends Y { public String foo() { return "Z"; } }

public class InclRand {

  public static void main(String[] args) {
    A a=null;
    Random rand=new Random();
    for (int i=1; i<=10; i++) {
      switch (rand.nextInt(4)) {
        case 0: a=new A(); break;
        case 1: a=new X(); break;
        case 2: a=new Y(); break;
        case 3: a=new Z(); break;
      }
      System.out.println(a.foo());
    }
  }

}
