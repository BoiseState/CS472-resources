Glyph g;
...
Iterator<Glyph> i=g.createIterator();
for (i.first(); !i.isDone(); i.next()) {
	Glyph current=i.getCurrent();
	// do something with current
}
