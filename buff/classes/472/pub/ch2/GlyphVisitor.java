interface GlyphVisitor {
  void visit(Glyph e);
  void visit(Character e);
  void visit(Rectangle e);
  void visit(Row e);
  void visit(Column e);
  // ...
}
