package stuct;

public class QueueBy2Strack {

	public int size = 0;
	
	public Strack inter = new Strack();
	public Strack outer = new Strack();
	
	public void add(int i){
		inter.push(i);
		size++;
	}
	
	public int get(){
		size --;
		if(outer.size>0){
			return outer.pop();
		}else{
			while(inter.size>0){
				outer.push(inter.pop());
			}
			return outer.pop();
		}
	}
	
	
	public static void main(String[] args) {
		QueueBy2Strack q = new QueueBy2Strack();
		for(int i =0;i<3;i++){
			q.add(i);
		}
		while(q.size>0){
			System.out.println(q.get());
		}
		
	}
}
