import java.util.Scanner;

public class MainScanner {

  public static void main(String[] args) {
    Scanner inp=new Scanner(System.in);
    while (inp.hasNextLine()) {
	String s=inp.nextLine();
	System.out.println(s);
    }
    inp.close();
  }

}
