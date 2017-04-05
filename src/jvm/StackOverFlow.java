package jvm;

/**
 * 线程栈溢出
 * 
 * @author kingdee
 *
 */
public class StackOverFlow {
	public static volatile int i =0;
	
	public static void recursion() {
		System.out.println(i++);
		recursion();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			recursion();
		} catch (Exception e) {
			
		}
	}

}
