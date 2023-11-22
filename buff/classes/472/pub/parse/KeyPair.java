public class KeyPair<Key1,Key2> implements Comparable<KeyPair<Key1,Key2>> {

    private Key1 _k1;
    private Key2 _k2;

    public KeyPair(Key1 k1, Key2 k2) { _k1=k1; _k2=k2; }

    public Key1 k1() { return _k1; }
    public Key2 k2() { return _k2; }

    public int compareTo(KeyPair<Key1,Key2> k) {
	return toString().compareTo(k.toString());
    }

    public String toString() {
	return "<"+k1()+"@"+k2()+">";
    }

}
