package iterator;

// FactoryMethod(107)

public interface Iteratee<Item> {

  Iterator<Item> createIterator();

}
