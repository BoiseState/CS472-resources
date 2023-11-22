// javac Overloading.java && java Overloading

public class Overloading {

    private static void foo(int i)    { System.out.println("foo(int i)"); }
    private static void foo(double d) { System.out.println("foo(double d)"); }

    public static void main(String[] args) {
	int i=77;
	double d=1.234;
	foo(i);
	foo(d);
    }
	
}
