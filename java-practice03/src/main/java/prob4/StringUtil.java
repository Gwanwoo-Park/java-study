package prob4;

public class StringUtil {
	public static String concatenate(String[] str) {
		int len = str.length;
		String s = "";
		
		for(int i = 0; i < len; i++) {
			s += str[i];
		}
		return s;
	}
}