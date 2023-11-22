// javac Inclusion.java && java Inclusion

class A {
    public String foo() { return "A"; }
}

class X extends A {
    public String foo() { return "X"; }
}

class Y extends A {
    public String foo() { return "Y"; }
}

class Z extends Y {
    public String foo() { return "Z"; }
}

public class Inclusion {

    public static void main(String[] args) {
	A a;
	a=new A(); System.out.println(a.foo());
	a=new X(); System.out.println(a.foo());
	a=new Y(); System.out.println(a.foo());
	a=new Z(); System.out.println(a.foo());
    }

}
