package stuct;

public class StackBy2Queue {
	 public Queue q1 = new Queue();
	 public Queue q2 = new Queue();
	 public int size = 0;
	 
	 public void push(int a){
		 size++;
		 if(size==0){
			 q1.add(a);
			 return;
		 }
		 if(q1.size==0){
			 q2.add(a);
		 }else if(q2.size==0){
			 q1.add(a);
		 }else{
			 System.out.println("内部错误");
		 }
	 }
	 
	 public int pop(){
		 if(size>0){
			 size --;
			 if(q1.size>0&&q2.size==0){
				 while(q1.size>1){
					 q2.add(q1.get());
				 }
				 return q1.get();
			 }else if(q2.size>0&&q1.size==0){
				 while(q2.size>1){
					 q1.add(q2.get());
				 }
				 return q2.get();
			 }
		 }
		 return 0;
	 }
	 
	 public static void main(String[] args) {
		 StackBy2Queue s = new StackBy2Queue();
		for(int i=0;i<5;i++){
			s.push(i);
		}
		while(s.size>0){
			System.out.println(s.size+" "+s.pop());
		}
	}
	 
}
