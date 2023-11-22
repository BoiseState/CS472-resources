// javac LightSwitch.java && java LightSwitch

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightSwitch implements ActionListener {

    private ToggleButton button;
    
    public LightSwitch() {	             // delegator
        button=new ToggleButton("off","on"); // delegate
        button.addActionListener(this);      // delegation
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new JMenuBar());
	frame.pack();
        frame.setSize(300,200);
        frame.add(button);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("The light is "+button.getLabel());
    }

    public static void main(String[] args) {
	new LightSwitch();
    }

}
