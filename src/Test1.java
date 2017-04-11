import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new LinkedHashMap<>();
		map.put("sujy", "sujingyu");
		map.put("wsl", "wushuiling");
		map.put("yl", "yanglan");
		map.put("hxw", "huxianwen");
		map.get("sujy");
		Iterator ite = map.entrySet().iterator();
		
		
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}

}
