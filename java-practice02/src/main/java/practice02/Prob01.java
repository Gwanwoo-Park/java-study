package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");

		////////////
		int n = scanner.nextInt();
		
		int sum = n;
		
		if (n / 50000 > 0) {
			System.out.printf("50000원 : %d개\n", n / 50000 );
			sum -= 50000 * (n / 50000);
			n = sum;
		}
		if (n / 10000 > 0) {
			System.out.printf("10000원 : %d개\n", n / 10000 );
			sum -= 10000 * (n / 10000);
			n = sum;
		}
		if (n / 5000 > 0) {
			System.out.printf("5000원 : %d개\n", n / 5000 );
			sum -= 5000 * (n / 5000);
			n = sum;
		}
		if (n / 1000 > 0) {
			System.out.printf("1000원 : %d개\n", n / 1000 );
			sum -= 1000 * (n / 1000);
			n = sum;
		}
		if (n / 500 > 0) {
			System.out.printf("500원 : %d개\n", n / 500 );
			sum -= 500 * (n / 500);
			n = sum;
		}
		if (n / 100 > 0) {
			System.out.printf("100원 : %d개\n", n / 100 );
			sum -= 100 * (n / 100);
			n = sum;
		}
		if (n / 50 > 0) {
			System.out.printf("50원 : %d개\n", n / 50 );
			sum -= 50 * (n / 50);
			n = sum;
		}
		if (n / 10 > 0) {
			System.out.printf("10원 : %d개\n", n / 10 );
			sum -= 10 * (n / 10);
			n = sum;
		}
		if (n / 5 > 0) {
			System.out.printf("5원 : %d개\n", n / 5 );
			sum -= 5 * (n / 5);
			n = sum;
		}
		if (n / 1 > 0) {
			System.out.printf("1원 : %d개\n", n / 1 );
			sum -= 1 * (n / 1);
			n = sum;
		}
		
		
		//////////////
		
		scanner.close();
	}

}
