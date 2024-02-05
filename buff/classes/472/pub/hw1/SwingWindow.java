package window;

import glyph.*;

import java.awt.*;
import javax.swing.*;

public class SwingWindow implements Window {

  private final int width=200;
  private final int height=200;

  private Window _window;
  private Glyph _glyph;
  private Pane _pane;
  private JFrame _jFrame;
  private Graphics _graphics;
  private FontMetrics _fm;

  private class Pane extends JPanel {

    public void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      _graphics=graphics;
      if (_glyph!=null)
        _glyph.draw(_window);
    }

  }

  public SwingWindow(String title) {
    _window=this;
    JFrame.setDefaultLookAndFeelDecorated(true);
    _jFrame=new JFrame(title);
    _jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _jFrame.setJMenuBar(new JMenuBar());
    _jFrame.pack();
    _jFrame.setSize(width,height);
    _jFrame.setVisible(true);
    _fm=_jFrame.getGraphics().getFontMetrics();
  }

  public int charWidth(char c) {
    return _fm.charWidth(c);
  }

  public int charHeight(char c) {
    return _fm.getHeight();
  }

  private int charBaseline(char c) {
    return _fm.getLeading()+_fm.getAscent();
  }

  public void drawCharacter(char c, int x, int y) {
    _graphics.drawString(c+"",x,y+charBaseline(c));
  }

  public void drawRectangle(int x, int y, int width, int height) {
    _graphics.drawRect(x,y,width,height);
  }

  public void setContents(Glyph glyph) {
    _glyph=glyph;
    _pane=new Pane();
    _jFrame.setContentPane(_pane);
    _jFrame.setVisible(true);
  }

}
