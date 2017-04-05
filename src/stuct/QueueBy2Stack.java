package stuct;

public class QueueBy2Stack {

	public int size = 0;
	
	public Stack inter = new Stack();
	public Stack outer = new Stack();
	
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
		QueueBy2Stack q = new QueueBy2Stack();
		for(int i =0;i<3;i++){
			q.add(i);
		}
		while(q.size>0){
			System.out.println(q.get());
		}
		
	}
}
