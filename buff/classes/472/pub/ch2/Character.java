public class Character extends Glyph {

  // ...

  public void accept(GlyphVisitor v) { v.visit(this); }

}
