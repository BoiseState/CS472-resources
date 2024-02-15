// javac TryFactory2.java && java TryFactory2

interface Product {}

class ConcreteProduct implements Product {}

class Creator<Product> {

  private Class<Product> c;

  public Creator(Class<Product> c) { this.c=c; }
	
  public Product create() {
  	try {
	    return c.getDeclaredConstructor().newInstance();
	  } catch (Exception e) {
	    System.out.println(e);
	  }
	  return null;
  }

}

public class TryFactory2 {

  public static void main(String[] args) {
	  Creator<ConcreteProduct> creator=
	    new Creator<ConcreteProduct>(ConcreteProduct.class);
	  // ...
  	Product product=creator.create();
	  System.out.println(product);
  }

}
