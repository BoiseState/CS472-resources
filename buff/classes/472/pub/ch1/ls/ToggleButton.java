import java.awt.*;
import java.awt.event.*;

public class ToggleButton extends Button implements ActionListener {

    private String label1, label2;
   
    public ToggleButton(String label1, String label2) {
        super(label1);
        this.label1=label1; 
        this.label2=label2;
        addActionListener(this);
    } 

    public void actionPerformed(ActionEvent e) {
        String s=label1;
        label1=label2;
        label2=s;
        setLabel(label1);
    }

}
