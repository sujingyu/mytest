package stuct;

import java.util.Stack;
/**
 * 链表的实现
 * http://www.cnblogs.com/smyhvae/p/4782595.html
 * 面试提
 * @author kingdee
 *
 */
public class LinkList {
	private  int lenth = 0;
	private node head = null;
	
	private class node{
		int item;
		node next;
		public node(int i,node n){
			this.item = i;
			this.next = n;
		}
	}

	public int getLenth() {
		return lenth;
	}
	
	public void insert(int index,int n){
		if(index>lenth){
			System.out.println("插入位置超过链表长度！错误！");
			return;
		}
		node node = new node(n, null);
		node current = head;
		lenth++;
		if(head==null){
			head = node;
			return;
		}
		int i = 0;
		while(i++<(index-1)){
			current = current.next;
		}
		node next = current.next;
		current.next = node;
		node.next = next;
	}
	
	public void print(){
		if(head == null)return;
		for(node n = head;n!=null;n=n.next){
			System.out.println(n.item);
		}
	}
	
	public void remove(int index){
		if(index>lenth){
			System.out.println("删除位置超过链表长度！错误！");
			return;
		}
		if(index==0){
			head=head.next;
			return;
		}
		node current = head;
		int i = 0;
		while(i++<(index-1)){
			current = current.next;
		}
		if(current.next==null){
			current = null;
			return;
		}
		current.next = current.next.next;
	}
	
	/**
	 * 查找倒数第K个节点
	 * @param k
	 * @return
	 */
	public int getLastNode(int k){
		if(k<=0||k>lenth){
			
		}
		node i = head;
		node j = head;
		for(int a=0;a<k;a++){
			j=j.next;
		}
		while(j!=null){
			i=i.next;
			j=j.next;
		}
		return i.item;
	}
	
	/**
	 * 得到中间节点
	 * @return
	 */
	public int getListMid(){
		node i = head;
		node j = head;
		while(j!=null&&j.next!=null){
			i = i.next;
			j= j.next.next;
		}
		return i.item;
	}
	
	public void reverseList(){
		if(head==null||head.next==null){
			return;
		}
		node current = head ;
		node newhead = null;
		node next = null;
		while(current!=null){
			next = current.next;
			current.next = newhead;
			newhead = current;
			current = next;
		}
		head = newhead;
	}
	
	/**
	 * 逆序打印 不破坏结构 使用栈实现
	 */
	public void reversePrint(){
		Stack s = new Stack<>();
		node current = head;
		while(current!=null){
			s.add(current.item);
			current = current.next;
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	/**
	 * 逆序打印 使用递归的方式实现  如果链表过长  可能导致栈溢出
	 * @param n
	 */
	public void reversePrint1(node n){
		if(n==null){
			return;
		}
		reversePrint1(n.next);
		System.out.println(n.item);
	}
	
	public boolean hasCycle(){
		node i = head;
		node j = head;
		while(j!=null&&j.next!=null){
			i = i.next;
			j = j.next.next;
			if(i==j){
 				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		LinkList ll = new LinkList();
		for(int i =0;i<7;i++){
			ll.insert(i, i);
		}
		ll.insert(3, 8);
		ll.insert(ll.getLenth(), 66);
		ll.print();
//		ll.reverseList();
		ll.reversePrint1(ll.head);
//		ll.remove(8);
		
//		int k = ll.getListMid();
//		System.out.println(k);
	}
	
}
