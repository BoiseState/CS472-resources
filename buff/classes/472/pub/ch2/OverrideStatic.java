// javac OverrideStatic.java

interface Foo {
    static void foo();		// illegal
}

abstract class Bar {
    abstract static void bar();	// illegal
}

abstract class Zap {
    static void zap() {}
}

class NewFoo implements Foo {
    public static void foo() { System.out.println("new foo"); }
}

class NewBar extends Bar {
    public static void bar() { System.out.println("new bar"); }
}

class NewZap extends Zap {
    public static void zap() { System.out.println("new zap"); }
}

public class OverrideStatic {

    public static void main(String[] args) {
	NewFoo.foo();
	NewBar.bar();
	NewZap.zap();
    }

}
