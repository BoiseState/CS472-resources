// Observer(293).Observer
// Composite(163).Composite/Component/Leaf (optional: for nested views)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View implements Observer {

    private Model model;
    private JFrame frame;
    private JLabel label;

    public View(Model model) {
	this.model=model;
	JFrame.setDefaultLookAndFeelDecorated(true);
	frame=new JFrame("Model/View/Controller Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new JMenuBar());
        frame.setSize(500,500);
	label=new JLabel();
	frame.add(label);
        frame.setVisible(true);
	model.attach(this);
    }

    public void addKeyListener(KeyListener keyListener) {
	frame.addKeyListener(keyListener);
    }

    public void update() {
	label.setText(model.getState().str.toString());
    }

}
