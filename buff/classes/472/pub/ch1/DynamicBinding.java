// javac DynamicBinding.java && java DynamicBinding

public class DynamicBinding {

  private class FooTable<Key, Data> implements Table<Key,Data> {
    public Data get(Key key)            { return null; }
    public void put(Key key, Data data) { System.out.println("foo"); }
  }

  private class BarTable<Key, Data> implements Table<Key, Data> {
    public Data get(Key key)            { return null; }
    public void put(Key key, Data data) { System.out.println("bar"); }
  }

  public DynamicBinding() {
    Table<String,Integer> t;
    if (Math.random()<0.5)
      t=new FooTable<String,Integer>();
    else
      t=new BarTable<String,Integer>();
    t.put("Hi",100);
  }

  public static void main(String[] args) {
    for (int i=1; i<=10; i++)
      new DynamicBinding();
  }

}
