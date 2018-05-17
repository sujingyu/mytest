import java.util.LinkedList;
import java.util.List;

public class FindPrimeNum {

	
	public static void main(String[] args) {
		List<Integer> pirmelist = new LinkedList<>();
		for(int i=2;i<10000;i++){
			isPrime(i,pirmelist);
		}
		System.out.println(pirmelist.size());
	}

	public static boolean isPrime(int x,List<Integer> pirmelist){
		for(int i=2;i<Math.sqrt(x);i++){
			if(x%i==0){
				return false;
			}
		}
		pirmelist.add(x);
		return true;
	}
}
