// javac Coercion.java && java Coercion

class A {}

class B {}

public class Coercion {

  public static void main(String[] args) {
    int i=77;
    double d=1.234;
    d=(double)i;                // explicit
    i=(int)d;                   // explicit
    d=i;                        // implicit
    System.out.println(i+" "+d);
    // illegal:
    // i=d; // implicit

    var a=new A();
    var b=new B();
    System.out.println(a+" "+b);
    // illegal:
    // a=b;    // implicit
    // b=a;    // implicit
    // a=(A)b; // explicit
    // b=(B)a; // explicit
  }

}
