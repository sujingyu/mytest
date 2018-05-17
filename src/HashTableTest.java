import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> group = new Hashtable();
		group.put("ad", 34);
		Integer a = group.get("ad");
		System.out.println(a+" "+group.size());
		
	}

}
