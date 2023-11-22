import java.util.*;

public class Map2<Key1,Key2,Data> implements Iterable<KeyPair<Key1,Key2>> {

    private Map<KeyPair<Key1,Key2>,Data> _m;

    public Map2() { _m=new TreeMap<KeyPair<Key1,Key2>,Data>(); }

    public void put(Key1 k1, Key2 k2, Data d) {
	KeyPair<Key1,Key2> kp=new KeyPair<Key1,Key2>(k1,k2);
	Data old=_m.get(kp);
	if (old==null)
	    _m.put(kp,d);
	else if (!old.equals(d))
	    Error.warn("Map2.put(): duplicate table entry ("
		       +k1+","+k2+","+old+"/"+d+")");
    }

    public Data get(Key1 k1, Key2 k2) {
	KeyPair<Key1,Key2> kp=new KeyPair<Key1,Key2>(k1,k2);
	return _m.get(kp);
    }

    public Iterator<KeyPair<Key1,Key2>> iterator() {
	return _m.keySet().iterator();
    }

    public String toString() {
	String s="";
	for (KeyPair<Key1,Key2> kp: this)
	    s+="("+kp.k1()+","+kp.k2()+","+get(kp.k1(),kp.k2())+")\n";
	return s;
    }
}
