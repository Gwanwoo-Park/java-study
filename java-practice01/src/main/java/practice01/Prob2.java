package practice01;

public class Prob2 {
	public static void main(String[] args) {
		////////////////////
		
		int start = 1;
		
		for(int i = 1; i < 10; i++) {
			int end = start + 10;
			for(int j = start; j < end; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			start++;
		}
		
		
		//////////////
	}
}
