package command;

import glyph.*;
import iterator.*;

// Command(233): ConcreteCommand

public class PrintWordsCommand extends Command {

  private Glyph _glyph;

  public PrintWordsCommand(Glyph glyph) {
    _glyph=glyph;
  }

  public void execute() {
    GlyphVisitor v=new WordsVisitor();
    Iterator<Glyph> i=new PreorderIterator<>(_glyph);
    for (i.init(); !i.done(); i.next())
      i.item().accept(v);
    System.out.println(v);
  }

  public boolean reversible() { return false; }

}
