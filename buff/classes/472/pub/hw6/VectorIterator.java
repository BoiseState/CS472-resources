package iterator;

// Iterator(257): ConcreteIterator

import java.util.*;

public class VectorIterator<Item> implements Iterator<Item> {

  private Vector<Item> _v;
  private int _i;

  public VectorIterator(Vector<Item> v) { _v=v; init(); }

  public void init() { _i=0; }
  public void next() { _i++; }
  public boolean done() { return _i>=_v.size(); }

  public Item item() {
    try {
      return _v.get(_i);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("VectorIterator.item(): "+e);
    }
    return null;
  }

}
