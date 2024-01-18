import java.util.*;

public class HashTable<Key,Data> implements Table<Key,Data> {

  private Hashtable<Key,Data> table;

  public HashTable() {
    table=new Hashtable<Key,Data>();
  }

  public Data get(Key key) {
    return table.get(key);
  }

  public void put(Key key, Data data) {
    table.put(key,data);
  }

}
