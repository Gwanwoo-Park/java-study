package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");

		///////////////////
		
		String s = scanner.nextLine();
		
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(s.charAt(j));
			}
			System.out.println();
		}
		
		//////////////////
		
		scanner.close();
	}

}
