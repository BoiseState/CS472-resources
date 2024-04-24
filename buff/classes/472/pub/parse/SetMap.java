import java.util.*;

public class SetMap<Key  extends Comparable<Key>,
		                Data extends Iterable<Key>
                               & SetMapData<Key,Data>> {

  private String _name;
  private Data _proto;
  private Map<Key,Data> _map;

  public SetMap(String name, Data proto) {
    _name=name;
    _proto=proto;
    _map=new TreeMap<Key,Data>();
  }

  public Data get(Key key) {
    Data d=_map.get(key);
    if (d==null)
      d=_proto.newData();
    return d;
  }

  public void put(Key key, Key data) {
    Data d=_map.get(key);
    if (d==null) {
      d=_proto.newData();
      _map.put(key,d);
    }
    d.add(data);
  }

  public int size(Key key) {
    return get(key).size();
  }

  public boolean add(Key key, Data data) {
    int size=size(key);
    for (Key k: data)
      put(key,k);
    return size!=size(key);
  }

  public String toString() {
    String s="";
    for (Key key: _map.keySet())
      s+=_name+"("+key+")="+get(key)+"\n";
    return s;
  }

}
