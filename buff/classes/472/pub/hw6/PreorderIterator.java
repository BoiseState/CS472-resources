package iterator;

// Iterator(257): ConcreteIterator

import java.util.*;

public class PreorderIterator<Item extends Iteratee<Item>>
  implements Iterator<Item> {

  private Item _root;
  private Stack<Iterator<Item>> _stack;

  public PreorderIterator(Item root) {
    _root=root;
    init();
  }

  public void init() {
    _stack=new Stack<>();
    Iterator<Item> i=_root.createIterator();
    i.init();
    if (!i.done())
      _stack.push(i);
  }

  public void next() {
    Iterator<Item> i=_stack.peek().item().createIterator();
    i.init();
    _stack.push(i);
    while (!_stack.empty()&&_stack.peek().done()) {
      _stack.pop();
      if (!_stack.empty()&&!_stack.peek().done())
        _stack.peek().next();
    }
  }

  public boolean done() {
    return _stack.empty();
  }

  public Item item() {
    return _stack.empty() ? null : _stack.peek().item();
  }

}
