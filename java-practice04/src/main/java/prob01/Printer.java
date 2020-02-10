package prob01;

public class Printer{
	///// 강사님 코드
	/*
	 * public void println(int val) { System.out.println(val); }
	 * 
	 * public void println(boolean val) { System.out.println(val); }
	 * 
	 * public void println(double val) { System.out.println(val); }
	 * 
	 * public void println(String val) { System.out.println(val); }
	 */
	
	/*
	 * // 제너릭 public <T> void println(T t) { System.out.println(t); }
	 */
	
	//가변 변수
	public int sum(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		return sum;
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
	
	////// 내가 한 거
	/*
	 * public void println(int n) { System.out.println(n); }
	 * 
	 * public void println(boolean bool) { System.out.println(bool); }
	 * 
	 * public void println(double d) { System.out.println(d); }
	 * 
	 * public void println(String s) { System.out.println(s); }
	 * 
	 * public void println(int a, int b, int c, int d, int e, String s, StringBuffer
	 * sb) { System.out.printf("%d, %d, %d, %d, %d, %s, %s", a, b, c, d, e, s, sb);
	 * }
	 */
}
