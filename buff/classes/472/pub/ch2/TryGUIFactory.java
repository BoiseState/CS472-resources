// javac TryGUIFactory.java

interface Label { void foo(); }
class RedLabel implements Label
    { public void foo() { System.out.println("red"); } }
class GreenLabel implements Label
    { public void foo() { System.out.println("green"); } }

interface GUIFactory {
    Label labelFactoryMethod();
}

class StandardGUIFactory<T> implements GUIFactory {
    public Label labelFactoryMethod() { return new T(); } // illegal
}

public class TryGUIFactory {

    public static void main() {
	GUIFactory guiFactory=new StandardGUIFactory<RedLabel>();
	Label label=guiFactory.labelFactoryMethod();
	label.foo();
    }

}
