package glyph;

// Visitor(331): ConcreteVisitor

import java.util.*;
import embellishment.*;

public class WordsVisitor implements GlyphVisitor {

  private String _word;
  private Vector<String> _words;

  public WordsVisitor() {
    _word="";
    _words=new Vector<>();
  }

  private void add() {
    if (_word.length()>0)
      _words.add(_word);
    _word="";
  }

  public void visit(Character e) {
    switch (e.getChar()) {
      case ' ': case ',': case '.':
        add();
        break;
      default:
        _word+=e.getChar();
        break;
    }
  }

  public void visit(Glyph e)         { add(); }
  public void visit(Rectangle e)     { add(); }
  public void visit(Row e)           { add(); }
  public void visit(Column e)        { add(); }
  public void visit(Embellishment e) { add(); }

  public String toString() {
    String res="";
    add();
    for (String word: _words)
      res+=word+"\n";
    return res;
  }

}
