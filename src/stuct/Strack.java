package stuct;

public class Strack {
	
	public int size = 0;
	public Node head = null;
	
	public class Node{
		public int data = 0;
		public Node next = null;
		Node(int i,Node next){
			this.data = i;
			this.next = next;
		}
	}
	
	public void push(int i){
		Node n = new Node(i,head);
		head = n;
		size++;
	}
	
	public int pop(){
		Node temp = head;
		head = head.next;
		size--;
		return temp.data;
	}
	
	public static void main(String[] args) {
		Strack s = new Strack();
		for(int i=0;i<5;i++){
			s.push(i);
		}
		while(s.head!=null){
			
			System.out.println(s.size+" "+s.pop());
		}
	}
}
