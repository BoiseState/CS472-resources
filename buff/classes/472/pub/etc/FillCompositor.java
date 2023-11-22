// Strategy(315): ConcreteStrategyA

public class FillCompositor extends SimpleCompositor {

    private int _w, _h;

    public FillCompositor(Window window, int w, int h) {
	super(window); _w=w; _h=h;
    }

    public void compose() {
	super.compose();
	Glyph p=_composition;
	int gaps=getGaps(p);
	if (gaps>0) {
	    // much pixel arithmetic
	    ...
	    Rect cursor=new Rect(...);
	    try {
		Glyph c;
		for (int i=0; (c=p.child(i))!=null; i++) {
		    // much x/y arithmetic
		    ...
		    c.computePosition(cursor);
		    c.compose();
		    p.computeCursorAfter(cursor,c);
		}
	    } catch (GlyphException e) {}
	}
	// much w/h arithmetic
	...
    }

}
