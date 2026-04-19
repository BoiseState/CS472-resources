package iterator;

public class NullIterator<Item> implements Iterator<Item> {

  public void init() {}
  public void next() {}
  public boolean done() { return true; }
  public Item item()    { return null; }

}
