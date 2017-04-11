import java.util.Date;

public class Test extends Thread{

	@Override
	public void run() {
		getName();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date(1465747200000l));
		Test t = new Test();
		t.setName("3");
	}

}
