package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {


	public static void main(String[] args) {

		///////////
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");
			
			int count = 1;
			
			Random r = new Random();
			int k = r.nextInt(100) + 1;
			
			while(true) {
				
				System.out.printf("%d>>", count);
				
				int num = scanner.nextInt();
				scanner.nextLine();
				
				count++;
				
				if (k > num) {
					System.out.println("더 높게");
				} else if (k < num) {
					System.out.println("더 낮게");
				} else {
					System.out.println("맞았습니다.");
					break;
				}
			}
			System.out.println("다시하시겠습니까(y/n)>>");
			String answer = scanner.nextLine();
			
			if (answer.equals("n")) break;
			
			count = 0;
		}
		
		//////////
	}
}
