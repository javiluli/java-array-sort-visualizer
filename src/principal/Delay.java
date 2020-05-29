package principal;

public class Delay {
	public static int n = 1;

	public static void delay() {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void delay(int m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
