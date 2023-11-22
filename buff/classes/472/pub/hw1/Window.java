package window;

import glyph.*;

public interface Window {

    void drawCharacter(char c, int x, int y);
    void drawRectangle(int x, int y, int width, int height);

    int charWidth(char c);
    int charHeight(char c);

    void setContents(Glyph glyph);

}
