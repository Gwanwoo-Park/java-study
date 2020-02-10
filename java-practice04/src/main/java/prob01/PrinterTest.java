package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.println( 10 );
		printer.println( true );
		printer.println( 5.7 );
		printer.println( "홍길동" );
		
		System.out.println(printer.sum(0, 1, 2, 3, 4, 5));
		System.out.println(printer.sum(0, 1, 2, 3, 4, 5, 6, 7, 8 ,9));
		System.out.println(printer.sum(0, 1, 2));
		
		printer.println( 1, 2, 3, 4, 5, "Hello", new StringBuffer("20") );
	}

}
