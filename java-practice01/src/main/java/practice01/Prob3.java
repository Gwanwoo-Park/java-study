package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			///////////
			
			System.out.println("숫자를 입력하세요: ");
			int n = scanner.nextInt();
			scanner.nextLine();
			
			int sum = 0;
			
			if (n % 2 == 1) {
				for(int i = 1; i <= n; i += 2) {
					sum += i;
				}
			} else {
				for(int i = 2; i <= n; i += 2) {
					sum += i;
				}
			}
			
			System.out.println("결과 값 : "+ sum);
			//////////
		}
	}
}
