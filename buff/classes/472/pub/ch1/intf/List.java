// javac List.java && java List

interface Stack<Data> {
  Data pop();
  void push(Data data);
}

interface Queue<Data> {
  Data next();
  void wait(Data data);
}

public class List<Data> implements Stack<Data>,Queue<Data> {
  public Data pop()           { return null; }
  public void push(Data data) {}
  public Data next()          { return null; }
  public void wait(Data data) {}

  public static void main(String[] args) {
    List<Integer> l=new List<>();
    l.push(1);
    Integer i=l.next();
    l.push(i);
    i=l.pop();
  }
}
