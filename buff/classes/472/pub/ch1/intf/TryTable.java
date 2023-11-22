// javac TryTable.java && java TryTable

public class TryTable {

    public static void main(String[] args) {
	Table<String,Integer> t=new HashTable<String,Integer>();
	t.put("Hi",100);
	System.out.println(t.get("Hi"));
    }

}
