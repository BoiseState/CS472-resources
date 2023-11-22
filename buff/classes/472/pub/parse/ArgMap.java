import java.util.*;

public class ArgMap implements Iterable<Arg> {

    private Map<String,Arg> m;

    public ArgMap() { m=new Hashtable<String,Arg>(); }

    public void put(String s, Arg a) { m.put(s,a); }
    public Arg get(String s) { return m.get(s); }

    public Iterator<Arg> iterator() { return m.values().iterator(); }

}
