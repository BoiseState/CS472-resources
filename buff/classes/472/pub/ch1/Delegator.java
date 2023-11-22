// javac Delegator.java && java Delegator

public class Delegator {

    private Delegate e;
    private int data;

    public Delegator(int d) {
	e=new Delegate();
	data=d;
    }

    public void request() { data=e.complexMethod(this); }

    public int get_data() { return data; }

    public static void main(String[] args) {
	Delegator r=new Delegator(123);
	r.request();
	System.out.println(r.get_data());
    }
	
}
