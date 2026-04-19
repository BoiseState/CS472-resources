package iterator;

// Iterator(257): Iterator

public interface Iterator<Item> {

  void init();
  void next();
  boolean done();
  Item item();

}
