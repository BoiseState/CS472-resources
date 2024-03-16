void first(Traversal kind);
void next();
boolean isDone();
Glyph getCurrent();

// ...

{
    Glyph g;
    // ...
    for (g.first(PREORDER); !g.isDone(); g.next()) {
     	Glyph current=g.getCurrent();
  	  // do some analysis
    }
}
