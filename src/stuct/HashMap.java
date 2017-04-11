package stuct;


public class HashMap {
	
	public int size = 0;
	private int lenth = 10;
	public Entry[] array ;
	
	private class Entry{
		public String key;
		public Object value;
		public Entry next;
		public Entry(String s,Object obj){
			this.key = s;
			this.value = obj;
		}
	}
	
	public HashMap(){
		array = new Entry[lenth];
	}
	
	public HashMap(int lenth){
		if(lenth>0){
			this.lenth = lenth;
		}
		array = new Entry[this.lenth];
	}
	
	public void put(String key,Object value){
		Entry en = new Entry(key,value);
		int i = key.hashCode()%lenth;
		Entry temp = array[i];
		array[i] = en;
		array[i].next = temp;
	}
	
	public Object get(String key){
		int i = key.hashCode()%lenth;
		Entry en = array[i];
		while(en!=null&&!key.equals(en.key)){
			en = en.next;
		}
		if(en==null){
			return null;
		}else{
			return en.value;
		}
	}
	
	public void remove(String key){
		int i = key.hashCode()%lenth;
		Entry pre = array[i];
		Entry en = pre;
		while(en!=null){
			if(key.equals(en.key)){
				if(pre == en){
					array[i] = en.next;
				}else{
					pre.next = en.next;	
				}
				en = en.next;
			}else{
				pre = en;
				en = en.next;
			}
		}
	}
	
	public static void main(String[] args) {
		HashMap map = new HashMap(1);
		map.put("sujy", "sujingyu");
		map.put("wsl", "wushuiling");
		map.remove("sujy");
		String s = (String)map.get("sujy");
		System.out.println(s);
	}

}
