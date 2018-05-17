package singleton;

public class SingleTon4 {

	private static SingleTon4 instance = null;
	static {
		instance = new SingleTon4();
	}
	private SingleTon4(){}
	
	public static SingleTon4 getInstance(){
		return instance;
	}
}
