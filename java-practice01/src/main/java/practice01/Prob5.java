package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for( int i = 1; i <=100; i++ ) {

			
			//////////
			
			String s = String.valueOf(i);
			
			int len = s.length();
			
			int sum = 0;
			boolean pandan = false;
			
			for(int j = 0; j < len; j++) {
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
					sum++;
					pandan = true;
				}
			}
			
			if (pandan) {
				System.out.print(i + " ");
				
				for(int j = 0; j < sum; j++) {
					System.out.print("짝");
				}
				System.out.println();
				
				sum = 0;
				pandan = false;
			}
			
			////////
			
			
		}
	}
}
