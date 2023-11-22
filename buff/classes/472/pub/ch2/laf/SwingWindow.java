import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingWindow implements Window {

    private Panel _panel;
    private JPanel _jPanel;
    private JFrame _jFrame;

    private final int width=200;
    private final int height=200;

    private static String laf;

    public static void setLaF(int i) {
	if (i==1) laf="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	if (i==2) laf="com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    }

    private void init() {
	_panel=new Panel();
	_jPanel=new JPanel(new BorderLayout());
	_jPanel.add(_panel,BorderLayout.CENTER);
	_jPanel.setOpaque(true);
    }

    public SwingWindow(String title) {
	if (laf!=null) {
	    try {
		UIManager.setLookAndFeel(laf);
	    } catch (Exception e) {
		System.out.println(e);
	    }
	}
	init();
	JFrame.setDefaultLookAndFeelDecorated(true);
	_jFrame=new JFrame(title);
        _jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _jFrame.setJMenuBar(new JMenuBar());
	_jFrame.setContentPane(_jPanel);
        _jFrame.setSize(width,height);
        _jFrame.setVisible(true);
    }

}
