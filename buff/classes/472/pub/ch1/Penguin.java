// javac Penguin.java && java Penguin

interface Bird {
    void fly();
    void hop();
}

public class Penguin implements Bird {

    private void fly() {} 	// illegal
    public  void hop() { System.out.println("hop"); }

    public static void main(String[] args) {
	Penguin h=new Penguin();
	h.hop();
    }

}
