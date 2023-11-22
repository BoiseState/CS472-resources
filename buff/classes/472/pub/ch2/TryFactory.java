// javac TryFactory.java && java TryFactory

interface Product {
    Product factoryMethod();
}

class ConcreteProduct implements Product {
    public Product factoryMethod() { return new ConcreteProduct(); }
}

class Creator {

    private Product product;

    public Creator(Product product) { this.product=product; }

    public Product create() { return product.factoryMethod(); }

}

public class TryFactory {

    public static void main(String[] args) {
	Creator creator=new Creator(new ConcreteProduct());
	// ...
	Product product=creator.create();
	System.out.println(product);
    }

}
