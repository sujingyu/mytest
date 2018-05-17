package singleton;

/**
 * 饿汉线程安全
 * @author kingdee
 *
 */
public class SingleTon2 {

	private static SingleTon2 instance = new SingleTon2();
	private SingleTon2() {
	}

	public static SingleTon2 getInstance(){
		return instance;
	}
	
}
