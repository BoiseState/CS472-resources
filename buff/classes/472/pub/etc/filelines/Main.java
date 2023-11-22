public class Main {

    public static void main(String[] args) {
	String name=args.length==0 ? null : args[0];
	for (String s: new FileLines(name))
	    System.out.println(s);
    }
    
}
