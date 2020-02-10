package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int temp = 0;
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		//
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count - 1; j++) {
				int k = j + 1;
				if (array[j] < array[k]) {
					temp = array[j];
					array[j] = array[k];
					array[k] = temp;
				}
			}
		}
		
		
		
		//

		
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		

	}
}