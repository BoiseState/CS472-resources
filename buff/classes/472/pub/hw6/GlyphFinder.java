package glyph;

import util.*;

// ChainOfResponsibility(223): Handler

interface GlyphFinder {
  Glyph find(Point p);
}
