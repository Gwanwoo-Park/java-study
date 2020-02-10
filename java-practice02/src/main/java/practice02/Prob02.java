package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];

		System.out.println("5개의 숫자를 입력하세요.");

		//////////////////
		
		
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt();
			scanner.nextLine();
			
			sum += intArray[i];
		}
		System.out.printf("평균은 %.1f 입니다.",  (double)sum / (double)5);
		
		///////////////
	}

}
