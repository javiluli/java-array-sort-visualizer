package Adicionales;

public class Memoria {
	private static int max, total, libre, usada;
	private final static int MEGABYTES = (int) Math.pow(1024, 2);
	static Runtime runtime = Runtime.getRuntime();

	public Memoria() {
		setMax(0);
		setTotal(0);
		setLibre(0);
		setUsada(0);
	}

	public static int max() {
		max = (int) (runtime.maxMemory() / MEGABYTES);
		return max;
	}

	public static int total() {
		total = (int) (runtime.totalMemory() / MEGABYTES);
		return total;
	}

	public static int libre() {
		libre = (int) (runtime.freeMemory() / MEGABYTES);
		return libre;
	}

	public static int usada() {
		usada = (int) ((runtime.totalMemory() - runtime.freeMemory()) / MEGABYTES);
		return usada;
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		Memoria.max = max;
	}

	public static int getLibre() {
		return libre;
	}

	public static void setLibre(int libre) {
		Memoria.libre = libre;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Memoria.total = total;
	}

	public static int getUsada() {
		return usada;
	}

	public static void setUsada(int usada) {
		Memoria.usada = usada;
	}

}
