package principal;

public class Delay {
	public static void delay(int n) {
		try {Thread.sleep(n);} catch (InterruptedException e) {System.out.println(e);}
	}
}
