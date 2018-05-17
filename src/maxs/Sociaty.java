package maxs;

import java.util.Arrays;

public class Sociaty {

	public static void main(String[] args) {
		double[] arrays = new double[100];
		for(int i=0;i<arrays.length;i++){
			if(i<10){
				arrays[i] = 100;
			}else{
				arrays[i] = 100;
			}
		}
		arrays = demo1(arrays);
//		Arrays.sort(arrays);
//		printArray(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	public static double[] demo1(double[] arrays){
		for(int i=0;i<100000;i++){
			for(int j=0;j<arrays.length;j++){
				if(arrays[j]>0){
					if(j<10){
						arrays[j] = (int) (arrays[j] - 0.9);
					}else{
						arrays[j]--;
					}
				}
				int lucky = (int)(Math.random()*100);
				arrays[lucky]++;
			}
		}
		return arrays;
	}
	
	public static void printArray(int[] arrays){
		for(int i=0;i<arrays.length;i++){
			System.out.print("arrays["+i+"]:");
			for(int j=1;j<=arrays[i];j++){
				System.out.print(".");
			}
			System.out.println("");
		}
	}
	
	
}
