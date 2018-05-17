import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringEscapeUtils;



public class Test1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("abcd");
		list.add("abcd122");
		System.out.println(list.toString());
	}
	
	
	/**
	 * 
	 @Title: unescapeHtml 
	 @Description:  转码    
	 @return void
	 */
	public void unescapeHtml(){
		String str = "{&quot;type&quot;:&quot;bulletin&quot;,&quot;props&quot;:{&quot;title&quot;:&quot;111&quot;,&quot;notice&quot;:&quot;false&quot;}}";
		str = StringEscapeUtils.unescapeHtml(str);
		System.out.println(str);
	}

}
