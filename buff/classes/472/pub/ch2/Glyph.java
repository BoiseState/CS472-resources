interface Glyph {
    void draw(Window window);
    Bounds getBounds();
    boolean intersects(Point point);
    void insert(Glyph glyph, int position);
    void remove(Glyph glyph);
    Glyph child(int position);
    Glyph getParent();
}
