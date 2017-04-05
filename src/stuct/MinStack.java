package stuct;

public class MinStack {

	Stack s = new Stack();
	Stack sub = new Stack();
	int size = 0;
	
	public void push(int i){
		size++;
		s.push(i);
		if(sub.size>0){
			if(i>sub.peek()){
				sub.push(sub.peek());
				return;
			}
		}
		sub.push(i);;
	}
	
	public int pop(){
		size -- ;
		sub.pop();
		return s.pop();
	}
	
	public int min(){
		return sub.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
