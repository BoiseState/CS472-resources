public abstract class CompositeGlyph extends Glyph {

    private Vector<Glyph> _children;

    ...

    public Iterator<Glyph> createIterator() {
	return new VectorIterator<Glyph>(_children);
    }

}
