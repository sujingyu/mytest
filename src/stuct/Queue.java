package stuct;

public class Queue {

	public int size = 0;
	public Node head = null;
	public Node current = null;
	
	public class Node{
		public int date;
		public Node next = null;
		public Node(int i){
			this.date = i;
		}
	}
	
	public void add(int i){
		size++;
		Node n = new Node(i);
		if(head ==null){
			head = current = n;
		}else{
			current.next = n;
			current = n;
		}
	}

	public int get(){
		size--;
		if(head ==null){
			return 0;
		}
		int data = head.date;
		head = head.next;
		return data;
	}
	
	
	public static void main(String[] args) {
		Queue q= new Queue();
		for(int i = 0;i<5;i++){
			q.add(i);
		}
		while(q.head!=null){
			System.out.println(q.get());
		}
	}
}
