import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainBufferedReader {

  public static void main(String[] args) {
      InputStreamReader file=new InputStreamReader(System.in);
      BufferedReader inp=new BufferedReader(file);
      try {
	  String s;
	  while (((s=inp.readLine())!=null))
	      System.out.println(s);
	  inp.close();
      } catch (Exception e) {
	  e.printStackTrace();
      }
  }

}
