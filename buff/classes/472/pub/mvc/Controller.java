// Observer(293).Observer
// Strategy(315).Context (optional: for different controllers)

import java.awt.event.*;

public class Controller implements Observer, KeyListener {

    private Model model;

    public Controller(Model model) {
	this.model=model;
	model.attach(this);
    }

    public void update() {}

    private void inst(char c, State s) { s.str.insert(s.pos++,c); } 
    private void back(State s) { if (s.pos>0) s.pos--; }
    private void forw(State s) { if (s.pos<s.str.length()) s.pos++; }
    private void dele(State s) { if (s.pos>0) s.str.deleteCharAt(--s.pos); }

    private static char ctl(char c) { return (char)(c&'\u001f'); }

    private void doKey(char c) {
	State state=model.getState();
	if (c>=' ' && c<='~') inst(c,state);
	if (c==ctl('B')) back(state);
	if (c==ctl('F')) forw(state);
	if (c==ctl('H')) dele(state);
	if (c==ctl('Q')) System.exit(0);
	model.setState(state);
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) { doKey(e.getKeyChar()); }

}
