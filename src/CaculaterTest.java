/**
 * 计算保险
 * @author kingdee
 *
 */
public class CaculaterTest {

	public static void main(String[] args) {
		double sum = 0;
		for(int i=0;i<30;i++){
			sum = sum +Math.pow(1.05,i);
		}
		System.out.println(sum*3870);
		
	}

}
