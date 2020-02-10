package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for(int i = 0; i < COUNT_GOODS; i++) {
			String s = scanner.nextLine();
			String[] str = s.split(" ");
			
			goods[i] = new Goods();
			goods[i].setName(str[0]);
			goods[i].setPrice(Integer.parseInt(str[1]));
			goods[i].setCount(Integer.parseInt(str[2]));
		}
		
		for(int i = 0; i < COUNT_GOODS; i++) {
			System.out.printf("%s(가격:%d원)이 %d개 입고 되었습니다.\n", goods[i].getName(), goods[i].getPrice(), goods[i].getCount());
		}
		
		
		scanner.close();
	}
}
