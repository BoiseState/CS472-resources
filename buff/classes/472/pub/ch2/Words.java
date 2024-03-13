GlyphVisitor v=new WordsVisitor();
Iterator<Glyph> i=new PreorderIterator(glyph);
for (i.init(); !i.done(); i.next())
  i.item().accept(v);
System.out.println(v);
